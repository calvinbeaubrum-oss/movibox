package com.bumptech.glide.repackaged.com.google.common.collect;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class Platform {
    public static <T> T[] newArray(T[] tArr, int i11) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11));
    }
}
