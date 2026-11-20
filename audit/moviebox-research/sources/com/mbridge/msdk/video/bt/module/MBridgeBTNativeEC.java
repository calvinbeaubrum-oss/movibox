package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.f.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeBTNativeEC extends MBridgeBTNativeECDiff {
    private TextView A;
    private StarLevelView B;
    private boolean C;
    private boolean D;
    private int E;
    private Runnable F;
    private boolean G;
    private View H;
    private String I;
    private k J;
    private WebView K;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ViewGroup f47449p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ViewGroup f47450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RelativeLayout f47451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f47452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RoundImageView f47453t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f47454u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f47455v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView f47456w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageView f47457x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f47458y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f47459z;

    public MBridgeBTNativeEC(Context context) {
        super(context);
        this.C = false;
        this.D = false;
        this.E = 0;
        this.G = false;
    }

    public MBridgeBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = false;
        this.D = false;
        this.E = 0;
        this.G = false;
    }

    private Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage());
            return null;
        }
    }

    private void a(View view) {
        if (view == null) {
            init(this.f47373a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    public static /* synthetic */ void a(MBridgeBTNativeEC mBridgeBTNativeEC, float f11, float f12) {
        if (mBridgeBTNativeEC.K != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                jSONObject.put("id", mBridgeBTNativeEC.f47376d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f11));
                jSONObject2.put("y", String.valueOf(f12));
                jSONObject.put("data", jSONObject2);
                g.a().a(mBridgeBTNativeEC.K, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a(mBridgeBTNativeEC.K, "onClicked", mBridgeBTNativeEC.f47376d);
            }
        }
    }

    public static /* synthetic */ void a(MBridgeBTNativeEC mBridgeBTNativeEC, int i11, Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(a.f44374j, mBridgeBTNativeEC.a(i11));
                } catch (JSONException e11) {
                    e = e11;
                    jSONObject2 = jSONObject;
                    e.printStackTrace();
                    jSONObject = jSONObject2;
                }
            } catch (Throwable th2) {
                ad.a(BTBaseView.TAG, th2.getMessage());
                return;
            }
        } catch (JSONException e12) {
            e = e12;
        }
        if (mBridgeBTNativeEC.J != null) {
            if (b.a()) {
                mBridgeBTNativeEC.doChinaJumpClick(context, mBridgeBTNativeEC.J);
            }
            mBridgeBTNativeEC.J.click(1, jSONObject != null ? jSONObject.toString() : "");
        }
    }

    private boolean b(View view) {
        try {
            this.f47451r = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_layout"));
            this.f47452s = (ImageView) view.findViewById(findID("mbridge_iv_adbanner_bg"));
            this.f47453t = (RoundImageView) view.findViewById(findID("mbridge_iv_adbanner"));
            this.f47454u = (ImageView) view.findViewById(findID("mbridge_iv_icon"));
            this.f47455v = (ImageView) view.findViewById(findID("mbridge_iv_flag"));
            this.f47456w = (ImageView) view.findViewById(findID("mbridge_iv_link"));
            this.f47458y = (TextView) view.findViewById(findID("mbridge_tv_apptitle"));
            this.f47459z = (TextView) view.findViewById(findID("mbridge_tv_appdesc"));
            this.A = (TextView) view.findViewById(findID("mbridge_tv_number"));
            this.B = (StarLevelView) view.findViewById(findID("mbridge_sv_starlevel"));
            this.H = view.findViewById(findID("mbridge_iv_close"));
            this.ctaView = view.findViewById(findID("mbridge_tv_cta"));
            this.f47457x = (ImageView) view.findViewById(findID("mbridge_iv_logo"));
            return isNotNULL(this.f47452s, this.f47453t, this.f47454u, this.f47458y, this.f47459z, this.A, this.B, this.H, this.ctaView);
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public final void a() {
        if (this.f47380h) {
            this.f47451r.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.C) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 1, view.getContext());
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                    }
                }
            });
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.K != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", MBridgeBTNativeEC.this.f47376d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTNativeEC.this.I);
                            jSONObject.put("data", jSONObject2);
                            ad.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                        } catch (JSONException e11) {
                            ad.a(BTBaseView.TAG, e11.getMessage());
                        }
                        g.a().a(MBridgeBTNativeEC.this.K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            });
            this.ctaView.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.4
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.f47454u.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.5
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    if (!b.a() || MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    }
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.f47453t.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.6
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    if (!b.a() || MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    }
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript renderScriptCreate = RenderScript.create(this.f47373a.getApplicationContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(10.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            bitmap.recycle();
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTNativeECDiff, com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
        boolean zB;
        int iFindLayout = findLayout(isLandscape() ? "mbridge_reward_endcard_native_land" : "mbridge_reward_endcard_native_hor");
        if (iFindLayout > 0) {
            if (isLandscape()) {
                ViewGroup viewGroup = (ViewGroup) this.f47378f.inflate(iFindLayout, (ViewGroup) null);
                this.f47450q = viewGroup;
                addView(viewGroup);
                zB = b(this.f47450q);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) this.f47378f.inflate(iFindLayout, (ViewGroup) null);
                this.f47449p = viewGroup2;
                addView(viewGroup2);
                zB = b(this.f47449p);
            }
            this.f47380h = zB;
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.F == null) {
            this.F = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.1
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeBTNativeEC.this.D = true;
                    if (MBridgeBTNativeEC.this.H != null) {
                        MBridgeBTNativeEC.this.H.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.F;
        if (runnable != null) {
            postDelayed(runnable, this.E * 1000);
        }
        if (!this.f47380h && this.K != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f47376d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.I);
                jSONObject.put("data", jSONObject2);
                ad.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e11) {
                ad.a(BTBaseView.TAG, e11.getMessage());
            }
            g.a().a(this.K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.K != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.f47376d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.I);
                jSONObject3.put("data", jSONObject4);
                ad.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e12) {
                ad.a(BTBaseView.TAG, e12.getMessage());
            }
            g.a().a(this.K, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTNativeECDiff, com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.F;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        int i11 = configuration.orientation;
        this.f47379g = i11;
        if (i11 == 2) {
            removeView(this.f47449p);
            a(this.f47450q);
        } else {
            removeView(this.f47450q);
            a(this.f47449p);
        }
    }

    public void preLoadData() {
        Bitmap bitmapBlurBitmap;
        try {
            CampaignEx campaignEx = this.f47374b;
            if (campaignEx == null || !this.f47380h) {
                return;
            }
            if (campaignEx.getCbd() > -2) {
                this.E = this.f47374b.getCbd();
            } else {
                c cVar = this.f47377e;
                if (cVar != null) {
                    this.E = cVar.p();
                }
            }
            com.mbridge.msdk.foundation.same.c.b.a(this.f47373a.getApplicationContext()).a(this.f47374b.getImageUrl(), new e(this.f47453t, this.f47374b, this.I));
            com.mbridge.msdk.foundation.same.c.b.a(this.f47373a.getApplicationContext()).a(this.f47374b.getIconUrl(), new j(this.f47454u, ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 8.0f)));
            this.f47458y.setText(this.f47374b.getAppName());
            this.f47459z.setText(this.f47374b.getAppDesc());
            this.A.setText(this.f47374b.getNumberRating() + ")");
            this.B.removeAllViews();
            if (b.a()) {
                setChinaCTAData(this.f47374b);
            }
            double rating = this.f47374b.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            this.B.initScore(rating);
            try {
                Bitmap bitmapA = a(this.f47453t.getDrawable());
                if (bitmapA != null && (bitmapBlurBitmap = blurBitmap(bitmapA)) != null) {
                    this.f47452s.setImageBitmap(bitmapBlurBitmap);
                }
            } catch (Throwable unused) {
                this.f47452s.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f47374b.getendcard_url()) && this.f47374b.getendcard_url().contains("alecfc=1")) {
                this.C = true;
            }
            if (!TextUtils.isEmpty(this.f47374b.getendcard_url()) && this.f47374b.getendcard_url().contains("wlgo=1")) {
                this.G = true;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.f47455v.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().g())));
            } else {
                this.f47455v.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().g())));
            }
            if (!this.G) {
                this.f47455v.setVisibility(4);
                this.f47457x.setVisibility(4);
            }
            ai.a(2, this.f47456w, this.f47374b, this.f47373a, true, null);
            if (this.D) {
                return;
            }
            this.H.setVisibility(8);
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void setCreateWebView(WebView webView) {
        this.K = webView;
    }

    public void setJSCommon(k kVar) {
        this.J = kVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void setUnitId(String str) {
        this.I = str;
    }
}
