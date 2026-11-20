package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamx implements zzamy {
    private final List zza;
    private final zzaea[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = C.TIME_UNSET;

    public zzamx(List list) {
        this.zza = list;
        this.zzb = new zzaea[list.size()];
    }

    private final boolean zzf(zzfp zzfpVar, int i11) {
        if (zzfpVar.zzb() == 0) {
            return false;
        }
        if (zzfpVar.zzm() != i11) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        if (this.zzc) {
            if (this.zzd != 2 || zzf(zzfpVar, 32)) {
                if (this.zzd != 1 || zzf(zzfpVar, 0)) {
                    int iZzd = zzfpVar.zzd();
                    int iZzb = zzfpVar.zzb();
                    for (zzaea zzaeaVar : this.zzb) {
                        zzfpVar.zzK(iZzd);
                        zzaeaVar.zzr(zzfpVar, iZzb);
                    }
                    this.zze += iZzb;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        for (int i11 = 0; i11 < this.zzb.length; i11++) {
            zzaoh zzaohVar = (zzaoh) this.zza.get(i11);
            zzaokVar.zzc();
            zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 3);
            zzak zzakVar = new zzak();
            zzakVar.zzK(zzaokVar.zzb());
            zzakVar.zzW(MimeTypes.APPLICATION_DVBSUBS);
            zzakVar.zzL(Collections.singletonList(zzaohVar.zzb));
            zzakVar.zzN(zzaohVar.zza);
            zzaeaVarZzw.zzl(zzakVar.zzac());
            this.zzb[i11] = zzaeaVarZzw;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
        if (this.zzc) {
            zzek.zzf(this.zzf != C.TIME_UNSET);
            for (zzaea zzaeaVar : this.zzb) {
                zzaeaVar.zzt(this.zzf, 1, this.zze, 0, null);
            }
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.zzc = true;
        this.zzf = j11;
        this.zze = 0;
        this.zzd = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzc = false;
        this.zzf = C.TIME_UNSET;
    }
}
