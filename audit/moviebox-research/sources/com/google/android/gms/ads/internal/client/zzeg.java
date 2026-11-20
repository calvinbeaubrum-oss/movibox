package com.google.android.gms.ads.internal.client;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzeg extends zzcz {
    private zzeg() {
    }

    public /* synthetic */ zzeg(zzef zzefVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzda
    public final void zze(@Nullable zze zzeVar) {
        OnAdInspectorClosedListener onAdInspectorClosedListener = zzej.zzf().zzh;
        if (onAdInspectorClosedListener != null) {
            onAdInspectorClosedListener.onAdInspectorClosed(zzeVar == null ? null : new AdInspectorError(zzeVar.zza, zzeVar.zzb, zzeVar.zzc));
        }
    }
}
