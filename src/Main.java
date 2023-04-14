import com.pokemon.character.Charact;
import com.pokemon.map.Map;
import com.pokemon.map.MapGenerator;
import com.pokemon.menu.GameMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, option;
        int map_size;
        boolean playing = true;

        String menu = """
                1.- Move Around
                2.- Ride or dismout your bike
                3.- Look at your map
                4.- show info of the map icons
                5.- Let this world ends...""";

        // Finalmente, en el método principal de la clase ejecutable de tu proyecto, da una
        //bienvenida al usuario.
        //A continuación, desarrolla un mecanismo para solicitarle el tamaño del mapa de juego y,
        //con una única instancia de MenuDeJuego, implementa un menú de interacción con el
        //usuario que tenga las opciones:
        //- Desplazar al jugador en las cuatro direcciones.
        //- Montar o desmontar al jugador de la bicicleta.
        //- Mostrar el mapa incluyendo al jugador.
        //- Mostrar la leyenda del mapa de juego.
        //- Cerrar el juego despidiéndose del usuario.

        System.out.println("Welcome to the world of endless plains!");
        System.out.println("How may we refer to you? Hero of the plains?");
        name = sc.nextLine();
        Charact player = new Charact(name);

        System.out.println("Great! " + name + " your jourmey is about to begin, " +
                "but first you'll have to decide how much of this world are you going to save..." +
                "\n \t Write a number which will decide how large the world is going to be:");
        map_size = sc.nextInt();
        sc.nextLine();

        Map map = new Map(map_size);

        GameMenu gameMenu = new GameMenu(player, map);

        while (playing) {

            System.out.println("*You think in your next move*");
            System.out.println(menu);
            option = sc.nextLine();

            switch (option) {
                case "1":
                    boolean stop = false;
                    String movement;
                    System.out.println("*you see a piece of paper in the floor*" +
                            "\n'use WASD to move, if you want to stop press Q'");
                    while (stop) {
                        System.out.println("*you tought where to go*");
                        movement = sc.nextLine();
                        if (movement.equals("Q")) {
                            stop = true;
                        } else {
                            gameMenu.moveCharacter(movement);
                        }
                    }

            }
        }


    }
}