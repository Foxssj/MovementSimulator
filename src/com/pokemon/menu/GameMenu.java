package com.pokemon.menu;

import com.pokemon.character.Charact;
import com.pokemon.map.Map;

public class GameMenu {
    private Charact player;
    private Map map;
    private boolean onBike = false;

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
    //e) Es necesario un método que pinte el mapa con el personaje en la posición que
    //corresponde. La representación del mismo puede ser, “O” cuando está caminando,
    //y “8” cuando está en bicicleta.
    //f) Por último, debe incluir un método que retorne una cadena de texto informando
    //de la leyenda completa de símbolos utilizados tanto para el mapa como para el
    //usuario.
    //# → Borde del mapa (no accesible)
    //X → Suelo del mapa (accesible)
    //O → Posición del personaje (caminando)
    //8 → Posición del personaje (en bic
}
