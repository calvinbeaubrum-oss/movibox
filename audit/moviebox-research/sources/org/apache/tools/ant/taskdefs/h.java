package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface h {
    void a(InputStream inputStream) throws IOException;

    void b(OutputStream outputStream) throws IOException;

    void c(InputStream inputStream) throws IOException;

    void start() throws IOException;

    void stop();
}
