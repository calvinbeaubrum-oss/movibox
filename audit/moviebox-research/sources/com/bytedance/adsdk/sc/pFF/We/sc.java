package com.bytedance.adsdk.sc.pFF.We;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum sc implements ExN {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, sc> We = new HashMap(128);

    static {
        for (sc scVar : values()) {
            We.put(scVar.name().toLowerCase(), scVar);
        }
    }

    public static sc sc(String str) {
        return We.get(str.toLowerCase());
    }
}
