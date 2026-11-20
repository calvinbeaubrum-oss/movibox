package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Gb {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Map<String, Gb> f28731sc = new HashMap();
    private SharedPreferences pFF;

    private Gb(String str, Context context) {
        if (context != null) {
            this.pFF = context.getSharedPreferences(str, 0);
        }
    }

    public static Gb sc(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        Map<String, Gb> map = f28731sc;
        Gb gb2 = map.get(str);
        if (gb2 != null) {
            return gb2;
        }
        Gb gb3 = new Gb(str, context);
        map.put(str, gb3);
        return gb3;
    }

    public String sc(String str, String str2) {
        try {
            return this.pFF.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void sc(String str) {
        try {
            this.pFF.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
