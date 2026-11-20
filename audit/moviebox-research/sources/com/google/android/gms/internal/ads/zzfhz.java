package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfhz {
    private final Pattern zza;

    public zzfhz() {
        Pattern patternCompile;
        try {
            patternCompile = Pattern.compile((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgT));
        } catch (PatternSyntaxException unused) {
            patternCompile = null;
        }
        this.zza = patternCompile;
    }

    @Nullable
    public final String zza(@Nullable String str) {
        Pattern pattern = this.zza;
        if (pattern == null || str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
