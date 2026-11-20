package com.pgl.ssdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f48793a = -1;

    public static String a() {
        int i11 = f48793a;
        if (i11 != 0) {
            return i11 != 1 ? "" : "https://ssdk-va.pangle.io/ssdk/v2/r";
        }
        return "https://ssdk-sg.pangle.io/ssdk/v2/r";
    }

    public static void a(int i11) {
        f48793a = i11;
    }

    public static String b() {
        int i11 = f48793a;
        if (i11 != 0) {
            return i11 != 1 ? "" : "https://ssdk-va.pangle.io/ssdk/sd/token";
        }
        return "https://ssdk-sg.pangle.io/ssdk/sd/token";
    }
}
