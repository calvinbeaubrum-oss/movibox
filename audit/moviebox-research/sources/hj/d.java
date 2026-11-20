package hj;

import com.google.common.base.m;
import java.io.IOException;
import java.nio.CharBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static CharBuffer a() {
        return CharBuffer.allocate(2048);
    }

    public static <T> T b(Readable readable, j<T> jVar) throws IOException {
        String strB;
        m.p(readable);
        m.p(jVar);
        k kVar = new k(readable);
        do {
            strB = kVar.b();
            if (strB == null) {
                break;
            }
        } while (jVar.b(strB));
        return jVar.a();
    }
}
