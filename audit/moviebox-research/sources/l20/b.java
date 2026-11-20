package l20;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f69765a = new byte[1];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f69766b = 0;

    public void a(int i11) {
        b(i11);
    }

    public void b(long j11) {
        if (j11 != -1) {
            this.f69766b += j11;
        }
    }

    public long c() {
        return this.f69766b;
    }

    public void d(long j11) {
        this.f69766b -= j11;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f69765a, 0, 1) == -1) {
            return -1;
        }
        return this.f69765a[0] & 255;
    }
}
