package com.google.android.gms.measurement.internal;

import androidx.collection.x;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzff extends x {
    final /* synthetic */ zzfi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzff(zzfi zzfiVar, int i11) {
        super(20);
        this.zza = zzfiVar;
    }

    @Override // androidx.collection.x
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfi.zzd(this.zza, str);
    }
}
