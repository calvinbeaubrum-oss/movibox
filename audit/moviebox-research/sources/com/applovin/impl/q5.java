package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f9 f21901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f9 f21902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21904e;

    public q5(String str, f9 f9Var, f9 f9Var2, int i11, int i12) {
        b1.a(i11 == 0 || i12 == 0);
        this.f21900a = b1.a(str);
        this.f21901b = (f9) b1.a(f9Var);
        this.f21902c = (f9) b1.a(f9Var2);
        this.f21903d = i11;
        this.f21904e = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q5.class != obj.getClass()) {
            return false;
        }
        q5 q5Var = (q5) obj;
        return this.f21903d == q5Var.f21903d && this.f21904e == q5Var.f21904e && this.f21900a.equals(q5Var.f21900a) && this.f21901b.equals(q5Var.f21901b) && this.f21902c.equals(q5Var.f21902c);
    }

    public int hashCode() {
        return ((((((((this.f21903d + 527) * 31) + this.f21904e) * 31) + this.f21900a.hashCode()) * 31) + this.f21901b.hashCode()) * 31) + this.f21902c.hashCode();
    }
}
