package com.transsion.ad.view.native_ad;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.card.MaterialCardView;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.strategy.MeasureManager;
import com.transsion.ad.view.native_ad.AbsBiddingBuyOutView;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p006enum.ScaleMode;
import iv.d;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@Metadata
public abstract class AbsBiddingBuyOutView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f50661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f50662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public jq.a f50664d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdPlans f50665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AdMaterialList f50666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f50667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f50669j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f50671b;

        public a(f fVar) {
            this.f50671b = fVar;
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
            com.transsion.ad.a.z(com.transsion.ad.a.f50276a, AbsBiddingBuyOutView.this.getClassTag() + " --> playVideo() --> onPlayError() --> errorInfo = " + errorInfo + " -- sceneId = " + AbsBiddingBuyOutView.this.getSceneId(), false, 2, null);
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
            this.f50671b.play();
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements MeasureManager.a {
        public b() {
        }

        @Override // com.transsion.ad.strategy.MeasureManager.a
        public double getVisibilityThreshold() {
            return MeasureManager.a.C0550a.a(this);
        }

        @Override // com.transsion.ad.strategy.MeasureManager.a
        public View getVisibilityView() {
            return AbsBiddingBuyOutView.this;
        }

        @Override // com.transsion.ad.strategy.MeasureManager.a
        public void onVisibilityChanged(boolean z11) {
            if (!z11) {
                if (AbsBiddingBuyOutView.this.f50661a > 0) {
                    AbsBiddingBuyOutView.this.c(SystemClock.elapsedRealtime() - AbsBiddingBuyOutView.this.f50661a);
                }
                AbsBiddingBuyOutView.this.f50661a = 0L;
                return;
            }
            if (AbsBiddingBuyOutView.this.f50661a == 0) {
                AbsBiddingBuyOutView.this.f50661a = SystemClock.elapsedRealtime();
            }
            if (AbsBiddingBuyOutView.this.f50662b.get()) {
                return;
            }
            AbsBiddingBuyOutView.this.f50662b.set(true);
            AbsBiddingBuyOutView.this.b();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AbsBiddingBuyOutView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsBiddingBuyOutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f50662b = new AtomicBoolean(false);
        this.f50668i = true;
        b bVar = new b();
        this.f50669j = bVar;
        MeasureManager.f50573a.g(bVar);
    }

    public /* synthetic */ AbsBiddingBuyOutView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void e(FrameLayout this_apply, AbsBiddingBuyOutView this$0, ImageView imageView, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(imageView, "$imageView");
        com.transsion.ad.a.f50276a.I(this_apply.getClass().getSimpleName() + " --> playVideo() --> 点击了音频按钮", false);
        boolean z11 = this$0.f50668i ^ true;
        this$0.f50668i = z11;
        f fVar = this$0.f50667h;
        if (fVar != null) {
            fVar.setMute(z11);
        }
        this$0.setVolumeImage(imageView);
    }

    private final void setVolumeImage(ImageView imageView) {
        if (this.f50668i) {
            imageView.setImageResource(R$mipmap.ad_volumeoff);
        } else {
            imageView.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    public final void b() {
        jq.a listener = getListener();
        if (listener != null) {
            listener.c(getAdPlans());
        }
        NonAdShowedTimesManager.f50524a.c(getAdPlans());
    }

    public final void c(long j11) {
        jq.a listener = getListener();
        if (listener != null) {
            listener.d(this.f50665f, j11);
        }
    }

    public final void d(AdMaterialList adMaterialList) {
        MbAdVideo video;
        String path;
        MbAdVideo video2;
        String path2;
        MbAdVideo video3;
        String url;
        MbAdVideo video4;
        String url2;
        MbAdVideo video5;
        final FrameLayout mediaContainer = getMediaContainer();
        if (mediaContainer != null) {
            mediaContainer.removeAllViews();
            TextureView textureView = new TextureView(mediaContainer.getContext());
            mediaContainer.addView(textureView);
            if (isShowVolumeIcon()) {
                final ImageView imageView = new ImageView(mediaContainer.getContext());
                imageView.setTag("adVolumeImage");
                setVolumeImage(imageView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f0.a(24.0f), f0.a(24.0f));
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
                layoutParams.topMargin = f0.a(8.0f);
                layoutParams.setMarginEnd(f0.a(8.0f));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: zq.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AbsBiddingBuyOutView.e(mediaContainer, this, imageView, view);
                    }
                });
                mediaContainer.addView(imageView, layoutParams);
            }
            Context context = mediaContainer.getContext();
            Intrinsics.f(context, "context");
            f fVarA = new f.a(context).b(new d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 94207, null)).a();
            fVarA.setMute(true);
            fVarA.setTextureView(textureView);
            fVarA.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
            fVarA.setLooping(true);
            fVarA.setPlayerListener(new a(fVarA));
            this.f50667h = fVarA;
            if (TextUtils.isEmpty((adMaterialList == null || (video5 = adMaterialList.getVideo()) == null) ? null : video5.getPath())) {
                f fVar = this.f50667h;
                if (fVar != null) {
                    fVar.setDataSource(new MediaSource((adMaterialList == null || (video4 = adMaterialList.getVideo()) == null || (url2 = video4.getUrl()) == null) ? "" : url2, (adMaterialList == null || (video3 = adMaterialList.getVideo()) == null || (url = video3.getUrl()) == null) ? "" : url, 0, null, null, 28, null));
                }
            } else {
                f fVar2 = this.f50667h;
                if (fVar2 != null) {
                    fVar2.setDataSource(new MediaSource((adMaterialList == null || (video2 = adMaterialList.getVideo()) == null || (path2 = video2.getPath()) == null) ? "" : path2, (adMaterialList == null || (video = adMaterialList.getVideo()) == null || (path = video.getPath()) == null) ? "" : path, 0, null, null, 28, null));
                }
            }
            f fVar3 = this.f50667h;
            if (fVar3 != null) {
                fVar3.prepare();
            }
        }
    }

    public final void destroy() {
        if (this.f50661a > 0) {
            c(SystemClock.elapsedRealtime() - this.f50661a);
        }
        setListener(null);
        removeAllViews();
        this.f50662b.set(false);
        f fVar = this.f50667h;
        if (fVar != null) {
            fVar.release();
        }
    }

    public final void f(AdMaterialList adMaterialList) {
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        FrameLayout mediaContainer = getMediaContainer();
        if (mediaContainer != null) {
            mediaContainer.removeAllViews();
            ImageView imageView = new ImageView(mediaContainer.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String path = null;
            if (TextUtils.isEmpty((adMaterialList == null || (image3 = adMaterialList.getImage()) == null) ? null : image3.getPath())) {
                RequestManager requestManagerWith = Glide.with(mediaContainer.getContext());
                if (adMaterialList != null && (image2 = adMaterialList.getImage()) != null) {
                    path = image2.getUrl();
                }
                requestManagerWith.load(path).centerCrop().into(imageView);
            } else {
                RequestManager requestManagerWith2 = Glide.with(mediaContainer.getContext());
                if (adMaterialList != null && (image = adMaterialList.getImage()) != null) {
                    path = image.getPath();
                }
                requestManagerWith2.load(path).centerCrop().into(imageView);
            }
            mediaContainer.addView(imageView);
        }
    }

    public final AdMaterialList getAdMaterialList() {
        return this.f50666g;
    }

    public final AdPlans getAdPlans() {
        return this.f50665f;
    }

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final jq.a getListener() {
        return this.f50664d;
    }

    public abstract FrameLayout getMediaContainer();

    public final f getOrPlayer() {
        return this.f50667h;
    }

    public final String getSceneId() {
        String str = this.f50663c;
        return str == null ? "" : str;
    }

    public abstract boolean isShowVolumeIcon();

    public final void onAdClick() {
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        AdMaterialList adMaterialList = this.f50666g;
        String deeplink = adMaterialList != null ? adMaterialList.getDeeplink() : null;
        AdMaterialList adMaterialList2 = this.f50666g;
        aVar.a(deeplink, adMaterialList2 != null ? adMaterialList2.getH5Link() : null, this.f50665f);
        jq.a listener = getListener();
        if (listener != null) {
            listener.a(getAdPlans());
        }
    }

    public final void setAdPlans(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        List<AdMaterialList> adMaterialList2;
        this.f50665f = adPlans;
        if (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null || !(!adMaterialList.isEmpty())) {
            return;
        }
        AdPlans adPlans2 = this.f50665f;
        this.f50666g = (adPlans2 == null || (adMaterialList2 = adPlans2.getAdMaterialList()) == null) ? null : adMaterialList2.get(0);
    }

    public final void setListener(jq.a aVar) {
        this.f50664d = aVar;
    }

    public final void setSceneId(String str) {
        this.f50663c = str;
    }

    public final void showMedia() {
        if (getAdMaterialList() == null) {
            return;
        }
        AdMaterialList adMaterialList = getAdMaterialList();
        if (Intrinsics.b(adMaterialList != null ? adMaterialList.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
            f(getAdMaterialList());
        } else {
            d(getAdMaterialList());
        }
    }
}
