package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzmd extends zzii {
    public static final /* synthetic */ int zzc = 0;
    private final int zzd;
    private final int zze;
    private final int[] zzf;
    private final int[] zzg;
    private final zzcx[] zzh;
    private final Object[] zzi;
    private final HashMap zzj;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzmd(Collection collection, zzwk zzwkVar) {
        zzcx[] zzcxVarArr = new zzcx[collection.size()];
        Iterator it = collection.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            zzcxVarArr[i12] = ((zzlm) it.next()).zza();
            i12++;
        }
        Object[] objArr = new Object[collection.size()];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            objArr[i11] = ((zzlm) it2.next()).zzb();
            i11++;
        }
        this(zzcxVarArr, objArr, zzwkVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzmd(zzcx[] zzcxVarArr, Object[] objArr, zzwk zzwkVar) {
        super(false, zzwkVar);
        int i11 = 0;
        this.zzh = zzcxVarArr;
        int length = zzcxVarArr.length;
        this.zzf = new int[length];
        this.zzg = new int[length];
        this.zzi = objArr;
        this.zzj = new HashMap();
        int iZzc = 0;
        int iZzb = 0;
        int i12 = 0;
        while (i11 < zzcxVarArr.length) {
            zzcx zzcxVar = zzcxVarArr[i11];
            this.zzh[i12] = zzcxVar;
            this.zzg[i12] = iZzc;
            this.zzf[i12] = iZzb;
            iZzc += zzcxVar.zzc();
            iZzb += this.zzh[i12].zzb();
            this.zzj.put(objArr[i12], Integer.valueOf(i12));
            i11++;
            i12++;
        }
        this.zzd = iZzc;
        this.zze = iZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zzp(Object obj) {
        Integer num = (Integer) this.zzj.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zzq(int i11) {
        return zzfy.zzb(this.zzf, i11 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zzr(int i11) {
        return zzfy.zzb(this.zzg, i11 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zzs(int i11) {
        return this.zzf[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zzt(int i11) {
        return this.zzg[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final zzcx zzu(int i11) {
        return this.zzh[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final Object zzv(int i11) {
        return this.zzi[i11];
    }

    public final List zzw() {
        return Arrays.asList(this.zzh);
    }

    public final zzmd zzx(zzwk zzwkVar) {
        zzcx[] zzcxVarArr = new zzcx[this.zzh.length];
        int i11 = 0;
        while (true) {
            zzcx[] zzcxVarArr2 = this.zzh;
            if (i11 >= zzcxVarArr2.length) {
                return new zzmd(zzcxVarArr, this.zzi, zzwkVar);
            }
            zzcxVarArr[i11] = new zzmc(this, zzcxVarArr2[i11]);
            i11++;
        }
    }
}
