package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.f0;
import com.cloud.hisavana.sdk.z;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RewardedVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdVideoView f29589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressBar f29590c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RewardedVideoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RewardedVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RewardedVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f29588a = "Rewarded";
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_interstitial_ad_video_view, this);
        this.f29589b = (AdVideoView) viewInflate.findViewById(R$id.ad_video);
        this.f29590c = (ProgressBar) viewInflate.findViewById(R$id.ad_progress);
    }

    public /* synthetic */ RewardedVideoView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final long getDuration() {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            return adVideoView.getDuration();
        }
        return 0L;
    }

    public final long pause() {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.dispatchPause();
        }
        AdVideoView adVideoView2 = this.f29589b;
        if (adVideoView2 != null) {
            return adVideoView2.getCurrentPosition();
        }
        return 0L;
    }

    public final void release() {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.setAdMediaPlayerListener(null);
        }
        AdVideoView adVideoView2 = this.f29589b;
        if (adVideoView2 != null) {
            adVideoView2.release();
        }
        AdVideoView adVideoView3 = this.f29589b;
        if (adVideoView3 != null) {
            adVideoView3.removeAllViews();
        }
        removeView(this.f29589b);
        this.f29589b = null;
    }

    public final void resume() {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.dispatchPlay();
        }
    }

    public final void seekTo(long j11) {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.seekTo(j11);
        }
    }

    public final void setAdMediaPlayerListener(f0 f0Var) {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.setAdMediaPlayerListener(f0Var);
        }
    }

    public final void setCompanionUrl(String url) {
        Intrinsics.g(url, "url");
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.setCompanionSize(url);
        }
    }

    public final void setMediaData(String path, AdsDTO adsDTO, boolean z11) {
        Intrinsics.g(path, "path");
        z.a().i(this.f29588a, "setMediaData -------------> path = " + path);
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.setMeasureAble(false);
        }
        AdVideoView adVideoView2 = this.f29589b;
        if (adVideoView2 != null) {
            adVideoView2.setMediaData(adsDTO, path, z11);
        }
    }

    public final void setPlayWhenReady(boolean z11) {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView == null) {
            return;
        }
        adVideoView.setPlayWhenReady(z11);
    }

    public final void toggleVolume() {
        AdVideoView adVideoView = this.f29589b;
        if (adVideoView != null) {
            adVideoView.openOrCloseVolume();
        }
    }
}
