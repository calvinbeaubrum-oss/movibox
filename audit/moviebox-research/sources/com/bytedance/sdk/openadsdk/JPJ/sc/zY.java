package com.bytedance.sdk.openadsdk.JPJ.sc;

import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    public static int pFF = 6;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static boolean f27102sc = false;
    public static String zY = "engaged_view";

    public static void pFF(Sfl sfl) {
        pFF pffZY = zY(sfl);
        if (pffZY == null) {
            return;
        }
        pffZY.pFF();
    }

    public static void sc(Sfl sfl) {
        pFF pffZY = zY(sfl);
        if (pffZY == null) {
            return;
        }
        pffZY.sc();
    }

    public static void sc(Sfl sfl, int i11) {
        pFF pffZY = zY(sfl);
        if (pffZY == null || pffZY.zY()) {
            return;
        }
        pffZY.sc(i11);
    }

    public static void sc(Sfl sfl, boolean z11) {
        pFF pffZY = zY(sfl);
        if (pffZY == null || pffZY.zY()) {
            return;
        }
        pffZY.sc(z11);
        pffZY.sc(z11 ? 4 : 8);
    }

    private static pFF zY(Sfl sfl) {
        if (sfl == null || !sfl.wy()) {
            return null;
        }
        return sfl.rC();
    }
}
