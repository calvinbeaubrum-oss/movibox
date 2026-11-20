package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zziv implements zzlc {
    private final zzyx zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private final long zzg;
    private int zzh;
    private boolean zzi;

    public zziv() {
        zzyx zzyxVar = new zzyx(true, 65536);
        zzj(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 0, "bufferForPlaybackMs", "0");
        zzj(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzj(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, "minBufferMs", "bufferForPlaybackMs");
        zzj(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", "0");
        this.zzb = zzyxVar;
        this.zzc = zzfy.zzq(50000L);
        this.zzd = zzfy.zzq(50000L);
        this.zze = zzfy.zzq(2500L);
        this.zzf = zzfy.zzq(5000L);
        this.zzh = C.DEFAULT_VIDEO_BUFFER_SIZE;
        this.zzg = zzfy.zzq(0L);
    }

    private static void zzj(int i11, int i12, String str, String str2) {
        zzek.zze(i11 >= i12, str + " cannot be less than " + str2);
    }

    private final void zzk(boolean z11) {
        this.zzh = C.DEFAULT_VIDEO_BUFFER_SIZE;
        this.zzi = false;
        if (z11) {
            this.zzb.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final long zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzb() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzc() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzd() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zze(zzcx zzcxVar, zzur zzurVar, zzmf[] zzmfVarArr, zzws zzwsVar, zzyi[] zzyiVarArr) {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int length = zzmfVarArr.length;
            int i13 = C.DEFAULT_VIDEO_BUFFER_SIZE;
            if (i11 >= 2) {
                int iMax = Math.max(C.DEFAULT_VIDEO_BUFFER_SIZE, i12);
                this.zzh = iMax;
                this.zzb.zzf(iMax);
                return;
            } else {
                if (zzyiVarArr[i11] != null) {
                    if (zzmfVarArr[i11].zzbj() != 1) {
                        i13 = 131072000;
                    }
                    i12 += i13;
                }
                i11++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final boolean zzg(long j11, long j12, float f11) {
        int iZza = this.zzb.zza();
        int i11 = this.zzh;
        long jMin = this.zzc;
        if (f11 > 1.0f) {
            jMin = Math.min(zzfy.zzo(jMin, f11), this.zzd);
        }
        if (j12 < Math.max(jMin, 500000L)) {
            boolean z11 = iZza < i11;
            this.zzi = z11;
            if (!z11 && j12 < 500000) {
                zzff.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.zzd || iZza >= i11) {
            this.zzi = false;
        }
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final boolean zzh(zzcx zzcxVar, zzur zzurVar, long j11, float f11, boolean z11, long j12) {
        long jZzp = zzfy.zzp(j11, f11);
        long jMin = z11 ? this.zzf : this.zze;
        if (j12 != C.TIME_UNSET) {
            jMin = Math.min(j12 / 2, jMin);
        }
        return jMin <= 0 || jZzp >= jMin || this.zzb.zza() >= this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final zzyx zzi() {
        return this.zzb;
    }
}
