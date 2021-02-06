package Repository;

import Domain.Autor;
import Domain.Carte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CarteRepository{
    private ArrayList<Carte> carti;

    public CarteRepository(){      //constructor implicit
        carti=new ArrayList<>();
    }

    public CarteRepository(ArrayList<Carte>carti){      //constructor cu parametru
        this.carti=new ArrayList<>(carti);
    }

    public CarteRepository(CarteRepository repo){       //constructor de copiere
        this.carti=new ArrayList<Carte>(repo.getCarti());
    }

    public ArrayList<Carte> getCarti(){     //returneaza lista de carti
        return carti;
    }

    public Carte getCarte(int i){       //returneaza o carte in functie de index
        return carti.get(i);
    }

    public int getLungime(){        //cate carti avem in biblioteca
        return carti.size();
    }

    public void setCarti(ArrayList<Carte> c){       //modifica lista de cari
        carti=c;
    }

    public void setCarte(int i,Carte c){        //modifica o carte
        for(int index=0;index<carti.size();index++){
            if (i==carti.get(index).getId()) {
                carti.set(index, c);
                break;
            }
        }
    }

    public void add(Carte c){       //adauga o carte in lista
        carti.add(c);
    }

    public void delete(int i){      //sterge o carte
        carti.remove(i);
    }

    public void update(int i, Carte c){     //modifica o carte
        setCarte(i,c);
    }

    public void clearEl(){      //sterge tot
        carti.clear();
    }

    public int contains(Carte c){
        for (int i=0;i<carti.size();i++)
            if (getCarte(i).equals(c)) {
                return i;
            }
        return -1;
    }

    public void citireDinFisier() {     //functie care realizeaza citirea din fisier
        this.clearEl();
        try {
            BufferedReader fisIn = new BufferedReader(new FileReader("C:\\Users\\Andreea\\IdeaProjects\\Biblioteca\\src\\CartiInBiblioteca"));
            String s; //= fisIn.readLine();

            for(int i = 0; (s = fisIn.readLine()) != null; ++i) {
                String[] felii = s.split(" ");
                int id=Integer.parseInt(felii[0]);
                String titlu = felii[1];
                ArrayList<String> bucati_autor= new ArrayList<String>(Arrays.asList(felii[2].split(",")));
                int anAparitie=(Integer.parseInt(felii[3]));
                String editura=felii[4];
                String desc=felii[5];
                String cota=felii[6];
                ArrayList<String>descriere=new ArrayList<String>(Arrays.asList(desc.split(",")));
                if (bucati_autor.size()==1){
                    Autor autor=new Autor(bucati_autor.get(0));
                    Carte c = new Carte(id,titlu,autor,anAparitie,editura,descriere,cota);
                    this.add(c);
                }
                else{
                    Autor autor=new Autor(bucati_autor.get(0), bucati_autor.get(1), bucati_autor.get(2), bucati_autor.get(3) );
                    Carte c = new Carte(id,titlu,autor,anAparitie,editura,descriere,cota);
                    this.add(c);
                }
            }
            fisIn.close();
        }
        catch (Exception var9) {
            System.out.println(var9.getMessage());
            var9.printStackTrace();
        }
    }
}
