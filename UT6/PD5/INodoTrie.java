package org.example.UT6.PD5;

import java.util.List;

public interface INodoTrie {

    void insertar(String palabra);

    boolean buscar(String palabra);

    void predecir(String prefijo, List<String> resultados);

    void buscarPatrones(String texto, List<Integer> posiciones);

    void insertarTelefono(String telefono, String nombre);

    void buscarTelefonos(String prefijo, List<Abonado> resultados);



}
