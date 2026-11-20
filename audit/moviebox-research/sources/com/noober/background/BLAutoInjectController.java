package com.noober.background;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class BLAutoInjectController {
    private static boolean enableAutoInject = true;

    public static boolean isEnableAutoInject() {
        return enableAutoInject;
    }

    public static void setEnableAutoInject(boolean z11) {
        enableAutoInject = z11;
    }
}
