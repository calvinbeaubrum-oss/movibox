package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NativeAdVideoView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdVideoView f29578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f29579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f29580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f29581d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f29582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f29583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f29584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q0 f29585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f29586j;

    /* JADX INFO: compiled from: source.java */
    public class a implements q0 {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void a() {
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.a();
            }
            if (NativeAdVideoView.this.f29579b.getVisibility() == 8) {
                NativeAdVideoView.this.f29579b.setVisibility(0);
            }
            if (NativeAdVideoView.this.f29580c.getVisibility() == 8) {
                NativeAdVideoView.this.f29580c.setVisibility(0);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void b(long j11, long j12, int i11) {
            NativeAdVideoView.this.f29582f.setProgress(i11);
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.b(j11, j12, i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void c(boolean z11) {
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.c(z11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void d() {
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.d();
            }
            if (NativeAdVideoView.this.f29583g) {
                if (NativeAdVideoView.this.f29578a == null || !NativeAdVideoView.this.f29578a.isPlayWhenReady()) {
                    if (NativeAdVideoView.this.f29581d.getVisibility() == 8) {
                        NativeAdVideoView.this.f29581d.setVisibility(0);
                    }
                } else if (NativeAdVideoView.this.f29581d.getVisibility() == 0) {
                    NativeAdVideoView.this.f29581d.setVisibility(8);
                }
                if (NativeAdVideoView.this.f29582f.getVisibility() == 8) {
                    NativeAdVideoView.this.f29582f.setVisibility(0);
                }
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void e(boolean z11) {
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.e(z11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onComplete() {
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.onComplete();
            }
            if (NativeAdVideoView.this.f29584h) {
                if (NativeAdVideoView.this.f29578a != null) {
                    NativeAdVideoView.this.f29578a.repeat();
                }
            } else if (NativeAdVideoView.this.f29578a != null) {
                NativeAdVideoView.this.f29578a.setCompanionViewVisibility(0);
            }
            if (NativeAdVideoView.this.f29583g && !NativeAdVideoView.this.f29584h) {
                if (NativeAdVideoView.this.f29581d.getVisibility() == 8) {
                    NativeAdVideoView.this.f29581d.setVisibility(0);
                }
                if (NativeAdVideoView.this.f29579b.getVisibility() == 0) {
                    NativeAdVideoView.this.f29579b.setVisibility(8);
                }
                if (NativeAdVideoView.this.f29580c.getVisibility() == 0) {
                    NativeAdVideoView.this.f29580c.setVisibility(8);
                }
                if (NativeAdVideoView.this.f29582f.getVisibility() == 0) {
                    NativeAdVideoView.this.f29582f.setVisibility(8);
                }
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onIsPlayingChanged(boolean z11) {
            ImageView imageView;
            int i11;
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.onIsPlayingChanged(z11);
            }
            if (NativeAdVideoView.this.f29583g) {
                if (z11) {
                    imageView = NativeAdVideoView.this.f29581d;
                    i11 = 8;
                } else {
                    imageView = NativeAdVideoView.this.f29581d;
                    i11 = 0;
                }
                imageView.setVisibility(i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onPlayerError(PlaybackException playbackException) {
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.onPlayerError(playbackException);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onVideoSizeChanged(int i11, int i12) {
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.onVideoSizeChanged(i11, i12);
            }
        }

        @Override // com.cloud.hisavana.sdk.q0
        public void onVolumeChanged(float f11) {
            ImageView imageView;
            int i11;
            if (NativeAdVideoView.this.f29585i != null) {
                NativeAdVideoView.this.f29585i.onVolumeChanged(f11);
            }
            if (NativeAdVideoView.this.f29583g) {
                if (f11 == 0.0f) {
                    imageView = NativeAdVideoView.this.f29579b;
                    i11 = R$drawable.hisavana_volume_close;
                } else {
                    imageView = NativeAdVideoView.this.f29579b;
                    i11 = R$drawable.hisavana_volume_open;
                }
                imageView.setImageResource(i11);
            }
        }
    }

    public NativeAdVideoView(@NonNull Context context) {
        this(context, null);
    }

    public NativeAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29583g = true;
        this.f29586j = false;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_native_ad_video_view, (ViewGroup) this, false);
        removeAllViews();
        addView(viewInflate);
        this.f29578a = (AdVideoView) viewInflate.findViewById(R$id.ad_video);
        this.f29579b = (ImageView) viewInflate.findViewById(R$id.im_volume);
        this.f29580c = (ImageView) viewInflate.findViewById(R$id.im_repeat);
        this.f29581d = (ImageView) viewInflate.findViewById(R$id.im_play);
        this.f29582f = (ProgressBar) viewInflate.findViewById(R$id.ad_progress);
        j();
        i();
    }

    public final void i() {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView == null) {
            return;
        }
        adVideoView.setAdMediaPlayerListener(new a());
    }

    public void j() {
        this.f29579b.setOnClickListener(this);
        this.f29580c.setOnClickListener(this);
        this.f29580c.setVisibility(8);
        this.f29579b.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdVideoView adVideoView;
        if (view.getId() == R$id.ad_video) {
            z.a().d("NativeAdVideoView", "onClick ad_video ");
            AdVideoView adVideoView2 = this.f29578a;
            if (adVideoView2 == null || !this.f29586j) {
                return;
            }
            adVideoView2.dispatchPlayPause();
            return;
        }
        if (view.getId() == R$id.im_repeat) {
            AdVideoView adVideoView3 = this.f29578a;
            if (adVideoView3 != null) {
                adVideoView3.repeat();
                return;
            }
            return;
        }
        if (view.getId() != R$id.im_volume || (adVideoView = this.f29578a) == null) {
            return;
        }
        adVideoView.openOrCloseVolume();
    }

    public void pause() {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.pause();
        }
    }

    public void play() {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.play();
        }
    }

    public void release() {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.setAdMediaPlayerListener(null);
            this.f29578a.release();
            this.f29578a.removeAllViews();
            removeView(this.f29578a);
            this.f29578a = null;
        }
        q0 q0Var = this.f29585i;
        if (q0Var instanceof f0) {
            ((f0) q0Var).i();
        }
        this.f29585i = null;
    }

    public void setAdMediaPlayerListener(q0 q0Var) {
        this.f29585i = q0Var;
    }

    public void setAutoReset(boolean z11) {
        this.f29584h = z11;
    }

    public void setCompanionSize(String str) {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.setCompanionSize(str);
        }
    }

    public void setFullScreenAd(boolean z11) {
        this.f29586j = z11;
        z.a().d("NativeAdVideoView", "setFullScreenAd " + z11);
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView == null || !z11) {
            return;
        }
        adVideoView.setOnClickListener(this);
    }

    public void setMediaData(String str, AdsDTO adsDTO) {
        z.a().d("NativeAdVideoView", "setMediaData -------------> path = " + str);
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.setMediaData(adsDTO, str, AdManager.j());
        }
    }

    public void setPlayWhenReady(boolean z11) {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.setPlayWhenReady(z11);
        }
    }

    public void setShowComponents(boolean z11) {
        this.f29583g = z11;
    }

    public void setUseCache(boolean z11) {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.setUseCache(z11);
        }
    }

    public void setUseListMode(boolean z11) {
        AdVideoView adVideoView = this.f29578a;
        if (adVideoView != null) {
            adVideoView.setUseListMode(z11);
        }
    }
}
