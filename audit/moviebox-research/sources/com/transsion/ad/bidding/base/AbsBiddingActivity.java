package com.transsion.ad.bidding.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.p;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.strategy.MeasureManager;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
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
@Metadata
public abstract class AbsBiddingActivity extends AppCompatActivity implements MeasureManager.a, n, com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdPlans f50292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdMaterialList f50293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50295d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f50296f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f50300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.transsion.player.orplayer.f f50301k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicBoolean f50297g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50298h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f50299i = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f50302l = new Runnable() { // from class: com.transsion.ad.bidding.base.k
        @Override // java.lang.Runnable
        public final void run() {
            AbsBiddingActivity.T(this.f50327a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends p {
        public a() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
        }
    }

    public static final void T(AbsBiddingActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.o0(this$0.f50300j);
        this$0.l0(3, "refreshCountDown --> times = " + this$0.a0() + " --> i = " + this$0.f50300j);
        if (this$0.f50300j == 0) {
            this$0.j0();
        }
        this$0.f50300j--;
        this$0.y0();
    }

    private final com.transsion.player.orplayer.f e0() {
        return this.f50301k;
    }

    private final void m0() {
        this.f50299i.removeCallbacksAndMessages(null);
    }

    private final void n0() {
        AdMaterialList adMaterialListX;
        MbAdVideo video;
        String path;
        AdMaterialList adMaterialListX2;
        MbAdVideo video2;
        MbAdVideo video3;
        FrameLayout frameLayoutC0 = c0();
        if (frameLayoutC0 != null) {
            TextureView textureView = new TextureView(this);
            com.transsion.player.orplayer.f fVarA = new com.transsion.player.orplayer.f.a(this).b(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, null, 94207, null)).a();
            fVarA.setMute(d0());
            fVarA.setTextureView(textureView);
            fVarA.setLooping(b0());
            fVarA.setPlayerListener(this);
            this.f50301k = fVarA;
            AdMaterialList adMaterialListX3 = X();
            String str = (!TextUtils.isEmpty((adMaterialListX3 == null || (video3 = adMaterialListX3.getVideo()) == null) ? null : video3.getPath()) ? !((adMaterialListX = X()) == null || (video = adMaterialListX.getVideo()) == null || (path = video.getPath()) == null) : !((adMaterialListX2 = X()) == null || (video2 = adMaterialListX2.getVideo()) == null || (path = video2.getUrl()) == null)) ? "" : path;
            com.transsion.player.orplayer.f fVar = this.f50301k;
            if (fVar != null) {
                fVar.setDataSource(new MediaSource(str, str, 0, null, null, 28, null));
            }
            com.transsion.player.orplayer.f fVar2 = this.f50301k;
            if (fVar2 != null) {
                fVar2.prepare();
            }
            frameLayoutC0.addView(textureView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private final boolean q0() {
        this.f50298h = !this.f50298h;
        com.transsion.player.orplayer.f fVarE0 = e0();
        if (fVarE0 != null) {
            fVarE0.setMute(this.f50298h);
        }
        return this.f50298h;
    }

    public static final void v0(AbsBiddingActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.Q();
    }

    public static final void x0(AbsBiddingActivity this$0, AppCompatImageView volumeImageView, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(volumeImageView, "$volumeImageView");
        if (this$0.q0()) {
            volumeImageView.setImageResource(R$mipmap.ad_volumeoff);
        } else {
            volumeImageView.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    private final void y0() {
        m0();
        if (this.f50300j >= 0) {
            this.f50299i.postDelayed(this.f50302l, 1000L);
        }
    }

    public final void Q() {
        Intent intent = new Intent(getIntent().getStringExtra("action_click"));
        intent.putExtra("ad_plan", Y());
        u3.a.b(this).d(intent);
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        AdMaterialList adMaterialListX = X();
        String deeplink = adMaterialListX != null ? adMaterialListX.getDeeplink() : null;
        AdMaterialList adMaterialListX2 = X();
        aVar.a(deeplink, adMaterialListX2 != null ? adMaterialListX2.getH5Link() : null, Y());
    }

    public final void R() {
        Intent intent = new Intent(getIntent().getStringExtra("action_close"));
        intent.putExtra("ad_plan", Y());
        u3.a.b(this).d(intent);
    }

    public final void S() {
        Intent intent = new Intent(getIntent().getStringExtra("action_rewarded"));
        intent.putExtra("ad_plan", Y());
        u3.a.b(this).d(intent);
    }

    public final void U() {
        Intent intent = new Intent(getIntent().getStringExtra("action_display"));
        intent.putExtra("ad_plan", Y());
        u3.a.b(this).d(intent);
    }

    public final void V() {
        finish();
    }

    public abstract View W();

    public final AdMaterialList X() {
        return this.f50293b;
    }

    public final AdPlans Y() {
        return this.f50292a;
    }

    public final int Z() {
        return this.f50294c;
    }

    public abstract int a0();

    public boolean b0() {
        return false;
    }

    public abstract FrameLayout c0();

    public boolean d0() {
        return true;
    }

    public final String f0() {
        String str = this.f50295d;
        return str == null ? "" : str;
    }

    public abstract View g0();

    @Override // com.transsion.ad.bidding.base.n
    public String getClassTag() {
        return n.a.a(this);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return MeasureManager.a.C0550a.a(this);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return c0();
    }

    public abstract FrameLayout h0();

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public final void i0() {
        AdPlans adPlans;
        List<AdMaterialList> adMaterialList;
        List<AdMaterialList> adMaterialList2;
        Intent intent = getIntent();
        AdMaterialList adMaterialList3 = null;
        this.f50295d = intent != null ? intent.getStringExtra(TrackingKey.SCENE_ID) : null;
        Intent intent2 = getIntent();
        this.f50294c = intent2 != null ? intent2.getIntExtra("app_layout_id", 0) : 0;
        if (Build.VERSION.SDK_INT >= 33) {
            Intent intent3 = getIntent();
            if (intent3 != null) {
                adPlans = (AdPlans) intent3.getParcelableExtra("ad_plan", AdPlans.class);
            } else {
                adPlans = null;
            }
        } else {
            Intent intent4 = getIntent();
            if (intent4 != null) {
                adPlans = (AdPlans) intent4.getParcelableExtra("ad_plan");
            } else {
                adPlans = null;
            }
        }
        this.f50292a = adPlans;
        if (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null || !(!adMaterialList.isEmpty())) {
            return;
        }
        AdPlans adPlans2 = this.f50292a;
        if (adPlans2 != null && (adMaterialList2 = adPlans2.getAdMaterialList()) != null) {
            adMaterialList3 = adMaterialList2.get(0);
        }
        this.f50293b = adMaterialList3;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    public abstract void j0();

    public final void k0() {
        getOnBackPressedDispatcher().i(this, new a());
    }

    public void l0(int i11, String str) {
        n.a.b(this, i11, str);
    }

    public abstract void o0(int i11);

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(g0());
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
        i0();
        if (Y() == null || TextUtils.isEmpty(f0())) {
            finish();
            return;
        }
        l0(3, "开始展示广告");
        this.f50300j = a0();
        MeasureManager.f50573a.g(this);
        s0();
        u0();
        k0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f50299i.removeCallbacksAndMessages(null);
        MeasureManager.f50573a.p(this);
        com.transsion.player.orplayer.f fVarE0 = e0();
        if (fVarE0 != null) {
            fVarE0.release();
        }
        p0();
        R();
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        com.transsion.player.orplayer.e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.h(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.j(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.player.orplayer.e.a.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        MbAdVideo video;
        MbAdVideo video2;
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
        String strF0 = f0();
        AdMaterialList adMaterialListX = X();
        String path = null;
        String url = (adMaterialListX == null || (video2 = adMaterialListX.getVideo()) == null) ? null : video2.getUrl();
        AdMaterialList adMaterialListX2 = X();
        if (adMaterialListX2 != null && (video = adMaterialListX2.getVideo()) != null) {
            path = video.getPath();
        }
        l0(6, "errorInfo = " + errorInfo + " -- sceneId = " + strF0 + " --> url = " + url + " --> path = " + path);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
        com.transsion.player.orplayer.f fVarE0 = e0();
        if (fVarE0 != null) {
            fVarE0.play();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        com.transsion.player.orplayer.e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        com.transsion.player.orplayer.f fVarE0;
        if (!z11) {
            com.transsion.player.orplayer.f fVarE1 = e0();
            if (fVarE1 != null) {
                fVarE1.pause();
            }
            p0();
            m0();
            return;
        }
        if (this.f50296f == 0) {
            this.f50296f = SystemClock.elapsedRealtime();
            y0();
        }
        com.transsion.player.orplayer.f fVarE2 = e0();
        if (fVarE2 != null && !fVarE2.isPlaying() && (fVarE0 = e0()) != null) {
            fVarE0.play();
        }
        if (this.f50297g.get()) {
            return;
        }
        this.f50297g.set(true);
        U();
    }

    public final void p0() {
        if (this.f50296f > 0) {
            Intent intent = new Intent(getIntent().getStringExtra("action_display_timestamp"));
            intent.putExtra("ad_plan", Y());
            intent.putExtra("display_timestamp", SystemClock.elapsedRealtime() - this.f50296f);
            u3.a.b(this).d(intent);
            this.f50296f = 0L;
        }
    }

    public final void r0(boolean z11) {
        if (z11) {
            com.transsion.player.orplayer.f fVarE0 = e0();
            if (fVarE0 != null) {
                fVarE0.pause();
            }
            m0();
            return;
        }
        com.transsion.player.orplayer.f fVarE1 = e0();
        if (fVarE1 != null) {
            fVarE1.play();
        }
        y0();
    }

    public abstract void s0();

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    public final void t0() {
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        FrameLayout frameLayoutC0 = c0();
        if (frameLayoutC0 != null) {
            AppCompatImageView appCompatImageView = new AppCompatImageView(this);
            AdMaterialList adMaterialListX = X();
            String path = null;
            if (TextUtils.isEmpty((adMaterialListX == null || (image3 = adMaterialListX.getImage()) == null) ? null : image3.getPath())) {
                RequestManager requestManagerWith = Glide.with((FragmentActivity) this);
                AdMaterialList adMaterialListX2 = X();
                if (adMaterialListX2 != null && (image2 = adMaterialListX2.getImage()) != null) {
                    path = image2.getUrl();
                }
                requestManagerWith.load2(path).into(appCompatImageView);
            } else {
                RequestManager requestManagerWith2 = Glide.with((FragmentActivity) this);
                AdMaterialList adMaterialListX3 = X();
                if (adMaterialListX3 != null && (image = adMaterialListX3.getImage()) != null) {
                    path = image.getPath();
                }
                requestManagerWith2.load2(path).into(appCompatImageView);
            }
            frameLayoutC0.addView(appCompatImageView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void u0() {
        AdMaterialList adMaterialListX = X();
        if (Intrinsics.b(adMaterialListX != null ? adMaterialListX.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
            t0();
        } else {
            n0();
        }
        FrameLayout frameLayoutC0 = c0();
        if (frameLayoutC0 != null) {
            frameLayoutC0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.bidding.base.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbsBiddingActivity.v0(this.f50328a, view);
                }
            });
        }
        w0();
        View viewW = W();
        if (viewW != null) {
            com.transsion.ad.strategy.e.f50608a.a(viewW);
        }
    }

    public final void w0() {
        int i11;
        FrameLayout frameLayoutH0 = h0();
        if (frameLayoutH0 != null) {
            AdMaterialList adMaterialListX = X();
            if (Intrinsics.b(adMaterialListX != null ? adMaterialListX.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
                i11 = 8;
            } else {
                final AppCompatImageView appCompatImageView = new AppCompatImageView(this);
                appCompatImageView.setImageResource(R$mipmap.ad_volumeoff);
                frameLayoutH0.removeAllViews();
                frameLayoutH0.addView(appCompatImageView, -1, -1);
                frameLayoutH0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.bidding.base.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AbsBiddingActivity.x0(this.f50329a, appCompatImageView, view);
                    }
                });
                i11 = 0;
            }
            frameLayoutH0.setVisibility(i11);
        }
    }
}
