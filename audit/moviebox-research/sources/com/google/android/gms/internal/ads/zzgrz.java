package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgrz {
    private ArrayList zza = new ArrayList();
    private zzgrw zzb = zzgrw.zza;
    private Integer zzc = null;

    public final zzgrz zza(zzgge zzggeVar, int i11, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList == null) {
            throw new IllegalStateException("addEntry cannot be called after build()");
        }
        arrayList.add(new zzgsb(zzggeVar, i11, str, str2, null));
        return this;
    }

    public final zzgrz zzb(zzgrw zzgrwVar) {
        if (this.zza == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build()");
        }
        this.zzb = zzgrwVar;
        return this;
    }

    public final zzgrz zzc(int i11) {
        if (this.zza == null) {
            throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
        }
        this.zzc = Integer.valueOf(i11);
        return this;
    }

    public final zzgsd zzd() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        Integer num = this.zzc;
        if (num != null) {
            int iIntValue = num.intValue();
            ArrayList arrayList = this.zza;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                int iZza = ((zzgsb) arrayList.get(i11)).zza();
                i11++;
                if (iZza == iIntValue) {
                }
            }
            throw new GeneralSecurityException("primary key ID is not present in entries");
        }
        zzgsd zzgsdVar = new zzgsd(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, null);
        this.zza = null;
        return zzgsdVar;
    }
}
