package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class el implements m8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m8 f18752b;

    /* JADX INFO: compiled from: source.java */
    public class a implements ij {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ij f18753a;

        public a(ij ijVar) {
            this.f18753a = ijVar;
        }

        @Override // com.applovin.impl.ij
        public ij.a b(long j11) {
            ij.a aVarB = this.f18753a.b(j11);
            kj kjVar = aVarB.f19729a;
            kj kjVar2 = new kj(kjVar.f20256a, kjVar.f20257b + el.this.f18751a);
            kj kjVar3 = aVarB.f19730b;
            return new ij.a(kjVar2, new kj(kjVar3.f20256a, kjVar3.f20257b + el.this.f18751a));
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return this.f18753a.b();
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return this.f18753a.d();
        }
    }

    public el(long j11, m8 m8Var) {
        this.f18751a = j11;
        this.f18752b = m8Var;
    }

    @Override // com.applovin.impl.m8
    public qo a(int i11, int i12) {
        return this.f18752b.a(i11, i12);
    }

    @Override // com.applovin.impl.m8
    public void a(ij ijVar) {
        this.f18752b.a(new a(ijVar));
    }

    @Override // com.applovin.impl.m8
    public void c() {
        this.f18752b.c();
    }
}
