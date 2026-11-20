package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class nj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f21349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final qo[] f21350b;

    public nj(List list) {
        this.f21349a = list;
        this.f21350b = new qo[list.size()];
    }

    public void a(long j11, bh bhVar) {
        c3.a(j11, bhVar, this.f21350b);
    }

    public void a(m8 m8Var, dp.d dVar) {
        for (int i11 = 0; i11 < this.f21350b.length; i11++) {
            dVar.a();
            qo qoVarA = m8Var.a(dVar.c(), 3);
            f9 f9Var = (f9) this.f21349a.get(i11);
            String str = f9Var.f18900m;
            b1.a(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            String strB = f9Var.f18889a;
            if (strB == null) {
                strB = dVar.b();
            }
            qoVarA.a(new f9.b().c(strB).f(str).o(f9Var.f18892d).e(f9Var.f18891c).a(f9Var.E).a(f9Var.f18902o).a());
            this.f21350b[i11] = qoVarA;
        }
    }
}
