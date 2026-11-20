package com.google.android.gms.common.data;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Freezable<T> {
    @NonNull
    T freeze();

    boolean isDataValid();
}
