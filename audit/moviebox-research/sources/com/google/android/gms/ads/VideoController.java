package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzfj;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoController {

    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;

    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;

    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();

    @Nullable
    private zzdq zzb;

    @Nullable
    private VideoLifecycleCallbacks zzc;

    /* JADX INFO: compiled from: source.java */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z11) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @KeepForSdk
    public int getPlaybackState() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return 0;
            }
            try {
                return zzdqVar.zzh();
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call getPlaybackState on video controller.", e11);
                return 0;
            }
        }
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z11;
        synchronized (this.zza) {
            z11 = this.zzb != null;
        }
        return z11;
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return false;
            }
            try {
                return zzdqVar.zzo();
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call isClickToExpandEnabled.", e11);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return false;
            }
            try {
                return zzdqVar.zzp();
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call isUsingCustomPlayerControls.", e11);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return true;
            }
            try {
                return zzdqVar.zzq();
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call isMuted on video controller.", e11);
                return true;
            }
        }
    }

    public void mute(boolean z11) {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzj(z11);
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call mute on video controller.", e11);
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzk();
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call pause on video controller.", e11);
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzl();
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call play on video controller.", e11);
            }
        }
    }

    public void setVideoLifecycleCallbacks(@Nullable VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfj zzfjVar;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            if (videoLifecycleCallbacks == null) {
                zzfjVar = null;
            } else {
                try {
                    zzfjVar = new zzfj(videoLifecycleCallbacks);
                } catch (RemoteException e11) {
                    zzcec.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e11);
                }
            }
            zzdqVar.zzm(zzfjVar);
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzn();
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call stop on video controller.", e11);
            }
        }
    }

    @Nullable
    public final zzdq zza() {
        zzdq zzdqVar;
        synchronized (this.zza) {
            zzdqVar = this.zzb;
        }
        return zzdqVar;
    }

    public final void zzb(@Nullable zzdq zzdqVar) {
        synchronized (this.zza) {
            try {
                this.zzb = zzdqVar;
                VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
                if (videoLifecycleCallbacks != null) {
                    setVideoLifecycleCallbacks(videoLifecycleCallbacks);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
