package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class vp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f23936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final qo[] f23937b;

    public vp(List list) {
        this.f23936a = list;
        this.f23937b = new qo[list.size()];
    }

    public void a(long j11, bh bhVar) {
        if (bhVar.a() < 9) {
            return;
        }
        int iJ = bhVar.j();
        int iJ2 = bhVar.j();
        int iW = bhVar.w();
        if (iJ == 434 && iJ2 == 1195456820 && iW == 3) {
            c3.b(j11, bhVar, this.f23937b);
        }
    }

    public void a(m8 m8Var, dp.d dVar) {
        for (int i11 = 0; i11 < this.f23937b.length; i11++) {
            dVar.a();
            qo qoVarA = m8Var.a(dVar.c(), 3);
            f9 f9Var = (f9) this.f23936a.get(i11);
            String str = f9Var.f18900m;
            b1.a(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            qoVarA.a(new f9.b().c(dVar.b()).f(str).o(f9Var.f18892d).e(f9Var.f18891c).a(f9Var.E).a(f9Var.f18902o).a());
            this.f23937b[i11] = qoVarA;
        }
    }
}
