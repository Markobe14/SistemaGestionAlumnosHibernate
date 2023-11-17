package mx.markobe.test;

import mx.markobe.dao.AlumnoDAO;
import java.util.List;
import mx.markobe.dao.AsignacionDAO;
import mx.markobe.dao.ContactoDAO;
import mx.markobe.dao.CursoDAO;
import mx.markobe.dao.DomicilioDAO;
import mx.markobe.domain.Asignacion;

public class TestDAOs {
    public static void main(String[] args) {
        
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println("Alumnos");
        imprimir(alumnoDAO.listarAlumnos());
        
        DomicilioDAO domicilioDAO = new DomicilioDAO();
        System.out.println("Domicilio: ");
        imprimir(domicilioDAO.listarDomicilios());
        
        ContactoDAO contactoDAO = new ContactoDAO();
        System.out.println("Contacto");
        imprimir(contactoDAO.listarContacto());
        
        CursoDAO cursoDAO = new CursoDAO();
        System.out.println("Cursos: ");
        imprimir(cursoDAO.listarCursos());
        
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        System.out.println("Asignaciones: ");
        imprimir(asignacionDAO.listarAsignacions());
        
    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("Valor = " + o);
        }
    }
}
