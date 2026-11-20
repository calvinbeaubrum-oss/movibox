package ch;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import tg.h0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public a f14844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14846p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public h0.d f14847q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public h0.b f14848r;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h0.d f14849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0.b f14850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f14851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0.c[] f14852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f14853e;

        public a(h0.d dVar, h0.b bVar, byte[] bArr, h0.c[] cVarArr, int i11) {
            this.f14849a = dVar;
            this.f14850b = bVar;
            this.f14851c = bArr;
            this.f14852d = cVarArr;
            this.f14853e = i11;
        }
    }

    public static void n(c0 c0Var, long j11) {
        if (c0Var.b() < c0Var.f() + 4) {
            c0Var.M(Arrays.copyOf(c0Var.d(), c0Var.f() + 4));
        } else {
            c0Var.O(c0Var.f() + 4);
        }
        byte[] bArrD = c0Var.d();
        bArrD[c0Var.f() - 4] = (byte) (j11 & 255);
        bArrD[c0Var.f() - 3] = (byte) ((j11 >>> 8) & 255);
        bArrD[c0Var.f() - 2] = (byte) ((j11 >>> 16) & 255);
        bArrD[c0Var.f() - 1] = (byte) ((j11 >>> 24) & 255);
    }

    public static int o(byte b11, a aVar) {
        return !aVar.f14852d[p(b11, aVar.f14853e, 1)].f77041a ? aVar.f14849a.f77051g : aVar.f14849a.f77052h;
    }

    public static int p(byte b11, int i11, int i12) {
        return (b11 >> i12) & (255 >>> (8 - i11));
    }

    public static boolean r(c0 c0Var) {
        try {
            return h0.m(1, c0Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // ch.i
    public void e(long j11) {
        super.e(j11);
        this.f14846p = j11 != 0;
        h0.d dVar = this.f14847q;
        this.f14845o = dVar != null ? dVar.f77051g : 0;
    }

    @Override // ch.i
    public long f(c0 c0Var) {
        if ((c0Var.d()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(c0Var.d()[0], (a) com.google.android.exoplayer2.util.a.i(this.f14844n));
        long j11 = this.f14846p ? (this.f14845o + iO) / 4 : 0;
        n(c0Var, j11);
        this.f14846p = true;
        this.f14845o = iO;
        return j11;
    }

    @Override // ch.i
    public boolean h(c0 c0Var, long j11, i.b bVar) throws IOException {
        if (this.f14844n != null) {
            com.google.android.exoplayer2.util.a.e(bVar.f14842a);
            return false;
        }
        a aVarQ = q(c0Var);
        this.f14844n = aVarQ;
        if (aVarQ == null) {
            return true;
        }
        h0.d dVar = aVarQ.f14849a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f77054j);
        arrayList.add(aVarQ.f14851c);
        bVar.f14842a = new m1.b().e0(MimeTypes.AUDIO_VORBIS).G(dVar.f77049e).Z(dVar.f77048d).H(dVar.f77046b).f0(dVar.f77047c).T(arrayList).X(h0.c(ImmutableList.copyOf(aVarQ.f14850b.f77039b))).E();
        return true;
    }

    @Override // ch.i
    public void l(boolean z11) {
        super.l(z11);
        if (z11) {
            this.f14844n = null;
            this.f14847q = null;
            this.f14848r = null;
        }
        this.f14845o = 0;
        this.f14846p = false;
    }

    @Nullable
    public a q(c0 c0Var) throws IOException {
        h0.d dVar = this.f14847q;
        if (dVar == null) {
            this.f14847q = h0.k(c0Var);
            return null;
        }
        h0.b bVar = this.f14848r;
        if (bVar == null) {
            this.f14848r = h0.i(c0Var);
            return null;
        }
        byte[] bArr = new byte[c0Var.f()];
        System.arraycopy(c0Var.d(), 0, bArr, 0, c0Var.f());
        h0.c[] cVarArrL = h0.l(c0Var, dVar.f77046b);
        return new a(dVar, bVar, bArr, cVarArrL, h0.a(cVarArrL.length - 1));
    }
}
