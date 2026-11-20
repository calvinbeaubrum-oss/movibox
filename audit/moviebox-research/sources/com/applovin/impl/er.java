package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class er extends gl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f18767n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f18768o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18769p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private fr.d f18770q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private fr.b f18771r;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fr.d f18772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fr.b f18773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f18774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final fr.c[] f18775d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18776e;

        public a(fr.d dVar, fr.b bVar, byte[] bArr, fr.c[] cVarArr, int i11) {
            this.f18772a = dVar;
            this.f18773b = bVar;
            this.f18774c = bArr;
            this.f18775d = cVarArr;
            this.f18776e = i11;
        }
    }

    public static int a(byte b11, int i11, int i12) {
        return (b11 >> i12) & (255 >>> (8 - i11));
    }

    private static int a(byte b11, a aVar) {
        return !aVar.f18775d[a(b11, aVar.f18776e, 1)].f19106a ? aVar.f18772a.f19116g : aVar.f18772a.f19117h;
    }

    public static void a(bh bhVar, long j11) {
        if (bhVar.b() < bhVar.e() + 4) {
            bhVar.a(Arrays.copyOf(bhVar.c(), bhVar.e() + 4));
        } else {
            bhVar.e(bhVar.e() + 4);
        }
        byte[] bArrC = bhVar.c();
        bArrC[bhVar.e() - 4] = (byte) (j11 & 255);
        bArrC[bhVar.e() - 3] = (byte) ((j11 >>> 8) & 255);
        bArrC[bhVar.e() - 2] = (byte) ((j11 >>> 16) & 255);
        bArrC[bhVar.e() - 1] = (byte) ((j11 >>> 24) & 255);
    }

    public static boolean c(bh bhVar) {
        try {
            return fr.a(1, bhVar, true);
        } catch (dh unused) {
            return false;
        }
    }

    @Override // com.applovin.impl.gl
    public long a(bh bhVar) {
        if ((bhVar.c()[0] & 1) == 1) {
            return -1L;
        }
        int iA = a(bhVar.c()[0], (a) b1.b(this.f18767n));
        long j11 = this.f18769p ? (this.f18768o + iA) / 4 : 0;
        a(bhVar, j11);
        this.f18769p = true;
        this.f18768o = iA;
        return j11;
    }

    @Override // com.applovin.impl.gl
    public void a(boolean z11) {
        super.a(z11);
        if (z11) {
            this.f18767n = null;
            this.f18770q = null;
            this.f18771r = null;
        }
        this.f18768o = 0;
        this.f18769p = false;
    }

    @Override // com.applovin.impl.gl
    public boolean a(bh bhVar, long j11, gl.b bVar) throws dh {
        if (this.f18767n != null) {
            b1.a(bVar.f19260a);
            return false;
        }
        a aVarB = b(bhVar);
        this.f18767n = aVarB;
        if (aVarB == null) {
            return true;
        }
        fr.d dVar = aVarB.f18772a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f19119j);
        arrayList.add(aVarB.f18774c);
        bVar.f19260a = new f9.b().f(MimeTypes.AUDIO_VORBIS).b(dVar.f19114e).k(dVar.f19113d).c(dVar.f19111b).n(dVar.f19112c).a(arrayList).a();
        return true;
    }

    public a b(bh bhVar) throws dh {
        fr.d dVar = this.f18770q;
        if (dVar == null) {
            this.f18770q = fr.b(bhVar);
            return null;
        }
        fr.b bVar = this.f18771r;
        if (bVar == null) {
            this.f18771r = fr.a(bhVar);
            return null;
        }
        byte[] bArr = new byte[bhVar.e()];
        System.arraycopy(bhVar.c(), 0, bArr, 0, bhVar.e());
        fr.c[] cVarArrA = fr.a(bhVar, dVar.f19111b);
        return new a(dVar, bVar, bArr, cVarArrA, fr.a(cVarArrA.length - 1));
    }

    @Override // com.applovin.impl.gl
    public void c(long j11) {
        super.c(j11);
        this.f18769p = j11 != 0;
        fr.d dVar = this.f18770q;
        this.f18768o = dVar != null ? dVar.f19116g : 0;
    }
}
