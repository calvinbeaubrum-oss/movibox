package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbga implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;

    @Nullable
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();

    private final void zzd(final SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            this.zzh = new JSONObject((String) zzbgh.zza(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzbfx
                @Override // com.google.android.gms.internal.ads.zzfxu
                public final Object zza() {
                    return sharedPreferences.getString("flag_configuration", "{}");
                }
            }));
        } catch (JSONException unused) {
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzd(sharedPreferences);
        }
    }

    public final Object zza(final zzbfu zzbfuVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                try {
                    if (!this.zza) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null) {
                }
                return zzbfuVar.zzm();
            }
        }
        if (zzbfuVar.zze() != 2) {
            return (zzbfuVar.zze() == 1 && this.zzh.has(zzbfuVar.zzn())) ? zzbfuVar.zza(this.zzh) : zzbgh.zza(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzbfy
                @Override // com.google.android.gms.internal.ads.zzfxu
                public final Object zza() {
                    return this.zza.zzb(zzbfuVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbfuVar.zzm() : zzbfuVar.zzb(bundle);
    }

    public final /* synthetic */ Object zzb(zzbfu zzbfuVar) {
        return zzbfuVar.zzc(this.zze);
    }

    public final void zzc(Context context) {
        if (this.zzd) {
            return;
        }
        synchronized (this.zzb) {
            try {
                if (this.zzd) {
                    return;
                }
                if (!this.zza) {
                    this.zza = true;
                }
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.zzg = context;
                try {
                    this.zzf = Wrappers.packageManager(context).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                }
                try {
                    Context context2 = this.zzg;
                    Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context2);
                    if (remoteContext != null || context2 == null || (remoteContext = context2.getApplicationContext()) != null) {
                        context2 = remoteContext;
                    }
                    if (context2 == null) {
                        this.zza = false;
                        this.zzc.open();
                        return;
                    }
                    com.google.android.gms.ads.internal.client.zzba.zzb();
                    SharedPreferences sharedPreferencesZza = zzbfw.zza(context2);
                    this.zze = sharedPreferencesZza;
                    if (sharedPreferencesZza != null) {
                        sharedPreferencesZza.registerOnSharedPreferenceChangeListener(this);
                    }
                    zzbis.zzc(new zzbfz(this, this.zze));
                    zzd(this.zze);
                    this.zzd = true;
                    this.zza = false;
                    this.zzc.open();
                } catch (Throwable th2) {
                    this.zza = false;
                    this.zzc.open();
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
