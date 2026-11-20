package com.bytedance.adsdk.sc.pFF.We;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum We implements ExN {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, We> TRI;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final String f26294qr;

    static {
        HashMap map = new HashMap(128);
        TRI = map;
        for (We we2 : map.values()) {
            TRI.put(we2.sc(), we2);
        }
    }

    We(String str) {
        this.f26294qr = str;
    }

    public static boolean sc(ExN exN) {
        return exN instanceof We;
    }

    public String sc() {
        return this.f26294qr;
    }
}
