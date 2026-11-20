package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdk {
    private final zzgaa zzd;
    public static final zzdk zza = new zzdk(zzgaa.zzl());
    private static final String zzc = Integer.toString(0, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzdh
    };

    public zzdk(List list) {
        this.zzd = zzgaa.zzj(list);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdk.class != obj.getClass()) {
            return false;
        }
        return this.zzd.equals(((zzdk) obj).zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final zzgaa zza() {
        return this.zzd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzb(int i11) {
        for (int i12 = 0; i12 < this.zzd.size(); i12++) {
            zzdj zzdjVar = (zzdj) this.zzd.get(i12);
            if (zzdjVar.zzc() && zzdjVar.zza() == i11) {
                return true;
            }
        }
        return false;
    }
}
