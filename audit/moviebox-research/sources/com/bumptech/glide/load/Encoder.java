package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Encoder<T> {
    boolean encode(@NonNull T t11, @NonNull File file, @NonNull Options options);
}
