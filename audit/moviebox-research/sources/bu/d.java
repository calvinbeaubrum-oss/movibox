package bu;

import java.io.Closeable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                zt.a.f82154a.d("error", th2.getMessage());
            }
        }
    }
}
