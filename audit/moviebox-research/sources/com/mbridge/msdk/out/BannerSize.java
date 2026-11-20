package com.mbridge.msdk.out;

import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BannerSize {
    public static final int DEV_SET_TYPE = 5;
    public static final int LARGE_TYPE = 1;
    public static final int MEDIUM_TYPE = 2;
    public static final int SMART_TYPE = 3;
    public static final int STANDARD_TYPE = 4;
    private int height;
    private int width;

    public BannerSize(int i11, int i12, int i13) {
        if (i11 == 1) {
            this.height = 90;
            this.width = 320;
            return;
        }
        if (i11 == 2) {
            this.height = 250;
            this.width = LogSeverity.NOTICE_VALUE;
            return;
        }
        if (i11 == 3) {
            setSmartMode();
            return;
        }
        if (i11 == 4) {
            this.height = 50;
            this.width = 320;
        } else {
            if (i11 != 5) {
                return;
            }
            this.height = i13;
            this.width = i12;
        }
    }

    private void setSmartMode() {
        if (z.g(c.m().c()) < 720) {
            this.height = 50;
            this.width = 320;
        } else {
            this.height = 90;
            this.width = 728;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
