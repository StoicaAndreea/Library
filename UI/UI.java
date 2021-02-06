package UI;
import Domain.Autor;
import Domain.Carte;
import Repository.CarteRepository;
import Service.CartiService;
import View.Rapoarte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    private CartiService serv;
    public UI(CartiService s){serv=s;}       //constructor implicit

    public static int printMenu(){      //function that prints the menu and receives the option
        System.out.println("\n MENU:");
        System.out.println("    1) Toate cartile");
        System.out.println("    2) Carti in functie de titlu");
        System.out.println("    3) Carti in functie de autor");
        System.out.println("    4) Carti in functie de editura");
        System.out.println("    5) Carti in functie de gen");
        System.out.println("    6) Adauga mai multe carti, separate prin ';'");
        System.out.println("    7) Modifica o carte");
        System.out.println("    8) Sterge o carte");
        System.out.println("    0) Exit");
        System.out.print("Optiunea ta:");
        Scanner s=new Scanner(System.in);
        int option;
        try{option=s.nextInt();
            return option;}
        catch(Exception var) {
            System.out.print("Wrong! give integer");
            return printMenu();}
    }

    public int citireInt(){     //reads an integer
        System.out.print("Da un index");
        Scanner s=new Scanner(System.in);
        int option;
        try{option=s.nextInt();
            return option;}
        catch(Exception var) {
            System.out.print("Wrong! give integer");
            return citireInt();
        }
    }
    public Carte citireCarte(){     //reads a book
        try
        {System.out.print("    Da o carte:");
            String input;
            Scanner s=new Scanner(System.in);
            input=s.nextLine();
            String[] list= (input.split(" "));
            int id=(Integer.parseInt(list[0]));
            int str=Integer.parseInt(list[3]);
            ArrayList<String> arr=new ArrayList<String>(Arrays.asList(list[5].split(",")));
            ArrayList<String> bucati_autor= new ArrayList<String>(Arrays.asList(list[2].split(",")));
            if (bucati_autor.size()==1){
                Autor autor=new Autor(bucati_autor.get(0));
                return new Carte(id,list[1],autor,str,list[4],arr,list[6]);
            }
            else {
                Autor autor = new Autor(bucati_autor.get(0), bucati_autor.get(1), bucati_autor.get(2), bucati_autor.get(3));
                return new Carte(id,list[1], autor, str, list[4], arr, list[6]);
            }
        }
        catch(Exception var){System.out.println("Aualeuuu, eroareee, nu ai citit bine");
            return citireCarte();
        }
    }

    public ArrayList<Carte> citireCarti(){      //reads multiplw books
        ArrayList<Carte>carti=new ArrayList<Carte>();
        try
        {System.out.print("    Da cartile separate prin ';' (spatiu intre cuv din descrieri) :");
            String input;
            Scanner s=new Scanner(System.in);
            input=s.nextLine();
            String[] l=input.split(";");
            for (String el:l){
                String[] list= (el.split(" "));
                int id=(Integer.parseInt(list[0]));
                int str=Integer.parseInt(list[3]);
                ArrayList<String> arr=new ArrayList<String>(Arrays.asList(list[5].split(",")));
                ArrayList<String> bucati_autor= new ArrayList<String>(Arrays.asList(list[2].split(",")));
                if (bucati_autor.size()==1){
                    Autor autor=new Autor(bucati_autor.get(0));
                    carti.add(new Carte(id,list[1],autor,str,list[4],arr,list[6]));
                }
                else {
                    Autor autor = new Autor(bucati_autor.get(0), bucati_autor.get(1), bucati_autor.get(2), bucati_autor.get(3));
                    carti.add(new Carte(id,list[1],autor,str,list[4],arr,list[6]));
                }
            }
            return carti;
        }
        catch(Exception var){System.out.println("Aualeuuu, eroareee, nu ai citit bine un rau");
            return citireCarti();
        }
    }

    public void Main(){     //control
        int opt=printMenu();
        while(opt!=0){
            switch(opt){
                case 1:{
                    Rapoarte.afis(serv.tot());
                    break;
                }
                case 2: {
                    System.out.print("Da un titlu: ");
                    Scanner s=new Scanner(System.in);
                    String input=s.nextLine();
                    Rapoarte.afis(serv.cartiInFunctieDeTitilu(input));
                    break;
                }
                case 3: {
                    System.out.print("Da un autor: ");
                    Scanner s=new Scanner(System.in);
                    String input=s.nextLine();
                    Rapoarte.afis(serv.cartiInFunctieDeAutor(input));
                    break;
                }
                case 4: {
                    System.out.print("Da o editura: ");
                    Scanner s=new Scanner(System.in);
                    String input=s.nextLine();
                    Rapoarte.afis(serv.cartiInFunctieDeEditura(input));
                    break;
                }
                case 5: {
                    System.out.print("Da un gen: ");
                    Scanner s=new Scanner(System.in);
                    String input=s.nextLine();
                    Rapoarte.afis(serv.cartiInFunctieDeGen(input));
                    break;
                }
                case 6: {
                    ArrayList<Carte> carti=new ArrayList<Carte>(citireCarti());
                    for (Carte c:carti) {
                        if (serv.add(c)==-1) {
                            System.out.println("nu am putut citi " + c.toString());
                            break;
                        }
                    }
                    break;
                }
                case 7: {

                    int rasp= serv.update(citireInt(),citireCarte());
                    if(rasp==-1) System.out.println("Nu s-a putut realiza modificarea");
                    else System.out.println("Am modificat");
                    break;
                }
                case 8:{
                    int rasp= serv.delete(citireInt());
                    if(rasp==-1) System.out.println("Nu s-a putut sterge");
                    else System.out.println("Am sters");
                    break;
                }
                default: {System.out.println("wrong option");}
            }
            opt=printMenu();
        }
        System.out.println("bye...");

    }
}

