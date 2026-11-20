package com.mbridge.msdk.video.signal.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.FrameLayout;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f48398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f48399b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Activity f48400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f48401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f48402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected c f48403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected String f48404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.b.c f48405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f48406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f48407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f48408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f48409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f48410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f48411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f48412u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f48413v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected IJSFactory f48414w;

    public AbstractJSContainer(Context context) {
        super(context);
        this.f48398a = 0;
        this.f48399b = 1;
        this.f48407p = 2;
        this.f48408q = false;
        this.f48409r = false;
        this.f48413v = false;
        this.f48414w = new a();
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48398a = 0;
        this.f48399b = 1;
        this.f48407p = 2;
        this.f48408q = false;
        this.f48409r = false;
        this.f48413v = false;
        this.f48414w = new a();
    }

    private String a(int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            ad.b("AbstractJSContainer", "code to string is error");
            return "";
        }
    }

    private boolean b(int i11) {
        boolean z11 = true;
        try {
            if (i11 != 1) {
                if (i11 != 2) {
                    z11 = false;
                } else {
                    this.f48400i.setRequestedOrientation(11);
                }
                return z11;
            }
            this.f48400i.setRequestedOrientation(12);
            return z11;
        } catch (Throwable th2) {
            ad.a("AbstractJSContainer", th2.getMessage(), th2);
            return false;
        }
    }

    public final void a(c cVar, CampaignEx campaignEx) {
        CampaignEx.c rewardTemplateMode;
        if (c(campaignEx) == 1) {
            return;
        }
        if ((campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null || !b(rewardTemplateMode.b())) && cVar != null) {
            b(this.f48403l.c());
        }
    }

    public final void a(Object obj) {
        g.a().a(obj, a(this.f48398a));
    }

    public final void a(Object obj, String str) {
        g.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    public void a(String str) {
        ad.b("AbstractJSContainer", str);
        Activity activity = this.f48400i;
        if (activity != null) {
            activity.finish();
        }
    }

    public final k b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        com.mbridge.msdk.videocommon.a.C0532a c0532aA = com.mbridge.msdk.videocommon.a.a(this.f48408q ? 287 : 94, campaignEx);
        if (c0532aA != null && c0532aA.c()) {
            WindVaneWebView windVaneWebViewA = c0532aA.a();
            if (windVaneWebViewA.getObject() instanceof k) {
                return (k) windVaneWebViewA.getObject();
            }
        }
        return null;
    }

    public final String b() {
        c cVar;
        return (!TextUtils.isEmpty(this.f48402k) || (cVar = this.f48403l) == null || TextUtils.isEmpty(cVar.z())) ? this.f48402k : this.f48403l.z();
    }

    public final int c(CampaignEx campaignEx) {
        k kVarB = b(campaignEx);
        if (kVarB != null) {
            return kVarB.l();
        }
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public b getActivityProxy() {
        return this.f48414w.getActivityProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.f48414w.getIJSRewardVideoV1();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.c getJSBTModule() {
        return this.f48414w.getJSBTModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        return this.f48414w.getJSCommon();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        return this.f48414w.getJSContainerModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.g getJSNotifyProxy() {
        return this.f48414w.getJSNotifyProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        return this.f48414w.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.f48402k;
    }

    public String getUnitId() {
        return this.f48401j;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().b()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().b()) {
            getActivityProxy().c();
        }
    }

    public void onPause() {
        if (getJSCommon().b()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().b()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.mbridge.msdk.foundation.d.b.f44150c) {
            return;
        }
        if (getJSCommon().b()) {
            getActivityProxy().b();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().b()) {
            getActivityProxy().e();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().b()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.f48414w = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.f48400i = activity;
    }

    public void setBidCampaign(boolean z11) {
        this.f48409r = z11;
    }

    public void setBigOffer(boolean z11) {
        this.f48413v = z11;
    }

    public void setIV(boolean z11) {
        this.f48408q = z11;
    }

    public void setIVRewardEnable(int i11, int i12, int i13) {
        this.f48410s = i11;
        this.f48411t = i12;
        this.f48412u = i13;
    }

    public void setMute(int i11) {
        this.f48407p = i11;
    }

    public void setPlacementId(String str) {
        this.f48402k = str;
    }

    public void setReward(com.mbridge.msdk.videocommon.b.c cVar) {
        this.f48405n = cVar;
    }

    public void setRewardId(String str) {
        this.f48406o = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f48403l = cVar;
    }

    public void setUnitId(String str) {
        this.f48401j = str;
    }

    public void setUserId(String str) {
        this.f48404m = str;
    }
}
