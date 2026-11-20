package com.applovin.impl;

import android.net.Uri;
import java.io.EOFException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q2 implements zh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8 f21890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k8 f21891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l8 f21892c;

    public q2(o8 o8Var) {
        this.f21890a = o8Var;
    }

    @Override // com.applovin.impl.zh
    public int a(th thVar) {
        return ((k8) b1.a(this.f21891b)).a((l8) b1.a(this.f21892c), thVar);
    }

    @Override // com.applovin.impl.zh
    public void a() {
        k8 k8Var = this.f21891b;
        if (k8Var != null) {
            k8Var.a();
            this.f21891b = null;
        }
        this.f21892c = null;
    }

    @Override // com.applovin.impl.zh
    public void a(long j11, long j12) {
        ((k8) b1.a(this.f21891b)).a(j11, j12);
    }

    @Override // com.applovin.impl.zh
    public void a(g5 g5Var, Uri uri, Map map, long j11, long j12, m8 m8Var) throws rp {
        b6 b6Var = new b6(g5Var, j11, j12);
        this.f21892c = b6Var;
        if (this.f21891b != null) {
            return;
        }
        k8[] k8VarArrA = this.f21890a.a(uri, map);
        if (k8VarArrA.length == 1) {
            this.f21891b = k8VarArrA[0];
        } else {
            for (k8 k8Var : k8VarArrA) {
                try {
                    if (k8Var.a(b6Var)) {
                        this.f21891b = k8Var;
                        b1.b(true);
                        b6Var.b();
                        break;
                    }
                    b1.b(this.f21891b != null || b6Var.f() == j11);
                    b6Var.b();
                } catch (EOFException unused) {
                    b1.b(this.f21891b != null || b6Var.f() == j11);
                    b6Var.b();
                } catch (Throwable th2) {
                    b1.b(this.f21891b != null || b6Var.f() == j11);
                    b6Var.b();
                    throw th2;
                }
            }
            if (this.f21891b == null) {
                throw new rp("None of the available extractors (" + xp.b(k8VarArrA) + ") could read the stream.", (Uri) b1.a(uri));
            }
        }
        this.f21891b.a(m8Var);
    }

    @Override // com.applovin.impl.zh
    public long b() {
        l8 l8Var = this.f21892c;
        if (l8Var != null) {
            return l8Var.f();
        }
        return -1L;
    }

    @Override // com.applovin.impl.zh
    public void c() {
        k8 k8Var = this.f21891b;
        if (k8Var instanceof of) {
            ((of) k8Var).c();
        }
    }
}
