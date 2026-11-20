package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzazs implements Comparator {
    public zzazs(zzazu zzazuVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzazy zzazyVar = (zzazy) obj;
        zzazy zzazyVar2 = (zzazy) obj2;
        int i11 = zzazyVar.zzc - zzazyVar2.zzc;
        return i11 != 0 ? i11 : Long.compare(zzazyVar.zza, zzazyVar2.zza);
    }
}
