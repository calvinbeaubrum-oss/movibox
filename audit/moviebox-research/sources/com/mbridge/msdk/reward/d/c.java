package com.mbridge.msdk.reward.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.Frame;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends f<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f46882a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f46883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.d.b f46885d;

    private void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, JSONObject jSONObject, int i11, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        String strB = "";
        if (list != null && list.size() > 0) {
            for (com.mbridge.msdk.foundation.same.net.d.b bVar2 : list) {
                if (bVar2 != null) {
                    String strA = bVar2.a();
                    if (!TextUtils.isEmpty(strA) && strA.equals("data_res_type")) {
                        strB = bVar2.b();
                    }
                }
            }
        }
        String strB2 = "errorCode: 3507 errorMessage: data load failed, errorMsg is " + jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (TextUtils.isEmpty(strB) || !strB.equals("1")) {
            com.mbridge.msdk.foundation.c.b bVarB = i11 == -1 ? com.mbridge.msdk.foundation.c.a.b(880017, strB2) : com.mbridge.msdk.foundation.c.a.b(880003, strB2);
            if (bVar != null) {
                bVar.a(bVarB);
                bVar.b(false);
                if (TextUtils.isEmpty(strB2)) {
                    strB2 = bVarB.b();
                }
            }
            b(i11, strB2, bVar);
            return;
        }
        com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880018, strB2);
        if (bVar != null) {
            bVar.a(bVarB2);
            bVar.b(true);
            if (TextUtils.isEmpty(strB2)) {
                strB2 = bVarB2.b();
            }
        }
        b(i11, strB2, bVar);
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        this.f46885d = bVar;
    }

    public final void a(String str) {
        this.f46884c = str;
    }

    public abstract void a(List<Frame> list);

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, CampaignUnit campaignUnit);

    public abstract void b(int i11, String str, com.mbridge.msdk.foundation.same.report.d.b bVar);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        ad.b(f46882a, "errorCode = " + aVar.f44551a);
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(aVar.f44551a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
        bVar.a("campaign_request_error", aVar);
        bVar.e(aVar.f44552b);
        this.f46885d.a(bVar);
        b(aVar.f44551a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar), this.f46885d);
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onSuccess(k<JSONObject> kVar) {
        com.mbridge.msdk.foundation.same.net.f.c cVar;
        super.onSuccess(kVar);
        if (kVar == null || (cVar = kVar.f44690b) == null) {
            return;
        }
        int i11 = this.f46883b;
        if (i11 == 0) {
            final List<com.mbridge.msdk.foundation.same.net.d.b> list = cVar.f44606b;
            final JSONObject jSONObject = kVar.f44691c;
            final int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 != iOptInt) {
                a(list, jSONObject, iOptInt, this.f46885d);
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            final String strOptString = jSONObject.optString("version");
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.d.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    final CampaignUnit v5CampaignUnit = "v5".equals(strOptString) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data"), c.this.f46884c) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"), c.this.f46884c);
                    com.mbridge.msdk.foundation.same.f.b.e().post(new Runnable() { // from class: com.mbridge.msdk.reward.d.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CampaignUnit campaignUnit = v5CampaignUnit;
                            if (campaignUnit != null && campaignUnit.getAds() != null && v5CampaignUnit.getAds().size() > 0) {
                                v5CampaignUnit.setMetricsData(c.this.f46885d);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                c.this.a(list, v5CampaignUnit);
                                c.this.saveRequestTime(v5CampaignUnit.getAds().size());
                                return;
                            }
                            CampaignUnit campaignUnit2 = v5CampaignUnit;
                            String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                            if (TextUtils.isEmpty(msg)) {
                                msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                            }
                            AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                            c cVar2 = c.this;
                            cVar2.b(iOptInt, msg, cVar2.f46885d);
                        }
                    });
                }
            });
            return;
        }
        if (i11 == 1) {
            List<com.mbridge.msdk.foundation.same.net.d.b> list2 = cVar.f44606b;
            JSONObject jSONObject2 = kVar.f44691c;
            int iOptInt2 = jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 != iOptInt2) {
                a(list2, jSONObject2, iOptInt2, this.f46885d);
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            CampaignUnit v5CampaignUnit = "v5".equals(jSONObject2.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject2.optJSONObject("data"), this.f46884c) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject2.optJSONObject("data"), this.f46884c);
            if (v5CampaignUnit != null && v5CampaignUnit.getListFrames() != null && v5CampaignUnit.getListFrames().size() > 0) {
                List<Frame> listFrames = v5CampaignUnit.getListFrames();
                a(listFrames);
                saveRequestTime(listFrames.size());
            } else {
                String msg = v5CampaignUnit != null ? v5CampaignUnit.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                b(iOptInt2, msg, this.f46885d);
            }
        }
    }
}
