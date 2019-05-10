package models;

public enum OmikujiType {
    DAI_KICHI(1,"大吉"),
    KICHI(2,"吉"),
    KYO(3,"凶"),
    DAI_KYO(4,"大凶");

    private final int id;
    private final String name;

    OmikujiType(int id ,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
