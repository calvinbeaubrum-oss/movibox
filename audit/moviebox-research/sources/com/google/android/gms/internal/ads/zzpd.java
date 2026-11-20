package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpd {
    public static final zzpd zza = new zzpd(new int[]{2}, 10);

    @SuppressLint({"InlinedApi"})
    private static final zzgaa zzb = zzgaa.zzo(2, 5, 6);
    private static final zzgad zzc;
    private final int[] zzd;
    private final int zze;

    static {
        zzgac zzgacVar = new zzgac();
        zzgacVar.zza(5, 6);
        zzgacVar.zza(17, 6);
        zzgacVar.zza(7, 6);
        zzgacVar.zza(30, 10);
        zzgacVar.zza(18, 6);
        zzgacVar.zza(6, 8);
        zzgacVar.zza(8, 8);
        zzgacVar.zza(14, 8);
        zzc = zzgacVar.zzc();
    }

    public zzpd(@Nullable int[] iArr, int i11) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, 1);
        this.zzd = iArrCopyOf;
        Arrays.sort(iArrCopyOf);
        this.zze = 10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzpd) && Arrays.equals(this.zzd, ((zzpd) obj).zzd);
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzd) * 31) + 10;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=10, supportedEncodings=" + Arrays.toString(this.zzd) + "]";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:16:0x0038 A[PHI: r0
  0x0038: PHI (r0v3 int) = (r0v2 int), (r0v6 int) binds: [B:11:0x002b, B:14:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    /* JADX WARN: Code duplicated, block: B:51:0x009f  */
    @Nullable
    public final Pair zza(zzam zzamVar, zzk zzkVar) {
        String str = zzamVar.zzm;
        str.getClass();
        int iZza = zzcb.zza(str, zzamVar.zzj);
        zzgad zzgadVar = zzc;
        if (!zzgadVar.containsKey(Integer.valueOf(iZza))) {
            return null;
        }
        int i11 = 8;
        if (iZza != 18) {
            if (iZza != 8) {
                if (iZza == 30 && !zzc(30)) {
                    iZza = 7;
                }
            } else if (zzc(8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else if (zzc(18)) {
            iZza = 18;
            if (iZza != 8) {
                if (iZza == 30) {
                    iZza = 7;
                }
            } else if (zzc(8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else {
            iZza = 6;
        }
        if (!zzc(iZza)) {
            return null;
        }
        int iIntValue = zzamVar.zzz;
        if (iIntValue == -1 || iZza == 18) {
            int i12 = zzamVar.zzA;
            if (i12 == -1) {
                i12 = 48000;
            }
            if (zzfy.zza >= 29) {
                iIntValue = zzpc.zza(iZza, i12, zzkVar);
            } else {
                Integer num = (Integer) zzgadVar.getOrDefault(Integer.valueOf(iZza), 0);
                num.getClass();
                iIntValue = num.intValue();
            }
        } else if (zzamVar.zzm.equals("audio/vnd.dts.uhd;profile=p2")) {
            if (iIntValue > 10) {
                return null;
            }
        } else if (iIntValue > 10) {
            return null;
        }
        int i13 = zzfy.zza;
        if (i13 > 28) {
            i11 = iIntValue;
        } else if (iIntValue != 7) {
            if (iIntValue == 3 || iIntValue == 4 || iIntValue == 5) {
                i11 = 6;
            } else {
                i11 = iIntValue;
            }
        }
        if (i13 <= 26 && "fugu".equals(zzfy.zzb) && i11 == 1) {
            i11 = 2;
        }
        int iZzg = zzfy.zzg(i11);
        if (iZzg != 0) {
            return Pair.create(Integer.valueOf(iZza), Integer.valueOf(iZzg));
        }
        return null;
    }

    public final boolean zzc(int i11) {
        return Arrays.binarySearch(this.zzd, i11) >= 0;
    }
}
