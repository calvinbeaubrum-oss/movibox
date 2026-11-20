package id;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e {

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final a f67195g8 = a.f67196a;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f67196a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Handler f67197b = new Handler(Looper.getMainLooper());

        public final Handler a() {
            return f67197b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public static Handler a(e eVar) {
            return e.f67195g8.a();
        }

        public static boolean b(e eVar, Runnable runnable) {
            Intrinsics.g(runnable, "runnable");
            return eVar.postDelayed(runnable, 0L);
        }

        public static boolean c(e eVar, Runnable runnable, long j11) {
            Intrinsics.g(runnable, "runnable");
            return e.f67195g8.a().postAtTime(runnable, eVar, j11);
        }

        public static boolean d(e eVar, Object obj, long j11, Runnable runnable) {
            Intrinsics.g(runnable, "runnable");
            Handler handlerA = e.f67195g8.a();
            Object obj2 = eVar;
            if (obj != null) {
                obj2 = obj;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (j11 < 0) {
                j11 = 0;
            }
            return handlerA.postAtTime(runnable, obj2, jUptimeMillis + j11);
        }

        public static boolean e(e eVar, Runnable runnable, long j11) {
            Intrinsics.g(runnable, "runnable");
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (j11 < 0) {
                j11 = 0;
            }
            return eVar.postAtTime(runnable, jUptimeMillis + j11);
        }

        public static void f(e eVar) {
            e.f67195g8.a().removeCallbacksAndMessages(eVar);
        }

        public static void g(e eVar, Runnable runnable) {
            Intrinsics.g(runnable, "runnable");
            e.f67195g8.a().removeCallbacks(runnable);
        }

        public static void h(e eVar, Object obj) {
            Handler handlerA = e.f67195g8.a();
            Object obj2 = eVar;
            if (obj != null) {
                obj2 = obj;
            }
            handlerA.removeCallbacksAndMessages(obj2);
        }
    }

    boolean postAtTime(Runnable runnable, long j11);

    boolean postDelayed(Runnable runnable, long j11);
}
