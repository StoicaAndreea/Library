package View;

import Domain.Carte;

import java.util.ArrayList;

public class Rapoarte {
    public Rapoarte(){      //constructor implicit
    }


    public static void afis(ArrayList<Carte> r) {      //functia care afiseaza tabelul ordonat in functie de nume
        CapTabel.capTabel();
        for(int i = 0; i < r.size(); ++i) {
            System.out.format("| %5s | %-30s | %-20s | %13s | %-14s | %12s | %-55s |\n",r.get(i).getId(), r.get(i).getTitlu(), r.get(i).getAutor().getNume(),r.get(i).getAnAparitie(),r.get(i).getEditura(),r.get(i).getCota(),r.get(i).descriereString());
        }
        String linii = "===========================================================================================================================================================================";
        System.out.println(linii);
    }

}
