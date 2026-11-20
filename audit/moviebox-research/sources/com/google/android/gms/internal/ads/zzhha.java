package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhha {
    public static HashSet zza(int i11) {
        return new HashSet(zzd(i11));
    }

    public static LinkedHashMap zzb(int i11) {
        return new LinkedHashMap(zzd(i11));
    }

    public static List zzc(int i11) {
        return i11 == 0 ? Collections.emptyList() : new ArrayList(i11);
    }

    private static int zzd(int i11) {
        if (i11 < 3) {
            return i11 + 1;
        }
        return i11 < 1073741824 ? (int) ((i11 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
