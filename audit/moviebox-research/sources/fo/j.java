package fo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f65186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f65187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f65188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f65189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f65190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f65191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f65192g;

    public j() {
    }

    public j(b bVar) {
        this.f65186a = bVar.d();
        this.f65187b = bVar.f();
        this.f65188c = bVar.h();
        this.f65189d = bVar.i();
        this.f65190e = bVar.c();
        this.f65191f = bVar.k();
        this.f65192g = (byte) 3;
    }

    @Override // fo.b.a
    public final b.a a(String str) {
        if (str == null) {
            throw new NullPointerException("Null operatingSystemVersion");
        }
        this.f65188c = str;
        return this;
    }

    @Override // fo.b.a
    public final b.a b(int i11) {
        this.f65190e = i11;
        this.f65192g = (byte) (this.f65192g | 1);
        return this;
    }

    @Override // fo.b.a
    public final b build() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f65192g == 3 && (str = this.f65186a) != null && (str2 = this.f65187b) != null && (str3 = this.f65188c) != null && (str4 = this.f65189d) != null) {
            return new b(str, str2, str3, str4, this.f65190e, this.f65191f);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f65186a == null) {
            sb2.append(" make");
        }
        if (this.f65187b == null) {
            sb2.append(" model");
        }
        if (this.f65188c == null) {
            sb2.append(" operatingSystemVersion");
        }
        if (this.f65189d == null) {
            sb2.append(" supportedAbis");
        }
        if ((this.f65192g & 1) == 0) {
            sb2.append(" logicalProcessors");
        }
        if ((this.f65192g & 2) == 0) {
            sb2.append(" totalMemoryBytes");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
    }

    @Override // fo.b.a
    public final b.a c(String str) {
        if (str == null) {
            throw new NullPointerException("Null supportedAbis");
        }
        this.f65189d = str;
        return this;
    }

    @Override // fo.b.a
    public final b.a d(String str) {
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f65187b = str;
        return this;
    }

    @Override // fo.b.a
    public final b.a e(String str) {
        if (str == null) {
            throw new NullPointerException("Null make");
        }
        this.f65186a = str;
        return this;
    }

    @Override // fo.b.a
    public final b.a f(long j11) {
        this.f65191f = j11;
        this.f65192g = (byte) (this.f65192g | 2);
        return this;
    }
}
