package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class wo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final si[] f24151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h8[] f24152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f24153d;

    public wo(si[] siVarArr, h8[] h8VarArr, Object obj) {
        this.f24151b = siVarArr;
        this.f24152c = (h8[]) h8VarArr.clone();
        this.f24153d = obj;
        this.f24150a = siVarArr.length;
    }

    public boolean a(int i11) {
        return this.f24151b[i11] != null;
    }

    public boolean a(wo woVar) {
        if (woVar == null || woVar.f24152c.length != this.f24152c.length) {
            return false;
        }
        for (int i11 = 0; i11 < this.f24152c.length; i11++) {
            if (!a(woVar, i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(wo woVar, int i11) {
        return woVar != null && xp.a(this.f24151b[i11], woVar.f24151b[i11]) && xp.a(this.f24152c[i11], woVar.f24152c[i11]);
    }
}
