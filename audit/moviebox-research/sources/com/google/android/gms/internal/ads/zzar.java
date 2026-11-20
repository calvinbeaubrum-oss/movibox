package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzar {

    @Nullable
    private String zza;

    @Nullable
    private Uri zzb;
    private final zzat zzc = new zzat();
    private final zzba zzd = new zzba(null);
    private final List zze = Collections.emptyList();
    private final zzgaa zzf = zzgaa.zzl();
    private final zzbd zzg = new zzbd();
    private final zzbl zzh = zzbl.zza;

    public final zzar zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzar zzb(@Nullable Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzbp zzc() {
        zzbi zzbiVar;
        Uri uri = this.zzb;
        if (uri != null) {
            zzbiVar = new zzbi(uri, null, null, null, this.zze, null, this.zzf, null, C.TIME_UNSET, null);
        } else {
            zzbiVar = null;
        }
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzbp(str, new zzax(this.zzc, null), zzbiVar, new zzbf(this.zzg), zzbv.zza, this.zzh, null);
    }
}
