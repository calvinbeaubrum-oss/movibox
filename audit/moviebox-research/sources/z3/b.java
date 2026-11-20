package z3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f81753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f81754b;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileOutputStream f81755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f81756b = false;

        public a(File file) throws FileNotFoundException {
            this.f81755a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f81756b) {
                return;
            }
            this.f81756b = true;
            flush();
            try {
                this.f81755a.getFD().sync();
            } catch (IOException e11) {
                o.i("AtomicFile", "Failed to sync file descriptor:", e11);
            }
            this.f81755a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f81755a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i11) throws IOException {
            this.f81755a.write(i11);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f81755a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f81755a.write(bArr, i11, i12);
        }
    }

    public b(File file) {
        this.f81753a = file;
        this.f81754b = new File(file.getPath() + ".bak");
    }

    public void a() {
        this.f81753a.delete();
        this.f81754b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f81754b.delete();
    }

    public boolean c() {
        return this.f81753a.exists() || this.f81754b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f81753a);
    }

    public final void e() {
        if (this.f81754b.exists()) {
            this.f81753a.delete();
            this.f81754b.renameTo(this.f81753a);
        }
    }

    public OutputStream f() throws IOException {
        if (this.f81753a.exists()) {
            if (this.f81754b.exists()) {
                this.f81753a.delete();
            } else if (!this.f81753a.renameTo(this.f81754b)) {
                o.h("AtomicFile", "Couldn't rename file " + this.f81753a + " to backup file " + this.f81754b);
            }
        }
        try {
            return new a(this.f81753a);
        } catch (FileNotFoundException e11) {
            File parentFile = this.f81753a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f81753a, e11);
            }
            try {
                return new a(this.f81753a);
            } catch (FileNotFoundException e12) {
                throw new IOException("Couldn't create " + this.f81753a, e12);
            }
        }
    }
}
