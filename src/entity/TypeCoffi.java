package entity;

public enum    TypeCoffi {

    GOLD(1), CLASSIC(2),DLY_LOHOV(3);
private int db;

    public int getDb() {
        return db;
    }

    TypeCoffi(int i) {
        db = i;
    }

}
