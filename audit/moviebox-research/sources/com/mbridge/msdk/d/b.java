package com.mbridge.msdk.d;

import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static b f43235a = new b();
    }

    private b() {
    }

    public static b getInstance() {
        return a.f43235a;
    }

    public void addInterstitialList(String str, String str2) {
        try {
            com.mbridge.msdk.d.a.C0478a.f43234a.b(str, str2);
        } catch (Exception e11) {
            ad.b("TimerController", "addInterstitialList error:" + e11.getMessage());
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            com.mbridge.msdk.d.a.C0478a.f43234a.a(str, str2);
        } catch (Exception e11) {
            ad.b("TimerController", "addRewardList error:" + e11.getMessage());
        }
    }

    public void start() {
        g gVarB = h.a().b(c.m().k());
        if (gVarB == null) {
            h.a();
            gVarB = i.a();
        }
        int iL = gVarB.l();
        if (iL > 0) {
            com.mbridge.msdk.d.a.C0478a.f43234a.a(iL * 1000);
        }
    }
}
