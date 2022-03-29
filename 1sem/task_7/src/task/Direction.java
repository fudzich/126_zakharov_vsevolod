package task;

public enum Direction {
    North(0, -1),
    West(-1, 0),
    South(0, 1),
    East(1, 0);


    private int x;
    private int y;


    private Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 move(Vector2 start, double distance) {
        double x = start.getX() + distance*this.x;
        double y = start.getY() + distance*this.y;
        Vector2 place = new Vector2(x,y);
        return place;
    }
}

