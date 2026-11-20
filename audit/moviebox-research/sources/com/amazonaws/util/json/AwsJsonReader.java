package com.amazonaws.util.json;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AwsJsonReader {
    void a() throws IOException;

    void c() throws IOException;

    void close() throws IOException;

    void d() throws IOException;

    boolean e() throws IOException;

    String f() throws IOException;

    String g() throws IOException;

    boolean hasNext() throws IOException;

    AwsJsonToken peek() throws IOException;
}
