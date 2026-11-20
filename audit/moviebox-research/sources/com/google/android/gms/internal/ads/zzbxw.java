package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbxw implements zzbxy {
    public static zzbxy zza;
    static zzbxy zzb;
    static zzbxy zzc;
    private static final Object zzd = new Object();
    private final Context zzf;
    private final ExecutorService zzh;
    private final zzcei zzi;
    private final Object zze = new Object();
    private final WeakHashMap zzg = new WeakHashMap();

    public zzbxw(Context context, zzcei zzceiVar) {
        zzfts.zza();
        this.zzh = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zzf = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzi = zzceiVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0035 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0015, B:10:0x0027, B:13:0x0035, B:14:0x003c), top: B:19:0x0003 }] */
    public static zzbxy zza(Context context) {
        synchronized (zzd) {
            try {
                if (zza == null) {
                    if (((Boolean) zzbij.zze.zze()).booleanValue()) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhF)).booleanValue()) {
                            zza = new zzbxx();
                        } else {
                            zza = new zzbxw(context, zzcei.zza());
                        }
                    } else {
                        zza = new zzbxx();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zza;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0062 A[Catch: all -> 0x004e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0015, B:10:0x0027, B:12:0x0036, B:13:0x0038, B:16:0x0041, B:22:0x0052, B:23:0x0053, B:24:0x0062, B:25:0x0069, B:14:0x0039, B:15:0x0040), top: B:32:0x0003, inners: #0 }] */
    public static zzbxy zzb(Context context, zzcei zzceiVar) {
        synchronized (zzd) {
            if (zzc == null) {
                if (((Boolean) zzbij.zze.zze()).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhF)).booleanValue()) {
                        zzc = new zzbxx();
                    } else {
                        zzbxw zzbxwVar = new zzbxw(context, zzceiVar);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzbxwVar.zze) {
                                zzbxwVar.zzg.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzbxv(zzbxwVar, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzbxu(zzbxwVar, Thread.getDefaultUncaughtExceptionHandler()));
                        zzc = zzbxwVar;
                    }
                } else {
                    zzc = new zzbxx();
                }
            }
        }
        return zzc;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x002b, B:13:0x0039, B:14:0x0040), top: B:19:0x0003 }] */
    public static zzbxy zzc(Context context) {
        synchronized (zzd) {
            try {
                if (zzb == null) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhG)).booleanValue()) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhF)).booleanValue()) {
                            zzb = new zzbxx();
                        } else {
                            zzb = new zzbxw(context, zzcei.zza());
                        }
                    } else {
                        zzb = new zzbxx();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzb;
    }

    public static String zzd(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zze(Throwable th2) {
        return zzfxt.zzc(zzcdv.zzf(zzd(th2)));
    }

    public final void zzf(Thread thread, Throwable th2) {
        if (th2 != null) {
            boolean zZzo = false;
            boolean zEquals = false;
            for (Throwable cause = th2; cause != null; cause = cause.getCause()) {
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    zZzo |= zzcdv.zzo(stackTraceElement.getClassName());
                    zEquals |= zzbxw.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (!zZzo || zEquals) {
                return;
            }
            zzh(th2, "", 1.0f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxy
    public final void zzg(Throwable th2, String str) {
        zzh(th2, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzbxy
    public final void zzh(Throwable th2, String str, float f11) {
        Throwable th3;
        String packageName;
        Handler handler = zzcdv.zza;
        boolean zIsCallerInstantApp = false;
        if (((Boolean) zzbij.zzf.zze()).booleanValue()) {
            th3 = th2;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable cause = th2; cause != null; cause = cause.getCause()) {
                linkedList.push(cause);
            }
            th3 = null;
            while (!linkedList.isEmpty()) {
                Throwable th4 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th4.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z11 = false;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (zzcdv.zzo(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z11 = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z11) {
                    th3 = th3 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th3);
                    th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th3 == null) {
            return;
        }
        String name = th2.getClass().getName();
        String strZzd = zzd(th2);
        String strZze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziI)).booleanValue() ? zze(th2) : "";
        double d11 = f11;
        double dRandom = Math.random();
        int i11 = f11 > 0.0f ? (int) (1.0f / f11) : 1;
        if (dRandom < d11) {
            ArrayList<String> arrayList2 = new ArrayList();
            try {
                zIsCallerInstantApp = Wrappers.packageManager(this.zzf).isCallerInstantApp();
            } catch (Throwable th5) {
                zzcec.zzh("Error fetching instant app info", th5);
            }
            try {
                packageName = this.zzf.getPackageName();
            } catch (Throwable unused) {
                zzcec.zzj("Cannot obtain package name, proceeding.");
                packageName = AppLovinMediationProvider.UNKNOWN;
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zIsCallerInstantApp)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
            String str2 = Build.MANUFACTURER;
            String str3 = Build.MODEL;
            if (!str3.startsWith(str2)) {
                str3 = str2 + " " + str3;
            }
            Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("device", str3).appendQueryParameter("js", this.zzi.zza).appendQueryParameter(SafeStringUtils.SP_APPID, packageName).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", strZzd).appendQueryParameter("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzba.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "610756093").appendQueryParameter(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, "dev").appendQueryParameter("sampling_rate", Integer.toString(i11)).appendQueryParameter("pb_tm", String.valueOf(zzbij.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzf))).appendQueryParameter("lite", true != this.zzi.zze ? "0" : "1");
            if (!TextUtils.isEmpty(strZze)) {
                builderAppendQueryParameter2.appendQueryParameter("hash", strZze);
            }
            arrayList2.add(builderAppendQueryParameter2.toString());
            for (final String str4 : arrayList2) {
                final zzceh zzcehVar = new zzceh(null);
                this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxt
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcehVar.zza(str4);
                    }
                });
            }
        }
    }
}
