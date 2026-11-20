package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhao extends zzhas {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzhao() {
        super(null);
    }

    public /* synthetic */ zzhao(zzhan zzhanVar) {
        super(null);
    }

    private static List zzf(Object obj, long j11, int i11) {
        List list;
        List listZzd;
        List list2 = (List) zzhcz.zzh(obj, j11);
        if (list2.isEmpty()) {
            if (list2 instanceof zzham) {
                listZzd = new zzhal(i11);
            } else {
                listZzd = ((list2 instanceof zzhbm) && (list2 instanceof zzhad)) ? ((zzhad) list2).zzd(i11) : new ArrayList(i11);
            }
            zzhcz.zzv(obj, j11, listZzd);
            return listZzd;
        }
        if (zza.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i11);
            arrayList.addAll(list2);
            zzhcz.zzv(obj, j11, arrayList);
            list = arrayList;
        } else {
            if (!(list2 instanceof zzhcu)) {
                if (!(list2 instanceof zzhbm) || !(list2 instanceof zzhad)) {
                    return list2;
                }
                zzhad zzhadVar = (zzhad) list2;
                if (zzhadVar.zzc()) {
                    return list2;
                }
                zzhad zzhadVarZzd = zzhadVar.zzd(list2.size() + i11);
                zzhcz.zzv(obj, j11, zzhadVarZzd);
                return zzhadVarZzd;
            }
            zzhal zzhalVar = new zzhal(list2.size() + i11);
            zzhalVar.addAll(zzhalVar.size(), (zzhcu) list2);
            zzhcz.zzv(obj, j11, zzhalVar);
            list = zzhalVar;
        }
        return list;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final List zza(Object obj, long j11) {
        return zzf(obj, j11, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzb(Object obj, long j11) {
        Object objUnmodifiableList;
        List list = (List) zzhcz.zzh(obj, j11);
        if (list instanceof zzham) {
            objUnmodifiableList = ((zzham) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzhbm) && (list instanceof zzhad)) {
                zzhad zzhadVar = (zzhad) list;
                if (zzhadVar.zzc()) {
                    zzhadVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhcz.zzv(obj, j11, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzc(Object obj, Object obj2, long j11) {
        List list = (List) zzhcz.zzh(obj2, j11);
        List listZzf = zzf(obj, j11, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzhcz.zzv(obj, j11, list);
    }
}
