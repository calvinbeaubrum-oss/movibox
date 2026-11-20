package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfvk extends zzfun {
    final /* synthetic */ zzfvl zza;
    private final zzfvq zzb;

    public zzfvk(zzfvl zzfvlVar, zzfvq zzfvqVar) {
        this.zza = zzfvlVar;
        this.zzb = zzfvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    public final void zzb(Bundle bundle) {
        int i11 = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfvo zzfvoVarZzc = zzfvp.zzc();
        zzfvoVarZzc.zzb(i11);
        if (string != null) {
            zzfvoVarZzc.zza(string);
        }
        this.zzb.zza(zzfvoVarZzc.zzc());
        if (i11 == 8157) {
            this.zza.zzc();
        }
    }
}
