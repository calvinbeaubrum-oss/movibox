package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class StreamPumper implements Runnable {
    private static final int SMALL_BUFFER_SIZE = 128;
    private boolean autoflush;
    private int bufferSize;
    private boolean closeWhenExhausted;
    private Exception exception;
    private volatile boolean finish;
    private volatile boolean finished;

    /* JADX INFO: renamed from: is, reason: collision with root package name */
    private InputStream f72748is;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    private OutputStream f72749os;
    private boolean started;

    public StreamPumper(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, false);
    }

    public StreamPumper(InputStream inputStream, OutputStream outputStream, boolean z11) {
        this.autoflush = false;
        this.exception = null;
        this.bufferSize = 128;
        this.started = false;
        this.f72748is = inputStream;
        this.f72749os = outputStream;
        this.closeWhenExhausted = z11;
    }

    public synchronized int getBufferSize() {
        return this.bufferSize;
    }

    public synchronized Exception getException() {
        return this.exception;
    }

    public boolean isFinished() {
        return this.finished;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.started = true;
        }
        this.finished = false;
        this.finish = false;
        byte[] bArr = new byte[this.bufferSize];
        while (true) {
            try {
                try {
                    int i11 = this.f72748is.read(bArr);
                    if (i11 <= 0 || this.finish) {
                        break;
                    }
                    this.f72749os.write(bArr, 0, i11);
                    if (this.autoflush) {
                        this.f72749os.flush();
                    }
                } catch (Exception e11) {
                    synchronized (this) {
                        this.exception = e11;
                        if (this.closeWhenExhausted) {
                            try {
                                this.f72749os.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.finished = true;
                        synchronized (this) {
                            notifyAll();
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                if (this.closeWhenExhausted) {
                    try {
                        this.f72749os.close();
                    } catch (IOException unused2) {
                    }
                }
                this.finished = true;
                synchronized (this) {
                    notifyAll();
                    throw th2;
                }
            }
        }
        this.f72749os.flush();
        if (this.closeWhenExhausted) {
            try {
                this.f72749os.close();
            } catch (IOException unused3) {
            }
        }
        this.finished = true;
        synchronized (this) {
            notifyAll();
        }
    }

    public void setAutoflush(boolean z11) {
        this.autoflush = z11;
    }

    public synchronized void setBufferSize(int i11) {
        if (this.started) {
            throw new IllegalStateException("Cannot set buffer size on a running StreamPumper");
        }
        this.bufferSize = i11;
    }

    public synchronized void stop() {
        this.finish = true;
        notifyAll();
    }

    public synchronized void waitFor() throws InterruptedException {
        while (!isFinished()) {
            wait();
        }
    }
}
