package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f66906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f66907b;

    public a(int i11) {
        this(i11, null);
    }

    public a(int i11, a aVar) {
        if (i11 != 393216 && i11 != 327680 && i11 != 262144 && i11 != 458752) {
            throw new IllegalArgumentException();
        }
        this.f66906a = i11;
        this.f66907b = aVar;
    }

    public abstract void a(String str, Object obj);

    public abstract a b(String str, String str2);

    public abstract a c(String str);

    public abstract void d();

    public abstract void e(String str, String str2, String str3);
}
