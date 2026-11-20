package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzt {
    public static final zzt zza;
    public static final zzt zzb;

    @Deprecated
    public static final zzn zzc;
    private static final String zzj;
    private static final String zzk;
    private static final String zzl;
    private static final String zzm;
    private static final String zzn;
    private static final String zzo;
    public final int zzd;
    public final int zze;
    public final int zzf;

    @Nullable
    public final byte[] zzg;
    public final int zzh;
    public final int zzi;
    private int zzp;

    static {
        zzr zzrVar = new zzr();
        zzrVar.zzc(1);
        zzrVar.zzb(2);
        zzrVar.zzd(3);
        zza = zzrVar.zzg();
        zzr zzrVar2 = new zzr();
        zzrVar2.zzc(1);
        zzrVar2.zzb(1);
        zzrVar2.zzd(2);
        zzb = zzrVar2.zzg();
        zzj = Integer.toString(0, 36);
        zzk = Integer.toString(1, 36);
        zzl = Integer.toString(2, 36);
        zzm = Integer.toString(3, 36);
        zzn = Integer.toString(4, 36);
        zzo = Integer.toString(5, 36);
        zzc = new zzn() { // from class: com.google.android.gms.internal.ads.zzp
        };
    }

    public /* synthetic */ zzt(int i11, int i12, int i13, byte[] bArr, int i14, int i15, zzs zzsVar) {
        this.zzd = i11;
        this.zze = i12;
        this.zzf = i13;
        this.zzg = bArr;
        this.zzh = i14;
        this.zzi = i15;
    }

    public static int zza(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int zzb(int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 4) {
            return 10;
        }
        if (i11 == 13) {
            return 2;
        }
        if (i11 == 16) {
            return 6;
        }
        if (i11 != 18) {
            return (i11 == 6 || i11 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String zzg(int i11) {
        if (i11 == -1) {
            return "Unset color range";
        }
        if (i11 != 1) {
            return i11 != 2 ? "Undefined color range" : "Limited range";
        }
        return "Full range";
    }

    private static String zzh(int i11) {
        if (i11 == -1) {
            return "Unset color space";
        }
        if (i11 == 6) {
            return "BT2020";
        }
        if (i11 != 1) {
            return i11 != 2 ? "Undefined color space" : "BT601";
        }
        return "BT709";
    }

    private static String zzi(int i11) {
        if (i11 == -1) {
            return "Unset color transfer";
        }
        if (i11 == 10) {
            return "Gamma 2.2";
        }
        if (i11 == 1) {
            return "Linear";
        }
        if (i11 == 2) {
            return "sRGB";
        }
        if (i11 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i11 != 6) {
            return i11 != 7 ? "Undefined color transfer" : "HLG";
        }
        return "ST2084 PQ";
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzt.class == obj.getClass()) {
            zzt zztVar = (zzt) obj;
            if (this.zzd == zztVar.zzd && this.zze == zztVar.zze && this.zzf == zztVar.zzf && Arrays.equals(this.zzg, zztVar.zzg) && this.zzh == zztVar.zzh && this.zzi == zztVar.zzi) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzp;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = ((((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zzf) * 31) + Arrays.hashCode(this.zzg)) * 31) + this.zzh) * 31) + this.zzi;
        this.zzp = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String str;
        int i11 = this.zzh;
        String str2 = "NA";
        if (i11 != -1) {
            str = i11 + "bit Luma";
        } else {
            str = "NA";
        }
        int i12 = this.zzi;
        if (i12 != -1) {
            str2 = i12 + "bit Chroma";
        }
        byte[] bArr = this.zzg;
        int i13 = this.zzf;
        int i14 = this.zze;
        int i15 = this.zzd;
        return "ColorInfo(" + zzh(i15) + ", " + zzg(i14) + ", " + zzi(i13) + ", " + (bArr != null) + ", " + str + ", " + str2 + ")";
    }

    public final zzr zzc() {
        return new zzr(this, null);
    }

    public final String zzd() {
        String str;
        String str2 = zzf() ? String.format(Locale.US, "%s/%s/%s", zzh(this.zzd), zzg(this.zze), zzi(this.zzf)) : "NA/NA/NA";
        if (zze()) {
            str = this.zzh + "/" + this.zzi;
        } else {
            str = "NA/NA";
        }
        return str2 + "/" + str;
    }

    public final boolean zze() {
        return (this.zzh == -1 || this.zzi == -1) ? false : true;
    }

    public final boolean zzf() {
        return (this.zzd == -1 || this.zze == -1 || this.zzf == -1) ? false : true;
    }
}
