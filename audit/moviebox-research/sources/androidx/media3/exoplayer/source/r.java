package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.decoder.DecoderInputBuffer;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import u4.r0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.b f11295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f11297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f11298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f11299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f11300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11301g;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements androidx.media3.exoplayer.upstream.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.upstream.a f11304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public a f11305d;

        public a(long j11, int i11) {
            d(j11, i11);
        }

        @Override // androidx.media3.exoplayer.upstream.b.a
        public androidx.media3.exoplayer.upstream.a a() {
            return (androidx.media3.exoplayer.upstream.a) z3.a.e(this.f11304c);
        }

        public a b() {
            this.f11304c = null;
            a aVar = this.f11305d;
            this.f11305d = null;
            return aVar;
        }

        public void c(androidx.media3.exoplayer.upstream.a aVar, a aVar2) {
            this.f11304c = aVar;
            this.f11305d = aVar2;
        }

        public void d(long j11, int i11) {
            z3.a.g(this.f11304c == null);
            this.f11302a = j11;
            this.f11303b = j11 + ((long) i11);
        }

        public int e(long j11) {
            return ((int) (j11 - this.f11302a)) + this.f11304c.f11444b;
        }

        @Override // androidx.media3.exoplayer.upstream.b.a
        @Nullable
        public androidx.media3.exoplayer.upstream.b.a next() {
            a aVar = this.f11305d;
            if (aVar == null || aVar.f11304c == null) {
                return null;
            }
            return aVar;
        }
    }

    public r(androidx.media3.exoplayer.upstream.b bVar) {
        this.f11295a = bVar;
        int individualAllocationLength = bVar.getIndividualAllocationLength();
        this.f11296b = individualAllocationLength;
        this.f11297c = new c0(32);
        a aVar = new a(0L, individualAllocationLength);
        this.f11298d = aVar;
        this.f11299e = aVar;
        this.f11300f = aVar;
    }

    public static a d(a aVar, long j11) {
        while (j11 >= aVar.f11303b) {
            aVar = aVar.f11305d;
        }
        return aVar;
    }

    public static a i(a aVar, long j11, ByteBuffer byteBuffer, int i11) {
        a aVarD = d(aVar, j11);
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (aVarD.f11303b - j11));
            byteBuffer.put(aVarD.f11304c.f11443a, aVarD.e(j11), iMin);
            i11 -= iMin;
            j11 += (long) iMin;
            if (j11 == aVarD.f11303b) {
                aVarD = aVarD.f11305d;
            }
        }
        return aVarD;
    }

    public static a j(a aVar, long j11, byte[] bArr, int i11) {
        a aVarD = d(aVar, j11);
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(i12, (int) (aVarD.f11303b - j11));
            System.arraycopy(aVarD.f11304c.f11443a, aVarD.e(j11), bArr, i11 - i12, iMin);
            i12 -= iMin;
            j11 += (long) iMin;
            if (j11 == aVarD.f11303b) {
                aVarD = aVarD.f11305d;
            }
        }
        return aVarD;
    }

    public static a k(a aVar, DecoderInputBuffer decoderInputBuffer, s.b bVar, c0 c0Var) {
        int iN;
        long j11 = bVar.f11333b;
        c0Var.Q(1);
        a aVarJ = j(aVar, j11, c0Var.e(), 1);
        long j12 = j11 + 1;
        byte b11 = c0Var.e()[0];
        boolean z11 = (b11 & 128) != 0;
        int i11 = b11 & Ascii.DEL;
        androidx.media3.decoder.c cVar = decoderInputBuffer.f9779b;
        byte[] bArr = cVar.f9802a;
        if (bArr == null) {
            cVar.f9802a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarJ2 = j(aVarJ, j12, cVar.f9802a, i11);
        long j13 = j12 + ((long) i11);
        if (z11) {
            c0Var.Q(2);
            aVarJ2 = j(aVarJ2, j13, c0Var.e(), 2);
            j13 += 2;
            iN = c0Var.N();
        } else {
            iN = 1;
        }
        int[] iArr = cVar.f9805d;
        if (iArr == null || iArr.length < iN) {
            iArr = new int[iN];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.f9806e;
        if (iArr3 == null || iArr3.length < iN) {
            iArr3 = new int[iN];
        }
        int[] iArr4 = iArr3;
        if (z11) {
            int i12 = iN * 6;
            c0Var.Q(i12);
            aVarJ2 = j(aVarJ2, j13, c0Var.e(), i12);
            j13 += (long) i12;
            c0Var.U(0);
            for (int i13 = 0; i13 < iN; i13++) {
                iArr2[i13] = c0Var.N();
                iArr4[i13] = c0Var.L();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f11332a - ((int) (j13 - bVar.f11333b));
        }
        r0.a aVar2 = (r0.a) u0.i(bVar.f11334c);
        cVar.c(iN, iArr2, iArr4, aVar2.f78381b, cVar.f9802a, aVar2.f78380a, aVar2.f78382c, aVar2.f78383d);
        long j14 = bVar.f11333b;
        int i14 = (int) (j13 - j14);
        bVar.f11333b = j14 + ((long) i14);
        bVar.f11332a -= i14;
        return aVarJ2;
    }

    public static a l(a aVar, DecoderInputBuffer decoderInputBuffer, s.b bVar, c0 c0Var) {
        if (decoderInputBuffer.d()) {
            aVar = k(aVar, decoderInputBuffer, bVar, c0Var);
        }
        if (!decoderInputBuffer.hasSupplementalData()) {
            decoderInputBuffer.b(bVar.f11332a);
            return i(aVar, bVar.f11333b, decoderInputBuffer.f9780c, bVar.f11332a);
        }
        c0Var.Q(4);
        a aVarJ = j(aVar, bVar.f11333b, c0Var.e(), 4);
        int iL = c0Var.L();
        bVar.f11333b += 4;
        bVar.f11332a -= 4;
        decoderInputBuffer.b(iL);
        a aVarI = i(aVarJ, bVar.f11333b, decoderInputBuffer.f9780c, iL);
        bVar.f11333b += (long) iL;
        int i11 = bVar.f11332a - iL;
        bVar.f11332a = i11;
        decoderInputBuffer.h(i11);
        return i(aVarI, bVar.f11333b, decoderInputBuffer.f9783g, bVar.f11332a);
    }

    public final void a(a aVar) {
        if (aVar.f11304c == null) {
            return;
        }
        this.f11295a.a(aVar);
        aVar.b();
    }

    public void b(long j11) {
        a aVar;
        if (j11 == -1) {
            return;
        }
        while (true) {
            aVar = this.f11298d;
            if (j11 < aVar.f11303b) {
                break;
            }
            this.f11295a.b(aVar.f11304c);
            this.f11298d = this.f11298d.b();
        }
        if (this.f11299e.f11302a < aVar.f11302a) {
            this.f11299e = aVar;
        }
    }

    public void c(long j11) {
        z3.a.a(j11 <= this.f11301g);
        this.f11301g = j11;
        if (j11 != 0) {
            a aVar = this.f11298d;
            if (j11 != aVar.f11302a) {
                while (this.f11301g > aVar.f11303b) {
                    aVar = aVar.f11305d;
                }
                a aVar2 = (a) z3.a.e(aVar.f11305d);
                a(aVar2);
                a aVar3 = new a(aVar.f11303b, this.f11296b);
                aVar.f11305d = aVar3;
                if (this.f11301g == aVar.f11303b) {
                    aVar = aVar3;
                }
                this.f11300f = aVar;
                if (this.f11299e == aVar2) {
                    this.f11299e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f11298d);
        a aVar4 = new a(this.f11301g, this.f11296b);
        this.f11298d = aVar4;
        this.f11299e = aVar4;
        this.f11300f = aVar4;
    }

    public long e() {
        return this.f11301g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, s.b bVar) {
        l(this.f11299e, decoderInputBuffer, bVar, this.f11297c);
    }

    public final void g(int i11) {
        long j11 = this.f11301g + ((long) i11);
        this.f11301g = j11;
        a aVar = this.f11300f;
        if (j11 == aVar.f11303b) {
            this.f11300f = aVar.f11305d;
        }
    }

    public final int h(int i11) {
        a aVar = this.f11300f;
        if (aVar.f11304c == null) {
            aVar.c(this.f11295a.allocate(), new a(this.f11300f.f11303b, this.f11296b));
        }
        return Math.min(i11, (int) (this.f11300f.f11303b - this.f11301g));
    }

    public void m(DecoderInputBuffer decoderInputBuffer, s.b bVar) {
        this.f11299e = l(this.f11299e, decoderInputBuffer, bVar, this.f11297c);
    }

    public void n() {
        a(this.f11298d);
        this.f11298d.d(0L, this.f11296b);
        a aVar = this.f11298d;
        this.f11299e = aVar;
        this.f11300f = aVar;
        this.f11301g = 0L;
        this.f11295a.trim();
    }

    public void o() {
        this.f11299e = this.f11298d;
    }

    public int p(androidx.media3.common.l lVar, int i11, boolean z11) throws IOException {
        int iH = h(i11);
        a aVar = this.f11300f;
        int i12 = lVar.read(aVar.f11304c.f11443a, aVar.e(this.f11301g), iH);
        if (i12 != -1) {
            g(i12);
            return i12;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(c0 c0Var, int i11) {
        while (i11 > 0) {
            int iH = h(i11);
            a aVar = this.f11300f;
            c0Var.l(aVar.f11304c.f11443a, aVar.e(this.f11301g), iH);
            i11 -= iH;
            g(iH);
        }
    }
}
