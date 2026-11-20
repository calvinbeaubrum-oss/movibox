package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e7 implements q7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qo f18593d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private f9 f18598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18599j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f18590a = new bh(new byte[18]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18594e = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f18600k = C.TIME_UNSET;

    public e7(String str) {
        this.f18591b = str;
    }

    private boolean a(bh bhVar, byte[] bArr, int i11) {
        int iMin = Math.min(bhVar.a(), i11 - this.f18595f);
        bhVar.a(bArr, this.f18595f, iMin);
        int i12 = this.f18595f + iMin;
        this.f18595f = i12;
        return i12 == i11;
    }

    private boolean b(bh bhVar) {
        while (bhVar.a() > 0) {
            int i11 = this.f18596g << 8;
            this.f18596g = i11;
            int iW = i11 | bhVar.w();
            this.f18596g = iW;
            if (f7.a(iW)) {
                byte[] bArrC = this.f18590a.c();
                int i12 = this.f18596g;
                bArrC[0] = (byte) ((i12 >> 24) & 255);
                bArrC[1] = (byte) ((i12 >> 16) & 255);
                bArrC[2] = (byte) ((i12 >> 8) & 255);
                bArrC[3] = (byte) (i12 & 255);
                this.f18595f = 4;
                this.f18596g = 0;
                return true;
            }
        }
        return false;
    }

    private void c() {
        byte[] bArrC = this.f18590a.c();
        if (this.f18598i == null) {
            f9 f9VarA = f7.a(bArrC, this.f18592c, this.f18591b, null);
            this.f18598i = f9VarA;
            this.f18593d.a(f9VarA);
        }
        this.f18599j = f7.a(bArrC);
        this.f18597h = (int) ((((long) f7.d(bArrC)) * 1000000) / ((long) this.f18598i.A));
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f18594e = 0;
        this.f18595f = 0;
        this.f18596g = 0;
        this.f18600k = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f18600k = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        b1.b(this.f18593d);
        while (bhVar.a() > 0) {
            int i11 = this.f18594e;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(bhVar.a(), this.f18599j - this.f18595f);
                    this.f18593d.a(bhVar, iMin);
                    int i12 = this.f18595f + iMin;
                    this.f18595f = i12;
                    int i13 = this.f18599j;
                    if (i12 == i13) {
                        long j11 = this.f18600k;
                        if (j11 != C.TIME_UNSET) {
                            this.f18593d.a(j11, 1, i13, 0, null);
                            this.f18600k += this.f18597h;
                        }
                        this.f18594e = 0;
                    }
                } else if (a(bhVar, this.f18590a.c(), 18)) {
                    c();
                    this.f18590a.f(0);
                    this.f18593d.a(this.f18590a, 18);
                    this.f18594e = 2;
                }
            } else if (b(bhVar)) {
                this.f18594e = 1;
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f18592c = dVar.b();
        this.f18593d = m8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
