package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxq extends zzaxx {
    public zzaxq(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12) {
        super(zzawjVar, "U5Ngb8pPuPEbyAEAeNCt0wgGFK4YAtkNGCrOQKfD/ONzQcV8GTtSZ6EoO3NY8V1s", "GZJYAQ87uqT/39Vw1xO4VkKaUA+BZKFiVkKasBC0VSw=", zzasgVar, i11, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zze) {
            zzawe zzaweVar = new zzawe((String) this.zzf.invoke(null, new Object[0]));
            this.zze.zzp(zzaweVar.zza.longValue());
            this.zze.zzq(zzaweVar.zzb.longValue());
        }
    }
}
