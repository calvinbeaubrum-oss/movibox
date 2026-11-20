package com.vungle.warren.persistence;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface d {
    void a();

    File c(String str) throws IllegalStateException;

    void d(String str) throws IOException;

    File getCacheDirectory() throws IllegalStateException;
}
