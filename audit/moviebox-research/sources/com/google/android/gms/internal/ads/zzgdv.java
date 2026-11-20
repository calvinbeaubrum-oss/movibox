package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgdv extends zzgdx {
    public zzgdv(zzfzv zzfzvVar, boolean z11) {
        super(zzfzvVar, z11);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgdx
    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList arrayListZza = zzgao.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgdw zzgdwVar = (zzgdw) it.next();
            arrayListZza.add(zzgdwVar != null ? zzgdwVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZza);
    }
}
