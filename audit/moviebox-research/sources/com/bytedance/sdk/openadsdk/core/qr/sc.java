package com.bytedance.sdk.openadsdk.core.qr;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.TRI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static volatile boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile sc f28472sc;
    private static volatile long zY;
    private Handler ExN;
    private final Queue<C0306sc> We = new LinkedList();
    private final TRI TRI = Xc.We();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.qr.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0306sc {
        private final String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final long f28474sc;

        private C0306sc(long j11, String str) {
            this.f28474sc = j11;
            this.pFF = str;
        }
    }

    private sc() {
    }

    private synchronized void pFF(long j11) {
        zY = j11;
    }

    private synchronized boolean pFF(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iFI = this.TRI.FI();
        long jJPJ = this.TRI.JPJ();
        if (this.We.size() <= 0 || this.We.size() < iFI) {
            this.We.offer(new C0306sc(jCurrentTimeMillis, str));
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - this.We.peek().f28474sc);
            if (jAbs <= jJPJ) {
                pFF(jJPJ - jAbs);
                return true;
            }
            this.We.poll();
            this.We.offer(new C0306sc(jCurrentTimeMillis, str));
        }
        return false;
    }

    public static sc sc() {
        if (f28472sc == null) {
            synchronized (sc.class) {
                try {
                    if (f28472sc == null) {
                        f28472sc = new sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28472sc;
    }

    private synchronized void sc(long j11) {
        try {
            if (this.ExN == null) {
                this.ExN = new Handler(Looper.getMainLooper());
            }
            this.ExN.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qr.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    sc.this.sc(false);
                }
            }, j11);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sc(boolean z11) {
        pFF = z11;
    }

    public synchronized boolean pFF() {
        return pFF;
    }

    public synchronized boolean sc(String str) {
        try {
            if (pFF(str)) {
                sc(true);
                sc(zY);
            } else {
                sc(false);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return pFF;
    }

    public synchronized String zY() {
        String str;
        try {
            HashMap map = new HashMap();
            for (C0306sc c0306sc : this.We) {
                if (map.containsKey(c0306sc.pFF)) {
                    map.put(c0306sc.pFF, Integer.valueOf(((Integer) map.get(c0306sc.pFF)).intValue() + 1));
                } else {
                    map.put(c0306sc.pFF, 1);
                }
            }
            str = "";
            int i11 = Integer.MIN_VALUE;
            for (String str2 : map.keySet()) {
                int iIntValue = ((Integer) map.get(str2)).intValue();
                if (i11 < iIntValue) {
                    str = str2;
                    i11 = iIntValue;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return str;
    }
}
