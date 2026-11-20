package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z11, boolean z12) {
        super("log");
        this.zzc = zztVar;
        this.zza = z11;
        this.zzb = z12;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int i11;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            this.zzc.zza.zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        int iZzb = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
        if (iZzb == 2) {
            i11 = 4;
        } else if (iZzb == 3) {
            i11 = 1;
        } else if (iZzb != 5) {
            i11 = iZzb != 6 ? 3 : 2;
        } else {
            i11 = 5;
        }
        String strZzi = zzgVar.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            this.zzc.zza.zza(i11, strZzi, Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 2; i12 < Math.min(list.size(), 5); i12++) {
            arrayList.add(zzgVar.zzb((zzap) list.get(i12)).zzi());
        }
        this.zzc.zza.zza(i11, strZzi, arrayList, this.zza, this.zzb);
        return zzap.zzf;
    }
}
