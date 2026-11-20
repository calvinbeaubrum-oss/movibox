package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
interface ArrayAdapterInterface<T> {
    int getArrayLength(T t11);

    int getElementSizeInBytes();

    String getTag();

    T newArray(int i11);
}
