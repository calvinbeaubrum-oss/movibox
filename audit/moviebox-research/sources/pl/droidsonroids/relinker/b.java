package pl.droidsonroids.relinker;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance);
    }

    /* JADX INFO: renamed from: pl.droidsonroids.relinker.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0806b {
        void a(String str);

        String b(String str);

        String c(String str);

        String[] d();

        void e(String str);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, c cVar) {
        new ReLinkerInstance().f(context, str, str2, cVar);
    }
}
