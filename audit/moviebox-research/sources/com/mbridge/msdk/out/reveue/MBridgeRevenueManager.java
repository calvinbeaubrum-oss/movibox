package com.mbridge.msdk.out.reveue;

import android.content.Context;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.l;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeRevenueManager {
    public static void track(Context context, MBridgeRevenueParamsEntity mBridgeRevenueParamsEntity) {
        if (c.m().c() == null) {
            c.m().b(context);
        }
        try {
            HashMap map = new HashMap();
            map.put("name", mBridgeRevenueParamsEntity.getMediationName());
            l.a().a("m_start_ad_rev", "roas", "", "", map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        k.a().a(mBridgeRevenueParamsEntity.getReportData());
    }
}
