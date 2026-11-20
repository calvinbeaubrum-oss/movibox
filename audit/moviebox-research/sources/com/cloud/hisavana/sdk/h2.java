package com.cloud.hisavana.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.TadmWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient;
import com.cloud.hisavana.sdk.internal.agentpage.bean.AgentPageCurrentAd;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f29750a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f29753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f29754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdChoicesView f29755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TadmWebView f29756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InteractiveWebView f29757h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f29759j;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f29765p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public j f29767r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdsDTO f29751b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f29752c = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f29758i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x9.c f29760k = new x9.c(com.cloud.sdk.commonutil.util.f.a());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f29761l = -1.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f29762m = -1.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f29763n = -1.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f29764o = -1.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g f29766q = new g(this);

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29768a;

        public a(AdsDTO adsDTO) {
            this.f29768a = adsDTO;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AthenaTracker.U(this.f29768a, 5);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            if (Build.VERSION.SDK_INT >= 23) {
                return;
            }
            AthenaTracker.U(this.f29768a, 4);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            AthenaTracker.U(this.f29768a, 4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements InteractiveWebView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InteractiveWebView f29771b;

        public b(AdsDTO adsDTO, InteractiveWebView interactiveWebView) {
            this.f29770a = adsDTO;
            this.f29771b = interactiveWebView;
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void a(String str) {
            AthenaTracker.z(this.f29770a, str);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void b() {
            h2.this.d(this.f29771b);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void c() {
            z.a().d("BannerGemini", "timeoutShutdown");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements l1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TadmWebView f29773a;

        public c(TadmWebView tadmWebView) {
            this.f29773a = tadmWebView;
        }

        @Override // com.cloud.hisavana.sdk.l1
        public void a(@Nullable String str, int i11) {
            h2.this.f29750a.F0();
            AthenaTracker.c0(h2.this.f29751b, str, i11);
        }

        @Override // com.cloud.hisavana.sdk.l1
        public int b(float f11, float f12, float f13, float f14) {
            h2.this.f29761l = f11;
            h2.this.f29762m = f12;
            h2.this.f29763n = f13;
            h2.this.f29764o = f14;
            return h2.this.p(this.f29773a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements AgentPageJsBridge.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f29775a;

        public d(ViewGroup viewGroup) {
            this.f29775a = viewGroup;
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge.a
        public void a() {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(h2.this.f29751b, this.f29775a, h2.this.f29766q);
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge.a
        public void a(int i11) {
            if (h2.this.f29750a != null) {
                h2.this.f29750a.c1(i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge.a
        public void onClick() {
            if (h2.this.f29750a == null || h2.this.f29750a.l() == null) {
                return;
            }
            h2.this.f29750a.l().a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements AgentPageWebViewClient.OverrideListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f29777a = false;

        public e() {
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public boolean OnOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
                return false;
            }
            AdsDTO adsDTOM117clone = h2.this.f29751b.m117clone();
            adsDTOM117clone.setAdChoiceClickUrl(webResourceRequest.getUrl().toString());
            e1.i(webView.getContext(), adsDTOM117clone, true, false, null);
            return true;
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public boolean OnOverrideUrlLoading(WebView webView, String str) {
            AdsDTO adsDTOM117clone = h2.this.f29751b.m117clone();
            adsDTOM117clone.setAdChoiceClickUrl(str);
            e1.i(webView.getContext(), adsDTOM117clone, true, false, null);
            return true;
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public void onError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceRequest == null || !webResourceRequest.isForMainFrame() || this.f29777a || h2.this.f29750a == null) {
                return;
            }
            h2.this.f29750a.F0();
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public void onPageFinished(WebView webView, String str) {
            if (webView == null || webView.getProgress() != 100) {
                return;
            }
            this.f29777a = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnClickListener {
        public f() {
        }

        public /* synthetic */ f(h2 h2Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h2.this.f29751b != null) {
                e1.g(view.getContext(), h2.this.f29751b);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends com.cloud.hisavana.sdk.common.tranmeasure.a<AdsDTO> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<h2> f29780a;

        public g(h2 h2Var) {
            this.f29780a = new WeakReference<>(h2Var);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            j2 j2Var;
            super.a(adsDTO);
            z.a().d("BannerGemini", "view has impression,start report track---------------------------------");
            h2 h2Var = this.f29780a.get();
            if (h2Var == null || (j2Var = h2Var.f29750a) == null || j2Var.l() == null) {
                return;
            }
            j2Var.l().g();
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return;
            }
            x.h().k(adsDTO.getImpBeanRequest().pmid);
            if (adsDTO.getSource() == 4) {
                a0.f29085a.m(adsDTO.getAdCreativeId(), adsDTO.getCodeSeatId());
            } else if (adsDTO.isOfflineAd()) {
                adsDTO.setShowNum(Integer.valueOf(adsDTO.getShowNum().intValue() + 1));
                b1.c().s(adsDTO);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements View.OnClickListener {
        public h() {
        }

        public /* synthetic */ h(h2 h2Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h2.this.d(view);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements View.OnTouchListener {
        public i() {
        }

        public /* synthetic */ i(h2 h2Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                h2.this.f29761l = motionEvent.getX();
                h2.this.f29762m = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            h2.this.f29763n = motionEvent.getX();
            h2.this.f29764o = motionEvent.getY();
            return false;
        }
    }

    public h2(j2 j2Var) {
        this.f29750a = j2Var;
    }

    public final void A(ViewGroup viewGroup) {
        int i11;
        AdsDTO adsDTO = this.f29751b;
        if (adsDTO == null) {
            return;
        }
        String adImgUrl = adsDTO.getAdImgUrl();
        if ((!TextUtils.equals(this.f29751b.getMaterialStyle(), "B20301") && !TextUtils.equals(this.f29751b.getMaterialStyle(), "B20302") && !TextUtils.equals(this.f29751b.getMaterialStyle(), "B20303")) || this.f29751b.getPackageName() == null || this.f29751b.getNativeObject() == null) {
            i11 = 2;
        } else {
            adImgUrl = this.f29751b.getNativeObject().getLogoUrl();
            i11 = 1;
        }
        e(viewGroup);
        if (this.f29751b.getSource() == 4) {
            AdsDTO adsDTO2 = this.f29751b;
            ImageView imageView = this.f29753d;
            if (imageView == null) {
                imageView = this.f29754e;
            }
            DownLoadRequest.o(adImgUrl, adsDTO2, null, imageView);
            return;
        }
        AdsDTO adsDTO3 = this.f29751b;
        ImageView imageView2 = this.f29753d;
        if (imageView2 == null) {
            imageView2 = this.f29754e;
        }
        DownLoadRequest.p(adImgUrl, adsDTO3, i11, null, imageView2);
    }

    public void c() {
        com.cloud.sdk.commonutil.util.l.a(this.f29753d);
        com.cloud.sdk.commonutil.util.l.a(this.f29754e);
        com.cloud.sdk.commonutil.util.l.a(this.f29755f);
        TadmWebView tadmWebView = this.f29756g;
        if (tadmWebView != null) {
            tadmWebView.destroy();
            this.f29756g = null;
        }
        InteractiveWebView interactiveWebView = this.f29757h;
        if (interactiveWebView != null) {
            interactiveWebView.destroy();
            this.f29757h = null;
        }
        j jVar = this.f29767r;
        if (jVar != null) {
            jVar.h();
        }
    }

    public final void d(View view) {
        z zVarA;
        String str;
        try {
            AdsDTO adsDTO = this.f29751b;
            if (adsDTO != null) {
                if (adsDTO.getPslinkInfo() != null) {
                    if (view.getId() == R$id.tvBtn) {
                        this.f29751b.getPslinkInfo().setClickType(2);
                        zVarA = z.a();
                        str = "pslink half setClickType, click_install";
                    } else {
                        this.f29751b.getPslinkInfo().setClickType(1);
                        zVarA = z.a();
                        str = "pslink half setClickType, click_img";
                    }
                    zVarA.d("BannerGemini", str);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f29765p > 1000) {
                    p(view);
                    this.f29765p = jCurrentTimeMillis;
                }
            }
        } catch (Exception e11) {
            z.a().e(Log.getStackTraceString(e11));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:104:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:106:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:108:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:110:0x0300 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0302  */
    /* JADX WARN: Code duplicated, block: B:115:0x030d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0311  */
    /* JADX WARN: Code duplicated, block: B:119:0x0321  */
    /* JADX WARN: Code duplicated, block: B:120:0x032a  */
    /* JADX WARN: Code duplicated, block: B:123:0x0337  */
    /* JADX WARN: Code duplicated, block: B:124:0x0340  */
    /* JADX WARN: Code duplicated, block: B:13:0x006d  */
    /* JADX WARN: Code duplicated, block: B:50:0x014a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0162  */
    /* JADX WARN: Code duplicated, block: B:53:0x0164  */
    /* JADX WARN: Code duplicated, block: B:56:0x016b  */
    /* JADX WARN: Code duplicated, block: B:57:0x016d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0174  */
    /* JADX WARN: Code duplicated, block: B:61:0x0176  */
    /* JADX WARN: Code duplicated, block: B:64:0x017d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0185 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x0187  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:75:0x020d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0226  */
    /* JADX WARN: Code duplicated, block: B:80:0x0247 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0249  */
    /* JADX WARN: Code duplicated, block: B:82:0x024b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0252  */
    /* JADX WARN: Code duplicated, block: B:86:0x0254  */
    /* JADX WARN: Code duplicated, block: B:89:0x025c  */
    /* JADX WARN: Code duplicated, block: B:90:0x025f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0275  */
    /* JADX WARN: Code duplicated, block: B:99:0x0290  */
    public void e(ViewGroup viewGroup) {
        z zVarA;
        String str;
        byte b11;
        boolean z11;
        boolean z12;
        View view;
        TextView textView;
        String materialStyle;
        byte b12;
        boolean zA;
        StoreMarkView storeMarkView;
        TextView textView2;
        ImageView imageView;
        ImageView imageView2;
        TextView textView3;
        View viewFindViewById;
        int i11;
        int iA;
        float f11;
        int i12;
        int i13;
        float f12;
        if (this.f29751b == null || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        ((RelativeLayout) viewGroup).setGravity(17);
        if (this.f29751b.getNativeObject() != null && this.f29751b.getMaterialStyle() != null) {
            z.a().d("BannerGemini", "*----> TranBanner --> MaterialStyle =" + this.f29751b.getMaterialStyle());
            m2 m2Var = new m2(this.f29751b);
            int iG = m2Var.g();
            String materialStyle2 = this.f29751b.getMaterialStyle();
            materialStyle2.hashCode();
            switch (materialStyle2) {
                case "B3201":
                    b11 = 0;
                    break;
                case "B20301":
                    b11 = 1;
                    break;
                case "B20302":
                    b11 = 2;
                    break;
                case "B20303":
                    b11 = 3;
                    break;
                case "B20304":
                    b11 = 4;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            a aVar = null;
            switch (b11) {
                case 0:
                    this.f29752c = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.banner_style_3201_layout, viewGroup, false);
                    iG = -1;
                    z11 = true;
                    z12 = true;
                    this.f29751b.setBannerStyle(iG);
                    com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f29751b, this.f29752c, this.f29766q);
                    AthenaTracker.B(this.f29751b);
                    view = this.f29752c;
                    if (view != null) {
                        textView = (TextView) view.findViewById(R$id.tvDescription);
                        materialStyle = this.f29751b.getMaterialStyle();
                        materialStyle.hashCode();
                        switch (materialStyle) {
                            case "B20301":
                                b12 = 0;
                                break;
                            case "B20302":
                                b12 = 1;
                                break;
                            case "B20303":
                                b12 = 2;
                                break;
                            default:
                                b12 = -1;
                                break;
                        }
                        switch (b12) {
                            case 0:
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getTitleTxt());
                                if (textView != null) {
                                    textView.setText(this.f29751b.getNativeObject().getDescriptionTxt());
                                }
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                break;
                            case 1:
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getTitleTxt());
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                if (textView != null) {
                                    ((TextView) this.f29752c.findViewById(R$id.tvDescription)).setVisibility(8);
                                }
                                break;
                            case 2:
                                if (textView != null) {
                                    textView.setText(this.f29751b.getNativeObject().getTitleTxt());
                                }
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getDescriptionTxt());
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                break;
                        }
                        zA = w9.x.a(this.f29751b);
                        storeMarkView = (StoreMarkView) this.f29752c.findViewById(R$id.ps_mark_view);
                        if (storeMarkView != null) {
                            if (zA) {
                                i12 = 0;
                            } else {
                                i12 = 8;
                            }
                            storeMarkView.setVisibility(i12);
                            if (z11) {
                                i13 = -1;
                            } else {
                                i13 = -8882056;
                            }
                            storeMarkView.setTextColor(i13);
                            if (z11) {
                                f12 = 8.0f;
                            } else {
                                f12 = 6.0f;
                            }
                            storeMarkView.setTextSize(f12);
                            storeMarkView.attachInfo(this.f29751b);
                        }
                        textView2 = (TextView) this.f29752c.findViewById(R$id.tvName);
                        if (textView2 != null && textView2.getPaint() != null) {
                            textView2.getPaint().setFakeBoldText(true);
                        }
                        imageView = (ImageView) this.f29752c.findViewById(R$id.iv_main_image);
                        this.f29753d = imageView;
                        if (imageView != null) {
                            imageView.setOnTouchListener(new i(this, aVar));
                            this.f29753d.setOnClickListener(new h(this, aVar));
                        }
                        this.f29754e = (ImageView) this.f29752c.findViewById(R$id.ivIcon);
                        u(this.f29751b, this.f29752c);
                        j(this.f29751b, this.f29752c);
                        k(this.f29751b, this.f29752c, true);
                        if (iG != 1 || iG == 2) {
                            imageView2 = (ImageView) this.f29752c.findViewById(R$id.score_icon);
                            textView3 = (TextView) this.f29752c.findViewById(R$id.score_text);
                            viewFindViewById = this.f29752c.findViewById(R$id.score_dot);
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(z2.a.getDrawable(com.cloud.sdk.commonutil.util.f.a(), m2Var.f(iG)));
                            }
                            if (textView3 != null) {
                                textView3.setText(m2Var.h(iG));
                            }
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(zA ? 0 : 8);
                            }
                        }
                        if (com.cloud.sdk.commonutil.util.j.e() == 2) {
                            View view2 = this.f29752c;
                            if (z12) {
                                iA = com.cloud.sdk.commonutil.util.j.a(300.0f);
                                f11 = 200.0f;
                            } else {
                                iA = com.cloud.sdk.commonutil.util.j.a(360.0f);
                                f11 = 54.0f;
                            }
                            viewGroup.addView(view2, iA, com.cloud.sdk.commonutil.util.j.a(f11));
                        } else {
                            viewGroup.addView(this.f29752c, -1, -2);
                        }
                        if (viewGroup.getBackground() != null) {
                            i11 = 0;
                            viewGroup.getBackground().setAlpha(0);
                        } else {
                            i11 = 0;
                        }
                        viewGroup.setVisibility(i11);
                        zVarA = z.a();
                        str = "ad banner show...";
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    int i14 = R$layout.banner_style_20301_20302_20303_layout;
                    if (iG == 1 || iG == 2) {
                        i14 = R$layout.banner_style_203_newstyle_layout;
                    }
                    View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i14, viewGroup, false);
                    this.f29752c = viewInflate;
                    viewInflate.findViewById(R$id.clRoot).setOnTouchListener(new i(this, aVar));
                    this.f29752c.findViewById(R$id.clRoot).setOnClickListener(new h(this, aVar));
                    this.f29752c.findViewById(R$id.tvBtn).setOnClickListener(new h(this, aVar));
                    z11 = false;
                    z12 = false;
                    this.f29751b.setBannerStyle(iG);
                    com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f29751b, this.f29752c, this.f29766q);
                    AthenaTracker.B(this.f29751b);
                    view = this.f29752c;
                    if (view != null) {
                        textView = (TextView) view.findViewById(R$id.tvDescription);
                        materialStyle = this.f29751b.getMaterialStyle();
                        materialStyle.hashCode();
                        switch (materialStyle) {
                            case 1937180532:
                                if (!materialStyle.equals("B20301")) {
                                    b12 = 0;
                                } else {
                                    b12 = -1;
                                }
                                break;
                            case 1937180533:
                                if (!materialStyle.equals("B20302")) {
                                    b12 = 1;
                                } else {
                                    b12 = -1;
                                }
                                break;
                            case 1937180534:
                                if (!materialStyle.equals("B20303")) {
                                    b12 = 2;
                                } else {
                                    b12 = -1;
                                }
                                break;
                            default:
                                b12 = -1;
                                break;
                        }
                        switch (b12) {
                            case 0:
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getTitleTxt());
                                if (textView != null) {
                                    textView.setText(this.f29751b.getNativeObject().getDescriptionTxt());
                                }
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                break;
                            case 1:
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getTitleTxt());
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                if (textView != null) {
                                    ((TextView) this.f29752c.findViewById(R$id.tvDescription)).setVisibility(8);
                                }
                                break;
                            case 2:
                                if (textView != null) {
                                    textView.setText(this.f29751b.getNativeObject().getTitleTxt());
                                }
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getDescriptionTxt());
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                break;
                        }
                        zA = w9.x.a(this.f29751b);
                        storeMarkView = (StoreMarkView) this.f29752c.findViewById(R$id.ps_mark_view);
                        if (storeMarkView != null) {
                            if (zA) {
                                i12 = 0;
                            } else {
                                i12 = 8;
                            }
                            storeMarkView.setVisibility(i12);
                            if (z11) {
                                i13 = -1;
                            } else {
                                i13 = -8882056;
                            }
                            storeMarkView.setTextColor(i13);
                            if (z11) {
                                f12 = 8.0f;
                            } else {
                                f12 = 6.0f;
                            }
                            storeMarkView.setTextSize(f12);
                            storeMarkView.attachInfo(this.f29751b);
                        }
                        textView2 = (TextView) this.f29752c.findViewById(R$id.tvName);
                        if (textView2 != null) {
                            textView2.getPaint().setFakeBoldText(true);
                        }
                        imageView = (ImageView) this.f29752c.findViewById(R$id.iv_main_image);
                        this.f29753d = imageView;
                        if (imageView != null) {
                            imageView.setOnTouchListener(new i(this, aVar));
                            this.f29753d.setOnClickListener(new h(this, aVar));
                        }
                        this.f29754e = (ImageView) this.f29752c.findViewById(R$id.ivIcon);
                        u(this.f29751b, this.f29752c);
                        j(this.f29751b, this.f29752c);
                        k(this.f29751b, this.f29752c, true);
                        if (iG != 1) {
                            imageView2 = (ImageView) this.f29752c.findViewById(R$id.score_icon);
                            textView3 = (TextView) this.f29752c.findViewById(R$id.score_text);
                            viewFindViewById = this.f29752c.findViewById(R$id.score_dot);
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(z2.a.getDrawable(com.cloud.sdk.commonutil.util.f.a(), m2Var.f(iG)));
                            }
                            if (textView3 != null) {
                                textView3.setText(m2Var.h(iG));
                            }
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(zA ? 0 : 8);
                            }
                        } else {
                            imageView2 = (ImageView) this.f29752c.findViewById(R$id.score_icon);
                            textView3 = (TextView) this.f29752c.findViewById(R$id.score_text);
                            viewFindViewById = this.f29752c.findViewById(R$id.score_dot);
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(z2.a.getDrawable(com.cloud.sdk.commonutil.util.f.a(), m2Var.f(iG)));
                            }
                            if (textView3 != null) {
                                textView3.setText(m2Var.h(iG));
                            }
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(zA ? 0 : 8);
                            }
                        }
                        if (com.cloud.sdk.commonutil.util.j.e() == 2) {
                            View view3 = this.f29752c;
                            if (z12) {
                                iA = com.cloud.sdk.commonutil.util.j.a(300.0f);
                                f11 = 200.0f;
                            } else {
                                iA = com.cloud.sdk.commonutil.util.j.a(360.0f);
                                f11 = 54.0f;
                            }
                            viewGroup.addView(view3, iA, com.cloud.sdk.commonutil.util.j.a(f11));
                        } else {
                            viewGroup.addView(this.f29752c, -1, -2);
                        }
                        if (viewGroup.getBackground() != null) {
                            i11 = 0;
                            viewGroup.getBackground().setAlpha(0);
                        } else {
                            i11 = 0;
                        }
                        viewGroup.setVisibility(i11);
                        zVarA = z.a();
                        str = "ad banner show...";
                        break;
                    }
                    break;
                case 4:
                    this.f29752c = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.banner_style_20304_layout, viewGroup, false);
                    iG = -1;
                    z11 = false;
                    z12 = false;
                    this.f29751b.setBannerStyle(iG);
                    com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f29751b, this.f29752c, this.f29766q);
                    AthenaTracker.B(this.f29751b);
                    view = this.f29752c;
                    if (view != null) {
                        textView = (TextView) view.findViewById(R$id.tvDescription);
                        materialStyle = this.f29751b.getMaterialStyle();
                        materialStyle.hashCode();
                        switch (materialStyle) {
                            case 1937180532:
                                if (!materialStyle.equals("B20301")) {
                                    b12 = 0;
                                } else {
                                    b12 = -1;
                                }
                                break;
                            case 1937180533:
                                if (!materialStyle.equals("B20302")) {
                                    b12 = 1;
                                } else {
                                    b12 = -1;
                                }
                                break;
                            case 1937180534:
                                if (!materialStyle.equals("B20303")) {
                                    b12 = 2;
                                } else {
                                    b12 = -1;
                                }
                                break;
                            default:
                                b12 = -1;
                                break;
                        }
                        switch (b12) {
                            case 0:
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getTitleTxt());
                                if (textView != null) {
                                    textView.setText(this.f29751b.getNativeObject().getDescriptionTxt());
                                }
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                break;
                            case 1:
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getTitleTxt());
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                if (textView != null) {
                                    ((TextView) this.f29752c.findViewById(R$id.tvDescription)).setVisibility(8);
                                }
                                break;
                            case 2:
                                if (textView != null) {
                                    textView.setText(this.f29751b.getNativeObject().getTitleTxt());
                                }
                                ((TextView) this.f29752c.findViewById(R$id.tvName)).setText(this.f29751b.getNativeObject().getDescriptionTxt());
                                ((TextView) this.f29752c.findViewById(R$id.tvBtn)).setText(this.f29751b.getNativeObject().getButtonTxt(this.f29751b.getInstallApk()));
                                break;
                        }
                        zA = w9.x.a(this.f29751b);
                        storeMarkView = (StoreMarkView) this.f29752c.findViewById(R$id.ps_mark_view);
                        if (storeMarkView != null) {
                            if (zA) {
                                i12 = 0;
                            } else {
                                i12 = 8;
                            }
                            storeMarkView.setVisibility(i12);
                            if (z11) {
                                i13 = -1;
                            } else {
                                i13 = -8882056;
                            }
                            storeMarkView.setTextColor(i13);
                            if (z11) {
                                f12 = 8.0f;
                            } else {
                                f12 = 6.0f;
                            }
                            storeMarkView.setTextSize(f12);
                            storeMarkView.attachInfo(this.f29751b);
                        }
                        textView2 = (TextView) this.f29752c.findViewById(R$id.tvName);
                        if (textView2 != null) {
                            textView2.getPaint().setFakeBoldText(true);
                        }
                        imageView = (ImageView) this.f29752c.findViewById(R$id.iv_main_image);
                        this.f29753d = imageView;
                        if (imageView != null) {
                            imageView.setOnTouchListener(new i(this, aVar));
                            this.f29753d.setOnClickListener(new h(this, aVar));
                        }
                        this.f29754e = (ImageView) this.f29752c.findViewById(R$id.ivIcon);
                        u(this.f29751b, this.f29752c);
                        j(this.f29751b, this.f29752c);
                        k(this.f29751b, this.f29752c, true);
                        if (iG != 1) {
                            imageView2 = (ImageView) this.f29752c.findViewById(R$id.score_icon);
                            textView3 = (TextView) this.f29752c.findViewById(R$id.score_text);
                            viewFindViewById = this.f29752c.findViewById(R$id.score_dot);
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(z2.a.getDrawable(com.cloud.sdk.commonutil.util.f.a(), m2Var.f(iG)));
                            }
                            if (textView3 != null) {
                                textView3.setText(m2Var.h(iG));
                            }
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(zA ? 0 : 8);
                            }
                        } else {
                            imageView2 = (ImageView) this.f29752c.findViewById(R$id.score_icon);
                            textView3 = (TextView) this.f29752c.findViewById(R$id.score_text);
                            viewFindViewById = this.f29752c.findViewById(R$id.score_dot);
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(z2.a.getDrawable(com.cloud.sdk.commonutil.util.f.a(), m2Var.f(iG)));
                            }
                            if (textView3 != null) {
                                textView3.setText(m2Var.h(iG));
                            }
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(zA ? 0 : 8);
                            }
                        }
                        if (com.cloud.sdk.commonutil.util.j.e() == 2) {
                            View view4 = this.f29752c;
                            if (z12) {
                                iA = com.cloud.sdk.commonutil.util.j.a(300.0f);
                                f11 = 200.0f;
                            } else {
                                iA = com.cloud.sdk.commonutil.util.j.a(360.0f);
                                f11 = 54.0f;
                            }
                            viewGroup.addView(view4, iA, com.cloud.sdk.commonutil.util.j.a(f11));
                        } else {
                            viewGroup.addView(this.f29752c, -1, -2);
                        }
                        if (viewGroup.getBackground() != null) {
                            i11 = 0;
                            viewGroup.getBackground().setAlpha(0);
                        } else {
                            i11 = 0;
                        }
                        viewGroup.setVisibility(i11);
                        zVarA = z.a();
                        str = "ad banner show...";
                        break;
                    }
                    break;
                default:
                    zVarA = z.a();
                    str = "TranBanner --> 没有匹配到 materialStyle --> 配置错误 materialStyle=" + this.f29751b.getMaterialStyle();
                    break;
            }
        }
        zVarA = z.a();
        str = "TranBanner --> null == mAdBean.nativeBean || null == mAdBean.materialStyle";
        zVarA.d("BannerGemini", str);
    }

    public void f(ViewGroup viewGroup, boolean z11, boolean z12, AdsDTO adsDTO) {
        j2 j2Var;
        this.f29758i = z11;
        this.f29759j = z12;
        if (adsDTO != null) {
            this.f29751b = adsDTO;
            if (NetStateManager.checkNetworkState() && (j2Var = this.f29750a) != null && j2Var.d0() != null && this.f29750a.d0().isPriorityH5Ad().booleanValue() && w9.a0.f(this.f29750a.d0().getH5AdUrl())) {
                x(viewGroup);
                return;
            }
            if (!TextUtils.isEmpty(adsDTO.getAdm())) {
                s(viewGroup);
            } else if (adsDTO.isInteractiveAd()) {
                z(viewGroup);
            } else {
                A(viewGroup);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    public void g(InteractiveWebView interactiveWebView, ViewGroup viewGroup) {
        z zVarA;
        String str;
        boolean z11;
        int iA;
        float f11;
        int iK;
        AdsDTO adsDTO = this.f29751b;
        if (adsDTO == null || viewGroup == null || interactiveWebView == null) {
            return;
        }
        viewGroup.removeAllViews();
        ((RelativeLayout) viewGroup).setGravity(17);
        if (adsDTO.getNativeObject() == null || adsDTO.getMaterialStyle() == null) {
            zVarA = z.a();
            str = "TranBanner --> null == mAdBean.nativeBean || null == mAdBean.materialStyle";
        } else {
            z.a().d("BannerGemini", "*----> TranBanner --> MaterialStyle =" + adsDTO.getMaterialStyle());
            String materialStyle = adsDTO.getMaterialStyle();
            materialStyle.hashCode();
            boolean z12 = true;
            switch (materialStyle) {
                case "B3201":
                    this.f29752c = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.banner_style_3201_layout, viewGroup, false);
                    z11 = true;
                    break;
                case "B20301":
                case "B20302":
                case "B20303":
                case "B20304":
                    this.f29752c = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.banner_style_20304_layout, viewGroup, false);
                    z11 = false;
                    z12 = false;
                    break;
                default:
                    zVarA = z.a();
                    str = "TranBanner --> 没有匹配到 materialStyle --> 配置错误 materialStyle=" + adsDTO.getMaterialStyle();
                    break;
            }
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(adsDTO, this.f29752c, this.f29766q);
            AthenaTracker.B(this.f29751b);
            View view = this.f29752c;
            if (view == null) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.ivBanner);
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                interactiveWebView.setLayoutParams(layoutParams);
                List<String> scales = adsDTO.getScales();
                if (scales != null && !scales.isEmpty()) {
                    String str2 = scales.get(0);
                    str2.hashCode();
                    if (str2.equals("3:2")) {
                        iK = (ca.d.k() * 2) / 3;
                    } else if (str2.equals("20:3")) {
                        iK = (ca.d.k() * 3) / 20;
                    }
                    layoutParams.height = iK;
                    layoutParams.width = ca.d.k();
                }
                frameLayout.addView(interactiveWebView, layoutParams);
                frameLayout.setOnTouchListener(new i(this, null));
                interactiveWebView.setWebViewClient(new a(adsDTO));
                interactiveWebView.setmListener(new b(adsDTO, interactiveWebView));
                l(adsDTO, interactiveWebView);
            }
            m(adsDTO, z12, this.f29752c);
            ImageView imageView = (ImageView) this.f29752c.findViewById(R$id.ivIcon);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            u(adsDTO, this.f29752c);
            j(adsDTO, this.f29752c);
            k(adsDTO, this.f29752c, false);
            interactiveWebView.setVisibility(0);
            if (com.cloud.sdk.commonutil.util.j.e() == 2) {
                View view2 = this.f29752c;
                if (z11) {
                    iA = com.cloud.sdk.commonutil.util.j.a(300.0f);
                    f11 = 200.0f;
                } else {
                    iA = com.cloud.sdk.commonutil.util.j.a(360.0f);
                    f11 = 54.0f;
                }
                viewGroup.addView(view2, iA, com.cloud.sdk.commonutil.util.j.a(f11));
            } else {
                viewGroup.addView(this.f29752c, -1, -2);
            }
            if (viewGroup.getBackground() != null) {
                viewGroup.getBackground().setAlpha(0);
            }
            viewGroup.setVisibility(0);
            zVarA = z.a();
            str = "ad banner attachInteractiveAd show...";
        }
        zVarA.d("BannerGemini", str);
    }

    public void h(TadmWebView tadmWebView, ViewGroup viewGroup) {
        AdsDTO adsDTO;
        if (viewGroup == null || tadmWebView == null || (adsDTO = this.f29751b) == null || TextUtils.isEmpty(adsDTO.getAdm())) {
            return;
        }
        AthenaTracker.B(this.f29751b);
        if (this.f29767r == null) {
            this.f29767r = new j();
        }
        this.f29767r.d(tadmWebView, this.f29751b, new c(tadmWebView));
        i(tadmWebView, viewGroup, false, false, false);
        tadmWebView.loadDataWithBaseURL(null, this.f29751b.getAdm() + TadmWebView.JS_TEXT, "text/html", "utf-8", null);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:38:0x0117  */
    public final void i(TadmWebView tadmWebView, ViewGroup viewGroup, boolean z11, boolean z12, boolean z13) {
        int iA;
        float f11;
        View viewFindViewById;
        viewGroup.removeAllViews();
        ((RelativeLayout) viewGroup).setGravity(17);
        this.f29752c = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.banner_style_3201_layout, viewGroup, false);
        if (!z13) {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f29751b, viewGroup, this.f29766q);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        View viewFindViewById2 = this.f29752c.findViewById(R$id.ivBanner);
        if (viewFindViewById2 instanceof FrameLayout) {
            ((FrameLayout) viewFindViewById2).addView(tadmWebView, layoutParams);
        }
        if (z12 && (viewFindViewById = this.f29752c.findViewById(R$id.ad_flag)) != null) {
            viewFindViewById.setVisibility(8);
        }
        u(this.f29751b, this.f29752c);
        j(this.f29751b, this.f29752c);
        k(this.f29751b, this.f29752c, z11);
        ImageView imageView = (ImageView) this.f29752c.findViewById(R$id.ivIcon);
        boolean z14 = true;
        if (imageView != null && this.f29751b.getNativeObject() != null && this.f29751b.getNativeObject().getLogoUrl() != null) {
            DownLoadRequest.p(this.f29751b.getNativeObject().getLogoUrl(), this.f29751b, 1, null, imageView);
        }
        if (tadmWebView.getLayoutParams() == null) {
            z14 = false;
        } else {
            List<String> scales = this.f29751b.getScales();
            if (scales == null || scales.isEmpty()) {
                if (com.cloud.sdk.commonutil.util.j.e() != 1) {
                    tadmWebView.getLayoutParams().height = -1;
                    tadmWebView.getLayoutParams().width = -1;
                } else if (TextUtils.equals(this.f29751b.getMaterialStyle(), "B3201")) {
                    tadmWebView.getLayoutParams().height = (ca.d.k() * 2) / 3;
                    tadmWebView.getLayoutParams().width = ca.d.k();
                } else {
                    tadmWebView.getLayoutParams().height = (ca.d.k() * 3) / 20;
                    tadmWebView.getLayoutParams().width = ca.d.k();
                }
                z14 = false;
            } else {
                if (com.cloud.sdk.commonutil.util.j.e() == 1) {
                    String str = scales.get(0);
                    str.hashCode();
                    if (str.equals("3:2")) {
                        tadmWebView.getLayoutParams().height = (ca.d.k() * 2) / 3;
                        tadmWebView.getLayoutParams().width = ca.d.k();
                    } else if (str.equals("20:3")) {
                        tadmWebView.getLayoutParams().height = (ca.d.k() * 3) / 20;
                        tadmWebView.getLayoutParams().width = ca.d.k();
                    }
                } else {
                    tadmWebView.getLayoutParams().height = -1;
                    tadmWebView.getLayoutParams().width = -1;
                }
                z14 = false;
            }
        }
        tadmWebView.setVisibility(0);
        z.a().d("BannerGemini", "banner attachBannerToViewTree");
        if (viewGroup.getBackground() != null) {
            viewGroup.getBackground().setAlpha(0);
        }
        viewGroup.setVisibility(0);
        if (com.cloud.sdk.commonutil.util.j.e() != 2) {
            viewGroup.addView(this.f29752c, -1, -2);
            return;
        }
        View view = this.f29752c;
        if (z14) {
            iA = com.cloud.sdk.commonutil.util.j.a(300.0f);
            f11 = 200.0f;
        } else {
            iA = com.cloud.sdk.commonutil.util.j.a(360.0f);
            f11 = 54.0f;
        }
        viewGroup.addView(view, iA, com.cloud.sdk.commonutil.util.j.a(f11));
    }

    public final void j(AdsDTO adsDTO, View view) {
        AdBadgeView adBadgeView;
        if (adsDTO == null || view == null || (adBadgeView = (AdBadgeView) view.findViewById(R$id.ad_badge_view)) == null) {
            return;
        }
        adBadgeView.setDisplayStyle(adsDTO.getDisplayRule(), w9.v.c(adsDTO));
    }

    public final void k(AdsDTO adsDTO, View view, boolean z11) {
        AdCloseView adCloseView;
        if (adsDTO == null || view == null || (adCloseView = (AdCloseView) view.findViewById(R$id.ad_close_view)) == null) {
            return;
        }
        if (z11 && this.f29758i) {
            adCloseView.setVisibility(8);
            return;
        }
        adCloseView.setVisibility(0);
        com.cloud.hisavana.sdk.h.p().g(com.cloud.sdk.commonutil.util.f.a(), adCloseView, this.f29750a, adsDTO, this.f29759j);
        adCloseView.setDisplayStyle(adsDTO.getDisplayRule(), AdCloseView.CloseImageType.CLOSE);
    }

    public final void l(AdsDTO adsDTO, InteractiveWebView interactiveWebView) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getIndexLocation())) {
            return;
        }
        if (!new File(adsDTO.getIndexLocation()).exists() || interactiveWebView == null) {
            j2 j2Var = this.f29750a;
            if (j2Var != null) {
                j2Var.F0();
            }
            AthenaTracker.U(this.f29751b, 3);
            return;
        }
        interactiveWebView.loadUrl("file://" + adsDTO.getIndexLocation());
    }

    public final void m(AdsDTO adsDTO, boolean z11, View view) {
        if (adsDTO == null || view == null) {
            return;
        }
        boolean zA = w9.x.a(adsDTO);
        StoreMarkView storeMarkView = (StoreMarkView) view.findViewById(R$id.ps_mark_view);
        if (storeMarkView != null) {
            storeMarkView.setVisibility(zA ? 0 : 8);
            storeMarkView.setTextColor(z11 ? -1 : -8882056);
            storeMarkView.setTextSize(z11 ? 8.0f : 6.0f);
            storeMarkView.attachInfo(adsDTO);
        }
    }

    public final int p(View view) {
        Context context = view.getContext();
        AdsDTO adsDTO = this.f29751b;
        DownUpPointBean downUpPointBean = new DownUpPointBean(this.f29761l, this.f29762m, this.f29763n, this.f29764o, view.getMeasuredHeight(), view.getMeasuredWidth());
        j2 j2Var = this.f29750a;
        int iA = e1.a(context, adsDTO, downUpPointBean, j2Var == null ? false : j2Var.t0());
        AthenaTracker.Y(this.f29751b);
        j2 j2Var2 = this.f29750a;
        if (j2Var2 != null && j2Var2.l() != null) {
            this.f29750a.l().a();
        }
        return iA;
    }

    public final void s(ViewGroup viewGroup) {
        AdsDTO adsDTO = this.f29751b;
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getAdm()) || viewGroup == null) {
            return;
        }
        TadmWebView tadmWebView = this.f29756g;
        if (tadmWebView != null) {
            tadmWebView.destroy();
        }
        try {
            TadmWebView tadmWebView2 = new TadmWebView(com.cloud.sdk.commonutil.util.f.a());
            this.f29756g = tadmWebView2;
            h(tadmWebView2, viewGroup);
        } catch (Throwable th2) {
            z.a().e("BannerGemini", "create webview error: " + Log.getStackTraceString(th2));
            this.f29756g = null;
        }
    }

    public void t(TadmWebView tadmWebView, ViewGroup viewGroup) {
        float f11;
        if (viewGroup == null || tadmWebView == null || this.f29751b == null) {
            return;
        }
        if (this.f29750a.d0() == null || TextUtils.isEmpty(this.f29750a.d0().getH5AdUrl())) {
            z.a().e("BannerGemini", "getConfig().getH5AdUrl() == null");
            return;
        }
        AthenaTracker.B(this.f29751b);
        AthenaTracker.A(0, null, null, this.f29751b);
        tadmWebView.getSettings().setCacheMode(-1);
        tadmWebView.getSettings().setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(tadmWebView, true);
        tadmWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        AgentPageJsBridge agentPageJsBridge = new AgentPageJsBridge();
        agentPageJsBridge.setWebview(tadmWebView);
        AgentPageCurrentAd agentPageCurrentAd = new AgentPageCurrentAd(this.f29750a.d0().getH5AdUrl(), this.f29751b.getCodeSeatId(), this.f29751b.getTriggerId());
        agentPageJsBridge.setCurrentAdInfo(agentPageCurrentAd);
        agentPageJsBridge.setAdActionListener(new d(viewGroup));
        agentPageJsBridge.setCurrentAd(this.f29751b);
        tadmWebView.addJavascriptInterface(agentPageJsBridge, AgentPageJsBridge.INTERFACE_NAME);
        AgentPageWebViewClient agentPageWebViewClient = new AgentPageWebViewClient(new e());
        agentPageWebViewClient.setMainPageUrl(this.f29750a.d0().getH5AdUrl());
        agentPageWebViewClient.setSource(this.f29751b.getSource());
        tadmWebView.setWebViewClient(agentPageWebViewClient);
        this.f29758i = true;
        i(tadmWebView, viewGroup, true, true, true);
        if (tadmWebView.getLayoutParams() != null) {
            if (tadmWebView.getLayoutParams().width <= 0 || tadmWebView.getLayoutParams().height <= 0) {
                if (TextUtils.equals(this.f29751b.getMaterialStyle(), "B3201")) {
                    agentPageCurrentAd.setHeight(com.cloud.sdk.commonutil.util.j.a(200.0f));
                    f11 = 300.0f;
                } else {
                    agentPageCurrentAd.setHeight(com.cloud.sdk.commonutil.util.j.a(54.0f));
                    f11 = 360.0f;
                }
                agentPageCurrentAd.setWidth(com.cloud.sdk.commonutil.util.j.a(f11));
            } else {
                agentPageCurrentAd.setWidth(tadmWebView.getLayoutParams().width);
                agentPageCurrentAd.setHeight(tadmWebView.getLayoutParams().height);
            }
        }
        tadmWebView.loadUrl(this.f29750a.d0().getH5AdUrl());
    }

    public final void u(AdsDTO adsDTO, View view) {
        AdChoicesView adChoicesView;
        if (adsDTO == null || view == null || (adChoicesView = (AdChoicesView) view.findViewById(R$id.ad_choices_view)) == null) {
            return;
        }
        a aVar = null;
        if (adsDTO.getSource() == 4) {
            DownLoadRequest.o(adsDTO.getAdChoiceImageUrl(), adsDTO, null, adChoicesView);
        } else {
            DownLoadRequest.p(adsDTO.getAdChoiceImageUrl(), adsDTO, 3, null, adChoicesView);
        }
        adChoicesView.setOnClickListener(new f(this, aVar));
        this.f29755f = adChoicesView;
    }

    public final void x(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        TadmWebView tadmWebView = this.f29756g;
        if (tadmWebView != null) {
            tadmWebView.destroy();
        }
        try {
            TadmWebView tadmWebView2 = new TadmWebView(com.cloud.sdk.commonutil.util.f.a());
            this.f29756g = tadmWebView2;
            t(tadmWebView2, viewGroup);
        } catch (Throwable th2) {
            z.a().e("BannerGemini", "create webview error: " + Log.getStackTraceString(th2));
            this.f29756g = null;
        }
    }

    public final void z(ViewGroup viewGroup) {
        if (this.f29751b == null) {
            return;
        }
        InteractiveWebView interactiveWebView = this.f29757h;
        if (interactiveWebView != null) {
            interactiveWebView.destroy();
        }
        try {
            InteractiveWebView interactiveWebView2 = new InteractiveWebView(com.cloud.sdk.commonutil.util.f.a());
            this.f29757h = interactiveWebView2;
            g(interactiveWebView2, viewGroup);
        } catch (Throwable th2) {
            z.a().e("BannerGemini", "create webview error: " + Log.getStackTraceString(th2));
            this.f29757h = null;
        }
    }
}
