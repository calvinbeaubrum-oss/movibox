package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zznv extends zzni {
    private final zznx zza;

    public zznv(zznx zznxVar, int i11) {
        super(zznxVar.size(), i11);
        this.zza = zznxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzni
    public final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
