package com.company;

import Repository.CarteRepository;
import Repository.GenRepository;
import Service.CartiService;
import UI.UI;
import javax.swing.*;

/*
3. Căutarea cărţilor într-o bibliotecă
Să se proiecteze şi creeze soft care exploatează o BD (sau ansamblu de fişiere/tabele în memorie) cu
informaţii despre cărţile unei biblioteci (în final acesta va conţine date reale pentru cel puţin 30 de cărţi) şî va
permite căutarea în bibliotecă după titlu, autori, domenii,edituri.
Pentru o Carte se va reţine:
- titlul cărţii;
- numele autorilor; (se poate face şi clasa Autor)
- anul apariţiei;
- editura publicării; (se poate face şi clasa Editura)
- 5 cuvinte cheie, care atestă apartenenţa la anumite domenii
- cota cărţii (8caractere);
Programul va face următoarele acţiuni:
- operaţii CRUD (Create/Read/Update/Delete)
Programul va putea afişa:
- un tabel cu toate cărţile ale unui autor dat;
- un tabel cu toate cărţile apărute la o anumită editură dată;
- un tabel cu toate cărţile apărute după un anumit domeniu dat;
- căutari de cărţi după: titlu/autor/domeniu/editura;
- alte rapoarte
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        CarteRepository cr=new CarteRepository();
        GenRepository gr=new GenRepository();
        CartiService s=new CartiService(cr,gr);
        UI ui=new UI(s);
        ui.Main();
    }
}
