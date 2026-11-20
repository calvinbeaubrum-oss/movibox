package com.mbridge.msdk.c.a;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static void a(Context context, e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            eVar.a("gaid", com.mbridge.msdk.foundation.tools.e.c());
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("SettingRequestDiff", e11.getMessage());
            }
        }
    }
}
