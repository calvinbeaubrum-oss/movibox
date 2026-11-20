package fo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements a.InterfaceC0676a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f65182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f65183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f65184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f65185d;

    public i() {
    }

    public i(a aVar) {
        this.f65182a = aVar.g();
        this.f65183b = aVar.d();
        this.f65184c = aVar.c();
        this.f65185d = (byte) 3;
    }

    @Override // fo.a.InterfaceC0676a
    public final a.InterfaceC0676a a(String str) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.f65183b = str;
        return this;
    }

    @Override // fo.a.InterfaceC0676a
    public final a.InterfaceC0676a b(long j11) {
        this.f65182a = j11;
        this.f65185d = (byte) (this.f65185d | 1);
        return this;
    }

    @Override // fo.a.InterfaceC0676a
    public final a build() {
        String str;
        if (this.f65185d == 3 && (str = this.f65183b) != null) {
            return new a(this.f65182a, str, this.f65184c);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f65185d & 1) == 0) {
            sb2.append(" timestampSeconds");
        }
        if (this.f65183b == null) {
            sb2.append(" id");
        }
        if ((this.f65185d & 2) == 0) {
            sb2.append(" count");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
    }

    @Override // fo.a.InterfaceC0676a
    public final a.InterfaceC0676a c(int i11) {
        this.f65184c = i11;
        this.f65185d = (byte) (this.f65185d | 2);
        return this;
    }
}
