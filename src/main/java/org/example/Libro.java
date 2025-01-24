package org.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Libri")
public class Libro extends Elemento_Catalogo {
    private String autore;
    private String genere;

     public Libro(Integer id, Integer isbn, String titolo, int annoPubblicazione,
                   Integer numeroPagine, String autore, String genere) {
        super (id, isbn,titolo,annoPubblicazione,numeroPagine);
        this.autore = autore;
        this.genere= genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}