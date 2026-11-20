package com.cloud.hisavana.sdk;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.CountTimeView;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.video.SplashAdVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.transsion.push.PushConstants;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f30197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SplashAdVideoView f30198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f30199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u1 f30200d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InteractiveWebView f30202f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q0 f30209m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f30210n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f30201e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f30203g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f30204h = -1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f30205i = -1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f30206j = -1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f30207k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f30208l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g f30211o = new g(this);

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f30212a;

        public a(AdsDTO adsDTO) {
            this.f30212a = adsDTO;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AthenaTracker.U(this.f30212a, 5);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            if (Build.VERSION.SDK_INT >= 23) {
                return;
            }
            AthenaTracker.U(this.f30212a, 4);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            AthenaTracker.U(this.f30212a, 4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements InteractiveWebView.b {
        public b() {
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void a(String str) {
            CountTimeView countTimeViewS0;
            z.a().d("SplashImage", "interactiveEvent: " + str);
            x1.this.l(str);
            if (x1.this.f30200d == null || (countTimeViewS0 = x1.this.f30200d.S0()) == null) {
                return;
            }
            countTimeViewS0.cancel();
            countTimeViewS0.changeFinishMode();
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void b() {
            z.a().d("SplashImage", "handleClick ");
            x1 x1Var = x1.this;
            x1Var.q(x1Var.f30202f);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void c() {
            z.a().d("SplashImage", "timeoutShutdown ");
            if (x1.this.f30200d != null) {
                x1.this.f30200d.L0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ValueCallback<String> {
        public c() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            z.a().e("SplashImage", "onReceiveValue " + str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f30216b;

        public d(AdsDTO adsDTO) {
            this.f30216b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            x1.this.e(TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR);
            r0.e().a();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            x1 x1Var = x1.this;
            if (adImage == null) {
                x1Var.e(TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR);
                r0.e().a();
                return;
            }
            if (x1Var.f30198b != null) {
                x1.this.f30198b.setMediaData(adImage.getFilePath(), this.f30216b);
            }
            if (x1.this.f30200d != null) {
                x1.this.f30200d.P0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends DrawableResponseListener {
        public e() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (x1.this.f30200d == null || x1.this.f30200d.l() == null) {
                return;
            }
            x1.this.e(taErrorCode);
            r0.e().a();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (x1.this.f30200d != null) {
                x1.this.f30200d.P0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends DrawableResponseListener {
        public f() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (x1.this.f30200d == null || x1.this.f30200d.l() == null) {
                return;
            }
            x1.this.e(taErrorCode);
            r0.e().a();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (x1.this.f30200d != null) {
                x1.this.f30200d.P0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends com.cloud.hisavana.sdk.common.tranmeasure.a<AdsDTO> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<x1> f30220a;

        public g(x1 x1Var) {
            this.f30220a = new WeakReference<>(x1Var);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            u1 u1Var;
            super.a(adsDTO);
            z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "onViewImpressed --> view has impression");
            x1 x1Var = this.f30220a.get();
            if (x1Var == null || x1Var.f30207k || (u1Var = x1Var.f30200d) == null || u1Var.l() == null) {
                return;
            }
            x1Var.f30207k = true;
            z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "mSplashAd.adListener().onAdShow()");
            u1Var.l().g();
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

        public /* synthetic */ h(x1 x1Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x1.this.q(view);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements View.OnTouchListener {
        public i() {
        }

        public /* synthetic */ i(x1 x1Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                x1.this.f30203g = motionEvent.getX();
                x1.this.f30204h = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            x1.this.f30205i = motionEvent.getX();
            x1.this.f30206j = motionEvent.getY();
            return false;
        }
    }

    public x1(u1 u1Var) {
        this.f30200d = u1Var;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    public void A(AdsDTO adsDTO) {
        View view;
        if (adsDTO == null) {
            return;
        }
        AthenaTracker.B(adsDTO);
        if (adsDTO.isVastTypeAd()) {
            y(adsDTO);
            view = this.f30198b;
        } else if (adsDTO.isInteractiveAd()) {
            v(adsDTO);
            view = this.f30202f;
        } else {
            if (adsDTO.getSource() != 4) {
                r(adsDTO);
            } else if (adsDTO.getDefaultMaterialType() == 1) {
                f(adsDTO);
            } else {
                y(adsDTO);
                view = this.f30198b;
            }
            view = this.f30197a;
        }
        u(view);
    }

    public View B(AdsDTO adsDTO) {
        if (adsDTO == null) {
            z.a().e("SplashImage", "getView adsDto is null");
            return new View(com.cloud.sdk.commonutil.util.f.a());
        }
        if (adsDTO.isInteractiveAd()) {
            return this.f30202f;
        }
        return (adsDTO.isVastTypeAd() || adsDTO.getDefaultMaterialType() == 2) ? this.f30198b : this.f30197a;
    }

    public void C(AdsDTO adsDTO) {
        if (adsDTO == null) {
            z.a().e("SplashImage", "initializeInteractiveAdView adsDTO is null");
            return;
        }
        if (this.f30202f != null || this.f30200d.N0() == null) {
            return;
        }
        a aVar = null;
        try {
            InteractiveWebView interactiveWebView = new InteractiveWebView(this.f30200d.N0());
            this.f30202f = interactiveWebView;
            interactiveWebView.setWebViewClient(new a(adsDTO));
            this.f30202f.setmListener(new b());
            this.f30202f.setOnTouchListener(new i(this, aVar));
        } catch (Throwable th2) {
            z.a().e("SplashImage", "create webview error: " + Log.getStackTraceString(th2));
            this.f30202f = null;
        }
    }

    public void D(AdsDTO adsDTO) {
        SplashAdVideoView splashAdVideoView;
        if (adsDTO == null || !adsDTO.isVastTypeAd() || (splashAdVideoView = this.f30198b) == null) {
            return;
        }
        splashAdVideoView.pause();
    }

    public void b() {
        u1 u1Var = this.f30200d;
        if (u1Var != null && u1Var.X != null) {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.f30200d.X);
        }
        d(this.f30197a);
        this.f30197a = null;
        InteractiveWebView interactiveWebView = this.f30202f;
        if (interactiveWebView != null) {
            interactiveWebView.setmListener(null);
            this.f30202f.destroy();
            this.f30202f = null;
        }
        SplashAdVideoView splashAdVideoView = this.f30198b;
        if (splashAdVideoView != null) {
            splashAdVideoView.setAdMediaPlayerListener(null);
            this.f30198b.release();
            this.f30198b = null;
        }
        z.a().d("ssp", PushConstants.PROVIDER_FIELD_DESTROY);
    }

    public void c(int i11) {
        this.f30210n = i11;
    }

    public final void d(View view) {
        if (view instanceof ImageView) {
            com.cloud.sdk.commonutil.util.l.a((ImageView) view);
        }
    }

    public final void e(TaErrorCode taErrorCode) {
        u1 u1Var = this.f30200d;
        if (u1Var == null || u1Var.l() == null) {
            return;
        }
        this.f30200d.l().h(taErrorCode);
    }

    public final void f(AdsDTO adsDTO) {
        if (this.f30197a == null) {
            this.f30197a = new ImageView(this.f30200d.N0());
        }
        ((ImageView) this.f30197a).setScaleType(ImageView.ScaleType.CENTER_CROP);
        DownLoadRequest.o(adsDTO.getAdImgUrl(), adsDTO, new f(), (ImageView) this.f30197a);
    }

    public final void g(AdsDTO adsDTO, InteractiveWebView interactiveWebView) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getIndexLocation()) || interactiveWebView == null) {
            u1 u1Var = this.f30200d;
            if (u1Var != null) {
                u1Var.L0();
                return;
            }
            return;
        }
        if (!new File(adsDTO.getIndexLocation()).exists()) {
            u1 u1Var2 = this.f30200d;
            if (u1Var2 != null) {
                u1Var2.L0();
            }
            AthenaTracker.U(adsDTO, 3);
            return;
        }
        interactiveWebView.loadUrl("file://" + adsDTO.getIndexLocation());
        u1 u1Var3 = this.f30200d;
        if (u1Var3 != null) {
            u1Var3.P0();
        }
    }

    public void h(q0 q0Var) {
        this.f30209m = q0Var;
    }

    public final void l(String str) {
        z zVarA;
        String str2;
        u1 u1Var = this.f30200d;
        if (u1Var == null) {
            zVarA = z.a();
            str2 = "trackInteractionEvent splashAd is null";
        } else {
            AdsDTO adsDTO = u1Var.X;
            if (adsDTO != null) {
                AthenaTracker.z(adsDTO, str);
                return;
            } else {
                zVarA = z.a();
                str2 = "trackInteractionEvent adsDto is null";
            }
        }
        zVarA.e("SplashImage", str2);
    }

    public final void q(View view) {
        if (view == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f30199c <= 1000 || this.f30200d == null) {
                return;
            }
            this.f30199c = jCurrentTimeMillis;
            e1.a(view.getContext(), this.f30200d.X, new DownUpPointBean(this.f30203g, this.f30204h, this.f30205i, this.f30206j, view.getMeasuredHeight(), view.getMeasuredWidth()), this.f30200d.t0());
            AthenaTracker.Y(this.f30200d.X);
            if (this.f30200d.l() != null) {
                this.f30200d.l().a();
            }
        } catch (Throwable th2) {
            z.a().e("ssp", Log.getStackTraceString(th2));
        }
    }

    public final void r(AdsDTO adsDTO) {
        z.a().d("SplashImage", "attachImgAd");
        if (this.f30197a == null) {
            this.f30197a = new ImageView(this.f30200d.N0());
        }
        ((ImageView) this.f30197a).setScaleType(ImageView.ScaleType.CENTER_CROP);
        DownLoadRequest.p(adsDTO.getAdImgUrl(), adsDTO, 2, new e(), (ImageView) this.f30197a);
    }

    public final void u(View view) {
        if (view == null) {
            return;
        }
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f30200d.X, view, this.f30211o);
        a aVar = null;
        view.setOnTouchListener(new i(this, aVar));
        view.setOnClickListener(new h(this, aVar));
    }

    public final void v(AdsDTO adsDTO) {
        z.a().d("SplashImage", "attachInteractiveAd");
        if (adsDTO == null) {
            return;
        }
        C(adsDTO);
        g(adsDTO, this.f30202f);
    }

    public final void y(AdsDTO adsDTO) {
        z.a().d("SplashImage", "fillVideoAd");
        if (this.f30198b == null) {
            this.f30198b = new SplashAdVideoView(this.f30200d.N0());
        }
        this.f30198b.setAdMediaPlayerListener(this.f30209m);
        String strA = w9.a.f79345a.a(this.f30200d.X);
        if (TextUtils.isEmpty(strA)) {
            u1 u1Var = this.f30200d;
            if (u1Var != null) {
                u1Var.L0();
                return;
            }
            return;
        }
        if (adsDTO.getSource() != 4) {
            DownLoadRequest.m(strA, adsDTO, true, new d(adsDTO));
            return;
        }
        if (!adsDTO.isFromLocal()) {
            strA = DiskLruCacheUtil.e(strA, 4);
        }
        this.f30198b.setMediaData(strA, adsDTO);
        u1 u1Var2 = this.f30200d;
        if (u1Var2 != null) {
            u1Var2.P0();
        }
    }

    public void z(AdsDTO adsDTO) {
        InteractiveWebView interactiveWebView;
        if (adsDTO == null) {
            return;
        }
        if (adsDTO.isVastTypeAd()) {
            SplashAdVideoView splashAdVideoView = this.f30198b;
            if (splashAdVideoView != null) {
                splashAdVideoView.play();
                return;
            }
            return;
        }
        if (!adsDTO.isInteractiveAd() || (interactiveWebView = this.f30202f) == null) {
            return;
        }
        interactiveWebView.evaluateJavascript("javascript:continuePlay()", new c());
    }
}
