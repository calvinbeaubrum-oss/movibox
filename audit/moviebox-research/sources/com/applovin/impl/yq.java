package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class yq extends xl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f24710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f24711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f24713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f24714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24715g;

    public yq(qo qoVar) {
        super(qoVar);
        this.f24710b = new bh(zf.f24845a);
        this.f24711c = new bh(4);
    }

    @Override // com.applovin.impl.xl
    public boolean a(bh bhVar) throws xl.a {
        int iW = bhVar.w();
        int i11 = (iW >> 4) & 15;
        int i12 = iW & 15;
        if (i12 == 7) {
            this.f24715g = i11;
            return i11 != 5;
        }
        throw new xl.a("Video format not supported: " + i12);
    }

    @Override // com.applovin.impl.xl
    public boolean b(bh bhVar, long j11) throws dh {
        int iW = bhVar.w();
        long jK = j11 + (((long) bhVar.k()) * 1000);
        if (iW == 0 && !this.f24713e) {
            bh bhVar2 = new bh(new byte[bhVar.a()]);
            bhVar.a(bhVar2.c(), 0, bhVar.a());
            w1 w1VarB = w1.b(bhVar2);
            this.f24712d = w1VarB.f24006b;
            this.f24345a.a(new f9.b().f(MimeTypes.VIDEO_H264).a(w1VarB.f24010f).q(w1VarB.f24007c).g(w1VarB.f24008d).b(w1VarB.f24009e).a(w1VarB.f24005a).a());
            this.f24713e = true;
            return false;
        }
        if (iW != 1 || !this.f24713e) {
            return false;
        }
        int i11 = this.f24715g == 1 ? 1 : 0;
        if (!this.f24714f && i11 == 0) {
            return false;
        }
        byte[] bArrC = this.f24711c.c();
        bArrC[0] = 0;
        bArrC[1] = 0;
        bArrC[2] = 0;
        int i12 = 4 - this.f24712d;
        int i13 = 0;
        while (bhVar.a() > 0) {
            bhVar.a(this.f24711c.c(), i12, this.f24712d);
            this.f24711c.f(0);
            int iA = this.f24711c.A();
            this.f24710b.f(0);
            this.f24345a.a(this.f24710b, 4);
            this.f24345a.a(bhVar, iA);
            i13 = i13 + 4 + iA;
        }
        this.f24345a.a(jK, i11, i13, 0, null);
        this.f24714f = true;
        return true;
    }
}
