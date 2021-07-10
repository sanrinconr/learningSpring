package com.linkTracker.service;

import com.linkTracker.dto.request.LinkCreateRequestDTO;
import com.linkTracker.dto.response.LinkCreatedResponseDTO;
import com.linkTracker.dto.response.LinkMetricsResponseDTO;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.model.LinkModel;
import com.linkTracker.repository.ILinkRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    final ILinkRepository linkRepository;
    final DozerBeanMapper mapper;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
        this.mapper = new DozerBeanMapper();
    }

    public LinkCreatedResponseDTO createURL(LinkCreateRequestDTO data) throws LinkAlreadyExistsException {
        LinkModel linkModel = new LinkModel(data.getName(), data.getUrl(), data.getPassword());
        linkRepository.insertLink(linkModel);
        return mapper.map(linkModel, LinkCreatedResponseDTO.class);
    }
    @Override
    public String getURLById(String id, String password) throws LinkNotExistException {
        return linkRepository.findLinkById(id,password);
    }

    @Override
    public LinkMetricsResponseDTO getMetricsLink(String linkId) throws LinkNotExistException {
         LinkModel model = linkRepository.findModelById(linkId);
         LinkMetricsResponseDTO out = mapper.map(model, LinkMetricsResponseDTO.class);
         if(out.getPassword() != null) out.setPassword("****");
         return out ;
    }
}
