package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaao {
    private final zzaan zza;
    private final zzaaw zzb;
    private boolean zzc;
    private long zzf;
    private int zzd = 0;
    private long zze = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzi = 1.0f;
    private zzel zzj = zzel.zza;

    public zzaao(Context context, zzaan zzaanVar, long j11) {
        this.zza = zzaanVar;
        this.zzb = new zzaaw(context);
    }

    private final void zzq(int i11) {
        this.zzd = Math.min(this.zzd, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if (r20.zza.zzb(r1, r6) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if (r23 >= r27) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
    
        if (r20.zzc != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(long j11, long j12, long j13, long j14, boolean z11, zzaam zzaamVar) throws zziz {
        zzaam.zzg(zzaamVar);
        if (this.zze == C.TIME_UNSET) {
            this.zze = j12;
        }
        if (this.zzg != j11) {
            this.zzb.zzd(j11);
            this.zzg = j11;
        }
        long jZzq = (long) ((j11 - j12) / ((double) this.zzi));
        if (this.zzc) {
            jZzq -= zzfy.zzq(SystemClock.elapsedRealtime()) - j13;
        }
        zzaamVar.zza = jZzq;
        long j15 = zzaamVar.zza;
        if (this.zzh == C.TIME_UNSET) {
            int i11 = this.zzd;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            throw new IllegalStateException();
                        }
                        long jZzq2 = zzfy.zzq(SystemClock.elapsedRealtime()) - this.zzf;
                        if (this.zzc) {
                        }
                    }
                }
                return 0;
            }
        }
        if (!this.zzc || j12 == this.zze) {
            return 5;
        }
        zzaaw zzaawVar = this.zzb;
        long jNanoTime = System.nanoTime();
        zzaamVar.zzb = zzaawVar.zza((zzaamVar.zza * 1000) + jNanoTime);
        zzaamVar.zza = (zzaamVar.zzb - jNanoTime) / 1000;
        boolean z12 = this.zzh != C.TIME_UNSET;
        if (this.zza.zzc(zzaamVar.zza, j12, j13, z11, z12)) {
            return 4;
        }
        if (this.zza.zza(zzaamVar.zza, j13, z11)) {
            return z12 ? 3 : 2;
        }
        return zzaamVar.zza > 50000 ? 5 : 1;
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc() {
        this.zzh = C.TIME_UNSET;
    }

    public final void zzd() {
        zzq(0);
    }

    public final void zze(boolean z11) {
        this.zzd = z11 ? 1 : 0;
    }

    public final void zzf() {
        zzq(2);
    }

    public final void zzg() {
        this.zzc = true;
        this.zzf = zzfy.zzq(SystemClock.elapsedRealtime());
        this.zzb.zzg();
    }

    public final void zzh() {
        this.zzc = false;
        this.zzh = C.TIME_UNSET;
        this.zzb.zzh();
    }

    public final void zzi() {
        this.zzb.zzf();
        this.zzg = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        zzq(1);
        this.zzh = C.TIME_UNSET;
    }

    public final void zzj(int i11) {
        this.zzb.zzj(i11);
    }

    public final void zzk(zzel zzelVar) {
        this.zzj = zzelVar;
    }

    public final void zzl(float f11) {
        this.zzb.zzc(f11);
    }

    public final void zzm(@Nullable Surface surface) {
        this.zzb.zzi(surface);
        zzq(1);
    }

    public final void zzn(float f11) {
        this.zzi = f11;
        this.zzb.zze(f11);
    }

    public final boolean zzo(boolean z11) {
        boolean z12 = true;
        if (z11 && this.zzd == 3) {
            this.zzh = C.TIME_UNSET;
        } else {
            if (this.zzh == C.TIME_UNSET) {
                return false;
            }
            if (SystemClock.elapsedRealtime() >= this.zzh) {
                z12 = false;
                this.zzh = C.TIME_UNSET;
            }
        }
        return z12;
    }

    public final boolean zzp() {
        int i11 = this.zzd;
        this.zzd = 3;
        this.zzf = zzfy.zzq(SystemClock.elapsedRealtime());
        return i11 != 3;
    }
}
