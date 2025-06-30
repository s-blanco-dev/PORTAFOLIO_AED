package org.example.UT6.PD5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TTrieHashMap implements ITrie{

    private INodoTrie root;

    public TTrieHashMap() {
        root = new TNodoTrieHashMap();
    }

    @Override
    public void insertar(String palabra) {
        root.insertar(palabra);

    }

    @Override
    public boolean buscar(String palabra) {
        return root.buscar(palabra);
    }

    @Override
    public List<String> autocompletar(String prefijo) {
        List<String> resultadongos = new LinkedList<>();
        root.predecir(prefijo, resultadongos);
        return resultadongos;
    }

    @Override
    public List<Integer> buscarPatrones(String texto) {
        List<Integer> posiciones = new LinkedList<>();
        root.buscarPatrones(texto, posiciones);
        return posiciones;
    }

    @Override
    public void insertarTelefonos(String telefono, String nombre) {
        if (root != null) {
            root.insertarTelefono(telefono, nombre);
        }
    }

    @Override
    public List<Abonado> buscarTelefonos(String codigoPais, String codigoArea) {
        List<Abonado> lista = new ArrayList<>();
        String clave = codigoPais.concat(codigoArea);
        if (root != null) {
            root.buscarTelefonos(clave, lista);
        }
        if (!lista.isEmpty()) {
            Collections.sort(lista);
        }
        return lista;
    }
}
