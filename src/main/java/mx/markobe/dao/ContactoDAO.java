package mx.markobe.dao;

import java.util.List;
import javax.persistence.Query;
import mx.markobe.domain.Contacto;

public class ContactoDAO extends GenericDAO{
    
    public List<Contacto> listarContacto() {

        String consulta = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        List<Contacto> contactos = query.getResultList();

        return contactos;
    }

    public void insertarContacto(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto); //Persist es para insertar elementos
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void actualizarContacto(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto); //Merge es para modificar
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void eliminarContacto(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contacto)); //Remove y merge, primero actualiza el estado de la BD y luego lo elimina
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public Object buscarContactoPorId(Contacto contacto){
        
        em = getEntityManager();
        return em.find(Contacto.class, contacto.getIdContacto());
        
    }
    
}
