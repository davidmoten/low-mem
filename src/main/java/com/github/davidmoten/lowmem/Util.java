package com.github.davidmoten.lowmem;

public final class Util {

    static int makeInt(byte a, byte b, byte c, byte d) {
        return (((a) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | ((d & 0xff)));
    }

    static long makeLong(byte a, byte b, byte c, byte d, byte e, byte f, byte g, byte h) {
        return ((((long) a) << 56) | (((long) b & 0xff) << 48) | (((long) c & 0xff) << 40)
                | (((long) d & 0xff) << 32) | (((long) e & 0xff) << 24) | (((long) f & 0xff) << 16)
                | (((long) g & 0xff) << 8) | (((long) h & 0xff)));
    }

    public static int getInt(byte a, byte b, byte c, byte d, boolean bigEndian) {
        if (bigEndian)
            return makeInt(a, b, c, d);
        else
            return makeInt(d, c, b, a);
    }

    public static int getInt(byte a, byte b, byte c, byte d) {
        return getInt(a, b, c, d, true);
    }

    public static long getLong(byte a, byte b, byte c, byte d, byte e, byte f, byte g, byte h,
            boolean bigEndian) {
        if (bigEndian)
            return makeLong(a, b, c, d, e, f, g, h);
        else
            return makeLong(h, g, f, e, d, c, b, a);
    }

    public static float getFloat(byte a, byte b, byte c, byte d, boolean bigEndian) {
        return Float.intBitsToFloat(getInt(a, b, c, d, bigEndian));
    }

    public static float getFloat(byte a, byte b, byte c, byte d) {
        return getFloat(a, b, c, d, true);
    }

    public static double getDouble(byte a, byte b, byte c, byte d, byte e, byte f, byte g, byte h,
            boolean bigEndian) {
        return Double.longBitsToDouble(getLong(a, b, c, d, e, f, g, h, bigEndian));
    }
}
