package org.example.UT4.PD5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PD5_TESTS {

    @Test
    public void obtenerMenorClaveConUnNodo() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5, 5);
        assertEquals(5, raiz.obtenerMenorClave());
    }

    @Test
    public void obtenerMenorClaveConHijos() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5, 5);
        raiz.setHijoIzq(new TElementoAB<>(3, 3));
        raiz.getHijoIzq().setHijoIzq(new TElementoAB<>(1, 1));
        assertEquals(1, raiz.obtenerMenorClave());
    }

    @Test
    public void obtenerMayorClaveNodoUnico() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5,5);
        assertEquals(5, raiz.obtenerMayorClave());
    }

    @Test
    public void obtenerMayorClaveConHijos() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5, 5);
        raiz.setHijoDer(new TElementoAB<>(7, 7));
        raiz.getHijoDer().setHijoDer(new TElementoAB<>(9, 9));
        assertEquals(9, raiz.obtenerMayorClave());
    }

    @Test
    public void testBuscarAnterior() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5, 5);
        raiz.setHijoIzq(new TElementoAB<>(3, 3));
        assertEquals(5, raiz.buscarAnterior(3));
    }

    @Test
    public void testBuscarAnteriorNulo() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5, 5);
        assertNull(raiz.buscarAnterior(10));
    }

    @Test
    public void testListarHojasDosHojas() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5,5);
        raiz.setHijoIzq(new TElementoAB<>(3,3));
        raiz.setHijoDer(new TElementoAB<>(7,7));
        raiz.listarHojas(raiz, 0);
    }

    @Test
    public void testContarNodosNivel() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5,5);
        raiz.setHijoIzq(new TElementoAB<>(3,3));
        raiz.getHijoIzq().setHijoIzq(new TElementoAB<>(1,1));
        assertEquals(1, raiz.contarNodosNivel(raiz, 2));
    }

    @Test
    public void testContarNodosNivelRaiz() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5,5);
        assertEquals(1, raiz.contarNodosNivel(raiz, 0));
    }

    @Test
    public void testEsDeBusquedaValidongo() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5,5);
        raiz.setHijoIzq(new TElementoAB<>(3,3));
        raiz.setHijoDer(new TElementoAB<>(7,7));
        assertTrue(raiz.esDeBusqueda());
    }

    @Test
    public void testEsDeBusquedaNo() {
        TElementoAB<Integer> raiz = new TElementoAB<>(5,5);
        raiz.setHijoIzq(new TElementoAB<>(7,7)); // Inválido (7 > 5)
        assertFalse(raiz.esDeBusqueda());
    }
}