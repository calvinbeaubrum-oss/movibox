package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.v0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhh {
    private final v0 zza;

    public zzhh(v0 v0Var) {
        this.zza = v0Var;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        v0 v0Var = (v0) this.zza.get(uri.toString());
        if (v0Var == null) {
            return null;
        }
        return (String) v0Var.get("".concat(String.valueOf(str3)));
    }
}
