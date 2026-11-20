package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwa extends NativeAd.Image {
    private final zzbjm zza;

    @Nullable
    private final Drawable zzb;

    @Nullable
    private final Uri zzc;
    private final double zzd;

    public zzbwa(zzbjm zzbjmVar) {
        Drawable drawable;
        double dZzb;
        this.zza = zzbjmVar;
        Uri uriZze = null;
        try {
            IObjectWrapper iObjectWrapperZzf = zzbjmVar.zzf();
            drawable = iObjectWrapperZzf != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf) : null;
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
        this.zzb = drawable;
        try {
            uriZze = this.zza.zze();
        } catch (RemoteException e12) {
            zzcec.zzh("", e12);
        }
        this.zzc = uriZze;
        try {
            dZzb = this.zza.zzb();
        } catch (RemoteException e13) {
            zzcec.zzh("", e13);
            dZzb = 1.0d;
        }
        this.zzd = dZzb;
        try {
            this.zza.zzd();
        } catch (RemoteException e14) {
            zzcec.zzh("", e14);
        }
        try {
            this.zza.zzc();
        } catch (RemoteException e15) {
            zzcec.zzh("", e15);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    @Nullable
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    @Nullable
    public final Uri getUri() {
        return this.zzc;
    }
}
