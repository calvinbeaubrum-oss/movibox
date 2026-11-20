package d4;

import androidx.media3.common.c0;
import z3.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f62928a;

    /* JADX INFO: compiled from: source.java */
    public class a extends k {
        public a(String... strArr) {
            super(strArr);
        }

        @Override // z3.k
        public void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        c0.a("media3.decoder.av1");
        f62928a = new a("gav1JNI");
    }

    public static boolean a() {
        return f62928a.a();
    }
}
