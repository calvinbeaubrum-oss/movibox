package xf;

import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static String a() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
