package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhq {
    private static final a zza = new a();

    public static synchronized Uri zza(String str) {
        a aVar = zza;
        Uri uri = (Uri) aVar.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        aVar.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
