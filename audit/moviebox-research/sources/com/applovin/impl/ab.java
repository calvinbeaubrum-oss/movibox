package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ab implements q7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f17498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17499c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17502f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f17497a = new bh(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17500d = C.TIME_UNSET;

    @Override // com.applovin.impl.q7
    public void a() {
        this.f17499c = false;
        this.f17500d = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f17499c = true;
        if (j11 != C.TIME_UNSET) {
            this.f17500d = j11;
        }
        this.f17501e = 0;
        this.f17502f = 0;
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        b1.b(this.f17498b);
        if (this.f17499c) {
            int iA = bhVar.a();
            int i11 = this.f17502f;
            if (i11 < 10) {
                int iMin = Math.min(iA, 10 - i11);
                System.arraycopy(bhVar.c(), bhVar.d(), this.f17497a.c(), this.f17502f, iMin);
                if (this.f17502f + iMin == 10) {
                    this.f17497a.f(0);
                    if (73 != this.f17497a.w() || 68 != this.f17497a.w() || 51 != this.f17497a.w()) {
                        pc.d("Id3Reader", "Discarding invalid ID3 tag");
                        this.f17499c = false;
                        return;
                    } else {
                        this.f17497a.g(3);
                        this.f17501e = this.f17497a.v() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f17501e - this.f17502f);
            this.f17498b.a(bhVar, iMin2);
            this.f17502f += iMin2;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        qo qoVarA = m8Var.a(dVar.c(), 5);
        this.f17498b = qoVarA;
        qoVarA.a(new f9.b().c(dVar.b()).f(MimeTypes.APPLICATION_ID3).a());
    }

    @Override // com.applovin.impl.q7
    public void b() {
        int i11;
        b1.b(this.f17498b);
        if (this.f17499c && (i11 = this.f17501e) != 0 && this.f17502f == i11) {
            long j11 = this.f17500d;
            if (j11 != C.TIME_UNSET) {
                this.f17498b.a(j11, 1, i11, 0, null);
            }
            this.f17499c = false;
        }
    }
}
