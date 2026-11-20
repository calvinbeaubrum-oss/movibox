package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavd {
    protected volatile Boolean zzb;
    private final zzawj zze;
    private static final ConditionVariable zzc = new ConditionVariable();
    protected static volatile zzfst zza = null;
    private static volatile Random zzd = null;

    public zzavd(zzawj zzawjVar) {
        this.zze = zzawjVar;
        zzawjVar.zzk().execute(new zzavc(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zzd == null) {
                synchronized (zzavd.class) {
                    try {
                        if (zzd == null) {
                            zzd = new Random();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return zzd.nextInt();
        }
    }

    public final void zzc(int i11, int i12, long j11, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzars zzarsVarZza = zzarw.zza();
            zzarsVarZza.zza(this.zze.zza.getPackageName());
            zzarsVarZza.zze(j11);
            if (str != null) {
                zzarsVarZza.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzarsVarZza.zzf(stringWriter.toString());
                zzarsVarZza.zzd(exc.getClass().getName());
            }
            zzfss zzfssVarZza = zza.zza(((zzarw) zzarsVarZza.zzal()).zzax());
            zzfssVarZza.zza(i11);
            if (i12 != -1) {
                zzfssVarZza.zzb(i12);
            }
            zzfssVarZza.zzc();
        } catch (Exception unused) {
        }
    }
}
