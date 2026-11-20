package com.mbridge.msdk.newreward.function.d.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.cloud.config.utils.ConstantsKt;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.a.m;
import com.mbridge.msdk.e.a.o;
import com.mbridge.msdk.e.a.p;
import com.mbridge.msdk.e.a.r;
import com.mbridge.msdk.e.a.u;
import com.mbridge.msdk.e.a.v;
import com.mbridge.msdk.e.a.y;
import com.mbridge.msdk.e.a.z;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.VolleyErrorUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends p<JSONObject> implements r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.newreward.function.d.a.b f46308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f46309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f46310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f46311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f46312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f46313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f46314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f46315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private v f46316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f46317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f46318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f46319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f46320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f46321n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f46322o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map<String, String> f46323p;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.d.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0508a implements com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f46324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.d.a.b f46325b;

        public C0508a(a aVar, com.mbridge.msdk.newreward.function.d.a.b bVar) {
            this.f46324a = aVar;
            this.f46325b = bVar;
        }

        @Override // com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a
        public final void a(String str, long j11) {
            ad.a("BaseCampaignRequest", "onTimeout taskID = " + str + ", timeout = " + j11);
            f.a();
            a aVar = this.f46324a;
            if (aVar != null && !aVar.m()) {
                aVar.c();
            }
            a.a(this.f46324a, this.f46325b, j11);
        }
    }

    public a(int i11, String str, String str2, String str3, long j11, String str4) {
        super(0, str4);
        this.f46309b = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f46310c = i11;
        this.f46311d = str;
        this.f46312e = str2;
        this.f46313f = str3;
        this.f46319l = UUID.randomUUID().toString();
        this.f46317j = SystemClock.elapsedRealtime();
        this.f46322o = str4;
        this.f46308a = new com.mbridge.msdk.newreward.function.d.a.b(this.f46310c, this.f46311d, this.f46312e, this.f46313f);
        a((r.a) this);
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46319l, j11 <= 0 ? 30000L : j11, new C0508a(this, this.f46308a));
    }

    public static /* synthetic */ void a(a aVar, com.mbridge.msdk.newreward.function.d.a.b bVar, long j11) {
        c cVar;
        if (aVar == null || bVar == null || (cVar = aVar.f46315h) == null) {
            return;
        }
        try {
            cVar.a(bVar, aVar, j11, new b(10, "v3 is timeout"));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("BaseCampaignRequest", "onTimeout Exception: ", e11);
            }
        }
    }

    private static void a(a aVar, com.mbridge.msdk.newreward.function.d.a.b bVar, b bVar2) {
        c cVar;
        if (aVar == null || bVar == null || (cVar = aVar.f46315h) == null) {
            return;
        }
        try {
            cVar.a(bVar, aVar, bVar2);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("BaseCampaignRequest", "handlerOnFailedEvent Exception: ", e11);
            }
        }
    }

    @Override // com.mbridge.msdk.e.a.p
    public final r<JSONObject> a(m mVar) {
        if (mVar != null) {
            try {
                byte[] bArr = mVar.f43803b;
                if (bArr != null && bArr.length != 0) {
                    return r.a(new JSONObject(new String(bArr, com.mbridge.msdk.e.a.a.e.a(mVar.f43804c))), com.mbridge.msdk.e.a.a.e.a(mVar));
                }
            } catch (UnsupportedEncodingException e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("BaseCampaignRequest", "parseNetworkResponse UnsupportedEncodingException: ", e11);
                }
                return r.a(new com.mbridge.msdk.e.a.g(e11));
            } catch (JSONException e12) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("BaseCampaignRequest", "parseNetworkResponse JSONException: ", e12);
                }
                return r.a(new o(e12));
            } catch (Exception e13) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("BaseCampaignRequest", "parseNetworkResponse Exception: ", e13);
                }
                return r.a(new y(e13));
            }
        }
        return r.a(new u());
    }

    @Override // com.mbridge.msdk.e.a.p
    public final Map<String, String> a() {
        if (this.f46314g == null) {
            this.f46314g = new HashMap();
        }
        return this.f46314g;
    }

    @Override // com.mbridge.msdk.e.a.r.a
    public final void a(z zVar) {
        c cVar;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46319l);
        if (MBridgeConstans.DEBUG) {
            ad.b("BaseCampaignRequest", "onErrorResponse: " + zVar.getMessage());
        }
        com.mbridge.msdk.newreward.function.d.a.b bVar = this.f46308a;
        if (bVar == null || (cVar = this.f46315h) == null) {
            return;
        }
        try {
            cVar.b(bVar, this, VolleyErrorUtils.parseVolleyError(zVar));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("BaseCampaignRequest", "onError Exception: ", e11);
            }
        }
    }

    public final void a(c cVar) {
        this.f46315h = cVar;
    }

    @Override // com.mbridge.msdk.e.a.p
    public final /* synthetic */ void a(JSONObject jSONObject) {
        c cVar;
        JSONObject jSONObject2 = jSONObject;
        if (MBridgeConstans.DEBUG) {
            ad.a("BaseCampaignRequest", "deliverResponse: " + jSONObject2);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46319l);
        int iOptInt = jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS);
        if (iOptInt == 1) {
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                CampaignUnit campaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObjectOptJSONObject, this.f46320m);
                this.f46308a.a(jSONObjectOptJSONObject);
                this.f46308a.f(jSONObjectOptJSONObject.optString("c"));
                this.f46308a.e(jSONObjectOptJSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
                this.f46308a.d(jSONObjectOptJSONObject.optString("a"));
                this.f46308a.b(jSONObjectOptJSONObject.optInt("template"));
                this.f46308a.a(System.currentTimeMillis());
                this.f46308a.c(this.f46320m);
                this.f46308a.g(jSONObjectOptJSONObject.optString(com.mbridge.msdk.foundation.same.a.S));
                this.f46308a.a(1);
                this.f46308a.c(0);
                this.f46308a.a(campaignUnit.getRequestId());
                this.f46308a.a(campaignUnit.getEcppv());
                this.f46308a.i(this.f46322o);
                ArrayList arrayList = new ArrayList();
                ArrayList<CampaignEx> ads = campaignUnit.getAds();
                for (CampaignEx campaignEx : ads) {
                    campaignEx.setRequestId(this.f46308a.d());
                    campaignEx.setLocalRequestId(this.f46321n);
                    com.mbridge.msdk.newreward.function.d.a.a aVar = new com.mbridge.msdk.newreward.function.d.a.a(this.f46308a);
                    aVar.c(campaignEx.getRequestIdNotice());
                    aVar.b(campaignEx.getAppName());
                    aVar.a(campaignEx.getId());
                    aVar.a(campaignEx);
                    arrayList.add(aVar);
                    this.f46308a.h(campaignEx.getCMPTEntryUrl());
                    this.f46308a.f(campaignEx.getMof_tplid());
                    long candidateCacheTime = campaignEx.getCandidateCacheTime();
                    if (candidateCacheTime > 0) {
                        this.f46308a.b((candidateCacheTime * 1000) + System.currentTimeMillis());
                    }
                    this.f46308a.h(campaignEx.getVcn());
                    this.f46308a.i(campaignEx.getTokenRule());
                    CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                    if (rewardTemplateMode != null) {
                        this.f46308a.g(rewardTemplateMode.b());
                    }
                }
                this.f46308a.b(ads);
                this.f46308a.a(arrayList);
                com.mbridge.msdk.newreward.function.d.a.b bVar = this.f46308a;
                if (bVar != null && (cVar = this.f46315h) != null) {
                    try {
                        cVar.a(bVar, this);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.a("BaseCampaignRequest", "handlerOnSuccessEvent Exception: ", e11);
                        }
                    }
                }
            } else {
                a(this, this.f46308a, new b(7, ConstantsKt.ERROR_1000_MESSAGE));
            }
        } else {
            b bVar2 = new b(9);
            bVar2.a(jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
            bVar2.a(iOptInt);
            bVar2.c(jSONObject2.toString());
            a(this, this.f46308a, bVar2);
        }
        this.f46318k = SystemClock.elapsedRealtime();
    }

    public final void a(String str) {
        this.f46320m = str;
    }

    public final void a(String str, String str2) {
        if (this.f46314g == null) {
            this.f46314g = new HashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map = this.f46314g;
        if (str2 == null) {
            str2 = "";
        }
        map.put(str, str2);
    }

    public final void a(Map<String, String> map) {
        if (this.f46314g == null) {
            this.f46314g = new HashMap();
        }
        if (map == null || map.size() == 0) {
            return;
        }
        this.f46314g.putAll(map);
    }

    @Override // com.mbridge.msdk.e.a.p
    public final v b() {
        if (this.f46316i == null) {
            this.f46316i = new com.mbridge.msdk.e.a.f(ComConstants.AD_TIMEOUT_MILLIS, 5, 1.0f);
        }
        return this.f46316i;
    }

    public final void b(String str) {
        this.f46321n = str;
    }

    public final void b(String str, String str2) {
        if (this.f46323p == null) {
            this.f46323p = new HashMap();
        }
        this.f46323p.put(str, str2);
    }

    @Override // com.mbridge.msdk.e.a.p
    public final void c() {
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46319l);
        super.c();
    }

    @Override // com.mbridge.msdk.e.a.p
    public final Map<String, String> d() {
        if (this.f46323p == null) {
            this.f46323p = new HashMap();
        }
        return this.f46323p;
    }
}
