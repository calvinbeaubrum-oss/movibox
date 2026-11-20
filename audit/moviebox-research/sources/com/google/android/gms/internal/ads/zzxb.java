package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzxb implements zzyi {
    protected final zzcz zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzam[] zzd;
    private int zze;

    public zzxb(zzcz zzczVar, int[] iArr, int i11) {
        int length = iArr.length;
        zzek.zzf(length > 0);
        zzczVar.getClass();
        this.zza = zzczVar;
        this.zzb = length;
        this.zzd = new zzam[length];
        for (int i12 = 0; i12 < iArr.length; i12++) {
            this.zzd[i12] = zzczVar.zzb(iArr[i12]);
        }
        Arrays.sort(this.zzd, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxa
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzam) obj2).zzi - ((zzam) obj).zzi;
            }
        });
        this.zzc = new int[this.zzb];
        for (int i13 = 0; i13 < this.zzb; i13++) {
            this.zzc[i13] = zzczVar.zza(this.zzd[i13]);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxb zzxbVar = (zzxb) obj;
            if (this.zza.equals(zzxbVar.zza) && Arrays.equals(this.zzc, zzxbVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zze;
        if (i11 != 0) {
            return i11;
        }
        int iIdentityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
        this.zze = iIdentityHashCode;
        return iIdentityHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final int zza(int i11) {
        return this.zzc[0];
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final int zzb(int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            if (this.zzc[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final int zzc() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final zzam zzd(int i11) {
        return this.zzd[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final zzcz zze() {
        return this.zza;
    }
}
