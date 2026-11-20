package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbkh {
    private final zzbkg zza;
    private final MediaView zzb;
    private final VideoController zzc = new VideoController();

    public zzbkh(zzbkg zzbkgVar) {
        Context context;
        this.zza = zzbkgVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbkgVar.zzh());
        } catch (RemoteException | NullPointerException e11) {
            zzcec.zzh("", e11);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (true == this.zza.zzs(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e12) {
                zzcec.zzh("", e12);
            }
        }
        this.zzb = mediaView;
    }

    public final zzbkg zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            return null;
        }
    }
}
