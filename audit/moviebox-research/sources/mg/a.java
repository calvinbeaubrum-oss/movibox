package mg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f71021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f71022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f71023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f71024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f71025f;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f71026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f71027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f71028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f71029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f71030e;

        @Override // mg.e.a
        public e a() {
            String str = "";
            if (this.f71026a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f71027b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f71028c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f71029d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f71030e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f71026a.longValue(), this.f71027b.intValue(), this.f71028c.intValue(), this.f71029d.longValue(), this.f71030e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // mg.e.a
        public e.a b(int i11) {
            this.f71028c = Integer.valueOf(i11);
            return this;
        }

        @Override // mg.e.a
        public e.a c(long j11) {
            this.f71029d = Long.valueOf(j11);
            return this;
        }

        @Override // mg.e.a
        public e.a d(int i11) {
            this.f71027b = Integer.valueOf(i11);
            return this;
        }

        @Override // mg.e.a
        public e.a e(int i11) {
            this.f71030e = Integer.valueOf(i11);
            return this;
        }

        @Override // mg.e.a
        public e.a f(long j11) {
            this.f71026a = Long.valueOf(j11);
            return this;
        }
    }

    public a(long j11, int i11, int i12, long j12, int i13) {
        this.f71021b = j11;
        this.f71022c = i11;
        this.f71023d = i12;
        this.f71024e = j12;
        this.f71025f = i13;
    }

    @Override // mg.e
    public int b() {
        return this.f71023d;
    }

    @Override // mg.e
    public long c() {
        return this.f71024e;
    }

    @Override // mg.e
    public int d() {
        return this.f71022c;
    }

    @Override // mg.e
    public int e() {
        return this.f71025f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f71021b == eVar.f() && this.f71022c == eVar.d() && this.f71023d == eVar.b() && this.f71024e == eVar.c() && this.f71025f == eVar.e();
    }

    @Override // mg.e
    public long f() {
        return this.f71021b;
    }

    public int hashCode() {
        long j11 = this.f71021b;
        int i11 = (((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f71022c) * 1000003) ^ this.f71023d) * 1000003;
        long j12 = this.f71024e;
        return this.f71025f ^ ((i11 ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f71021b + ", loadBatchSize=" + this.f71022c + ", criticalSectionEnterTimeoutMs=" + this.f71023d + ", eventCleanUpAge=" + this.f71024e + ", maxBlobByteSizePerRow=" + this.f71025f + "}";
    }
}
