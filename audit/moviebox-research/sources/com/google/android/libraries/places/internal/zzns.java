package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzns {
    public static int zzd(int i11, int i12) {
        int i13 = i11 + (i11 >> 1) + 1;
        if (i13 < i12) {
            int iHighestOneBit = Integer.highestOneBit(i12 - 1);
            i13 = iHighestOneBit + iHighestOneBit;
        }
        return i13 < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i13;
    }

    public abstract zzns zzb(Object obj);
}
