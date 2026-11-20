package com.transsion.ad.middle.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.ad.R$color;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.R$string;
import com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import com.transsion.ad.strategy.MeasureManager;
import com.transsion.ad.view.AdTagView;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.j;

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
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
@Metadata
@SuppressLint({"CustomSplashScreen"})
public final class NonSplashActivity extends AppCompatActivity implements MeasureManager.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f50504j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f50505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50506b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f50507c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f50508d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdPlans f50509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AdMaterialList f50510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f50511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50512i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f50513a;

        public b(f fVar) {
            this.f50513a = fVar;
        }

        @Override // com.transsion.player.orplayer.e
        public void initPlayer() {
            e.a.a(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
            e.a.b(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onBufferedPosition(long j11, MediaSource mediaSource) {
            e.a.c(this, j11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onCompletion(MediaSource mediaSource) {
            e.a.d(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onFocusChange(boolean z11) {
            e.a.f(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onIsPlayingChanged(boolean z11) {
            e.a.g(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingBegin(MediaSource mediaSource) {
            e.a.h(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingEnd(MediaSource mediaSource) {
            e.a.j(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
            e.a.l(this, i11, f11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoopingStart() {
            e.a.n(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onMediaItemTransition(String str) {
            e.a.o(this, str);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
            Intrinsics.g(errorInfo, "errorInfo");
            e.a.p(this, errorInfo, mediaSource);
            com.transsion.ad.a.P(com.transsion.ad.a.f50276a, b.class.getSimpleName() + " --> playVideo() --> onPlayError() --> errorInfo = " + errorInfo, false, 2, null);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerRelease(MediaSource mediaSource) {
            e.a.s(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerReset() {
            e.a.u(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPrepare(MediaSource mediaSource) {
            e.a.v(this, mediaSource);
            this.f50513a.play();
        }

        @Override // com.transsion.player.orplayer.e
        public void onProgress(long j11, MediaSource mediaSource) {
            e.a.x(this, j11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onRenderFirstFrame() {
            e.a.z(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onSetDataSource() {
            e.a.A(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksAudioBitrateChange(int i11) {
            e.a.B(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksChange(ov.c cVar) {
            e.a.C(this, cVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksVideoBitrateChange(int i11) {
            e.a.D(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoPause(MediaSource mediaSource) {
            e.a.E(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoSizeChanged(int i11, int i12) {
            e.a.G(this, i11, i12);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(MediaSource mediaSource) {
            e.a.H(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void setOnSeekCompleteListener() {
            e.a.J(this);
        }
    }

    private final String S() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getStringExtra(TrackingKey.SCENE_ID);
        }
        return null;
    }

    private final void T() {
        MbAdVideo video;
        String path;
        MbAdVideo video2;
        String path2;
        MbAdVideo video3;
        String url;
        MbAdVideo video4;
        String url2;
        MbAdVideo video5;
        final FrameLayout frameLayout = (FrameLayout) findViewById(R$id.container);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            TextureView textureView = new TextureView(frameLayout.getContext());
            frameLayout.addView(textureView);
            if (this.f50506b) {
                final ImageView imageView = new ImageView(frameLayout.getContext());
                X(imageView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f0.a(20.0f), f0.a(20.0f));
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
                layoutParams.topMargin = f0.a(10.0f);
                layoutParams.setMarginEnd(f0.a(10.0f));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.splash.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NonSplashActivity.U(frameLayout, this, imageView, view);
                    }
                });
                frameLayout.addView(imageView, layoutParams);
            }
            Context context = frameLayout.getContext();
            Intrinsics.f(context, "context");
            f fVarA = new f.a(context).b(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 94207, null)).a();
            fVarA.setMute(this.f50507c);
            fVarA.setTextureView(textureView);
            frameLayout.setBackgroundColor(z2.a.getColor(frameLayout.getContext(), R$color.ad_bg_01));
            fVarA.setLooping(true);
            fVarA.setPlayerListener(new b(fVarA));
            this.f50508d = fVarA;
            AdMaterialList adMaterialList = this.f50510g;
            if (TextUtils.isEmpty((adMaterialList == null || (video5 = adMaterialList.getVideo()) == null) ? null : video5.getPath())) {
                f fVar = this.f50508d;
                if (fVar != null) {
                    AdMaterialList adMaterialList2 = this.f50510g;
                    String str = (adMaterialList2 == null || (video4 = adMaterialList2.getVideo()) == null || (url2 = video4.getUrl()) == null) ? "" : url2;
                    AdMaterialList adMaterialList3 = this.f50510g;
                    fVar.setDataSource(new MediaSource(str, (adMaterialList3 == null || (video3 = adMaterialList3.getVideo()) == null || (url = video3.getUrl()) == null) ? "" : url, 0, null, null, 28, null));
                }
            } else {
                f fVar2 = this.f50508d;
                if (fVar2 != null) {
                    AdMaterialList adMaterialList4 = this.f50510g;
                    String str2 = (adMaterialList4 == null || (video2 = adMaterialList4.getVideo()) == null || (path2 = video2.getPath()) == null) ? "" : path2;
                    AdMaterialList adMaterialList5 = this.f50510g;
                    fVar2.setDataSource(new MediaSource(str2, (adMaterialList5 == null || (video = adMaterialList5.getVideo()) == null || (path = video.getPath()) == null) ? "" : path, 0, null, null, 28, null));
                }
            }
            f fVar3 = this.f50508d;
            if (fVar3 != null) {
                fVar3.prepare();
            }
        }
    }

    public static final void U(FrameLayout this_apply, NonSplashActivity this$0, ImageView imageView, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(imageView, "$imageView");
        com.transsion.ad.a.N(com.transsion.ad.a.f50276a, this_apply.getClass().getSimpleName() + " --> playVideo() --> 点击了音频按钮", false, 2, null);
        boolean z11 = this$0.f50507c ^ true;
        this$0.f50507c = z11;
        f fVar = this$0.f50508d;
        if (fVar != null) {
            fVar.setMute(z11);
        }
        this$0.X(imageView);
    }

    private final void V() {
        if (this.f50511h > 0) {
            vq.b bVar = vq.b.f79053a;
            String strS = S();
            AdPlans adPlans = this.f50509f;
            String id2 = adPlans != null ? adPlans.getId() : null;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50511h;
            AdMaterialList adMaterialList = this.f50510g;
            bVar.c((1 & 1) != 0 ? "" : null, strS, id2, jCurrentTimeMillis, adMaterialList != null ? adMaterialList.getId() : null, 5, (1 & 64) != 0 ? false : uq.b.f78633a.a(this.f50509f));
            this.f50511h = 0L;
        }
    }

    public static final void Z(NonSplashActivity this$0, AdPlans adPlans, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adPlans, "$adPlans");
        if (xq.e.f80670a.a(view.getId(), 500L)) {
            return;
        }
        vq.b bVar = vq.b.f79053a;
        String strS = this$0.S();
        String id2 = adPlans.getId();
        AdMaterialList adMaterialList = this$0.f50510g;
        bVar.a((128 & 1) != 0 ? "" : null, strS, id2, 102, adMaterialList != null ? adMaterialList.getId() : null, 5, (128 & 64) != 0 ? false : uq.b.f78633a.a(this$0.f50509f), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this$0.f50509f), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        AdMaterialList adMaterialList2 = this$0.f50510g;
        String deeplink = adMaterialList2 != null ? adMaterialList2.getDeeplink() : null;
        AdMaterialList adMaterialList3 = this$0.f50510g;
        aVar.a(deeplink, adMaterialList3 != null ? adMaterialList3.getH5Link() : null, this$0.f50509f);
        this$0.finish();
    }

    public static final void c0(NonSplashActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    private final void d0() {
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.container);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            AdMaterialList adMaterialList = this.f50510g;
            String path = null;
            if (TextUtils.isEmpty((adMaterialList == null || (image3 = adMaterialList.getImage()) == null) ? null : image3.getPath())) {
                RequestManager requestManagerWith = Glide.with(frameLayout.getContext());
                AdMaterialList adMaterialList2 = this.f50510g;
                if (adMaterialList2 != null && (image2 = adMaterialList2.getImage()) != null) {
                    path = image2.getUrl();
                }
                requestManagerWith.load(path).into(imageView);
            } else {
                RequestManager requestManagerWith2 = Glide.with(frameLayout.getContext());
                AdMaterialList adMaterialList3 = this.f50510g;
                if (adMaterialList3 != null && (image = adMaterialList3.getImage()) != null) {
                    path = image.getPath();
                }
                requestManagerWith2.load(path).into(imageView);
            }
            frameLayout.addView(imageView);
        }
    }

    private final String getClassTag() {
        String simpleName = NonSplashActivity.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final int R() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getIntExtra("app_layout", 0);
        }
        return 0;
    }

    public final void W() {
        NonAdShowedTimesManager.f50524a.c(this.f50509f);
    }

    public final void X(ImageView imageView) {
        if (this.f50507c) {
            imageView.setImageResource(R$mipmap.ad_volumeoff);
        } else {
            imageView.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    public final void Y(final AdPlans adPlans) {
        this.f50509f = adPlans;
        List<AdMaterialList> adMaterialList = adPlans.getAdMaterialList();
        this.f50510g = adMaterialList != null ? adMaterialList.get(0) : null;
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.container);
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.splash.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NonSplashActivity.Z(this.f50514a, adPlans, view);
                }
            });
        }
        AdTagView adTagView = (AdTagView) findViewById(R$id.adIcon);
        if (adTagView != null) {
            com.transsion.ad.strategy.e.f50608a.a(adTagView);
        }
        AdMaterialList adMaterialList2 = this.f50510g;
        if (Intrinsics.b(adMaterialList2 != null ? adMaterialList2.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
            d0();
        } else {
            T();
        }
    }

    public final void a0() {
        try {
            Result.Companion companion = Result.Companion;
            FrameLayout frameLayout = (FrameLayout) findViewById(R$id.movieBoxLayout);
            if (frameLayout != null) {
                Intrinsics.f(frameLayout, "findViewById<FrameLayout>(R.id.movieBoxLayout)");
                frameLayout.removeAllViews();
                frameLayout.addView(LayoutInflater.from(this).inflate(R(), (ViewGroup) frameLayout, false));
            } else {
                frameLayout = null;
            }
            Result.m163constructorimpl(frameLayout);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @SuppressLint({"StringFormatMatches"})
    public final void b0() {
        JsonElement jsonElement;
        MeasureManager.f50573a.g(this);
        JsonObject jsonObjectB = wq.d.f79584a.b(S());
        int asInt = (jsonObjectB == null || (jsonElement = jsonObjectB.get("countDown")) == null) ? 5 : jsonElement.getAsInt();
        TextView textView = (TextView) findViewById(R$id.tvCountDown);
        textView.setVisibility(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String string = getString(R$string.skip_ad, Integer.valueOf(asInt));
        Intrinsics.f(string, "getString(R.string.skip_ad, countDownSeconds)");
        String str = String.format(string, Arrays.copyOf(new Object[0], 0));
        Intrinsics.f(str, "format(...)");
        textView.setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.splash.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NonSplashActivity.c0(this.f50516a, view);
            }
        });
        this.f50505a = textView;
        j.d(v.a(this), null, null, new NonSplashActivity$showCountDown$2(asInt, this, null), 3, null);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return MeasureManager.a.C0550a.a(this);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return findViewById(R$id.container);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Unit unit;
        super.onCreate(bundle);
        setContentView(R$layout.activity_non_splash);
        AdPlans adPlansB = d.f50520a.b();
        if (adPlansB != null) {
            Y(adPlansB);
            b0();
            a0();
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MeasureManager.f50573a.p(this);
        d.f50520a.a();
        f fVar = this.f50508d;
        if (fVar != null) {
            fVar.release();
        }
        com.transsion.ad.a.N(com.transsion.ad.a.f50276a, getClassTag() + " --> onDestroy() --> 开屏广告关闭 -- 资源回收", false, 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        V();
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        f fVar;
        if (!z11) {
            f fVar2 = this.f50508d;
            if (fVar2 != null) {
                fVar2.pause();
            }
            V();
            return;
        }
        if (this.f50511h == 0) {
            this.f50511h = System.currentTimeMillis();
        }
        f fVar3 = this.f50508d;
        if (fVar3 != null && !fVar3.isPlaying() && (fVar = this.f50508d) != null) {
            fVar.play();
        }
        if (this.f50512i) {
            return;
        }
        this.f50512i = true;
        vq.b bVar = vq.b.f79053a;
        String strS = S();
        AdPlans adPlans = this.f50509f;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList = this.f50510g;
        String id3 = adMaterialList != null ? adMaterialList.getId() : null;
        uq.b.a aVar = uq.b.f78633a;
        bVar.f((128 & 1) != 0 ? "" : null, strS, id2, 102, id3, 5, (128 & 64) != 0 ? false : aVar.a(this.f50509f), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50509f), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        com.transsion.ad.a.N(com.transsion.ad.a.f50276a, NonSplashActivity.class.getSimpleName() + " --> 开屏广告展示 --> isAdShowLevel = " + aVar.a(this.f50509f), false, 2, null);
        W();
    }
}
