package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.nativex.listener.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WindVaneWebViewForNV extends WindVaneWebView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f45929e = "WindVaneWebViewForNV";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f45930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f45931g;

    public WindVaneWebViewForNV(Context context) {
        super(context);
        this.f45931g = false;
    }

    public WindVaneWebViewForNV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45931g = false;
    }

    public WindVaneWebViewForNV(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f45931g = false;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        b bVar;
        if (i11 != 4 || (bVar = this.f45930f) == null) {
            return super.onKeyDown(i11, keyEvent);
        }
        bVar.a();
        return true;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f45931g) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void orientation(boolean z11) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z11) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            g.a().a((WebView) this, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void setBackListener(b bVar) {
        this.f45930f = bVar;
    }

    public void setInterceptTouch(boolean z11) {
        this.f45931g = z11;
    }

    public void webViewShow(CampaignEx campaignEx, String str) {
        try {
            g.a().a((WebView) this, "webviewshow", "");
            n nVar = new n();
            nVar.f(campaignEx.getRequestId());
            nVar.g(campaignEx.getRequestIdNotice());
            if (getContext() != null && getContext().getApplicationContext() != null) {
                nVar.e(campaignEx.getId());
                nVar.d(campaignEx.isMraid() ? n.f44338a : n.f44339b);
                m.d(nVar, getContext().getApplicationContext(), str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
