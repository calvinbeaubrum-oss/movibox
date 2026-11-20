package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzckr {
    private static final Pattern zza = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
    private static final Pattern zzb = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String zza(@NonNull String str, @Nullable String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        Matcher matcher = zza.matcher(str);
        int i11 = 0;
        if (matcher.find()) {
            int iEnd = matcher.end();
            sb2.append(str.substring(0, iEnd));
            while (i11 <= 0) {
                String str2 = strArr[i11];
                if (str2 != null) {
                    sb2.append(str2);
                }
                i11++;
            }
            sb2.append(str.substring(iEnd));
        } else {
            if (!zzb.matcher(str).find()) {
                while (i11 <= 0) {
                    String str3 = strArr[i11];
                    if (str3 != null) {
                        sb2.append(str3);
                    }
                    i11++;
                }
            }
            sb2.append(str);
        }
        return sb2.toString();
    }
}
