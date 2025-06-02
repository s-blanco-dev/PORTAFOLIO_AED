package org.example.UT5.PD1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UT5_PD1_TEST {
    TArbolGenerico<String> elArbol;

    @BeforeEach
    void setUp() {
        elArbol = new TArbolGenerico<String>();
    }

    @Test
    void insertarComoRaiz() {
        elArbol.insertar("MOTOR", ""); /* Inserto en árbol vacio */
        boolean esRaiz = elArbol.getRaiz().getEtiqueta() == "MOTOR";

        /* Reemplazo la raíz*/
        elArbol.insertar("HUGO", "");
        boolean reemplazaRaiz = elArbol.getRaiz().getEtiqueta() == "HUGO";

        assertTrue(esRaiz && reemplazaRaiz);
    }

    @Test
    void insertarInterno() {
        boolean inserto1 = elArbol.insertar("RAIZ", "");
        boolean inserto2 = elArbol.insertar("HIJO1", "RAIZ");
        boolean inserto3 = elArbol.insertar("HIJO2", "RAIZ");
        boolean inserto4 = elArbol.insertar("HIJO3", "RAIZ");
        boolean inserto5 = elArbol.insertar("HIJO2_1", "HIJO2");

        /* HIJO 3 DEBE SER EL ULTIMO HIJO DE LA RAIZ */
        assertSame("HIJO3", elArbol.getRaiz().getUltimoHijo().getEtiqueta());
        /* HIJO 1 DEBE SER EL PRIMER HIJO DE LA RAIZ */
        assertSame("HIJO1", elArbol.getRaiz().getPrimerHijo().getEtiqueta());
        /* HIJO 2 DEBE SER EL NODO DEL MEDIO */
        assertSame("HIJO2", elArbol.getRaiz().getPrimerHijo().getSiguienteHermano().getEtiqueta());
        /* HIJO2_1 DEBE SER EL UNICO HIJO DE HIJO2 - USANDO METODO BUSCAR*/
        assertSame("HIJO2_1", elArbol.buscar("HIJO2").getPrimerHijo().getEtiqueta());
        assertNull(elArbol.buscar("HIJO2_1").getSiguienteHermano());

        /* DEVUELVE VALORES CORRECTOS */
        assertTrue(inserto1 && inserto2 && inserto3 && inserto4 && inserto5);
    }

    @Test
    void insertarPadreNulo() {
        elArbol.insertar("RAIZ", "");
        elArbol.insertar("HIJO1", "RAIZ");
        boolean insertoNulo = elArbol.insertar("MORRO", "HIJO5");

        assertFalse(insertoNulo);
        assertNull(elArbol.buscar("MORRO"));
    }


    @Test
    public void testListarIndentado() {
        boolean inserto1 = elArbol.insertar("RAIZ", "");
        boolean inserto2 = elArbol.insertar("HIJO", "RAIZ");
        boolean inserto6 = elArbol.insertar("NIETO", "HIJO");

        String resultado = elArbol.listarIndentado();

        String[] lineas = resultado.split("\n");

        assertEquals("RAIZ", lineas[0]);        // nivel 0
        assertEquals("\tHIJO", lineas[1]);      // nivel 1
        assertEquals("\t\tNIETO", lineas[2]);    // nivel 2
    }

    @Test
    public void testBuscar() {
        boolean inserto1 = elArbol.insertar("RAIZ", "");
        boolean inserto2 = elArbol.insertar("HIJO", "RAIZ");
        boolean inserto6 = elArbol.insertar("NIETO", "HIJO");

        assertSame("HIJO", elArbol.buscar("HIJO").getEtiqueta());
        assertSame("NIETO", elArbol.buscar("NIETO").getEtiqueta());
        assertSame("RAIZ", elArbol.buscar("RAIZ").getEtiqueta());
        assertNull(elArbol.buscar("PERRO"));
    }
}