package com.cloud.hisavana.sdk.common.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.a0;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.b1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.RewardedState;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.HSChronometer;
import com.cloud.hisavana.sdk.common.widget.video.RewardedVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.f0;
import com.cloud.hisavana.sdk.y0;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class HisavanaRewardedActivity extends Activity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdsDTO f29219d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f29221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f29223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f29224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HSChronometer f29225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RewardedVideoView f29226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f29227m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f29228n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f29229o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public w9.l f29230p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public w9.l f29231q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f29232r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f29233s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f29234t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f29235u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f29237w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29216a = "Rewarded";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29217b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f29218c = ((long) 5) * 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f29220f = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RewardedState f29236v = new RewardedState(0, 0.0f, false, false, false, false, false, false, false, 511, null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends com.cloud.hisavana.sdk.common.tranmeasure.a<AdsDTO> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<HisavanaRewardedActivity> f29238a;

        public a(HisavanaRewardedActivity hisavanaRewardedActivity) {
            this.f29238a = new WeakReference<>(hisavanaRewardedActivity);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            super.a(adsDTO);
            if (this.f29238a.get() != null) {
                HisavanaRewardedActivity.this.a0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f29240a = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f29241b = -1.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f29242c = -1.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f29243d = -1.0f;

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v11, MotionEvent event) {
            Intrinsics.g(v11, "v");
            Intrinsics.g(event, "event");
            int action = event.getAction();
            if (action == 0) {
                this.f29240a = event.getX();
                this.f29241b = event.getY();
            } else if (action == 1) {
                this.f29242c = event.getX();
                float y11 = event.getY();
                this.f29243d = y11;
                if (Math.hypot(this.f29242c - this.f29240a, y11 - this.f29241b) < 50.0d) {
                    v11.performClick();
                    HisavanaRewardedActivity.this.z(false, new DownUpPointBean(this.f29240a, this.f29241b, this.f29242c, this.f29243d, v11.getMeasuredWidth(), v11.getMeasuredHeight()));
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends f0 {
        public c(AdsDTO adsDTO) {
            super(adsDTO);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void a() {
            if (!HisavanaRewardedActivity.this.f29236v.isPlayStart()) {
                super.a();
            }
            HisavanaRewardedActivity.this.f29236v.setPlayStart(true);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onComplete() {
            if (!HisavanaRewardedActivity.this.f29236v.isPlayComplete()) {
                super.onComplete();
            }
            HisavanaRewardedActivity.this.f29236v.setPlayComplete(true);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onVolumeChanged(float f11) {
            super.onVolumeChanged(f11);
            HisavanaRewardedActivity.this.f29236v.setVideoVolume(f11);
            HisavanaRewardedActivity.this.i(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends DrawableResponseListener {
        public d() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                HisavanaRewardedActivity.this.u(taErrorCode);
            }
            HisavanaRewardedActivity.this.y(false);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null && adImage.isAdImageRecycled()) {
                HisavanaRewardedActivity.this.u(new TaErrorCode(i11, "bitmap is null"));
                HisavanaRewardedActivity.this.y(false);
                return;
            }
            ImageView imageView = HisavanaRewardedActivity.this.f29227m;
            if ((imageView != null ? imageView.getParent() : null) != null) {
                ImageView imageView2 = HisavanaRewardedActivity.this.f29227m;
                ViewParent parent = imageView2 != null ? imageView2.getParent() : null;
                Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(HisavanaRewardedActivity.this.f29227m);
            }
            FrameLayout frameLayout = HisavanaRewardedActivity.this.f29223i;
            if (frameLayout != null) {
                frameLayout.addView(HisavanaRewardedActivity.this.f29227m);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends Lambda implements Function0<Unit> {
        public e() {
            super(0);
        }

        public final void a() {
            HisavanaRewardedActivity.this.u(TaErrorCode.NO_MAIN_IMG_DATA_ERROR);
            HisavanaRewardedActivity.this.y(false);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends DrawableResponseListener {
        public f() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                HisavanaRewardedActivity.this.u(taErrorCode);
            }
            HisavanaRewardedActivity.this.y(false);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage == null || TextUtils.isEmpty(adImage.getFilePath())) {
                com.cloud.hisavana.sdk.z.a().w(HisavanaRewardedActivity.this.f29216a, "onRequestSuccess,video path is null");
                HisavanaRewardedActivity.this.u(new TaErrorCode(i11, "video path is null"));
                HisavanaRewardedActivity.this.y(false);
                return;
            }
            HisavanaRewardedActivity.this.t(adImage);
            RewardedVideoView rewardedVideoView = HisavanaRewardedActivity.this.f29226l;
            if ((rewardedVideoView != null ? rewardedVideoView.getParent() : null) != null) {
                RewardedVideoView rewardedVideoView2 = HisavanaRewardedActivity.this.f29226l;
                ViewParent parent = rewardedVideoView2 != null ? rewardedVideoView2.getParent() : null;
                Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(HisavanaRewardedActivity.this.f29226l);
            }
            FrameLayout frameLayout = HisavanaRewardedActivity.this.f29223i;
            if (frameLayout != null) {
                frameLayout.addView(HisavanaRewardedActivity.this.f29226l);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g extends Lambda implements Function0<Unit> {
        public g() {
            super(0);
        }

        public final void a() {
            HisavanaRewardedActivity hisavanaRewardedActivity = HisavanaRewardedActivity.this;
            TaErrorCode taErrorCode = TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR;
            hisavanaRewardedActivity.u(new TaErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
            HisavanaRewardedActivity.this.y(false);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h implements w9.l.a {
        public h() {
        }

        @Override // w9.l.a
        public void a() {
            HSChronometer hSChronometer = HisavanaRewardedActivity.this.f29225k;
            if (hSChronometer != null) {
                hSChronometer.stop();
            }
            w9.l lVar = HisavanaRewardedActivity.this.f29230p;
            if (lVar != null) {
                lVar.dismiss();
            }
            HisavanaRewardedActivity.this.f29236v.setShowRetainDialog(false);
            HisavanaRewardedActivity.this.z(true, null);
        }

        @Override // w9.l.a
        public void b() {
            RewardedVideoView rewardedVideoView;
            w9.l lVar = HisavanaRewardedActivity.this.f29230p;
            if (lVar != null) {
                lVar.dismiss();
            }
            HSChronometer hSChronometer = HisavanaRewardedActivity.this.f29225k;
            if (hSChronometer != null) {
                hSChronometer.resumeCountdown(HisavanaRewardedActivity.this.f29236v.getCountdownRemainDuration());
            }
            if (!HisavanaRewardedActivity.this.f29236v.isPlayComplete() && (rewardedVideoView = HisavanaRewardedActivity.this.f29226l) != null) {
                rewardedVideoView.resume();
            }
            HisavanaRewardedActivity.this.f29236v.setShowRetainDialog(false);
        }

        @Override // w9.l.a
        public void c() {
            w9.l.a.C0885a.a(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i implements w9.l.a {
        public i() {
        }

        @Override // w9.l.a
        public void a() {
            w9.l.a.C0885a.b(this);
        }

        @Override // w9.l.a
        public void b() {
            w9.l.a.C0885a.c(this);
        }

        @Override // w9.l.a
        public void c() {
            RewardedVideoView rewardedVideoView;
            w9.l lVar = HisavanaRewardedActivity.this.f29231q;
            if (lVar != null) {
                lVar.dismiss();
            }
            HSChronometer hSChronometer = HisavanaRewardedActivity.this.f29225k;
            if (hSChronometer != null) {
                hSChronometer.resumeCountdown(HisavanaRewardedActivity.this.f29236v.getCountdownRemainDuration());
            }
            if (!HisavanaRewardedActivity.this.f29236v.isPlayComplete() && (rewardedVideoView = HisavanaRewardedActivity.this.f29226l) != null) {
                rewardedVideoView.resume();
            }
            HisavanaRewardedActivity.this.f29236v.setShowRuDialog(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j implements HSChronometer.a {
        public j() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onFinish() {
            HisavanaRewardedActivity.this.b0();
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onTick(long j11) {
            HisavanaRewardedActivity.this.j(j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class k implements HSChronometer.a {
        public k() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onFinish() {
            HisavanaRewardedActivity.this.b0();
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onTick(long j11) {
            HisavanaRewardedActivity.this.j(j11);
        }
    }

    public static final void D(HisavanaRewardedActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        e1.g(com.cloud.sdk.commonutil.util.f.a(), this$0.f29219d);
    }

    public static final void G(HisavanaRewardedActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        HSChronometer hSChronometer = this$0.f29225k;
        if ((hSChronometer != null && hSChronometer.isTimeUp()) || this$0.f29236v.isRewarded()) {
            this$0.y(true);
            return;
        }
        RewardedState rewardedState = this$0.f29236v;
        HSChronometer hSChronometer2 = this$0.f29225k;
        rewardedState.setCountdownRemainDuration(hSChronometer2 != null ? hSChronometer2.pauseCountdown() : 0L);
        RewardedVideoView rewardedVideoView = this$0.f29226l;
        if (rewardedVideoView != null) {
            rewardedVideoView.pause();
        }
        this$0.c0();
    }

    public static final void J(HisavanaRewardedActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        RewardedVideoView rewardedVideoView = this$0.f29226l;
        if (rewardedVideoView != null) {
            rewardedVideoView.toggleVolume();
        }
    }

    public static final void k(ConstraintLayout container, AdDisclaimerView adDisclaimerView, AdsDTO bean) {
        Intrinsics.g(container, "$container");
        Intrinsics.g(bean, "$bean");
        int measuredHeight = container.getMeasuredHeight();
        if (adDisclaimerView != null) {
            adDisclaimerView.setDisplayStyle(bean.getDisplayRule(), w9.v.f(bean), w9.v.e(bean), measuredHeight);
        }
        adDisclaimerView.setVisibility(0);
    }

    public static final void n(HisavanaRewardedActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.z(false, null);
    }

    public static final void q(HisavanaRewardedActivity this$0, String title, String message, String buttonText) {
        Intrinsics.g(this$0, "this$0");
        HSChronometer hSChronometer = this$0.f29225k;
        if ((hSChronometer == null || !hSChronometer.isTimeUp()) && !this$0.f29236v.isRewarded()) {
            RewardedState rewardedState = this$0.f29236v;
            HSChronometer hSChronometer2 = this$0.f29225k;
            rewardedState.setCountdownRemainDuration(hSChronometer2 != null ? hSChronometer2.pauseCountdown() : 0L);
            RewardedVideoView rewardedVideoView = this$0.f29226l;
            if (rewardedVideoView != null) {
                rewardedVideoView.pause();
            }
        }
        Intrinsics.f(title, "title");
        Intrinsics.f(message, "message");
        Intrinsics.f(buttonText, "buttonText");
        this$0.x(title, message, buttonText);
    }

    public final void B() {
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
    }

    public final void C(long j11) {
        if (com.cloud.hisavana.sdk.z.b()) {
            com.cloud.hisavana.sdk.z.a().i(this.f29216a, "-----------> startCountdown " + this.f29236v);
        }
        HSChronometer hSChronometer = this.f29225k;
        if (hSChronometer != null) {
            hSChronometer.setTickStringFormat(hSChronometer.getResources().getString(R$string.reward_before_tip));
            hSChronometer.setFinishedString(hSChronometer.getResources().getString(R$string.reward_after_tip));
        }
        if (this.f29236v.isShowRetainDialog()) {
            c0();
        }
        if (this.f29236v.isShowRuDialog()) {
            String string = getResources().getString(R$string.disclaimer);
            Intrinsics.f(string, "resources.getString(R.string.disclaimer)");
            String strF = w9.v.f(this.f29219d);
            Intrinsics.f(strF, "getDisclaimerText(adBean)");
            String string2 = getResources().getString(R$string.f29083ok);
            Intrinsics.f(string2, "resources.getString(R.string.ok)");
            x(string, strF, string2);
        }
        j(j11);
        boolean z11 = this.f29236v.isShowRetainDialog() || this.f29236v.isShowRuDialog() || this.f29236v.isPaused();
        if (this.f29236v.isRewarded()) {
            HSChronometer hSChronometer2 = this.f29225k;
            if (hSChronometer2 != null) {
                hSChronometer2.setText(hSChronometer2.getFinishedString());
                return;
            }
            return;
        }
        if (!z11) {
            HSChronometer hSChronometer3 = this.f29225k;
            if (hSChronometer3 != null) {
                hSChronometer3.startCountdown(j11, new j());
                return;
            }
            return;
        }
        HSChronometer hSChronometer4 = this.f29225k;
        if (hSChronometer4 != null) {
            hSChronometer4.setText(hSChronometer4.countdownText(this.f29236v.getCountdownRemainDuration()));
            hSChronometer4.setTickListener(new k());
        }
    }

    public final void F() {
        this.f29232r = getResources().getConfiguration().orientation == 2;
        h();
        U();
    }

    public final void I() {
        if (this.f29227m == null) {
            ImageView imageView = new ImageView(this);
            imageView.setAdjustViewBounds(true);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setOnTouchListener(new b());
            this.f29227m = imageView;
        }
    }

    public final void L() {
        NativeBean nativeObject;
        NativeBean nativeObject2;
        NativeBean nativeObject3;
        this.f29228n = (ImageView) findViewById(R$id.ad_icon);
        AdsDTO adsDTO = this.f29219d;
        String buttonTxt = null;
        if (adsDTO != null) {
            if (adsDTO.getSource() == 4) {
                DownLoadRequest.o(adsDTO.getLogoUrl(), adsDTO, null, this.f29228n);
            } else {
                DownLoadRequest.p(adsDTO.getLogoUrl(), this.f29219d, 1, null, this.f29228n);
            }
        }
        TextView textView = (TextView) findViewById(R$id.ad_name);
        if (textView != null) {
            AdsDTO adsDTO2 = this.f29219d;
            textView.setText((adsDTO2 == null || (nativeObject3 = adsDTO2.getNativeObject()) == null) ? null : nativeObject3.getTitleTxt());
        }
        TextView textView2 = (TextView) findViewById(R$id.ad_description);
        if (textView2 != null) {
            AdsDTO adsDTO3 = this.f29219d;
            textView2.setText((adsDTO3 == null || (nativeObject2 = adsDTO3.getNativeObject()) == null) ? null : nativeObject2.getDescriptionTxt());
        }
        TextView textView3 = (TextView) findViewById(R$id.ad_btn);
        if (textView3 != null) {
            AdsDTO adsDTO4 = this.f29219d;
            if (adsDTO4 != null) {
                int installApk = adsDTO4.getInstallApk();
                AdsDTO adsDTO5 = this.f29219d;
                if (adsDTO5 != null && (nativeObject = adsDTO5.getNativeObject()) != null) {
                    buttonTxt = nativeObject.getButtonTxt(installApk);
                }
            }
            textView3.setText(buttonTxt);
        }
        if (textView3 != null) {
            CharSequence text = textView3.getText();
            textView3.setVisibility((text == null || text.length() <= 0) ? 8 : 0);
        }
        View viewFindViewById = findViewById(R$id.ad_float_container);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HisavanaRewardedActivity.n(this.f29367a, view);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final void N() {
        boolean z11;
        this.f29223i = (FrameLayout) findViewById(R$id.ad_container);
        AdsDTO adsDTO = this.f29219d;
        if (adsDTO != null) {
            z11 = adsDTO.isVastTypeAd();
        }
        if (z11) {
            Z();
        } else {
            AdsDTO adsDTO2 = this.f29219d;
            if ((adsDTO2 != null ? adsDTO2.getNativeObject() : null) != null) {
                Y();
            }
        }
        if (this.f29219d == null || this.f29236v.isAlreadyMeasure()) {
            return;
        }
        AthenaTracker.B(this.f29219d);
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f29219d, z11 ? this.f29226l : this.f29227m, new a(this));
    }

    public final void P() {
        ImageView imageView = (ImageView) findViewById(R$id.ad_choices_view);
        this.f29229o = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HisavanaRewardedActivity.D(this.f29360a, view);
                }
            });
        }
        AdsDTO adsDTO = this.f29219d;
        if (adsDTO != null) {
            if (adsDTO.getSource() == 4) {
                DownLoadRequest.o(adsDTO.getAdChoiceImageUrl(), adsDTO, null, this.f29229o);
            } else {
                DownLoadRequest.p(adsDTO.getAdChoiceImageUrl(), this.f29219d, 3, null, this.f29229o);
            }
        }
        AdBadgeView adBadgeView = (AdBadgeView) findViewById(R$id.ad_badge_view);
        if (adBadgeView != null) {
            AdsDTO adsDTO2 = this.f29219d;
            adBadgeView.setDisplayStyle(adsDTO2 != null ? adsDTO2.getDisplayRule() : null, w9.v.c(this.f29219d));
        }
        AdCloseView adCloseView = (AdCloseView) findViewById(R$id.ad_close_view);
        if (adCloseView != null) {
            AdsDTO adsDTO3 = this.f29219d;
            adCloseView.setDisplayStyle(adsDTO3 != null ? adsDTO3.getDisplayRule() : null, AdCloseView.CloseImageType.EXPAND);
        }
        com.cloud.hisavana.sdk.h.p().f(this, adCloseView, this, this.f29219d);
        StoreMarkView storeMarkView = (StoreMarkView) findViewById(R$id.ps_mark_view);
        boolean zA = w9.x.a(this.f29219d);
        if (storeMarkView != null) {
            storeMarkView.setVisibility(zA ? 0 : 8);
        }
        if (storeMarkView != null) {
            storeMarkView.setTextSize(6.0f);
        }
        if (storeMarkView != null) {
            storeMarkView.setTextColor(-8882056);
        }
        if (storeMarkView != null) {
            storeMarkView.attachInfo(this.f29219d);
        }
    }

    public final void R() {
        final AdsDTO adsDTO = this.f29219d;
        if (adsDTO != null) {
            if (adsDTO.getDisplayRule() != Constants.AdDisplayRule.RU) {
                adsDTO = null;
            }
            if (adsDTO != null) {
                final ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R$id.main_layout);
                final AdDisclaimerView adDisclaimerView = (AdDisclaimerView) findViewById(R$id.ad_disclaimer_view);
                if (adDisclaimerView != null) {
                    adDisclaimerView.setListener(new AdDisclaimerView.b() { // from class: com.cloud.hisavana.sdk.common.activity.h
                        @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
                        public final void a(String str, String str2, String str3) {
                            HisavanaRewardedActivity.q(this.f29363a, str, str2, str3);
                        }
                    });
                }
                if (mainLayout != null) {
                    Intrinsics.f(mainLayout, "mainLayout");
                    mainLayout.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            HisavanaRewardedActivity.k(mainLayout, adDisclaimerView, adsDTO);
                        }
                    });
                }
            }
        }
    }

    public final void S() {
        if (this.f29226l != null) {
            return;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.f(applicationContext, "applicationContext");
        RewardedVideoView rewardedVideoView = new RewardedVideoView(applicationContext, null, 0, 6, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        rewardedVideoView.setLayoutParams(layoutParams);
        rewardedVideoView.setOnTouchListener(new b());
        rewardedVideoView.setAdMediaPlayerListener(new c(this.f29219d));
        this.f29226l = rewardedVideoView;
    }

    public final void U() {
        if (this.f29219d == null) {
            com.cloud.hisavana.sdk.z.a().w(this.f29216a, "rewarded adBean is null");
            y(true);
            return;
        }
        N();
        W();
        L();
        P();
        R();
    }

    public final void W() {
        VastData videoInfo;
        Integer duration;
        ImageView imageView = (ImageView) findViewById(R$id.ad_volume);
        this.f29224j = imageView;
        if (imageView != null) {
            i(this.f29236v.getVideoVolume());
            AdsDTO adsDTO = this.f29219d;
            imageView.setVisibility((adsDTO == null || !adsDTO.isVastTypeAd()) ? 8 : 0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HisavanaRewardedActivity.J(this.f29361a, view);
                }
            });
        }
        HSChronometer hSChronometer = (HSChronometer) findViewById(R$id.ad_chronometer);
        this.f29225k = hSChronometer;
        if (hSChronometer != null && this.f29236v.isAlreadyMeasure()) {
            C(this.f29236v.getCountdownRemainDuration());
        }
        View viewFindViewById = findViewById(R$id.ad_close);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HisavanaRewardedActivity.G(this.f29362a, view);
                }
            });
        }
        AdsDTO adsDTO2 = this.f29219d;
        int closeDelayTime = adsDTO2 != null ? adsDTO2.getCloseDelayTime() : 0;
        AdsDTO adsDTO3 = this.f29219d;
        if (adsDTO3 != null && adsDTO3.isVastTypeAd()) {
            AdsDTO adsDTO4 = this.f29219d;
            closeDelayTime = Math.min(closeDelayTime, (adsDTO4 == null || (videoInfo = adsDTO4.getVideoInfo()) == null || (duration = videoInfo.getDuration()) == null) ? closeDelayTime : duration.intValue());
        }
        com.cloud.hisavana.sdk.z.a().d(this.f29216a, "current close delay time duration is: " + closeDelayTime);
        this.f29237w = closeDelayTime;
        if (closeDelayTime <= 0 || X()) {
            com.cloud.hisavana.sdk.z.a().d(this.f29216a, "current close delay time is 0 or video or image is null, do not count down.");
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(8);
            if (this.f29236v.isAlreadyMeasure()) {
                j(this.f29236v.getCountdownRemainDuration());
            }
        }
    }

    public final boolean X() {
        VastData videoInfo;
        VastMedia mainAd;
        AdsDTO adsDTO = this.f29219d;
        String adImgUrl = null;
        if (adsDTO == null || !adsDTO.isVastTypeAd()) {
            AdsDTO adsDTO2 = this.f29219d;
            adImgUrl = adsDTO2 != null ? adsDTO2.getAdImgUrl() : null;
            if (adImgUrl == null || adImgUrl.length() == 0) {
                return true;
            }
        } else {
            AdsDTO adsDTO3 = this.f29219d;
            if (adsDTO3 != null && (videoInfo = adsDTO3.getVideoInfo()) != null && (mainAd = videoInfo.getMainAd()) != null) {
                adImgUrl = mainAd.getMediaResource();
            }
            if (adImgUrl == null || adImgUrl.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void Y() {
        String adImgUrl;
        I();
        AdsDTO adsDTO = this.f29219d;
        if (adsDTO == null || (adImgUrl = adsDTO.getAdImgUrl()) == null) {
            new e();
            return;
        }
        d dVar = new d();
        AdsDTO adsDTO2 = this.f29219d;
        if (adsDTO2 == null || adsDTO2.getSource() != 4) {
            DownLoadRequest.p(adImgUrl, this.f29219d, 2, dVar, this.f29227m);
        } else {
            DownLoadRequest.o(adImgUrl, this.f29219d, dVar, this.f29227m);
        }
        Unit unit = Unit.f68710a;
    }

    public final void Z() {
        VastData videoInfo;
        VastMedia mainAd;
        String mediaResource;
        AdsDTO adsDTO = this.f29219d;
        if (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (mainAd = videoInfo.getMainAd()) == null || (mediaResource = mainAd.getMediaResource()) == null) {
            new g();
            return;
        }
        S();
        DownLoadRequest.m(mediaResource, this.f29219d, true, new f());
        Unit unit = Unit.f68710a;
    }

    public final void a0() {
        this.f29236v.setAlreadyMeasure(true);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f29235u;
        AdsDTO adsDTO = this.f29219d;
        if (adsDTO != null) {
            adsDTO.setTriggerShowSpend(jCurrentTimeMillis);
        }
        v("_show");
        AdsDTO adsDTO2 = this.f29219d;
        Integer rewardDuration = adsDTO2 != null ? adsDTO2.getRewardDuration() : null;
        long jMax = ((long) Math.max(rewardDuration == null ? this.f29217b : rewardDuration.intValue(), this.f29217b)) * 1000;
        this.f29218c = jMax;
        C(jMax);
        AdsDTO adsDTO3 = this.f29219d;
        if (adsDTO3 != null) {
            com.cloud.hisavana.sdk.x.h().k(adsDTO3.getCodeSeatId());
            if (adsDTO3.getSource() == 4) {
                a0 a0Var = a0.f29085a;
                String adCreativeId = adsDTO3.getAdCreativeId();
                Intrinsics.f(adCreativeId, "ad.adCreativeId");
                String codeSeatId = adsDTO3.getCodeSeatId();
                Intrinsics.f(codeSeatId, "ad.codeSeatId");
                a0Var.m(adCreativeId, codeSeatId);
            } else if (adsDTO3.isOfflineAd()) {
                adsDTO3.setShowNum(Integer.valueOf(adsDTO3.getShowNum().intValue() + 1));
                b1.c().s(adsDTO3);
            }
        }
        View viewFindViewById = findViewById(R$id.ad_close_container);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setBackground(z2.a.getDrawable(com.cloud.sdk.commonutil.util.f.a(), R$drawable.hisavana_hollow_rounded_rect));
    }

    public final void b0() {
        if (this.f29236v.isRewarded()) {
            return;
        }
        AdsDTO adsDTO = this.f29219d;
        w("_rewarded", adsDTO != null ? Long.valueOf(adsDTO.getTriggerShowSpend()) : null);
        this.f29236v.setRewarded(true);
        this.f29236v.setCountdownRemainDuration(0L);
    }

    public final void c0() {
        if (this.f29230p == null) {
            w9.l lVar = new w9.l(this, new h());
            this.f29230p = lVar;
            String string = getResources().getString(R$string.not_reward_title);
            Intrinsics.f(string, "resources.getString(R.string.not_reward_title)");
            lVar.k(string);
            String string2 = getResources().getString(R$string.not_reward_content);
            Intrinsics.f(string2, "resources.getString(R.string.not_reward_content)");
            lVar.h(string2);
            String string3 = getResources().getString(R$string.continue_txt);
            Intrinsics.f(string3, "resources.getString(R.string.continue_txt)");
            lVar.i(string3);
        }
        try {
            w9.l lVar2 = this.f29230p;
            if (lVar2 != null) {
                lVar2.show();
            }
            this.f29236v.setShowRetainDialog(true);
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().e(this.f29216a, "showRetainDialog error: " + e11.getMessage());
        }
    }

    public final void d0() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f29219d = (AdsDTO) (Build.VERSION.SDK_INT >= 33 ? intent.getParcelableExtra("adBean", AdsDTO.class) : intent.getParcelableExtra("adBean"));
            String stringExtra = intent.getStringExtra(RequestParameters.PREFIX);
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.f(stringExtra, "it.getStringExtra(\"prefix\") ?: \"\"");
            }
            this.f29220f = stringExtra;
            this.f29221g = intent.getLongExtra("observerId", 0L);
            this.f29235u = intent.getLongExtra("triggerTs", System.currentTimeMillis());
        }
        AdsDTO adsDTO = this.f29219d;
        if (adsDTO == null || adsDTO.getMaterialStyle() == null) {
            y(true);
            return;
        }
        int iB = w9.a.f79345a.b(this.f29219d);
        this.f29222h = iB;
        if (iB == -1) {
            com.cloud.hisavana.sdk.z.a().w(this.f29216a, "adMediaType is INVALID_TYPE");
            y(true);
        } else {
            B();
            F();
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0004  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r1.length() > 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        Unit unit;
        int i11;
        int i12;
        if (this.f29232r) {
            AdsDTO adsDTO = this.f29219d;
            if (adsDTO != null) {
                String scale = adsDTO.getScale();
                if (scale == null || scale.length() == 0) {
                    i11 = R$layout.activity_rewarded_r01;
                } else {
                    int installApk = adsDTO.getInstallApk();
                    NativeBean nativeObject = adsDTO.getNativeObject();
                    if (nativeObject != null) {
                        Intrinsics.f(nativeObject, "nativeObject");
                        String logoUrl = nativeObject.getLogoUrl();
                        Intrinsics.f(logoUrl, "it.logoUrl");
                        if (logoUrl.length() <= 0) {
                            String titleTxt = nativeObject.getTitleTxt();
                            Intrinsics.f(titleTxt, "it.titleTxt");
                            if (titleTxt.length() <= 0) {
                                String descriptionTxt = nativeObject.getDescriptionTxt();
                                Intrinsics.f(descriptionTxt, "it.descriptionTxt");
                                if (descriptionTxt.length() <= 0) {
                                    String buttonTxt = nativeObject.getButtonTxt(installApk);
                                    Intrinsics.f(buttonTxt, "it.getButtonTxt(buttonType)");
                                }
                            }
                        }
                        if (Intrinsics.b(adsDTO.getScale(), "9:16")) {
                            this.f29233s = true;
                            i12 = R$layout.activity_rewarded_r01_916;
                        } else {
                            i12 = R$layout.activity_rewarded_r01;
                        }
                        setContentView(i12);
                        unit = Unit.f68710a;
                    }
                    i11 = R$layout.activity_rewarded_r01_expose;
                }
            } else {
                unit = null;
            }
            if (unit == null) {
                setContentView(R$layout.activity_rewarded_r01);
                return;
            }
            return;
        }
        i11 = R$layout.activity_rewarded_r01;
        setContentView(i11);
    }

    public final void i(float f11) {
        ImageView imageView = this.f29224j;
        if (imageView != null) {
            imageView.setImageResource(0.0f == f11 ? R$drawable.hisavana_volume_close : R$drawable.hisavana_volume_open);
        }
    }

    public final void j(long j11) {
        View viewFindViewById = findViewById(R$id.ad_close);
        int i11 = this.f29237w;
        if (i11 <= 0 || j11 <= 0) {
            if (viewFindViewById == null) {
                return;
            }
            viewFindViewById.setVisibility(0);
        } else {
            if ((this.f29218c - j11) / 1000.0f < i11 || viewFindViewById == null) {
                return;
            }
            viewFindViewById.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        w9.l lVar;
        w9.l lVar2;
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        HSChronometer hSChronometer = this.f29225k;
        if (hSChronometer != null) {
            this.f29236v.setCountdownRemainDuration(hSChronometer.pauseCountdown());
            hSChronometer.stop();
        }
        FrameLayout frameLayout = this.f29223i;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        F();
        if (this.f29236v.isShowRuDialog() && (lVar2 = this.f29231q) != null) {
            lVar2.l();
        }
        if (!this.f29236v.isShowRetainDialog() || (lVar = this.f29230p) == null) {
            return;
        }
        lVar.l();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d0();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RewardedVideoView rewardedVideoView = this.f29226l;
        if (rewardedVideoView != null) {
            rewardedVideoView.release();
        }
        HSChronometer hSChronometer = this.f29225k;
        if (hSChronometer != null) {
            hSChronometer.stop();
        }
        FrameLayout frameLayout = this.f29223i;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        w9.l lVar = this.f29230p;
        if (lVar != null) {
            lVar.dismiss();
        }
        w9.l lVar2 = this.f29231q;
        if (lVar2 != null) {
            lVar2.dismiss();
        }
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.f29219d);
        com.cloud.sdk.commonutil.util.l.a(this.f29227m);
        com.cloud.sdk.commonutil.util.l.a(this.f29228n);
        com.cloud.sdk.commonutil.util.l.a(this.f29229o);
    }

    @Override // android.app.Activity
    public void onPause() {
        RewardedVideoView rewardedVideoView;
        super.onPause();
        if (!this.f29236v.isShowRetainDialog() && !this.f29236v.isShowRuDialog() && !this.f29236v.isPaused()) {
            RewardedState rewardedState = this.f29236v;
            HSChronometer hSChronometer = this.f29225k;
            rewardedState.setCountdownRemainDuration(hSChronometer != null ? hSChronometer.pauseCountdown() : 0L);
            if (!this.f29236v.isPlayComplete() && (rewardedVideoView = this.f29226l) != null) {
                rewardedVideoView.pause();
            }
        }
        this.f29236v.setPaused(true);
        if (com.cloud.hisavana.sdk.z.b()) {
            com.cloud.hisavana.sdk.z.a().i(this.f29216a, "----------> onPause " + this.f29236v);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        RewardedVideoView rewardedVideoView;
        super.onResume();
        if (com.cloud.hisavana.sdk.z.b()) {
            com.cloud.hisavana.sdk.z.a().i(this.f29216a, "-----------> onResume " + this.f29236v);
        }
        if (!this.f29236v.isShowRetainDialog() && !this.f29236v.isShowRuDialog()) {
            HSChronometer hSChronometer = this.f29225k;
            if (hSChronometer != null) {
                hSChronometer.resumeCountdown(this.f29236v.getCountdownRemainDuration());
            }
            if (!this.f29236v.isPlayComplete() && (rewardedVideoView = this.f29226l) != null) {
                rewardedVideoView.resume();
            }
        }
        this.f29236v.setPaused(false);
    }

    public final void t(AdImage adImage) {
        VastData videoInfo;
        VideoMask videoMask;
        String resource;
        RewardedVideoView rewardedVideoView;
        if (this.f29236v.isPlayComplete()) {
            RewardedVideoView rewardedVideoView2 = this.f29226l;
            if (rewardedVideoView2 != null) {
                rewardedVideoView2.seekTo(rewardedVideoView2.getDuration());
                return;
            }
            return;
        }
        if (this.f29236v.isPlayStart()) {
            return;
        }
        if (com.cloud.hisavana.sdk.z.b()) {
            com.cloud.hisavana.sdk.z.a().i(this.f29216a, "-----------> video set media data.");
        }
        RewardedVideoView rewardedVideoView3 = this.f29226l;
        if (rewardedVideoView3 != null) {
            String filePath = adImage.getFilePath();
            Intrinsics.f(filePath, "adMedia.filePath");
            rewardedVideoView3.setMediaData(filePath, this.f29219d, this.f29236v.getVideoVolume() == 0.0f);
        }
        AdsDTO adsDTO = this.f29219d;
        if (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (videoMask = videoInfo.getVideoMask()) == null || (resource = videoMask.getResource()) == null || (rewardedVideoView = this.f29226l) == null) {
            return;
        }
        rewardedVideoView.setCompanionUrl(resource);
    }

    public final void u(TaErrorCode taErrorCode) {
        w("_error", taErrorCode);
    }

    public final void v(String str) {
        w(str, null);
    }

    public final void w(String str, Object obj) {
        y0.f30225a.d(this.f29221g, this.f29220f + str, obj);
    }

    public final void x(String str, String str2, String str3) {
        if (this.f29231q == null) {
            w9.l lVar = new w9.l(this, new i());
            this.f29231q = lVar;
            lVar.k(str);
            lVar.h(str2);
            lVar.g(str3);
            lVar.j(true);
        }
        try {
            w9.l lVar2 = this.f29231q;
            if (lVar2 != null) {
                lVar2.show();
            }
            this.f29236v.setShowRuDialog(true);
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().e(this.f29216a, "showRuDialog error: " + e11.getMessage());
        }
    }

    public final void y(boolean z11) {
        if (z11) {
            v("_close");
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }

    public final void z(boolean z11, DownUpPointBean downUpPointBean) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f29234t < 1000) {
            return;
        }
        this.f29234t = jCurrentTimeMillis;
        if (z11) {
            y(true);
        } else {
            w("_click", new Pair(this.f29219d, downUpPointBean));
        }
    }
}
