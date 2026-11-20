package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DataRewinder<T> {

    /* JADX INFO: compiled from: source.java */
    public interface Factory<T> {
        @NonNull
        DataRewinder<T> build(@NonNull T t11);

        @NonNull
        Class<T> getDataClass();
    }

    void cleanup();

    @NonNull
    T rewindAndGet() throws IOException;
}
