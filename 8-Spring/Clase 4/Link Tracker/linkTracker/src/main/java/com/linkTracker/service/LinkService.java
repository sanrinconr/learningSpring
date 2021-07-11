package com.linkTracker.service;

import com.linkTracker.dto.request.LinkCreateRequestDTO;
import com.linkTracker.dto.response.*;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkInvalidException;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.model.LinkModel;
import com.linkTracker.repository.ILinkRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class LinkService implements ILinkService {
    final ILinkRepository linkRepository;
    final DozerBeanMapper mapper;

    @SuppressWarnings("unused")
    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
        this.mapper = new DozerBeanMapper();
    }

    public LinkCreatedResponseDTO createURL(LinkCreateRequestDTO data) throws LinkAlreadyExistsException {
        LinkModel linkModel = new LinkModel(data.getName(), data.getUrl(), data.getPassword());
        return mapper.map(linkRepository.insertLink(linkModel), LinkCreatedResponseDTO.class);
    }
    @Override
    public LinkRedirectResponseDTO getURLToRedirect(String id, String password) throws LinkNotExistException, LinkInvalidException {
        LinkModel link = linkRepository.findModelByIdUSER(id,password);
        if(link.getStatus().equals("INVALID")) throw new LinkInvalidException(id);
        return mapper.map(linkRepository.incrementCounterURL(link.getLinkID()), LinkRedirectResponseDTO.class);
    }

    @Override
    public LinkMetricsResponseDTO getMetricsLink(String linkId) throws LinkNotExistException {
         LinkModel model = linkRepository.findModelByIdADMIN(linkId);
         LinkMetricsResponseDTO out = mapper.map(model, LinkMetricsResponseDTO.class);
         //Avoid to show the plain password when the metric is requested
         if(out.getPassword() != null) out.setPassword("****");
         return out ;
    }

    @Override
    public LinkInvalidatedResponseDTO invalidateURL(String linkID) throws LinkNotExistException {
        LinkInvalidatedResponseDTO out;
        LinkModel model = linkRepository.findModelByIdADMIN(linkID);
        model = linkRepository.setLinkAsInvalid(model);
        out = mapper.map(model, LinkInvalidatedResponseDTO.class);
        return  out;
    }

    private LinkIncrementedCounterResponseDTO incrementCounterTimesClicked(String id) throws LinkNotExistException {
        LinkModel link = linkRepository.findModelByIdADMIN(id);
        link.incrementTimesClicked();
        linkRepository.modifyLink(link);
        return mapper.map(link, LinkIncrementedCounterResponseDTO.class);
    }
}
