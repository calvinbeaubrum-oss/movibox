package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.R$dimen;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.a0;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.b1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.TadmWebView;
import com.cloud.hisavana.sdk.common.widget.video.InterstitialAdVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.f0;
import com.cloud.hisavana.sdk.l1;
import com.cloud.sdk.commonutil.widget.TranCircleImageView;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TAdInterstitialActivity extends Activity {
    public boolean A;
    public com.cloud.hisavana.sdk.j C;
    public w9.l D;
    public x9.a E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TadmWebView f29276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranCircleImageView f29277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdChoicesView f29278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f29279d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f29280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f29281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f29282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f29283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InteractiveWebView f29284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f29285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f29286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InterstitialAdVideoView f29287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AdDisclaimerView f29288n;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f29299y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f29300z;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AdsDTO f29289o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f29290p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f29291q = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f29292r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f29293s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f29294t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f29295u = -1.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f29296v = -1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f29297w = -1.0f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f29298x = -1.0f;
    public final k B = new k(this);

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TextView f29301f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ImageView f29302g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j11, long j12, TextView textView, ImageView imageView) {
            super(j11, j12);
            this.f29301f = textView;
            this.f29302g = imageView;
        }

        @Override // x9.a
        public void e() {
            TAdInterstitialActivity.this.E.d();
            this.f29302g.setVisibility(0);
            this.f29301f.setVisibility(4);
        }

        @Override // x9.a
        public void f(long j11) {
            this.f29301f.setText(String.valueOf((int) Math.ceil(j11 / 1000.0f)));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends x9.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TextView f29304f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ View f29305g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ TextView f29306h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ View f29307i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j11, long j12, TextView textView, View view, TextView textView2, View view2) {
            super(j11, j12);
            this.f29304f = textView;
            this.f29305g = view;
            this.f29306h = textView2;
            this.f29307i = view2;
        }

        @Override // x9.a
        public void e() {
            TAdInterstitialActivity.this.E.d();
            this.f29305g.setEnabled(true);
            this.f29306h.setTextColor(Color.parseColor("#222222"));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f29306h.getLayoutParams();
            layoutParams.setMarginStart(0);
            this.f29306h.setLayoutParams(layoutParams);
            this.f29304f.setVisibility(8);
            this.f29307i.setVisibility(8);
            this.f29305g.requestLayout();
        }

        @Override // x9.a
        public void f(long j11) {
            this.f29304f.setText(String.valueOf((int) Math.ceil(j11 / 1000.0f)));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TAdInterstitialActivity.this.f29289o != null) {
                AthenaTracker.U(TAdInterstitialActivity.this.f29289o, 5);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            if (Build.VERSION.SDK_INT >= 23) {
                return;
            }
            AthenaTracker.U(TAdInterstitialActivity.this.f29289o, 4);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            AthenaTracker.U(TAdInterstitialActivity.this.f29289o, 4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends DrawableResponseListener {
        public d() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                TAdInterstitialActivity.this.p(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            }
            TAdInterstitialActivity.this.finish();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (TAdInterstitialActivity.this.f29277b == null) {
                return;
            }
            TAdInterstitialActivity.this.f29277b.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f29383a.j(view);
                }
            });
        }

        public final /* synthetic */ void j(View view) {
            TAdInterstitialActivity.this.s(view, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f29311b;

        public e(l lVar) {
            this.f29311b = lVar;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                TAdInterstitialActivity.this.p(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            }
            TAdInterstitialActivity.this.finish();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage == null || TextUtils.isEmpty(adImage.getFilePath())) {
                com.cloud.hisavana.sdk.z.a().e("InterActivity", "onRequestSuccess,video path is null");
                TAdInterstitialActivity.this.p(i11, "video path is null");
                TAdInterstitialActivity.this.finish();
            } else {
                TAdInterstitialActivity.this.K(adImage.getFilePath());
                l lVar = this.f29311b;
                if (lVar != null) {
                    lVar.a();
                }
                TAdInterstitialActivity.this.R();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends f0 {
        public f(AdsDTO adsDTO) {
            super(adsDTO);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void a() {
            if (!TAdInterstitialActivity.this.f29293s) {
                super.a();
            }
            TAdInterstitialActivity.this.f29293s = true;
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void b(long j11, long j12, int i11) {
            if (TAdInterstitialActivity.this.f29294t) {
                return;
            }
            super.b(j11, j12, i11);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onComplete() {
            if (!TAdInterstitialActivity.this.f29294t) {
                super.onComplete();
            }
            TAdInterstitialActivity.this.f29294t = true;
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onVolumeChanged(float f11) {
            super.onVolumeChanged(f11);
            if (TAdInterstitialActivity.this.f29286l == null) {
                return;
            }
            TAdInterstitialActivity.this.f29291q = f11;
            TAdInterstitialActivity.this.o(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends DrawableResponseListener {
        public g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            TAdInterstitialActivity.this.s(view, false);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                TAdInterstitialActivity.this.p(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            }
            TAdInterstitialActivity.this.finish();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null && adImage.isAdImageRecycled()) {
                TAdInterstitialActivity.this.p(i11, "bitmap is null");
                TAdInterstitialActivity.this.finish();
            } else if (TAdInterstitialActivity.this.f29277b != null) {
                TAdInterstitialActivity.this.f29277b.setOnTouchListener(new m(TAdInterstitialActivity.this, null));
                TAdInterstitialActivity.this.f29277b.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f29384a.j(view);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements l1 {
        public h() {
        }

        @Override // com.cloud.hisavana.sdk.l1
        public void a(@Nullable String str, int i11) {
            TAdInterstitialActivity.this.l0();
            AthenaTracker.c0(TAdInterstitialActivity.this.f29289o, str, i11);
        }

        @Override // com.cloud.hisavana.sdk.l1
        public int b(float f11, float f12, float f13, float f14) {
            TAdInterstitialActivity.this.f29295u = f11;
            TAdInterstitialActivity.this.f29296v = f12;
            TAdInterstitialActivity.this.f29297w = f13;
            TAdInterstitialActivity.this.f29298x = f14;
            TAdInterstitialActivity tAdInterstitialActivity = TAdInterstitialActivity.this;
            return tAdInterstitialActivity.E(tAdInterstitialActivity.f29276a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements w9.l.a {
        public i() {
        }

        @Override // w9.l.a
        public void a() {
        }

        @Override // w9.l.a
        public void b() {
        }

        @Override // w9.l.a
        public void c() {
            TAdInterstitialActivity.this.D.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements InteractiveWebView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<TAdInterstitialActivity> f29317a;

        public j(TAdInterstitialActivity tAdInterstitialActivity) {
            this.f29317a = new WeakReference<>(tAdInterstitialActivity);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void a(String str) {
            TAdInterstitialActivity tAdInterstitialActivity;
            WeakReference<TAdInterstitialActivity> weakReference = this.f29317a;
            if (weakReference == null || (tAdInterstitialActivity = weakReference.get()) == null) {
                return;
            }
            tAdInterstitialActivity.U(str);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void b() {
            TAdInterstitialActivity tAdInterstitialActivity;
            WeakReference<TAdInterstitialActivity> weakReference = this.f29317a;
            if (weakReference == null || (tAdInterstitialActivity = weakReference.get()) == null) {
                return;
            }
            tAdInterstitialActivity.h0();
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.b
        public void c() {
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "timeoutShutdown");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k extends com.cloud.hisavana.sdk.common.tranmeasure.a<AdsDTO> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<TAdInterstitialActivity> f29318a;

        public k(TAdInterstitialActivity tAdInterstitialActivity) {
            this.f29318a = new WeakReference<>(tAdInterstitialActivity);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            super.a(adsDTO);
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "view has impression     track = onAdShow");
            TAdInterstitialActivity tAdInterstitialActivity = this.f29318a.get();
            if (tAdInterstitialActivity == null) {
                return;
            }
            TAdInterstitialActivity.this.f29292r = true;
            tAdInterstitialActivity.A("_show", new Intent());
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return;
            }
            com.cloud.hisavana.sdk.x.h().k(adsDTO.getImpBeanRequest().pmid);
            if (adsDTO.getSource() == 4) {
                a0.f29085a.m(adsDTO.getAdCreativeId(), adsDTO.getCodeSeatId());
            } else if (adsDTO.isOfflineAd()) {
                adsDTO.setShowNum(Integer.valueOf(adsDTO.getShowNum().intValue() + 1));
                b1.c().s(adsDTO);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface l {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    public class m implements View.OnTouchListener {
        public m() {
        }

        public /* synthetic */ m(TAdInterstitialActivity tAdInterstitialActivity, a aVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                TAdInterstitialActivity.this.f29295u = motionEvent.getX();
                TAdInterstitialActivity.this.f29296v = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            TAdInterstitialActivity.this.f29297w = motionEvent.getX();
            TAdInterstitialActivity.this.f29298x = motionEvent.getY();
            return false;
        }
    }

    public final void A(String str, Intent intent) {
        if (intent == null) {
            try {
                intent = new Intent();
                intent.putExtra("mAdBean", this.f29289o);
            } catch (Throwable th2) {
                com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(th2));
                return;
            }
        }
        intent.setAction(this.f29290p + str);
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "sendBroadcast action: " + intent.getAction());
        sendBroadcast(intent);
    }

    public final void A0() {
        if (this.f29289o == null) {
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "TAdInterstitialActivity --> null == mAdBean |");
            q0();
            return;
        }
        this.f29285k = (ViewGroup) findViewById(R$id.main_layout);
        this.f29277b = (TranCircleImageView) findViewById(R$id.iv_main_image);
        v0();
        w0();
        z0();
    }

    public final void B0() {
        ImageView imageView = (ImageView) findViewById(R$id.im_volume);
        this.f29286l = imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
            o(this.f29291q);
        }
    }

    public final /* synthetic */ void C0() {
        this.f29288n.setDisplayStyle(this.f29289o.getDisplayRule(), w9.v.f(this.f29289o), w9.v.e(this.f29289o), this.f29285k.getMeasuredHeight());
    }

    public final boolean D(AdsDTO adsDTO, int i11) {
        if (adsDTO != null && adsDTO.getMaterialStyle() != null) {
            if (adsDTO.getMaterialStyle().equals("I91601")) {
                return true;
            }
            if (i11 == 2 && adsDTO.getMaterialStyle().equals("I16901")) {
                return true;
            }
        }
        return false;
    }

    public final void D0() {
        AdsDTO adsDTO;
        l lVar;
        AdsDTO adsDTO2 = this.f29289o;
        if (adsDTO2 == null) {
            l0();
            return;
        }
        if (!TextUtils.isEmpty(adsDTO2.getAdm())) {
            Y();
        } else {
            if (!this.f29289o.isInteractiveAd()) {
                if (this.f29289o.isVastTypeAd()) {
                    adsDTO = this.f29289o;
                    lVar = new l() { // from class: com.cloud.hisavana.sdk.common.activity.o
                        @Override // com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity.l
                        public final void a() {
                            this.f29372a.E0();
                        }
                    };
                } else if (this.f29289o.getSource() != 4) {
                    T(this.f29289o);
                } else if (this.f29289o.getDefaultMaterialType() == 1) {
                    J(this.f29289o);
                } else {
                    adsDTO = this.f29289o;
                    lVar = new l() { // from class: com.cloud.hisavana.sdk.common.activity.o
                        @Override // com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity.l
                        public final void a() {
                            this.f29372a.E0();
                        }
                    };
                }
                y(adsDTO, lVar);
                return;
            }
            a0(this.f29289o);
        }
        E0();
    }

    public final int E(@NonNull View view) {
        DownUpPointBean downUpPointBean = new DownUpPointBean(this.f29295u, this.f29296v, this.f29297w, this.f29298x, view.getMeasuredHeight(), view.getMeasuredWidth());
        A("_click", null);
        return e1.a(getApplicationContext(), this.f29289o, downUpPointBean, false);
    }

    public final void E0() {
        ViewGroup viewGroup;
        final View childAt;
        if (this.f29289o == null || this.f29292r || (viewGroup = this.f29285k) == null || viewGroup.getChildCount() <= 0 || (childAt = this.f29285k.getChildAt(0)) == null) {
            return;
        }
        childAt.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f29381a.o0(childAt);
            }
        });
    }

    public final void F0() {
        try {
            if (getIntent() != null) {
                this.f29290p = getIntent().getStringExtra("BroadCastPrefix");
                this.f29289o = (AdsDTO) getIntent().getParcelableExtra("mAdBean");
            }
            AdsDTO adsDTO = this.f29289o;
            if (adsDTO != null && adsDTO.getMaterialStyle() != null) {
                int iB = w9.a.f79345a.b(this.f29289o);
                this.f29300z = iB;
                if (iB != -1) {
                    t0();
                    return;
                }
                com.cloud.hisavana.sdk.z.a().d("InterActivity", "TAdInterstitialActivity --> adMediaType == INVALID_TYPE");
                p(TaErrorCode.CODE_INVALID_TYPE, TaErrorCode.ERROR_INVALID_TYPE.getErrorMessage());
                finish();
                return;
            }
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "TAdInterstitialActivity --> null == mAdBean || null == mAdBean.materialStyle");
            p(TaErrorCode.CODE_INTERSTITIAL_MISS_ELEMENT, TaErrorCode.ERROR_INTERSTITIAL_MISS_ELEMENT.getErrorMessage());
            finish();
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().e("InterActivity", "start " + Log.getStackTraceString(e11));
        }
    }

    public final void G(View view, int i11) {
        TextView textView = (TextView) view.findViewById(R$id.close_view);
        TextView textView2 = (TextView) view.findViewById(R$id.count_down_view);
        View viewFindViewById = view.findViewById(R$id.separator);
        if (textView == null || textView2 == null || viewFindViewById == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f29377a.Z(view2);
            }
        });
        if (i11 > 0) {
            x9.a aVar = this.E;
            if (aVar != null) {
                aVar.d();
            }
            view.setEnabled(false);
            b bVar = new b(1000 * ((long) i11), 1000L, textView2, view, textView, viewFindViewById);
            this.E = bVar;
            bVar.g();
            return;
        }
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "current close delay time is 0, do not count down.");
        view.setEnabled(true);
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.setMarginStart(0);
        textView.setLayoutParams(layoutParams);
        textView2.setVisibility(8);
        viewFindViewById.setVisibility(8);
        view.requestLayout();
    }

    public final void J(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        DownLoadRequest.o(adsDTO.getAdImgUrl(), adsDTO, new d(), this.f29277b);
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "use image to show ad is:= " + this.f29289o.getAdImgUrl());
    }

    public final void K(String str) {
        AdsDTO adsDTO;
        InterstitialAdVideoView interstitialAdVideoView;
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "setMediaData ");
        q(this.f29287m);
        if (this.f29294t && (interstitialAdVideoView = this.f29287m) != null) {
            interstitialAdVideoView.seekToPosition(interstitialAdVideoView.getDuration());
        }
        if (this.f29293s) {
            return;
        }
        if (this.f29287m != null && !TextUtils.isEmpty(str)) {
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "setMediaData filePath " + str);
            this.f29287m.setMediaData(str, this.f29289o, this.f29291q == 0.0f);
            this.f29287m.setOnTouchListener(new m(this, null));
            this.f29287m.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f29380a.r0(view);
                }
            });
        }
        if (this.f29287m == null || (adsDTO = this.f29289o) == null || adsDTO.getVideoInfo() == null || this.f29289o.getVideoInfo().getVideoMask() == null) {
            return;
        }
        this.f29287m.setCompanionSize(this.f29289o.getVideoInfo().getVideoMask().getResource());
    }

    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final void B(String str, String str2, String str3) {
        if (this.D == null) {
            w9.l lVar = new w9.l(this, new i());
            this.D = lVar;
            lVar.k(str);
            this.D.h(str2);
            this.D.g(str3);
            this.D.j(true);
        }
        try {
            this.D.show();
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().e("InterActivity", "showRuDialog error: " + e11.getMessage());
        }
    }

    public final boolean M() {
        int i11;
        int i12;
        f0(this.f29289o);
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "*----> TAdInterstitialActivity --> 当前样式为=" + this.f29289o.getMaterialStyle());
        if (TextUtils.isEmpty(this.f29289o.getAdm())) {
            String materialStyle = this.f29289o.getMaterialStyle();
            materialStyle.hashCode();
            switch (materialStyle) {
                case "FA14":
                    i11 = R$layout.activity_t_ad_interstitial_1104_1105_layout;
                    break;
                case "I1101":
                    i11 = R$layout.activity_t_ad_interstitial_1101_layout;
                    break;
                case "I1102":
                    i11 = R$layout.activity_t_ad_interstitial_1102_layout;
                    break;
                case "I1103":
                    i11 = R$layout.activity_t_ad_interstitial_1103_layout;
                    break;
                case "I1106":
                    i11 = R$layout.activity_t_ad_interstitial_1106_layout;
                    break;
                case "I1107":
                    i11 = R$layout.activity_t_ad_interstitial_1107_layout;
                    break;
                case "I16901":
                    i11 = R$layout.activity_t_ad_interstitial_16901_layout;
                    break;
                case "I91601":
                    i11 = R$layout.activity_t_ad_interstitial_91601_layout;
                    break;
                default:
                    finish();
                    com.cloud.hisavana.sdk.z.a().d("InterActivity", "TAdTemplateActivity --> 没有匹配到 materialStyle --> 配置错误 materialStyle=" + this.f29289o.getMaterialStyle());
                    return true;
            }
        } else {
            i11 = R$layout.activity_t_ad_interstitial_adm_layout;
        }
        setContentView(i11);
        try {
            i12 = getResources().getConfiguration().orientation;
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().w("InterActivity", "*----> TAdInterstitialActivity --> get screen orientation error:" + e11.getMessage());
            i12 = 0;
        }
        if (D(this.f29289o, i12)) {
            Window window = getWindow();
            if (window != null) {
                if (Build.VERSION.SDK_INT >= 28 && window.getAttributes() != null) {
                    window.getAttributes().layoutInDisplayCutoutMode = 1;
                }
                WindowCompat.setDecorFitsSystemWindows(window, false);
                WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
                windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
                windowInsetsControllerCompat.setSystemBarsBehavior(2);
            }
        } else {
            n();
        }
        return false;
    }

    public final int P(View view, int i11) {
        return (view == null || view.getLayoutParams() == null || view.getLayoutParams().height <= 0) ? i11 : view.getLayoutParams().height;
    }

    public final void R() {
        AdsDTO adsDTO = this.f29289o;
        if (adsDTO == null || adsDTO.getDisplayRule() != Constants.AdDisplayRule.RU || this.f29285k == null) {
            return;
        }
        if (this.f29288n == null) {
            AdDisclaimerView adDisclaimerView = new AdDisclaimerView(this);
            this.f29288n = adDisclaimerView;
            adDisclaimerView.setListener(new AdDisclaimerView.b() { // from class: com.cloud.hisavana.sdk.common.activity.u
                @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
                public final void a(String str, String str2, String str3) {
                    this.f29378a.B(str, str2, str3);
                }
            });
        }
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, getResources().getDimensionPixelOffset(R$dimen.ad_disclaimer_height));
        bVar.f7315t = this.f29285k.getId();
        bVar.f7319v = this.f29285k.getId();
        bVar.f7299l = this.f29285k.getId();
        if (this.f29288n.getParent() != null) {
            ((ViewGroup) this.f29288n.getParent()).removeView(this.f29288n);
        }
        this.f29285k.addView(this.f29288n, bVar);
        this.f29285k.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f29379a.C0();
            }
        });
        d0();
    }

    public final /* synthetic */ void S(View view) {
        s(view, true);
        finish();
    }

    public final void T(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        DownLoadRequest.p(adsDTO.getAdImgUrl(), adsDTO, 2, new g(), this.f29277b);
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "use image to show ad is:= " + this.f29289o.getAdImgUrl());
    }

    public final void U(String str) {
        AdsDTO adsDTO = this.f29289o;
        if (adsDTO != null) {
            AthenaTracker.z(adsDTO, str);
        }
    }

    public final void Y() {
        AdsDTO adsDTO = this.f29289o;
        if (adsDTO == null) {
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "attachAdmView adBean is null");
            q0();
            return;
        }
        String scale = adsDTO.getScale();
        if (TextUtils.isEmpty(scale)) {
            scale = (this.f29289o.getScales() == null || this.f29289o.getScales().isEmpty()) ? "" : this.f29289o.getScales().get(0);
        }
        if (TextUtils.isEmpty(scale)) {
            com.cloud.hisavana.sdk.z.a().e("InterActivity", "attachAdmView scale is empty,finish");
            q0();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f29285k.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).I = scale;
        }
        String str = this.f29289o.getAdm() + TadmWebView.JS_TEXT;
        if (this.f29276a == null) {
            try {
                this.f29276a = new TadmWebView(getApplicationContext());
            } catch (Throwable th2) {
                com.cloud.hisavana.sdk.z.a().e("InterActivity", "create webview error: " + Log.getStackTraceString(th2));
                this.f29276a = null;
                q0();
                return;
            }
        }
        z(str);
        q(this.f29276a);
    }

    public final /* synthetic */ void Z(View view) {
        s(view, true);
        finish();
    }

    public final void a0(AdsDTO adsDTO) {
        InteractiveWebView interactiveWebView;
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getIndexLocation())) {
            return;
        }
        x0();
        if (!new File(adsDTO.getIndexLocation()).exists() || (interactiveWebView = this.f29284j) == null) {
            p(3005, "interactive file not exists ");
            AthenaTracker.U(this.f29289o, 3);
            finish();
        } else {
            interactiveWebView.setVisibility(0);
            this.f29284j.loadUrl("file://" + adsDTO.getIndexLocation());
        }
    }

    public final void d0() {
        View viewFindViewById = findViewById(R$id.ad_flag);
        if (viewFindViewById != null) {
            viewFindViewById.bringToFront();
        }
    }

    public final /* synthetic */ void e0(View view) {
        s(view, false);
    }

    public final void f0(AdsDTO adsDTO) {
        int i11;
        int i12;
        if (adsDTO == null) {
            return;
        }
        try {
            i11 = getResources().getConfiguration().orientation;
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().w("InterActivity", "*----> TAdInterstitialActivity --> get screen orientation error:" + e11.getMessage());
            i11 = 0;
        }
        if (D(adsDTO, i11)) {
            i12 = R$style.InterstitialFullscreenStyle;
        } else {
            i12 = i11 == 2 ? R$style.AppCompatTranscutes : R$style.InterstitialStyle;
        }
        setTheme(i12);
    }

    public final void h0() {
        InteractiveWebView interactiveWebView = this.f29284j;
        if (interactiveWebView != null) {
            s(interactiveWebView, false);
        }
    }

    public final /* synthetic */ void i0(View view) {
        s(view, false);
    }

    public void l0() {
        A("_close", null);
        if (isFinishing()) {
            return;
        }
        q0();
    }

    public final /* synthetic */ void m0(View view) {
        e1.g(getApplicationContext(), this.f29289o);
    }

    public final void n() {
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
    }

    public final void n0() {
        AdsDTO adsDTO = this.f29289o;
        if (adsDTO == null) {
            return;
        }
        if (adsDTO.getSource() == 4) {
            DownLoadRequest.o(this.f29289o.getAdChoiceImageUrl(), this.f29289o, null, this.f29278c);
        } else {
            DownLoadRequest.p(this.f29289o.getAdChoiceImageUrl(), this.f29289o, 3, null, this.f29278c);
        }
        if (this.f29279d == null || this.f29289o.getNativeObject() == null) {
            return;
        }
        if (this.f29289o.getSource() == 4) {
            DownLoadRequest.o(this.f29289o.getLogoUrl(), this.f29289o, null, this.f29279d);
        } else {
            DownLoadRequest.p(this.f29289o.getNativeObject().getLogoUrl(), this.f29289o, 1, null, this.f29279d);
        }
        if (this.f29289o.isVastTypeAd()) {
            this.f29279d.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f29376a.e0(view);
                }
            });
        }
    }

    public final void o(float f11) {
        this.f29286l.setImageResource(f11 == 0.0f ? R$drawable.hisavana_volume_close : R$drawable.hisavana_volume_open);
    }

    public final /* synthetic */ void o0(View view) {
        AthenaTracker.B(this.f29289o);
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f29289o, view, this.B);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "sendBroadcast(TAG_CLOSE);");
        AdsDTO adsDTO = this.f29289o;
        if (adsDTO == null || !adsDTO.isVastTypeAd()) {
            A("_close", null);
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t0();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        setTitle((CharSequence) null);
        if (AdManager.f() == 1) {
            setRequestedOrientation(1);
        } else if (AdManager.f() == 0) {
            setRequestedOrientation(0);
        }
        try {
            if (getIntent() != null) {
                f0((AdsDTO) getIntent().getParcelableExtra("mAdBean"));
            }
        } catch (Exception unused) {
        }
        super.onCreate(bundle);
        if (com.cloud.sdk.commonutil.util.f.g()) {
            this.f29291q = AdManager.j() ? 0.0f : 1.0f;
            F0();
            this.A = true;
        } else {
            com.cloud.sdk.commonutil.util.f.f(getApplicationContext());
            p(TaErrorCode.CODE_INIT_ERROR, TaErrorCode.ERROR_INIT_ERROR.getErrorMessage());
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        A("_close", null);
        A("_destroy", null);
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.f29289o);
        com.cloud.sdk.commonutil.util.l.a(this.f29277b);
        com.cloud.sdk.commonutil.util.l.a(this.f29279d);
        com.cloud.sdk.commonutil.util.l.a(this.f29278c);
        ViewGroup viewGroup = this.f29280f;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f29280f = null;
        }
        ViewGroup viewGroup2 = this.f29285k;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            this.f29285k = null;
        }
        TadmWebView tadmWebView = this.f29276a;
        if (tadmWebView != null) {
            tadmWebView.destroy();
            this.f29276a = null;
        }
        com.cloud.hisavana.sdk.j jVar = this.C;
        if (jVar != null) {
            jVar.h();
            this.C = null;
        }
        InteractiveWebView interactiveWebView = this.f29284j;
        if (interactiveWebView != null) {
            interactiveWebView.destroy();
            this.f29284j = null;
        }
        InterstitialAdVideoView interstitialAdVideoView = this.f29287m;
        if (interstitialAdVideoView != null) {
            interstitialAdVideoView.release();
            this.f29287m = null;
        }
        if (this.f29288n != null) {
            this.f29288n = null;
        }
        w9.l lVar = this.D;
        if (lVar != null) {
            lVar.dismiss();
            this.D = null;
        }
        x9.a aVar = this.E;
        if (aVar != null) {
            aVar.d();
            this.E = null;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "onNewIntent ----------------------->");
        if (this.A) {
            setIntent(intent);
            F0();
        }
    }

    public final void p(int i11, String str) {
        Intent intent = new Intent();
        intent.putExtra("error_msg", str);
        intent.putExtra(TrackingKey.ERROR_CODE, i11);
        A("_error", intent);
    }

    public final void q(View view) {
        if (this.f29285k == null || view == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f29285k.removeAllViews();
        this.f29285k.addView(view, new ConstraintLayout.b(-1, -1));
    }

    public final void q0() {
        finish();
    }

    public final void r(View view, int i11) {
        ImageView imageView = (ImageView) view.findViewById(R$id.close_view);
        TextView textView = (TextView) view.findViewById(R$id.count_down_view);
        if (imageView == null || textView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f29375a.S(view2);
            }
        });
        if (i11 <= 0) {
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "current close delay time is 0, do not count down.");
            imageView.setVisibility(0);
            textView.setVisibility(8);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setCornerRadius(P(view, com.cloud.sdk.commonutil.util.j.a(24.0f)) * 0.5f);
        textView.setBackground(gradientDrawable);
        imageView.setVisibility(4);
        textView.setVisibility(0);
        x9.a aVar = this.E;
        if (aVar != null) {
            aVar.d();
        }
        a aVar2 = new a(((long) i11) * 1000, 1000L, textView, imageView);
        this.E = aVar2;
        aVar2.g();
    }

    public final /* synthetic */ void r0(View view) {
        s(view, false);
    }

    public final void s(View view, boolean z11) {
        try {
            com.cloud.hisavana.sdk.z.a().d("InterActivity", "asyncAction");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f29299y > 1000) {
                if (z11) {
                    A("_close", null);
                    if (!isFinishing()) {
                        q0();
                    }
                } else {
                    E(view);
                }
                this.f29299y = jCurrentTimeMillis;
            }
        } catch (Throwable th2) {
            com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(th2));
        }
    }

    public final void t0() {
        if (M()) {
            return;
        }
        A0();
        D0();
        n0();
        R();
        d0();
    }

    public final void v0() {
        TextView textView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.llRoot);
        this.f29280f = viewGroup;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f29374a.i0(view);
                }
            });
        }
        this.f29279d = (ImageView) findViewById(R$id.ivIcon);
        this.f29281g = (TextView) findViewById(R$id.tvName);
        this.f29282h = (TextView) findViewById(R$id.tvDescription);
        this.f29283i = (TextView) findViewById(R$id.tvBtn);
        AdsDTO adsDTO = this.f29289o;
        if (adsDTO == null || adsDTO.getNativeObject() == null || TextUtils.isEmpty(this.f29289o.getMaterialStyle()) || !TextUtils.isEmpty(this.f29289o.getAdm())) {
            return;
        }
        String materialStyle = this.f29289o.getMaterialStyle();
        materialStyle.hashCode();
        switch (materialStyle) {
            case "FA14":
            case "I1106":
                this.f29281g.setText(this.f29289o.getNativeObject().getTitleTxt());
                this.f29282h.setText(this.f29289o.getNativeObject().getDescriptionTxt());
                this.f29283i.setText(this.f29289o.getNativeObject().getButtonTxt(this.f29289o.getInstallApk()));
                textView = this.f29282h;
                break;
            case "I1101":
            case "I1103":
            case "I16901":
            case "I91601":
                this.f29281g.setText(this.f29289o.getNativeObject().getTitleTxt());
                this.f29282h.setText(this.f29289o.getNativeObject().getDescriptionTxt());
                this.f29283i.setText(this.f29289o.getNativeObject().getButtonTxt(this.f29289o.getInstallApk()));
                TextPaint paint = this.f29281g.getPaint();
                paint.setStrokeWidth(2.0f);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.f29277b == null || !this.f29289o.getMaterialStyle().equals("I91601") || TextUtils.isEmpty(this.f29289o.getScale()) || !this.f29289o.getScale().equals("9:16")) {
                    return;
                }
                this.f29277b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return;
            case "I1102":
                this.f29281g.setText(this.f29289o.getNativeObject().getTitleTxt());
                this.f29283i.setText(this.f29289o.getNativeObject().getButtonTxt(this.f29289o.getInstallApk()));
                textView = this.f29281g;
                break;
            default:
                return;
        }
        TextPaint paint2 = textView.getPaint();
        paint2.setStrokeWidth(2.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public final void w0() {
        AdsDTO adsDTO;
        View viewFindViewById = findViewById(R$id.ivCancel);
        if (viewFindViewById == null || (adsDTO = this.f29289o) == null) {
            return;
        }
        int closeDelayTime = (!adsDTO.isVastTypeAd() || this.f29289o.getVideoInfo() == null || this.f29289o.getVideoInfo().getDuration() == null || this.f29289o.getVideoInfo().getDuration().intValue() <= 0) ? this.f29289o.getCloseDelayTime() : Math.min(this.f29289o.getCloseDelayTime(), this.f29289o.getVideoInfo().getDuration().intValue());
        com.cloud.hisavana.sdk.z.a().d("InterActivity", "current close delay time is: " + closeDelayTime);
        if (viewFindViewById.getTag() == null || !viewFindViewById.getTag().equals("close_button")) {
            r(viewFindViewById, closeDelayTime);
        } else {
            G(viewFindViewById, closeDelayTime);
        }
    }

    public final void x(AdsDTO adsDTO) {
        if ((this.f29300z == 1 || adsDTO.getDefaultMaterialType() == 2) && this.f29287m == null) {
            InterstitialAdVideoView interstitialAdVideoView = new InterstitialAdVideoView(getApplicationContext());
            this.f29287m = interstitialAdVideoView;
            interstitialAdVideoView.setAutoReset(true);
            this.f29287m.setAdMediaPlayerListener(new f(adsDTO));
        }
    }

    public final void x0() {
        if (this.f29289o.isInteractiveAd()) {
            if (this.f29284j == null) {
                try {
                    this.f29284j = new InteractiveWebView(getApplicationContext());
                } catch (Throwable th2) {
                    com.cloud.hisavana.sdk.z.a().e("InterActivity", "create webview error: " + Log.getStackTraceString(th2));
                    this.f29284j = null;
                }
            }
            if (this.f29285k == null || this.f29284j == null) {
                l0();
            } else {
                y0();
                q(this.f29284j);
            }
        }
    }

    public final void y(AdsDTO adsDTO, l lVar) {
        String strA = w9.a.f79345a.a(adsDTO);
        if (strA == null || TextUtils.isEmpty(strA)) {
            TaErrorCode taErrorCode = TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR;
            p(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            finish();
            return;
        }
        B0();
        x(adsDTO);
        this.f29287m.setVolumeView(this.f29286l);
        if (adsDTO.getSource() != 4) {
            DownLoadRequest.m(strA, adsDTO, true, new e(lVar));
            return;
        }
        if (!adsDTO.isFromLocal()) {
            strA = DiskLruCacheUtil.e(strA, 4);
        }
        K(strA);
        if (lVar != null) {
            lVar.a();
        }
    }

    public final void y0() {
        this.f29284j.setWebViewClient(new c());
        this.f29284j.setOnTouchListener(new m(this, null));
        this.f29284j.setmListener(new j(this));
    }

    public final void z(String str) {
        if (this.C == null) {
            this.C = new com.cloud.hisavana.sdk.j();
        }
        this.C.d(this.f29276a, this.f29289o, new h());
        this.f29276a.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
    }

    public final void z0() {
        AdChoicesView adChoicesView = (AdChoicesView) findViewById(R$id.ad_choices_view);
        this.f29278c = adChoicesView;
        if (adChoicesView != null) {
            adChoicesView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f29373a.m0(view);
                }
            });
        }
        AdBadgeView adBadgeView = (AdBadgeView) findViewById(R$id.ad_badge_view);
        if (adBadgeView != null) {
            adBadgeView.setDisplayStyle(this.f29289o.getDisplayRule(), w9.v.c(this.f29289o));
        }
        AdCloseView adCloseView = (AdCloseView) findViewById(R$id.ad_close_view);
        if (adCloseView != null) {
            adCloseView.setDisplayStyle(this.f29289o.getDisplayRule(), AdCloseView.CloseImageType.EXPAND);
            com.cloud.hisavana.sdk.h.p().f(this, adCloseView, this, this.f29289o);
        }
        boolean zA = w9.x.a(this.f29289o);
        StoreMarkView storeMarkView = (StoreMarkView) findViewById(R$id.ps_mark_view);
        if (storeMarkView != null) {
            storeMarkView.setVisibility(zA ? 0 : 4);
            storeMarkView.setTextSize(6.0f);
            storeMarkView.setTextColor(-8882056);
            storeMarkView.attachInfo(this.f29289o);
        }
    }
}
