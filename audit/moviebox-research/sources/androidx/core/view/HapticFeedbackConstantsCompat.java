package androidx.core.view;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    private HapticFeedbackConstantsCompat() {
    }

    /* JADX WARN: Code duplicated, block: B:24:0x002d  */
    /* JADX WARN: Code duplicated, block: B:25:0x002f  */
    public static int getFeedbackConstantOrFallback(int i11) {
        int i12 = -1;
        if (i11 == -1) {
            return -1;
        }
        int i13 = Build.VERSION.SDK_INT;
        int i14 = 0;
        if (i13 < 34) {
            switch (i11) {
                case 21:
                case 23:
                case 26:
                    i11 = 6;
                    break;
                case 22:
                case 24:
                case 27:
                    i11 = 4;
                    break;
                case 25:
                    i11 = 0;
                    break;
            }
        }
        if (i13 >= 30) {
            i14 = i11;
        } else if (i11 == 12) {
            i14 = 1;
        } else if (i11 == 13) {
            i14 = 6;
        } else if (i11 == 16) {
            i14 = 1;
        } else if (i11 != 17) {
            i14 = i11;
        }
        if (i13 >= 27 || (i14 != 7 && i14 != 8 && i14 != 9)) {
            i12 = i14;
        }
        if (i13 >= 23 || i12 != 6) {
            return i12;
        }
        return 4;
    }
}
