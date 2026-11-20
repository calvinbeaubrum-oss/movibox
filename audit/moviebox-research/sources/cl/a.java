package cl;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14953c;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f14955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f14956c;

        @Override // cl.k.a
        public k a() {
            String str = "";
            if (this.f14954a == null) {
                str = " token";
            }
            if (this.f14955b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f14956c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f14954a, this.f14955b.longValue(), this.f14956c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cl.k.a
        public k.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f14954a = str;
            return this;
        }

        @Override // cl.k.a
        public k.a c(long j11) {
            this.f14956c = Long.valueOf(j11);
            return this;
        }

        @Override // cl.k.a
        public k.a d(long j11) {
            this.f14955b = Long.valueOf(j11);
            return this;
        }
    }

    public a(String str, long j11, long j12) {
        this.f14951a = str;
        this.f14952b = j11;
        this.f14953c = j12;
    }

    @Override // cl.k
    @NonNull
    public String b() {
        return this.f14951a;
    }

    @Override // cl.k
    @NonNull
    public long c() {
        return this.f14953c;
    }

    @Override // cl.k
    @NonNull
    public long d() {
        return this.f14952b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f14951a.equals(kVar.b()) && this.f14952b == kVar.d() && this.f14953c == kVar.c();
    }

    public int hashCode() {
        int iHashCode = (this.f14951a.hashCode() ^ 1000003) * 1000003;
        long j11 = this.f14952b;
        long j12 = this.f14953c;
        return ((iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f14951a + ", tokenExpirationTimestamp=" + this.f14952b + ", tokenCreationTimestamp=" + this.f14953c + "}";
    }
}
