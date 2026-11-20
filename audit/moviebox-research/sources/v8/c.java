package v8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f78762a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f78763b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f78764c = "";

    public static void a() {
        f78762a = false;
        c(7);
    }

    public static void b() {
        f78762a = true;
        c(3);
    }

    public static void c(int i11) {
        f78763b = i11;
    }

    public static void d(String str) {
        f78764c = str;
    }

    public static boolean e() {
        return f78762a;
    }
}
