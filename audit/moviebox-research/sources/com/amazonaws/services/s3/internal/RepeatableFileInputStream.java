package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class RepeatableFileInputStream extends SdkInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Log f15964f = LogFactory.c("RepeatableFIS");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f15965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileInputStream f15966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15967c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15968d = 0;

    public RepeatableFileInputStream(File file) throws FileNotFoundException {
        this.f15966b = null;
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        this.f15966b = new FileInputStream(file);
        this.f15965a = file;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        c();
        return this.f15966b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15966b.close();
        c();
    }

    @Override // com.amazonaws.internal.SdkInputStream
    public InputStream d() {
        return this.f15966b;
    }

    @Override // java.io.InputStream
    public void mark(int i11) {
        c();
        this.f15968d += this.f15967c;
        this.f15967c = 0L;
        Log log = f15964f;
        if (log.b()) {
            log.a("Input stream marked at " + this.f15968d + " bytes");
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        c();
        int i11 = this.f15966b.read();
        if (i11 == -1) {
            return -1;
        }
        this.f15967c++;
        return i11;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        c();
        int i13 = this.f15966b.read(bArr, i11, i12);
        this.f15967c += (long) i13;
        return i13;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f15966b.close();
        c();
        this.f15966b = new FileInputStream(this.f15965a);
        long jSkip = this.f15968d;
        while (jSkip > 0) {
            jSkip -= this.f15966b.skip(jSkip);
        }
        Log log = f15964f;
        if (log.b()) {
            log.a("Reset to mark point " + this.f15968d + " after returning " + this.f15967c + " bytes");
        }
        this.f15967c = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j11) throws IOException {
        c();
        long jSkip = this.f15966b.skip(j11);
        this.f15967c += jSkip;
        return jSkip;
    }
}
