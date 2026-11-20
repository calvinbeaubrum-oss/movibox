package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbkm extends zzayh implements zzbkn {
    public static zzbkn zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        return iInterfaceQueryLocalInterface instanceof zzbkn ? (zzbkn) iInterfaceQueryLocalInterface : new zzbkl(iBinder);
    }
}
