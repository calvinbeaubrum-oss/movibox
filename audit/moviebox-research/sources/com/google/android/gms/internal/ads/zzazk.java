package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazk {
    private final Object zza = new Object();
    private zzazi zzb = null;
    private boolean zzc = false;

    @Nullable
    public final Activity zza() {
        synchronized (this.zza) {
            try {
                zzazi zzaziVar = this.zzb;
                if (zzaziVar == null) {
                    return null;
                }
                return zzaziVar.zza();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public final Context zzb() {
        synchronized (this.zza) {
            try {
                zzazi zzaziVar = this.zzb;
                if (zzaziVar == null) {
                    return null;
                }
                return zzaziVar.zzb();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzc(zzazj zzazjVar) {
        synchronized (this.zza) {
            try {
                if (this.zzb == null) {
                    this.zzb = new zzazi();
                }
                this.zzb.zzf(zzazjVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            try {
                if (!this.zzc) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        zzcec.zzj("Can not cast Context to Application");
                        return;
                    }
                    if (this.zzb == null) {
                        this.zzb = new zzazi();
                    }
                    this.zzb.zzg(application, context);
                    this.zzc = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zze(zzazj zzazjVar) {
        synchronized (this.zza) {
            try {
                zzazi zzaziVar = this.zzb;
                if (zzaziVar == null) {
                    return;
                }
                zzaziVar.zzh(zzazjVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
