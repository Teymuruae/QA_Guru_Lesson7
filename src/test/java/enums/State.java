package enums;

public enum State {
    HARYANA, RAJASTHAN, NCR;

    @Override
    public String toString(){
        return  this.name().substring(0,1) + this.name().substring(1).toLowerCase();
    }
}
