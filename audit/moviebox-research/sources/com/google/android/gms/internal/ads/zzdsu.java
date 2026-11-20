package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdsu implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzdsu(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        int i11 = ((zzdao) this.zzc).zza().zzo.zza;
        if (i11 != 0) {
            return i11 + (-1) != 0 ? ((zzeoa) this.zzb).zzb() : ((zzeoa) this.zza).zzb();
        }
        throw null;
    }
}
