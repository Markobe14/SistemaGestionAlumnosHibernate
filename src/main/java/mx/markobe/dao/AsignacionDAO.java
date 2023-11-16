package mx.markobe.dao;

import java.util.List;
import javax.persistence.Query;
import static mx.markobe.dao.GenericDAO.em;
import mx.markobe.domain.Asignacion;


public class AsignacionDAO extends GenericDAO{
    
    public List<Asignacion> listarAsignacions() {

        String consulta = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        List<Asignacion> asignacions = query.getResultList();

        return asignacions;
    }

    public void intertarAsignacion(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);

        } finally {
            if (em!= null) {
                em.clear();
            }
        }
    }
    
    public void actualizarDomicilio(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion); //Merge es para modificar
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void eliminarDomicilio(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion)); //Remove y merge, primero actualiza el estado de la BD y luego lo elimina
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
        public Object buscarDomicilioPorId(Asignacion asignacion){
        
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
        
    }
    
}
