package sl;

import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f76372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.firebase.perf.metrics.j f76373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Timer f76374c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f76376f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f76375d = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f76377g = -1;

    public a(InputStream inputStream, com.google.firebase.perf.metrics.j jVar, Timer timer) {
        this.f76374c = timer;
        this.f76372a = inputStream;
        this.f76373b = jVar;
        this.f76376f = jVar.e();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f76372a.available();
        } catch (IOException e11) {
            this.f76373b.q(this.f76374c.getDurationMicros());
            j.d(this.f76373b);
            throw e11;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long durationMicros = this.f76374c.getDurationMicros();
        if (this.f76377g == -1) {
            this.f76377g = durationMicros;
        }
        try {
            this.f76372a.close();
            long j11 = this.f76375d;
            if (j11 != -1) {
                this.f76373b.o(j11);
            }
            long j12 = this.f76376f;
            if (j12 != -1) {
                this.f76373b.r(j12);
            }
            this.f76373b.q(this.f76377g);
            this.f76373b.c();
        } catch (IOException e11) {
            this.f76373b.q(this.f76374c.getDurationMicros());
            j.d(this.f76373b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i11) {
        this.f76372a.mark(i11);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f76372a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int i11 = this.f76372a.read();
            long durationMicros = this.f76374c.getDurationMicros();
            if (this.f76376f == -1) {
                this.f76376f = durationMicros;
            }
            if (i11 == -1 && this.f76377g == -1) {
                this.f76377g = durationMicros;
                this.f76373b.q(durationMicros);
                this.f76373b.c();
            } else {
                long j11 = this.f76375d + 1;
                this.f76375d = j11;
                this.f76373b.o(j11);
            }
            return i11;
        } catch (IOException e11) {
            this.f76373b.q(this.f76374c.getDurationMicros());
            j.d(this.f76373b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int i11 = this.f76372a.read(bArr);
            long durationMicros = this.f76374c.getDurationMicros();
            if (this.f76376f == -1) {
                this.f76376f = durationMicros;
            }
            if (i11 == -1 && this.f76377g == -1) {
                this.f76377g = durationMicros;
                this.f76373b.q(durationMicros);
                this.f76373b.c();
            } else {
                long j11 = this.f76375d + ((long) i11);
                this.f76375d = j11;
                this.f76373b.o(j11);
            }
            return i11;
        } catch (IOException e11) {
            this.f76373b.q(this.f76374c.getDurationMicros());
            j.d(this.f76373b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        try {
            int i13 = this.f76372a.read(bArr, i11, i12);
            long durationMicros = this.f76374c.getDurationMicros();
            if (this.f76376f == -1) {
                this.f76376f = durationMicros;
            }
            if (i13 == -1 && this.f76377g == -1) {
                this.f76377g = durationMicros;
                this.f76373b.q(durationMicros);
                this.f76373b.c();
            } else {
                long j11 = this.f76375d + ((long) i13);
                this.f76375d = j11;
                this.f76373b.o(j11);
            }
            return i13;
        } catch (IOException e11) {
            this.f76373b.q(this.f76374c.getDurationMicros());
            j.d(this.f76373b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        try {
            this.f76372a.reset();
        } catch (IOException e11) {
            this.f76373b.q(this.f76374c.getDurationMicros());
            j.d(this.f76373b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j11) throws IOException {
        try {
            long jSkip = this.f76372a.skip(j11);
            long durationMicros = this.f76374c.getDurationMicros();
            if (this.f76376f == -1) {
                this.f76376f = durationMicros;
            }
            if (jSkip == -1 && this.f76377g == -1) {
                this.f76377g = durationMicros;
                this.f76373b.q(durationMicros);
            } else {
                long j12 = this.f76375d + jSkip;
                this.f76375d = j12;
                this.f76373b.o(j12);
            }
            return jSkip;
        } catch (IOException e11) {
            this.f76373b.q(this.f76374c.getDurationMicros());
            j.d(this.f76373b);
            throw e11;
        }
    }
}
