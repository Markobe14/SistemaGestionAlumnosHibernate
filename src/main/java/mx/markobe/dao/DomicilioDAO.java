package mx.markobe.dao;

import java.util.List;
import javax.persistence.Query;
import mx.markobe.domain.Domicilio;

public class DomicilioDAO extends GenericDAO {

    public List<Domicilio> listarDomicilios() {

        String consulta = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        List<Domicilio> domicilios = query.getResultList();

        return domicilios;
    }

    public void insertarDomicilio(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio); //Persist es para insertar elementos
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void actualizarDomicilio(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio); //Merge es para modificar
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void eliminarDomicilio(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio)); //Remove y merge, primero actualiza el estado de la BD y luego lo elimina
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public Object buscarDomicilioPorId(Domicilio domicilio){
        
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
        
    }

    
}
