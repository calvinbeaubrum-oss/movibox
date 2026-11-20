package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwh implements NativeCustomFormatAd {
    private final zzbkg zza;
    private NativeCustomFormatAd.DisplayOpenMeasurement zzb;

    public zzbwh(zzbkg zzbkgVar) {
        this.zza = zzbkgVar;
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    public final void destroy() {
        try {
            this.zza.zzl();
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    @Nullable
    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    @Nullable
    public final String getCustomFormatId() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    public final NativeCustomFormatAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzb == null && this.zza.zzq()) {
                this.zzb = new zzbvz(this.zza);
            }
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    @Nullable
    public final NativeAd.Image getImage(String str) {
        try {
            zzbjm zzbjmVarZzg = this.zza.zzg(str);
            if (zzbjmVarZzg != null) {
                return new zzbwa(zzbjmVarZzg);
            }
            return null;
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    @Nullable
    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzf() != null) {
                return new com.google.android.gms.ads.internal.client.zzep(this.zza.zzf(), this.zza);
            }
            return null;
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    @Nullable
    public final CharSequence getText(String str) {
        try {
            return this.zza.zzj(str);
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    public final void performClick(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd
    public final void recordImpression() {
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
    }
}
