package mx.markobe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.markobe.domain.Curso;

public class CursoDAO extends GenericDAO {

    public List<Curso> listarCursos() {

        String consulta = "Select c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        List<Curso> cursos = query.getResultList();

        return cursos;
    }

    public void intertarCurso(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);

        } finally {
            if (em!= null) {
                em.clear();
            }
        }
    }
    
    public void actualizarDomicilio(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso); //Merge es para modificar
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void eliminarDomicilio(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(curso)); //Remove y merge, primero actualiza el estado de la BD y luego lo elimina
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
        public Object buscarDomicilioPorId(Curso curso){
        
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());
        
    }

}
