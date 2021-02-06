package View;

public class CapTabel {
    public CapTabel() {     //constructor implicit
    }

    public static void capTabel() {        //capul de tabel pentru tabelul care afiseaza procentul de lungime
        String sir = "| id    | Titlu                          | Autor                | AnAparitie    | Editura        | Cota         | Descriere                                               |";
        String linii = "===========================================================================================================================================================================";
        System.out.println(linii);
        System.out.println(sir);
        System.out.println(linii);
    }
}
