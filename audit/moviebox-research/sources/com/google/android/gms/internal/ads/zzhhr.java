package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhhr implements zzhhd {
    private static final zzhhd zza = zzhhe.zza(Collections.emptySet());
    private final List zzb;
    private final List zzc;

    public /* synthetic */ zzhhr(List list, List list2, zzhhp zzhhpVar) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static zzhhq zza(int i11, int i12) {
        return new zzhhq(i11, i12, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Set zzb() {
        int size = this.zzb.size();
        ArrayList arrayList = new ArrayList(this.zzc.size());
        int size2 = this.zzc.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Collection collection = (Collection) ((zzhhm) this.zzc.get(i11)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetZza = zzhha.zza(size);
        int size3 = this.zzb.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Object objZzb = ((zzhhm) this.zzb.get(i12)).zzb();
            objZzb.getClass();
            hashSetZza.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i13 = 0; i13 < size4; i13++) {
            for (Object obj : (Collection) arrayList.get(i13)) {
                obj.getClass();
                hashSetZza.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSetZza);
    }
}
