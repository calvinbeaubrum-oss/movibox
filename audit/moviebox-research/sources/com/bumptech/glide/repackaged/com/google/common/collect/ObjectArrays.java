package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ObjectArrays {
    static final Object[] EMPTY_ARRAY = new Object[0];

    public static <T> T[] arraysCopyOf(T[] tArr, int i11) {
        T[] tArr2 = (T[]) newArray(tArr, i11);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(tArr.length, i11));
        return tArr2;
    }

    public static Object checkElementNotNull(Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i11);
    }

    public static Object[] checkElementsNotNull(Object... objArr) {
        return checkElementsNotNull(objArr, objArr.length);
    }

    public static Object[] checkElementsNotNull(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            checkElementNotNull(objArr[i12], i12);
        }
        return objArr;
    }

    public static <T> T[] newArray(T[] tArr, int i11) {
        return (T[]) Platform.newArray(tArr, i11);
    }
}
