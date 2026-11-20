package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhe extends androidx.browser.customtabs.c {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final List zzb = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjD)).split(","));
    private final zzbhh zzc;

    @Nullable
    private final androidx.browser.customtabs.c zzd;

    public zzbhe(@NonNull zzbhh zzbhhVar, @Nullable androidx.browser.customtabs.c cVar) {
        this.zzd = cVar;
        this.zzc = zzbhhVar;
    }

    @Override // androidx.browser.customtabs.c
    public final void extraCallback(String str, @Nullable Bundle bundle) {
        androidx.browser.customtabs.c cVar = this.zzd;
        if (cVar != null) {
            cVar.extraCallback(str, bundle);
        }
    }

    @Override // androidx.browser.customtabs.c
    @Nullable
    public final Bundle extraCallbackWithResult(String str, @Nullable Bundle bundle) {
        androidx.browser.customtabs.c cVar = this.zzd;
        if (cVar != null) {
            return cVar.extraCallbackWithResult(str, bundle);
        }
        return null;
    }

    @Override // androidx.browser.customtabs.c
    public final void onActivityResized(int i11, int i12, Bundle bundle) {
        androidx.browser.customtabs.c cVar = this.zzd;
        if (cVar != null) {
            cVar.onActivityResized(i11, i12, bundle);
        }
    }

    @Override // androidx.browser.customtabs.c
    public final void onMessageChannelReady(@Nullable Bundle bundle) {
        this.zza.set(false);
        androidx.browser.customtabs.c cVar = this.zzd;
        if (cVar != null) {
            cVar.onMessageChannelReady(bundle);
        }
    }

    @Override // androidx.browser.customtabs.c
    public final void onNavigationEvent(int i11, @Nullable Bundle bundle) {
        List list;
        this.zza.set(false);
        androidx.browser.customtabs.c cVar = this.zzd;
        if (cVar != null) {
            cVar.onNavigationEvent(i11, bundle);
        }
        this.zzc.zzi(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
        if (this.zzc == null || (list = this.zzb) == null || !list.contains(String.valueOf(i11))) {
            return;
        }
        this.zzc.zzf();
    }

    @Override // androidx.browser.customtabs.c
    public final void onPostMessage(String str, @Nullable Bundle bundle) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("gpa", -1) == 0) {
                this.zza.set(true);
                this.zzc.zzh(jSONObject.getString("paw_id"));
            }
        } catch (JSONException e11) {
            com.google.android.gms.ads.internal.util.zze.zzb("Message is not in JSON format: ", e11);
        }
        androidx.browser.customtabs.c cVar = this.zzd;
        if (cVar != null) {
            cVar.onPostMessage(str, bundle);
        }
    }

    @Override // androidx.browser.customtabs.c
    public final void onRelationshipValidationResult(int i11, Uri uri, boolean z11, @Nullable Bundle bundle) {
        androidx.browser.customtabs.c cVar = this.zzd;
        if (cVar != null) {
            cVar.onRelationshipValidationResult(i11, uri, z11, bundle);
        }
    }

    public final Boolean zza() {
        return Boolean.valueOf(this.zza.get());
    }
}
