package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgza extends zzgya {
    private static final Logger zza = Logger.getLogger(zzgza.class.getName());
    private static final boolean zzb = zzhcz.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgzb zze;

    private zzgza() {
    }

    public /* synthetic */ zzgza(zzgyz zzgyzVar) {
    }

    public static int zzA(long j11) {
        return (640 - (Long.numberOfLeadingZeros(j11) * 9)) >>> 6;
    }

    public static zzgza zzB(byte[] bArr, int i11, int i12) {
        return new zzgyw(bArr, 0, i12);
    }

    @Deprecated
    public static int zzw(int i11, zzhbe zzhbeVar, zzhby zzhbyVar) {
        int iZzz = zzz(i11 << 3);
        return iZzz + iZzz + ((zzgxt) zzhbeVar).zzat(zzhbyVar);
    }

    public static int zzx(zzhbe zzhbeVar, zzhby zzhbyVar) {
        int iZzat = ((zzgxt) zzhbeVar).zzat(zzhbyVar);
        return zzz(iZzat) + iZzat;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzhde.zze(str);
        } catch (zzhdd unused) {
            length = str.getBytes(zzhae.zzb).length;
        }
        return zzz(length) + length;
    }

    public static int zzz(int i11) {
        return (352 - (Integer.numberOfLeadingZeros(i11) * 9)) >>> 6;
    }

    public final void zzC() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzD(String str, zzhdd zzhddVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhddVar);
        byte[] bytes = str.getBytes(zzhae.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzgyx(e11);
        }
    }

    public abstract void zzH() throws IOException;

    public abstract void zzI(byte b11) throws IOException;

    public abstract void zzJ(int i11, boolean z11) throws IOException;

    public abstract void zzK(int i11, zzgyl zzgylVar) throws IOException;

    @Override // com.google.android.gms.internal.ads.zzgya
    public abstract void zza(byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i11, int i12) throws IOException;

    public abstract void zzi(int i11) throws IOException;

    public abstract void zzj(int i11, long j11) throws IOException;

    public abstract void zzk(long j11) throws IOException;

    public abstract void zzl(int i11, int i12) throws IOException;

    public abstract void zzm(int i11) throws IOException;

    public abstract void zzn(int i11, zzhbe zzhbeVar, zzhby zzhbyVar) throws IOException;

    public abstract void zzo(int i11, String str) throws IOException;

    public abstract void zzq(int i11, int i12) throws IOException;

    public abstract void zzr(int i11, int i12) throws IOException;

    public abstract void zzs(int i11) throws IOException;

    public abstract void zzt(int i11, long j11) throws IOException;

    public abstract void zzu(long j11) throws IOException;
}
