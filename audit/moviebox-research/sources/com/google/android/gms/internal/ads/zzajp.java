package com.google.android.gms.internal.ads;

import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajp {
    public final zzajm zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzajp(zzajm zzajmVar, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        int length = iArr.length;
        int length2 = jArr2.length;
        zzek.zzd(length == length2);
        int length3 = jArr.length;
        zzek.zzd(length3 == length2);
        int length4 = iArr2.length;
        zzek.zzd(length4 == length2);
        this.zza = zzajmVar;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i11;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j11;
        this.zzb = length3;
        if (length4 > 0) {
            int i12 = length4 - 1;
            iArr2[i12] = iArr2[i12] | ASTNode.DISCARD;
        }
    }

    public final int zza(long j11) {
        for (int iZzc = zzfy.zzc(this.zzf, j11, true, false); iZzc >= 0; iZzc--) {
            if ((this.zzg[iZzc] & 1) != 0) {
                return iZzc;
            }
        }
        return -1;
    }

    public final int zzb(long j11) {
        for (int iZza = zzfy.zza(this.zzf, j11, true, false); iZza < this.zzf.length; iZza++) {
            if ((this.zzg[iZza] & 1) != 0) {
                return iZza;
            }
        }
        return -1;
    }
}
