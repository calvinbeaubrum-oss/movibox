package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgn {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public zzgn(byte[] bArr, int i11, int i12) {
        this.zza = bArr;
        this.zzc = i11;
        this.zzb = i12;
        zzh();
    }

    private final int zzg() {
        int i11 = 0;
        while (!zzf()) {
            i11++;
        }
        return ((1 << i11) - 1) + (i11 > 0 ? zza(i11) : 0);
    }

    private final void zzh() {
        int i11;
        int i12 = this.zzc;
        boolean z11 = false;
        if (i12 >= 0 && (i12 < (i11 = this.zzb) || (i12 == i11 && this.zzd == 0))) {
            z11 = true;
        }
        zzek.zzf(z11);
    }

    private final boolean zzi(int i11) {
        if (i11 < 2 || i11 >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i11] == 3 && bArr[i11 + (-2)] == 0 && bArr[i11 + (-1)] == 0;
    }

    public final int zza(int i11) {
        int i12;
        this.zzd += i11;
        int i13 = 0;
        while (true) {
            i12 = this.zzd;
            int i14 = 2;
            if (i12 <= 8) {
                break;
            }
            int i15 = i12 - 8;
            this.zzd = i15;
            byte[] bArr = this.zza;
            int i16 = this.zzc;
            i13 |= (bArr[i16] & 255) << i15;
            if (true != zzi(i16 + 1)) {
                i14 = 1;
            }
            this.zzc = i16 + i14;
        }
        byte[] bArr2 = this.zza;
        int i17 = this.zzc;
        int i18 = i13 | ((bArr2[i17] & 255) >> (8 - i12));
        int i19 = 32 - i11;
        if (i12 == 8) {
            this.zzd = 0;
            this.zzc = i17 + (true != zzi(i17 + 1) ? 1 : 2);
        }
        int i21 = ((-1) >>> i19) & i18;
        zzh();
        return i21;
    }

    public final int zzb() {
        int iZzg = zzg();
        return (iZzg % 2 == 0 ? -1 : 1) * ((iZzg + 1) / 2);
    }

    public final int zzc() {
        return zzg();
    }

    public final void zzd() {
        int i11 = this.zzd + 1;
        this.zzd = i11;
        if (i11 == 8) {
            this.zzd = 0;
            int i12 = this.zzc;
            this.zzc = i12 + (true == zzi(i12 + 1) ? 2 : 1);
        }
        zzh();
    }

    public final void zze(int i11) {
        int i12 = this.zzc;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.zzc = i14;
        int i15 = this.zzd + (i11 - (i13 * 8));
        this.zzd = i15;
        if (i15 > 7) {
            this.zzc = i14 + 1;
            this.zzd = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.zzc) {
                zzh();
                return;
            } else if (zzi(i12)) {
                this.zzc++;
                i12 += 2;
            }
        }
    }

    public final boolean zzf() {
        int i11 = this.zza[this.zzc] & (128 >> this.zzd);
        zzd();
        return i11 != 0;
    }
}
