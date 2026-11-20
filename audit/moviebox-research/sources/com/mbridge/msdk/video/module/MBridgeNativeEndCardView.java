package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.tn.lib.view.FlowLayout;
import com.transsion.gslb.Worker;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeNativeEndCardView extends MBridgeNativeEndCardViewDiff {
    private LinearLayout A;
    private LinearLayout B;
    private Runnable C;
    private Runnable D;
    private RelativeLayout E;
    private b F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private AlphaAnimation L;
    private int M;
    private int N;
    private int O;
    private int P;
    private Bitmap Q;
    private View R;
    private FeedBackButton S;
    private String T;
    private CampaignUnit U;
    private MBShakeView V;
    private com.mbridge.msdk.shake.b W;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private MBridgeBaitClickView f47870aa;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private boolean f47871ab;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private int f47872ac;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private String f47873ad;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ViewGroup f47874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ViewGroup f47875o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RelativeLayout f47876p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f47877q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImageView f47878r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f47879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f47880t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f47881u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f47882v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView f47883w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f47884x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f47885y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f47886z;

    public MBridgeNativeEndCardView(Context context) {
        super(context);
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.f47871ab = false;
        this.f47872ac = 1;
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.f47871ab = false;
        this.f47872ac = 1;
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet, boolean z11, int i11, boolean z12, int i12, int i13) {
        super(context, attributeSet, z11, i11, z12, i12, i13);
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.f47871ab = false;
        this.f47872ac = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iE = e();
        if (iE > 0) {
            this.f47795f = b(iE);
            b();
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null) {
                campaignEx.setECTemplateRenderSucc(false);
            }
        }
    }

    private void a(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.F);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        f();
    }

    public static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, int i11) {
        JSONObject jSONObject;
        CampaignEx campaignEx = mBridgeNativeEndCardView.f47791b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeNativeEndCardView.f47791b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + "";
                }
                q.a(c.m().c(), "end_card_click", mBridgeNativeEndCardView.f47791b.getCampaignUnitId(), mBridgeNativeEndCardView.f47791b.isBidCampaign(), mBridgeNativeEndCardView.f47791b.getRequestId(), mBridgeNativeEndCardView.f47791b.getRequestIdNotice(), mBridgeNativeEndCardView.f47791b.getId(), str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.f44374j, mBridgeNativeEndCardView.a(i11));
                if (mBridgeNativeEndCardView.f47791b.getDynamicTempCode() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e12) {
                e = e12;
                jSONObject2 = jSONObject;
                e.printStackTrace();
                jSONObject = jSONObject2;
            }
        } catch (JSONException e13) {
            e = e13;
        }
        mBridgeNativeEndCardView.f47791b.setClickTempSource(2);
        mBridgeNativeEndCardView.f47794e.a(105, jSONObject);
    }

    public static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, final Bitmap bitmap) {
        try {
            com.mbridge.msdk.foundation.same.f.b.f().execute(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.13
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeNativeEndCardView mBridgeNativeEndCardView2 = MBridgeNativeEndCardView.this;
                    mBridgeNativeEndCardView2.Q = mBridgeNativeEndCardView2.blurBitmap(bitmap);
                    if (MBridgeNativeEndCardView.this.Q == null || MBridgeNativeEndCardView.this.Q.isRecycled() || MBridgeNativeEndCardView.this.f47877q == null) {
                        return;
                    }
                    MBridgeNativeEndCardView.this.f47877q.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.13.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView3 = MBridgeNativeEndCardView.this;
                            if (mBridgeNativeEndCardView3.f47798i) {
                                mBridgeNativeEndCardView3.f47877q.setBackground(null);
                            }
                            ad.b("async", "执行异步加载图");
                            MBridgeNativeEndCardView.this.f47877q.setImageBitmap(MBridgeNativeEndCardView.this.Q);
                        }
                    });
                }
            });
        } catch (Exception e11) {
            ad.a(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        if (!this.f47795f) {
            this.f47794e.a(104, "");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.L = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    private boolean b(int i11) {
        if (isLandscape()) {
            ViewGroup viewGroup = (ViewGroup) this.f47792c.inflate(i11, (ViewGroup) null);
            this.f47875o = viewGroup;
            addView(viewGroup);
            return b(this.f47875o);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f47792c.inflate(i11, (ViewGroup) null);
        this.f47874n = viewGroup2;
        addView(viewGroup2);
        return b(this.f47874n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view) {
        try {
            this.f47876p = (RelativeLayout) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_native_ec_layout"));
            this.f47878r = (ImageView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_iv_adbanner"));
            this.f47879s = (ImageView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_iv_icon"));
            this.f47880t = (ImageView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_iv_flag"));
            this.f47881u = (TextView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_tv_flag"));
            this.f47882v = (ImageView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_iv_logo"));
            this.f47883w = (ImageView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_iv_link"));
            this.f47884x = (TextView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_tv_apptitle"));
            this.A = (LinearLayout) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_sv_starlevel"));
            this.B = (LinearLayout) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_sv_heat_count_level"));
            this.R = view.findViewById(filterFindViewId(this.f47871ab, "mbridge_iv_close"));
            this.ctaView = (TextView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_tv_cta"));
            this.S = (FeedBackButton) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_native_endcard_feed_btn"));
            this.E = (RelativeLayout) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_native_ec_controller"));
            this.f47877q = (ImageView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_iv_adbanner_bg"));
            this.f47870aa = (MBridgeBaitClickView) findViewById(filterFindViewId(this.f47871ab, "mbridge_animation_click_view"));
            this.f47885y = (TextView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_tv_appdesc"));
            if (!this.f47798i) {
                TextView textView = (TextView) view.findViewById(filterFindViewId(this.f47871ab, "mbridge_tv_number"));
                this.f47886z = textView;
                return isNotNULL(this.f47878r, this.f47879s, this.f47884x, this.f47885y, textView, this.A, this.R, this.ctaView);
            }
            ImageView imageView = this.f47878r;
            if (imageView != null && (imageView instanceof RoundImageView)) {
                ((RoundImageView) imageView).setBorderRadius(10);
            }
            ImageView imageView2 = this.f47879s;
            if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                ((RoundImageView) imageView2).setBorderRadius(10);
            }
            return isNotNULL(this.f47878r, this.f47879s, this.f47884x, this.A, this.R, this.ctaView);
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    private int e() {
        int i11 = this.f47801l;
        String str = "mbridge_reward_endcard_native_land";
        String str2 = "mbridge_reward_endcard_native_hor";
        if (i11 == 0) {
            str2 = this.f47800k ? "mbridge_reward_endcard_native_half_portrait" : "mbridge_reward_endcard_native_hor";
            if (isLandscape()) {
                if (this.f47800k) {
                    str = "mbridge_reward_endcard_native_half_landscape";
                }
                str2 = str;
            }
        } else {
            if (i11 != 1) {
                str2 = "";
            } else if (this.f47800k) {
                str2 = "mbridge_reward_endcard_native_half_portrait";
            }
            if (i11 == 2) {
                if (this.f47800k) {
                    str = "mbridge_reward_endcard_native_half_landscape";
                }
                str2 = str;
            }
        }
        return findLayout(str2);
    }

    private void f() {
        RelativeLayout relativeLayout;
        if (!this.f47795f || (relativeLayout = this.E) == null) {
            return;
        }
        relativeLayout.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeNativeEndCardView.this.E != null) {
                    CampaignEx campaignEx = MBridgeNativeEndCardView.this.f47791b;
                    if (campaignEx != null && !campaignEx.isDynamicView() && MBridgeNativeEndCardView.this.f47791b.getAdSpaceT() != 2) {
                        MBridgeNativeEndCardView.this.E.setPadding(MBridgeNativeEndCardView.this.M, MBridgeNativeEndCardView.this.O, MBridgeNativeEndCardView.this.N, MBridgeNativeEndCardView.this.P);
                        MBridgeNativeEndCardView.this.E.startAnimation(MBridgeNativeEndCardView.this.L);
                    }
                    MBridgeNativeEndCardView.this.E.setVisibility(0);
                }
                if (MBridgeNativeEndCardView.this.R != null && MBridgeNativeEndCardView.this.R.getVisibility() != 0 && MBridgeNativeEndCardView.this.H) {
                    MBridgeNativeEndCardView.this.R.setVisibility(0);
                }
                MBridgeNativeEndCardView.p(MBridgeNativeEndCardView.this);
            }
        }, 200L);
    }

    public static /* synthetic */ void p(MBridgeNativeEndCardView mBridgeNativeEndCardView) {
        CampaignEx campaignEx = mBridgeNativeEndCardView.f47791b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(mBridgeNativeEndCardView.T);
            com.mbridge.msdk.foundation.d.b.a().a(mBridgeNativeEndCardView.T + "_2", mBridgeNativeEndCardView.f47791b);
        }
        if (!com.mbridge.msdk.foundation.d.b.a().b()) {
            FeedBackButton feedBackButton = mBridgeNativeEndCardView.S;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.d.b.a().a(mBridgeNativeEndCardView.T + "_2", new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.4
            @Override // com.mbridge.msdk.foundation.d.a
            public final void a() {
                MBridgeNativeEndCardView.this.J = true;
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void a(String str) {
                MBridgeNativeEndCardView.this.J = false;
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void b() {
                MBridgeNativeEndCardView.this.J = false;
            }
        });
        com.mbridge.msdk.foundation.d.b.a().c(mBridgeNativeEndCardView.T + "_1");
        if (mBridgeNativeEndCardView.S != null) {
            com.mbridge.msdk.foundation.d.b.a().a(mBridgeNativeEndCardView.T + "_2", mBridgeNativeEndCardView.S);
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript renderScriptCreate = RenderScript.create(this.f47790a.getApplicationContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(25.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        if (this.f47795f) {
            this.f47876p.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.G) {
                        MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 1);
                    }
                }
            });
            this.R.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.f47798i) {
                        try {
                            com.mbridge.msdk.video.dynview.moffer.a.a().b();
                        } catch (Exception e11) {
                            ad.b(MBridgeBaseView.TAG, e11.getMessage());
                        }
                        try {
                            CampaignEx campaignEx = MBridgeNativeEndCardView.this.f47791b;
                            if (campaignEx != null) {
                                String strA = ao.a(campaignEx.getendcard_url(), "ecid");
                                String strA2 = ao.a(MBridgeNativeEndCardView.this.f47791b.getendcard_url(), "mof");
                                d dVar = new d();
                                dVar.a("type", "choseFromTwoClose");
                                dVar.a("endcard_id", strA);
                                dVar.a("mof", strA2);
                                com.mbridge.msdk.video.module.b.a.a("2000103", MBridgeNativeEndCardView.this.f47791b, dVar);
                            }
                        } catch (Exception e12) {
                            if (MBridgeConstans.DEBUG) {
                                e12.printStackTrace();
                            }
                        }
                    }
                    try {
                        d dVar2 = new d();
                        dVar2.a("type", 2);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", dVar2);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000134", MBridgeNativeEndCardView.this.f47791b);
                    } catch (Throwable th2) {
                        if (MBridgeConstans.DEBUG) {
                            th2.printStackTrace();
                        }
                    }
                    MBridgeNativeEndCardView.this.f47794e.a(104, "");
                }
            });
            TextView textView = this.ctaView;
            if (textView != null) {
                textView.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.16
                    @Override // com.mbridge.msdk.widget.a
                    public final void a(View view) {
                        MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(1);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                });
            }
            this.f47879s.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.17
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    if (MBridgeNativeEndCardView.this.ctaView != null) {
                        if (!com.mbridge.msdk.f.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                            MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                        }
                    }
                }
            });
            this.f47878r.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.2
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    if (MBridgeNativeEndCardView.this.ctaView != null) {
                        if (!com.mbridge.msdk.f.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                            MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                        }
                    }
                }
            });
        }
    }

    public boolean canBackPress() {
        View view = this.R;
        return view != null && view.getVisibility() == 0;
    }

    public void clearMoreOfferBitmap() {
        CampaignUnit campaignUnit;
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || !campaignEx.isDynamicView() || (campaignUnit = this.U) == null || campaignUnit.getAds() == null || this.U.getAds().size() <= 0) {
            return;
        }
        for (CampaignEx campaignEx2 : this.U.getAds()) {
            if (!TextUtils.isEmpty(campaignEx2.getIconUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(c.m().c()).a(campaignEx2.getIconUrl());
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    public boolean isDyXmlSuccess() {
        return this.f47871ab;
    }

    public void notifyShowListener() {
        this.f47794e.a(Worker.WHAT_QUIT, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i11;
        int i12;
        int i13;
        MBridgeBaitClickView mBridgeBaitClickView;
        super.onAttachedToWindow();
        if (this.C == null) {
            this.C = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeNativeEndCardView.this.H = true;
                    if (MBridgeNativeEndCardView.this.R != null) {
                        MBridgeNativeEndCardView.this.R.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.C;
        if (runnable != null) {
            postDelayed(runnable, this.K * 1000);
            if (!this.I) {
                this.I = true;
            }
            try {
                CampaignEx campaignEx = this.f47791b;
                if (campaignEx != null && campaignEx.isDynamicView()) {
                    String endScreenUrl = this.f47791b.getendcard_url();
                    if (TextUtils.isEmpty(endScreenUrl)) {
                        endScreenUrl = this.f47791b.getEndScreenUrl();
                    }
                    String strA = ao.a(endScreenUrl, "alac");
                    if (!TextUtils.isEmpty(strA) && strA.equals("1") && this.f47791b.getAutoShowStoreMiniCard() != 1) {
                        postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.8
                            @Override // java.lang.Runnable
                            public final void run() {
                                MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(2);
                                MBridgeNativeEndCardView.this.f47791b.setClickType(1);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                            }
                        }, 1000L);
                    }
                }
            } catch (Throwable th2) {
                ad.b(MBridgeBaseView.TAG, th2.getMessage());
            }
        }
        try {
            CampaignEx campaignEx2 = this.f47791b;
            if (campaignEx2 != null && campaignEx2.isDynamicView()) {
                String endScreenUrl2 = this.f47791b.getendcard_url();
                if (TextUtils.isEmpty(endScreenUrl2)) {
                    endScreenUrl2 = this.f47791b.getEndScreenUrl();
                }
                String strA2 = ao.a(endScreenUrl2, "bait_click");
                try {
                    i13 = Integer.parseInt(strA2);
                } catch (Throwable th3) {
                    ad.b(MBridgeBaseView.TAG, th3.getMessage());
                    i13 = 1;
                }
                if (!TextUtils.isEmpty(strA2) && i13 != 0 && (mBridgeBaitClickView = this.f47870aa) != null) {
                    mBridgeBaitClickView.setVisibility(0);
                    this.f47870aa.init(1342177280, i13);
                    if (this.f47791b.getEcTemplateId() == 1302) {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setShape(0);
                        gradientDrawable.setColor(1342177280);
                        gradientDrawable.setStroke(0, FlowLayout.SPACING_AUTO);
                        gradientDrawable.setCornerRadius(25.0f);
                        this.f47870aa.setBackground(gradientDrawable);
                    }
                    this.f47870aa.startAnimation();
                    this.f47870aa.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                        }
                    });
                }
            }
        } catch (Throwable th4) {
            ad.b(MBridgeBaseView.TAG, th4.getMessage());
        }
        try {
            CampaignEx campaignEx3 = this.f47791b;
            if (campaignEx3 != null && campaignEx3.isDynamicView()) {
                String endScreenUrl3 = this.f47791b.getendcard_url();
                if (TextUtils.isEmpty(endScreenUrl3)) {
                    endScreenUrl3 = this.f47791b.getEndScreenUrl();
                }
                String strA3 = ao.a(endScreenUrl3, "shake_show");
                String strA4 = ao.a(endScreenUrl3, "shake_strength");
                String strA5 = ao.a(endScreenUrl3, "shake_time");
                if (!TextUtils.isEmpty(strA3) && strA3.equals("1") && this.V == null) {
                    MBridgeBaitClickView mBridgeBaitClickView2 = this.f47870aa;
                    if (mBridgeBaitClickView2 != null) {
                        mBridgeBaitClickView2.setVisibility(8);
                    }
                    MBShakeView mBShakeView = new MBShakeView(getContext());
                    this.V = mBShakeView;
                    mBShakeView.initView(this.f47791b.getAdCall(), true);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    if (isLandscape()) {
                        layoutParams.addRule(13);
                    } else {
                        layoutParams.addRule(2, filterFindViewId(this.f47871ab, "mbridge_iv_logo"));
                        layoutParams.addRule(14);
                        this.V.setPadding(0, 0, 0, ai.a(getContext(), 20.0f));
                    }
                    this.V.setLayoutParams(layoutParams);
                    RelativeLayout relativeLayout = this.f47876p;
                    if (relativeLayout != null && relativeLayout.isShown()) {
                        this.f47876p.addView(this.V);
                        TextView textView = this.ctaView;
                        if (textView != null) {
                            textView.setVisibility(4);
                        }
                        this.ctaView.setVisibility(4);
                        this.V.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.5
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(5);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                            }
                        });
                        int i14 = 10;
                        if (!TextUtils.isEmpty(strA4) && (i12 = Integer.parseInt(strA4)) > 0) {
                            i14 = i12;
                        }
                        int i15 = 5000;
                        if (!TextUtils.isEmpty(strA5) && (i11 = Integer.parseInt(strA5)) > 0) {
                            i15 = i11 * 1000;
                        }
                        this.W = new com.mbridge.msdk.shake.b(i14, i15) { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.6
                            @Override // com.mbridge.msdk.shake.b
                            public final void a() {
                                if ((com.mbridge.msdk.f.b.a() && MBridgeNativeEndCardView.this.checkChinaShakeState()) || MBridgeNativeEndCardView.this.J || !MBridgeNativeEndCardView.this.I) {
                                    return;
                                }
                                MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                                mBridgeNativeEndCardView.f47796g = 0.0f;
                                mBridgeNativeEndCardView.f47797h = 0.0f;
                                mBridgeNativeEndCardView.f47791b.setTriggerClickSource(5);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 4);
                            }
                        };
                        com.mbridge.msdk.shake.a.a().a(this.W);
                    }
                }
            }
        } catch (Throwable th5) {
            ad.b(MBridgeBaseView.TAG, th5.getMessage());
        }
        try {
            CampaignEx campaignEx4 = this.f47791b;
            if (campaignEx4 != null && campaignEx4.getAutoShowStoreMiniCard() != 0 && !TextUtils.isEmpty(this.f47791b.getDeepLinkURL())) {
                long showStoreMiniCardDelayTime = this.f47791b.getShowStoreMiniCardDelayTime();
                if (showStoreMiniCardDelayTime == 0) {
                    showStoreMiniCardDelayTime = 1;
                }
                if (this.D == null) {
                    this.D = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.9
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBridgeNativeEndCardView.this.f47791b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.this.f47791b.setClickType(1);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                        }
                    };
                }
                postDelayed(this.D, showStoreMiniCardDelayTime * 1000);
            }
        } catch (Throwable th6) {
            ad.b(MBridgeBaseView.TAG, th6.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.C;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.D;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        if (this.W != null) {
            com.mbridge.msdk.shake.a.a().b(this.W);
            this.W = null;
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            RelativeLayout relativeLayout = this.E;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            int i11 = configuration.orientation;
            this.f47793d = i11;
            if (i11 == 2) {
                removeView(this.f47874n);
                a(this.f47875o);
            } else {
                removeView(this.f47875o);
                a(this.f47874n);
            }
        }
    }

    public void preLoadData(b bVar) {
        this.F = bVar;
        try {
            if (this.f47791b == null || !this.f47795f) {
                return;
            }
            com.mbridge.msdk.foundation.same.c.b.a(this.f47790a.getApplicationContext()).a(this.f47791b.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.11
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        if (MBridgeNativeEndCardView.this.f47878r != null) {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                            if (mBridgeNativeEndCardView.f47798i) {
                                mBridgeNativeEndCardView.f47878r.setBackground(null);
                            }
                            MBridgeNativeEndCardView.this.f47878r.setImageBitmap(bitmap);
                        }
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, bitmap);
                    } catch (Throwable unused) {
                        if (MBridgeNativeEndCardView.this.f47877q != null) {
                            MBridgeNativeEndCardView.this.f47877q.setVisibility(4);
                        }
                    }
                }
            });
            com.mbridge.msdk.foundation.same.c.b.a(this.f47790a.getApplicationContext()).a(this.f47791b.getIconUrl(), new j(this.f47879s, ai.a(c.m().c(), 8.0f)));
            this.f47884x.setText(this.f47791b.getAppName());
            TextView textView = this.ctaView;
            if (textView != null) {
                textView.setText(this.f47791b.getAdCall());
            }
            TextView textView2 = this.f47885y;
            if (textView2 != null) {
                textView2.setText(this.f47791b.getAppDesc());
            }
            TextView textView3 = this.f47886z;
            if (textView3 != null) {
                textView3.setText(this.f47791b.getNumberRating() + ")");
            }
            this.A.removeAllViews();
            double rating = this.f47791b.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            LinearLayout linearLayout = this.A;
            if (linearLayout instanceof StarLevelView) {
                ((StarLevelView) linearLayout).initScore(rating);
            }
            LinearLayout linearLayout2 = this.A;
            if (linearLayout2 instanceof MBridgeLevelLayoutView) {
                ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, this.f47791b.getNumberRating());
            }
            LinearLayout linearLayout3 = this.A;
            if (linearLayout3 instanceof MBStarLevelLayoutView) {
                ((MBStarLevelLayoutView) linearLayout3).setRating((int) rating);
            }
            LinearLayout linearLayout4 = this.B;
            if (linearLayout4 != null && (linearLayout4 instanceof MBHeatLevelLayoutView)) {
                ((MBHeatLevelLayoutView) linearLayout4).setHeatCount(this.f47791b.getNumberRating());
            }
            if (!TextUtils.isEmpty(this.f47791b.getendcard_url()) && this.f47791b.getendcard_url().contains("alecfc=1")) {
                this.G = true;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.f47880t.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_en", "drawable", c.m().g())));
                this.f47873ad = "AD";
            } else {
                this.f47880t.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", c.m().g())));
                this.f47873ad = "广告";
            }
            if (this.f47872ac == 0) {
                ImageView imageView = this.f47880t;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                ImageView imageView2 = this.f47882v;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
                TextView textView4 = this.f47881u;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.f47881u.setText(this.f47873ad);
                }
            }
            ai.a(2, this.f47883w, this.f47791b, this.f47790a, true, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.12
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                    MBridgeNativeEndCardView.this.J = true;
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    MBridgeNativeEndCardView.this.J = false;
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    MBridgeNativeEndCardView.this.J = false;
                }
            });
            if (this.H) {
                return;
            }
            this.R.setVisibility(8);
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void release() {
        try {
            removeAllViews();
            AlphaAnimation alphaAnimation = this.L;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.C = null;
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void setCloseBtnDelay(int i11) {
        this.K = i11;
    }

    public void setLayout() {
        if (!this.f47798i) {
            a();
            return;
        }
        com.mbridge.msdk.video.dynview.c cVarA = new com.mbridge.msdk.video.dynview.j.c().a(getContext(), this.f47791b, this.f47799j, com.mbridge.msdk.f.b.a() ? "cn_" : "en_");
        this.f47872ac = cVarA.n();
        com.mbridge.msdk.video.dynview.b.a().a(cVarA, new g() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.10
            @Override // com.mbridge.msdk.video.dynview.e.g
            public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                if (aVar != null) {
                    MBridgeNativeEndCardView.this.addView(aVar.a());
                    MBridgeNativeEndCardView.this.f47871ab = aVar.c();
                    if (MBridgeNativeEndCardView.this.ctaViewCanGet(aVar.a(), MBridgeNativeEndCardView.this.f47871ab)) {
                        MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                        mBridgeNativeEndCardView.f47795f = mBridgeNativeEndCardView.b(aVar.a());
                        MBridgeNativeEndCardView.this.b();
                    } else {
                        MBridgeNativeEndCardView.this.f47871ab = false;
                        MBridgeNativeEndCardView mBridgeNativeEndCardView2 = MBridgeNativeEndCardView.this;
                        mBridgeNativeEndCardView2.f47798i = false;
                        mBridgeNativeEndCardView2.a();
                    }
                    MBridgeNativeEndCardView mBridgeNativeEndCardView3 = MBridgeNativeEndCardView.this;
                    CampaignEx campaignEx = mBridgeNativeEndCardView3.f47791b;
                    if (campaignEx != null) {
                        campaignEx.setECTemplateRenderSucc(mBridgeNativeEndCardView3.f47871ab);
                    }
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.g
            public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                ad.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
            }
        });
    }

    public void setMoreOfferCampaignUnit(CampaignUnit campaignUnit) {
        MBShakeView mBShakeView;
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            return;
        }
        this.U = campaignUnit;
        if (campaignUnit == null || campaignUnit.getAds() == null || this.U.getAds().size() <= 5 || (mBShakeView = this.V) == null) {
            return;
        }
        mBShakeView.setPadding(0, 0, 0, ai.a(getContext(), 5.0f));
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        ad.b(MBridgeBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
        this.M = i11;
        this.N = i12;
        this.O = i13;
        this.P = i14;
        f();
    }

    public void setOnPause() {
        this.I = false;
    }

    public void setOnResume() {
        this.I = true;
    }

    public void setUnitId(String str) {
        this.T = str;
    }
}
