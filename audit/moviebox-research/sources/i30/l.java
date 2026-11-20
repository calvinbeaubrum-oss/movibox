package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f66981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f66982b;

    public l(int i11) {
        this(i11, null);
    }

    public l(int i11, l lVar) {
        if (i11 != 393216 && i11 != 327680 && i11 != 262144 && i11 != 458752) {
            throw new IllegalArgumentException();
        }
        this.f66981a = i11;
        this.f66982b = lVar;
    }

    public abstract a a(String str, boolean z11);

    public abstract void b(c cVar);

    public abstract void c();

    public abstract a d(int i11, z zVar, String str, boolean z11);
}
