package fh;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f64916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f64917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f64918c;

    public final long a(long j11) {
        return this.f64916a + Math.max(0L, ((this.f64917b - 529) * 1000000) / j11);
    }

    public long b(m1 m1Var) {
        return a(m1Var.A);
    }

    public void c() {
        this.f64916a = 0L;
        this.f64917b = 0L;
        this.f64918c = false;
    }

    public long d(m1 m1Var, DecoderInputBuffer decoderInputBuffer) {
        if (this.f64917b == 0) {
            this.f64916a = decoderInputBuffer.f33032f;
        }
        if (this.f64918c) {
            return decoderInputBuffer.f33032f;
        }
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(decoderInputBuffer.f33030c);
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            i11 = (i11 << 8) | (byteBuffer.get(i12) & 255);
        }
        int iM = b0.m(i11);
        if (iM != -1) {
            long jA = a(m1Var.A);
            this.f64917b += (long) iM;
            return jA;
        }
        this.f64918c = true;
        this.f64917b = 0L;
        this.f64916a = decoderInputBuffer.f33032f;
        s.i("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return decoderInputBuffer.f33032f;
    }
}
