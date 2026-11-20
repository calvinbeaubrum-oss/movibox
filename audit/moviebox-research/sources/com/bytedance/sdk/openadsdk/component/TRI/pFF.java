package com.bytedance.sdk.openadsdk.component.TRI;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements Handler.Callback {
    private final com.bytedance.sdk.openadsdk.component.Qj.sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f27762qr;
    private sc zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Handler f27763sc = new Handler(Looper.myLooper(), this);
    private int We = 0;
    private int ExN = 5;
    private int TRI = 0;

    public pFF(com.bytedance.sdk.openadsdk.component.Qj.sc scVar) {
        this.pFF = scVar;
    }

    public void ExN() {
        this.f27763sc.removeCallbacksAndMessages(null);
        this.f27763sc = null;
    }

    public void We() {
        Handler handler = this.f27763sc;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 100 && this.f27763sc != null) {
            int i11 = message.arg1;
            sc(i11);
            if (i11 > 0) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                messageObtain.arg1 = i11 - 1;
                this.f27763sc.sendMessageDelayed(messageObtain, 1000L);
            }
        }
        return true;
    }

    public void pFF() {
        Handler handler = this.f27763sc;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(100, this.ExN, 0));
        }
    }

    public void pFF(int i11) {
        this.TRI = i11;
    }

    public int sc() {
        return this.TRI;
    }

    public void sc(float f11) {
        int i11 = (int) f11;
        this.ExN = i11;
        if (i11 <= 0) {
            this.ExN = 5;
        }
    }

    public void sc(int i11) {
        this.We = i11;
        int i12 = this.ExN - i11;
        this.pFF.sc(i12);
        if (i11 <= 0) {
            sc scVar = this.zY;
            if (scVar != null && !this.f27762qr) {
                scVar.pFF();
                this.f27762qr = true;
            }
            i11 = 0;
        }
        boolean z11 = i12 >= this.TRI;
        sc scVar2 = this.zY;
        if (scVar2 != null) {
            scVar2.sc(i11, i12, z11);
        }
    }

    public void sc(sc scVar) {
        this.zY = scVar;
    }

    public void zY() {
        if (this.f27763sc != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            messageObtain.arg1 = this.We;
            this.f27763sc.sendMessage(messageObtain);
        }
    }
}
