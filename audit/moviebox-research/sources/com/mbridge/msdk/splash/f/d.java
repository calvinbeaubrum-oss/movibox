package com.mbridge.msdk.splash.f;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.Frame;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d extends com.mbridge.msdk.foundation.same.net.f<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f47153a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f47154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47155c;

    public final void a(String str) {
        this.f47155c = str;
    }

    public abstract void a(List<Frame> list);

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, CampaignUnit campaignUnit);

    public abstract void b(int i11, String str);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        ad.b(f47153a, "errorCode = " + aVar.f44551a);
        b(aVar.f44551a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
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
        int i11 = this.f47154b;
        if (i11 == 0) {
            final List<com.mbridge.msdk.foundation.same.net.d.b> list = cVar.f44606b;
            final JSONObject jSONObject = kVar.f44691c;
            final int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 != iOptInt) {
                b(iOptInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            final String strOptString = jSONObject.optString("version");
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.splash.f.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    final CampaignUnit v5CampaignUnit = "v5".equals(strOptString) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data"), d.this.f47155c) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"), d.this.f47155c);
                    com.mbridge.msdk.foundation.same.f.b.e().post(new Runnable() { // from class: com.mbridge.msdk.splash.f.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CampaignUnit campaignUnit = v5CampaignUnit;
                            if (campaignUnit != null && campaignUnit.getAds() != null && v5CampaignUnit.getAds().size() > 0) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                d.this.a(list, v5CampaignUnit);
                                d.this.saveRequestTime(v5CampaignUnit.getAds().size());
                            } else {
                                CampaignUnit campaignUnit2 = v5CampaignUnit;
                                String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                                if (TextUtils.isEmpty(msg)) {
                                    msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                                }
                                AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                                d.this.b(iOptInt, msg);
                            }
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
                b(iOptInt2, jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE));
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            CampaignUnit v5CampaignUnit = "v5".equals(jSONObject2.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject2.optJSONObject("data"), this.f47155c) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject2.optJSONObject("data"), this.f47155c);
            if (v5CampaignUnit != null && v5CampaignUnit.getListFrames() != null && v5CampaignUnit.getListFrames().size() > 0) {
                List<Frame> listFrames = v5CampaignUnit.getListFrames();
                a(listFrames);
                saveRequestTime(listFrames.size());
            } else {
                String msg = v5CampaignUnit != null ? v5CampaignUnit.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                b(iOptInt2, msg);
            }
        }
    }
}
