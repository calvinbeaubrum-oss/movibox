package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    public int get(int i11) {
        return this.values[i11];
    }

    public boolean getEnablePush(boolean z11) {
        if ((this.set & 4) != 0) {
            if (this.values[2] == 1) {
                return true;
            }
        } else if (z11) {
            return true;
        }
        return false;
    }

    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public int getMaxConcurrentStreams(int i11) {
        return (this.set & 16) != 0 ? this.values[4] : i11;
    }

    public int getMaxFrameSize(int i11) {
        return (this.set & 32) != 0 ? this.values[5] : i11;
    }

    public int getMaxHeaderListSize(int i11) {
        return (this.set & 64) != 0 ? this.values[6] : i11;
    }

    public boolean isSet(int i11) {
        return ((1 << i11) & this.set) != 0;
    }

    public void merge(Settings settings) {
        for (int i11 = 0; i11 < 10; i11++) {
            if (settings.isSet(i11)) {
                set(i11, settings.get(i11));
            }
        }
    }

    public Settings set(int i11, int i12) {
        if (i11 >= 0) {
            int[] iArr = this.values;
            if (i11 < iArr.length) {
                this.set = (1 << i11) | this.set;
                iArr[i11] = i12;
            }
        }
        return this;
    }

    public int size() {
        return Integer.bitCount(this.set);
    }
}
