package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzae extends zzz {
    private final zzag zza;

    public zzae(zzag zzagVar, int i11) {
        super(zzagVar.size(), i11);
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
