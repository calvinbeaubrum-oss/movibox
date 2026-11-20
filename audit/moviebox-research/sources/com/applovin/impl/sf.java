package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class sf implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f22881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final tf.a f22882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qo f22884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f22887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f22888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f22889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f22890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f22891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f22892l;

    public sf() {
        this(null);
    }

    public sf(String str) {
        this.f22886f = 0;
        bh bhVar = new bh(4);
        this.f22881a = bhVar;
        bhVar.c()[0] = -1;
        this.f22882b = new tf.a();
        this.f22892l = C.TIME_UNSET;
        this.f22883c = str;
    }

    private void b(bh bhVar) {
        byte[] bArrC = bhVar.c();
        int iE = bhVar.e();
        for (int iD = bhVar.d(); iD < iE; iD++) {
            byte b11 = bArrC[iD];
            boolean z11 = (b11 & 255) == 255;
            boolean z12 = this.f22889i && (b11 & 224) == 224;
            this.f22889i = z11;
            if (z12) {
                bhVar.f(iD + 1);
                this.f22889i = false;
                this.f22881a.c()[1] = bArrC[iD];
                this.f22887g = 2;
                this.f22886f = 1;
                return;
            }
        }
        bhVar.f(iE);
    }

    private void c(bh bhVar) {
        int iMin = Math.min(bhVar.a(), this.f22891k - this.f22887g);
        this.f22884d.a(bhVar, iMin);
        int i11 = this.f22887g + iMin;
        this.f22887g = i11;
        int i12 = this.f22891k;
        if (i11 < i12) {
            return;
        }
        long j11 = this.f22892l;
        if (j11 != C.TIME_UNSET) {
            this.f22884d.a(j11, 1, i12, 0, null);
            this.f22892l += this.f22890j;
        }
        this.f22887g = 0;
        this.f22886f = 0;
    }

    private void d(bh bhVar) {
        int iMin = Math.min(bhVar.a(), 4 - this.f22887g);
        bhVar.a(this.f22881a.c(), this.f22887g, iMin);
        int i11 = this.f22887g + iMin;
        this.f22887g = i11;
        if (i11 < 4) {
            return;
        }
        this.f22881a.f(0);
        if (!this.f22882b.a(this.f22881a.j())) {
            this.f22887g = 0;
            this.f22886f = 1;
            return;
        }
        tf.a aVar = this.f22882b;
        this.f22891k = aVar.f23372c;
        if (!this.f22888h) {
            this.f22890j = (((long) aVar.f23376g) * 1000000) / ((long) aVar.f23373d);
            this.f22884d.a(new f9.b().c(this.f22885e).f(this.f22882b.f23371b).i(4096).c(this.f22882b.f23374e).n(this.f22882b.f23373d).e(this.f22883c).a());
            this.f22888h = true;
        }
        this.f22881a.f(0);
        this.f22884d.a(this.f22881a, 4);
        this.f22886f = 2;
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f22886f = 0;
        this.f22887g = 0;
        this.f22889i = false;
        this.f22892l = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f22892l = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        b1.b(this.f22884d);
        while (bhVar.a() > 0) {
            int i11 = this.f22886f;
            if (i11 == 0) {
                b(bhVar);
            } else if (i11 == 1) {
                d(bhVar);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException();
                }
                c(bhVar);
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f22885e = dVar.b();
        this.f22884d = m8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
