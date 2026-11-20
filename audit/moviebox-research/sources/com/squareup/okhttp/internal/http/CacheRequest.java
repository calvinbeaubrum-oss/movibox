package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
