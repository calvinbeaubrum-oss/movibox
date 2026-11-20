package com.transsion.ad.middle.intercept;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.activity.p;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import com.transsion.ad.strategy.MeasureManager;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import iv.d;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class BaseInterceptMbAdActivity extends AppCompatActivity implements MeasureManager.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f50431n = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdPlans f50432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdMaterialList f50434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f50435d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f50436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50437g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f50440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f50442l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50438h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f50439i = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f50443m = new Runnable() { // from class: com.transsion.ad.middle.intercept.a
        @Override // java.lang.Runnable
        public final void run() {
            BaseInterceptMbAdActivity.V(this.f50450a);
        }
    };

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
    public static final class b extends p {
        public b() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (BaseInterceptMbAdActivity.this.f50436f) {
                BaseInterceptMbAdActivity.this.finish();
            } else if (BaseInterceptMbAdActivity.this.a0() == 3) {
                BaseInterceptMbAdActivity.this.r0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f50446b;

        public c(f fVar) {
            this.f50446b = fVar;
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
            BaseInterceptMbAdActivity.this.g0();
            BaseInterceptMbAdActivity.this.e0();
            BaseInterceptMbAdActivity.this.f50436f = true;
            BaseInterceptMbAdActivity.this.k0(0);
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
            com.transsion.ad.a.H(com.transsion.ad.a.f50276a, c.class.getSimpleName() + " --> playVideo() --> onPlayError() --> errorInfo = " + errorInfo + " -- sceneId = " + BaseInterceptMbAdActivity.this.f50433b, false, 2, null);
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
            this.f50446b.play();
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
            BaseInterceptMbAdActivity.this.g0();
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoSizeChanged(int i11, int i12) {
            e.a.G(this, i11, i12);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(MediaSource mediaSource) {
            e.a.H(this, mediaSource);
            BaseInterceptMbAdActivity.this.t0();
        }

        @Override // com.transsion.player.orplayer.e
        public void setOnSeekCompleteListener() {
            e.a.J(this);
        }
    }

    public static final void V(BaseInterceptMbAdActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.k0(this$0.f50442l);
        this$0.f50442l--;
        this$0.t0();
    }

    public static final void i0(BaseInterceptMbAdActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        Intent intentY = this$0.Y();
        intentY.putExtra("key", AppMeasurementSdk.ConditionalUserProperty.VALUE);
        u3.a.b(this$0).d(intentY);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0029  */
    private final void initData() {
        AdPlans adPlans;
        String stringExtra;
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
        MeasureManager.f50573a.g(this);
        if (Build.VERSION.SDK_INT >= 33) {
            Intent intent = getIntent();
            if (intent != null) {
                adPlans = (AdPlans) intent.getParcelableExtra("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.AdPlan", AdPlans.class);
            } else {
                adPlans = null;
            }
        } else {
            Intent intent2 = getIntent();
            if (intent2 != null) {
                adPlans = (AdPlans) intent2.getParcelableExtra("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.AdPlan");
            } else {
                adPlans = null;
            }
        }
        this.f50432a = adPlans;
        Intent intent3 = getIntent();
        if (intent3 == null || (stringExtra = intent3.getStringExtra("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.SceneId")) == null) {
            stringExtra = "";
        }
        this.f50433b = stringExtra;
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> onCreate --> 开始展示广告了 --> mSceneId = " + this.f50433b + " -- mAdPlan = " + this.f50432a, false, 2, null);
        this.f50442l = b0();
    }

    private final void j0() {
        MbAdVideo video;
        String path;
        MbAdVideo video2;
        String path2;
        MbAdVideo video3;
        MbAdVideo video4;
        MbAdVideo video5;
        String url;
        MbAdVideo video6;
        String url2;
        MbAdVideo video7;
        T(true);
        f fVarA = new f.a(this).b(new d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, null, 94207, null)).a();
        fVarA.setMute(true);
        fVarA.setTextureView(Z());
        fVarA.setLooping(a0() == 4);
        fVarA.setPlayerListener(new c(fVarA));
        this.f50435d = fVarA;
        AdMaterialList adMaterialList = this.f50434c;
        if (TextUtils.isEmpty((adMaterialList == null || (video7 = adMaterialList.getVideo()) == null) ? null : video7.getPath())) {
            f fVar = this.f50435d;
            if (fVar != null) {
                AdMaterialList adMaterialList2 = this.f50434c;
                String str = (adMaterialList2 == null || (video6 = adMaterialList2.getVideo()) == null || (url2 = video6.getUrl()) == null) ? "" : url2;
                AdMaterialList adMaterialList3 = this.f50434c;
                fVar.setDataSource(new MediaSource(str, (adMaterialList3 == null || (video5 = adMaterialList3.getVideo()) == null || (url = video5.getUrl()) == null) ? "" : url, 0, null, null, 28, null));
            }
        } else {
            f fVar2 = this.f50435d;
            if (fVar2 != null) {
                AdMaterialList adMaterialList4 = this.f50434c;
                String str2 = (adMaterialList4 == null || (video2 = adMaterialList4.getVideo()) == null || (path2 = video2.getPath()) == null) ? "" : path2;
                AdMaterialList adMaterialList5 = this.f50434c;
                fVar2.setDataSource(new MediaSource(str2, (adMaterialList5 == null || (video = adMaterialList5.getVideo()) == null || (path = video.getPath()) == null) ? "" : path, 0, null, null, 28, null));
            }
        }
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String simpleName = getClass().getSimpleName();
        AdMaterialList adMaterialList6 = this.f50434c;
        String url3 = (adMaterialList6 == null || (video4 = adMaterialList6.getVideo()) == null) ? null : video4.getUrl();
        AdMaterialList adMaterialList7 = this.f50434c;
        com.transsion.ad.a.F(aVar, simpleName + " --> playVideo() --> url = " + url3 + " --> path = " + ((adMaterialList7 == null || (video3 = adMaterialList7.getVideo()) == null) ? null : video3.getPath()), false, 2, null);
        f fVar3 = this.f50435d;
        if (fVar3 != null) {
            fVar3.prepare();
        }
    }

    private final void l0() {
        if (this.f50440j > 0) {
            vq.b bVar = vq.b.f79053a;
            String str = this.f50433b;
            AdPlans adPlans = this.f50432a;
            String id2 = adPlans != null ? adPlans.getId() : null;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50440j;
            AdMaterialList adMaterialList = this.f50434c;
            bVar.c((1 & 1) != 0 ? "" : null, str, id2, jCurrentTimeMillis, adMaterialList != null ? adMaterialList.getId() : null, a0(), (1 & 64) != 0 ? false : uq.b.f78633a.a(this.f50432a));
            this.f50440j = 0L;
        }
    }

    private final void s0() {
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        T(false);
        t0();
        ImageView imageViewX = X();
        if (imageViewX != null) {
            AdMaterialList adMaterialList = this.f50434c;
            String path = null;
            if (TextUtils.isEmpty((adMaterialList == null || (image3 = adMaterialList.getImage()) == null) ? null : image3.getPath())) {
                RequestManager requestManagerWith = Glide.with((FragmentActivity) this);
                AdMaterialList adMaterialList2 = this.f50434c;
                if (adMaterialList2 != null && (image2 = adMaterialList2.getImage()) != null) {
                    path = image2.getUrl();
                }
                requestManagerWith.load2(path).into(imageViewX);
                return;
            }
            RequestManager requestManagerWith2 = Glide.with((FragmentActivity) this);
            AdMaterialList adMaterialList3 = this.f50434c;
            if (adMaterialList3 != null && (image = adMaterialList3.getImage()) != null) {
                path = image.getPath();
            }
            requestManagerWith2.load2(path).into(imageViewX);
        }
    }

    public final void S() {
        vq.b bVar = vq.b.f79053a;
        String str = this.f50433b;
        AdPlans adPlans = this.f50432a;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList = this.f50434c;
        bVar.a((128 & 1) != 0 ? "" : null, str, id2, 102, adMaterialList != null ? adMaterialList.getId() : null, a0(), (128 & 64) != 0 ? false : uq.b.f78633a.a(this.f50432a), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50432a), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        AdMaterialList adMaterialList2 = this.f50434c;
        String deeplink = adMaterialList2 != null ? adMaterialList2.getDeeplink() : null;
        AdMaterialList adMaterialList3 = this.f50434c;
        aVar.a(deeplink, adMaterialList3 != null ? adMaterialList3.getH5Link() : null, this.f50432a);
    }

    public abstract void T(boolean z11);

    public final void U() {
        this.f50436f = true;
        getOnBackPressedDispatcher().l();
    }

    public abstract Intent W();

    public abstract ImageView X();

    public abstract Intent Y();

    public abstract TextureView Z();

    public abstract int a0();

    public abstract int b0();

    public final AdMaterialList c0() {
        return this.f50434c;
    }

    public final AdPlans d0() {
        return this.f50432a;
    }

    public abstract void e0();

    public final void f0() {
        f fVar = this.f50435d;
        if (fVar != null) {
            fVar.pause();
        }
        l0();
    }

    public final void g0() {
        this.f50439i.removeCallbacksAndMessages(null);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return MeasureManager.a.C0550a.a(this);
    }

    public final void h0() {
        f fVar;
        f fVar2;
        if (this.f50440j == 0) {
            this.f50440j = System.currentTimeMillis();
        }
        f fVar3 = this.f50435d;
        if (fVar3 != null && !fVar3.isPlaying() && !this.f50437g && (fVar = this.f50435d) != null && !fVar.isComplete() && (fVar2 = this.f50435d) != null) {
            fVar2.play();
        }
        if (this.f50441k) {
            return;
        }
        this.f50441k = true;
        vq.b bVar = vq.b.f79053a;
        String str = this.f50433b;
        AdPlans adPlans = this.f50432a;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList = this.f50434c;
        String id3 = adMaterialList != null ? adMaterialList.getId() : null;
        int iA0 = a0();
        uq.b.a aVar = uq.b.f78633a;
        bVar.f((128 & 1) != 0 ? "" : null, str, id2, 102, id3, iA0, (128 & 64) != 0 ? false : aVar.a(this.f50432a), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50432a), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        com.transsion.ad.a.f50276a.E(getClass().getSimpleName() + " --> 广告展示 --> sceneId = " + this.f50433b + " --> isAdShowLevel = " + aVar.a(this.f50432a), false);
        runOnUiThread(new Runnable() { // from class: com.transsion.ad.middle.intercept.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseInterceptMbAdActivity.i0(this.f50451a);
            }
        });
        NonAdShowedTimesManager.f50524a.c(this.f50432a);
    }

    public abstract void k0(int i11);

    public abstract void m0();

    public abstract int n0();

    public final boolean o0() {
        boolean z11 = !this.f50438h;
        this.f50438h = z11;
        f fVar = this.f50435d;
        if (fVar != null) {
            fVar.setMute(z11);
        }
        return this.f50438h;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(n0());
        initData();
        q0();
        getOnBackPressedDispatcher().i(this, new b());
        m0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f fVar = this.f50435d;
        if (fVar != null) {
            fVar.release();
        }
        Intent intentW = W();
        intentW.putExtra("key", AppMeasurementSdk.ConditionalUserProperty.VALUE);
        u3.a.b(this).d(intentW);
        MeasureManager.f50573a.p(this);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        if (z11) {
            h0();
        } else {
            f0();
        }
    }

    public final void p0(boolean z11) {
        this.f50437g = z11;
    }

    public final void q0() {
        List<AdMaterialList> adMaterialList;
        AdPlans adPlans = this.f50432a;
        AdMaterialList adMaterialList2 = (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null) ? null : adMaterialList.get(0);
        this.f50434c = adMaterialList2;
        if (Intrinsics.b(adMaterialList2 != null ? adMaterialList2.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
            ImageView imageViewX = X();
            if (imageViewX != null) {
                imageViewX.setVisibility(0);
            }
            TextureView textureViewZ = Z();
            if (textureViewZ != null) {
                textureViewZ.setVisibility(0);
            }
            s0();
            return;
        }
        ImageView imageViewX2 = X();
        if (imageViewX2 != null) {
            imageViewX2.setVisibility(8);
        }
        TextureView textureViewZ2 = Z();
        if (textureViewZ2 != null) {
            textureViewZ2.setVisibility(0);
        }
        j0();
    }

    public abstract void r0();

    public final void t0() {
        g0();
        if (this.f50442l < 0) {
            this.f50436f = true;
        } else {
            this.f50439i.postDelayed(this.f50443m, 1000L);
        }
    }
}
