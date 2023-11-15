package mx.markobe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.markobe.domain.Domicilio;

public class DomicilioDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public DomicilioDAO(){
        emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        em = emf.createEntityManager();
    }
    
    public List<Domicilio> listarDomicilios(){
        String hql = "Select d FROM Domicilio d";
        Query query = em.createQuery(hql);
        List<Domicilio> domicilios = query.getResultList();
        
        return domicilios;
    }
    
}
