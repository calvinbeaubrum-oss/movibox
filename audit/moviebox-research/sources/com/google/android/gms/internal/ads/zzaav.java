package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaav implements Choreographer.FrameCallback, Handler.Callback {
    private static final zzaav zzb = new zzaav();
    public volatile long zza = C.TIME_UNSET;
    private final Handler zzc;
    private final HandlerThread zzd;
    private Choreographer zze;
    private int zzf;

    private zzaav() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.zzd = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.zzc = handler;
        handler.sendEmptyMessage(0);
    }

    public static zzaav zza() {
        return zzb;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j11) {
        this.zza = j11;
        Choreographer choreographer = this.zze;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            try {
                this.zze = Choreographer.getInstance();
            } catch (RuntimeException e11) {
                zzff.zzg("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e11);
            }
            return true;
        }
        if (i11 == 1) {
            Choreographer choreographer = this.zze;
            if (choreographer != null) {
                int i12 = this.zzf + 1;
                this.zzf = i12;
                if (i12 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        }
        if (i11 != 2) {
            return false;
        }
        Choreographer choreographer2 = this.zze;
        if (choreographer2 != null) {
            int i13 = this.zzf - 1;
            this.zzf = i13;
            if (i13 == 0) {
                choreographer2.removeFrameCallback(this);
                this.zza = C.TIME_UNSET;
            }
        }
        return true;
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }
}
