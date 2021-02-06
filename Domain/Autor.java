package Domain;

import java.util.Objects;

public class Autor {
    private String nume;
    private String dataNastere;
    private String adresa;
    private String numarTelefon;

    public Autor(){     //constructor implicit
         nume="";
         dataNastere="";
         adresa="";
         numarTelefon="";
    }
    public Autor(String nume){      //constructor cu un parametru
        this.nume=nume;
        dataNastere="privat";
        adresa="privat";
        numarTelefon="privat";
    }

    public Autor(String nume, String dataNastere, String adresa, String numarTelefon){      //constructor cu parametri
        this.nume=nume;
        this.dataNastere=dataNastere;
        this.adresa=adresa;
        this.numarTelefon=numarTelefon;
    }
    public String getNume(){        //returneaza numele
        return nume;
    }

    public String getDataNastere() {        //returneaza data nasterii
        return dataNastere;
    }

    public String getAdresa() {     //returneaza adresa
        return adresa;
    }

    public String getNumarTelefon() {  //returneaza numarul de telefon
        return numarTelefon;
    }

    public void setNume(String nume) {      //modifica numele
        this.nume = nume;
    }

    public void setAdresa(String adresa) {      //modifica adresa
        this.adresa = adresa;
    }

    public void setDataNastere(String dataNastere) {        //modifica data nasterii
        this.dataNastere = dataNastere;
    }

    public void setNumarTelefon(String numarTelefon) {      //modifica numarul de telefon
        this.numarTelefon = numarTelefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(getNume(), autor.getNume()) &&
                Objects.equals(getDataNastere(), autor.getDataNastere()) &&
                Objects.equals(getAdresa(), autor.getAdresa()) &&
                Objects.equals(getNumarTelefon(), autor.getNumarTelefon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getDataNastere(), getAdresa(), getNumarTelefon());
    }
}
