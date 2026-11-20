package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbxq {
    private final View zza;

    @Nullable
    private final Map zzb;

    @Nullable
    private final zzcct zzc;

    public zzbxq(zzbxp zzbxpVar) {
        View view = zzbxpVar.zza;
        this.zza = view;
        Map map = zzbxpVar.zzb;
        this.zzb = map;
        zzcct zzcctVarZza = zzbxk.zza(zzbxpVar.zza.getContext());
        this.zzc = zzcctVarZza;
        if (zzcctVarZza == null || map.isEmpty()) {
            return;
        }
        try {
            zzcctVarZza.zzg(new zzbxr(ObjectWrapper.wrap(view).asBinder(), ObjectWrapper.wrap(map).asBinder()));
        } catch (RemoteException unused) {
            zzcec.zzg("Failed to call remote method.");
        }
    }

    public final void zza(List list) {
        if (list == null || list.isEmpty()) {
            zzcec.zzj("No click urls were passed to recordClick");
            return;
        }
        if (this.zzc == null) {
            zzcec.zzj("Failed to get internal reporting info generator in recordClick.");
        }
        try {
            this.zzc.zzh(list, ObjectWrapper.wrap(this.zza), new zzbxo(this, list));
        } catch (RemoteException e11) {
            zzcec.zzg("RemoteException recording click: ".concat(e11.toString()));
        }
    }

    public final void zzb(List list) {
        if (list == null || list.isEmpty()) {
            zzcec.zzj("No impression urls were passed to recordImpression");
            return;
        }
        zzcct zzcctVar = this.zzc;
        if (zzcctVar == null) {
            zzcec.zzj("Failed to get internal reporting info generator from recordImpression.");
            return;
        }
        try {
            zzcctVar.zzi(list, ObjectWrapper.wrap(this.zza), new zzbxn(this, list));
        } catch (RemoteException e11) {
            zzcec.zzg("RemoteException recording impression urls: ".concat(e11.toString()));
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzcct zzcctVar = this.zzc;
        if (zzcctVar == null) {
            zzcec.zze("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzcctVar.zzk(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzcec.zzg("Failed to call remote method.");
        }
    }

    public final void zzd(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzl(new ArrayList(Arrays.asList(uri)), ObjectWrapper.wrap(this.zza), new zzbxm(this, updateClickUrlCallback));
        } catch (RemoteException e11) {
            updateClickUrlCallback.onFailure("Internal error: ".concat(e11.toString()));
        }
    }

    public final void zze(List list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzm(list, ObjectWrapper.wrap(this.zza), new zzbxl(this, updateImpressionUrlsCallback));
        } catch (RemoteException e11) {
            updateImpressionUrlsCallback.onFailure("Internal error: ".concat(e11.toString()));
        }
    }
}
