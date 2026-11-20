package androidx.media3.common;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f9541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f9544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9545e;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k f9546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f9549d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9550e;

        public b(k kVar, int i11, int i12) {
            this.f9546a = kVar;
            this.f9547b = i11;
            this.f9548c = i12;
        }

        public z a() {
            return new z(this.f9546a, this.f9547b, this.f9548c, this.f9549d, this.f9550e);
        }

        public b b(float f11) {
            this.f9549d = f11;
            return this;
        }
    }

    public z(k kVar, int i11, int i12, float f11, long j11) {
        z3.a.b(i11 > 0, "width must be positive, but is: " + i11);
        z3.a.b(i12 > 0, "height must be positive, but is: " + i12);
        this.f9541a = kVar;
        this.f9542b = i11;
        this.f9543c = i12;
        this.f9544d = f11;
        this.f9545e = j11;
    }
}
