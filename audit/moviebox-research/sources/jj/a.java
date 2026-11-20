package jj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f68006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68007c;

    public a(long j11, long j12, long j13) {
        this.f68005a = j11;
        this.f68006b = j12;
        this.f68007c = j13;
    }

    @Override // jj.l
    public long b() {
        return this.f68006b;
    }

    @Override // jj.l
    public long c() {
        return this.f68005a;
    }

    @Override // jj.l
    public long d() {
        return this.f68007c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f68005a == lVar.c() && this.f68006b == lVar.b() && this.f68007c == lVar.d();
    }

    public int hashCode() {
        long j11 = this.f68005a;
        long j12 = this.f68006b;
        int i11 = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        long j13 = this.f68007c;
        return ((int) ((j13 >>> 32) ^ j13)) ^ i11;
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f68005a + ", elapsedRealtime=" + this.f68006b + ", uptimeMillis=" + this.f68007c + "}";
    }
}
