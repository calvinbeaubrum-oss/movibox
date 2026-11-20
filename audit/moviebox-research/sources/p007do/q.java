package p007do;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f63496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f63497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f63498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f63499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f63500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f63501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f63503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte f63504i;

    public q() {
    }

    public q(d dVar) {
        this.f63496a = dVar.j();
        this.f63497b = dVar.c();
        this.f63498c = dVar.m();
        this.f63499d = dVar.f();
        this.f63500e = dVar.d();
        this.f63501f = dVar.i();
        this.f63502g = dVar.h();
        this.f63503h = dVar.l();
        this.f63504i = (byte) 3;
    }

    @Override // do.d.a
    public final d.a a(String str) {
        if (str == null) {
            throw new NullPointerException("Null installerBundle");
        }
        this.f63500e = str;
        return this;
    }

    @Override // do.d.a
    public final d.a b(String str) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f63499d = str;
        return this;
    }

    @Override // do.d.a
    public final d build() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (this.f63504i == 3 && (str = this.f63496a) != null && (str2 = this.f63497b) != null && (str3 = this.f63498c) != null && (str4 = this.f63499d) != null && (str5 = this.f63500e) != null && (str6 = this.f63501f) != null) {
            return new d(str, str2, str3, str4, str5, str6, this.f63502g, this.f63503h);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f63496a == null) {
            sb2.append(" storeId");
        }
        if (this.f63497b == null) {
            sb2.append(" bundle");
        }
        if (this.f63498c == null) {
            sb2.append(" version");
        }
        if (this.f63499d == null) {
            sb2.append(" name");
        }
        if (this.f63500e == null) {
            sb2.append(" installerBundle");
        }
        if (this.f63501f == null) {
            sb2.append(" processName");
        }
        if ((this.f63504i & 1) == 0) {
            sb2.append(" processId");
        }
        if ((this.f63504i & 2) == 0) {
            sb2.append(" userId");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
    }

    @Override // do.d.a
    public final d.a c(String str) {
        if (str == null) {
            throw new NullPointerException("Null processName");
        }
        this.f63501f = str;
        return this;
    }

    @Override // do.d.a
    public final d.a d(int i11) {
        this.f63503h = i11;
        this.f63504i = (byte) (this.f63504i | 2);
        return this;
    }

    @Override // do.d.a
    public final d.a e(String str) {
        if (str == null) {
            throw new NullPointerException("Null version");
        }
        this.f63498c = str;
        return this;
    }

    @Override // do.d.a
    public final d.a f(String str) {
        if (str == null) {
            throw new NullPointerException("Null bundle");
        }
        this.f63497b = str;
        return this;
    }

    @Override // do.d.a
    public final d.a g(int i11) {
        this.f63502g = i11;
        this.f63504i = (byte) (this.f63504i | 1);
        return this;
    }

    @Override // do.d.a
    public final d.a h(String str) {
        if (str == null) {
            throw new NullPointerException("Null storeId");
        }
        this.f63496a = str;
        return this;
    }
}
