package mg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f71031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.o f71032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.i f71033c;

    public b(long j11, com.google.android.datatransport.runtime.o oVar, com.google.android.datatransport.runtime.i iVar) {
        this.f71031a = j11;
        if (oVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f71032b = oVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f71033c = iVar;
    }

    @Override // mg.k
    public com.google.android.datatransport.runtime.i b() {
        return this.f71033c;
    }

    @Override // mg.k
    public long c() {
        return this.f71031a;
    }

    @Override // mg.k
    public com.google.android.datatransport.runtime.o d() {
        return this.f71032b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f71031a == kVar.c() && this.f71032b.equals(kVar.d()) && this.f71033c.equals(kVar.b());
    }

    public int hashCode() {
        long j11 = this.f71031a;
        return this.f71033c.hashCode() ^ ((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f71032b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f71031a + ", transportContext=" + this.f71032b + ", event=" + this.f71033c + "}";
    }
}
