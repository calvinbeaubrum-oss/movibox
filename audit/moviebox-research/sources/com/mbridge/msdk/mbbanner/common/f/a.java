package com.mbridge.msdk.mbbanner.common.f;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.d.b;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends f<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45389a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45390b = "";

    public abstract void a(int i11, String str);

    public abstract void a(CampaignUnit campaignUnit);

    public final void a(String str) {
        this.f45390b = str;
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        ad.c(f45389a, "onFailed errorCode = " + aVar.f44551a);
        a(aVar.f44551a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onSuccess(k<JSONObject> kVar) {
        super.onSuccess(kVar);
        List<b> list = kVar.f44690b.f44606b;
        final JSONObject jSONObject = kVar.f44691c;
        ad.c(f45389a, "parseLoad content = " + jSONObject);
        final int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != iOptInt) {
            a(iOptInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        final String strOptString = jSONObject.optString("version");
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.f.a.1
            @Override // java.lang.Runnable
            public final void run() {
                final CampaignUnit v5CampaignUnit = "v5".equals(strOptString) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data"), a.this.f45390b) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"), a.this.f45390b);
                com.mbridge.msdk.foundation.same.f.b.e().post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.f.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CampaignUnit campaignUnit = v5CampaignUnit;
                        if (campaignUnit != null && campaignUnit.getAds() != null && v5CampaignUnit.getAds().size() > 0) {
                            a.this.a(v5CampaignUnit);
                            if (!TextUtils.isEmpty(a.this.f45390b)) {
                                a.this.saveHbState(1);
                            }
                            a.this.saveRequestTime(v5CampaignUnit.getAds().size());
                            return;
                        }
                        CampaignUnit campaignUnit2 = v5CampaignUnit;
                        String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                        if (TextUtils.isEmpty(msg)) {
                            msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a.this.a(iOptInt, msg);
                    }
                });
            }
        });
    }
}
