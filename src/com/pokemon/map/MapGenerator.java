package com.pokemon.map;

import java.lang.reflect.Array;

public class MapGenerator {
    //a) Uno que acepte un parámetro entero N y retorne un array string bidimensional
    //que represente un mapa cuadrado (NxN). Por ejemplo, si pasamos un tamaño de
    //mapa 10, el array devuelto debe tener una configuración similar a la siguiente:
    //b) Otro método que retorne una cadena de texto indicando la leyenda utilizada para
    //la generación del mapa. La idea es generar un diagrama que tenga una parte
    //accesible y una parte que no pueda pisarse. Por ejemplo, para el gráfico anterior:
    //# → Borde del mapa (no accesible)
    //X → Suelo del mapa (accesible)

    public static String[][] mapGeneration(int mapSize) {
        String[][] map = new String[mapSize][mapSize];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || j == 0 || i == mapSize - 1 || j == mapSize - 1) {
                    map[i][j] = "#";
                } else {
                    map[i][j] = "X";
                }
            }
        }
        return map;
    }

    public static String ShowMap() {
        String index = "# → map border (not accesible)\n" +
                "X → maps floor (accesible)";
        return index;
    }
}
