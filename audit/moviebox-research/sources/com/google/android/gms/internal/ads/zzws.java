package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzws {
    public final int zzc;
    private final zzgaa zze;
    private int zzf;
    public static final zzws zza = new zzws(new zzcz[0]);
    private static final String zzd = Integer.toString(0, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzwr
    };

    /* JADX WARN: Multi-variable type inference failed */
    public zzws(zzcz... zzczVarArr) {
        this.zze = zzgaa.zzk(zzczVarArr);
        this.zzc = zzczVarArr.length;
        int i11 = 0;
        while (i11 < this.zze.size()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.zze.size(); i13++) {
                if (((zzcz) this.zze.get(i11)).equals(this.zze.get(i13))) {
                    zzff.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i11 = i12;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzws.class == obj.getClass()) {
            zzws zzwsVar = (zzws) obj;
            if (this.zzc == zzwsVar.zzc && this.zze.equals(zzwsVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzf;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = this.zze.hashCode();
        this.zzf = iHashCode;
        return iHashCode;
    }

    public final int zza(zzcz zzczVar) {
        int iIndexOf = this.zze.indexOf(zzczVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzcz zzb(int i11) {
        return (zzcz) this.zze.get(i11);
    }
}
