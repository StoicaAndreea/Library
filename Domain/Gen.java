package Domain;

import java.util.ArrayList;
import java.util.Objects;

public class Gen {
    private String nume;
    private ArrayList<String>descriere;

    public Gen(){       //constructor implicit
        nume="";
        descriere=new ArrayList<>();
    }

    public Gen(String nume, ArrayList<String> descriere){       //constructor cu parametri
        this.nume=nume;
        this.descriere=new ArrayList<>(descriere);
    }


    public Gen(Gen g){      //construcotr de copiere
        nume=g.getNume();
        descriere=new ArrayList<>(g.getDescriere());
    }

    public void setGen(Gen g){
        nume=g.getNume();
        descriere=new ArrayList<>(g.getDescriere());
    }
    public String getNume() {       //returneaza numele
        return nume;
    }

    public ArrayList<String> getDescriere() {       //returneaza descrierea
        return descriere;
    }

    public String getCuvantDescriere(int i){        //returneaza un cuvant din descriere
        return descriere.get(i);
    }

    public void setNume(String nume) {      //modifica numele genului
        this.nume = nume;
    }

    public void setDescriere(ArrayList<String> descriere) {     //modifica  o descriere
        this.descriere = descriere;
    }

    public void setCuvantDescriere(int i,String s){     //modifica un cuvant din descriere
        this.descriere.set(i,s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gen)) return false;
        Gen gen = (Gen) o;
        return Objects.equals(getNume(), gen.getNume()) &&
                Objects.equals(getDescriere(), gen.getDescriere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getDescriere());
    }

    public boolean apartineGen(String cuvant){
        for(String el:descriere){
            if(Objects.equals(el,cuvant)) return true;
        }
        return false;
    }
}
