package com.amazonaws.internal.config;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HostRegexToRegionMapping {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15750b;

    public HostRegexToRegionMapping(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex must be non-empty");
        }
        try {
            Pattern.compile(str);
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: regionName must be non-empty");
            }
            this.f15749a = str;
            this.f15750b = str2;
        } catch (PatternSyntaxException e11) {
            throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex is not a valid regex", e11);
        }
    }

    public String a() {
        return this.f15749a;
    }

    public String b() {
        return this.f15750b;
    }
}
