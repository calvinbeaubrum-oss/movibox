package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbe extends zzcaj {
    private final String zza;
    private final int zzb;

    public zzcbe(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzcbe(String str, int i11) {
        this.zza = str;
        this.zzb = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzcak
    public final int zze() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcak
    public final String zzf() throws RemoteException {
        return this.zza;
    }
}
