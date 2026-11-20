package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhab extends AbstractList {
    private final List zza;
    private final zzhaa zzb;

    public zzhab(List list, zzhaa zzhaaVar) {
        this.zza = list;
        this.zzb = zzhaaVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i11) {
        zzbcn zzbcnVarZzb = zzbcn.zzb(((Integer) this.zza.get(i11)).intValue());
        return zzbcnVarZzb == null ? zzbcn.AD_FORMAT_TYPE_UNSPECIFIED : zzbcnVarZzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
