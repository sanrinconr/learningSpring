package com.prendas.pertenencias;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendasPersona1 = new ArrayList<>();
        List<Prenda> prendasPersona2 = new ArrayList<>();

        prendasPersona1.add(new Prenda("a","1111"));
        prendasPersona1.add(new Prenda("bbb","222"));

        prendasPersona2.add(new Prenda("a","1111"));
        prendasPersona2.add(new Prenda("cc","3423"));

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.addPrendasGuardaRopa(prendasPersona1);
        guardaRopa.addPrendasGuardaRopa(prendasPersona2);

        guardaRopa.devolverPrendas(1);
        guardaRopa.printPrendasGuardaRopa();
    }
}
