package com.bytedance.adsdk.sc.pFF.We;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum zY implements ExN {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final int Sfl;
    private final String wjp;
    private static final Map<String, zY> dE = new HashMap(128);
    private static final Set<zY> Xc = new HashSet();

    static {
        for (zY zYVar : values()) {
            dE.put(zYVar.sc(), zYVar);
            Xc.add(zYVar);
        }
    }

    zY(String str, int i11) {
        this.wjp = str;
        this.Sfl = i11;
    }

    public static zY sc(String str) {
        return dE.get(str);
    }

    public static boolean sc(ExN exN) {
        return exN instanceof zY;
    }

    public int pFF() {
        return this.Sfl;
    }

    public String sc() {
        return this.wjp;
    }
}
