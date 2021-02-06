package Service;

import Domain.Carte;
import Repository.CarteRepository;
import Repository.GenRepository;

import java.util.ArrayList;
import java.util.Objects;

public class CartiService {
    private CarteRepository repo;
    private GenRepository genuri;

    public CartiService(){      //constructor implicit
        repo=new CarteRepository();
        genuri=new GenRepository();
    }

    public CartiService(CarteRepository r, GenRepository g){     //constructor cu parametru
        repo=r;
        genuri=g;
        r.citireDinFisier();
        g.citireDinFisier();
    }

    public int add(Carte c){        //adauga o carte in biblioteca
        if(repo.contains(c) != -1) return -1;
        repo.add(c);
        return 0;
    }

    public int update(int i,Carte uc){        //modifica o carte din biblioteca
        repo.setCarte(i,uc);
        return 0;
    }

    public int delete(int i){     //sterge o carte din biblioteca
        int pos=-1;
        for(int index=0;index<repo.getLungime();index++){
            if (i==repo.getCarte(index).getId()){
                pos=index;
                break;
            }
        }
        if (pos!=-1){
            repo.delete(pos);
            return 0;
        }
        return -1;
    }

    public ArrayList<Carte> tot(){      //returneaza lista de carti
        return repo.getCarti();
    }

    public ArrayList<Carte> cartiInFunctieDeTitilu(String titlu){       //returneaza o lista cu carti care au un titlu
        ArrayList<Carte> lista=new ArrayList<>();
        for(Carte el: repo.getCarti()){
            if (Objects.equals(el.getTitlu(),titlu)){
                lista.add(el);
            }
        }
        return lista;
    }

    public ArrayList<Carte> cartiInFunctieDeAutor(String autor){       //returneaza o lista cu carti care au un autor
        ArrayList<Carte> lista=new ArrayList<>();
        for(Carte el: repo.getCarti()){
            if (Objects.equals(el.getAutor().getNume(),autor)){
                lista.add(el);
            }
        }
        return lista;
    }

    public ArrayList<Carte> cartiInFunctieDeEditura(String editura){       //returneaza o lista cu carti care au o editura
        ArrayList<Carte> lista=new ArrayList<>();
        for(Carte el: repo.getCarti()){
            if (Objects.equals(el.getEditura(),editura)){
                lista.add(el);
            }
        }
        return lista;
    }

    public ArrayList<Carte> cartiInFunctieDeGen(String gen){       //returneaza o lista cu carti care au un gen
        ArrayList<Carte> lista=new ArrayList<>();
        for(Carte el: repo.getCarti()) {
            if (Objects.equals(genuri.apartineGen(el).getNume(), gen)) {
                lista.add(el);
            }
        }
        return lista;
    }
}
