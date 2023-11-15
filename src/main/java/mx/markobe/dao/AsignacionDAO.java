package mx.markobe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.markobe.domain.Asignacion;
import mx.markobe.domain.Domicilio;

public class AsignacionDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public AsignacionDAO(){
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }
    
    public List<Asignacion> listarAsignaciones(){
        String hql = "Select a FROM Asignacion a";
        Query query = em.createQuery(hql);
        List<Asignacion> asignaciones = query.getResultList();
        
        return asignaciones;
    }
    
}
