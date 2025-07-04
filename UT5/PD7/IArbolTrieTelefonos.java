package org.example;

import java.util.LinkedList;

/**
 *
 * @author ernesto
 */
public interface IArbolTrieTelefonos {

    LinkedList<TAbonado> buscarTelefonos(String pais, String area);

    void insertar(TAbonado unAbonado);

}
