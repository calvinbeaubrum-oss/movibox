package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import f4.y0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzqs {
    public final zzam zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzdq zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;
    public final boolean zzl = false;

    public zzqs(zzam zzamVar, int i11, int i12, int i13, int i14, int i15, int i16, int i17, zzdq zzdqVar, boolean z11, boolean z12, boolean z13) {
        this.zza = zzamVar;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = i15;
        this.zzg = i16;
        this.zzh = i17;
        this.zzi = zzdqVar;
    }

    public final AudioTrack zza(zzk zzkVar, int i11) throws zzpx {
        AudioTrack audioTrack;
        try {
            if (zzfy.zza >= 29) {
                AudioFormat audioFormatZzv = zzfy.zzv(this.zze, this.zzf, this.zzg);
                AudioAttributes audioAttributes = zzkVar.zza().zza;
                l.a();
                audioTrack = y0.a().setAudioAttributes(audioAttributes).setAudioFormat(audioFormatZzv).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i11).setOffloadedPlayback(this.zzc == 1).build();
            } else {
                audioTrack = new AudioTrack(zzkVar.zza().zza, zzfy.zzv(this.zze, this.zzf, this.zzg), this.zzh, 1, i11);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzpx(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), null);
        } catch (IllegalArgumentException e11) {
            e = e11;
            throw new zzpx(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e);
        } catch (UnsupportedOperationException e12) {
            e = e12;
            throw new zzpx(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e);
        }
    }

    public final zzpv zzb() {
        boolean z11 = this.zzc == 1;
        return new zzpv(this.zzg, this.zze, this.zzf, false, z11, this.zzh);
    }

    public final boolean zzc() {
        return this.zzc == 1;
    }
}
