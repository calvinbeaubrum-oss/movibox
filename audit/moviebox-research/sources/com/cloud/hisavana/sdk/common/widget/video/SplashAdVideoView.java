package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.f0;
import com.cloud.hisavana.sdk.q0;
import com.cloud.hisavana.sdk.z;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SplashAdVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdVideoView f29595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f29596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29597d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q0 f29598f;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SplashAdVideoView.this.f29595b != null) {
                SplashAdVideoView.this.f29595b.openOrCloseVolume();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements q0 {
        public b() {
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void a() {
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.a();
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void b(long j11, long j12, int i11) {
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.b(j11, j12, i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void c(boolean z11) {
            z.a().d("SplashAdVideoView", "onVideoClickToPauseOrPlay isPlay " + z11);
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void d() {
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.d();
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void e(boolean z11) {
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.e(z11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onComplete() {
            if (SplashAdVideoView.this.f29595b != null && SplashAdVideoView.this.f29597d) {
                SplashAdVideoView.this.f29595b.repeat();
            }
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.onComplete();
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onIsPlayingChanged(boolean z11) {
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.onIsPlayingChanged(z11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onPlayerError(PlaybackException playbackException) {
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.onPlayerError(playbackException);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onVideoSizeChanged(int i11, int i12) {
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.onVideoSizeChanged(i11, i12);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onVolumeChanged(float f11) {
            ImageView imageView;
            int i11;
            if (f11 == 0.0f) {
                imageView = SplashAdVideoView.this.f29596c;
                i11 = R$drawable.hisavana_volume_close;
            } else {
                imageView = SplashAdVideoView.this.f29596c;
                i11 = R$drawable.hisavana_volume_open;
            }
            imageView.setImageResource(i11);
            if (SplashAdVideoView.this.f29598f != null) {
                SplashAdVideoView.this.f29598f.onVolumeChanged(f11);
            }
        }
    }

    public SplashAdVideoView(@NonNull Context context) {
        this(context, null);
    }

    public SplashAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplashAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29594a = "SplashAdVideoView";
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_splash_ad_video_view, (ViewGroup) this, false);
        removeAllViews();
        addView(viewInflate);
        this.f29595b = (AdVideoView) viewInflate.findViewById(R$id.ad_video);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.im_volume);
        this.f29596c = imageView;
        imageView.setOnClickListener(new a());
        e();
    }

    public final void e() {
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView == null) {
            return;
        }
        adVideoView.setAdMediaPlayerListener(new b());
    }

    public int getDuration() {
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView != null) {
            return adVideoView.getDuration() > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) this.f29595b.getDuration();
        }
        return 0;
    }

    public int getRemainingDuration() {
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView == null) {
            return 0;
        }
        long duration = adVideoView.getDuration();
        z.a().d("SplashAdVideoView", "getRemainingDuration -------------> duration = " + duration);
        long currentPosition = this.f29595b.getCurrentPosition();
        z.a().d("SplashAdVideoView", "getRemainingDuration -------------> currentDuration = " + currentPosition);
        long j11 = duration - currentPosition;
        z.a().d("SplashAdVideoView", "getRemainingDuration -------------> remainingDuration = " + j11);
        return j11 > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) j11;
    }

    public void pause() {
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView != null) {
            adVideoView.pause();
        }
    }

    public void play() {
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView != null) {
            adVideoView.play();
        }
    }

    public void release() {
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView != null) {
            adVideoView.setAdMediaPlayerListener(null);
            this.f29595b.release();
            this.f29595b.removeAllViews();
            removeView(this.f29595b);
            this.f29595b = null;
        }
        q0 q0Var = this.f29598f;
        if (q0Var instanceof f0) {
            ((f0) q0Var).i();
        }
        this.f29598f = null;
    }

    public void setAdMediaPlayerListener(q0 q0Var) {
        this.f29598f = q0Var;
    }

    public void setAutoReset(boolean z11) {
        this.f29597d = z11;
    }

    public void setCompanionSize(String str, int i11, int i12) {
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView != null) {
            adVideoView.setCompanionSize(str);
        }
    }

    public void setMediaData(String str, AdsDTO adsDTO) {
        z.a().d("SplashAdVideoView", "setMediaData -------------> path = " + str);
        AdVideoView adVideoView = this.f29595b;
        if (adVideoView != null) {
            adVideoView.setPlayWhenReady(true);
            this.f29595b.setMediaData(adsDTO, str, AdManager.j());
        }
    }
}
