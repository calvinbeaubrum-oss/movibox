package com.mbridge.msdk.splash.signal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdError;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class SplashExpandDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f47168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f47169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f47170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f47171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindVaneWebView f47172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f47173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f47174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<CampaignEx> f47175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.splash.d.a f47176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.mraid.b f47177j;

    public SplashExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.splash.d.a aVar) {
        super(context);
        this.f47168a = "SplashExpandDialog";
        this.f47177j = new com.mbridge.msdk.mbsignalcommon.mraid.b() { // from class: com.mbridge.msdk.splash.signal.SplashExpandDialog.5
            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void close() {
                SplashExpandDialog.this.dismiss();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void expand(String str, boolean z11) {
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final CampaignEx getMraidCampaign() {
                return null;
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void open(String str) {
                try {
                    if (SplashExpandDialog.this.f47172e == null || System.currentTimeMillis() - SplashExpandDialog.this.f47172e.lastTouchTime <= com.mbridge.msdk.click.b.a.f43105c || !com.mbridge.msdk.click.b.a.a((CampaignEx) SplashExpandDialog.this.f47175h.get(0), SplashExpandDialog.this.f47172e.getUrl(), com.mbridge.msdk.click.b.a.f43103a)) {
                        ad.b("SplashExpandDialog", str);
                        if (SplashExpandDialog.this.f47175h.size() > 1) {
                            com.mbridge.msdk.foundation.controller.c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            str = null;
                        }
                        if (SplashExpandDialog.this.f47176i != null) {
                            SplashExpandDialog.this.f47176i.a(true, str);
                        }
                    }
                } catch (Throwable th2) {
                    ad.a("SplashExpandDialog", "open", th2);
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void unload() {
                close();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void useCustomClose(boolean z11) {
                try {
                    SplashExpandDialog.this.f47173f.setVisibility(z11 ? 4 : 0);
                } catch (Throwable th2) {
                    ad.a("SplashExpandDialog", "useCustomClose", th2);
                }
            }
        };
        if (bundle != null) {
            this.f47169b = bundle.getString("url");
            this.f47170c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f47176i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
    }

    public static /* synthetic */ void a(SplashExpandDialog splashExpandDialog) {
        String str;
        try {
            int i11 = com.mbridge.msdk.foundation.controller.c.m().c().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i11 == 2) {
                str = "landscape";
            } else {
                str = i11 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN;
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
            map.put("state", "expanded");
            map.put("viewable", "true");
            map.put("currentAppOrientation", jSONObject);
            int[] iArr = new int[2];
            splashExpandDialog.f47172e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = splashExpandDialog.f47172e;
            aVarA.a(windVaneWebView, iArr[0], iArr[1], windVaneWebView.getWidth(), splashExpandDialog.f47172e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = splashExpandDialog.f47172e;
            aVarA2.b(windVaneWebView2, iArr[0], iArr[1], windVaneWebView2.getWidth(), splashExpandDialog.f47172e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(splashExpandDialog.f47172e, fI, fG);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(splashExpandDialog.f47172e, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(splashExpandDialog.f47172e, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(splashExpandDialog.f47172e);
        } catch (Throwable th2) {
            ad.a("SplashExpandDialog", "notifyMraid", th2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        CampaignEx campaignEx;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f47171d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.f47172e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f47171d.addView(this.f47172e);
        TextView textView = new TextView(getContext());
        this.f47173f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f47173f.setLayoutParams(layoutParams);
        this.f47173f.setVisibility(this.f47170c ? 4 : 0);
        this.f47173f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.splash.signal.SplashExpandDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashExpandDialog.this.dismiss();
            }
        });
        this.f47171d.addView(this.f47173f);
        setContentView(this.f47171d);
        a();
        this.f47172e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.splash.signal.SplashExpandDialog.2
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                webView.evaluateJavascript("javascript:" + com.mbridge.msdk.c.b.a.a().b(), new ValueCallback<String>() { // from class: com.mbridge.msdk.splash.signal.SplashExpandDialog.2.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
                SplashExpandDialog.a(SplashExpandDialog.this);
            }
        });
        this.f47172e.setObject(this.f47177j);
        this.f47172e.loadUrl(this.f47169b);
        List<CampaignEx> list = this.f47175h;
        if (list != null && !list.isEmpty() && (campaignEx = this.f47175h.get(0)) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().c());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f), ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.splash.signal.SplashExpandDialog.3
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    SplashExpandDialog.this.a();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    SplashExpandDialog.this.a();
                }
            });
            this.f47171d.addView(mBAdChoice, layoutParams2);
        }
        BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(this.f47174g, 297);
        if (bitmapDrawableA != null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            ai.a(imageView, bitmapDrawableA, this.f47171d.getResources().getDisplayMetrics());
            this.f47171d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mbridge.msdk.splash.signal.SplashExpandDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (SplashExpandDialog.this.f47176i != null) {
                    SplashExpandDialog.this.f47176i.a(false);
                    SplashExpandDialog.this.f47176i.a();
                }
                SplashExpandDialog.this.f47172e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                SplashExpandDialog.this.f47171d.removeView(SplashExpandDialog.this.f47172e);
                SplashExpandDialog.this.f47172e.release();
                SplashExpandDialog.this.f47172e = null;
                SplashExpandDialog.this.f47176i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f47174g = str;
        this.f47175h = list;
    }
}
