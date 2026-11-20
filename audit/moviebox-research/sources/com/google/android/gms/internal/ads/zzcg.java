package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcg {
    public final float zzc;
    public final float zzd;
    private final int zzg;
    public static final zzcg zza = new zzcg(1.0f, 1.0f);
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzcf
    };

    public zzcg(float f11, float f12) {
        zzek.zzd(f11 > 0.0f);
        zzek.zzd(f12 > 0.0f);
        this.zzc = f11;
        this.zzd = f12;
        this.zzg = Math.round(f11 * 1000.0f);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcg.class == obj.getClass()) {
            zzcg zzcgVar = (zzcg) obj;
            if (this.zzc == zzcgVar.zzc && this.zzd == zzcgVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzc) + 527) * 31) + Float.floatToRawIntBits(this.zzd);
    }

    public final String toString() {
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.zzc), Float.valueOf(this.zzd));
    }

    public final long zza(long j11) {
        return j11 * ((long) this.zzg);
    }
}
