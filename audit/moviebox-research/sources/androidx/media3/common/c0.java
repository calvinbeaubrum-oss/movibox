package androidx.media3.common;

import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f9121a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f9122b = "media3.common";

    public static synchronized void a(String str) {
        if (f9121a.add(str)) {
            f9122b += ", " + str;
        }
    }

    public static synchronized String b() {
        return f9122b;
    }
}
