package kk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f68617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f68618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final gk.e f68620f;

    public b(String str, String str2, String str3, String str4, int i11, gk.e eVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f68615a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f68616b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f68617c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f68618d = str4;
        this.f68619e = i11;
        if (eVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f68620f = eVar;
    }

    @Override // kk.f.a
    public String a() {
        return this.f68615a;
    }

    @Override // kk.f.a
    public int c() {
        return this.f68619e;
    }

    @Override // kk.f.a
    public gk.e d() {
        return this.f68620f;
    }

    @Override // kk.f.a
    public String e() {
        return this.f68618d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.a)) {
            return false;
        }
        f.a aVar = (f.a) obj;
        return this.f68615a.equals(aVar.a()) && this.f68616b.equals(aVar.f()) && this.f68617c.equals(aVar.g()) && this.f68618d.equals(aVar.e()) && this.f68619e == aVar.c() && this.f68620f.equals(aVar.d());
    }

    @Override // kk.f.a
    public String f() {
        return this.f68616b;
    }

    @Override // kk.f.a
    public String g() {
        return this.f68617c;
    }

    public int hashCode() {
        return ((((((((((this.f68615a.hashCode() ^ 1000003) * 1000003) ^ this.f68616b.hashCode()) * 1000003) ^ this.f68617c.hashCode()) * 1000003) ^ this.f68618d.hashCode()) * 1000003) ^ this.f68619e) * 1000003) ^ this.f68620f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f68615a + ", versionCode=" + this.f68616b + ", versionName=" + this.f68617c + ", installUuid=" + this.f68618d + ", deliveryMechanism=" + this.f68619e + ", developmentPlatformProvider=" + this.f68620f + "}";
    }
}
