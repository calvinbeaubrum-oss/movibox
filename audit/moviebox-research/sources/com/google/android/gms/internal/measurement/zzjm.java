package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzjm extends zziu {
    private static final Logger zzb = Logger.getLogger(zzjm.class.getName());
    private static final boolean zzc = zzmy.zzx();
    zzjn zza;

    private zzjm() {
    }

    public /* synthetic */ zzjm(zzjl zzjlVar) {
    }

    public static int zzA(int i11) {
        if ((i11 & (-128)) == 0) {
            return 1;
        }
        if ((i11 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i11) == 0) {
            return 3;
        }
        return (i11 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzB(long j11) {
        int i11;
        if (((-128) & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if (((-34359738368L) & j11) != 0) {
            j11 >>>= 28;
            i11 = 6;
        } else {
            i11 = 2;
        }
        if (((-2097152) & j11) != 0) {
            i11 += 2;
            j11 >>>= 14;
        }
        return (j11 & (-16384)) != 0 ? i11 + 1 : i11;
    }

    public static zzjm zzC(byte[] bArr) {
        return new zzjj(bArr, 0, bArr.length);
    }

    public static int zzt(zzje zzjeVar) {
        int iZzd = zzjeVar.zzd();
        return zzA(iZzd) + iZzd;
    }

    @Deprecated
    public static int zzu(int i11, zzlm zzlmVar, zzlx zzlxVar) {
        int iZzA = zzA(i11 << 3);
        return iZzA + iZzA + ((zzio) zzlmVar).zzbr(zzlxVar);
    }

    public static int zzv(int i11) {
        if (i11 >= 0) {
            return zzA(i11);
        }
        return 10;
    }

    public static int zzw(zzks zzksVar) {
        int iZza = zzksVar.zza();
        return zzA(iZza) + iZza;
    }

    public static int zzx(zzlm zzlmVar, zzlx zzlxVar) {
        int iZzbr = ((zzio) zzlmVar).zzbr(zzlxVar);
        return zzA(iZzbr) + iZzbr;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zznd.zzc(str);
        } catch (zznc unused) {
            length = str.getBytes(zzkn.zzb).length;
        }
        return zzA(length) + length;
    }

    public static int zzz(int i11) {
        return zzA(i11 << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzE(String str, zznc zzncVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzncVar);
        byte[] bytes = str.getBytes(zzkn.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzjk(e11);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b11) throws IOException;

    public abstract void zzd(int i11, boolean z11) throws IOException;

    public abstract void zze(int i11, zzje zzjeVar) throws IOException;

    public abstract void zzf(int i11, int i12) throws IOException;

    public abstract void zzg(int i11) throws IOException;

    public abstract void zzh(int i11, long j11) throws IOException;

    public abstract void zzi(long j11) throws IOException;

    public abstract void zzj(int i11, int i12) throws IOException;

    public abstract void zzk(int i11) throws IOException;

    public abstract void zzl(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void zzm(int i11, String str) throws IOException;

    public abstract void zzo(int i11, int i12) throws IOException;

    public abstract void zzp(int i11, int i12) throws IOException;

    public abstract void zzq(int i11) throws IOException;

    public abstract void zzr(int i11, long j11) throws IOException;

    public abstract void zzs(long j11) throws IOException;
}
