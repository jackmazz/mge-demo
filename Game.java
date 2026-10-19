package TMG;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static ArrayList<Character> characters = new ArrayList<Character>();
    private static ArrayList<String> maps = new ArrayList<String>();
    private static ArrayList<World> worlds = new ArrayList<World>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean game = true;
    private static int level = 0;

    public static void control() {
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("t")) {
            game = false;
            return;
        }
        String controls = "qweasdzxc";
        int[] movements = { -1, -1, -1, 0, -1, 1, 0, -1, 0, 0, 0, 1, 1, -1, 1, 0, 1, 1 };
        for (int i = 0; i < controls.length(); i++) {
            if (input.equals(controls.substring(i, i + 1))) {
                if (getPlayer().getPosition().getLocation().inBounds(getPlayer().getPosition().getRCoordinate() +
                                                                     movements[i * 2],
                                                                     getPlayer().getPosition().getCCoordinate() +
                                                                     movements[i * 2 + 1])) {
                    getPlayer().move(movements[i * 2], movements[i * 2 + 1]);
                    return;
                }
            }
        }
        control();
        return;
    }

    public static void display() {
        String status = getPlayer().toString();
        String map = getWorld(level).toString();
        System.out.println((status + map).replace("\n", "\n   "));
    }

    public static void main(String[] args) {
        setup();
        while (game) {
            display();
            control();
        }
    }

    public static void setCharacters(ArrayList<Character> c) {
        characters = c;
    }

    public static void setMaps(ArrayList<String> m) {
        maps = m;
    }

    public static void setup() {
        String s = "";
        maps.add("###########        ##        ##        ##        ##        ##        ##        ##        ###########");
        for (int i = 0; i < 900; i++) {
            if (i % 30 - 15 > 0 || i % 30 == 0 || i <= 30 || i > 870) {
                s += "#";
            } else {
                s += " ";
            }
        }
        maps.add(s);
        worlds.add(new World(getMap(0), 10, 10));
        worlds.add(new World(getMap(1), 30, 30));
        characters.add(new Character(worlds.get(0).getSpace(0, 0), "@"));
        characters.add(new Character(worlds.get(0).getSpace(3, 3)));
        characters.add(new Character(worlds.get(1).getSpace(5, 5)));
    }

    public static void setGame(boolean g) {
        game = g;
    }

    public static void setLevel(int l) {
        level = l;
    }

    public static void setScanner(Scanner s) {
        scanner = s;
    }

    public static void setWorlds(ArrayList<World> w) {
        worlds = w;
    }

    public static ArrayList<Character> getCharacters() {
        return characters;
    }

    public static ArrayList<String> getMaps() {
        return maps;
    }

    public static ArrayList<World> getWorlds() {
        return worlds;
    }

    public static Character getCharacter(int i) {
        return characters.get(i);
    }

    public static Character getPlayer() {
        return getCharacter(0);
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static String getMap(int i) {
        return maps.get(i);
    }

    public static World getWorld(int i) {
        return worlds.get(i);
    }

    public static boolean getGame() {
        return game;
    }

    public static int getLevel() {
        return level;
    }
}
