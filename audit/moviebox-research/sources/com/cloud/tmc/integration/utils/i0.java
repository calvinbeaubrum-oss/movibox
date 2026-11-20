package com.cloud.tmc.integration.utils;

import androidx.collection.v0;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0<String, String> f31065a = new v0<>();

    public static boolean a(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public static boolean b(CharSequence charSequence) {
        return a("[a-zA-z]+://[^\\s]*", charSequence);
    }
}
