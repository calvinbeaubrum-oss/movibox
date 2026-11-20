package com.mbridge.msdk.playercommon.exoplayer2.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class RepeatModeUtil {
    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    /* JADX INFO: compiled from: source.java */
    public @interface RepeatToggleModes {
    }

    private RepeatModeUtil() {
    }

    public static int getNextRepeatMode(int i11, int i12) {
        for (int i13 = 1; i13 <= 2; i13++) {
            int i14 = (i11 + i13) % 3;
            if (isRepeatModeEnabled(i14, i12)) {
                return i14;
            }
        }
        return i11;
    }

    public static boolean isRepeatModeEnabled(int i11, int i12) {
        if (i11 == 0) {
            return true;
        }
        if (i11 != 1) {
            return i11 == 2 && (i12 & 2) != 0;
        }
        return (i12 & 1) != 0;
    }
}
