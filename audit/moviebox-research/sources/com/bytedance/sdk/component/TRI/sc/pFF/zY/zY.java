package com.bytedance.sdk.component.TRI.sc.pFF.zY;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.TRI.sc.ExN;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.bytedance.sdk.component.TRI.sc.sc.We;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends HandlerThread implements Handler.Callback {
    private static int Sfl = 200;
    private static int Xc = 10;
    private final AtomicInteger BT;
    private final int Dl;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.TRI.sc.We.sc> ExN;
    private final AtomicInteger Ol;
    private volatile long Qj;
    private volatile Handler Ql;
    private final List<com.bytedance.sdk.component.TRI.sc.We.sc> SR;
    private volatile int TRI;
    private final AtomicInteger Tf;
    private final long UFX;
    private final long WH;
    private com.bytedance.sdk.component.TRI.sc.pFF.zY We;
    private final int YIK;
    private final AtomicInteger dE;
    private volatile boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private volatile long f26622qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected We f26623sc;
    private final int uEA;
    private long wjp;
    private final Object zY;

    public zY(PriorityBlockingQueue<com.bytedance.sdk.component.TRI.sc.We.sc> priorityBlockingQueue) {
        super("csj_log");
        this.pFF = true;
        this.zY = new Object();
        this.f26622qr = 0L;
        this.Qj = 0L;
        this.Ol = new AtomicInteger(0);
        this.WH = 5000L;
        this.UFX = 5000000000L;
        this.Tf = new AtomicInteger(0);
        this.SR = new ArrayList();
        this.BT = new AtomicInteger(0);
        this.dE = new AtomicInteger(0);
        this.wjp = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        this.YIK = 1;
        this.Dl = 2;
        this.uEA = 3;
        this.ExN = priorityBlockingQueue;
        this.f26623sc = new com.bytedance.sdk.component.TRI.sc.sc.pFF();
        if (com.bytedance.sdk.component.TRI.sc.pFF.pFF()) {
            return;
        }
        long jBT = Qj.qr().dE().BT();
        if (jBT > 0) {
            this.wjp = jBT;
        }
    }

    private void ExN() {
        while (sc()) {
            try {
                com.bytedance.sdk.component.TRI.sc.pFF.sc.sc scVar = com.bytedance.sdk.component.TRI.sc.pFF.We.We;
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.Qj(), 1);
                com.bytedance.sdk.component.TRI.sc.We.sc scVarPoll = this.ExN.poll(this.wjp, TimeUnit.MILLISECONDS);
                int size = this.ExN.size();
                if (scVarPoll instanceof com.bytedance.sdk.component.TRI.sc.We.pFF) {
                    sc(scVarPoll, size);
                } else if (scVarPoll == null) {
                    int iIncrementAndGet = this.Ol.incrementAndGet();
                    com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.GI(), 1);
                    if (We(iIncrementAndGet)) {
                        TRI();
                        return;
                    } else if (iIncrementAndGet < 4) {
                        this.TRI = 1;
                        pFF((com.bytedance.sdk.component.TRI.sc.We.sc) null);
                    }
                } else {
                    sc(scVarPoll);
                    pFF(scVarPoll);
                }
            } catch (Throwable th2) {
                th2.getMessage();
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.JoC(), 1);
            }
        }
    }

    private void ExN(int i11) {
        if (sc()) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.sc(), 1);
            return;
        }
        if (this.Ql == null) {
            return;
        }
        com.bytedance.sdk.component.TRI.sc.pFF.sc.sc scVar = com.bytedance.sdk.component.TRI.sc.pFF.We.We;
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.zY(), 1);
        if (this.Ql.hasMessages(1)) {
            return;
        }
        if (i11 == 1) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.TRI(), 1);
        } else if (i11 == 2) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.We(), 1);
        } else if (i11 == 3) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.ExN(), 1);
        }
        this.Ql.sendEmptyMessage(1);
    }

    private void Ol() {
        try {
            if (this.ExN.size() == 0 && this.Ql.hasMessages(11) && sc()) {
                sc(false);
            }
        } catch (Exception e11) {
            e11.getMessage();
        }
    }

    private boolean Qj() {
        if (com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.pFF) {
            return this.TRI == 4 || this.TRI == 7 || this.TRI == 6 || this.TRI == 5 || this.TRI == 2;
        }
        return false;
    }

    private void TRI() {
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.uEA(), 1);
        sc(false);
        com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.zY();
    }

    private void WH() {
        if (this.Ql.hasMessages(11)) {
            Ol();
        } else {
            ExN(1);
        }
        com.bytedance.sdk.component.TRI.sc.pFF.sc.sc scVar = com.bytedance.sdk.component.TRI.sc.pFF.We.We;
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.pFF(), 1);
        if (this.TRI != 2) {
            return;
        }
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.qr(), 1);
        synchronized (this.zY) {
            try {
                try {
                    long jNanoTime = System.nanoTime();
                    this.zY.wait(5000L);
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    com.bytedance.sdk.component.TRI.sc.pFF.We we2 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
                    if (!we2.pFF) {
                        boolean z11 = we2.zY;
                    }
                    if (jNanoTime2 < 5000000000L && 5000000000L - jNanoTime2 >= 50000000) {
                        if (!we2.pFF && !we2.zY) {
                            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.BR(), 1);
                            zY(2);
                            return;
                        }
                        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.UFX(), 1);
                        return;
                    }
                    com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar.WH(), 1);
                } catch (InterruptedException e11) {
                    e11.getMessage();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void We() {
        if (!isAlive()) {
            com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.We();
        } else {
            if (sc()) {
                return;
            }
            zY(6);
        }
    }

    private boolean We(int i11) {
        if (i11 < 4 || this.Tf.get() != 0) {
            return false;
        }
        com.bytedance.sdk.component.TRI.sc.pFF.We we2 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
        return (we2.pFF || we2.zY) ? false : true;
    }

    private void pFF() {
        long jXc = Qj.qr().Xc();
        if (jXc <= 0) {
            return;
        }
        this.f26623sc.sc(Api.BaseClientBuilder.API_PRIORITY_OTHER, jXc);
    }

    public static void pFF(int i11) {
        Sfl = i11;
    }

    private void pFF(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc;
        if (com.bytedance.sdk.component.TRI.sc.zY.sc.pFF() && Qj.qr().sc()) {
            return;
        }
        int i11 = 0;
        if (Qj()) {
            com.bytedance.sdk.component.TRI.sc.zY.sc.sc(this.TRI);
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.Tf(), 1);
            if (this.ExN.size() != 0) {
                return;
            }
            if (this.Ql.hasMessages(2)) {
                sc(false);
                return;
            }
            com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.pFF = false;
            this.Qj = 0L;
            this.f26622qr = 0L;
            this.BT.set(0);
            this.dE.set(0);
        }
        do {
            boolean zSc = sc(this.TRI, com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.pFF);
            com.bytedance.sdk.component.TRI.sc.zY.sc.sc(zSc, this.TRI, scVar);
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.Ql(), 1);
            if (!zSc || (listSc = this.f26623sc.sc(this.TRI, -1, null)) == null) {
                Ol();
            } else {
                listSc.size();
                sc(listSc);
            }
            i11++;
            if (!zSc) {
                return;
            }
        } while (i11 <= 6);
    }

    private void pFF(List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        this.SR.addAll(list);
        this.SR.size();
        ExN exNDE = Qj.qr().dE();
        if (exNDE != null && exNDE.Tf() != null) {
            Xc = exNDE.Tf().pFF();
        }
        if (this.SR.size() >= Xc) {
            if (this.Ql.hasMessages(11)) {
                this.Ql.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.SR);
            this.SR.clear();
            sc((List<com.bytedance.sdk.component.TRI.sc.We.sc>) arrayList, false, "max_size_dispatch");
            WH();
            return;
        }
        if (this.ExN.size() != 0) {
            this.SR.size();
            return;
        }
        sc(false);
        if (this.Ql.hasMessages(11)) {
            this.Ql.removeMessages(11);
        }
        if (this.Ql.hasMessages(1)) {
            this.Ql.removeMessages(1);
        }
        long jSc = Sfl;
        if (exNDE != null && exNDE.Tf() != null) {
            jSc = exNDE.Tf().sc();
        }
        this.Ql.sendEmptyMessageDelayed(11, jSc);
    }

    private void pFF(List<com.bytedance.sdk.component.TRI.sc.We.sc> list, final boolean z11, final long j11) {
        this.Tf.incrementAndGet();
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.bSP(), 1);
        try {
            HashMap map = new HashMap();
            Iterator<com.bytedance.sdk.component.TRI.sc.We.sc> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.TRI.sc.We.sc next = it.next();
                int iWH = next == null ? 0 : next.WH();
                if (map.get(Integer.valueOf(iWH)) == null) {
                    map.put(Integer.valueOf(iWH), new ArrayList());
                }
                ((List) map.get(Integer.valueOf(iWH))).add(next);
            }
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                int iIntValue = ((Integer) it2.next()).intValue();
                if (iIntValue == 0 || Qj.qr().zY() == null || Qj.qr().zY().get(Integer.valueOf(iIntValue)) == null) {
                    this.We.sc(list, new com.bytedance.sdk.component.TRI.sc.pFF.pFF() { // from class: com.bytedance.sdk.component.TRI.sc.pFF.zY.zY.2
                        @Override // com.bytedance.sdk.component.TRI.sc.pFF.pFF
                        public void sc(List<sc> list2) {
                            try {
                                zY.this.Tf.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i11 = 0; i11 < size; i11++) {
                                    sc scVar = list2.get(i11);
                                    if (scVar != null) {
                                        zY.this.sc(z11, scVar.sc(), scVar.pFF(), j11);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                } else {
                    Qj.qr().zY().get(Integer.valueOf(iIntValue)).sc(list, new com.bytedance.sdk.component.TRI.sc.pFF.pFF() { // from class: com.bytedance.sdk.component.TRI.sc.pFF.zY.zY.3
                        @Override // com.bytedance.sdk.component.TRI.sc.pFF.pFF
                        public void sc(List<sc> list2) {
                            try {
                                zY.this.Tf.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i11 = 0; i11 < size; i11++) {
                                    sc scVar = list2.get(i11);
                                    if (scVar != null) {
                                        zY.this.sc(z11, scVar.sc(), scVar.pFF(), j11);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
        } catch (Exception e11) {
            e11.getMessage();
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.JoC(), 1);
            this.Tf.decrementAndGet();
        }
    }

    private void qr() {
        if (this.ExN.size() >= 100) {
            for (int i11 = 0; i11 < 100; i11++) {
                com.bytedance.sdk.component.TRI.sc.We.sc scVarPoll = this.ExN.poll();
                if (!(scVarPoll instanceof com.bytedance.sdk.component.TRI.sc.We.pFF) && scVarPoll != null) {
                    sc(scVarPoll);
                }
            }
        }
    }

    public static void sc(int i11) {
        Xc = i11;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006a A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0074 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0080 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x008d A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00af A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bd A[Catch: all -> 0x0040, DONT_GENERATE, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cc A[Catch: all -> 0x0040, DONT_GENERATE, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ce A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00dc A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    private void sc(int i11, List<com.bytedance.sdk.component.TRI.sc.We.sc> list, long j11) {
        com.bytedance.sdk.component.TRI.sc.pFF.We we2;
        synchronized (this.zY) {
            if (list != null) {
                try {
                    if (this.Ql != null) {
                        com.bytedance.sdk.component.TRI.sc.zY.sc.sc(i11, list, j11);
                        this.f26623sc.sc(i11, list);
                        Qj.qr().dE();
                        if (i11 == -2) {
                            com.bytedance.sdk.component.TRI.sc.pFF.We we3 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
                            we3.pFF = false;
                            we3.zY = true;
                            if (this.Ql.hasMessages(3)) {
                                return;
                            }
                            if (System.currentTimeMillis() - this.Qj < 15000) {
                                return;
                            }
                            this.Qj = System.currentTimeMillis();
                            if (this.Ql.hasMessages(2)) {
                                this.Ql.removeMessages(2);
                            }
                            sc(3, 15000L);
                        } else if (i11 == -1) {
                            we2 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
                            if (we2.pFF || we2.zY) {
                                we2.pFF = false;
                                we2.zY = false;
                                if (this.Ql.hasMessages(2)) {
                                    this.Ql.removeMessages(2);
                                }
                                if (this.Ql.hasMessages(3)) {
                                    this.Ql.removeMessages(3);
                                }
                                this.Qj = 0L;
                                this.f26622qr = 0L;
                                this.BT.set(0);
                                this.dE.set(0);
                                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.CYO(), 1);
                                zY(2);
                            }
                        } else if (i11 == 0) {
                            com.bytedance.sdk.component.TRI.sc.pFF.We we4 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
                            we4.pFF = false;
                            we4.zY = true;
                            if (this.Ql.hasMessages(3)) {
                                return;
                            }
                            if (System.currentTimeMillis() - this.Qj < 15000) {
                                return;
                            }
                            this.Qj = System.currentTimeMillis();
                            if (this.Ql.hasMessages(2)) {
                                this.Ql.removeMessages(2);
                            }
                            sc(3, 15000L);
                        } else if (i11 == 200) {
                            we2 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
                            if (we2.pFF) {
                                we2.pFF = false;
                                we2.zY = false;
                                if (this.Ql.hasMessages(2)) {
                                    this.Ql.removeMessages(2);
                                }
                                if (this.Ql.hasMessages(3)) {
                                    this.Ql.removeMessages(3);
                                }
                                this.Qj = 0L;
                                this.f26622qr = 0L;
                                this.BT.set(0);
                                this.dE.set(0);
                                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.CYO(), 1);
                                zY(2);
                            } else {
                                we2.pFF = false;
                                we2.zY = false;
                                if (this.Ql.hasMessages(2)) {
                                    this.Ql.removeMessages(2);
                                }
                                if (this.Ql.hasMessages(3)) {
                                    this.Ql.removeMessages(3);
                                }
                                this.Qj = 0L;
                                this.f26622qr = 0L;
                                this.BT.set(0);
                                this.dE.set(0);
                                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.CYO(), 1);
                                zY(2);
                            }
                        } else if (i11 == 509) {
                            com.bytedance.sdk.component.TRI.sc.pFF.We we5 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
                            we5.pFF = true;
                            we5.zY = false;
                            if (this.Ql.hasMessages(2)) {
                                return;
                            }
                            if (System.currentTimeMillis() - this.f26622qr < 30000) {
                                return;
                            }
                            this.f26622qr = System.currentTimeMillis();
                            if (this.Ql.hasMessages(3)) {
                                this.Ql.removeMessages(3);
                            }
                            sc(2, 30000L);
                        }
                        if (this.TRI == 2) {
                            this.zY.notify();
                        }
                        this.ExN.size();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        this.Ol.set(0);
        com.bytedance.sdk.component.TRI.sc.pFF.We we2 = com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc;
        if (we2.pFF) {
            this.TRI = 5;
        } else if (we2.zY) {
            this.TRI = 7;
        } else {
            this.TRI = 4;
        }
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.qfG(), 1);
        this.f26623sc.sc(scVar, this.TRI);
        com.bytedance.sdk.component.TRI.sc.zY.sc.qr(scVar);
    }

    private void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar, int i11) {
        this.Ol.set(0);
        if (i11 == 0) {
            this.TRI = ((com.bytedance.sdk.component.TRI.sc.We.pFF) scVar).UFX();
            if (this.TRI != 6) {
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.pc(), 1);
                pFF(scVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.TRI.sc.We.pFF pff = (com.bytedance.sdk.component.TRI.sc.We.pFF) scVar;
        if (pff.UFX() == 1) {
            this.TRI = 1;
            pFF(scVar);
        } else if (pff.UFX() == 2) {
            qr();
            this.TRI = 2;
            pFF(scVar);
        }
    }

    private void sc(pFF pff, List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        if (pff == null || !pff.f26620sc) {
            return;
        }
        List<Object> listSc = com.bytedance.sdk.component.TRI.sc.pFF.sc();
        if (list == null || listSc == null || listSc.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.TRI.sc.We.sc scVar : list) {
            if (scVar.ExN() == 1) {
                com.bytedance.sdk.component.TRI.sc.zY.sc.sc(scVar);
                com.bytedance.sdk.component.TRI.sc.zY.sc.ExN(scVar);
                Iterator<Object> it = listSc.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    private void sc(String str) {
        if (this.Ql.hasMessages(11)) {
            this.Ql.removeMessages(11);
        }
        if (this.SR.size() != 0) {
            ArrayList arrayList = new ArrayList(this.SR);
            this.SR.clear();
            sc((List<com.bytedance.sdk.component.TRI.sc.We.sc>) arrayList, false, "before_".concat(String.valueOf(str)));
            WH();
            arrayList.size();
        }
    }

    private void sc(List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        if (list.size() == 0) {
            Ol();
            return;
        }
        com.bytedance.sdk.component.TRI.sc.zY.sc.sc(list, this.ExN.size());
        if (list.size() > 1 || com.bytedance.sdk.component.TRI.sc.zY.sc.zY()) {
            sc(list, "batchRead");
            return;
        }
        com.bytedance.sdk.component.TRI.sc.We.sc scVar = list.get(0);
        if (scVar != null) {
            if (scVar.ExN() == 1) {
                sc(list, "highPriority");
                return;
            }
            if (scVar.We() == 0 && scVar.ExN() == 2) {
                if (scVar.pFF() == 3) {
                    sc(list, "version_v3");
                    return;
                } else {
                    pFF(list);
                    return;
                }
            }
            if (scVar.We() == 1) {
                sc(list, "stats");
            } else if (scVar.We() == 3) {
                sc(list, "adType_v3");
            } else if (scVar.We() == 2) {
                sc(list, "other");
            }
        }
    }

    private void sc(List<com.bytedance.sdk.component.TRI.sc.We.sc> list, String str) {
        sc(str);
        sc(list, false, str);
        WH();
    }

    private void sc(final List<com.bytedance.sdk.component.TRI.sc.We.sc> list, final boolean z11, final long j11) {
        ExN exNDE = Qj.qr().dE();
        if (exNDE != null) {
            Executor executorExN = exNDE.ExN();
            if (list.get(0).ExN() == 1) {
                executorExN = exNDE.We();
            }
            if (executorExN == null) {
                return;
            }
            this.Tf.incrementAndGet();
            executorExN.execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("csj_log_upload") { // from class: com.bytedance.sdk.component.TRI.sc.pFF.zY.zY.1
                @Override // java.lang.Runnable
                public void run() {
                    zY zYVar = zY.this;
                    zYVar.sc((List<com.bytedance.sdk.component.TRI.sc.We.sc>) list, z11, j11, zYVar.TRI);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(List<com.bytedance.sdk.component.TRI.sc.We.sc> list, boolean z11, long j11, int i11) {
        pFF pffSc;
        try {
            com.bytedance.sdk.component.TRI.sc.We.sc scVar = list.get(0);
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.bSP(), 1);
            if (scVar.We() == 0) {
                pffSc = Qj.ExN().sc(list);
                sc(pffSc, list);
                if (pffSc != null) {
                    com.bytedance.sdk.component.TRI.sc.zY.sc.sc(list, pffSc.We);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.TRI.sc.We.sc> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().qr());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e11) {
                    e11.getMessage();
                }
                pffSc = Qj.ExN().sc(jSONObject);
            }
            pFF pff = pffSc;
            this.Tf.decrementAndGet();
            sc(z11, pff, list, j11);
        } catch (Throwable th2) {
            th2.getMessage();
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.JoC(), 1);
            this.Tf.decrementAndGet();
        }
    }

    private void sc(List<com.bytedance.sdk.component.TRI.sc.We.sc> list, boolean z11, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.TRI.sc.zY.sc.sc(list, this.TRI, str);
        com.bytedance.sdk.component.TRI.sc.pFF.zY zYVarQj = Qj.qr().Qj();
        this.We = zYVarQj;
        if (zYVarQj != null) {
            pFF(list, z11, jCurrentTimeMillis);
        } else {
            sc(list, z11, jCurrentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z11, pFF pff, List<com.bytedance.sdk.component.TRI.sc.We.sc> list, long j11) {
        if (z11 || pff == null) {
            return;
        }
        int i11 = pff.pFF;
        int i12 = -2;
        if (pff.ExN) {
            i11 = -1;
        } else if (i11 < 0) {
            i11 = -2;
        }
        if (i11 == 510 || i11 == 511) {
            i11 = -2;
        }
        if (pff.f26620sc || ((i11 < 500 || i11 >= 509) && i11 <= 513)) {
            i12 = i11;
        }
        if (list != null) {
            list.size();
            this.Tf.get();
        }
        sc(i12, list, j11);
    }

    private void zY() {
        We();
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.kX(), 1);
        zY(1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i11 = message.what;
        try {
            if (i11 == 1) {
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.Ol(), 1);
                pFF();
                sc(true);
                ExN();
            } else {
                if (i11 != 2 && i11 != 3) {
                    if (i11 == 11) {
                        ArrayList arrayList = new ArrayList(this.SR);
                        this.SR.clear();
                        sc((List<com.bytedance.sdk.component.TRI.sc.We.sc>) arrayList, false, "timeout_dispatch");
                        WH();
                    }
                    return true;
                }
                zY();
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.Ql = new Handler(getLooper(), this);
        com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.sc(this.Ql);
        this.Ql.sendEmptyMessage(1);
    }

    public void sc(int i11, long j11) {
        if (this.Ql == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i11;
        if (i11 == 2) {
            this.Ql.sendMessageDelayed(messageObtain, ((long) (((this.BT.incrementAndGet() - 1) % 4) + 1)) * j11);
        } else if (i11 == 3) {
            this.Ql.sendMessageDelayed(messageObtain, ((long) (((this.dE.incrementAndGet() - 1) % 4) + 1)) * j11);
        }
    }

    public void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar, boolean z11) {
        if (scVar == null) {
            return;
        }
        scVar.We();
        if (!z11) {
            this.ExN.add(scVar);
            ExN(2);
        } else if (this.Ql != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(scVar);
            sc((List<com.bytedance.sdk.component.TRI.sc.We.sc>) arrayList, true, "ignore_result_dispatch");
        }
    }

    public void sc(boolean z11) {
        this.pFF = z11;
    }

    public boolean sc() {
        return this.pFF;
    }

    public boolean sc(int i11, boolean z11) {
        ExN exNDE = Qj.qr().dE();
        if (exNDE == null || !exNDE.sc(Qj.qr().TRI())) {
            return false;
        }
        return this.f26623sc.sc(i11, z11);
    }

    public void zY(int i11) {
        try {
            boolean zSc = sc(i11, com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.pFF);
            if (i11 == 6 || zSc) {
                com.bytedance.sdk.component.TRI.sc.We.pFF pff = new com.bytedance.sdk.component.TRI.sc.We.pFF();
                pff.pFF(i11);
                this.ExN.add(pff);
                ExN(3);
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }
}
