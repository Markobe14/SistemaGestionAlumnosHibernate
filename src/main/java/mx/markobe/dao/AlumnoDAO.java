package mx.markobe.dao;

import java.util.List;
import javax.persistence.Query;
import static mx.markobe.dao.GenericDAO.em;
import mx.markobe.domain.Alumno;

public class AlumnoDAO extends GenericDAO{
    
    public List<Alumno> listarAlumnos() {

        String consulta = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        List<Alumno> alumnos = query.getResultList();

        return alumnos;
    }

    public void intertarAlumno(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);

        } finally {
            if (em!= null) {
                em.clear();
            }
        }
    }
    
    public void actualizarDomicilio(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno); //Merge es para modificar
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void eliminarDomicilio(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno)); //Remove y merge, primero actualiza el estado de la BD y luego lo elimina
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
        public Object buscarDomicilioPorId(Alumno alumno){
        
        em = getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());
        
    }
    
}
