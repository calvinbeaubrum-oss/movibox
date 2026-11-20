package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzuh implements zzgw {
    private final zzgw zza;
    private final int zzb;
    private final zzug zzc;
    private final byte[] zzd;
    private int zze;

    public zzuh(zzgw zzgwVar, int i11, zzug zzugVar) {
        zzek.zzd(i11 > 0);
        this.zza = zzgwVar;
        this.zzb = i11;
        this.zzc = zzugVar;
        this.zzd = new byte[1];
        this.zze = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.zze;
        if (i13 == 0) {
            int i14 = 0;
            if (this.zza.zza(this.zzd, 0, 1) != -1) {
                int i15 = (this.zzd[0] & 255) << 4;
                if (i15 != 0) {
                    byte[] bArr2 = new byte[i15];
                    int i16 = i15;
                    while (i16 > 0) {
                        int iZza = this.zza.zza(bArr2, i14, i16);
                        if (iZza != -1) {
                            i14 += iZza;
                            i16 -= iZza;
                        }
                    }
                    while (i15 > 0) {
                        int i17 = i15 - 1;
                        if (bArr2[i17] != 0) {
                            break;
                        }
                        i15 = i17;
                    }
                    if (i15 > 0) {
                        this.zzc.zza(new zzfp(bArr2, i15));
                    }
                }
                i13 = this.zzb;
                this.zze = i13;
            }
            return -1;
        }
        int iZza2 = this.zza.zza(bArr, i11, Math.min(i13, i12));
        if (iZza2 != -1) {
            this.zze -= iZza2;
        }
        return iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Map zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzf(zzhy zzhyVar) {
        zzhyVar.getClass();
        this.zza.zzf(zzhyVar);
    }
}
