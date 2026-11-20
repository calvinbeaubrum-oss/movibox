package com.transsion.ad.middle.nativead;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.middle.WrapperAdListener;
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
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.s;
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
public final class BuyOutNativeView extends FrameLayout implements MeasureManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f50476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdPlans f50479d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdMaterialList f50480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f50481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f50482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WrapperAdListener f50483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f50484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50485k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f50487b;

        public a(f fVar) {
            this.f50487b = fVar;
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
            com.transsion.ad.a.f50276a.I(a.class.getSimpleName() + " --> playVideo() --> onPlayError() --> errorInfo = " + errorInfo + " -- sceneId = " + BuyOutNativeView.this.f50478c, false);
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
            this.f50487b.play();
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BuyOutNativeView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BuyOutNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyOutNativeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f50476a = true;
        this.f50477b = true;
    }

    private final void d() {
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        AdMaterialList adMaterialList = this.f50480f;
        String deeplink = adMaterialList != null ? adMaterialList.getDeeplink() : null;
        AdMaterialList adMaterialList2 = this.f50480f;
        aVar.a(deeplink, adMaterialList2 != null ? adMaterialList2.getH5Link() : null, this.f50479d);
        com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
        String simpleName = BuyOutNativeView.class.getSimpleName();
        String str = this.f50478c;
        uq.b.a aVar3 = uq.b.f78633a;
        aVar2.I(simpleName + " --> 广告点击了 --> sceneId = " + str + " --> isAdShowFinal = " + aVar3.a(this.f50479d), false);
        vq.b bVar = vq.b.f79053a;
        String str2 = this.f50478c;
        AdPlans adPlans = this.f50479d;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList3 = this.f50480f;
        bVar.a((128 & 1) != 0 ? "" : null, str2, id2, 102, adMaterialList3 != null ? adMaterialList3.getId() : null, 2, (128 & 64) != 0 ? false : aVar3.a(this.f50479d), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50479d), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        WrapperAdListener wrapperAdListener = this.f50483i;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(102);
        }
    }

    private final void e() {
        f fVar = this.f50481g;
        if (fVar != null) {
            fVar.pause();
        }
        i();
    }

    private final void f() {
        f fVar;
        if (this.f50484j == 0) {
            this.f50484j = System.currentTimeMillis();
        }
        f fVar2 = this.f50481g;
        if (fVar2 != null && !fVar2.isPlaying() && (fVar = this.f50481g) != null) {
            fVar.play();
        }
        if (this.f50485k) {
            return;
        }
        this.f50485k = true;
        vq.b bVar = vq.b.f79053a;
        String str = this.f50478c;
        AdPlans adPlans = this.f50479d;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList = this.f50480f;
        String id3 = adMaterialList != null ? adMaterialList.getId() : null;
        uq.b.a aVar = uq.b.f78633a;
        bVar.f((128 & 1) != 0 ? "" : null, str, id2, 102, id3, 2, (128 & 64) != 0 ? false : aVar.a(this.f50479d), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50479d), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        com.transsion.ad.a.f50276a.I(BuyOutNativeView.class.getSimpleName() + " --> 广告展示 --> sceneId = " + this.f50478c + " --> isAdShowFinal = " + aVar.a(this.f50479d), false);
        j();
    }

    private final String getClassTag() {
        String simpleName = BuyOutNativeView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public static final void h(FrameLayout this_apply, BuyOutNativeView this$0, ImageView imageView, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(imageView, "$imageView");
        com.transsion.ad.a.f50276a.I(this_apply.getClass().getSimpleName() + " --> playVideo() --> 点击了音频按钮", false);
        boolean z11 = this$0.f50476a ^ true;
        this$0.f50476a = z11;
        f fVar = this$0.f50481g;
        if (fVar != null) {
            fVar.setMute(z11);
        }
        this$0.setVolumeImage(imageView);
    }

    private final void i() {
        if (this.f50484j > 0) {
            vq.b bVar = vq.b.f79053a;
            String str = this.f50478c;
            AdPlans adPlans = this.f50479d;
            String id2 = adPlans != null ? adPlans.getId() : null;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50484j;
            AdMaterialList adMaterialList = this.f50480f;
            bVar.c((1 & 1) != 0 ? "" : null, str, id2, jCurrentTimeMillis, adMaterialList != null ? adMaterialList.getId() : null, 2, (1 & 64) != 0 ? false : uq.b.f78633a.a(this.f50479d));
            this.f50484j = 0L;
        }
    }

    private final void j() {
        NonAdShowedTimesManager.f50524a.c(this.f50479d);
    }

    public static final void l(BuyOutNativeView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.d();
    }

    public static final void m(BuyOutNativeView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.d();
    }

    private final void setVolumeImage(ImageView imageView) {
        if (this.f50476a) {
            imageView.setImageResource(R$mipmap.ad_volumeoff);
        } else {
            imageView.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    public final void bindNativeView(String str, AdPlans adPlans, ViewBinder viewBinder, boolean z11, boolean z12) {
        this.f50476a = z11;
        this.f50477b = z12;
        this.f50478c = str;
        if (adPlans == null || viewBinder == null) {
            return;
        }
        View viewInflate = viewBinder.layout;
        if (viewInflate == null) {
            viewInflate = LayoutInflater.from(getContext()).inflate(viewBinder.layoutId, (ViewGroup) this, false);
        }
        k(viewInflate, adPlans, viewBinder);
        addView(viewInflate);
        MeasureManager.f50573a.g(this);
    }

    public final void destroy() {
        com.transsion.ad.a.f50276a.I(getClassTag() + " --> destroy() --> sceneId = " + this.f50478c + " --> isAdShowFinal = " + uq.b.f78633a.a(this.f50479d), false);
        removeAllViews();
        f fVar = this.f50481g;
        if (fVar != null) {
            fVar.release();
        }
        MeasureManager.f50573a.p(this);
        this.f50483i = null;
        i();
    }

    public final void enableBgBlur(Boolean bool) {
        this.f50482h = bool;
    }

    public final void g(View view, ViewBinder viewBinder, AdMaterialList adMaterialList) {
        final FrameLayout frameLayout;
        MbAdVideo video;
        String path;
        MbAdVideo video2;
        String path2;
        MbAdVideo video3;
        String url;
        MbAdVideo video4;
        String url2;
        MbAdVideo video5;
        if (view == null || (frameLayout = (FrameLayout) view.findViewById(viewBinder.mediaId)) == null) {
            return;
        }
        frameLayout.removeAllViews();
        TextureView textureView = new TextureView(frameLayout.getContext());
        frameLayout.addView(textureView);
        if (this.f50477b) {
            final ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setTag("adVolumeImage");
            setVolumeImage(imageView);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f0.a(24.0f), f0.a(24.0f));
            layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
            layoutParams.topMargin = f0.a(8.0f);
            layoutParams.setMarginEnd(f0.a(8.0f));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.nativead.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BuyOutNativeView.h(frameLayout, this, imageView, view2);
                }
            });
            frameLayout.addView(imageView, layoutParams);
        }
        Context context = frameLayout.getContext();
        Intrinsics.f(context, "context");
        f fVarA = new f.a(context).b(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 94207, null)).a();
        fVarA.setMute(this.f50476a);
        fVarA.setTextureView(textureView);
        fVarA.setLooping(true);
        fVarA.setPlayerListener(new a(fVarA));
        this.f50481g = fVarA;
        if (TextUtils.isEmpty((adMaterialList == null || (video5 = adMaterialList.getVideo()) == null) ? null : video5.getPath())) {
            f fVar = this.f50481g;
            if (fVar != null) {
                fVar.setDataSource(new MediaSource((adMaterialList == null || (video4 = adMaterialList.getVideo()) == null || (url2 = video4.getUrl()) == null) ? "" : url2, (adMaterialList == null || (video3 = adMaterialList.getVideo()) == null || (url = video3.getUrl()) == null) ? "" : url, 0, null, null, 28, null));
            }
        } else {
            f fVar2 = this.f50481g;
            if (fVar2 != null) {
                fVar2.setDataSource(new MediaSource((adMaterialList == null || (video2 = adMaterialList.getVideo()) == null || (path2 = video2.getPath()) == null) ? "" : path2, (adMaterialList == null || (video = adMaterialList.getVideo()) == null || (path = video.getPath()) == null) ? "" : path, 0, null, null, 28, null));
            }
        }
        f fVar3 = this.f50481g;
        if (fVar3 != null) {
            fVar3.prepare();
        }
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return 10.0d;
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return this;
    }

    public final void k(View view, AdPlans adPlans, ViewBinder viewBinder) {
        FrameLayout frameLayout;
        TextView textView;
        AdMaterialList adMaterialList;
        TextView textView2;
        TextView textView3;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && activity.isDestroyed()) {
            com.transsion.ad.a.f50276a.I(BuyOutNativeView.class.getSimpleName() + " --> 当前Activity销毁，广告就不需要展示了", false);
            return;
        }
        List<AdMaterialList> adMaterialList2 = adPlans.getAdMaterialList();
        this.f50480f = adMaterialList2 != null ? adMaterialList2.get(0) : null;
        this.f50479d = adPlans;
        if (view != null && (textView3 = (TextView) view.findViewById(viewBinder.titleId)) != null) {
            AdMaterialList adMaterialList3 = this.f50480f;
            textView3.setText(adMaterialList3 != null ? adMaterialList3.getTitle() : null);
        }
        if (view != null && (textView2 = (TextView) view.findViewById(viewBinder.descriptionId)) != null) {
            AdMaterialList adMaterialList4 = this.f50480f;
            textView2.setText(adMaterialList4 != null ? adMaterialList4.getDesc() : null);
        }
        if (view != null && (textView = (TextView) view.findViewById(viewBinder.callToActionId)) != null) {
            AdMaterialList adMaterialList5 = this.f50480f;
            if (TextUtils.isEmpty(adMaterialList5 != null ? adMaterialList5.getButtonText() : null) && (adMaterialList = this.f50480f) != null) {
                adMaterialList.setButtonText("GO");
            }
            AdMaterialList adMaterialList6 = this.f50480f;
            textView.setText(adMaterialList6 != null ? adMaterialList6.getButtonText() : null);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.nativead.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BuyOutNativeView.l(this.f50488a, view2);
                }
            });
        }
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.nativead.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BuyOutNativeView.m(this.f50489a, view2);
                }
            });
        }
        if (view != null && (frameLayout = (FrameLayout) view.findViewById(viewBinder.iconId)) != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if (TextUtils.isEmpty(adPlans.getAdvertiserAvatarPath())) {
                Glide.with(frameLayout.getContext()).load2(adPlans.getAdvertiserAvatar()).fitCenter().into(imageView);
            } else {
                Glide.with(frameLayout.getContext()).load2(adPlans.getAdvertiserAvatarPath()).fitCenter().into(imageView);
            }
            frameLayout.addView(imageView);
        }
        AdMaterialList adMaterialList7 = this.f50480f;
        if (Intrinsics.b(adMaterialList7 != null ? adMaterialList7.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
            n(view, viewBinder, this.f50480f);
        } else {
            g(view, viewBinder, this.f50480f);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    public final void n(View view, ViewBinder viewBinder, AdMaterialList adMaterialList) {
        FrameLayout frameLayout;
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        MbAdImage image4;
        String path;
        MbAdImage image5;
        MbAdImage image6;
        if (view == null || (frameLayout = (FrameLayout) view.findViewById(viewBinder.mediaId)) == null) {
            return;
        }
        frameLayout.removeAllViews();
        String path2 = null;
        if (Intrinsics.b(this.f50482h, Boolean.TRUE)) {
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (TextUtils.isEmpty((adMaterialList == null || (image6 = adMaterialList.getImage()) == null) ? null : image6.getPath())) {
                if (adMaterialList == null || (image5 = adMaterialList.getImage()) == null) {
                    path = null;
                } else {
                    path = image5.getUrl();
                }
            } else if (adMaterialList == null || (image4 = adMaterialList.getImage()) == null) {
                path = null;
            } else {
                path = image4.getPath();
            }
            Glide.with(frameLayout.getContext()).load2(path).transform(new yq.a(25)).into(imageView);
            frameLayout.addView(imageView);
        }
        ImageView imageView2 = new ImageView(frameLayout.getContext());
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (TextUtils.isEmpty((adMaterialList == null || (image3 = adMaterialList.getImage()) == null) ? null : image3.getPath())) {
            if (adMaterialList != null && (image2 = adMaterialList.getImage()) != null) {
                path2 = image2.getUrl();
            }
        } else if (adMaterialList != null && (image = adMaterialList.getImage()) != null) {
            path2 = image.getPath();
        }
        Glide.with(frameLayout.getContext()).load2(path2).into(imageView2);
        frameLayout.addView(imageView2);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        if (z11) {
            f();
        } else {
            e();
        }
    }

    public final void setCallback(WrapperAdListener wrapperAdListener) {
        this.f50483i = wrapperAdListener;
    }
}
