package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzexj implements zzexq {
    private final boolean zza;

    public zzexj(@Nullable zzfeh zzfehVar) {
        this.zza = zzfehVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return zzgen.zzh(this.zza ? new zzexp() { // from class: com.google.android.gms.internal.ads.zzexi
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                ((Bundle) obj).putBoolean("sdk_prefetch", true);
            }
        } : null);
    }
}
