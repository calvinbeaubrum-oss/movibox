package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcax implements RewardItem {
    private final zzcak zza;

    public zzcax(zzcak zzcakVar) {
        this.zza = zzcakVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzcak zzcakVar = this.zza;
        if (zzcakVar != null) {
            try {
                return zzcakVar.zze();
            } catch (RemoteException e11) {
                zzcec.zzk("Could not forward getAmount to RewardItem", e11);
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    @Nullable
    public final String getType() {
        zzcak zzcakVar = this.zza;
        if (zzcakVar != null) {
            try {
                return zzcakVar.zzf();
            } catch (RemoteException e11) {
                zzcec.zzk("Could not forward getType to RewardItem", e11);
            }
        }
        return null;
    }
}
