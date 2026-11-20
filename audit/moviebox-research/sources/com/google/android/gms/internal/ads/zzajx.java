package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajx {
    private final zzajy zza = new zzajy();
    private final zzfp zzb = new zzfp(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    private final int zzf(int i11) {
        int i12;
        int i13 = 0;
        this.zzd = 0;
        do {
            int i14 = this.zzd;
            int i15 = i11 + i14;
            zzajy zzajyVar = this.zza;
            if (i15 >= zzajyVar.zzc) {
                break;
            }
            this.zzd = i14 + 1;
            i12 = zzajyVar.zzf[i15];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public final zzfp zza() {
        return this.zzb;
    }

    public final zzajy zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzH(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzfp zzfpVar = this.zzb;
        if (zzfpVar.zzM().length == 65025) {
            return;
        }
        zzfpVar.zzI(Arrays.copyOf(zzfpVar.zzM(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, zzfpVar.zze())), this.zzb.zze());
    }

    public final boolean zze(zzacv zzacvVar) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzH(0);
        }
        while (true) {
            if (this.zze) {
                return true;
            }
            int i11 = this.zzc;
            if (i11 < 0) {
                if (!this.zza.zzc(zzacvVar, -1L) || !this.zza.zzb(zzacvVar, true)) {
                    return false;
                }
                zzajy zzajyVar = this.zza;
                int iZzf = zzajyVar.zzd;
                if ((zzajyVar.zza & 1) == 1 && this.zzb.zze() == 0) {
                    iZzf += zzf(0);
                    i11 = this.zzd;
                } else {
                    i11 = 0;
                }
                if (!zzacy.zze(zzacvVar, iZzf)) {
                    return false;
                }
                this.zzc = i11;
            }
            int iZzf2 = zzf(i11);
            int i12 = this.zzc + this.zzd;
            if (iZzf2 > 0) {
                zzfp zzfpVar = this.zzb;
                zzfpVar.zzE(zzfpVar.zze() + iZzf2);
                zzfp zzfpVar2 = this.zzb;
                if (!zzacy.zzd(zzacvVar, zzfpVar2.zzM(), zzfpVar2.zze(), iZzf2)) {
                    return false;
                }
                zzfp zzfpVar3 = this.zzb;
                zzfpVar3.zzJ(zzfpVar3.zze() + iZzf2);
                this.zze = this.zza.zzf[i12 + (-1)] != 255;
            }
            if (i12 == this.zza.zzc) {
                i12 = -1;
            }
            this.zzc = i12;
        }
    }
}
