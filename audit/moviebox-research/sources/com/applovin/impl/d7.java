package com.applovin.impl;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d7 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static boolean a(Throwable th2) {
            return th2 instanceof DeniedByServerException;
        }

        public static boolean b(Throwable th2) {
            return th2 instanceof NotProvisionedException;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public static boolean a(Throwable th2) {
            return th2 instanceof MediaDrm.MediaDrmStateException;
        }

        public static int b(Throwable th2) {
            return t2.a(xp.a(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {
        public static boolean a(Throwable th2) {
            return e4.p3.a(th2);
        }
    }

    public static int a(Exception exc, int i11) {
        int i12 = xp.f24372a;
        if (i12 >= 21 && b.a(exc)) {
            return b.b(exc);
        }
        if (i12 >= 23 && c.a(exc)) {
            return 6006;
        }
        if (i12 >= 18 && a.b(exc)) {
            return 6002;
        }
        if (i12 >= 18 && a.a(exc)) {
            return 6007;
        }
        if (exc instanceof sp) {
            return 6001;
        }
        if (exc instanceof y5.e) {
            return 6003;
        }
        if (exc instanceof zb) {
            return 6008;
        }
        if (i11 == 1) {
            return 6006;
        }
        if (i11 == 2) {
            return 6004;
        }
        if (i11 == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }
}
