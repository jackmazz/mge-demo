package TMG;

public class Character {
    private Space position;
    private String appearance;

    public Character() {
        this(null, "*");
    }

    public Character(Space p) {
        this(p, "*");
    }

    public Character(Space p, String a) {
        setPosition(p);
        setAppearance(a);
    }

    public void move(int r, int c) {
        setPosition(position.getLocation().getSpace(position.getRCoordinate() + r, position.getCCoordinate() + c));
    }

    public void setAppearance(String a) {
        appearance = a;
    }

    public void setPosition(Space p) {
        if (position != null) {
            position.setOccupant(null);
        }
        position = p;
        position.setOccupant(this);
    }

    public Space getPosition() {
        return position;
    }

    public String getAppearance() {
        return appearance;
    }

    public String toString() {
        return "\n" + position.getCCoordinate() + "," + position.getRCoordinate();
    }

    public boolean equals(Character c) {
        if (!position.equals(c.getPosition()) || !appearance.equals(c.getAppearance())) {
            return false;
        }
        return true;
    }
}
