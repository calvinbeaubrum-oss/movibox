package com.bytedance.sdk.openadsdk.We;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.google.logging.type.LogSeverity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile Tf f27325sc;
    private Map<String, Object> TRI;
    private HandlerThread pFF;
    private final Handler zY;
    private final Executor We = Executors.newCachedThreadPool();
    private pFF ExN = pFF.sc();

    /* JADX INFO: compiled from: source.java */
    public static class pFF {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f27327sc = LogSeverity.NOTICE_VALUE;
        public int pFF = 6000;

        private pFF() {
        }

        public static pFF sc() {
            return new pFF();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements Serializable, Runnable {
        public Map<String, Object> ExN;
        public String We;
        public Sfl zY;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final AtomicInteger f27328sc = new AtomicInteger(0);
        public final AtomicBoolean pFF = new AtomicBoolean(false);
        private final long TRI = SystemClock.elapsedRealtime();

        public sc(Sfl sfl, String str, Map<String, Object> map) {
            this.zY = sfl;
            this.We = str;
            this.ExN = map;
        }

        public static sc sc(Sfl sfl, String str, Map<String, Object> map) {
            return new sc(sfl, str, map);
        }

        public void pFF() {
            this.f27328sc.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zY == null || TextUtils.isEmpty(this.We)) {
                return;
            }
            String str = this.pFF.get() ? "dpl_success" : "dpl_failed";
            if (this.ExN == null) {
                this.ExN = new HashMap();
            }
            Sfl sfl = this.zY;
            if (sfl != null && sfl.Vb() == 0) {
                Map<String, Object> map = this.ExN;
                Sfl sfl2 = this.zY;
                map.put("auto_click", Boolean.valueOf((sfl2 == null || sfl2.We()) ? false : true));
            }
            this.ExN.put("lifeCycleInit", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.BT.sc().zY()));
            this.ExN.put("duration", Long.valueOf(SystemClock.elapsedRealtime() - this.TRI));
            zY.sc(this.zY, this.We, str, this.ExN);
        }

        public int sc() {
            return this.f27328sc.get();
        }

        public sc sc(boolean z11) {
            this.pFF.set(z11);
            return this;
        }
    }

    private Tf() {
        if (this.pFF == null) {
            HandlerThread handlerThread = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.pFF = handlerThread;
            handlerThread.start();
        }
        this.zY = new Handler(this.pFF.getLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.We.Tf.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return true;
                }
                Object obj = message.obj;
                sc scVar = (obj == null || !(obj instanceof sc)) ? null : (sc) obj;
                if (scVar == null) {
                    return true;
                }
                Tf.this.pFF(scVar);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(sc scVar) {
        if (scVar == null) {
            return;
        }
        boolean zWe = com.bytedance.sdk.openadsdk.core.BT.sc().We();
        boolean zSc = com.bytedance.sdk.openadsdk.core.BT.sc().sc(true);
        if (!zWe && zSc) {
            sc(scVar);
            return;
        }
        if (scVar.ExN == null) {
            scVar.ExN = new HashMap();
        }
        scVar.ExN.put("is_background", Boolean.valueOf(zWe));
        scVar.ExN.put("has_focus", Boolean.valueOf(zSc));
        zY(scVar.sc(true));
    }

    public static Tf sc() {
        if (f27325sc == null) {
            synchronized (Tf.class) {
                try {
                    if (f27325sc == null) {
                        f27325sc = new Tf();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27325sc;
    }

    private void sc(sc scVar) {
        if (scVar == null) {
            return;
        }
        scVar.pFF();
        int iSc = scVar.sc();
        pFF pff = this.ExN;
        if (iSc * pff.f27327sc > pff.pFF) {
            zY(scVar.sc(false));
            return;
        }
        Message messageObtainMessage = this.zY.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = scVar;
        this.zY.sendMessageDelayed(messageObtainMessage, this.ExN.f27327sc);
    }

    private void zY(sc scVar) {
        if (scVar == null) {
            return;
        }
        this.We.execute(scVar);
    }

    public Tf sc(Map<String, Object> map) {
        this.TRI = map;
        return sc();
    }

    public void sc(Sfl sfl, String str) {
        Message messageObtainMessage = this.zY.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = sc.sc(sfl, str, this.TRI);
        messageObtainMessage.sendToTarget();
    }
}
