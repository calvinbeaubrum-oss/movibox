package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzahz {
    private final zzfp zza = new zzfp(8);
    private int zzb;

    private final long zzb(zzacv zzacvVar) throws IOException {
        int i11;
        zzack zzackVar = (zzack) zzacvVar;
        int i12 = 0;
        zzackVar.zzm(this.zza.zzM(), 0, 1, false);
        int i13 = this.zza.zzM()[0] & 255;
        if (i13 == 0) {
            return Long.MIN_VALUE;
        }
        int i14 = 128;
        int i15 = 0;
        while (true) {
            i11 = i15 + 1;
            if ((i13 & i14) != 0) {
                break;
            }
            i14 >>= 1;
            i15 = i11;
        }
        int i16 = i13 & (~i14);
        zzackVar.zzm(this.zza.zzM(), 1, i15, false);
        while (i12 < i15) {
            i12++;
            i16 = (this.zza.zzM()[i12] & 255) + (i16 << 8);
        }
        this.zzb += i11;
        return i16;
    }

    public final boolean zza(zzacv zzacvVar) throws IOException {
        long jZzd = zzacvVar.zzd();
        long j11 = 1024;
        if (jZzd != -1 && jZzd <= 1024) {
            j11 = jZzd;
        }
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzm(this.zza.zzM(), 0, 4, false);
        long jZzu = this.zza.zzu();
        this.zzb = 4;
        while (jZzu != 440786851) {
            int i11 = (int) j11;
            int i12 = this.zzb + 1;
            this.zzb = i12;
            if (i12 == i11) {
                return false;
            }
            zzackVar.zzm(this.zza.zzM(), 0, 1, false);
            jZzu = ((jZzu << 8) & (-256)) | ((long) (this.zza.zzM()[0] & 255));
        }
        long jZzb = zzb(zzacvVar);
        long j12 = this.zzb;
        if (jZzb != Long.MIN_VALUE) {
            long j13 = j12 + jZzb;
            if (jZzd == -1 || j13 < jZzd) {
                while (true) {
                    long j14 = this.zzb;
                    if (j14 < j13) {
                        if (zzb(zzacvVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long jZzb2 = zzb(zzacvVar);
                        if (jZzb2 < 0) {
                            return false;
                        }
                        if (jZzb2 != 0) {
                            int i13 = (int) jZzb2;
                            zzackVar.zzl(i13, false);
                            this.zzb += i13;
                        }
                    } else if (j14 == j13) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
