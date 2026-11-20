package com.transsion.sdk.oneid.data;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class EnvironInfo extends OneBaseInfo implements Serializable {
    public String lang;

    /* JADX INFO: renamed from: tz, reason: collision with root package name */
    public String f57400tz;

    @SuppressLint({"DefaultLocale"})
    public EnvironInfo(Context context) {
        this.f57400tz = "";
        this.lang = "";
        try {
            this.f57400tz = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError unused) {
            this.f57400tz = "GMT+00:00";
        }
        if ("GMT".equals(this.f57400tz)) {
            this.f57400tz = "GMT+00:00";
        }
        this.lang = Locale.getDefault().getLanguage();
    }
}
