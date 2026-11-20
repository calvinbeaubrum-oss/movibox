package com.mbridge.msdk.mbbanner.common.communication;

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
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BannerExpandDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f45363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f45366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindVaneWebView f45367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f45368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f45369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<CampaignEx> f45370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.a f45371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f45372j;

    public BannerExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.mbbanner.common.b.a aVar) {
        super(context);
        this.f45363a = "BannerExpandDialog";
        this.f45372j = new b() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.5
            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void close() {
                BannerExpandDialog.this.dismiss();
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
                    if (BannerExpandDialog.this.f45367e == null || System.currentTimeMillis() - BannerExpandDialog.this.f45367e.lastTouchTime <= com.mbridge.msdk.click.b.a.f43105c || !com.mbridge.msdk.click.b.a.a((CampaignEx) BannerExpandDialog.this.f45370h.get(0), BannerExpandDialog.this.f45367e.getUrl(), com.mbridge.msdk.click.b.a.f43103a)) {
                        ad.b("BannerExpandDialog", str);
                        if (BannerExpandDialog.this.f45370h.size() > 1) {
                            c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            str = null;
                        }
                        if (BannerExpandDialog.this.f45371i != null) {
                            BannerExpandDialog.this.f45371i.a(true, str);
                        }
                    }
                } catch (Throwable th2) {
                    ad.a("BannerExpandDialog", "open", th2);
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void unload() {
                close();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void useCustomClose(boolean z11) {
                try {
                    BannerExpandDialog.this.f45368f.setVisibility(z11 ? 4 : 0);
                } catch (Throwable th2) {
                    ad.a("BannerExpandDialog", "useCustomClose", th2);
                }
            }
        };
        if (bundle != null) {
            this.f45364b = bundle.getString("url");
            this.f45365c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f45371i = aVar;
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

    public static /* synthetic */ void a(BannerExpandDialog bannerExpandDialog) {
        String str;
        try {
            int i11 = c.m().c().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i11 == 2) {
                str = "landscape";
            } else {
                str = i11 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN;
            }
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            float fI = z.i(c.m().c());
            float fG = z.g(c.m().c());
            HashMap mapH = z.h(c.m().c());
            int iIntValue = ((Integer) mapH.get("width")).intValue();
            int iIntValue2 = ((Integer) mapH.get("height")).intValue();
            HashMap map = new HashMap();
            map.put("placementType", "Interstitial");
            map.put("state", "expanded");
            map.put("viewable", "true");
            map.put("currentAppOrientation", jSONObject);
            int[] iArr = new int[2];
            bannerExpandDialog.f45367e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = bannerExpandDialog.f45367e;
            aVarA.a(windVaneWebView, iArr[0], iArr[1], windVaneWebView.getWidth(), bannerExpandDialog.f45367e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = bannerExpandDialog.f45367e;
            aVarA2.b(windVaneWebView2, iArr[0], iArr[1], windVaneWebView2.getWidth(), bannerExpandDialog.f45367e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog.f45367e, fI, fG);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(bannerExpandDialog.f45367e, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog.f45367e, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog.f45367e);
        } catch (Throwable th2) {
            ad.a("BannerExpandDialog", "notifyMraid", th2);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        CampaignEx campaignEx;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f45366d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.f45367e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f45366d.addView(this.f45367e);
        TextView textView = new TextView(getContext());
        this.f45368f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f45368f.setLayoutParams(layoutParams);
        this.f45368f.setVisibility(this.f45365c ? 4 : 0);
        this.f45368f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerExpandDialog.this.dismiss();
            }
        });
        BitmapDrawable bitmapDrawableA = c.m().a(this.f45369g, 296);
        if (bitmapDrawableA != null) {
            ImageView imageView = new ImageView(c.m().c());
            ai.a(imageView, bitmapDrawableA, this.f45366d.getResources().getDisplayMetrics());
            this.f45366d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.f45366d.addView(this.f45368f);
        setContentView(this.f45366d);
        a();
        this.f45367e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.2
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                webView.evaluateJavascript("javascript:" + com.mbridge.msdk.c.b.a.a().b(), new ValueCallback<String>() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.2.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
                BannerExpandDialog.a(BannerExpandDialog.this);
            }
        });
        this.f45367e.setObject(this.f45372j);
        this.f45367e.loadUrl(this.f45364b);
        List<CampaignEx> list = this.f45370h;
        if (list != null && list.size() > 0 && (campaignEx = this.f45370h.get(0)) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
            MBAdChoice mBAdChoice = new MBAdChoice(c.m().c());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ai.a(c.m().c(), 12.0f), ai.a(c.m().c(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.3
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    BannerExpandDialog.this.a();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    BannerExpandDialog.this.a();
                }
            });
            this.f45366d.addView(mBAdChoice, layoutParams2);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (BannerExpandDialog.this.f45371i != null) {
                    BannerExpandDialog.this.f45371i.a(false);
                }
                BannerExpandDialog.this.f45367e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                BannerExpandDialog.this.f45366d.removeView(BannerExpandDialog.this.f45367e);
                BannerExpandDialog.this.f45367e.release();
                BannerExpandDialog.this.f45367e = null;
                BannerExpandDialog.this.f45371i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f45369g = str;
        this.f45370h = list;
    }
}
