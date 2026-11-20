package com.applovin.sdk;

import com.google.logging.type.LogSeverity;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinAdSize {
    public static final int SPAN = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f25044c;
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(LogSeverity.NOTICE_VALUE, 250, "MREC");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize NATIVE = new AppLovinAdSize(-1, -1, "NATIVE");

    private AppLovinAdSize(int i11, int i12, String str) {
        this.f25043b = i11;
        this.f25044c = i12;
        this.f25042a = str;
    }

    public static AppLovinAdSize fromString(String str) {
        if ("BANNER".equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Size: " + str);
    }

    public int getHeight() {
        return this.f25044c;
    }

    public String getLabel() {
        return this.f25042a.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.f25043b;
    }

    public String toString() {
        return getLabel();
    }
}
