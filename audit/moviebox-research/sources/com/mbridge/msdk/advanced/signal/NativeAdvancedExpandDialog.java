package com.mbridge.msdk.advanced.signal;

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
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NativeAdvancedExpandDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f42832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f42833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f42834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f42835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindVaneWebView f42836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f42837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f42838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<CampaignEx> f42839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.advanced.b.a f42840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.mraid.b f42841j;

    public NativeAdvancedExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.advanced.b.a aVar) {
        super(context);
        this.f42832a = "NativeAdvancedExpandDialog";
        this.f42841j = new com.mbridge.msdk.mbsignalcommon.mraid.b() { // from class: com.mbridge.msdk.advanced.signal.NativeAdvancedExpandDialog.5
            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void close() {
                NativeAdvancedExpandDialog.this.dismiss();
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
                    if (NativeAdvancedExpandDialog.this.f42836e == null || System.currentTimeMillis() - NativeAdvancedExpandDialog.this.f42836e.lastTouchTime <= com.mbridge.msdk.click.b.a.f43105c || !com.mbridge.msdk.click.b.a.a((CampaignEx) NativeAdvancedExpandDialog.this.f42839h.get(0), NativeAdvancedExpandDialog.this.f42836e.getUrl(), com.mbridge.msdk.click.b.a.f43103a)) {
                        ad.b("NativeAdvancedExpandDialog", str);
                        if (NativeAdvancedExpandDialog.this.f42839h.size() > 1) {
                            c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            str = null;
                        }
                        if (NativeAdvancedExpandDialog.this.f42840i != null) {
                            NativeAdvancedExpandDialog.this.f42840i.a(true, str);
                        }
                    }
                } catch (Throwable th2) {
                    ad.a("NativeAdvancedExpandDialog", "open", th2);
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void unload() {
                close();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void useCustomClose(boolean z11) {
                try {
                    NativeAdvancedExpandDialog.this.f42837f.setVisibility(z11 ? 4 : 0);
                } catch (Throwable th2) {
                    ad.a("NativeAdvancedExpandDialog", "useCustomClose", th2);
                }
            }
        };
        if (bundle != null) {
            this.f42833b = bundle.getString("url");
            this.f42834c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f42840i = aVar;
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

    public static /* synthetic */ void a(NativeAdvancedExpandDialog nativeAdvancedExpandDialog) {
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
            map.put("placementType", "inline");
            map.put("state", "expanded");
            map.put("viewable", "true");
            map.put("currentAppOrientation", jSONObject);
            int[] iArr = new int[2];
            nativeAdvancedExpandDialog.f42836e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = nativeAdvancedExpandDialog.f42836e;
            aVarA.a(windVaneWebView, iArr[0], iArr[1], windVaneWebView.getWidth(), nativeAdvancedExpandDialog.f42836e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = nativeAdvancedExpandDialog.f42836e;
            aVarA2.b(windVaneWebView2, iArr[0], iArr[1], windVaneWebView2.getWidth(), nativeAdvancedExpandDialog.f42836e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(nativeAdvancedExpandDialog.f42836e, fI, fG);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(nativeAdvancedExpandDialog.f42836e, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(nativeAdvancedExpandDialog.f42836e, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(nativeAdvancedExpandDialog.f42836e);
        } catch (Throwable th2) {
            ad.a("NativeAdvancedExpandDialog", "notifyMraid", th2);
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
        this.f42835d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.f42836e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f42835d.addView(this.f42836e);
        TextView textView = new TextView(getContext());
        this.f42837f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f42837f.setLayoutParams(layoutParams);
        this.f42837f.setVisibility(this.f42834c ? 4 : 0);
        this.f42837f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.advanced.signal.NativeAdvancedExpandDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NativeAdvancedExpandDialog.this.dismiss();
            }
        });
        this.f42835d.addView(this.f42837f);
        setContentView(this.f42835d);
        a();
        this.f42836e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.advanced.signal.NativeAdvancedExpandDialog.2
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                webView.evaluateJavascript("javascript:" + com.mbridge.msdk.c.b.a.a().b(), new ValueCallback<String>() { // from class: com.mbridge.msdk.advanced.signal.NativeAdvancedExpandDialog.2.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
                NativeAdvancedExpandDialog.a(NativeAdvancedExpandDialog.this);
            }
        });
        this.f42836e.setObject(this.f42841j);
        this.f42836e.loadUrl(this.f42833b);
        List<CampaignEx> list = this.f42839h;
        if (list != null && list.size() > 0 && (campaignEx = this.f42839h.get(0)) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
            MBAdChoice mBAdChoice = new MBAdChoice(c.m().c());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ai.a(c.m().c(), 12.0f), ai.a(c.m().c(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.advanced.signal.NativeAdvancedExpandDialog.3
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    NativeAdvancedExpandDialog.this.a();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    NativeAdvancedExpandDialog.this.a();
                }
            });
            this.f42835d.addView(mBAdChoice, layoutParams2);
        }
        BitmapDrawable bitmapDrawableA = c.m().a(this.f42838g, 296);
        if (bitmapDrawableA != null) {
            ImageView imageView = new ImageView(c.m().c());
            ai.a(imageView, bitmapDrawableA, this.f42835d.getResources().getDisplayMetrics());
            this.f42835d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mbridge.msdk.advanced.signal.NativeAdvancedExpandDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (NativeAdvancedExpandDialog.this.f42840i != null) {
                    NativeAdvancedExpandDialog.this.f42840i.a(false);
                }
                NativeAdvancedExpandDialog.this.f42836e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                NativeAdvancedExpandDialog.this.f42835d.removeView(NativeAdvancedExpandDialog.this.f42836e);
                NativeAdvancedExpandDialog.this.f42836e.release();
                NativeAdvancedExpandDialog.this.f42836e = null;
                NativeAdvancedExpandDialog.this.f42840i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f42838g = str;
        this.f42839h = list;
    }
}
