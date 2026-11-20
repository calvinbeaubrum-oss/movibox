package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset cset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final a listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file, a aVar) {
        this(file, aVar, 1000L);
    }

    public Tailer(File file, a aVar, long j11) {
        this(file, aVar, j11, false);
    }

    public Tailer(File file, a aVar, long j11, boolean z11) {
        this(file, aVar, j11, z11, 4096);
    }

    public Tailer(File file, a aVar, long j11, boolean z11, int i11) {
        this(file, aVar, j11, z11, false, i11);
    }

    public Tailer(File file, a aVar, long j11, boolean z11, boolean z12) {
        this(file, aVar, j11, z11, z12, 4096);
    }

    public Tailer(File file, a aVar, long j11, boolean z11, boolean z12, int i11) {
        this(file, DEFAULT_CHARSET, aVar, j11, z11, z12, i11);
    }

    public Tailer(File file, Charset charset, a aVar, long j11, boolean z11, boolean z12, int i11) {
        this.run = true;
        this.file = file;
        this.delayMillis = j11;
        this.end = z11;
        this.inbuf = new byte[i11];
        this.listener = aVar;
        aVar.d(this);
        this.reOpen = z12;
        this.cset = charset;
    }

    public static Tailer create(File file, a aVar) {
        return create(file, aVar, 1000L, false);
    }

    public static Tailer create(File file, a aVar, long j11) {
        return create(file, aVar, j11, false);
    }

    public static Tailer create(File file, a aVar, long j11, boolean z11) {
        return create(file, aVar, j11, z11, 4096);
    }

    public static Tailer create(File file, a aVar, long j11, boolean z11, int i11) {
        return create(file, aVar, j11, z11, false, i11);
    }

    public static Tailer create(File file, a aVar, long j11, boolean z11, boolean z12) {
        return create(file, aVar, j11, z11, z12, 4096);
    }

    public static Tailer create(File file, a aVar, long j11, boolean z11, boolean z12, int i11) {
        return create(file, DEFAULT_CHARSET, aVar, j11, z11, z12, i11);
    }

    public static Tailer create(File file, Charset charset, a aVar, long j11, boolean z11, boolean z12, int i11) {
        Tailer tailer = new Tailer(file, charset, aVar, j11, z11, z12, i11);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int i11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        try {
            long filePointer = randomAccessFile.getFilePointer();
            long filePointer2 = filePointer;
            boolean z11 = false;
            while (getRun() && (i11 = randomAccessFile.read(this.inbuf)) != -1) {
                for (int i12 = 0; i12 < i11; i12++) {
                    byte b11 = this.inbuf[i12];
                    if (b11 == 10) {
                        this.listener.e(new String(byteArrayOutputStream.toByteArray(), this.cset));
                        byteArrayOutputStream.reset();
                        filePointer = ((long) i12) + filePointer2 + 1;
                        z11 = false;
                    } else if (b11 != 13) {
                        if (z11) {
                            this.listener.e(new String(byteArrayOutputStream.toByteArray(), this.cset));
                            byteArrayOutputStream.reset();
                            filePointer = ((long) i12) + filePointer2 + 1;
                            z11 = false;
                        }
                        byteArrayOutputStream.write(b11);
                    } else {
                        if (z11) {
                            byteArrayOutputStream.write(13);
                        }
                        z11 = true;
                    }
                }
                filePointer2 = randomAccessFile.getFilePointer();
            }
            randomAccessFile.seek(filePointer);
            a aVar = this.listener;
            if (aVar instanceof b) {
                ((b) aVar).f();
            }
            byteArrayOutputStream.close();
            return filePointer;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th2.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public long getDelay() {
        return this.delayMillis;
    }

    public File getFile() {
        return this.file;
    }

    public boolean getRun() {
        return this.run;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        RandomAccessFile randomAccessFile;
        long lines;
        long jLastModified;
        RandomAccessFile randomAccessFile2 = null;
        long jLastModified2 = 0;
        long length = 0;
        while (getRun() && randomAccessFile2 == null) {
            try {
                try {
                    try {
                        randomAccessFile2 = new RandomAccessFile(this.file, "r");
                    } catch (FileNotFoundException unused) {
                        this.listener.b();
                    }
                    if (randomAccessFile2 == null) {
                        Thread.sleep(this.delayMillis);
                    } else {
                        length = this.end ? this.file.length() : 0L;
                        jLastModified2 = this.file.lastModified();
                        randomAccessFile2.seek(length);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (InterruptedException e11) {
                e = e11;
            } catch (Exception e12) {
                e = e12;
            }
        }
        while (getRun()) {
            boolean zB = c.b(this.file, jLastModified2);
            long length2 = this.file.length();
            if (length2 < length) {
                this.listener.c();
                try {
                    randomAccessFile = new RandomAccessFile(this.file, "r");
                    try {
                        try {
                            readLines(randomAccessFile2);
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Throwable th5) {
                                        try {
                                            th.addSuppressed(th5);
                                        } catch (FileNotFoundException unused2) {
                                            randomAccessFile2 = randomAccessFile;
                                            this.listener.b();
                                            Thread.sleep(this.delayMillis);
                                        }
                                    }
                                }
                                throw th4;
                            }
                        }
                    } catch (IOException e13) {
                        this.listener.a(e13);
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            try {
                                randomAccessFile2.close();
                            } catch (FileNotFoundException unused3) {
                                length = 0;
                                randomAccessFile2 = randomAccessFile;
                                this.listener.b();
                                Thread.sleep(this.delayMillis);
                            }
                        } catch (InterruptedException e14) {
                            e = e14;
                            randomAccessFile2 = randomAccessFile;
                            Thread.currentThread().interrupt();
                            this.listener.a(e);
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e15) {
                                    e = e15;
                                    this.listener.a(e);
                                }
                            }
                            stop();
                        } catch (Exception e16) {
                            e = e16;
                            randomAccessFile2 = randomAccessFile;
                            this.listener.a(e);
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e17) {
                                    e = e17;
                                    this.listener.a(e);
                                }
                            }
                            stop();
                        } catch (Throwable th6) {
                            th = th6;
                            randomAccessFile2 = randomAccessFile;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e18) {
                                    this.listener.a(e18);
                                }
                            }
                            stop();
                            throw th;
                        }
                    }
                    length = 0;
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th7) {
                    th = th7;
                    randomAccessFile = randomAccessFile2;
                }
            } else {
                if (length2 > length) {
                    lines = readLines(randomAccessFile2);
                    jLastModified = this.file.lastModified();
                } else if (zB) {
                    randomAccessFile2.seek(0L);
                    lines = readLines(randomAccessFile2);
                    jLastModified = this.file.lastModified();
                } else {
                    if (this.reOpen && randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    Thread.sleep(this.delayMillis);
                    if (!getRun() && this.reOpen) {
                        randomAccessFile = new RandomAccessFile(this.file, "r");
                        randomAccessFile.seek(length);
                        randomAccessFile2 = randomAccessFile;
                    }
                }
                long j11 = lines;
                jLastModified2 = jLastModified;
                length = j11;
                if (this.reOpen) {
                    randomAccessFile2.close();
                }
                Thread.sleep(this.delayMillis);
                if (!getRun()) {
                }
            }
        }
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (IOException e19) {
                e = e19;
                this.listener.a(e);
            }
        }
        stop();
    }

    public void stop() {
        this.run = false;
    }
}
