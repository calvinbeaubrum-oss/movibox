package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class WindVaneWebView extends BaseWebView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected k f45758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected c f45759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected f f45760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f45761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f45762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f45763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f45764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f45765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f45766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CampaignEx f45767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f45768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f45769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f45770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f45771o;

    public WindVaneWebView(Context context) {
        super(context);
        this.f45769m = false;
        this.f45770n = 0.0f;
        this.f45771o = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45769m = false;
        this.f45770n = 0.0f;
        this.f45771o = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f45769m = false;
        this.f45770n = 0.0f;
        this.f45771o = 0.0f;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.BaseWebView
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.f45758b == null) {
            this.f45758b = new k(this);
        }
        setWebViewChromeClient(this.f45758b);
        l lVar = new l();
        this.mWebViewClient = lVar;
        setWebViewClient(lVar);
        if (this.f45759c == null) {
            c iVar = new i(this.f45656a);
            this.f45759c = iVar;
            setSignalCommunication(iVar);
        }
        this.f45760d = new f(this.f45656a, this);
    }

    public void clearWebView() {
        if (this.f45769m) {
            return;
        }
        loadUrl("about:blank");
    }

    public CampaignEx getCampaignEx() {
        return this.f45767k;
    }

    public String getCampaignId() {
        return this.f45763g;
    }

    public Object getJsObject(String str) {
        f fVar = this.f45760d;
        if (fVar == null) {
            return null;
        }
        return fVar.a(str);
    }

    public String getLocalRequestId() {
        return this.f45766j;
    }

    public Object getMraidObject() {
        return this.f45762f;
    }

    public Object getObject() {
        return this.f45761e;
    }

    public String getRid() {
        return this.f45765i;
    }

    public c getSignalCommunication() {
        return this.f45759c;
    }

    public d getWebViewListener() {
        return this.f45764h;
    }

    public boolean isDestoryed() {
        return this.f45769m;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f45770n = motionEvent.getRawX();
                    this.f45771o = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.f45770n;
                    float y11 = motionEvent.getY() - this.f45771o;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= 48) && ((rawX <= 0.0f || rawX <= 48) && ((y11 >= 0.0f || (-1.0f) * y11 <= 48) && (y11 <= 0.0f || y11 <= 48)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        f fVar = this.f45760d;
        if (fVar == null) {
            return;
        }
        fVar.a(cls.getSimpleName(), cls);
    }

    public void release() {
        try {
            if (!this.f45769m) {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("type", Integer.valueOf(this.f45768l));
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000135", this.f45767k, dVar);
            }
        } catch (Exception unused) {
        }
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener(null);
            this.f45761e = null;
            int iB = ai.b(getContext());
            if (iB == 0) {
                this.f45769m = true;
                destroy();
            } else {
                new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindVaneWebView.this.f45769m = true;
                        WindVaneWebView.this.destroy();
                    }
                }, iB * 1000);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        f fVar = this.f45760d;
        if (fVar != null) {
            fVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        f fVar = this.f45760d;
        if (fVar != null) {
            fVar.a(obj);
        }
    }

    public void setCampaignEx(CampaignEx campaignEx) {
        this.f45767k = campaignEx;
    }

    public void setCampaignId(String str) {
        this.f45763g = str;
    }

    public void setLocalRequestId(String str) {
        this.f45766j = str;
    }

    public void setMraidObject(Object obj) {
        this.f45762f = obj;
    }

    public void setObject(Object obj) {
        this.f45761e = obj;
    }

    public void setRid(String str) {
        this.f45765i = str;
    }

    public void setSignalCommunication(c cVar) {
        this.f45759c = cVar;
        cVar.a(this);
    }

    public void setTempTypeForMetrics(int i11) {
        this.f45768l = i11;
    }

    public void setWebViewChromeClient(k kVar) {
        this.f45758b = kVar;
        setWebChromeClient(kVar);
    }

    public void setWebViewListener(d dVar) {
        this.f45764h = dVar;
        k kVar = this.f45758b;
        if (kVar != null) {
            kVar.a(dVar);
        }
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }
}
