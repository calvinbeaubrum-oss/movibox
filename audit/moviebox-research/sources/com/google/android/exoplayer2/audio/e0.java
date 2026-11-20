package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 extends v {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f32820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f32821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final short f32822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f32823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f32824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f32825n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f32826o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f32827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f32828q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f32829r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f32830s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f32831t;

    public e0() {
        this(150000L, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, (short) 1024);
    }

    public e0(long j11, long j12, short s11) {
        com.google.android.exoplayer2.util.a.a(j12 <= j11);
        this.f32820i = j11;
        this.f32821j = j12;
        this.f32822k = s11;
        byte[] bArr = o0.f35613f;
        this.f32825n = bArr;
        this.f32826o = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.v
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f32705c == 2) {
            return this.f32824m ? aVar : AudioProcessor.a.f32702e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void d() {
        if (this.f32824m) {
            this.f32823l = this.f32948b.f32706d;
            int iH = h(this.f32820i) * this.f32823l;
            if (this.f32825n.length != iH) {
                this.f32825n = new byte[iH];
            }
            int iH2 = h(this.f32821j) * this.f32823l;
            this.f32829r = iH2;
            if (this.f32826o.length != iH2) {
                this.f32826o = new byte[iH2];
            }
        }
        this.f32827p = 0;
        this.f32831t = 0L;
        this.f32828q = 0;
        this.f32830s = false;
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void e() {
        int i11 = this.f32828q;
        if (i11 > 0) {
            m(this.f32825n, i11);
        }
        if (this.f32830s) {
            return;
        }
        this.f32831t += (long) (this.f32829r / this.f32823l);
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void f() {
        this.f32824m = false;
        this.f32829r = 0;
        byte[] bArr = o0.f35613f;
        this.f32825n = bArr;
        this.f32826o = bArr;
    }

    public final int h(long j11) {
        return (int) ((j11 * ((long) this.f32948b.f32703a)) / 1000000);
    }

    public final int i(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.f32822k);
        int i11 = this.f32823l;
        return ((iLimit / i11) * i11) + i11;
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f32824m;
    }

    public final int j(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.f32822k) {
                int i11 = this.f32823l;
                return i11 * (iPosition / i11);
            }
        }
        return byteBuffer.limit();
    }

    public long k() {
        return this.f32831t;
    }

    public final void l(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        g(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.f32830s = true;
        }
    }

    public final void m(byte[] bArr, int i11) {
        g(i11).put(bArr, 0, i11).flip();
        if (i11 > 0) {
            this.f32830s = true;
        }
    }

    public final void n(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iJ = j(byteBuffer);
        int iPosition = iJ - byteBuffer.position();
        byte[] bArr = this.f32825n;
        int length = bArr.length;
        int i11 = this.f32828q;
        int i12 = length - i11;
        if (iJ < iLimit && iPosition < i12) {
            m(bArr, i11);
            this.f32828q = 0;
            this.f32827p = 0;
            return;
        }
        int iMin = Math.min(iPosition, i12);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f32825n, this.f32828q, iMin);
        int i13 = this.f32828q + iMin;
        this.f32828q = i13;
        byte[] bArr2 = this.f32825n;
        if (i13 == bArr2.length) {
            if (this.f32830s) {
                m(bArr2, this.f32829r);
                this.f32831t += (long) ((this.f32828q - (this.f32829r * 2)) / this.f32823l);
            } else {
                this.f32831t += (long) ((i13 - this.f32829r) / this.f32823l);
            }
            r(byteBuffer, this.f32825n, this.f32828q);
            this.f32828q = 0;
            this.f32827p = 2;
        }
        byteBuffer.limit(iLimit);
    }

    public final void o(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f32825n.length));
        int i11 = i(byteBuffer);
        if (i11 == byteBuffer.position()) {
            this.f32827p = 1;
        } else {
            byteBuffer.limit(i11);
            l(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    public final void p(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iJ = j(byteBuffer);
        byteBuffer.limit(iJ);
        this.f32831t += (long) (byteBuffer.remaining() / this.f32823l);
        r(byteBuffer, this.f32826o, this.f32829r);
        if (iJ < iLimit) {
            m(this.f32826o, this.f32829r);
            this.f32827p = 0;
            byteBuffer.limit(iLimit);
        }
    }

    public void q(boolean z11) {
        this.f32824m = z11;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !b()) {
            int i11 = this.f32827p;
            if (i11 == 0) {
                o(byteBuffer);
            } else if (i11 == 1) {
                n(byteBuffer);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException();
                }
                p(byteBuffer);
            }
        }
    }

    public final void r(ByteBuffer byteBuffer, byte[] bArr, int i11) {
        int iMin = Math.min(byteBuffer.remaining(), this.f32829r);
        int i12 = this.f32829r - iMin;
        System.arraycopy(bArr, i11 - i12, this.f32826o, 0, i12);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f32826o, i12, iMin);
    }
}
