package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetn implements zzexq {

    @Nullable
    private final zzfdk zza;

    public zzetn(@Nullable zzfdk zzfdkVar) {
        this.zza = zzfdkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 15;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        zzfdk zzfdkVar = this.zza;
        zzexp zzexpVar = null;
        if (zzfdkVar != null && zzfdkVar.zza() != null && !zzfdkVar.zza().isEmpty()) {
            zzexpVar = new zzexp() { // from class: com.google.android.gms.internal.ads.zzetm
                @Override // com.google.android.gms.internal.ads.zzexp
                public final void zzj(Object obj) {
                    this.zza.zzc((Bundle) obj);
                }
            };
        }
        return zzgen.zzh(zzexpVar);
    }

    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
