package com.applovin.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class hg implements k8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o8 f19480d = new o8() { // from class: com.applovin.impl.gy
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return hg.b();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m8 f19481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private gl f19482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19483c;

    private static bh a(bh bhVar) {
        bhVar.f(0);
        return bhVar;
    }

    private boolean b(l8 l8Var) {
        jg jgVar = new jg();
        if (jgVar.a(l8Var, true) && (jgVar.f19949b & 2) == 2) {
            int iMin = Math.min(jgVar.f19956i, 8);
            bh bhVar = new bh(iMin);
            l8Var.c(bhVar.c(), 0, iMin);
            if (y8.c(a(bhVar))) {
                this.f19482b = new y8();
            } else if (er.c(a(bhVar))) {
                this.f19482b = new er();
            } else if (tg.b(a(bhVar))) {
                this.f19482b = new tg();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] b() {
        return new k8[]{new hg()};
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        b1.b(this.f19481a);
        if (this.f19482b == null) {
            if (!b(l8Var)) {
                throw dh.a("Failed to determine bitstream type", null);
            }
            l8Var.b();
        }
        if (!this.f19483c) {
            qo qoVarA = this.f19481a.a(0, 1);
            this.f19481a.c();
            this.f19482b.a(this.f19481a, qoVarA);
            this.f19483c = true;
        }
        return this.f19482b.a(l8Var, thVar);
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        gl glVar = this.f19482b;
        if (glVar != null) {
            glVar.a(j11, j12);
        }
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f19481a = m8Var;
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        try {
            return b(l8Var);
        } catch (dh unused) {
            return false;
        }
    }
}
