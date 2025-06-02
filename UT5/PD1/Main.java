package org.example.UT5.PD1;

public class Main {
    public static void main(String[] args) {
       TArbolGenerico<String> arbolete = new TArbolGenerico();

        arbolete.insertar("RECTORIA", "");
        arbolete.insertar("VICERRECTORÍA DEL MEDIO UNIVERSITARIO", "RECTORIA");
        arbolete.insertar("VICERRECTORÍA ACADEMICA", "RECTORIA");
        arbolete.insertar("VICERRECTORÍA ADMINISTRATIVA", "RECTORIA");
        arbolete.insertar("FACULTAD DE CIENCIAS EMPRESARIALES ", "VICERRECTORÍA ACADEMICA");
        arbolete.insertar("FACULTAD DE CIENCIAS HUMANAS ", "VICERRECTORÍA ACADEMICA");
        arbolete.insertar("FACULTAD DE ING", "VICERRECTORÍA ACADEMICA");
        arbolete.insertar("FACULTAD DE PSICO", "VICERRECTORÍA ACADEMICA");
        arbolete.insertar("DEPARTAMENTO DE ING ELECTETRICA", "FACULTAD DE ING");
        arbolete.insertar("DEPARTAMENTO DE INFORMATICA", "FACULTAD DE ING");
        arbolete.insertar("DEPARTAMENTO DE MATEMATE", "FACULTAD DE ING");

        System.out.println(arbolete.buscar("VICERRECTORÍA ADMINISTRATIVA") != null); // True
        System.out.println(arbolete.buscar("FACULTAD DE FACULTADES") != null); // False
        System.out.println(arbolete.buscar("FACULTAD DE ING") != null); // True
        System.out.println(arbolete.buscar("LO DE WALTER") != null); // False

        System.out.println("-----------------------------");

        String ojo = arbolete.listarIndentado();
        System.out.println(ojo);
    }
}
