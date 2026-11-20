package com.google.android.datatransport.runtime;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f32609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cg.d<?> f32611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cg.f<?, byte[]> f32612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cg.c f32613e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f32614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f32615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public cg.d<?> f32616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public cg.f<?, byte[]> f32617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public cg.c f32618e;

        @Override // com.google.android.datatransport.runtime.n.a
        public n a() {
            String str = "";
            if (this.f32614a == null) {
                str = " transportContext";
            }
            if (this.f32615b == null) {
                str = str + " transportName";
            }
            if (this.f32616c == null) {
                str = str + " event";
            }
            if (this.f32617d == null) {
                str = str + " transformer";
            }
            if (this.f32618e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f32614a, this.f32615b, this.f32616c, this.f32617d, this.f32618e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.n.a
        public n.a b(cg.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f32618e = cVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        public n.a c(cg.d<?> dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f32616c = dVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        public n.a d(cg.f<?, byte[]> fVar) {
            if (fVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f32617d = fVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        public n.a e(o oVar) {
            if (oVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f32614a = oVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        public n.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f32615b = str;
            return this;
        }
    }

    public c(o oVar, String str, cg.d<?> dVar, cg.f<?, byte[]> fVar, cg.c cVar) {
        this.f32609a = oVar;
        this.f32610b = str;
        this.f32611c = dVar;
        this.f32612d = fVar;
        this.f32613e = cVar;
    }

    @Override // com.google.android.datatransport.runtime.n
    public cg.c b() {
        return this.f32613e;
    }

    @Override // com.google.android.datatransport.runtime.n
    public cg.d<?> c() {
        return this.f32611c;
    }

    @Override // com.google.android.datatransport.runtime.n
    public cg.f<?, byte[]> e() {
        return this.f32612d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f32609a.equals(nVar.f()) && this.f32610b.equals(nVar.g()) && this.f32611c.equals(nVar.c()) && this.f32612d.equals(nVar.e()) && this.f32613e.equals(nVar.b());
    }

    @Override // com.google.android.datatransport.runtime.n
    public o f() {
        return this.f32609a;
    }

    @Override // com.google.android.datatransport.runtime.n
    public String g() {
        return this.f32610b;
    }

    public int hashCode() {
        return ((((((((this.f32609a.hashCode() ^ 1000003) * 1000003) ^ this.f32610b.hashCode()) * 1000003) ^ this.f32611c.hashCode()) * 1000003) ^ this.f32612d.hashCode()) * 1000003) ^ this.f32613e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f32609a + ", transportName=" + this.f32610b + ", event=" + this.f32611c + ", transformer=" + this.f32612d + ", encoding=" + this.f32613e + "}";
    }
}
