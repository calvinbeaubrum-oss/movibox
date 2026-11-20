package com.mbridge.msdk.mbnative.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbnative.controller.NativeController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {
    private static List<String> a(CampaignEx campaignEx) {
        ArrayList arrayList = new ArrayList();
        if (campaignEx == null) {
            return arrayList;
        }
        String ad_url_list = campaignEx.getAd_url_list();
        if (TextUtils.isEmpty(ad_url_list)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(ad_url_list);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add((String) jSONArray.get(i11));
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return arrayList;
    }

    private static synchronized void a(final CampaignEx campaignEx, final Context context, String str) {
        try {
            c.m().a(context);
            if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
                com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.mbnative.e.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            k.a(h.a(context)).a(campaignEx.getId());
                        } catch (Exception unused) {
                            ad.b("NativeReportUtils", "campain can't insert db");
                        }
                    }
                });
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43072g);
            }
            if (!TextUtils.isEmpty(str) && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().p() != null) {
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().p(), false, false);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void a(CampaignEx campaignEx, Context context, String str, com.mbridge.msdk.mbnative.d.a aVar) {
        if (campaignEx == null) {
            return;
        }
        try {
            g gVarA = com.mbridge.msdk.c.h.a().a(c.m().k());
            boolean z11 = gVarA != null ? gVarA.r() == 1 : true;
            if (!campaignEx.isReport()) {
                campaignEx.setReport(true);
                a(campaignEx, context, str);
                a(campaignEx, context, str, aVar, z11);
                List<String> listA = a(campaignEx);
                if (listA != null && listA.size() != 0) {
                    for (int i11 = 0; i11 < listA.size(); i11++) {
                        String str2 = listA.get(i11);
                        if (!TextUtils.isEmpty(str2)) {
                            com.mbridge.msdk.click.a.a(context, campaignEx, str, str2, false, false);
                        }
                    }
                }
                b(campaignEx, context, str);
            }
            if (aVar != null && !campaignEx.isCallBackImpression()) {
                if (!z11) {
                    try {
                        aVar.onLoggingImpression(campaignEx.getType());
                    } catch (Exception e11) {
                        Log.e("NativeReportUtils", e11.getMessage());
                    }
                }
                campaignEx.setCallBackImpression(true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static synchronized void a(CampaignEx campaignEx, Context context, String str, com.mbridge.msdk.mbnative.d.a aVar, boolean z11) {
        Map<String, Long> map;
        if (!TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) && (map = NativeController.f45460b) != null && !map.containsKey(campaignEx.getOnlyImpressionURL())) {
            if (z11 && aVar != null) {
                try {
                    aVar.onLoggingImpression(campaignEx.getAdType());
                } catch (Exception e11) {
                    Log.e("NativeReportUtils", e11.getMessage());
                }
            }
            NativeController.f45460b.put(campaignEx.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43073h);
        }
    }

    private static synchronized void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls != null && pv_urls.size() > 0) {
                    Iterator<String> it = pv_urls.iterator();
                    while (it.hasNext()) {
                        com.mbridge.msdk.click.a.a(context, campaignEx, str, it.next(), false, true);
                    }
                }
            } catch (Throwable th2) {
                ad.a("NativeReportUtils", th2.getMessage());
            }
        }
    }
}
