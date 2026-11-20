package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzle {
    private long zza;
    private float zzb;
    private long zzc;

    public zzle() {
        this.zza = C.TIME_UNSET;
        this.zzb = -3.4028235E38f;
        this.zzc = C.TIME_UNSET;
    }

    public /* synthetic */ zzle(zzlg zzlgVar, zzld zzldVar) {
        this.zza = zzlgVar.zza;
        this.zzb = zzlgVar.zzb;
        this.zzc = zzlgVar.zzc;
    }

    public final zzle zzd(long j11) {
        boolean z11 = true;
        if (j11 < 0) {
            if (j11 == C.TIME_UNSET) {
                j11 = -9223372036854775807L;
            } else {
                z11 = false;
            }
        }
        zzek.zzd(z11);
        this.zzc = j11;
        return this;
    }

    public final zzle zze(long j11) {
        this.zza = j11;
        return this;
    }

    public final zzle zzf(float f11) {
        boolean z11 = true;
        if (f11 <= 0.0f && f11 != -3.4028235E38f) {
            z11 = false;
        }
        zzek.zzd(z11);
        this.zzb = f11;
        return this;
    }

    public final zzlg zzg() {
        return new zzlg(this, null);
    }
}
