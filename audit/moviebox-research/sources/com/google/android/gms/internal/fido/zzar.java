package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzar extends zzao {
    private final zzat zza;

    public zzar(zzat zzatVar, int i11) {
        super(zzatVar.size(), i11);
        this.zza = zzatVar;
    }

    @Override // com.google.android.gms.internal.fido.zzao
    public final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
