package sl;

import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f76378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Timer f76379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.firebase.perf.metrics.j f76380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f76381d = -1;

    public b(OutputStream outputStream, com.google.firebase.perf.metrics.j jVar, Timer timer) {
        this.f76378a = outputStream;
        this.f76380c = jVar;
        this.f76379b = timer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long j11 = this.f76381d;
        if (j11 != -1) {
            this.f76380c.l(j11);
        }
        this.f76380c.p(this.f76379b.getDurationMicros());
        try {
            this.f76378a.close();
        } catch (IOException e11) {
            this.f76380c.q(this.f76379b.getDurationMicros());
            j.d(this.f76380c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.f76378a.flush();
        } catch (IOException e11) {
            this.f76380c.q(this.f76379b.getDurationMicros());
            j.d(this.f76380c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i11) throws IOException {
        try {
            this.f76378a.write(i11);
            long j11 = this.f76381d + 1;
            this.f76381d = j11;
            this.f76380c.l(j11);
        } catch (IOException e11) {
            this.f76380c.q(this.f76379b.getDurationMicros());
            j.d(this.f76380c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.f76378a.write(bArr);
            long length = this.f76381d + ((long) bArr.length);
            this.f76381d = length;
            this.f76380c.l(length);
        } catch (IOException e11) {
            this.f76380c.q(this.f76379b.getDurationMicros());
            j.d(this.f76380c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) throws IOException {
        try {
            this.f76378a.write(bArr, i11, i12);
            long j11 = this.f76381d + ((long) i12);
            this.f76381d = j11;
            this.f76380c.l(j11);
        } catch (IOException e11) {
            this.f76380c.q(this.f76379b.getDurationMicros());
            j.d(this.f76380c);
            throw e11;
        }
    }
}
