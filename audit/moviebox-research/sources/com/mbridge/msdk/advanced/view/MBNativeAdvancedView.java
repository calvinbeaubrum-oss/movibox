package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.advanced.signal.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBNativeAdvancedView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f42861a = "MBAdvancedNativeView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MBNativeAdvancedWebview f42862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f42863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f42864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f42865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f42866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f42867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f42868h;

    public MBNativeAdvancedView(Context context) {
        this(context, null);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42868h = context;
    }

    public static void transInfoForMraid(WebView webView, int i11, int i12, int i13, int i14) {
        String str;
        ad.b(f42861a, "transInfoForMraid");
        try {
            int i15 = c.m().c().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i15 == 2) {
                str = "landscape";
            } else {
                str = i15 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN;
            }
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            float fI = z.i(c.m().c());
            float fG = z.g(c.m().c());
            HashMap mapH = z.h(c.m().c());
            int iIntValue = ((Integer) mapH.get("width")).intValue();
            int iIntValue2 = ((Integer) mapH.get("height")).intValue();
            HashMap map = new HashMap();
            map.put("placementType", "inline");
            map.put("state", TmcEngineFactory.ENGINE_TYPE_DEFAULT);
            map.put("viewable", "true");
            map.put("currentAppOrientation", jSONObject);
            float f11 = i11;
            float f12 = i12;
            float f13 = i13;
            float f14 = i14;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f11, f12, f13, f14);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f11, f12, f13, f14);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, fI, fG);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(webView, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView);
        } catch (Throwable th2) {
            ad.a(f42861a, "transInfoForMraid", th2);
        }
    }

    public void changeCloseBtnState(int i11) {
        View view = this.f42863c;
        if (view != null) {
            if (i11 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f42866f = false;
        this.f42865e = false;
        this.f42864d = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        View view = this.f42863c;
        if (view == null || view.getParent() == null) {
            return;
        }
        removeView(this.f42863c);
    }

    public void destroy() {
        removeAllViews();
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42862b;
        if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
            this.f42862b.release();
            com.mbridge.msdk.advanced.signal.a.a(this.f42862b, "onSystemDestory", "");
        }
        if (this.f42868h != null) {
            this.f42868h = null;
        }
    }

    public b getAdvancedNativeSignalCommunicationImpl() {
        return this.f42867g;
    }

    public MBNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.f42862b;
    }

    public View getCloseView() {
        return this.f42863c;
    }

    public boolean isEndCardReady() {
        return this.f42866f;
    }

    public boolean isH5Ready() {
        return this.f42864d;
    }

    public boolean isVideoReady() {
        return this.f42865e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void resetLoadState() {
        this.f42866f = false;
        this.f42865e = false;
        this.f42864d = false;
    }

    public void setAdvancedNativeSignalCommunicationImpl(b bVar) {
        this.f42867g = bVar;
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42862b;
        if (mBNativeAdvancedWebview != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void setAdvancedNativeWebview(MBNativeAdvancedWebview mBNativeAdvancedWebview) {
        this.f42862b = mBNativeAdvancedWebview;
        b bVar = this.f42867g;
        if (bVar != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void setCloseView(View view) {
        this.f42863c = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setEndCardReady(boolean z11) {
        this.f42866f = z11;
    }

    public void setH5Ready(boolean z11) {
        this.f42864d = z11;
    }

    public void setVideoReady(boolean z11) {
        this.f42865e = z11;
    }

    public void show() {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42862b;
        if (mBNativeAdvancedWebview != null && mBNativeAdvancedWebview.getParent() == null) {
            addView(this.f42862b, new ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.f42862b.getLocationInWindow(iArr);
        MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.f42862b;
        transInfoForMraid(mBNativeAdvancedWebview2, iArr[0], iArr[1], mBNativeAdvancedWebview2.getWidth(), this.f42862b.getHeight());
        MBNativeAdvancedWebview mBNativeAdvancedWebview3 = this.f42862b;
        if (mBNativeAdvancedWebview3 != null) {
            mBNativeAdvancedWebview3.setObject(this.f42867g);
            this.f42862b.post(new Runnable() { // from class: com.mbridge.msdk.advanced.view.MBNativeAdvancedView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ad.a(MBNativeAdvancedView.f42861a, "webviewshow");
                        String string = "";
                        try {
                            int[] iArr2 = new int[2];
                            MBNativeAdvancedView.this.f42862b.getLocationOnScreen(iArr2);
                            ad.b(MBNativeAdvancedView.f42861a, "coordinate:" + iArr2[0] + "--" + iArr2[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", ai.b(c.m().c(), (float) iArr2[0]));
                            jSONObject.put("startY", ai.b(c.m().c(), (float) iArr2[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th2) {
                            ad.a(MBNativeAdvancedView.f42861a, th2.getMessage(), th2);
                        }
                        g.a().a((WebView) MBNativeAdvancedView.this.f42862b, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            });
        }
        View view = this.f42863c;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 28.0f), ai.a(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = ai.a(getContext(), 2.0f);
                layoutParams.topMargin = ai.a(getContext(), 2.0f);
                addView(this.f42863c, layoutParams);
            } else {
                bringChildToFront(this.f42863c);
            }
        }
        clearResState();
    }
}
