package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcrb implements zzcqv {
    private final zzdzd zza;

    public zzcrb(zzdzd zzdzdVar) {
        this.zza = zzdzdVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @Override // com.google.android.gms.internal.ads.zzcqv
    public final void zza(Map map) {
        byte b11;
        String str = (String) map.get("gesture");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 97520651) {
            if (iHashCode == 109399814 && str.equals("shake")) {
                b11 = 0;
            } else {
                b11 = -1;
            }
        } else if (str.equals("flick")) {
            b11 = 1;
        } else {
            b11 = -1;
        }
        if (b11 == 0) {
            this.zza.zzl(zzdyz.SHAKE);
        } else if (b11 != 1) {
            this.zza.zzl(zzdyz.NONE);
        } else {
            this.zza.zzl(zzdyz.FLICK);
        }
    }
}
