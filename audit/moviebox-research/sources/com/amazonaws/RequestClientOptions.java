package com.amazonaws;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestClientOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Marker, String> f15651a = new EnumMap(Marker.class);

    /* JADX INFO: compiled from: source.java */
    public enum Marker {
        USER_AGENT
    }

    public void a(String str) {
        Map<Marker, String> map = this.f15651a;
        Marker marker = Marker.USER_AGENT;
        String str2 = map.get(marker);
        if (str2 == null) {
            str2 = "";
        }
        d(marker, b(str2, str));
    }

    public final String b(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str + " " + str2;
    }

    public String c(Marker marker) {
        return this.f15651a.get(marker);
    }

    public void d(Marker marker, String str) {
        this.f15651a.put(marker, str);
    }
}
