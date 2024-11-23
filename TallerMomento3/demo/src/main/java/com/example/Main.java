package com.example;

import com.example.Entidad.Clientes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        // Leer un empleado
        Clientes empleado = leerEmpleado(1L); // Cambiado a 1L para que sea Long
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado.getNombre() + ", Edad: " + empleado.getEdad());
        }

        em.close();
        emf.close();
    }

    // Método para leer (consultar) un empleado por ID
    public static Clientes leerEmpleado(Long id) {
        EntityManager em = emf.createEntityManager();
        Clientes empleado = em.find(Clientes.class, id);
        em.close();
        return empleado;
    }
}