package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f44073c;

    private c() {
        c();
    }

    public static void c(boolean z11) {
    }

    public static c j() {
        if (f44073c == null) {
            synchronized (c.class) {
                try {
                    if (f44073c == null) {
                        f44073c = new c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44073c;
    }

    public static boolean k() {
        return true;
    }

    @Override // com.mbridge.msdk.foundation.controller.authoritycontroller.b
    public final int b(String str) {
        g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            h.a();
            gVarB = i.a();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return gVarB.av();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return gVarB.au();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return gVarB.aw();
        }
        return -1;
    }

    public final boolean c(String str) {
        boolean z11;
        g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            h.a();
            gVarB = i.a();
            z11 = true;
        } else {
            z11 = false;
        }
        int iAj = gVarB.aj();
        boolean z12 = iAj != 0 ? iAj == 1 && b(str) == 1 : a(str) == 1 && b(str) == 1;
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z12 = a(str) == 1;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) && j().g() == 2) {
            return (gVarB.aG() || z11 || a(str) != 1) ? false : true;
        }
        return z12;
    }
}
