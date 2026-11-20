package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzank implements zzamy {
    private zzaea zzb;
    private boolean zzc;
    private int zze;
    private int zzf;
    private final zzfp zza = new zzfp(10);
    private long zzd = C.TIME_UNSET;

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zzb);
        if (this.zzc) {
            int iZzb = zzfpVar.zzb();
            int i11 = this.zzf;
            if (i11 < 10) {
                int iMin = Math.min(iZzb, 10 - i11);
                System.arraycopy(zzfpVar.zzM(), zzfpVar.zzd(), this.zza.zzM(), this.zzf, iMin);
                if (this.zzf + iMin == 10) {
                    this.zza.zzK(0);
                    if (this.zza.zzm() != 73 || this.zza.zzm() != 68 || this.zza.zzm() != 51) {
                        zzff.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    } else {
                        this.zza.zzL(3);
                        this.zze = this.zza.zzl() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZzb, this.zze - this.zzf);
            this.zzb.zzr(zzfpVar, iMin2);
            this.zzf += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 5);
        this.zzb = zzaeaVarZzw;
        zzak zzakVar = new zzak();
        zzakVar.zzK(zzaokVar.zzb());
        zzakVar.zzW(MimeTypes.APPLICATION_ID3);
        zzaeaVarZzw.zzl(zzakVar.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
        int i11;
        zzek.zzb(this.zzb);
        if (this.zzc && (i11 = this.zze) != 0 && this.zzf == i11) {
            zzek.zzf(this.zzd != C.TIME_UNSET);
            this.zzb.zzt(this.zzd, 1, this.zze, 0, null);
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.zzc = true;
        this.zzd = j11;
        this.zze = 0;
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
    }
}
