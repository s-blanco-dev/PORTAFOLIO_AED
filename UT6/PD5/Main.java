package org.example.UT6.PD5;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TTrieHashMap modorra = new TTrieHashMap();

        modorra.insertar("casa");
        modorra.insertar("casamiento");
        modorra.insertar("casados");
        modorra.insertar("casco");
        modorra.insertar("carro");

        modorra.insertar("camioneta");
        modorra.insertar("casucuntusmonomunts");

        System.out.println("casamiento: " + modorra.buscar("casamiento"));
        System.out.println("Buscar cas (nulete)': " + modorra.buscar("cas"));

        System.out.println("carro: " + modorra.buscar("carro"));


        String testo = "camionetacasamientocasa";
        List<Integer> posiciones = modorra.buscarPatrones(testo);
        System.out.println("\nPatrones : " + posiciones);

        System.out.println("atompletar 'cas': " + modorra.autocompletar("cas"));
    }


}
