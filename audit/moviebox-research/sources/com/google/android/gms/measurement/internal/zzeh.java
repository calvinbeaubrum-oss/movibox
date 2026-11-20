package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeh extends zzgl {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzef zzd;
    private final zzef zze;
    private final zzef zzf;
    private final zzef zzg;
    private final zzef zzh;
    private final zzef zzi;
    private final zzef zzj;
    private final zzef zzk;
    private final zzef zzl;

    public zzeh(zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzef(this, 6, false, false);
        this.zze = new zzef(this, 6, true, false);
        this.zzf = new zzef(this, 6, false, true);
        this.zzg = new zzef(this, 5, false, false);
        this.zzh = new zzef(this, 5, true, false);
        this.zzi = new zzef(this, 5, false, true);
        this.zzj = new zzef(this, 4, false, false);
        this.zzk = new zzef(this, 3, false, false);
        this.zzl = new zzef(this, 2, false, false);
    }

    public static Object zzn(String str) {
        if (str == null) {
            return null;
        }
        return new zzeg(str);
    }

    public static String zzo(boolean z11, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZzp = zzp(z11, obj);
        String strZzp2 = zzp(z11, obj2);
        String strZzp3 = zzp(z11, obj3);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZzp)) {
            sb2.append(str2);
            sb2.append(strZzp);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZzp2)) {
            str3 = str2;
        } else {
            sb2.append(str2);
            sb2.append(strZzp2);
        }
        if (!TextUtils.isEmpty(strZzp3)) {
            sb2.append(str3);
            sb2.append(strZzp3);
        }
        return sb2.toString();
    }

    @VisibleForTesting
    public static String zzp(boolean z11, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z11) {
                return obj.toString();
            }
            Long l11 = (Long) obj;
            if (Math.abs(l11.longValue()) < 100) {
                return obj.toString();
            }
            String str = obj.toString().charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l11.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof zzeg) {
                return ((zzeg) obj).zza;
            }
            return z11 ? "-" : obj.toString();
        }
        Throwable th2 = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z11 ? th2.getClass().getName() : th2.toString());
        String strZzy = zzy(zzfr.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzy(className).equals(strZzy)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
        }
        return sb2.toString();
    }

    private static String zzy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public final zzef zzc() {
        return this.zzk;
    }

    public final zzef zzd() {
        return this.zzd;
    }

    public final zzef zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return false;
    }

    public final zzef zzh() {
        return this.zze;
    }

    public final zzef zzi() {
        return this.zzj;
    }

    public final zzef zzj() {
        return this.zzl;
    }

    public final zzef zzk() {
        return this.zzg;
    }

    public final zzef zzl() {
        return this.zzi;
    }

    public final zzef zzm() {
        return this.zzh;
    }

    @VisibleForTesting
    public final String zzq() {
        String str;
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    if (this.zzt.zzy() != null) {
                        this.zzc = this.zzt.zzy();
                    } else {
                        this.zzc = this.zzt.zzf().zzn();
                    }
                }
                Preconditions.checkNotNull(this.zzc);
                str = this.zzc;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public final void zzt(int i11, boolean z11, boolean z12, String str, Object obj, Object obj2, Object obj3) {
        if (!z11 && Log.isLoggable(zzq(), i11)) {
            Log.println(i11, zzq(), zzo(false, str, obj, obj2, obj3));
        }
        if (z12 || i11 < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzfo zzfoVarZzo = this.zzt.zzo();
        if (zzfoVarZzo == null) {
            Log.println(6, zzq(), "Scheduler not set. Not logging error/warn");
        } else if (zzfoVarZzo.zzx()) {
            zzfoVarZzo.zzp(new zzee(this, i11 >= 9 ? 8 : i11, str, obj, obj2, obj3));
        } else {
            Log.println(6, zzq(), "Scheduler not initialized. Not logging error/warn");
        }
    }
}
