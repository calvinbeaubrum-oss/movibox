package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacy {
    public static int zza(zzacv zzacvVar, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        while (i13 < i12) {
            int iZzb = zzacvVar.zzb(bArr, i11 + i13, i12 - i13);
            if (iZzb == -1) {
                break;
            }
            i13 += iZzb;
        }
        return i13;
    }

    public static void zzb(boolean z11, @Nullable String str) throws zzcc {
        if (!z11) {
            throw zzcc.zza(str, null);
        }
    }

    public static boolean zzc(zzacv zzacvVar, byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        try {
            return zzacvVar.zzm(bArr, 0, i12, z11);
        } catch (EOFException e11) {
            if (z11) {
                return false;
            }
            throw e11;
        }
    }

    public static boolean zzd(zzacv zzacvVar, byte[] bArr, int i11, int i12) throws IOException {
        try {
            ((zzack) zzacvVar).zzn(bArr, i11, i12, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzacv zzacvVar, int i11) throws IOException {
        try {
            ((zzack) zzacvVar).zzo(i11, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
