package com.google.firebase.perf.util;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.net.URI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f41034a;

    public static boolean a(@NonNull URI uri, @NonNull Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier == 0) {
            return true;
        }
        ql.a.e().a("Detected domain allowlist, only allowlisted domains will be measured.");
        if (f41034a == null) {
            f41034a = resources.getStringArray(identifier);
        }
        String host = uri.getHost();
        if (host == null) {
            return true;
        }
        for (String str : f41034a) {
            if (host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
