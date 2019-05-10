package models;

/*
 *性別列挙型
 */
public enum Gender {

    MALE(1,"男性"),
    FEMAL(2,"女性");

    private final int id;
    private final String jpTxt;

    Gender(int id, String jpTxt){
        this.id = id;
        this.jpTxt = jpTxt;
    }

    @Override
    public java.lang.String toString() {
        return jpTxt;
    }
}
