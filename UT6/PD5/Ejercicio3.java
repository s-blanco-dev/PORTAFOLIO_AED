package org.example.UT6.PD5;
import java.util.List;
import java.util.StringTokenizer;

public class Ejercicio3 {
    public static void main(String[] args) {
        TTrieHashMap trie = new TTrieHashMap();

        String[] linAbono = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6/PD5/abonados.txt");

        for (String linea : linAbono) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            if (st.countTokens() == 2) {
                String telefono = st.nextToken().trim();
                String nombre = st.nextToken().trim();
                trie.insertarTelefonos(telefono, nombre);
            }
        }

        String[] lineasCodigos = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6/PD5/codigos1.txt");

        String codigoPais = "";
        String codigoArea = "";

        for (String linea : lineasCodigos) {
            if (linea.startsWith("CODIGO PAIS:")) {
                codigoPais = linea.replace("CODIGO PAIS:", "").trim();
            } else if (linea.startsWith("CODIGO AREA:")) {
                codigoArea = linea.replace("CODIGO AREA:", "").trim();

                List<Abonado> resultados = trie.buscarTelefonos(codigoPais, codigoArea);
                String[] salida = new String[resultados.size()];
                for (int i = 0; i < resultados.size(); i++) {
                    salida[i] = resultados.get(i).toString();
                }

                if (salida.length > 0) {
                    ManejadorArchivosGenerico.escribirArchivo("salida.txt", salida);
                    System.out.println("Resultados escritos para código " + codigoPais + "-" + codigoArea);
                } else {
                    System.out.println("No se encontraron abonados para código " + codigoPais + "-" + codigoArea);
                }
            }
        }

    }}
