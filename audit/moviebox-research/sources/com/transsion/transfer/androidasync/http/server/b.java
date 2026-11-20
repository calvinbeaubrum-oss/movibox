package com.transsion.transfer.androidasync.http.server;

import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface b extends com.transsion.transfer.androidasync.r {
    <T extends gy.a> T getBody();

    Headers getHeaders();

    String getMethod();

    String getPath();

    com.transsion.transfer.androidasync.l getSocket();

    Multimap j();
}
