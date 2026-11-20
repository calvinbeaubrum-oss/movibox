package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzc {
    public final long zzc;
    public final int zzd;

    @Deprecated
    public final Uri[] zze;
    public final zzbp[] zzf;
    public final int[] zzg;
    public final long[] zzh;
    public final long zzi;
    public final boolean zzj;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    private static final String zzr = Integer.toString(7, 36);
    static final String zza = Integer.toString(8, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzb
    };

    public zzc(long j11) {
        this(0L, -1, -1, new int[0], new zzbp[0], new long[0], 0L, false);
    }

    private zzc(long j11, int i11, int i12, int[] iArr, zzbp[] zzbpVarArr, long[] jArr, long j12, boolean z11) {
        Uri uri;
        int length = iArr.length;
        int length2 = zzbpVarArr.length;
        int i13 = 0;
        zzek.zzd(length == length2);
        this.zzc = 0L;
        this.zzd = i11;
        this.zzg = iArr;
        this.zzf = zzbpVarArr;
        this.zzh = jArr;
        this.zzi = 0L;
        this.zzj = false;
        this.zze = new Uri[length2];
        while (true) {
            Uri[] uriArr = this.zze;
            if (i13 >= uriArr.length) {
                return;
            }
            zzbp zzbpVar = zzbpVarArr[i13];
            if (zzbpVar == null) {
                uri = null;
            } else {
                zzbi zzbiVar = zzbpVar.zzd;
                zzbiVar.getClass();
                uri = zzbiVar.zzb;
            }
            uriArr[i13] = uri;
            i13++;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzc.class == obj.getClass()) {
            zzc zzcVar = (zzc) obj;
            if (this.zzd == zzcVar.zzd && Arrays.equals(this.zzf, zzcVar.zzf) && Arrays.equals(this.zzg, zzcVar.zzg) && Arrays.equals(this.zzh, zzcVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd * 31) - 1) * 961) + Arrays.hashCode(this.zzf)) * 31) + Arrays.hashCode(this.zzg)) * 31) + Arrays.hashCode(this.zzh)) * 961;
    }

    public final int zza(int i11) {
        int i12;
        int i13 = i11 + 1;
        while (true) {
            int[] iArr = this.zzg;
            if (i13 >= iArr.length || (i12 = iArr[i13]) == 0 || i12 == 1) {
                break;
            }
            i13++;
        }
        return i13;
    }

    @CheckResult
    public final zzc zzb(int i11) {
        int[] iArr = this.zzg;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = this.zzh;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, C.TIME_UNSET);
        return new zzc(0L, 0, -1, iArrCopyOf, (zzbp[]) Arrays.copyOf(this.zzf, 0), jArrCopyOf, 0L, false);
    }
}
