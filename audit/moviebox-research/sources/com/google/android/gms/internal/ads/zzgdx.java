package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgdx extends zzgdm {
    private List zza;

    public zzgdx(zzfzv zzfzvVar, boolean z11) {
        super(zzfzvVar, z11, true);
        List listEmptyList = zzfzvVar.isEmpty() ? Collections.emptyList() : zzgao.zza(zzfzvVar.size());
        for (int i11 = 0; i11 < zzfzvVar.size(); i11++) {
            listEmptyList.add(null);
        }
        this.zza = listEmptyList;
    }

    public abstract Object zzG(List list);

    @Override // com.google.android.gms.internal.ads.zzgdm
    public final void zzf(int i11, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i11, new zzgdw(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    public final void zzu() {
        List list = this.zza;
        if (list != null) {
            zzc(zzG(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    public final void zzy(int i11) {
        super.zzy(i11);
        this.zza = null;
    }
}
