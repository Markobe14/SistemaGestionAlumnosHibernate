package mx.markobe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.markobe.domain.Contacto;

public class ContactoDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ContactoDAO(){
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }
    
    public List<Contacto> listarContactos(){
        String hql = "Select c FROM Contacto d";
        Query query = em.createQuery(hql);
        List<Contacto> contactos = query.getResultList();
        
        return contactos;
    }
}
