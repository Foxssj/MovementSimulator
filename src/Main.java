import com.pokemon.character.Charact;
import com.pokemon.map.Map;
import com.pokemon.map.MapGenerator;
import com.pokemon.menu.GameMenu;

public class Main {
    public static void main(String[] args) {

        Charact player = new Charact("link");

        Map map = new Map(10);

        GameMenu menu = new GameMenu(player, map);

        menu.showMap();
        menu.moveCharacter("s");
        menu.showMap();
        menu.moveCharacter("d");
        menu.showMap();
        menu.moveCharacter("d");
        menu.showMap();
        menu.moveCharacter("a");
        menu.showMap();
        menu.moveCharacter("w");
        menu.showMap();
        menu.moveCharacter("a");
        menu.showMap();

    }
}