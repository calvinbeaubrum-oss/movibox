package com.bytedance.sdk.openadsdk.JPJ.pFF;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.Tf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    private static HandlerThread pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static sc f27094sc;

    /* JADX INFO: compiled from: source.java */
    public static class sc extends Handler {
        public sc(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            pFF pff = (pFF) message.obj;
            if (pff == null) {
                return;
            }
            int iPFF = pff.pFF();
            if (iPFF == 1) {
                pff.qr();
            } else {
                if (iPFF != 2) {
                    ExN.pFF(pff.UFX());
                    return;
                }
                pff.Qj();
            }
            if (pff.Ol()) {
                ExN.pFF(pff.UFX());
            } else if (pff.Tf()) {
                sc(pff);
            }
        }

        public void sc(pFF pff) {
            if (pff == null) {
                return;
            }
            int iIntValue = pff.UFX().intValue();
            if (hasMessages(iIntValue)) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = iIntValue;
            messageObtain.obj = pff;
            sendMessageDelayed(messageObtain, pff.TRI());
        }
    }

    public static void pFF() {
        if (f27094sc != null) {
            return;
        }
        try {
            HandlerThread handlerThread = pFF;
            if (handlerThread != null && handlerThread.isAlive()) {
                return;
            }
            synchronized (qr.class) {
                try {
                    HandlerThread handlerThread2 = pFF;
                    if (handlerThread2 == null || !handlerThread2.isAlive()) {
                        HandlerThread handlerThread3 = new HandlerThread("csj_MRC");
                        pFF = handlerThread3;
                        handlerThread3.start();
                        f27094sc = new sc(pFF.getLooper());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Tf.sc("MRC", th3.getMessage());
        }
    }

    public static void pFF(pFF pff) {
        if (pff == null || f27094sc == null) {
            return;
        }
        try {
            int iIntValue = pff.UFX().intValue();
            if (f27094sc.hasMessages(iIntValue)) {
                f27094sc.removeMessages(iIntValue);
            }
        } catch (Exception unused) {
        }
    }

    public static void sc() {
    }

    public static void sc(pFF pff) {
        if (pff == null) {
            return;
        }
        pFF();
        sc scVar = f27094sc;
        if (scVar != null) {
            scVar.sc(pff);
        }
    }
}
