package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g8 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19163a;

    public g8(int i11) {
        super(a(i11));
        this.f19163a = i11;
    }

    private static String a(int i11) {
        if (i11 == 1) {
            return "Player release timed out.";
        }
        if (i11 != 2) {
            return i11 != 3 ? "Undefined timeout." : "Detaching surface timed out.";
        }
        return "Setting foreground mode timed out.";
    }
}
