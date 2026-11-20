package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbvy extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbvy(zzbjf zzbjfVar) {
        try {
            this.zzb = zzbjfVar.zzg();
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            this.zzb = "";
        }
        try {
            for (Object obj : zzbjfVar.zzh()) {
                zzbjm zzbjmVarZzg = obj instanceof IBinder ? zzbjl.zzg((IBinder) obj) : null;
                if (zzbjmVarZzg != null) {
                    this.zza.add(new zzbwa(zzbjmVarZzg));
                }
            }
        } catch (RemoteException e12) {
            zzcec.zzh("", e12);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzb;
    }
}
