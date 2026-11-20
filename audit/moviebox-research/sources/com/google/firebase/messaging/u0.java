package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class u0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f40933d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40936c;

    public u0(String str, String str2) {
        this.f40934a = d(str2, str);
        this.f40935b = str;
        this.f40936c = str + "!" + str2;
    }

    @Nullable
    public static u0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new u0(strArrSplit[0], strArrSplit[1]);
    }

    @NonNull
    public static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f40933d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public String b() {
        return this.f40935b;
    }

    public String c() {
        return this.f40934a;
    }

    public String e() {
        return this.f40936c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f40934a.equals(u0Var.f40934a) && this.f40935b.equals(u0Var.f40935b);
    }

    public int hashCode() {
        return Objects.hashCode(this.f40935b, this.f40934a);
    }
}
