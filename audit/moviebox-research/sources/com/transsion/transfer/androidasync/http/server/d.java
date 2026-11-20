package com.transsion.transfer.androidasync.http.server;

import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.u;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface d extends u, fy.a {
    String C();

    int b();

    d d(int i11);

    @Override // com.transsion.transfer.androidasync.u
    void f();

    Headers getHeaders();

    void send(String str);

    void u();

    void z(File file, fy.e eVar);
}
