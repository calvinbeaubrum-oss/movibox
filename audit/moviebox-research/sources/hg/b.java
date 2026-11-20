package hg;

import com.google.firebase.encoders.proto.Protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f66443b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f66444a;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f66445a = null;

        public b a() {
            return new b(this.f66445a);
        }

        public a b(d dVar) {
            this.f66445a = dVar;
            return this;
        }
    }

    public b(d dVar) {
        this.f66444a = dVar;
    }

    public static a b() {
        return new a();
    }

    @Protobuf(tag = 1)
    public d a() {
        return this.f66444a;
    }
}
