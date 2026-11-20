package vf;

import java.nio.charset.Charset;
import uf.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static e a(String str, int i11) {
        uf.a aVarA = a.a();
        aVarA.o(i11);
        return aVarA.e(str, null);
    }

    public static e b(String str, int i11, String str2) {
        uf.a aVarA = a.a();
        aVarA.o(i11);
        return aVarA.j(str, "application/json", str2.getBytes(Charset.forName("UTF-8")));
    }
}
