package org.example.Dao;

import org.example.Libro;
import org.example.Rivista;

import javax.persistence.*;
import javax.persistence.Persistence;

public class ElementoCatalogoDAO<T> {
    private EntityManager em= emf.createEntityManager();
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");

    protected Class<T> clazz;

    public ElementoCatalogoDAO(Class<T> clazz){
        this.clazz = clazz;
    }
public  int trovaUltimoIdLibro(){
        Query query = em.createQuery("SELECT MAX(e.id) FROM libro e");
        Integer result= (Integer) query.getSingleResult();
        return result;
}
 public void salva(Libro libro){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
 }
    public void salvaR(Rivista rivista ){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(rivista);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
    public boolean eliminabyISBN(int isbndaeliminare){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE * FROM elemento_catalogo e where e.ISBN = :isbn");
            query.setParameter("isbn", isbndaeliminare);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception e){

        }
        return false;
    }

    public ElementoCatalogoDAO ricercaperISBN(int isbnDacercare){
        return em.find(ElementoCatalogoDAO.class, isbnDacercare);
    }
    public ElementoCatalogoDAO ricercaperAnno (int annoDaCercare){
        return em.find(ElementoCatalogoDAO.class, annoDaCercare);
    }
    public ElementoCatalogoDAO ricercaperTitolo(int titoloDaCercare){
        return em.find(ElementoCatalogoDAO.class, titoloDaCercare);
    }
}