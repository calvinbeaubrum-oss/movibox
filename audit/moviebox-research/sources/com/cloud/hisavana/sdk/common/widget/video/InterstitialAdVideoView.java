package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.f0;
import com.cloud.hisavana.sdk.q0;
import com.cloud.hisavana.sdk.z;
import com.google.android.exoplayer2.PlaybackException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class InterstitialAdVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdVideoView f29571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f29572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29573d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q0 f29574f;

    /* JADX INFO: compiled from: source.java */
    public class a implements q0 {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void a() {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.a();
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void b(long j11, long j12, int i11) {
            InterstitialAdVideoView.this.f29572c.setProgress(i11);
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.b(j11, j12, i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void c(boolean z11) {
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void d() {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.d();
            }
            if (InterstitialAdVideoView.this.f29572c.getVisibility() == 8) {
                InterstitialAdVideoView.this.f29572c.setVisibility(0);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void e(boolean z11) {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.e(z11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onComplete() {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.onComplete();
            }
            if (InterstitialAdVideoView.this.f29571b != null && InterstitialAdVideoView.this.f29573d) {
                InterstitialAdVideoView.this.f29571b.repeat();
            }
            if (InterstitialAdVideoView.this.f29572c.getVisibility() == 0) {
                InterstitialAdVideoView.this.f29572c.setVisibility(8);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onIsPlayingChanged(boolean z11) {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.onIsPlayingChanged(z11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onPlayerError(PlaybackException playbackException) {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.onPlayerError(playbackException);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onVideoSizeChanged(int i11, int i12) {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.onVideoSizeChanged(i11, i12);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onVolumeChanged(float f11) {
            if (InterstitialAdVideoView.this.f29574f != null) {
                InterstitialAdVideoView.this.f29574f.onVolumeChanged(f11);
            }
        }
    }

    public InterstitialAdVideoView(@NonNull Context context) {
        this(context, null);
    }

    public InterstitialAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29570a = "NativeAdVideoView";
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_interstitial_ad_video_view, (ViewGroup) this, false);
        removeAllViews();
        addView(viewInflate);
        this.f29571b = (AdVideoView) viewInflate.findViewById(R$id.ad_video);
        this.f29572c = (ProgressBar) viewInflate.findViewById(R$id.ad_progress);
        f();
    }

    public final void f() {
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView == null) {
            return;
        }
        adVideoView.setAdMediaPlayerListener(new a());
    }

    public final /* synthetic */ void g(View view) {
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView != null) {
            adVideoView.openOrCloseVolume();
        }
    }

    public long getDuration() {
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView != null) {
            return adVideoView.getDuration();
        }
        return 0L;
    }

    public void release() {
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView != null) {
            adVideoView.setAdMediaPlayerListener(null);
            this.f29571b.release();
            this.f29571b.removeAllViews();
            removeView(this.f29571b);
            this.f29571b = null;
        }
        q0 q0Var = this.f29574f;
        if (q0Var instanceof f0) {
            ((f0) q0Var).i();
        }
        this.f29574f = null;
    }

    public void seekToPosition(long j11) {
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView != null) {
            adVideoView.seekTo(j11);
        }
    }

    public void setAdMediaPlayerListener(q0 q0Var) {
        this.f29574f = q0Var;
    }

    public void setAutoReset(boolean z11) {
        this.f29573d = z11;
    }

    public void setCompanionSize(String str) {
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView != null) {
            adVideoView.setCompanionSize(str);
        }
    }

    public void setMediaData(String str, AdsDTO adsDTO, boolean z11) {
        z.a().d("NativeAdVideoView", "setMediaData -------------> path = " + str);
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView != null) {
            adVideoView.setMeasureAble(false);
            this.f29571b.setMediaData(adsDTO, str, z11);
        }
    }

    public void setVideoSize(int i11, int i12) {
        AdVideoView adVideoView = this.f29571b;
        if (adVideoView != null) {
            adVideoView.setVideoSize(i11, i12);
        }
    }

    public void setVolumeView(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.widget.video.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f29602a.g(view2);
                }
            });
        }
    }
}
