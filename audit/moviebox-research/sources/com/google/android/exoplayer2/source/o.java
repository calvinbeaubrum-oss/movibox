package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f34321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f34323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f34324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f34325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f34326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f34327g;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements com.google.android.exoplayer2.upstream.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f34328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f34329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.upstream.a f34330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public a f34331d;

        public a(long j11, int i11) {
            d(j11, i11);
        }

        @Override // com.google.android.exoplayer2.upstream.b.a
        public com.google.android.exoplayer2.upstream.a a() {
            return (com.google.android.exoplayer2.upstream.a) com.google.android.exoplayer2.util.a.e(this.f34330c);
        }

        public a b() {
            this.f34330c = null;
            a aVar = this.f34331d;
            this.f34331d = null;
            return aVar;
        }

        public void c(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.f34330c = aVar;
            this.f34331d = aVar2;
        }

        public void d(long j11, int i11) {
            com.google.android.exoplayer2.util.a.g(this.f34330c == null);
            this.f34328a = j11;
            this.f34329b = j11 + ((long) i11);
        }

        public int e(long j11) {
            return ((int) (j11 - this.f34328a)) + this.f34330c.f35255b;
        }

        @Override // com.google.android.exoplayer2.upstream.b.a
        @Nullable
        public com.google.android.exoplayer2.upstream.b.a next() {
            a aVar = this.f34331d;
            if (aVar == null || aVar.f34330c == null) {
                return null;
            }
            return aVar;
        }
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.f34321a = bVar;
        int individualAllocationLength = bVar.getIndividualAllocationLength();
        this.f34322b = individualAllocationLength;
        this.f34323c = new c0(32);
        a aVar = new a(0L, individualAllocationLength);
        this.f34324d = aVar;
        this.f34325e = aVar;
        this.f34326f = aVar;
    }

    public static a d(a aVar, long j11) {
        while (j11 >= aVar.f34329b) {
            aVar = aVar.f34331d;
        }
        return aVar;
    }

    public static a i(a aVar, long j11, ByteBuffer byteBuffer, int i11) {
        a aVarD = d(aVar, j11);
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (aVarD.f34329b - j11));
            byteBuffer.put(aVarD.f34330c.f35254a, aVarD.e(j11), iMin);
            i11 -= iMin;
            j11 += (long) iMin;
            if (j11 == aVarD.f34329b) {
                aVarD = aVarD.f34331d;
            }
        }
        return aVarD;
    }

    public static a j(a aVar, long j11, byte[] bArr, int i11) {
        a aVarD = d(aVar, j11);
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(i12, (int) (aVarD.f34329b - j11));
            System.arraycopy(aVarD.f34330c.f35254a, aVarD.e(j11), bArr, i11 - i12, iMin);
            i12 -= iMin;
            j11 += (long) iMin;
            if (j11 == aVarD.f34329b) {
                aVarD = aVarD.f34331d;
            }
        }
        return aVarD;
    }

    public static a k(a aVar, DecoderInputBuffer decoderInputBuffer, p.b bVar, c0 c0Var) {
        int iJ;
        long j11 = bVar.f34359b;
        c0Var.L(1);
        a aVarJ = j(aVar, j11, c0Var.d(), 1);
        long j12 = j11 + 1;
        byte b11 = c0Var.d()[0];
        boolean z11 = (b11 & 128) != 0;
        int i11 = b11 & Ascii.DEL;
        com.google.android.exoplayer2.decoder.c cVar = decoderInputBuffer.f33029b;
        byte[] bArr = cVar.f33050a;
        if (bArr == null) {
            cVar.f33050a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarJ2 = j(aVarJ, j12, cVar.f33050a, i11);
        long j13 = j12 + ((long) i11);
        if (z11) {
            c0Var.L(2);
            aVarJ2 = j(aVarJ2, j13, c0Var.d(), 2);
            j13 += 2;
            iJ = c0Var.J();
        } else {
            iJ = 1;
        }
        int[] iArr = cVar.f33053d;
        if (iArr == null || iArr.length < iJ) {
            iArr = new int[iJ];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.f33054e;
        if (iArr3 == null || iArr3.length < iJ) {
            iArr3 = new int[iJ];
        }
        int[] iArr4 = iArr3;
        if (z11) {
            int i12 = iJ * 6;
            c0Var.L(i12);
            aVarJ2 = j(aVarJ2, j13, c0Var.d(), i12);
            j13 += (long) i12;
            c0Var.P(0);
            for (int i13 = 0; i13 < iJ; i13++) {
                iArr2[i13] = c0Var.J();
                iArr4[i13] = c0Var.H();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f34358a - ((int) (j13 - bVar.f34359b));
        }
        e0.a aVar2 = (e0.a) o0.j(bVar.f34360c);
        cVar.c(iJ, iArr2, iArr4, aVar2.f77012b, cVar.f33050a, aVar2.f77011a, aVar2.f77013c, aVar2.f77014d);
        long j14 = bVar.f34359b;
        int i14 = (int) (j13 - j14);
        bVar.f34359b = j14 + ((long) i14);
        bVar.f34358a -= i14;
        return aVarJ2;
    }

    public static a l(a aVar, DecoderInputBuffer decoderInputBuffer, p.b bVar, c0 c0Var) {
        if (decoderInputBuffer.p()) {
            aVar = k(aVar, decoderInputBuffer, bVar, c0Var);
        }
        if (!decoderInputBuffer.e()) {
            decoderInputBuffer.n(bVar.f34358a);
            return i(aVar, bVar.f34359b, decoderInputBuffer.f33030c, bVar.f34358a);
        }
        c0Var.L(4);
        a aVarJ = j(aVar, bVar.f34359b, c0Var.d(), 4);
        int iH = c0Var.H();
        bVar.f34359b += 4;
        bVar.f34358a -= 4;
        decoderInputBuffer.n(iH);
        a aVarI = i(aVarJ, bVar.f34359b, decoderInputBuffer.f33030c, iH);
        bVar.f34359b += (long) iH;
        int i11 = bVar.f34358a - iH;
        bVar.f34358a = i11;
        decoderInputBuffer.r(i11);
        return i(aVarI, bVar.f34359b, decoderInputBuffer.f33033g, bVar.f34358a);
    }

    public final void a(a aVar) {
        if (aVar.f34330c == null) {
            return;
        }
        this.f34321a.a(aVar);
        aVar.b();
    }

    public void b(long j11) {
        a aVar;
        if (j11 == -1) {
            return;
        }
        while (true) {
            aVar = this.f34324d;
            if (j11 < aVar.f34329b) {
                break;
            }
            this.f34321a.b(aVar.f34330c);
            this.f34324d = this.f34324d.b();
        }
        if (this.f34325e.f34328a < aVar.f34328a) {
            this.f34325e = aVar;
        }
    }

    public void c(long j11) {
        com.google.android.exoplayer2.util.a.a(j11 <= this.f34327g);
        this.f34327g = j11;
        if (j11 != 0) {
            a aVar = this.f34324d;
            if (j11 != aVar.f34328a) {
                while (this.f34327g > aVar.f34329b) {
                    aVar = aVar.f34331d;
                }
                a aVar2 = (a) com.google.android.exoplayer2.util.a.e(aVar.f34331d);
                a(aVar2);
                a aVar3 = new a(aVar.f34329b, this.f34322b);
                aVar.f34331d = aVar3;
                if (this.f34327g == aVar.f34329b) {
                    aVar = aVar3;
                }
                this.f34326f = aVar;
                if (this.f34325e == aVar2) {
                    this.f34325e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f34324d);
        a aVar4 = new a(this.f34327g, this.f34322b);
        this.f34324d = aVar4;
        this.f34325e = aVar4;
        this.f34326f = aVar4;
    }

    public long e() {
        return this.f34327g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, p.b bVar) {
        l(this.f34325e, decoderInputBuffer, bVar, this.f34323c);
    }

    public final void g(int i11) {
        long j11 = this.f34327g + ((long) i11);
        this.f34327g = j11;
        a aVar = this.f34326f;
        if (j11 == aVar.f34329b) {
            this.f34326f = aVar.f34331d;
        }
    }

    public final int h(int i11) {
        a aVar = this.f34326f;
        if (aVar.f34330c == null) {
            aVar.c(this.f34321a.allocate(), new a(this.f34326f.f34329b, this.f34322b));
        }
        return Math.min(i11, (int) (this.f34326f.f34329b - this.f34327g));
    }

    public void m(DecoderInputBuffer decoderInputBuffer, p.b bVar) {
        this.f34325e = l(this.f34325e, decoderInputBuffer, bVar, this.f34323c);
    }

    public void n() {
        a(this.f34324d);
        this.f34324d.d(0L, this.f34322b);
        a aVar = this.f34324d;
        this.f34325e = aVar;
        this.f34326f = aVar;
        this.f34327g = 0L;
        this.f34321a.trim();
    }

    public void o() {
        this.f34325e = this.f34324d;
    }

    public int p(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11) throws IOException {
        int iH = h(i11);
        a aVar = this.f34326f;
        int i12 = gVar.read(aVar.f34330c.f35254a, aVar.e(this.f34327g), iH);
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
            a aVar = this.f34326f;
            c0Var.j(aVar.f34330c.f35254a, aVar.e(this.f34327g), iH);
            i11 -= iH;
            g(iH);
        }
    }
}
