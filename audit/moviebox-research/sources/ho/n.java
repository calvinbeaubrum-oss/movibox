package ho;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f66737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f66740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f66741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f66742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f66743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f66744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f66745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f66746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte f66747k;

    public n() {
    }

    public n(k kVar) {
        this.f66737a = kVar.g();
        this.f66738b = kVar.e();
        this.f66739c = kVar.c();
        this.f66740d = kVar.d();
        this.f66741e = kVar.m();
        this.f66742f = kVar.n();
        this.f66743g = kVar.f();
        this.f66744h = kVar.j();
        this.f66745i = kVar.k();
        this.f66746j = kVar.i();
        this.f66747k = (byte) 7;
    }

    @Override // ho.k.a
    public final k.a a(String str) {
        if (str == null) {
            throw new NullPointerException("Null countryCode");
        }
        this.f66743g = str;
        return this;
    }

    @Override // ho.k.a
    public final k.a b(String str) {
        if (str == null) {
            throw new NullPointerException("Null operatorCode");
        }
        this.f66741e = str;
        return this;
    }

    @Override // ho.k.a
    public final k build() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (this.f66747k == 7 && (str = this.f66740d) != null && (str2 = this.f66741e) != null && (str3 = this.f66742f) != null && (str4 = this.f66743g) != null && (str5 = this.f66744h) != null && (str6 = this.f66745i) != null && (str7 = this.f66746j) != null) {
            return new k(this.f66737a, this.f66738b, this.f66739c, str, str2, str3, str4, str5, str6, str7);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f66747k & 1) == 0) {
            sb2.append(" id");
        }
        if ((this.f66747k & 2) == 0) {
            sb2.append(" connectionType");
        }
        if ((this.f66747k & 4) == 0) {
            sb2.append(" carrierId");
        }
        if (this.f66740d == null) {
            sb2.append(" carrierName");
        }
        if (this.f66741e == null) {
            sb2.append(" operatorCode");
        }
        if (this.f66742f == null) {
            sb2.append(" operatorName");
        }
        if (this.f66743g == null) {
            sb2.append(" countryCode");
        }
        if (this.f66744h == null) {
            sb2.append(" networkOperatorCode");
        }
        if (this.f66745i == null) {
            sb2.append(" networkOperatorName");
        }
        if (this.f66746j == null) {
            sb2.append(" networkCountryCode");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
    }

    @Override // ho.k.a
    public final k.a c(String str) {
        if (str == null) {
            throw new NullPointerException("Null networkCountryCode");
        }
        this.f66746j = str;
        return this;
    }

    @Override // ho.k.a
    public final k.a d(int i11) {
        this.f66737a = i11;
        this.f66747k = (byte) (this.f66747k | 1);
        return this;
    }

    @Override // ho.k.a
    public final k.a e(int i11) {
        this.f66739c = i11;
        this.f66747k = (byte) (this.f66747k | 4);
        return this;
    }

    @Override // ho.k.a
    public final k.a f(String str) {
        if (str == null) {
            throw new NullPointerException("Null networkOperatorName");
        }
        this.f66745i = str;
        return this;
    }

    @Override // ho.k.a
    public final k.a g(int i11) {
        this.f66738b = i11;
        this.f66747k = (byte) (this.f66747k | 2);
        return this;
    }

    @Override // ho.k.a
    public final k.a h(String str) {
        if (str == null) {
            throw new NullPointerException("Null carrierName");
        }
        this.f66740d = str;
        return this;
    }

    @Override // ho.k.a
    public final k.a i(String str) {
        if (str == null) {
            throw new NullPointerException("Null networkOperatorCode");
        }
        this.f66744h = str;
        return this;
    }

    @Override // ho.k.a
    public final k.a j(String str) {
        if (str == null) {
            throw new NullPointerException("Null operatorName");
        }
        this.f66742f = str;
        return this;
    }
}
