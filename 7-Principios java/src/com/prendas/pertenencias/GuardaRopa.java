package com.prendas.pertenencias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private int siguienteLibre;
    private HashMap<Integer, List<Prenda>> guardaRopa;


    public GuardaRopa() {
        this.siguienteLibre = 0;
        this.guardaRopa = new HashMap<>();
    }


    public void printPrendasGuardaRopa(int id){
        System.out.println(this.toString(id));
    }

    private String toString(int id) {
        String out = "GuardRopa{" + '\n';
            out += "    ListaPrendas{ " + '\n'+
                    "       id:"+ id + '\n' +
                    "       elementos{" + '\n' +
                    "           "+guardaRopa.get(id).toString()+ '\n'+
                    "       }" + '\n'+
                    "   }" + '\n';
        out += "}";
        return out;
    }

    public void printPrendasGuardaRopa(){
        System.out.println(this.toString());
    }

    public void addPrendasGuardaRopa(List<Prenda> prendas) {
        try{
            if(prendas.size() == 0) throw new Exception("La lista de prendas a guardar no tiene prendas");
            guardaRopa.put(siguienteLibre, prendas );
            siguienteLibre++;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Prenda> devolverPrendas(int id){
        List<Prenda> out = guardaRopa.get(id);
        guardaRopa.put(id, new ArrayList<>());
        return out;
    }

    @Override
    public String toString() {
        String out = "GuardRopa{" + '\n';
        for (int i = 0; i < siguienteLibre; i++) {
            if(guardaRopa.get(i).size() == 0){
                out += "    ListaPrendas{ " + '\n'+
                        "       id:"+ i + '\n' +
                        "       elementos{" + '\n' +
                        "           "+ "Vacio" + '\n'+
                        "       }" + '\n'+
                        "   }" + '\n';
            }else{
                out += "    ListaPrendas{ " + '\n'+
                        "       id:"+ i + '\n' +
                        "       elementos{" + '\n' +
                        "           "+  guardaRopa.get(i).toString()+ '\n'+
                        "       }" + '\n'+
                        "   }" + '\n';
            }

        }
        out += "}";
        return out;
    }

}
