package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgah extends zzfyb {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfxf zzb;

    public zzgah(Iterator it, zzfxf zzfxfVar) {
        this.zza = it;
        this.zzb = zzfxfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfyb
    public final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            zzfxf zzfxfVar = this.zzb;
            Object next = it.next();
            if (zzfxfVar.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
