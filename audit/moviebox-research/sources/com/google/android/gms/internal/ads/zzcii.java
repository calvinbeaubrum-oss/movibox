package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcii implements zzlc {
    private final zzyx zzb = new zzyx(true, 65536);
    private long zzc = 15000000;
    private long zzd = 30000000;
    private long zze = 2500000;
    private long zzf = 5000000;
    private int zzg;
    private boolean zzh;

    @Override // com.google.android.gms.internal.ads.zzlc
    public final long zza() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzb() {
        zzj(false);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzc() {
        zzj(true);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzd() {
        zzj(true);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final /* synthetic */ void zze(zzcx zzcxVar, zzur zzurVar, zzmf[] zzmfVarArr, zzws zzwsVar, zzyi[] zzyiVarArr) {
        int i11 = 0;
        this.zzg = 0;
        while (true) {
            int length = zzmfVarArr.length;
            if (i11 >= 2) {
                this.zzb.zzf(this.zzg);
                return;
            } else {
                if (zzyiVarArr[i11] != null) {
                    this.zzg += zzmfVarArr[i11].zzbj() != 1 ? 131072000 : C.DEFAULT_VIDEO_BUFFER_SIZE;
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
        char c11;
        boolean z11 = true;
        if (j12 > this.zzd) {
            c11 = 0;
        } else {
            c11 = j12 < this.zzc ? (char) 2 : (char) 1;
        }
        int iZza = this.zzb.zza();
        int i11 = this.zzg;
        if (c11 != 2 && (c11 != 1 || !this.zzh || iZza >= i11)) {
            z11 = false;
        }
        this.zzh = z11;
        return z11;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final /* synthetic */ boolean zzh(zzcx zzcxVar, zzur zzurVar, long j11, float f11, boolean z11, long j12) {
        long j13 = z11 ? this.zzf : this.zze;
        return j13 <= 0 || j11 >= j13;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final zzyx zzi() {
        return this.zzb;
    }

    public final void zzj(boolean z11) {
        this.zzg = 0;
        this.zzh = false;
        if (z11) {
            this.zzb.zze();
        }
    }

    public final synchronized void zzk(int i11) {
        this.zze = ((long) i11) * 1000;
    }

    public final synchronized void zzl(int i11) {
        this.zzf = ((long) i11) * 1000;
    }

    public final synchronized void zzm(int i11) {
        this.zzd = ((long) i11) * 1000;
    }

    public final synchronized void zzn(int i11) {
        this.zzc = ((long) i11) * 1000;
    }
}
