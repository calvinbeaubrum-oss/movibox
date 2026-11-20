package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzld implements zzlk {
    private final zzlk[] zza;

    public zzld(zzlk... zzlkVarArr) {
        this.zza = zzlkVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final zzlj zzb(Class cls) {
        zzlk[] zzlkVarArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzlk zzlkVar = zzlkVarArr[i11];
            if (zzlkVar.zzc(cls)) {
                return zzlkVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final boolean zzc(Class cls) {
        zzlk[] zzlkVarArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzlkVarArr[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
