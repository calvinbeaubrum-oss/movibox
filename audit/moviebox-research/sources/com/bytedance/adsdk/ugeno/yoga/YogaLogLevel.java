package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@com.bytedance.adsdk.ugeno.yoga.sc.sc
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);


    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final int f26473qr;

    YogaLogLevel(int i11) {
        this.f26473qr = i11;
    }

    @com.bytedance.adsdk.ugeno.yoga.sc.sc
    public static YogaLogLevel fromInt(int i11) {
        if (i11 == 0) {
            return ERROR;
        }
        if (i11 == 1) {
            return WARN;
        }
        if (i11 == 2) {
            return INFO;
        }
        if (i11 == 3) {
            return DEBUG;
        }
        if (i11 == 4) {
            return VERBOSE;
        }
        if (i11 == 5) {
            return FATAL;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }
}
