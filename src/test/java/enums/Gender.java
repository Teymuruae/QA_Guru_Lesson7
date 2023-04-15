package enums;

public enum Gender {
    MALE, FEMALE, OTHER;

    @Override
    public String toString(){
        return this.name().substring(0,1) + this.name().substring(1).toLowerCase();
    }
}
