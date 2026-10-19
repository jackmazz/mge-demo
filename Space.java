package TMG;

public class Space {
    private Character occupant;
    private String marker;
    private World location;
    private int[] coordinates;

    public Space() {
        this(null, " ", null, 0, 0);
    }

    public Space(World l, int r, int c) {
        this(null, " ", l, r, c);
    }

    public Space(Character o, String m, World l, int r, int c) {
        setOccupant(o);
        setMarker(m);
        setLocation(l);
        setCoordinates(r, c);
    }

    public void setCoordinates(int r, int c) {
        coordinates = new int[2];
        coordinates[0] = r;
        coordinates[1] = c;
    }

    public void setCCoordinate(int c) {
        coordinates[1] = c;
    }

    public void setMarker(String m) {
        marker = m;
    }

    public void setLocation(World l) {
        location = l;
    }

    public void setOccupant(Character o) {
        occupant = o;
    }

    public void setRCoordinate(int r) {
        coordinates[0] = r;
    }

    public Character getOccupant() {
        return occupant;
    }

    public String getMarker() {
        return marker;
    }

    public String toString() {
        if (occupant != null) {
            return occupant.getAppearance() + " ";
        }
        return marker + " ";
    }

    public World getLocation() {
        return location;
    }

    public boolean equals(Space s) {
        if (location != s.getLocation() || coordinates != s.getCoordinates()) {
            return false;
        }
        return true;
    }

    public boolean isOccupied() {
        if (occupant != null) {
            return true;
        }
        return false;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public int getCCoordinate() {
        return coordinates[1];
    }

    public int getRCoordinate() {
        return coordinates[0];
    }
}
