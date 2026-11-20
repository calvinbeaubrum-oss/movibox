package kk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f68624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f68625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f68626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f68627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f68628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f68629i;

    public c(int i11, String str, int i12, long j11, long j12, boolean z11, int i13, String str2, String str3) {
        this.f68621a = i11;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f68622b = str;
        this.f68623c = i12;
        this.f68624d = j11;
        this.f68625e = j12;
        this.f68626f = z11;
        this.f68627g = i13;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f68628h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f68629i = str3;
    }

    @Override // kk.f.b
    public int a() {
        return this.f68621a;
    }

    @Override // kk.f.b
    public int b() {
        return this.f68623c;
    }

    @Override // kk.f.b
    public long d() {
        return this.f68625e;
    }

    @Override // kk.f.b
    public boolean e() {
        return this.f68626f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.b)) {
            return false;
        }
        f.b bVar = (f.b) obj;
        return this.f68621a == bVar.a() && this.f68622b.equals(bVar.g()) && this.f68623c == bVar.b() && this.f68624d == bVar.j() && this.f68625e == bVar.d() && this.f68626f == bVar.e() && this.f68627g == bVar.i() && this.f68628h.equals(bVar.f()) && this.f68629i.equals(bVar.h());
    }

    @Override // kk.f.b
    public String f() {
        return this.f68628h;
    }

    @Override // kk.f.b
    public String g() {
        return this.f68622b;
    }

    @Override // kk.f.b
    public String h() {
        return this.f68629i;
    }

    public int hashCode() {
        int iHashCode = (((((this.f68621a ^ 1000003) * 1000003) ^ this.f68622b.hashCode()) * 1000003) ^ this.f68623c) * 1000003;
        long j11 = this.f68624d;
        int i11 = (iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f68625e;
        return ((((((((i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ (this.f68626f ? 1231 : 1237)) * 1000003) ^ this.f68627g) * 1000003) ^ this.f68628h.hashCode()) * 1000003) ^ this.f68629i.hashCode();
    }

    @Override // kk.f.b
    public int i() {
        return this.f68627g;
    }

    @Override // kk.f.b
    public long j() {
        return this.f68624d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f68621a + ", model=" + this.f68622b + ", availableProcessors=" + this.f68623c + ", totalRam=" + this.f68624d + ", diskSpace=" + this.f68625e + ", isEmulator=" + this.f68626f + ", state=" + this.f68627g + ", manufacturer=" + this.f68628h + ", modelClass=" + this.f68629i + "}";
    }
}
