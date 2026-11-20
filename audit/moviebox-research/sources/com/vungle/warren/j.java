package com.vungle.warren;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f62047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.vungle.warren.persistence.a f62048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f62049c;

    public j(@NonNull com.vungle.warren.persistence.a aVar, @NonNull s sVar, float f11) {
        this.f62048b = aVar;
        this.f62049c = sVar;
        this.f62047a = f11;
    }

    @Override // com.vungle.warren.u
    public long a() {
        x xVar = this.f62049c.f62337c.get();
        if (xVar == null) {
            return 0L;
        }
        long jE = this.f62048b.e() / 2;
        long jC = xVar.c();
        long jMax = Math.max(0L, xVar.d() - jE);
        float fMin = Math.min(jC, jE);
        return Math.max(0L, ((long) (fMin - (this.f62047a * fMin))) - jMax);
    }
}
