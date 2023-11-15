package mx.markobe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.markobe.domain.Curso;

public class CursoDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CursoDAO(){
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }
    
    public List<Curso> listarCursos(){
        String hql = "Select c FROM Curso c";
        Query query = em.createQuery(hql);
        List<Curso> cursos = query.getResultList();
        
        return cursos;
    }
    
}
