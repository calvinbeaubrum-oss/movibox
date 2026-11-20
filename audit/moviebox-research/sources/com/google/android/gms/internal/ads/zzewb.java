package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewb implements zzexq {

    @Nullable
    private final Bundle zza;

    public zzewb(@Nullable Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 30;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return zzgen.zzh(new zzewc(this.zza));
    }
}
