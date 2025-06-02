package org.example.UT3.PD12;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuntoTest {

    private Conjunto conjunto1;
    private Conjunto conjunto2;
    private Alumno ramon, sucio, motoneta, incendio, chorro;

    @BeforeEach
    void setUp() {
        conjunto1 = new Conjunto();
        conjunto2 = new Conjunto();

        Alumno ramon = new Alumno(22, "Ramon");
        Alumno sucio = new Alumno(62, "Sucio");
        Alumno motoneta = new Alumno(81, "Motoneta");
        Alumno incendio = new Alumno(41, "Incendio");
        Alumno chorro = new Alumno(11, "Chorro");

         conjunto1.insertar(ramon, ramon.getCodigo());
        conjunto1.insertar(sucio, sucio.getCodigo());
        conjunto1.insertar(chorro, chorro.getCodigo());

        conjunto2.insertar(incendio, incendio.getCodigo());
        conjunto2.insertar(chorro, chorro.getCodigo());
        conjunto2.insertar(motoneta, motoneta.getCodigo());
    }

    @Test
    void unionTestCantidad() {
        Conjunto total = new Conjunto();
        total = conjunto1.union(conjunto2);

        assertEquals(5, total.cantElementos());
    }

    @Test
    void unionTestElementos() {
        Conjunto total = new Conjunto();
        total = conjunto1.union(conjunto2);

        assertNotNull(total.buscar(22));
        assertNotNull(total.buscar(62));
        assertNotNull(total.buscar(81));
        assertNotNull(total.buscar(41));
        assertNotNull(total.buscar(11));
    }

    @Test
    void intersectionTestCantidad() {
        Conjunto total = new Conjunto();
        total = conjunto1.interseccion(conjunto2);

        assertEquals(1, total.cantElementos());
    }

    @Test
    void intersectionTestElementos() {
        Conjunto total = new Conjunto();
        total = conjunto1.interseccion(conjunto2);

        assertNull(total.buscar(22));
        assertNull(total.buscar(62));
        assertNull(total.buscar(81));
        assertNull(total.buscar(41));

        assertNotNull(total.buscar(11));
    }
}