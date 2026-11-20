package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzhp extends zzgx {
    public final zzhb zzb;
    public final int zzc;

    public zzhp(zzhb zzhbVar, int i11, int i12) {
        super(zzb(2008, 1));
        this.zzb = zzhbVar;
        this.zzc = 1;
    }

    public zzhp(IOException iOException, zzhb zzhbVar, int i11, int i12) {
        super(iOException, zzb(i11, i12));
        this.zzb = zzhbVar;
        this.zzc = i12;
    }

    public zzhp(String str, zzhb zzhbVar, int i11, int i12) {
        super(str, zzb(i11, i12));
        this.zzb = zzhbVar;
        this.zzc = i12;
    }

    public zzhp(String str, @Nullable IOException iOException, zzhb zzhbVar, int i11, int i12) {
        super(str, iOException, zzb(i11, i12));
        this.zzb = zzhbVar;
        this.zzc = i12;
    }

    public static zzhp zza(IOException iOException, zzhb zzhbVar, int i11) {
        int i12;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i12 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i12 = 1004;
        } else {
            i12 = (message == null || !zzfwk.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        }
        return i12 == 2007 ? new zzho(iOException, zzhbVar) : new zzhp(iOException, zzhbVar, i12, i11);
    }

    private static int zzb(int i11, int i12) {
        if (i11 == 2000) {
            return i12 != 1 ? 2000 : 2001;
        }
        return i11;
    }
}
