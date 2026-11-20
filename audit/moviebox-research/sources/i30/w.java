package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f67083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f67084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f67085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f67086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f67087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f67088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f67089g;

    public w(int i11, int i12, String str, String str2, String str3, long j11) {
        this.f67083a = i11;
        this.f67084b = i12;
        this.f67085c = str;
        this.f67086d = str2;
        this.f67087e = str3;
        this.f67088f = j11;
    }

    public int a() {
        if (this.f67089g == 0) {
            this.f67089g = y.c(this.f67087e);
        }
        return this.f67089g;
    }
}
