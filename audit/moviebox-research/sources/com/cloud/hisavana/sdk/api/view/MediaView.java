package com.cloud.hisavana.sdk.api.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ca.d;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.widget.TAdWebView;
import com.cloud.hisavana.sdk.common.widget.video.NativeAdVideoView;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.f0;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.l;
import com.cloud.sdk.commonutil.widget.TranCircleImageView;
import com.google.android.exoplayer2.PlaybackException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class MediaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranCircleImageView f29139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdImage f29140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NativeAdVideoView f29141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TAdWebView f29142d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f29144g;

    /* JADX INFO: compiled from: source.java */
    public class a extends f0 {
        public a(AdsDTO adsDTO) {
            super(adsDTO);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void a() {
            super.a();
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void b(long j11, long j12, int i11) {
            super.b(j11, j12, i11);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void d() {
            super.d();
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onComplete() {
            super.onComplete();
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onIsPlayingChanged(boolean z11) {
            super.onIsPlayingChanged(z11);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onPlayerError(PlaybackException playbackException) {
            super.onPlayerError(playbackException);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onVideoSizeChanged(int i11, int i12) {
            super.onVideoSizeChanged(i11, i12);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onVolumeChanged(float f11) {
            super.onVolumeChanged(f11);
        }
    }

    public MediaView(@NonNull Context context) {
        this(context, null);
    }

    public MediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29139a = null;
        this.f29140b = null;
        this.f29142d = null;
    }

    public final FrameLayout.LayoutParams a(int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i12);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public final void b(AdsDTO adsDTO, boolean z11) {
        if (this.f29141c == null) {
            NativeAdVideoView nativeAdVideoView = new NativeAdVideoView(getContext());
            this.f29141c = nativeAdVideoView;
            nativeAdVideoView.setAdMediaPlayerListener(new a(adsDTO));
        }
        this.f29141c.setUseListMode(z11);
        if (adsDTO.getDefaultMaterialType() == 2) {
            this.f29141c.setUseCache(false);
        }
        if (indexOfChild(this.f29141c) < 0) {
            addView(this.f29141c, a(-1, -2));
        }
        TranCircleImageView tranCircleImageView = this.f29139a;
        if (tranCircleImageView == null || !(tranCircleImageView.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f29139a.getParent()).removeView(this.f29139a);
        this.f29139a = null;
    }

    public final void c() {
        if (this.f29139a == null) {
            TranCircleImageView tranCircleImageView = new TranCircleImageView(getContext());
            this.f29139a = tranCircleImageView;
            tranCircleImageView.setId(R$id.native_mediaview_iv_id);
        }
        if (indexOfChild(this.f29139a) < 0) {
            addView(this.f29139a, a(-1, -2));
        }
        if (this.f29143f == 2 && this.f29139a.getLayoutParams() != null) {
            this.f29139a.getLayoutParams().height = -2;
        }
        NativeAdVideoView nativeAdVideoView = this.f29141c;
        if (nativeAdVideoView == null || !(nativeAdVideoView.getParent() instanceof ViewGroup)) {
            return;
        }
        this.f29141c.release();
        ((ViewGroup) this.f29141c.getParent()).removeView(this.f29141c);
        this.f29141c = null;
    }

    public void destroy() {
        TAdWebView tAdWebView = this.f29142d;
        if (tAdWebView != null) {
            tAdWebView.destroy();
            this.f29142d = null;
        }
        NativeAdVideoView nativeAdVideoView = this.f29141c;
        if (nativeAdVideoView != null) {
            nativeAdVideoView.release();
        }
        l.a(this.f29139a);
        removeAllViews();
        AdImage adImage = this.f29140b;
        if (adImage != null) {
            adImage.destroy();
        }
    }

    public void init(int i11) {
        this.f29143f = i11;
        if (i11 != 3) {
            c();
        }
    }

    public boolean isAttached() {
        return this.f29144g;
    }

    public void pause() {
        NativeAdVideoView nativeAdVideoView = this.f29141c;
        if (nativeAdVideoView != null) {
            nativeAdVideoView.pause();
        }
    }

    public void play() {
        NativeAdVideoView nativeAdVideoView = this.f29141c;
        if (nativeAdVideoView != null) {
            nativeAdVideoView.play();
        }
    }

    public void setMediaView(AdImage adImage, ImageView.ScaleType scaleType, boolean z11) {
        c();
        TranCircleImageView tranCircleImageView = this.f29139a;
        if (tranCircleImageView == null || scaleType == null) {
            return;
        }
        tranCircleImageView.setAdjustViewBounds(true);
        if (z11) {
            this.f29139a.setMaxWidth(d.k());
            this.f29139a.setMaxHeight(d.j());
        } else {
            this.f29139a.setScaleType(scaleType);
        }
        if (adImage != null) {
            this.f29140b = adImage;
            this.f29144g = adImage.attachView(this.f29139a);
        }
    }

    public void setRadius(float f11, float f12, float f13, float f14) {
        TranCircleImageView tranCircleImageView = this.f29139a;
        if (tranCircleImageView != null) {
            tranCircleImageView.setTopLeftRadius(f11);
            this.f29139a.setTopRightRadius(f12);
            this.f29139a.setBottomLeftRadius(f13);
            this.f29139a.setBottomRightRadius(f14);
            this.f29139a.setCircle((f11 == 0.0f && f12 == 0.0f && f13 == 0.0f && f14 == 0.0f) ? false : true);
            this.f29139a.invalidate();
        }
    }

    public void setVideoView(String str, boolean z11, String str2, AdsDTO adsDTO, boolean z12) {
        b(adsDTO, z12);
        if (TextUtils.isEmpty(str) || this.f29141c == null || adsDTO == null) {
            z.a().e("MediaView", "setVideoView filePath is null or adVideoView is null or adsDTO is null");
            return;
        }
        AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
        if (impBeanRequest != null) {
            z.a().d("MediaView", "init impBean.isAutoPlayVideoAd " + impBeanRequest.isAutoPlayVideoAd);
            this.f29141c.setPlayWhenReady(impBeanRequest.isAutoPlayVideoAd);
        }
        z.a().d("MediaView", "isMaterialStyleValid---->" + z11 + "   materialStyle---->" + str2);
        this.f29141c.setShowComponents(true);
        this.f29141c.setAutoReset(true);
        if (adsDTO.getFullScreenFlag().intValue() == 1) {
            z.a().d("MediaView", "adsDTO.getFullScreenFlag() == 1 ");
            this.f29141c.setFullScreenAd(true);
        }
        if (adsDTO.getVideoInfo() != null && adsDTO.getVideoInfo().getVideoMask() != null) {
            this.f29141c.setCompanionSize(adsDTO.getVideoInfo().getVideoMask().getResource());
        }
        this.f29141c.setMediaData(str, adsDTO);
    }
}
