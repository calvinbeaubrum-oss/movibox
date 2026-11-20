package f4;

import androidx.media3.common.audio.AudioProcessor;
import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p1 extends androidx.media3.common.audio.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f64578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short f64579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f64580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f64581l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f64582m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AudioProcessor.a f64583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f64584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f64585p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f64586q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f64587r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f64588s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte[] f64589t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f64590u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f64591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f64592w;

    public p1() {
        this(100000L, 0.2f, 2000000L, 10, (short) 1024);
    }

    public p1(long j11, float f11, long j12, int i11, short s11) {
        boolean z11 = false;
        this.f64588s = 0;
        this.f64590u = 0;
        this.f64591v = 0;
        if (f11 >= 0.0f && f11 <= 1.0f) {
            z11 = true;
        }
        z3.a.a(z11);
        this.f64581l = j11;
        this.f64578i = f11;
        this.f64582m = j12;
        this.f64580k = i11;
        this.f64579j = s11;
        this.f64583n = AudioProcessor.a.f8909e;
        byte[] bArr = z3.u0.f81843f;
        this.f64589t = bArr;
        this.f64592w = bArr;
    }

    public static int A(byte b11, byte b12) {
        return (b11 << 8) | (b12 & 255);
    }

    public static void x(byte[] bArr, int i11, int i12) {
        if (i12 >= 32767) {
            bArr[i11] = -1;
            bArr[i11 + 1] = Ascii.DEL;
        } else if (i12 <= -32768) {
            bArr[i11] = 0;
            bArr[i11 + 1] = -128;
        } else {
            bArr[i11] = (byte) (i12 & 255);
            bArr[i11 + 1] = (byte) (i12 >> 8);
        }
    }

    @Override // androidx.media3.common.audio.b
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f8912c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.f64583n = aVar;
        this.f64584o = aVar.f8911b * 2;
        return aVar;
    }

    @Override // androidx.media3.common.audio.b
    public void d() {
        int i11;
        if (isActive() && this.f64589t.length != (i11 = i(m(this.f64581l) / 2) * 2)) {
            this.f64589t = new byte[i11];
            this.f64592w = new byte[i11];
        }
        this.f64586q = 0;
        this.f64587r = 0L;
        this.f64588s = 0;
        this.f64590u = 0;
        this.f64591v = 0;
    }

    @Override // androidx.media3.common.audio.b
    public void e() {
        if (this.f64591v > 0) {
            u(true);
            this.f64588s = 0;
        }
    }

    @Override // androidx.media3.common.audio.b
    public void f() {
        this.f64585p = false;
        this.f64583n = AudioProcessor.a.f8909e;
        byte[] bArr = z3.u0.f81843f;
        this.f64589t = bArr;
        this.f64592w = bArr;
    }

    public final int h(float f11) {
        return i((int) f11);
    }

    public final int i(int i11) {
        int i12 = this.f64584o;
        return (i11 / i12) * i12;
    }

    @Override // androidx.media3.common.audio.b, androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f64583n.f8910a != -1 && this.f64585p;
    }

    public final int j(int i11, int i12) {
        int i13 = this.f64580k;
        return i13 + ((((100 - i13) * (i11 * 1000)) / i12) / 1000);
    }

    public final int k(int i11, int i12) {
        return (((this.f64580k - 100) * ((i11 * 1000) / i12)) / 1000) + 100;
    }

    public final int l(int i11) {
        int iM = ((m(this.f64582m) - this.f64588s) * this.f64584o) - (this.f64589t.length / 2);
        z3.a.g(iM >= 0);
        return h(Math.min((i11 * this.f64578i) + 0.5f, iM));
    }

    public final int m(long j11) {
        return (int) ((j11 * ((long) this.f64583n.f8910a)) / 1000000);
    }

    public final int n(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (q(byteBuffer.get(iLimit), byteBuffer.get(iLimit - 1))) {
                int i11 = this.f64584o;
                return ((iLimit / i11) * i11) + i11;
            }
        }
        return byteBuffer.position();
    }

    public final int o(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (q(byteBuffer.get(iPosition), byteBuffer.get(iPosition - 1))) {
                int i11 = this.f64584o;
                return i11 * (iPosition / i11);
            }
        }
        return byteBuffer.limit();
    }

    public long p() {
        return this.f64587r;
    }

    public final boolean q(byte b11, byte b12) {
        return Math.abs(A(b11, b12)) > this.f64579j;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !b()) {
            int i11 = this.f64586q;
            if (i11 == 0) {
                w(byteBuffer);
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException();
                }
                z(byteBuffer);
            }
        }
    }

    public final void r(byte[] bArr, int i11, int i12) {
        if (i12 == 3) {
            return;
        }
        for (int i13 = 0; i13 < i11; i13 += 2) {
            x(bArr, i13, (A(bArr[i13 + 1], bArr[i13]) * (i12 == 0 ? k(i13, i11 - 1) : i12 == 2 ? j(i13, i11 - 1) : this.f64580k)) / 100);
        }
    }

    public final void s(ByteBuffer byteBuffer) {
        g(byteBuffer.remaining()).put(byteBuffer).flip();
    }

    public final void t(byte[] bArr, int i11, int i12) {
        z3.a.b(i11 % this.f64584o == 0, "byteOutput size is not aligned to frame size " + i11);
        r(bArr, i11, i12);
        g(i11).put(bArr, 0, i11).flip();
    }

    public final void u(boolean z11) {
        int length;
        int iL;
        int i11 = this.f64591v;
        byte[] bArr = this.f64589t;
        if (i11 == bArr.length || z11) {
            if (this.f64588s == 0) {
                if (z11) {
                    v(i11, 3);
                    length = i11;
                } else {
                    z3.a.g(i11 >= bArr.length / 2);
                    length = this.f64589t.length / 2;
                    v(length, 0);
                }
                iL = length;
            } else if (z11) {
                int length2 = i11 - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iL2 = l(length2) + (this.f64589t.length / 2);
                v(iL2, 2);
                iL = iL2;
                length = length3;
            } else {
                length = i11 - (bArr.length / 2);
                iL = l(length);
                v(iL, 1);
            }
            z3.a.h(length % this.f64584o == 0, "bytesConsumed is not aligned to frame size: %s" + length);
            z3.a.g(i11 >= iL);
            this.f64591v -= length;
            int i12 = this.f64590u + length;
            this.f64590u = i12;
            this.f64590u = i12 % this.f64589t.length;
            int i13 = this.f64588s;
            int i14 = this.f64584o;
            this.f64588s = i13 + (iL / i14);
            this.f64587r += (long) ((length - iL) / i14);
        }
    }

    public final void v(int i11, int i12) {
        if (i11 == 0) {
            return;
        }
        z3.a.a(this.f64591v >= i11);
        if (i12 == 2) {
            int i13 = this.f64590u;
            int i14 = this.f64591v;
            int i15 = i13 + i14;
            byte[] bArr = this.f64589t;
            if (i15 <= bArr.length) {
                System.arraycopy(bArr, (i13 + i14) - i11, this.f64592w, 0, i11);
            } else {
                int length = i14 - (bArr.length - i13);
                if (length >= i11) {
                    System.arraycopy(bArr, length - i11, this.f64592w, 0, i11);
                } else {
                    int i16 = i11 - length;
                    System.arraycopy(bArr, bArr.length - i16, this.f64592w, 0, i16);
                    System.arraycopy(this.f64589t, 0, this.f64592w, i16, length);
                }
            }
        } else {
            int i17 = this.f64590u;
            int i18 = i17 + i11;
            byte[] bArr2 = this.f64589t;
            if (i18 <= bArr2.length) {
                System.arraycopy(bArr2, i17, this.f64592w, 0, i11);
            } else {
                int length2 = bArr2.length - i17;
                System.arraycopy(bArr2, i17, this.f64592w, 0, length2);
                System.arraycopy(this.f64589t, 0, this.f64592w, length2, i11 - length2);
            }
        }
        z3.a.b(i11 % this.f64584o == 0, "sizeToOutput is not aligned to frame size: " + i11);
        z3.a.g(this.f64590u < this.f64589t.length);
        t(this.f64592w, i11, i12);
    }

    public final void w(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f64589t.length));
        int iN = n(byteBuffer);
        if (iN == byteBuffer.position()) {
            this.f64586q = 1;
        } else {
            byteBuffer.limit(Math.min(iN, byteBuffer.capacity()));
            s(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    public void y(boolean z11) {
        this.f64585p = z11;
    }

    public final void z(ByteBuffer byteBuffer) {
        int length;
        int i11;
        z3.a.g(this.f64590u < this.f64589t.length);
        int iLimit = byteBuffer.limit();
        int iO = o(byteBuffer);
        int iPosition = iO - byteBuffer.position();
        int i12 = this.f64590u;
        int i13 = this.f64591v;
        int i14 = i12 + i13;
        byte[] bArr = this.f64589t;
        if (i14 < bArr.length) {
            length = bArr.length - (i13 + i12);
            i11 = i12 + i13;
        } else {
            int length2 = i13 - (bArr.length - i12);
            length = i12 - length2;
            i11 = length2;
        }
        boolean z11 = iO < iLimit;
        int iMin = Math.min(iPosition, length);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f64589t, i11, iMin);
        int i15 = this.f64591v + iMin;
        this.f64591v = i15;
        z3.a.g(i15 <= this.f64589t.length);
        boolean z12 = z11 && iPosition < length;
        u(z12);
        if (z12) {
            this.f64586q = 0;
            this.f64588s = 0;
        }
        byteBuffer.limit(iLimit);
    }
}
