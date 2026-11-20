package com.mbridge.msdk.mbnative.f.a;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.out.Frame;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends f<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45639a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f45640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f45641c;

    public final String a() {
        return this.f45641c;
    }

    public abstract void a(int i11, String str);

    public final void a(String str) {
        this.f45641c = str;
    }

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, CampaignUnit campaignUnit);

    public final int b() {
        return this.f45640b;
    }

    public abstract void b(List<Frame> list);

    public final void e(int i11) {
        this.f45640b = i11;
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        a(aVar.f44551a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onSuccess(k<JSONObject> kVar) {
        c cVar;
        super.onSuccess(kVar);
        if (kVar == null || (cVar = kVar.f44690b) == null) {
            return;
        }
        int i11 = this.f45640b;
        if (i11 == 0) {
            final List<com.mbridge.msdk.foundation.same.net.d.b> list = cVar.f44606b;
            final JSONObject jSONObject = kVar.f44691c;
            final int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 != iOptInt) {
                a(iOptInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            final String strOptString = jSONObject.optString("version");
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.mbnative.f.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    final CampaignUnit v5CampaignUnit = "v5".equals(strOptString) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data")) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"));
                    com.mbridge.msdk.foundation.same.f.b.e().post(new Runnable() { // from class: com.mbridge.msdk.mbnative.f.a.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CampaignUnit campaignUnit = v5CampaignUnit;
                            if (campaignUnit == null || campaignUnit.getAds() == null || v5CampaignUnit.getAds().size() <= 0) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                b.this.a(iOptInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
                            } else {
                                AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                                b.this.a(list, v5CampaignUnit);
                                b.this.saveRequestTime(v5CampaignUnit.getAds().size());
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
                a(iOptInt2, jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE));
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            CampaignUnit v5CampaignUnit = "v5".equals(jSONObject2.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject2.optJSONObject("data")) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject2.optJSONObject("data"));
            if (v5CampaignUnit == null || v5CampaignUnit.getListFrames() == null || v5CampaignUnit.getListFrames().size() <= 0) {
                a(iOptInt2, jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE));
            } else {
                b(v5CampaignUnit.getListFrames());
                saveRequestTime(v5CampaignUnit.getListFrames().size());
            }
        }
    }
}
