package TMG;

public class World {
    private Space[][] spaces;
    private String markers;

    public World() {
        this("", 0, 0);
    }

    public World(int r, int c) {
        this("", r, c);
    }

    public World(String m, int r, int c) {
        setSpaces(r, c);
        setMarkers(m);
    }

    public void setMarkers(String m) {
        int count = 0;
        while (m.length() < getSize()) {
            m += " ";
        }
        markers = m.substring(0, getSize());
        for (int i = 0; i < getRSize(); i++) {
            for (int j = 0; j < getCSize(); j++) {
                spaces[i][j].setMarker(markers.substring(count, count + 1));
                count++;
            }
        }
    }

    public void setSpaces(int r, int c) {
        spaces = new Space[r][c];
        for (int i = 0; i < getRSize(); i++) {
            for (int j = 0; j < getCSize(); j++) {
                spaces[i][j] = new Space(this, i, j);
            }
        }
    }

    public Space[][] getSpaces() {
        return spaces;
    }

    public Space getSpace(int r, int c) {
        return spaces[r][c];
    }

    public String getMarkers() {
        return markers;
    }

    public String getMarker(int i) {
        return markers.substring(i, i + 1);
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < getRSize(); i++) {
            string += "\n";
            for (int j = 0; j < getCSize(); j++) {
                string += spaces[i][j].toString();
            }
        }
        return string;
    }

    public boolean equals(World w) {
        if (getRSize() != w.getRSize() || getCSize() != w.getCSize()) {
            return false;
        }
        for (int i = 0; i < getRSize(); i++) {
            for (int j = 0; j < getCSize(); j++) {
                if (!spaces[i][j].equals(w.getSpace(j, i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean inBounds(int r, int c) {
        if (r < 0 || r >= getRSize() || c < 0 || c >= getCSize()) {
            return false;
        }
        return true;
    }

    public int getCSize() {
        return spaces[0].length;
    }

    public int getSize() {
        return getRSize() * getCSize();
    }

    public int getRSize() {
        return spaces.length;
    }
}
