package mx.markobe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.markobe.domain.Alumno;

public class AlumnoDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public AlumnoDAO(){
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }
    
    public List<Alumno> listarAlumnos(){
        String hql = "Select a FROM Alumno a";
        Query query = em.createQuery(hql);
        List<Alumno> alumnos = query.getResultList();
        
        return alumnos;
    }
    
}
