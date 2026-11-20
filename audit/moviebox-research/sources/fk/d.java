package fk;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static byte[] a(String str) {
        a.g(str, "Input");
        return str.getBytes(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b);
    }

    public static byte[] b(String str, String str2) {
        a.g(str, "Input");
        a.e(str2, "Charset");
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }
}
