package com.google.android.gms.internal.ads;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcz {
    public final int zzb = 1;
    public final String zzc;
    public final int zzd;
    private final zzam[] zzg;
    private int zzh;
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);

    @Deprecated
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzcy
    };

    public zzcz(String str, zzam... zzamVarArr) {
        this.zzc = str;
        this.zzg = zzamVarArr;
        int iZzb = zzcb.zzb(zzamVarArr[0].zzm);
        this.zzd = iZzb == -1 ? zzcb.zzb(zzamVarArr[0].zzl) : iZzb;
        zzd(zzamVarArr[0].zzd);
        int i11 = zzamVarArr[0].zzf;
    }

    private static String zzd(@Nullable String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static void zze(String str, @Nullable String str2, @Nullable String str3, int i11) {
        zzff.zzd("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i11 + ")"));
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcz.class == obj.getClass()) {
            zzcz zzczVar = (zzcz) obj;
            if (this.zzc.equals(zzczVar.zzc) && Arrays.equals(this.zzg, zzczVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzh;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = ((this.zzc.hashCode() + 527) * 31) + Arrays.hashCode(this.zzg);
        this.zzh = iHashCode;
        return iHashCode;
    }

    public final int zza(zzam zzamVar) {
        for (int i11 = 0; i11 <= 0; i11++) {
            if (zzamVar == this.zzg[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public final zzam zzb(int i11) {
        return this.zzg[i11];
    }

    @CheckResult
    public final zzcz zzc(String str) {
        return new zzcz(str, this.zzg);
    }
}
