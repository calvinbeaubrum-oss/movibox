package hg;

import com.google.firebase.encoders.proto.Protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f66451c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f66452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f66453b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f66454a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f66455b = 0;

        public d a() {
            return new d(this.f66454a, this.f66455b);
        }

        public a b(long j11) {
            this.f66454a = j11;
            return this;
        }

        public a c(long j11) {
            this.f66455b = j11;
            return this;
        }
    }

    public d(long j11, long j12) {
        this.f66452a = j11;
        this.f66453b = j12;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f66452a;
    }

    @Protobuf(tag = 2)
    public long b() {
        return this.f66453b;
    }
}
