package com.applovin.impl;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j5 extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19855a;

    public j5(int i11) {
        this.f19855a = i11;
    }

    public j5(String str, int i11) {
        super(str);
        this.f19855a = i11;
    }

    public j5(String str, Throwable th2, int i11) {
        super(str, th2);
        this.f19855a = i11;
    }

    public j5(Throwable th2, int i11) {
        super(th2);
        this.f19855a = i11;
    }

    public static boolean a(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof j5) && ((j5) cause).f19855a == 2008) {
                return true;
            }
        }
        return false;
    }
}
