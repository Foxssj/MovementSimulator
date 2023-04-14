package com.pokemon.menu;

import com.pokemon.character.Charact;
import com.pokemon.map.Map;

import java.util.Arrays;

public class GameMenu {
    private Charact player;
    private Map map;
    private boolean onBike = false;
    private String charModel = "i";
    private final String DEFSPACE = "X";

    public GameMenu(Charact player, Map map) {
        this.player = player;
        this.map = map;
    }

    //b) Debe incluir un método público para montar al personaje en la bicicleta,
    //cambiando su velocidad de desplazamiento a 2. Si ya estaba sobre la bicicleta,
    //debe mostrarse un mensaje que lo indique.

    public void mountBike() {
        if (!onBike) {
            System.out.println("*You mounted your bike*");
            charModel = "8";
            this.player.setMovementSpeed(2);
            onBike = true;
        } else {
            System.out.println("You're already on your bike");
        }
    }

    //c) Debe incluir un método público para desmontar al personaje de la bicicleta,
    //cambiando su velocidad de desplazamiento a 1. Si ya estaba caminando, debe
    //mostrarse un mensaje que lo indique.

    public void dismoutBike() {
        if (onBike) {
            System.out.println("*You dismounted your bike*");
            charModel = "i";
            this.player.setMovementSpeed(1);
            onBike = false;
        } else {
            System.out.println("You're already walking");
        }
    }

    //d) Debe tener un método desplazar personaje que acepte como parámetro una
    //variable que represente el sentido de desplazamiento. En función de este
    //parámetro, se aumentará o reducirá la coordenada correspondiente del personaje,
    //teniendo en cuenta la velocidad del mismo. Es decir, si nos desplazamos a la
    //derecha y está sobre la bicicleta, se moverá dos unidades a la derecha (sumando
    //dos a la coordenada X).
    //Es importante tener en cuenta la posición del personaje con respecto al mapa. Si el
    //personaje se va a mover al borde del mapa, hay que impedírselo, manteniendo la
    //posición que tenía y mostrando un mensaje por pantalla de que se ha llegado al
    //borde y no se puede avanzar más. Del mismo modo, si va en bicicleta y queda un
    //espacio entre el personaje y el muro, en lugar de desplazarse las dos unidades
    //correspondientes, debe moverse una única unidad hasta antes del borde.

    public void moveCharacter(String direccion) {
        switch (direccion) {
            case "W":
            case "w":
                if (!onBike) {
                    if (player.getPosY() == 1){
                        System.out.println("You can't go any further");
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                            player.setPosY(-1);
                        }
                } else {
                    if (player.getPosY() == 1){
                        System.out.println("You can't go any further");
                    } else if (player.getPosY() == 2) {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosY(-1);
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosY(-2);
                    }
                }
                break;
            case "A":
            case "a":
                if (!onBike) {
                    if (player.getPosX() == 1){
                        System.out.println("You can't go any further");
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosX(-1);
                    }
                } else {
                    if (player.getPosX() == 1){
                        System.out.println("You can't go any further");
                    } else if (player.getPosX() == 2) {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosX(-1);
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosX(-2);
                    }
                }
                break;
            case "D":
            case "d":
                if (!onBike) {
                    if (player.getPosX() == map.getMapSize() - 1){
                        System.out.println("You can't go any further");
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosX(1);
                    }
                } else {
                    if (player.getPosX() == map.getMapSize() - 1){
                        System.out.println("You can't go any further");
                    } else if (player.getPosX() == map.getMapSize() - 2) {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosX(1);
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosX(2);
                    }
                }
                break;
            case "S":
            case "s":
                if (!onBike) {
                    if (player.getPosY() == map.getMapSize() - 2){
                        System.out.println("You can't go any further");
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosY(1);
                    }
                } else {
                    if (player.getPosY() == map.getMapSize() - 2){
                        System.out.println("You can't go any further");
                    } else if (player.getPosY() == map.getMapSize() - 3) {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosY(1);
                    } else {
                        map.setMapGenerated(player.getPosX(), player.getPosY(), DEFSPACE);
                        player.setPosY(2);
                    }
                }
                break;
            case "Q":
        }
    }

    //e) Es necesario un método que pinte el mapa con el personaje en la posición que
    //corresponde. La representación del mismo puede ser, “O” cuando está caminando,
    //y “8” cuando está en bicicleta.

    public void showMap() {
        String tempMap = "";

        for (int i = 0; i < map.getMapGenerated().length; i++) {
            for (int j = 0; j < map.getMapSize(); j++) {
                if (i == player.getPosY() && j == player.getPosX()) {
                    tempMap += charModel;
                } else {
                    tempMap += Arrays.toString(map.getMapGenerated()[i]) + "\n";
                }
            }
        }
        map.setMapGenerated(player.getPosY(), player.getPosX(), charModel);
        System.out.println(map);
    }

    //f) Por último, debe incluir un método que retorne una cadena de texto informando
    //de la leyenda completa de símbolos utilizados tanto para el mapa como para el
    //usuario.
    //# → Borde del mapa (no accesible)
    //X → Suelo del mapa (accesible)
    //O → Posición del personaje (caminando)
    //8 → Posición del personaje (en bici)

    public void mapInfo() {
        System.out.println("# → map border (not accesible)\n" +
                "X → maps floor (accesible)\n" +
                "i → player position (walking)\n" +
                "8 → player position (on bike)");
    }

}
