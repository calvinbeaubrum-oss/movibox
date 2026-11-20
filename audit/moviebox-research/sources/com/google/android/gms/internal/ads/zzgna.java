package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgna {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzgna(Map map, Map map2, zzgmz zzgmzVar) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzgmy zza() {
        return new zzgmy(null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum r11 = (Enum) this.zzb.get(obj);
        if (r11 != null) {
            return r11;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(obj)));
    }

    public final Object zzc(Enum r11) throws GeneralSecurityException {
        Object obj = this.zza.get(r11);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(r11)));
    }
}
