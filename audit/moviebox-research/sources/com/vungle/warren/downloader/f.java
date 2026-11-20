package com.vungle.warren.downloader;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface f {
    @NonNull
    File a(@NonNull String str) throws IOException;

    void b(@NonNull File file, long j11);

    void c(@NonNull File file, long j11);

    void clear();

    @NonNull
    File d(@NonNull File file);

    boolean deleteContents(@NonNull File file);

    void e(@NonNull File file);

    void f(@NonNull File file);

    boolean g(@NonNull File file);

    @NonNull
    List<File> h();

    void init();
}
