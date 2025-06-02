package org.example.UT3.PD7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuntoTest {
    private IConjunto<TAlumno> AED;
    private IConjunto<TAlumno> PF;
    private TAlumno juan, chorro, morro, elsa, coco, pedro, pocho;

    @BeforeEach
    void setUp() {
        coco = new TAlumno(1266, "Cono", "Incienso");
         juan = new TAlumno(2211, "Juan", "Rombo");
        chorro = new TAlumno(4215, "Heriberto", "Parral");
        pedro = new TAlumno(5918, "Pedro", "Navaja");
        morro = new TAlumno(7799, "Manfredo", "Pado");
        pocho = new TAlumno(8791, "Luis", "Motoneta");
        elsa = new TAlumno(8811, "Elsa", "Capunta");

        AED = new Conjunto<TAlumno>();
        PF = new Conjunto<TAlumno>();

        AED.insertar(juan, juan.getCedula());
        AED.insertar(chorro, chorro.getCedula());
        AED.insertar(morro, morro.getCedula());
        AED.insertar(elsa, elsa.getCedula());

        PF.insertar(coco, coco.getCedula());
        PF.insertar(juan, juan.getCedula());
        PF.insertar(pedro, pedro.getCedula());
        PF.insertar(elsa, elsa.getCedula());
        PF.insertar(pocho, pocho.getCedula());
    }

    @Test
    void unionTestCantidad() {
        IConjunto<TAlumno> laUnion = PF.union(AED);
        int cantidad = laUnion.cantElementos();
        assertEquals(7, cantidad, "Debería tener la misma cantidad de elementos que los elementos existentes");

    }

    @Test
    void unionTestElementos() {
        IConjunto<TAlumno> laUnion = PF.union(AED);
        assertNotNull(laUnion.buscar(juan.getCedula()), "Uno de los elementos no está presente");
        assertNotNull(laUnion.buscar(morro.getCedula()), "Uno de los elementos no está presente");
        assertNotNull(laUnion.buscar(elsa.getCedula()), "Uno de los elementos no está presente");
    }

    @Test
    void testRepetidos() {
        IConjunto<TAlumno> laUnion = PF.union(AED);
        int cantidad = laUnion.cantElementos();
        TAlumno alomno = new TAlumno(2211, "Ernesto", "Chorro");
        laUnion.insertar(alomno, alomno.getCedula());

        assertEquals(cantidad, laUnion.cantElementos());
        assertEquals(laUnion.buscar(alomno.getCedula()), juan);
    }

    @Test
    void intersectionTestCantidad() {
        IConjunto<TAlumno> laInter = PF.intersection(AED);
        int cantidad = laInter.cantElementos();

        assertEquals(2, cantidad);
    }

    @Test
    void intersectionTestElementos() {
        IConjunto<TAlumno> laInter = PF.intersection(AED);

        assertNotNull(laInter.buscar(juan.getCedula()), "Uno de los elementos no está presente");
        assertNotNull(laInter.buscar(elsa.getCedula()), "Uno de los elementos no está presente");
        assertNull(laInter.buscar(morro.getCedula()), "Este muchacho no debería estar presente");
    }
}