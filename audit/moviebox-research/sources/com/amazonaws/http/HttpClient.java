package com.amazonaws.http;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface HttpClient {
    HttpResponse a(HttpRequest httpRequest) throws IOException;

    void shutdown();
}
