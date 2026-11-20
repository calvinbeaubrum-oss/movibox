package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z8 implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a9 f24821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f24822b;

    public z8(a9 a9Var, long j11) {
        this.f24821a = a9Var;
        this.f24822b = j11;
    }

    private kj a(long j11, long j12) {
        return new kj((j11 * 1000000) / ((long) this.f24821a.f17483e), this.f24822b + j12);
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        b1.b(this.f24821a.f17489k);
        a9 a9Var = this.f24821a;
        a9.a aVar = a9Var.f17489k;
        long[] jArr = aVar.f17491a;
        long[] jArr2 = aVar.f17492b;
        int iB = xp.b(jArr, a9Var.a(j11), true, false);
        kj kjVarA = a(iB == -1 ? 0L : jArr[iB], iB != -1 ? jArr2[iB] : 0L);
        if (kjVarA.f20256a == j11 || iB == jArr.length - 1) {
            return new ij.a(kjVarA);
        }
        int i11 = iB + 1;
        return new ij.a(kjVarA, a(jArr[i11], jArr2[i11]));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f24821a.b();
    }
}
