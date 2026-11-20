package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhav implements zzhbc {
    private final zzhbc[] zza;

    public zzhav(zzhbc... zzhbcVarArr) {
        this.zza = zzhbcVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    public final zzhbb zzb(Class cls) {
        for (int i11 = 0; i11 < 2; i11++) {
            zzhbc zzhbcVar = this.zza[i11];
            if (zzhbcVar.zzc(cls)) {
                return zzhbcVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    public final boolean zzc(Class cls) {
        for (int i11 = 0; i11 < 2; i11++) {
            if (this.zza[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
