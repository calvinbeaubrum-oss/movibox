package com.bytedance.adsdk.sc.pFF.ExN.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private static Object sc(double d11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Double.valueOf(d11 / ((double) number.intValue()));
        }
        if (number instanceof Long) {
            return Double.valueOf(d11 / number.longValue());
        }
        if (number instanceof Float) {
            return Double.valueOf(d11 / ((double) number.floatValue()));
        }
        if (number instanceof Double) {
            return Double.valueOf(d11 / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object sc(float f11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Float.valueOf(f11 / number.intValue());
        }
        if (number instanceof Long) {
            return Float.valueOf(f11 / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(f11 / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(((double) f11) / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object sc(int i11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i11 / number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(((long) i11) / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i11 / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(((double) i11) / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object sc(long j11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Long.valueOf(j11 / ((long) number.intValue()));
        }
        if (number instanceof Long) {
            return Long.valueOf(j11 / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(j11 / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(j11 / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static Object sc(Number number, Number number2) {
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
