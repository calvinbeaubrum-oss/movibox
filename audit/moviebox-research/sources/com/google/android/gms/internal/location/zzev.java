package com.google.android.gms.internal.location;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzev extends zzet {
    private final zzex zza;

    public zzev(zzex zzexVar, int i11) {
        super(zzexVar.size(), i11);
        this.zza = zzexVar;
    }

    @Override // com.google.android.gms.internal.location.zzet
    public final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
