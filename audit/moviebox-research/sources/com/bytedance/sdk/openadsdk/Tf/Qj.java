package com.bytedance.sdk.openadsdk.Tf;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final AudioManager f27286sc;
    private int pFF = -1;
    private boolean zY = false;

    public Qj(Context context) {
        this.f27286sc = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    private void sc(int i11, int i12, int i13) {
        try {
            this.f27286sc.setStreamVolume(i11, i12, i13);
        } catch (Throwable unused) {
        }
    }

    public boolean pFF() {
        if (!this.zY) {
            return false;
        }
        this.zY = false;
        return true;
    }

    public int sc() {
        return this.pFF;
    }

    public void sc(int i11) {
        this.pFF = i11;
    }

    public void sc(boolean z11) {
        sc(z11, false);
    }

    public void sc(boolean z11, boolean z12) {
        if (this.f27286sc == null) {
            return;
        }
        int i11 = 0;
        if (z11) {
            int iQr = DeviceUtils.qr();
            if (iQr != 0) {
                this.pFF = iQr;
            } else if (!z12) {
                return;
            }
            sc(3, 0, 0);
            this.zY = true;
            return;
        }
        int iOl = this.pFF;
        if (iOl != 0) {
            if (iOl == -1) {
                if (!z12) {
                    return;
                } else {
                    iOl = DeviceUtils.Ol() / 15;
                }
            }
            this.pFF = -1;
            sc(3, iOl, i11);
            this.zY = true;
        }
        iOl = DeviceUtils.Ol() / 15;
        i11 = 1;
        this.pFF = -1;
        sc(3, iOl, i11);
        this.zY = true;
    }
}
