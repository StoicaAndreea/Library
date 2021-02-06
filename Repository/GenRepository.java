package Repository;

import Domain.Carte;
import Domain.Gen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class GenRepository {
    private ArrayList<Gen> genuri;

    public GenRepository(){      //constructor implicit
        genuri=new ArrayList<>();
    }

    public GenRepository(ArrayList<Gen>genuri){      //constructor cu parametru
        this.genuri=new ArrayList<>(genuri);
    }

    public GenRepository(GenRepository repo){       //constructor de copiere
        this.genuri=new ArrayList<Gen>(repo.getGenuri());
    }

    public ArrayList<Gen> getGenuri(){     //returneaza lista de genuri
        return genuri;
    }

    public Gen getGen(int i){       //returneaza o carte in functie de index
        return genuri.get(i);
    }

    public int getLungime(){        //cate genuri avem in biblioteca
        return genuri.size();
    }

    public void setGenuri(ArrayList<Gen> c){       //modifica lista de cari
        genuri=c;
    }

    public void setGen(int i,Gen c){        //modifica o carte
        genuri.set(i,c);
    }

    public void add(Gen c){       //adauga o carte in lista
        genuri.add(c);
    }

    public void delete(int i){      //sterge o carte
        genuri.remove(i);
    }

    public void update(int i, Gen c){     //modifica o carte
        setGen(i,c);
    }

    public void clearEl(){      //sterge tot
        genuri.clear();
    }

    public int contains(Gen c){
        for (int i=0;i<genuri.size();i++)
            if (getGen(i).equals(c)) {
                return i;
            }
        return -1;
    }

    public void citireDinFisier() {     //functie care realizeaza citirea din fisier
        this.clearEl();
        try {
            BufferedReader fisIn = new BufferedReader(new FileReader("C:\\Users\\Andreea\\IdeaProjects\\Biblioteca\\src\\GenuriInBiblioteca"));
            String s; //= fisIn.readLine();

            for(int i = 0; (s = fisIn.readLine()) != null; ++i) {
                String[] felii = s.split(" ");
                String nume = felii[0];
                String desc=felii[1];
                ArrayList<String>descriere=new ArrayList<String>(Arrays.asList(desc.split(",")));
                Gen c = new Gen(nume,descriere);
                this.add(c);
            }
            fisIn.close();
        }
        catch (Exception var9) {
            System.out.println(var9.getMessage());
            var9.printStackTrace();
        }
    }
    
    public Gen apartineGen(Carte c){
        Gen genBun=new Gen();
        int contor;
        int max=0;
        for(Gen gen:genuri){
            contor=0;
            for(String elem : c.getDescriere()){
                if (gen.apartineGen(elem)){
                    contor++;
                }
            }
            if (contor>max){
                max=contor;
                genBun.setGen(gen);
            }
        }
        return genBun;
    }
}

