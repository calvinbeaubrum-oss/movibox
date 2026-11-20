package androidx.media3.exoplayer.offline;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadRequest f10901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f10908h;

    public c(DownloadRequest downloadRequest, int i11, long j11, long j12, long j13, int i12, int i13) {
        this(downloadRequest, i11, j11, j12, j13, i12, i13, new l());
    }

    public c(DownloadRequest downloadRequest, int i11, long j11, long j12, long j13, int i12, int i13, l lVar) {
        z3.a.e(lVar);
        z3.a.a((i13 == 0) == (i11 != 4));
        if (i12 != 0) {
            z3.a.a((i11 == 2 || i11 == 0) ? false : true);
        }
        this.f10901a = downloadRequest;
        this.f10902b = i11;
        this.f10903c = j11;
        this.f10904d = j12;
        this.f10905e = j13;
        this.f10906f = i12;
        this.f10907g = i13;
        this.f10908h = lVar;
    }

    public long a() {
        return this.f10908h.f10912a;
    }

    public float b() {
        return this.f10908h.f10913b;
    }

    public boolean c() {
        int i11 = this.f10902b;
        return i11 == 3 || i11 == 4;
    }
}
