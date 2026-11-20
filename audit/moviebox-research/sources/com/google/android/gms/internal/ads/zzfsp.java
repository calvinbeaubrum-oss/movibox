package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfsp {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfsq zzc;
    private final zzfqr zzd;
    private final zzfqm zze;

    @Nullable
    private zzfse zzf;
    private final Object zzg = new Object();

    public zzfsp(@NonNull Context context, @NonNull zzfsq zzfsqVar, @NonNull zzfqr zzfqrVar, @NonNull zzfqm zzfqmVar) {
        this.zzb = context;
        this.zzc = zzfsqVar;
        this.zzd = zzfqrVar;
        this.zze = zzfqmVar;
    }

    private final synchronized Class zzd(@NonNull zzfsf zzfsfVar) throws zzfso {
        try {
            String strZzk = zzfsfVar.zza().zzk();
            HashMap map = zza;
            Class cls = (Class) map.get(strZzk);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.zze.zza(zzfsfVar.zzc())) {
                    throw new zzfso(2026, "VM did not pass signature verification");
                }
                try {
                    File fileZzb = zzfsfVar.zzb();
                    if (!fileZzb.exists()) {
                        fileZzb.mkdirs();
                    }
                    Class<?> clsLoadClass = new DexClassLoader(zzfsfVar.zzc().getAbsolutePath(), fileZzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    map.put(strZzk, clsLoadClass);
                    return clsLoadClass;
                } catch (ClassNotFoundException e11) {
                    e = e11;
                    throw new zzfso(2008, e);
                } catch (IllegalArgumentException e12) {
                    e = e12;
                    throw new zzfso(2008, e);
                } catch (SecurityException e13) {
                    e = e13;
                    throw new zzfso(2008, e);
                }
            } catch (GeneralSecurityException e14) {
                throw new zzfso(2026, e14);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Nullable
    public final zzfqu zza() {
        zzfse zzfseVar;
        synchronized (this.zzg) {
            zzfseVar = this.zzf;
        }
        return zzfseVar;
    }

    @Nullable
    public final zzfsf zzb() {
        synchronized (this.zzg) {
            try {
                zzfse zzfseVar = this.zzf;
                if (zzfseVar == null) {
                    return null;
                }
                return zzfseVar.zzf();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean zzc(@NonNull zzfsf zzfsfVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfse zzfseVar = new zzfse(zzd(zzfsfVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfsfVar.zze(), null, new Bundle(), 2), zzfsfVar, this.zzc, this.zzd);
                if (!zzfseVar.zzh()) {
                    throw new zzfso(4000, "init failed");
                }
                int iZze = zzfseVar.zze();
                if (iZze != 0) {
                    throw new zzfso(4001, "ci: " + iZze);
                }
                synchronized (this.zzg) {
                    try {
                        zzfse zzfseVar2 = this.zzf;
                        if (zzfseVar2 != null) {
                            try {
                                zzfseVar2.zzg();
                            } catch (zzfso e11) {
                                this.zzd.zzc(e11.zza(), -1L, e11);
                            }
                        }
                        this.zzf = zzfseVar;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.zzd.zzd(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e12) {
                throw new zzfso(2004, e12);
            }
        } catch (zzfso e13) {
            this.zzd.zzc(e13.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e13);
            return false;
        } catch (Exception e14) {
            this.zzd.zzc(TaErrorCode.CODE_DESTROY_BEFORE_FILLING, System.currentTimeMillis() - jCurrentTimeMillis, e14);
            return false;
        }
    }
}
