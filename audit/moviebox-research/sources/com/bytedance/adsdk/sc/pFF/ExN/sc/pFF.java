package com.bytedance.adsdk.sc.pFF.ExN.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private static boolean sc(double d11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return d11 == ((double) number.intValue());
        }
        if (number instanceof Long) {
            return d11 == ((double) number.longValue());
        }
        if (number instanceof Float) {
            return d11 == ((double) number.floatValue());
        }
        if (number instanceof Double) {
            return d11 == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static boolean sc(float f11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return f11 == ((float) number.intValue());
        }
        if (number instanceof Long) {
            return f11 == ((float) number.longValue());
        }
        if (number instanceof Float) {
            return f11 == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) f11) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static boolean sc(int i11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return i11 == number.intValue();
        }
        if (number instanceof Long) {
            return ((long) i11) == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) i11) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) i11) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static boolean sc(long j11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return j11 == ((long) number.intValue());
        }
        if (number instanceof Long) {
            return j11 == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) j11) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) j11) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static boolean sc(Number number, Number number2) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return sc(number.intValue(), number2);
        }
        if (number instanceof Long) {
            return sc(number.longValue(), number2);
        }
        if (number instanceof Float) {
            return sc(number.floatValue(), number2);
        }
        if (number instanceof Double) {
            return sc(number.doubleValue(), number2);
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }
}
