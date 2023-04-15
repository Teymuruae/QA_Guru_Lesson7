package enums;

public enum Hobby {
    SPORTS, READING, MUSIC;

    @Override
    public String toString(){
        return this.name().substring(0,1) + this.name().substring(1).toLowerCase();
    }
}
