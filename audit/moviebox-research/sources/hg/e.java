package hg;

import com.google.firebase.encoders.proto.Protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f66456c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f66457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f66458b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f66459a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f66460b = 0;

        public e a() {
            return new e(this.f66459a, this.f66460b);
        }

        public a b(long j11) {
            this.f66460b = j11;
            return this;
        }

        public a c(long j11) {
            this.f66459a = j11;
            return this;
        }
    }

    public e(long j11, long j12) {
        this.f66457a = j11;
        this.f66458b = j12;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 2)
    public long a() {
        return this.f66458b;
    }

    @Protobuf(tag = 1)
    public long b() {
        return this.f66457a;
    }
}
