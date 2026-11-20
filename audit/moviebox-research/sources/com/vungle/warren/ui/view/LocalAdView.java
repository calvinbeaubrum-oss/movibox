package com.vungle.warren.ui.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.vungle.warren.ui.presenter.LocalAdPresenter;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class LocalAdView extends com.vungle.warren.ui.view.a<LocalAdPresenter> implements b10.d, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b10.c f62485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f62486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MediaPlayer f62487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f62488l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f62489m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler f62490n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FullAdWidget.j f62491o;

    /* JADX INFO: compiled from: source.java */
    public class a implements FullAdWidget.j {
        public a() {
        }

        @Override // com.vungle.warren.ui.view.FullAdWidget.j
        public void a(int i11) {
            if (i11 == 1) {
                LocalAdView.this.f62485i.k();
                return;
            }
            if (i11 == 2) {
                LocalAdView.this.f62485i.b();
                return;
            }
            if (i11 == 3) {
                if (LocalAdView.this.f62487k != null) {
                    LocalAdView.this.p();
                    LocalAdView.this.f62485i.r(LocalAdView.this.f62486j);
                    LocalAdView localAdView = LocalAdView.this;
                    localAdView.f62530f.setMuted(localAdView.f62486j);
                    return;
                }
                return;
            }
            if (i11 == 4) {
                LocalAdView.this.f62485i.d();
            } else if (i11 == 5 && LocalAdView.this.f62488l) {
                LocalAdView.this.f62485i.b();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            String str = LocalAdView.this.f62529d;
            if (LocalAdView.this.f62489m != null) {
                LocalAdView.this.f62490n.removeCallbacks(LocalAdView.this.f62489m);
            }
            LocalAdView.this.f62485i.c(mediaPlayer.getDuration(), mediaPlayer.getDuration());
        }
    }

    public LocalAdView(@NonNull Context context, @NonNull FullAdWidget fullAdWidget, @NonNull a10.e eVar, @NonNull a10.a aVar) {
        super(context, fullAdWidget, eVar, aVar);
        this.f62486j = false;
        this.f62488l = false;
        this.f62490n = new Handler(Looper.getMainLooper());
        this.f62491o = new a();
        o();
    }

    @Override // b10.d
    public int c() {
        return this.f62530f.getCurrentVideoPosition();
    }

    @Override // com.vungle.warren.ui.view.a, b10.a
    public void close() {
        super.close();
        this.f62490n.removeCallbacksAndMessages(null);
    }

    @Override // b10.d
    public boolean d() {
        return this.f62530f.isVideoPlaying();
    }

    @Override // b10.d
    public void e() {
        this.f62530f.pausePlayback();
        Runnable runnable = this.f62489m;
        if (runnable != null) {
            this.f62490n.removeCallbacks(runnable);
        }
    }

    @Override // b10.d
    public void f(@NonNull File file, boolean z11, int i11) {
        this.f62486j = this.f62486j || z11;
        if (file != null) {
            r();
            this.f62530f.playVideo(Uri.fromFile(file), i11);
            this.f62530f.setMuted(this.f62486j);
            boolean z12 = this.f62486j;
            if (z12) {
                this.f62485i.r(z12);
            }
        }
    }

    @Override // b10.d
    public void g(boolean z11, boolean z12) {
        this.f62488l = z12;
        this.f62530f.setCtaEnabled(z11 && z12);
    }

    public final void o() {
        this.f62530f.setOnItemClickListener(this.f62491o);
        this.f62530f.setOnPreparedListener(this);
        this.f62530f.setOnErrorListener(this);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(30);
        if (i11 == 1) {
            sb2.append("MEDIA_ERROR_UNKNOWN");
        } else if (i11 != 100) {
            sb2.append("UNKNOWN");
        } else {
            sb2.append("MEDIA_ERROR_SERVER_DIED");
        }
        sb2.append(':');
        if (i12 == -1010) {
            sb2.append("MEDIA_ERROR_UNSUPPORTED");
        } else if (i12 == -1007) {
            sb2.append("MEDIA_ERROR_MALFORMED");
        } else if (i12 == -1004) {
            sb2.append("MEDIA_ERROR_IO");
        } else if (i12 == -110) {
            sb2.append("MEDIA_ERROR_TIMED_OUT");
        } else if (i12 != 200) {
            sb2.append("MEDIA_ERROR_SYSTEM");
        } else {
            sb2.append("MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK");
        }
        this.f62485i.q(sb2.toString());
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f62487k = mediaPlayer;
        s();
        this.f62530f.setOnCompletionListener(new b());
        this.f62485i.h(c(), mediaPlayer.getDuration());
        r();
    }

    public final void p() {
        if (this.f62487k == null) {
            return;
        }
        this.f62486j = !this.f62486j;
        s();
    }

    @Override // b10.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void setPresenter(@NonNull LocalAdPresenter localAdPresenter) {
        this.f62485i = localAdPresenter;
    }

    public final void r() {
        Runnable runnable = new Runnable() { // from class: com.vungle.warren.ui.view.LocalAdView.2
            float duration = -2.0f;

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (LocalAdView.this.f62530f.isVideoPlaying()) {
                        int currentVideoPosition = LocalAdView.this.f62530f.getCurrentVideoPosition();
                        int videoDuration = LocalAdView.this.f62530f.getVideoDuration();
                        if (videoDuration > 0) {
                            if (this.duration == -2.0f) {
                                this.duration = videoDuration;
                            }
                            LocalAdView.this.f62485i.c(currentVideoPosition, this.duration);
                            LocalAdView.this.f62530f.setProgress(currentVideoPosition, this.duration);
                        }
                    }
                    LocalAdView.this.f62490n.postDelayed(this, 1000L);
                } catch (IllegalStateException unused) {
                    Log.v(LocalAdView.this.f62529d, "IllegalStateException while reporting progress indicates activity was killed via SIGKILL.");
                }
            }
        };
        this.f62489m = runnable;
        this.f62490n.post(runnable);
    }

    public final void s() {
        MediaPlayer mediaPlayer = this.f62487k;
        if (mediaPlayer != null) {
            try {
                float f11 = this.f62486j ? 0.0f : 1.0f;
                mediaPlayer.setVolume(f11, f11);
            } catch (IllegalStateException unused) {
            }
        }
    }

    @Override // b10.a
    public void showWebsite(@NonNull String str) {
        this.f62530f.stopPlayback();
        this.f62530f.showWebsite(str);
        this.f62490n.removeCallbacks(this.f62489m);
        this.f62487k = null;
    }
}
