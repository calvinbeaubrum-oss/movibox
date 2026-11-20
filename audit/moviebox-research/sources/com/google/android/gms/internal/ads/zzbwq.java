package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwq extends RemoteCreator {
    public zzbwq() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzbww ? (zzbww) iInterfaceQueryLocalInterface : new zzbwu(iBinder);
    }

    @Nullable
    public final zzbwt zza(Activity activity) {
        try {
            IBinder iBinderZze = ((zzbww) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return iInterfaceQueryLocalInterface instanceof zzbwt ? (zzbwt) iInterfaceQueryLocalInterface : new zzbwr(iBinderZze);
        } catch (RemoteException e11) {
            zzcec.zzk("Could not create remote AdOverlay.", e11);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e12) {
            zzcec.zzk("Could not create remote AdOverlay.", e12);
            return null;
        }
    }
}
