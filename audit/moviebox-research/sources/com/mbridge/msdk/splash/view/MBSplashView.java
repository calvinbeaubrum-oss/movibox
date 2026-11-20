package com.mbridge.msdk.splash.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ar;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.splash.signal.c;
import com.mbridge.msdk.splash.signal.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBSplashView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f47274a = "MBSplashView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f47275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MBSplashWebview f47276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f47277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ViewGroup f47278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f47279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f47280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f47282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47284k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ViewGroup f47285l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f47286m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f47287n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f47288o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RelativeLayout.LayoutParams f47289p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c f47290q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DyCountDownListener f47291r;

    public MBSplashView(Context context) {
        this(context, null);
    }

    public MBSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    private void b() {
        setBackgroundColor(0);
        this.f47275b = getResources().getConfiguration().orientation;
    }

    private void c() {
        MBSplashWebview mBSplashWebview = this.f47276c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(this.f47290q);
            this.f47276c.post(new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ad.a(MBSplashView.f47274a, "webviewshow");
                        String string = "";
                        try {
                            int[] iArr = new int[2];
                            MBSplashView.this.f47276c.getLocationOnScreen(iArr);
                            ad.b(MBSplashView.f47274a, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", ai.b(com.mbridge.msdk.foundation.controller.c.m().c(), (float) iArr[0]));
                            jSONObject.put("startY", ai.b(com.mbridge.msdk.foundation.controller.c.m().c(), (float) iArr[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th2) {
                            ad.a(MBSplashView.f47274a, th2.getMessage(), th2);
                        }
                        int[] iArr2 = new int[2];
                        MBSplashView.this.f47276c.getLocationInWindow(iArr2);
                        MBSplashView.transInfoForMraid(MBSplashView.this.f47276c, iArr2[0], iArr2[1], MBSplashView.this.f47276c.getWidth(), MBSplashView.this.f47276c.getHeight());
                        g.a().a((WebView) MBSplashView.this.f47276c, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            });
        }
    }

    public static void transInfoForMraid(WebView webView, int i11, int i12, int i13, int i14) {
        String str;
        ad.b(f47274a, "transInfoForMraid");
        try {
            int i15 = com.mbridge.msdk.foundation.controller.c.m().c().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i15 == 2) {
                str = "landscape";
            } else {
                str = i15 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN;
            }
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            float fI = z.i(com.mbridge.msdk.foundation.controller.c.m().c());
            float fG = z.g(com.mbridge.msdk.foundation.controller.c.m().c());
            HashMap mapH = z.h(com.mbridge.msdk.foundation.controller.c.m().c());
            int iIntValue = ((Integer) mapH.get("width")).intValue();
            int iIntValue2 = ((Integer) mapH.get("height")).intValue();
            HashMap map = new HashMap();
            map.put("placementType", "Interstitial");
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
            ad.a(f47274a, "transInfoForMraid", th2);
        }
    }

    public void changeCloseBtnState(int i11) {
        View view = this.f47279f;
        if (view != null) {
            if (i11 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f47284k = false;
        this.f47283j = false;
        this.f47282i = false;
    }

    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = this.f47285l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        MBSplashWebview mBSplashWebview = this.f47276c;
        if (mBSplashWebview == null || mBSplashWebview.isDestoryed()) {
            return;
        }
        d.a(this.f47276c, "onSystemDestory", "");
        this.f47276c.release();
        this.f47276c = null;
    }

    public View getCloseView() {
        return this.f47279f;
    }

    public ViewGroup getDevContainer() {
        return this.f47285l;
    }

    public View getIconVg() {
        return this.f47280g;
    }

    public c getSplashSignalCommunicationImpl() {
        return this.f47290q;
    }

    public MBSplashWebview getSplashWebview() {
        return this.f47276c;
    }

    public boolean isAttach() {
        return this.f47288o;
    }

    public boolean isDynamicView() {
        return this.f47287n;
    }

    public boolean isH5Ready() {
        return this.f47282i;
    }

    public boolean isImageReady() {
        return this.f47284k;
    }

    public boolean isVideoReady() {
        return this.f47283j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f47288o = true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void onPause() {
        View view = this.f47286m;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.f47286m;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.f47283j = false;
        this.f47282i = false;
    }

    public void setAllowClickSplash(final boolean z11) {
        MBSplashWebview mBSplashWebview = this.f47276c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.view.MBSplashView.2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z11;
                }
            });
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.view.MBSplashView.3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return !z11;
            }
        });
    }

    public void setCloseView(View view) {
        this.f47279f = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.f47285l = viewGroup;
    }

    public void setDyCountDownListener(DyCountDownListener dyCountDownListener) {
        this.f47291r = dyCountDownListener;
    }

    public void setDynamicView(boolean z11) {
        this.f47287n = z11;
    }

    public void setH5Ready(boolean z11) {
        this.f47282i = z11;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f47280g = view;
        this.f47289p = layoutParams;
    }

    public void setImageReady(boolean z11) {
        this.f47284k = z11;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        View view = this.f47286m;
        if (view != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).setNotchPadding(i11, i12, i13, i14);
        }
        if (this.f47276c != null) {
            g.a().a((WebView) this.f47276c, "oncutoutfetched", Base64.encodeToString(r.a(-999, i11, i12, i13, i14).getBytes(), 0));
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.f47286m = view;
        }
    }

    public void setSplashSignalCommunicationImpl(c cVar) {
        this.f47290q = cVar;
        MBSplashWebview mBSplashWebview = this.f47276c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(cVar);
        }
    }

    public void setSplashWebView() {
        if (this.f47276c == null) {
            try {
                MBSplashWebview mBSplashWebview = new MBSplashWebview(getContext());
                this.f47276c = mBSplashWebview;
                c cVar = this.f47290q;
                if (cVar != null) {
                    mBSplashWebview.setObject(cVar);
                }
                a aVar = this.f47277d;
                if (aVar != null) {
                    this.f47276c.setWebViewClient(aVar);
                    return;
                }
                a aVar2 = new a();
                this.f47277d = aVar2;
                this.f47276c.setWebViewClient(aVar2);
            } catch (Throwable th2) {
                ad.b(f47274a, th2.getMessage());
            }
        }
    }

    public void setVideoReady(boolean z11) {
        this.f47283j = z11;
    }

    public void show() {
        View view;
        View view2;
        View view3;
        ViewGroup viewGroup;
        com.mbridge.msdk.splash.d.a aVarA;
        if (this.f47290q != null && (viewGroup = this.f47285l) != null && (viewGroup.getContext() instanceof Activity)) {
            this.f47290q.a(this.f47285l.getContext());
            a aVar = this.f47277d;
            if (aVar != null && (aVarA = this.f47290q.a()) != null) {
                aVar.f47300a = aVarA;
            }
        }
        if (this.f47280g != null) {
            if (this.f47278e == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.f47278e = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.f47275b == 2) {
                this.f47281h = ai.f(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f47278e.getId());
                if (!this.f47287n || (view2 = this.f47286m) == null) {
                    MBSplashWebview mBSplashWebview = this.f47276c;
                    if (mBSplashWebview != null && mBSplashWebview.getParent() == null) {
                        addView(this.f47276c, layoutParams);
                    }
                    c();
                } else {
                    if (view2.getParent() != null) {
                        ar.a(this.f47286m);
                    }
                    addView(this.f47286m, layoutParams);
                }
                ViewGroup viewGroup2 = this.f47278e;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i11 = this.f47289p.width;
                    ar.a(this.f47280g);
                    int i12 = this.f47281h;
                    if (i11 > i12 / 4) {
                        i11 = i12 / 4;
                    }
                    this.f47278e.addView(this.f47280g, i11, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i11, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f47278e, layoutParams2);
                }
            } else {
                this.f47281h = ai.e(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f47278e.getId());
                if (!this.f47287n || (view = this.f47286m) == null) {
                    MBSplashWebview mBSplashWebview2 = this.f47276c;
                    if (mBSplashWebview2 != null && mBSplashWebview2.getParent() == null) {
                        addView(this.f47276c, layoutParams3);
                    }
                    c();
                } else {
                    if (view.getParent() != null) {
                        ar.a(this.f47286m);
                    }
                    addView(this.f47286m, layoutParams3);
                }
                ViewGroup viewGroup3 = this.f47278e;
                if (viewGroup3 != null && viewGroup3.getParent() == null) {
                    int i13 = this.f47289p.height;
                    int i14 = this.f47281h;
                    if (i13 > i14 / 4) {
                        i13 = i14 / 4;
                    }
                    ar.a(this.f47280g);
                    this.f47278e.addView(this.f47280g, -1, i13);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i13);
                    layoutParams4.addRule(12);
                    addView(this.f47278e, layoutParams4);
                }
            }
        } else if (!this.f47287n || (view3 = this.f47286m) == null) {
            MBSplashWebview mBSplashWebview3 = this.f47276c;
            if (mBSplashWebview3 != null && mBSplashWebview3.getParent() == null) {
                addView(this.f47276c, new ViewGroup.LayoutParams(-1, -1));
            }
            c();
        } else {
            if (view3.getParent() != null) {
                ar.a(this.f47286m);
            }
            addView(this.f47286m, new ViewGroup.LayoutParams(-1, -1));
        }
        View view4 = this.f47279f;
        if (view4 != null) {
            if (view4.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ai.a(getContext(), 100.0f), ai.a(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = ai.a(getContext(), 10.0f);
                layoutParams5.topMargin = ai.a(getContext(), 10.0f);
                addView(this.f47279f, layoutParams5);
            } else {
                bringChildToFront(this.f47279f);
            }
        }
        clearResState();
    }

    public void updateCountdown(int i11) {
        DyCountDownListener dyCountDownListener;
        View view;
        if (this.f47276c != null && !this.f47287n) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("countdown", i11);
                g.a().a((WebView) this.f47276c, "updateCountdown", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        if (this.f47287n && (view = this.f47286m) != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).updateCountDown(i11);
        }
        if (!this.f47287n || (dyCountDownListener = this.f47291r) == null) {
            return;
        }
        dyCountDownListener.getCountDownValue(i11);
    }
}
