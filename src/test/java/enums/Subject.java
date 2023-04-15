package enums;

public enum Subject {
    ENGLISH, CHEMISTRY, COMMERCE;

    @Override
    public String toString(){
        return this.name().substring(0,1) + this.name().substring(1).toLowerCase();
    }
}
