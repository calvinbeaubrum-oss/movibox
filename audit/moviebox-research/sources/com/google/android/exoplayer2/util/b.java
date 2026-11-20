package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f35539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f35540b;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileOutputStream f35541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f35542b = false;

        public a(File file) throws FileNotFoundException {
            this.f35541a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f35542b) {
                return;
            }
            this.f35542b = true;
            flush();
            try {
                this.f35541a.getFD().sync();
            } catch (IOException e11) {
                s.j("AtomicFile", "Failed to sync file descriptor:", e11);
            }
            this.f35541a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f35541a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i11) throws IOException {
            this.f35541a.write(i11);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f35541a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f35541a.write(bArr, i11, i12);
        }
    }

    public b(File file) {
        this.f35539a = file;
        this.f35540b = new File(file.getPath() + ".bak");
    }

    public void a() {
        this.f35539a.delete();
        this.f35540b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f35540b.delete();
    }

    public boolean c() {
        return this.f35539a.exists() || this.f35540b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f35539a);
    }

    public final void e() {
        if (this.f35540b.exists()) {
            this.f35539a.delete();
            this.f35540b.renameTo(this.f35539a);
        }
    }

    public OutputStream f() throws IOException {
        if (this.f35539a.exists()) {
            if (this.f35540b.exists()) {
                this.f35539a.delete();
            } else if (!this.f35539a.renameTo(this.f35540b)) {
                s.i("AtomicFile", "Couldn't rename file " + this.f35539a + " to backup file " + this.f35540b);
            }
        }
        try {
            return new a(this.f35539a);
        } catch (FileNotFoundException e11) {
            File parentFile = this.f35539a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f35539a, e11);
            }
            try {
                return new a(this.f35539a);
            } catch (FileNotFoundException e12) {
                throw new IOException("Couldn't create " + this.f35539a, e12);
            }
        }
    }
}
