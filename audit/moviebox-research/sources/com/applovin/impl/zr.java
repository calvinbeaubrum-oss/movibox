package com.applovin.impl;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f24915a = Pattern.compile("^NOTE([ \t].*)?$");

    public static float a(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static boolean a(bh bhVar) {
        String strL = bhVar.l();
        return strL != null && strL.startsWith("WEBVTT");
    }

    public static long b(String str) {
        String[] strArrB = xp.b(str, "\\.");
        long j11 = 0;
        for (String str2 : xp.a(strArrB[0], ":")) {
            j11 = (j11 * 60) + Long.parseLong(str2);
        }
        long j12 = j11 * 1000;
        if (strArrB.length == 2) {
            j12 += Long.parseLong(strArrB[1]);
        }
        return j12 * 1000;
    }

    public static void b(bh bhVar) throws dh {
        int iD = bhVar.d();
        if (a(bhVar)) {
            return;
        }
        bhVar.f(iD);
        throw dh.a("Expected WEBVTT. Got " + bhVar.l(), null);
    }
}
