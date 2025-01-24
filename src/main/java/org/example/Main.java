package org.example;

import org.example.Dao.ElementoCatalogoDAO;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   Scanner scanner = new Scanner(System.in);
   ElementoCatalogoDAO elementoCatalogoDAO = new ElementoCatalogoDAO();

   while(true){
        System.out.println("scegli un'operazione");
        System.out.println("0: aggiungi un libro ");
        System.out.println("1: aggiungi una rivista");
        System.out.println("2: rimuovi un elemento dal catalogo con ISBN ");
        System.out.println("3: ricerca per ISBN");
        System.out.println("4: ricerca per anno");
        System.out.println("5: ricerca per autore");
        System.out.println("6: ricerca per titolo");
        System.out.println("7: ricerca libri attualmente in prestito");
        System.out.println("8: ricerca i prestiti scaduti");
        System.out.println("9: esci");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta){
            case 0:
                int lastid = elementoCatalogoDAO.trovaUltimoIdLibro();
                lastid= lastid +1;
                //elementodao.cercaultimoid
                System.out.print("ISBN del libro da aggiungere: ");
                int ISBN = scanner.nextInt();
                System.out.print("titolo del libro da aggiungere: ");
                String titolo = scanner.nextLine();
                System.out.print("anno del libro da aggiungere:  (yyyy)");
                int anno = scanner.nextInt();
                System.out.print("numero di pagine del libro da aggiungere:  (yyyy)");
                int numero_pagine = scanner.nextInt();
                System.out.print("autore del libro da aggiungere:  (yyyy)");
                String autore  = scanner.nextLine();
                System.out.print("genere del libro da aggiungere:  (yyyy)");
                String genere  = scanner.nextLine();
                Libro libro = new Libro(lastid, ISBN, titolo,anno,numero_pagine,autore,genere);
                elementoCatalogoDAO.salva(libro);
            case 1:
                int lastidR = elementoCatalogoDAO.trovaUltimoIdLibro();
                lastidR= lastidR +1;
                //elementodao.cercaultimoid
                System.out.print("ISBN del libro da aggiungere: ");
                int ISBNR = scanner.nextInt();
                System.out.print("titolo del libro da aggiungere: ");
                String titoloR = scanner.nextLine();
                System.out.print("anno del libro da aggiungere:  (yyyy)");
                int annoR = scanner.nextInt();
                System.out.print("numero di pagine del libro da aggiungere:  (yyyy)");
                int numero_pagineR = scanner.nextInt();
                System.out.print("periodicità");
                String periodicita  = scanner.nextLine();

                Rivista rivista = new Rivista(lastidR,ISBNR,titoloR,annoR,numero_pagineR,periodicita);
                elementoCatalogoDAO.salvaR(rivista);

            case 2:
                System.out.println("inserisci isbn da eliminare");
                int isbnDaEliminare = scanner.nextInt();
               if(elementoCatalogoDAO.eliminabyISBN(isbnDaEliminare)){
                   System.out.println(("elemento eliminato"));




        }
            case 3:
                System.out.println("inserisci ISBN per la ricerca");
                int isbnDacercare = scanner.nextInt();
                ElementoCatalogoDAO risultato = elementoCatalogoDAO.ricercaperISBN(isbnDacercare);
            case 4:
                System.out.println("ricerca per anno di pubblicazione");
                int annodacercare = scanner.nextInt();
                ElementoCatalogoDAO risultatoanno = elementoCatalogoDAO.ricercaperAnno(annodacercare);
    }
}
}