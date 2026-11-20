package eg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f64168a;

    public h(long j11) {
        this.f64168a = j11;
    }

    @Override // eg.n
    public long c() {
        return this.f64168a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f64168a == ((n) obj).c();
    }

    public int hashCode() {
        long j11 = this.f64168a;
        return 1000003 ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f64168a + "}";
    }
}
