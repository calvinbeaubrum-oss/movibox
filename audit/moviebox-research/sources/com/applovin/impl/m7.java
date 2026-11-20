package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m7 implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f20623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final qo[] f20624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f20628f = C.TIME_UNSET;

    public m7(List list) {
        this.f20623a = list;
        this.f20624b = new qo[list.size()];
    }

    private boolean a(bh bhVar, int i11) {
        if (bhVar.a() == 0) {
            return false;
        }
        if (bhVar.w() != i11) {
            this.f20625c = false;
        }
        this.f20626d--;
        return this.f20625c;
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f20625c = false;
        this.f20628f = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f20625c = true;
        if (j11 != C.TIME_UNSET) {
            this.f20628f = j11;
        }
        this.f20627e = 0;
        this.f20626d = 2;
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        if (this.f20625c) {
            if (this.f20626d != 2 || a(bhVar, 32)) {
                if (this.f20626d != 1 || a(bhVar, 0)) {
                    int iD = bhVar.d();
                    int iA = bhVar.a();
                    for (qo qoVar : this.f20624b) {
                        bhVar.f(iD);
                        qoVar.a(bhVar, iA);
                    }
                    this.f20627e += iA;
                }
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        for (int i11 = 0; i11 < this.f20624b.length; i11++) {
            dp.a aVar = (dp.a) this.f20623a.get(i11);
            dVar.a();
            qo qoVarA = m8Var.a(dVar.c(), 3);
            qoVarA.a(new f9.b().c(dVar.b()).f(MimeTypes.APPLICATION_DVBSUBS).a(Collections.singletonList(aVar.f18485c)).e(aVar.f18483a).a());
            this.f20624b[i11] = qoVarA;
        }
    }

    @Override // com.applovin.impl.q7
    public void b() {
        if (this.f20625c) {
            if (this.f20628f != C.TIME_UNSET) {
                for (qo qoVar : this.f20624b) {
                    qoVar.a(this.f20628f, 1, this.f20627e, 0, null);
                }
            }
            this.f20625c = false;
        }
    }
}
