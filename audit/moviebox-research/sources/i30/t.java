package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f67057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f67058b;

    public t(int i11) {
        this(i11, null);
    }

    public t(int i11, t tVar) {
        if (i11 != 393216 && i11 != 458752) {
            throw new IllegalArgumentException();
        }
        this.f67057a = i11;
        this.f67058b = tVar;
    }

    public abstract void a();

    public abstract void b(String str, int i11, String... strArr);

    public abstract void c(String str);

    public abstract void d(String str, int i11, String... strArr);

    public abstract void e(String str);

    public abstract void f(String str, String... strArr);

    public abstract void g(String str, int i11, String str2);

    public abstract void h(String str);
}
