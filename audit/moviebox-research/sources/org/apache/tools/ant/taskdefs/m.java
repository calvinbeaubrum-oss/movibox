package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread f72817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f72818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StreamPumper f72819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OutputStream f72820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OutputStream f72821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InputStream f72822f;

    public m(OutputStream outputStream) {
        this(outputStream, outputStream);
    }

    public m(OutputStream outputStream, OutputStream outputStream2) {
        this(outputStream, outputStream2, null);
    }

    public m(OutputStream outputStream, OutputStream outputStream2, InputStream inputStream) {
        this.f72820d = outputStream;
        this.f72821e = outputStream2;
        this.f72822f = inputStream;
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void a(InputStream inputStream) {
        OutputStream outputStream = this.f72821e;
        if (outputStream != null) {
            e(inputStream, outputStream);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void b(OutputStream outputStream) {
        InputStream inputStream = this.f72822f;
        if (inputStream != null) {
            this.f72819c = d(inputStream, outputStream, true);
        } else {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void c(InputStream inputStream) {
        f(inputStream, this.f72820d);
    }

    public StreamPumper d(InputStream inputStream, OutputStream outputStream, boolean z11) {
        StreamPumper streamPumper = new StreamPumper(inputStream, outputStream, z11);
        streamPumper.setAutoflush(true);
        return streamPumper;
    }

    public void e(InputStream inputStream, OutputStream outputStream) {
        this.f72818b = g(inputStream, outputStream);
    }

    public void f(InputStream inputStream, OutputStream outputStream) {
        this.f72817a = g(inputStream, outputStream);
    }

    public Thread g(InputStream inputStream, OutputStream outputStream) {
        return h(inputStream, outputStream, false);
    }

    public Thread h(InputStream inputStream, OutputStream outputStream, boolean z11) {
        Thread thread = new Thread(new StreamPumper(inputStream, outputStream, z11));
        thread.setDaemon(true);
        return thread;
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void start() {
        this.f72817a.start();
        this.f72818b.start();
        if (this.f72819c != null) {
            Thread thread = new Thread(this.f72819c);
            thread.setDaemon(true);
            thread.start();
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void stop() {
        try {
            this.f72817a.join();
        } catch (InterruptedException unused) {
        }
        try {
            this.f72818b.join();
        } catch (InterruptedException unused2) {
        }
        StreamPumper streamPumper = this.f72819c;
        if (streamPumper != null) {
            streamPumper.stop();
        }
        try {
            this.f72821e.flush();
        } catch (IOException unused3) {
        }
        try {
            this.f72820d.flush();
        } catch (IOException unused4) {
        }
    }
}
