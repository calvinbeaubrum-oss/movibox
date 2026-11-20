package com.bytedance.sdk.openadsdk.We.sc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SR {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static SR f27386sc = new SR();
    private volatile boolean We;
    private sc pFF;
    private final Map<String, sc> zY = new HashMap();

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private final int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final int f27387sc;

        public sc(int i11, int i12) {
            this.f27387sc = (i11 < 0 || i11 > 5) ? 3 : i11;
            this.pFF = i12 < 10 ? 30 : i12;
        }

        public int pFF() {
            return this.pFF;
        }

        public int sc() {
            return this.f27387sc;
        }
    }

    private int pFF() {
        sc scVar = this.pFF;
        if (scVar != null) {
            return scVar.sc();
        }
        return 3;
    }

    private int zY() {
        sc scVar = this.pFF;
        if (scVar != null) {
            return scVar.pFF();
        }
        return 30;
    }

    public int pFF(String str) {
        sc scVar = this.zY.get(str);
        return scVar == null ? zY() : scVar.pFF();
    }

    public int sc(String str) {
        if (!sc()) {
            return 4;
        }
        sc scVar = this.zY.get(str);
        return scVar == null ? pFF() : scVar.sc();
    }

    public void sc(sc scVar) {
        this.pFF = scVar;
    }

    public void sc(String str, sc scVar) {
        if (TextUtils.isEmpty(str) || scVar == null) {
            return;
        }
        this.zY.put(str, scVar);
    }

    public void sc(boolean z11) {
        this.We = z11;
    }

    public boolean sc() {
        return this.We;
    }
}
