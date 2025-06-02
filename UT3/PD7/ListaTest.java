package org.example.UT3.PD7;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaTest extends TestCase {
 private Lista<Integer> lista1;
 private Lista<String> lista2;

   @BeforeEach
    public void setUp(){
     lista1 = new Lista<Integer>();
    lista2 = new Lista<String>();
    }

    @Test
    public void testGetPrimeroListaVacia() {
    Nodo<Integer> nodoInt = lista1.getPrimero();
    Nodo<String> nodoString = lista2.getPrimero();
    Assert.assertTrue(nodoInt == null && nodoString == null);
    }

    @Test
    public void testInsertarEnListaVacia() {
    int datoInt = 8;
    String datoString = "ABC";

     lista1.insertar(datoInt, datoInt);
     lista2.insertar(datoString, datoString);

     Nodo<Integer> nodoInt = lista1.getPrimero();
     Nodo<String> nodoString = lista2.getPrimero();

     assertEquals(datoInt, (int) nodoInt.getDato());
     assertEquals(datoString, nodoString.getDato());
    }

 // Pruebas para buscar()
 @Test
 void buscarEnListaVacia() {
  assertNull(lista1.buscar(5));
 }

 @Test
 void buscarElementoExistente() {
  lista1.insertar(1, 1);
  lista1.insertar(2, 2);
  lista1.insertar(3, 3);

  assertNotNull(lista1.buscar(2));
  assertEquals((Integer) 2, lista1.buscar(2));
 }

 @Test
 void buscarElementoNoExistente() {
  lista2.insertar("A", "A");
  lista2.insertar("B", "B");

  assertNull(lista2.buscar("C"));
 }

 @Test
 public void eliminarElemento() {
  lista1.insertar(1, 1);
  lista1.insertar(2, 2);
  lista1.insertar(3, 3);

  assertTrue(lista1.eliminar(2));
  assertEquals(2, lista1.cantElementos());
  assertEquals(1, (int) lista1.getPrimero().getDato());
  assertEquals(3, (int) lista1.getPrimero().getSiguiente().getDato());
 }
}