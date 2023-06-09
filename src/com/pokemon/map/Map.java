package com.pokemon.map;

import java.util.Arrays;

public class Map {
    //a) Debe contener, como mínimo, los siguientes atributos:
    //- Tamaño del mapa
    //- Mapa generado
    //b) El constructor debe recibir el tamaño del mapa. Se debe inicializar aquí el
    //atributo del mapa, mediante un método estático que se encuentra en la clase del
    //siguiente apartado.
    private int mapSize;
    private String[][] mapGenerated;

    public Map(int mapSize) {
        if (mapSize < 3) {
            this.mapSize = 3;
            this.mapGenerated = MapGenerator.mapGeneration(this.mapSize);
        } else {
            this.mapSize = mapSize;

            this.mapGenerated = MapGenerator.mapGeneration(mapSize);
        }

    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public String[][] getMapGenerated() {
        return mapGenerated;
    }

    public void setMapGenerated(int pos1, int pos2, String player) {
        this.mapGenerated[pos1][pos2] = player;
    }

    @Override
    public String toString() {
        String map = "";

        for (int i = 0; i < mapGenerated.length; i++) {
            map += Arrays.toString(mapGenerated[i]) + "\n";
        }

        return map;
    }
}
