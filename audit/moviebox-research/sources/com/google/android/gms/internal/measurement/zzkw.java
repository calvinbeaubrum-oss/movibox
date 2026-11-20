package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzkw extends zzla {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzkw() {
        super(null);
    }

    public /* synthetic */ zzkw(zzkv zzkvVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zza(Object obj, long j11) {
        Object objUnmodifiableList;
        List list = (List) zzmy.zzf(obj, j11);
        if (list instanceof zzku) {
            objUnmodifiableList = ((zzku) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzlt) && (list instanceof zzkm)) {
                zzkm zzkmVar = (zzkm) list;
                if (zzkmVar.zzc()) {
                    zzkmVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzmy.zzs(obj, j11, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zzb(Object obj, Object obj2, long j11) {
        List list;
        List list2;
        List listZzd;
        List list3 = (List) zzmy.zzf(obj2, j11);
        int size = list3.size();
        List list4 = (List) zzmy.zzf(obj, j11);
        if (list4.isEmpty()) {
            if (list4 instanceof zzku) {
                listZzd = new zzkt(size);
            } else {
                listZzd = ((list4 instanceof zzlt) && (list4 instanceof zzkm)) ? ((zzkm) list4).zzd(size) : new ArrayList(size);
            }
            zzmy.zzs(obj, j11, listZzd);
            list2 = listZzd;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzmy.zzs(obj, j11, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzmt) {
                zzkt zzktVar = new zzkt(list4.size() + size);
                zzktVar.addAll(zzktVar.size(), (zzmt) list4);
                zzmy.zzs(obj, j11, zzktVar);
                list = zzktVar;
            } else if ((list4 instanceof zzlt) && (list4 instanceof zzkm)) {
                zzkm zzkmVar = (zzkm) list4;
                if (!zzkmVar.zzc()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    zzkm zzkmVarZzd = zzkmVar.zzd(list4.size() + size);
                    zzmy.zzs(obj, j11, zzkmVarZzd);
                    list2 = zzkmVarZzd;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzmy.zzs(obj, j11, list3);
    }
}
