package com.vungle.warren.downloader;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface Downloader {

    /* JADX INFO: compiled from: source.java */
    public static class RequestException extends Exception {
        public RequestException(String str) {
            super(str);
        }
    }

    void a();

    void b();

    boolean c(String str);

    List<e> d();

    boolean e(@Nullable e eVar, long j11);

    void f(e eVar, a aVar);

    void g(boolean z11);

    void h(@Nullable e eVar);

    void i(e eVar);

    void init();
}
