package ze;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f81953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f81954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static nf.c f81955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f81956d;

    public static void a() {
        if (!f81956d) {
            throw new IllegalStateException("Do you forget to initialize XLog?");
        }
    }

    public static void b(String str) {
        a();
        f81953a.a(str);
    }

    public static void c(String str) {
        a();
        f81953a.c(str);
    }

    public static void d(String str) {
        a();
        f81953a.e(str);
    }

    public static void e(a aVar) {
        f(aVar, kf.a.i());
    }

    public static void f(a aVar, nf.c... cVarArr) {
        if (f81956d) {
            kf.b.e().g("XLog is already initialized, do not initialize again");
        }
        f81956d = true;
        if (aVar == null) {
            throw new IllegalArgumentException("Please specify a LogConfiguration");
        }
        f81954b = aVar;
        nf.d dVar = new nf.d(cVarArr);
        f81955c = dVar;
        f81953a = new d(f81954b, dVar);
    }

    public static d.a g(String str) {
        return new d.a().x(str);
    }
}
