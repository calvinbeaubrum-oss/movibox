package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcch {
    private final AtomicReference zzb = new AtomicReference(null);
    private final Object zzc = new Object();

    @Nullable
    private String zzd = null;
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final AtomicInteger zze = new AtomicInteger(-1);
    private final AtomicReference zzf = new AtomicReference(null);
    private final AtomicReference zzg = new AtomicReference(null);
    private final ConcurrentMap zzh = new ConcurrentHashMap(9);
    private final AtomicReference zzi = new AtomicReference(null);
    private final BlockingQueue zzj = new ArrayBlockingQueue(20);
    private final Object zzk = new Object();

    public static final boolean zzq(Context context) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzah)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzai)).intValue()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaj)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    @Nullable
    private final Object zzr(String str, Context context) {
        if (!zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            return null;
        }
        try {
            return zzs(context, str).invoke(this.zzf.get(), new Object[0]);
        } catch (Exception unused) {
            zzv(str, true);
            return null;
        }
    }

    @Nullable
    private final Method zzs(Context context, String str) {
        Method method = (Method) this.zzh.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzh.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzv(str, false);
            return null;
        }
    }

    private final void zzt(Context context, String str, String str2) {
        if (zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            Method declaredMethod = (Method) this.zzh.get(str2);
            if (declaredMethod == null) {
                try {
                    declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str2, String.class);
                    this.zzh.put(str2, declaredMethod);
                } catch (Exception unused) {
                    zzv(str2, false);
                    declaredMethod = null;
                }
            }
            try {
                declaredMethod.invoke(this.zzf.get(), str);
                com.google.android.gms.ads.internal.util.zze.zza("Invoke Firebase method " + str2 + ", Ad Unit Id: " + str);
            } catch (Exception unused2) {
                zzv(str2, false);
            }
        }
    }

    private final void zzu(Context context, String str, String str2, @Nullable Bundle bundle) {
        if (zzp(context)) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong(str2));
            } catch (NullPointerException | NumberFormatException e11) {
                zzcec.zzh("Invalid event ID: ".concat(String.valueOf(str2)), e11);
            }
            if ("_ac".equals(str)) {
                bundle2.putInt("_r", 1);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
                Method declaredMethod = (Method) this.zzh.get("logEventInternal");
                if (declaredMethod == null) {
                    try {
                        declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
                        this.zzh.put("logEventInternal", declaredMethod);
                    } catch (Exception unused) {
                        zzv("logEventInternal", true);
                        declaredMethod = null;
                    }
                }
                try {
                    declaredMethod.invoke(this.zzf.get(), "am", str, bundle2);
                } catch (Exception unused2) {
                    zzv("logEventInternal", true);
                }
            }
        }
    }

    private final void zzv(String str, boolean z11) {
        if (this.zza.get()) {
            return;
        }
        zzcec.zzj("Invoke Firebase method " + str + " error.");
        if (z11) {
            zzcec.zzj("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zza.set(true);
        }
    }

    private final boolean zzw(Context context, String str, AtomicReference atomicReference, boolean z11) {
        if (atomicReference.get() == null) {
            try {
                zzcce.zza(atomicReference, null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception unused) {
                zzv("getInstance", z11);
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final String zza(Context context) {
        Object objZzr;
        if (zzp(context) && (objZzr = zzr("generateEventId", context)) != null) {
            return objZzr.toString();
        }
        return null;
    }

    @Nullable
    public final String zzb(final Context context) {
        ExecutorService threadPoolExecutor;
        if (!zzp(context)) {
            return null;
        }
        long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaf)).longValue();
        if (jLongValue < 0) {
            return (String) zzr("getAppInstanceId", context);
        }
        if (this.zzb.get() == null) {
            if (ClientLibraryUtils.isPackageSide()) {
                threadPoolExecutor = zzfts.zza().zzc(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzag)).intValue(), new zzccg(this), 2);
            } else {
                zzbfu zzbfuVar = zzbgc.zzag;
                threadPoolExecutor = new ThreadPoolExecutor(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzccg(this));
            }
            zzcce.zza(this.zzb, null, threadPoolExecutor);
        }
        try {
            return (String) ((ExecutorService) this.zzb.get()).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzccf
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zze(context);
                }
            }).get(jLongValue, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            return "TIME_OUT";
        } catch (Exception unused2) {
            return null;
        }
    }

    public final String zzc(Context context) {
        if (zzp(context) && zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            try {
                String str = (String) zzs(context, "getCurrentScreenName").invoke(this.zzf.get(), new Object[0]);
                if (str == null) {
                    str = (String) zzs(context, "getCurrentScreenClass").invoke(this.zzf.get(), new Object[0]);
                }
                return str == null ? "" : str;
            } catch (Exception unused) {
                zzv("getCurrentScreenName", false);
            }
        }
        return "";
    }

    @Nullable
    public final String zzd(Context context) {
        if (!zzp(context)) {
            return null;
        }
        synchronized (this.zzc) {
            try {
                String str = this.zzd;
                if (str != null) {
                    return str;
                }
                String str2 = (String) zzr("getGmpAppId", context);
                this.zzd = str2;
                return str2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ String zze(Context context) throws Exception {
        return (String) zzr("getAppInstanceId", context);
    }

    public final void zzf(Context context, String str) {
        if (zzp(context)) {
            zzt(context, str, "beginAdUnitExposure");
        }
    }

    public final void zzg(Context context, String str) {
        if (zzp(context)) {
            zzt(context, str, "endAdUnitExposure");
        }
    }

    public final void zzh(Context context, String str) {
        zzu(context, "_aa", str, null);
    }

    public final void zzi(Context context, String str) {
        zzu(context, "_aq", str, null);
    }

    public final void zzj(Context context, String str) {
        zzu(context, "_ac", str, null);
    }

    public final void zzk(Context context, String str) {
        zzu(context, "_ai", str, null);
    }

    public final void zzl(Context context, String str, String str2, String str3, int i11) {
        if (zzp(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i11);
            zzu(context, "_ar", str, bundle);
            com.google.android.gms.ads.internal.util.zze.zza("Log a Firebase reward video event, reward type: " + str3 + ", reward value: " + i11);
        }
    }

    public final void zzm(Context context, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzam)).booleanValue() && zzp(context) && zzq(context)) {
            synchronized (this.zzk) {
            }
        }
    }

    public final void zzn(Context context, com.google.android.gms.ads.internal.client.zzff zzffVar) {
        zzcci.zzd(context).zzb().zzc(zzffVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzam)).booleanValue() && zzp(context) && zzq(context)) {
            synchronized (this.zzk) {
            }
        }
    }

    @Deprecated
    public final void zzo(Context context, String str) {
        if (zzp(context) && (context instanceof Activity) && zzw(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzg, false)) {
            Method declaredMethod = (Method) this.zzh.get("setCurrentScreen");
            if (declaredMethod == null) {
                try {
                    declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", Activity.class, String.class, String.class);
                    this.zzh.put("setCurrentScreen", declaredMethod);
                } catch (Exception unused) {
                    zzv("setCurrentScreen", false);
                    declaredMethod = null;
                }
            }
            try {
                declaredMethod.invoke(this.zzg.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception unused2) {
                zzv("setCurrentScreen", false);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0059  */
    public final boolean zzp(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaa)).booleanValue() && !this.zza.get()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzak)).booleanValue()) {
                return true;
            }
            if (this.zze.get() == -1) {
                com.google.android.gms.ads.internal.client.zzay.zzb();
                if (zzcdv.zzs(context, 12451000)) {
                    this.zze.set(1);
                } else {
                    com.google.android.gms.ads.internal.client.zzay.zzb();
                    if (zzcdv.zzt(context)) {
                        zzcec.zzj("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zze.set(0);
                    } else {
                        this.zze.set(1);
                    }
                }
            }
            if (this.zze.get() == 1) {
                return true;
            }
        }
        return false;
    }
}
