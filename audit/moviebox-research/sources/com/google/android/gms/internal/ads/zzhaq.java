package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhaq extends zzhas {
    private zzhaq() {
        super(null);
    }

    public /* synthetic */ zzhaq(zzhap zzhapVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final List zza(Object obj, long j11) {
        zzhad zzhadVar = (zzhad) zzhcz.zzh(obj, j11);
        if (zzhadVar.zzc()) {
            return zzhadVar;
        }
        int size = zzhadVar.size();
        zzhad zzhadVarZzd = zzhadVar.zzd(size == 0 ? 10 : size + size);
        zzhcz.zzv(obj, j11, zzhadVarZzd);
        return zzhadVarZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzb(Object obj, long j11) {
        ((zzhad) zzhcz.zzh(obj, j11)).zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzc(Object obj, Object obj2, long j11) {
        zzhad zzhadVarZzd = (zzhad) zzhcz.zzh(obj, j11);
        zzhad zzhadVar = (zzhad) zzhcz.zzh(obj2, j11);
        int size = zzhadVarZzd.size();
        int size2 = zzhadVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzhadVarZzd.zzc()) {
                zzhadVarZzd = zzhadVarZzd.zzd(size2 + size);
            }
            zzhadVarZzd.addAll(zzhadVar);
        }
        if (size > 0) {
            zzhadVar = zzhadVarZzd;
        }
        zzhcz.zzv(obj, j11, zzhadVar);
    }
}
