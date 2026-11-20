package com.mbridge.msdk.click.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f43103a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f43104b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f43105c = 1500;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f43106d = "2000109";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f43107e = "DspFilterUtils";

    public static boolean a(CampaignEx campaignEx, String str, int i11) {
        boolean z11 = false;
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            z11 = campaignEx.getFac() != 0;
            try {
                Context contextC = c.m().c();
                if (contextC != null) {
                    if (URLUtil.isFileUrl(str)) {
                        File file = new File(str.replace("file:////", "").replace("file:///", "").replace("file://", ""));
                        if (file.exists()) {
                            str = ab.b(file);
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=" + f43106d + "&");
                    stringBuffer.append("type=" + i11 + "&");
                    stringBuffer.append("html=" + str + "&");
                    stringBuffer.append("network_type=" + z.l(contextC) + "&");
                    stringBuffer.append("unit_id=" + campaignEx.getCampaignUnitId() + "&");
                    String requestId = campaignEx.getRequestId();
                    if (!TextUtils.isEmpty(requestId)) {
                        stringBuffer.append("rid=");
                        stringBuffer.append(requestId);
                        stringBuffer.append("&");
                    }
                    if (campaignEx.isBidCampaign()) {
                        stringBuffer.append("hb=");
                        stringBuffer.append("1");
                        stringBuffer.append("&");
                    }
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    if (!TextUtils.isEmpty(requestIdNotice)) {
                        stringBuffer.append("rid_n=");
                        stringBuffer.append(requestIdNotice);
                        stringBuffer.append("&");
                    }
                    stringBuffer.append("cid=" + campaignEx.getId());
                    if (j.a().b()) {
                        j.a().a(stringBuffer.toString());
                    } else {
                        q.b(contextC, stringBuffer.toString());
                    }
                }
            } catch (Throwable th2) {
                ad.b(f43107e, th2.getMessage());
            }
        }
        return z11;
    }
}
