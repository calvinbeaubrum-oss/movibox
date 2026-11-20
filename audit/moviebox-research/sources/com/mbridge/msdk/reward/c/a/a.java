package com.mbridge.msdk.reward.c.a;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.videocommon.d.c;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f46881a;

    private a() {
    }

    public static a a() {
        if (f46881a == null) {
            synchronized (a.class) {
                try {
                    if (f46881a == null) {
                        f46881a = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f46881a;
    }

    public final void a(String str, b bVar) {
        b bVar2;
        List<CampaignEx> listH;
        try {
            if (bVar == null) {
                try {
                    bVar2 = new b();
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            } else {
                bVar2 = bVar;
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB != null) {
                bVar2.h(aVarB.b());
                bVar2.f(aVarB.c());
            }
            if (bVar != null) {
                try {
                    int iJ = bVar.j();
                    String strI = bVar.i();
                    if (TextUtils.isEmpty(strI) && (listH = bVar.h()) != null && listH.size() > 0 && listH.get(0) != null) {
                        strI = listH.get(0).getCampaignUnitId();
                        iJ = listH.get(0).getAdType();
                        bVar.b(iJ);
                        bVar.d(strI);
                    }
                    c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), strI, iJ == 287);
                    if (cVarA != null) {
                        bVar.g(cVarA.l());
                        bVar.n(cVarA.k());
                    }
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        e12.printStackTrace();
                    }
                }
            }
            com.mbridge.msdk.foundation.same.report.d.c.a().a(bVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a(str, bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e13) {
            if (MBridgeConstans.DEBUG) {
                e13.printStackTrace();
            }
        }
    }
}
