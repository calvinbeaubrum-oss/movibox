package com.bytedance.adsdk.sc.pFF.ExN.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private static Object sc(double d11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(d11 < ((double) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(d11 < ((double) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(d11 < ((double) number.floatValue()));
        }
        if (number instanceof Double) {
            return Boolean.valueOf(d11 < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object sc(float f11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(f11 < ((float) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(f11 < ((float) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(f11 < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) f11) < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object sc(int i11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(i11 < number.intValue());
        }
        if (number instanceof Long) {
            return Boolean.valueOf(((long) i11) < number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) i11) < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) i11) < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object sc(long j11, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(j11 < ((long) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(j11 < number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) j11) < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) j11) < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static Object sc(Object obj, Number number) {
        if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            return sc(((Number) obj).intValue(), number);
        }
        if (obj instanceof Long) {
            return sc(((Long) obj).longValue(), number);
        }
        if (obj instanceof Float) {
            return sc(((Float) obj).floatValue(), number);
        }
        if (obj instanceof Double) {
            return sc(((Double) obj).doubleValue(), number);
        }
        if (!(obj instanceof String)) {
            throw new UnsupportedOperationException(obj.getClass().getName() + "This type of addition operation is not supported");
        }
        try {
            return sc(Float.parseFloat((String) obj), number);
        } catch (NumberFormatException unused) {
            throw new UnsupportedOperationException(obj.getClass().getName() + "This type of addition operation is not supported");
        }
    }
}
