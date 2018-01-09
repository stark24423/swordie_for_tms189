package enums;

/**
 * Created on 1/6/2018.
 */
public enum EnterType {
    NO_ANIMATION(0),
    ANIMATION(1);

    private byte val;

    EnterType(int val) {
        this.val = (byte) val;
    }

    public byte getVal() {
        return val;
    }
}
