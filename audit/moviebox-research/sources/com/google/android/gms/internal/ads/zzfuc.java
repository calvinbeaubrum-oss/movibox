package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class zzfuc {
    static final String zza = new UUID(0, 0).toString();
    final zzfud zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public zzfuc(Context context, String str, String str2, String str3) {
        this.zzb = zzfud.zzb(context);
        this.zzc = str;
        this.zzd = str.concat("_3p");
        this.zze = str2;
        this.zzf = str2.concat("_3p");
        this.zzg = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            return UUID.nameUUIDFromBytes((str + str2 + str3).getBytes(StandardCharsets.UTF_8)).toString();
        }
        String str4 = this.zzg;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        sb2.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
        sb2.append(str2 == null ? "null" : "not null");
        sb2.append(", hashKey is ");
        sb2.append(str3 == null ? "null" : "not null");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final long zza(boolean z11) {
        return this.zzb.zza(z11 ? this.zzf : this.zze, -1L);
    }

    public final zzfub zzb(@Nullable String str, @Nullable String str2, long j11, boolean z11) throws IOException {
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String strZze = zze(true);
                    String strZzc = this.zzb.zzc("paid_3p_hash_key", null);
                    if (strZze != null && strZzc != null && !strZze.equals(zzh(str, str2, strZzc))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfub();
        }
        boolean z12 = str != null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        long jZza = zza(z12);
        if (jZza != -1) {
            if (jCurrentTimeMillis < jZza) {
                this.zzb.zzd(z12 ? this.zzf : this.zze, Long.valueOf(jCurrentTimeMillis));
            } else if (jCurrentTimeMillis >= jZza + j11) {
                return zzc(str, str2);
            }
        }
        String strZze2 = zze(z12);
        return (strZze2 != null || z11) ? new zzfub(strZze2, zza(z12)) : zzc(str, str2);
    }

    public final zzfub zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String string = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", string);
        return zzd(zzh(str, str2, string), true);
    }

    public final zzfub zzd(String str, boolean z11) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        this.zzb.zzd(z11 ? this.zzf : this.zze, Long.valueOf(jCurrentTimeMillis));
        this.zzb.zzd(z11 ? this.zzd : this.zzc, str);
        return new zzfub(str, jCurrentTimeMillis);
    }

    public final String zze(boolean z11) {
        return this.zzb.zzc(z11 ? this.zzd : this.zzc, null);
    }

    public final void zzf(boolean z11) throws IOException {
        this.zzb.zze(z11 ? this.zzf : this.zze);
        this.zzb.zze(z11 ? this.zzd : this.zzc);
    }

    public final boolean zzg(boolean z11) {
        return this.zzb.zzg(this.zzc);
    }
}
