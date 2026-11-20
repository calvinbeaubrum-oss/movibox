package com.google.android.gms.internal.play_billing;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcb extends zzbw {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzbv zzc;

    /* JADX INFO: compiled from: source.java */
    final class zza {
        public static boolean zza() {
            return zzcb.zzt();
        }
    }

    static {
        String str = Build.FINGERPRINT;
        boolean z11 = true;
        if (str != null && !"robolectric".equals(str)) {
            z11 = false;
        }
        zzb = z11;
        zzc = new zzbv() { // from class: com.google.android.gms.internal.play_billing.zzcb.1
            @Override // com.google.android.gms.internal.play_billing.zzbv
            public zzaz zza(Class<?> cls, int i11) {
                return zzaz.zza;
            }

            @Override // com.google.android.gms.internal.play_billing.zzbv
            public String zzb(Class cls) {
                StackTraceElement stackTraceElementZza;
                if (zzcb.zza) {
                    try {
                        if (cls.equals(zzcb.zzp())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzcb.zzb || (stackTraceElementZza = zzcz.zza(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementZza.getClassName();
            }
        };
    }

    public static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    public static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", new Class[0]);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public zzbf zze(String str) {
        return zzce.zzb(str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public zzbv zzh() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public zzcl zzj() {
        return zzcf.zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public String zzm() {
        return "platform: Android";
    }
}
