package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoa implements zzacf {
    private final zzfw zza;
    private final zzfp zzb = new zzfp();
    private final int zzc;

    public zzaoa(int i11, zzfw zzfwVar, int i12) {
        this.zzc = i11;
        this.zza = zzfwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzace zza(zzacv zzacvVar, long j11) throws IOException {
        int iZza;
        int iZza2;
        long jZzf = zzacvVar.zzf();
        int iMin = (int) Math.min(112800L, zzacvVar.zzd() - jZzf);
        this.zzb.zzH(iMin);
        ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin, false);
        zzfp zzfpVar = this.zzb;
        int iZze = zzfpVar.zze();
        long j12 = -1;
        long j13 = -9223372036854775807L;
        long j14 = -1;
        while (zzfpVar.zzb() >= 188 && (iZza2 = (iZza = zzaom.zza(zzfpVar.zzM(), zzfpVar.zzd(), iZze)) + 188) <= iZze) {
            long jZzb = zzaom.zzb(zzfpVar, iZza, this.zzc);
            if (jZzb != C.TIME_UNSET) {
                long jZzb2 = this.zza.zzb(jZzb);
                if (jZzb2 <= j11) {
                    j14 = iZza;
                    if (100000 + jZzb2 <= j11) {
                        j13 = jZzb2;
                    }
                } else if (j13 == C.TIME_UNSET) {
                    return zzace.zzd(jZzb2, jZzf);
                }
                return zzace.zze(jZzf + j14);
            }
            zzfpVar.zzK(iZza2);
            j12 = iZza2;
        }
        return j13 != C.TIME_UNSET ? zzace.zzf(j13, jZzf + j12) : zzace.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb() {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
