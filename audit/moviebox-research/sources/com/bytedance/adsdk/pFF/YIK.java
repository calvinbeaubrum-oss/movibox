package com.bytedance.adsdk.pFF;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class YIK {
    private boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Map<String, String> f26167sc;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String pFF(String str, String str2) {
        if (this.pFF && this.f26167sc.containsKey(str2)) {
            return this.f26167sc.get(str2);
        }
        String strSc = sc(str, str2);
        if (this.pFF) {
            this.f26167sc.put(str2, strSc);
        }
        return strSc;
    }

    public String sc(String str) {
        return str;
    }

    public String sc(String str, String str2) {
        return sc(str2);
    }
}
