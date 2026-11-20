package cr;

import athena.a0;
import athena.j0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f62788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CopyOnWriteArrayList<Integer> f62789b = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList<Integer> a() {
        return f62789b;
    }

    public static boolean b(int i11) {
        if (f62789b.contains(Integer.valueOf(i11))) {
            return false;
        }
        return f62789b.add(Integer.valueOf(i11));
    }

    public static boolean c(long j11) {
        return f62789b.contains(Integer.valueOf(j0.a(j11)));
    }

    public static int d() {
        return f62788a;
    }

    public static void e(int i11) {
        if (f62788a != 0) {
            a0.a("The host appId has been set 2 times");
        }
        f62788a = i11;
    }
}
