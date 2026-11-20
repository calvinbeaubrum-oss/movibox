package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpv {
    private final zzfoy zza;
    private final ArrayList zzb;

    public zzfpv(zzfoy zzfoyVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = zzfoyVar;
        arrayList.add(str);
    }

    public final zzfoy zza() {
        return this.zza;
    }

    public final ArrayList zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        this.zzb.add(str);
    }
}
