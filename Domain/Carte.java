package Domain;

import java.util.ArrayList;
import java.util.Objects;

public class Carte {
    private int id;
    private String titlu;
    private Autor autor;
    private int anAparitie;
    private String editura;
    private ArrayList<String> descriere;        //5 cuvinte
    private String cota;        // 8caractere

    public Carte(){     //constructor implicit
        id=0;
        titlu = "";
        autor = new Autor();
        anAparitie = 0;
        editura = "";
        descriere = new ArrayList<String>();
        cota = "";
    }

    public Carte(int id,String titlu,Autor autor,int anAparitie,String editura,ArrayList<String> descriere,String cota){      //constructor cu parametri
        this.id=id;
        this.titlu=titlu;
        this.autor=autor;
        this.anAparitie=anAparitie;
        this.editura=editura;
        this.descriere=new ArrayList<>(descriere);
        this.cota=cota;
    }

    public Carte(Carte c){      //constructor de copiere
        this.id=c.getId();
        titlu=c.getTitlu();
        autor=c.getAutor();
        anAparitie=c.getAnAparitie();
        editura=c.getEditura();
        descriere=new ArrayList<String>(c.getDescriere());
        cota=c.getCota();
    }

    public int getId() {        //returneaza id
        return id;
    }

    public String getTitlu(){       //returneaza titlul
        return titlu;
    }


    public Autor getAutor(){       //returneaza autorul
        return autor;
    }

    public int getAnAparitie(){     //reutrneaza anul aparitiei
        return anAparitie;
    }

    public String getEditura(){     //returneaza editura
        return editura;
    }

    public ArrayList<String> getDescriere(){        //returneaza lista de cuvinte care formeaza descrierea
        return descriere;
    }

    public String getElementDescriere(int i){       //returneaza un element al descrierii
        return descriere.get(i);
    }

    public String getCota(){        //returneaza cota
        return cota;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitlu(String titlu){     //modifica titlul
        this.titlu=titlu;
    }

    public void setAutor(Autor autor) {        //modifica autorul
        this.autor = autor;
    }

    public void setAnAparitie(int anAparitie) {     //modifica anul aparitiei
        this.anAparitie = anAparitie;
    }

    public void setDescriere(ArrayList<String> descriere) {     //modifica descrierea
        this.descriere = descriere;
    }

    public void setElementDescriere(String el,int i){       //modifica un element al descrierii
        descriere.set(i,el);
    }

    public void setEditura(String editura) {        //modifica editura
        this.editura = editura;
    }

    public void setCota(String cota) {      //modifica cota
        this.cota = cota;
    }

    @Override
    public boolean equals(Object o) {       //verifica daca doua carti sunt la fel
        if (this == o) return true;
        if (!(o instanceof Carte)) return false;
        Carte carte = (Carte) o;
        return getAnAparitie() == carte.getAnAparitie() &&
                Objects.equals(getTitlu(), carte.getTitlu()) &&
                Objects.equals(getAutor(), carte.getAutor()) &&
                Objects.equals(getEditura(), carte.getEditura()) &&
                Objects.equals(getDescriere(), carte.getDescriere()) &&
                Objects.equals(getCota(), carte.getCota());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitlu(), getAutor(), getAnAparitie(), getEditura(), getDescriere(), getCota());
    }

    @Override
    public String toString() {      //transforma in string
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", anAparitie=" + anAparitie +
                ", editura='" + editura + '\'' +
                ", descriere=" + descriere +
                ", cota='" + cota + '\'' +
                '}';
    }

    public String descriereString(){       //string cu  descrierile pentru afisare
        StringBuilder s= new StringBuilder();
        for (String value : descriere) {
            s.append(" ");
            s.append(value);
        }
        return s.toString();
    }
}
