package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzq {
    public static int zza(int i11) {
        boolean z11;
        if (i11 == 0 || i11 == 1) {
            z11 = true;
        } else if (i11 == 2) {
            i11 = 2;
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i11));
        return i11;
    }

    public static String zzb(int i11) {
        if (i11 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i11 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i11 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }
}
