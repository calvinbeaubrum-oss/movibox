package ho;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends a.AbstractC0700a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f66715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f66716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f66718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f66719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f66720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f66721g;

    public l() {
    }

    public l(a aVar) {
        this.f66715a = aVar.k();
        this.f66716b = aVar.h();
        this.f66717c = aVar.c();
        this.f66718d = aVar.j();
        this.f66719e = aVar.e();
        this.f66720f = aVar.g();
        this.f66721g = (byte) 7;
    }

    @Override // ho.a.AbstractC0700a
    public final int a() {
        if ((this.f66721g & 2) != 0) {
            return this.f66717c;
        }
        throw new IllegalStateException("Property \"activeNetworkIndex\" has not been set");
    }

    @Override // ho.a.AbstractC0700a
    public final a.AbstractC0700a b(int i11) {
        this.f66717c = i11;
        this.f66721g = (byte) (this.f66721g | 2);
        return this;
    }

    @Override // ho.a.AbstractC0700a
    public final a.AbstractC0700a c(int i11) {
        this.f66719e = i11;
        this.f66721g = (byte) (this.f66721g | 4);
        return this;
    }

    @Override // ho.a.AbstractC0700a
    public final int d() {
        if ((this.f66721g & 4) != 0) {
            return this.f66719e;
        }
        throw new IllegalStateException("Property \"activeSubscriptionIndex\" has not been set");
    }

    @Override // ho.a.AbstractC0700a
    public final a f() {
        List list;
        List list2;
        String str;
        if (this.f66721g == 7 && (list = this.f66716b) != null && (list2 = this.f66718d) != null && (str = this.f66720f) != null) {
            return new a(this.f66715a, list, this.f66717c, list2, this.f66719e, str);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f66721g & 1) == 0) {
            sb2.append(" timestampSeconds");
        }
        if (this.f66716b == null) {
            sb2.append(" networks");
        }
        if ((this.f66721g & 2) == 0) {
            sb2.append(" activeNetworkIndex");
        }
        if (this.f66718d == null) {
            sb2.append(" subscriptions");
        }
        if ((this.f66721g & 4) == 0) {
            sb2.append(" activeSubscriptionIndex");
        }
        if (this.f66720f == null) {
            sb2.append(" mmsUserAgent");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
    }

    @Override // ho.a.AbstractC0700a
    public final List g() {
        List list = this.f66716b;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"networks\" has not been set");
    }

    @Override // ho.a.AbstractC0700a
    public final List h() {
        List list = this.f66718d;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"subscriptions\" has not been set");
    }

    @Override // ho.a.AbstractC0700a
    public final a.AbstractC0700a i(String str) {
        if (str == null) {
            throw new NullPointerException("Null mmsUserAgent");
        }
        this.f66720f = str;
        return this;
    }

    @Override // ho.a.AbstractC0700a
    public final a.AbstractC0700a j(List list) {
        if (list == null) {
            throw new NullPointerException("Null networks");
        }
        this.f66716b = list;
        return this;
    }

    @Override // ho.a.AbstractC0700a
    public final a.AbstractC0700a k(List list) {
        if (list == null) {
            throw new NullPointerException("Null subscriptions");
        }
        this.f66718d = list;
        return this;
    }

    @Override // ho.a.AbstractC0700a
    public final a.AbstractC0700a l(long j11) {
        this.f66715a = j11;
        this.f66721g = (byte) (this.f66721g | 1);
        return this;
    }
}
