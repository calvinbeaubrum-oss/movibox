package com.transsion.ad.middle.banner;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.middle.WrapperAdListener;
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
import com.transsion.player.p006enum.ScaleMode;
import iv.d;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import ov.c;

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
public final class NonBannerView extends FrameLayout implements MeasureManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WrapperAdListener f50407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdPlans f50409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdMaterialList f50410d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f50411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f50413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50414i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f50416b;

        public a(f fVar) {
            this.f50416b = fVar;
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
            com.transsion.ad.a.x(com.transsion.ad.a.f50276a, NonBannerView.this.getClassTag() + " --> playVideo() --> onPlayError() --> errorInfo = " + errorInfo + " -- sceneId = " + NonBannerView.this.f50408b, false, 2, null);
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
            this.f50416b.play();
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
        public void onTracksChange(c cVar) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonBannerView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonBannerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f50408b = "";
    }

    public static final void d(NonBannerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        AdMaterialList adMaterialList = this$0.f50410d;
        String deeplink = adMaterialList != null ? adMaterialList.getDeeplink() : null;
        AdMaterialList adMaterialList2 = this$0.f50410d;
        aVar.a(deeplink, adMaterialList2 != null ? adMaterialList2.getH5Link() : null, this$0.f50409c);
        vq.b bVar = vq.b.f79053a;
        String str = this$0.f50408b;
        AdPlans adPlans = this$0.f50409c;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList3 = this$0.f50410d;
        bVar.a((128 & 1) != 0 ? "" : null, str, id2, 102, adMaterialList3 != null ? adMaterialList3.getId() : null, 1, (128 & 64) != 0 ? false : uq.b.f78633a.a(this$0.f50409c), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this$0.f50409c), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
    }

    public static final void e(NonBannerView this$0, AppCompatImageView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        f fVar = this$0.f50411f;
        if (fVar == null || !fVar.isMute()) {
            f fVar2 = this$0.f50411f;
            if (fVar2 != null) {
                fVar2.setMute(true);
            }
            this_apply.setImageResource(R$mipmap.ad_volumeoff);
            return;
        }
        f fVar3 = this$0.f50411f;
        if (fVar3 != null) {
            fVar3.setMute(false);
        }
        this_apply.setImageResource(R$mipmap.ad_volumeon);
    }

    private final void g() {
        if (this.f50413h > 0) {
            vq.b bVar = vq.b.f79053a;
            String str = this.f50408b;
            AdPlans adPlans = this.f50409c;
            String id2 = adPlans != null ? adPlans.getId() : null;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50413h;
            AdMaterialList adMaterialList = this.f50410d;
            bVar.c((1 & 1) != 0 ? "" : null, str, id2, jCurrentTimeMillis, adMaterialList != null ? adMaterialList.getId() : null, 1, (1 & 64) != 0 ? false : uq.b.f78633a.a(this.f50409c));
            this.f50413h = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = NonBannerView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final void h() {
        NonAdShowedTimesManager.f50524a.c(this.f50409c);
    }

    public final void c() {
        AdTagView adTagView;
        final AppCompatImageView appCompatImageView;
        MeasureManager.f50573a.g(this);
        View viewInflate = LayoutInflater.from(Utils.a()).inflate(R$layout.non_banner_view_root_layout, (ViewGroup) this, false);
        if (viewInflate != null) {
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.banner.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NonBannerView.d(this.f50417a, view);
                }
            });
        }
        AdMaterialList adMaterialList = this.f50410d;
        if (Intrinsics.b(adMaterialList != null ? adMaterialList.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
            i(viewInflate, this.f50410d);
        } else {
            f(viewInflate, this.f50410d);
        }
        if (viewInflate != null && (appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R$id.mute)) != null) {
            appCompatImageView.setVisibility(this.f50412g ? 0 : 8);
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.banner.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NonBannerView.e(this.f50418a, appCompatImageView, view);
                }
            });
        }
        addView(viewInflate);
        if (viewInflate == null || (adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon)) == null) {
            return;
        }
        com.transsion.ad.strategy.e.f50608a.a(adTagView);
    }

    public final void destroy() {
        com.transsion.ad.a.v(com.transsion.ad.a.f50276a, getClassTag() + " --> destroy() --> sceneId = " + this.f50408b, false, 2, null);
        removeAllViews();
        f fVar = this.f50411f;
        if (fVar != null) {
            fVar.release();
        }
        MeasureManager.f50573a.p(this);
        g();
    }

    public final void f(View view, AdMaterialList adMaterialList) {
        FrameLayout frameLayout;
        MbAdVideo video;
        String path;
        MbAdVideo video2;
        String path2;
        MbAdVideo video3;
        String url;
        MbAdVideo video4;
        String url2;
        MbAdVideo video5;
        if (view == null || (frameLayout = (FrameLayout) view.findViewById(R$id.flAdContainer)) == null) {
            return;
        }
        frameLayout.removeAllViews();
        TextureView textureView = new TextureView(frameLayout.getContext());
        frameLayout.addView(textureView);
        Context context = frameLayout.getContext();
        Intrinsics.f(context, "context");
        f fVarA = new f.a(context).b(new d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 94207, null)).a();
        fVarA.setMute(true);
        fVarA.setTextureView(textureView);
        fVarA.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        fVarA.setLooping(true);
        fVarA.setPlayerListener(new a(fVarA));
        this.f50411f = fVarA;
        if (TextUtils.isEmpty((adMaterialList == null || (video5 = adMaterialList.getVideo()) == null) ? null : video5.getPath())) {
            f fVar = this.f50411f;
            if (fVar != null) {
                fVar.setDataSource(new MediaSource((adMaterialList == null || (video4 = adMaterialList.getVideo()) == null || (url2 = video4.getUrl()) == null) ? "" : url2, (adMaterialList == null || (video3 = adMaterialList.getVideo()) == null || (url = video3.getUrl()) == null) ? "" : url, 0, null, null, 28, null));
            }
        } else {
            f fVar2 = this.f50411f;
            if (fVar2 != null) {
                fVar2.setDataSource(new MediaSource((adMaterialList == null || (video2 = adMaterialList.getVideo()) == null || (path2 = video2.getPath()) == null) ? "" : path2, (adMaterialList == null || (video = adMaterialList.getVideo()) == null || (path = video.getPath()) == null) ? "" : path, 0, null, null, 28, null));
            }
        }
        f fVar3 = this.f50411f;
        if (fVar3 != null) {
            fVar3.prepare();
        }
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return MeasureManager.a.C0550a.a(this);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return this;
    }

    public final void i(View view, AdMaterialList adMaterialList) {
        FrameLayout frameLayout;
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        if (view == null || (frameLayout = (FrameLayout) view.findViewById(R$id.flAdContainer)) == null) {
            return;
        }
        frameLayout.removeAllViews();
        ImageView imageView = new ImageView(frameLayout.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String path = null;
        if (TextUtils.isEmpty((adMaterialList == null || (image3 = adMaterialList.getImage()) == null) ? null : image3.getPath())) {
            RequestManager requestManagerWith = Glide.with(frameLayout.getContext());
            if (adMaterialList != null && (image2 = adMaterialList.getImage()) != null) {
                path = image2.getUrl();
            }
            requestManagerWith.load2(path).centerCrop().into(imageView);
        } else {
            RequestManager requestManagerWith2 = Glide.with(frameLayout.getContext());
            if (adMaterialList != null && (image = adMaterialList.getImage()) != null) {
                path = image.getPath();
            }
            requestManagerWith2.load2(path).centerCrop().into(imageView);
        }
        frameLayout.addView(imageView);
    }

    public final void loadAd(String sceneId, AdPlans adPlans, WrapperAdListener wrapperAdListener, boolean z11) {
        List<AdMaterialList> adMaterialList;
        List<AdMaterialList> adMaterialList2;
        Intrinsics.g(sceneId, "sceneId");
        this.f50408b = sceneId;
        this.f50409c = adPlans;
        this.f50407a = wrapperAdListener;
        this.f50412g = z11;
        if (adPlans != null && (adMaterialList = adPlans.getAdMaterialList()) != null && (!adMaterialList.isEmpty())) {
            AdPlans adPlans2 = this.f50409c;
            this.f50410d = (adPlans2 == null || (adMaterialList2 = adPlans2.getAdMaterialList()) == null) ? null : adMaterialList2.get(0);
        }
        com.transsion.ad.a.v(com.transsion.ad.a.f50276a, getClassTag() + " --> loadAd() --> sceneId = " + sceneId, false, 2, null);
        c();
        WrapperAdListener wrapperAdListener2 = this.f50407a;
        if (wrapperAdListener2 != null) {
            wrapperAdListener2.onBannerViewReady(this);
        }
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        f fVar;
        if (!z11) {
            f fVar2 = this.f50411f;
            if (fVar2 != null) {
                fVar2.pause();
            }
            g();
            return;
        }
        if (this.f50413h == 0) {
            this.f50413h = System.currentTimeMillis();
        }
        f fVar3 = this.f50411f;
        if (fVar3 != null && !fVar3.isPlaying() && (fVar = this.f50411f) != null) {
            fVar.play();
        }
        if (this.f50414i) {
            return;
        }
        this.f50414i = true;
        vq.b bVar = vq.b.f79053a;
        String str = this.f50408b;
        AdPlans adPlans = this.f50409c;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList = this.f50410d;
        String id3 = adMaterialList != null ? adMaterialList.getId() : null;
        uq.b.a aVar = uq.b.f78633a;
        bVar.f((128 & 1) != 0 ? "" : null, str, id2, 102, id3, 1, (128 & 64) != 0 ? false : aVar.a(this.f50409c), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50409c), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        com.transsion.ad.a.v(com.transsion.ad.a.f50276a, getClassTag() + " --> Banner 广告展示 --> sceneId = " + this.f50408b + " --> isAdShowLevel = " + aVar.a(this.f50409c), false, 2, null);
        h();
    }
}
