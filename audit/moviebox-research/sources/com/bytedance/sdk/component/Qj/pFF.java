package com.bytedance.sdk.component.Qj;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.Tf;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class pFF implements Comparable, Runnable {
    private Thread We = null;
    private sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Qj f26560sc;
    private long zY;

    public pFF(Qj qj2, sc scVar) {
        this.zY = 0L;
        this.f26560sc = qj2;
        this.pFF = scVar;
        this.zY = SystemClock.uptimeMillis();
    }

    private void sc(String str, String str2, long j11) {
        Tf.sc("DelegateRunnable", "pool is " + str + "  name is " + str2 + "is timeout,cost " + j11);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof pFF) {
            return this.f26560sc.compareTo(((pFF) obj).sc());
        }
        return 0;
    }

    public boolean equals(Object obj) {
        Qj qj2;
        return (obj instanceof pFF) && (qj2 = this.f26560sc) != null && qj2.equals(((pFF) obj).sc());
    }

    public int hashCode() {
        return this.f26560sc.hashCode();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // java.lang.Runnable
    public void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.We = Thread.currentThread();
        Qj qj2 = this.f26560sc;
        if (qj2 != null) {
            qj2.run();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        if (this.pFF != null) {
            We.sc();
        }
        if (Tf.sc()) {
            sc scVar = this.pFF;
            if (scVar != null) {
                scVar.sc();
            }
            Qj qj3 = this.f26560sc;
            if (qj3 != null) {
                qj3.getName();
            }
            String strSc = this.pFF.sc();
            strSc.hashCode();
            byte b11 = -1;
            switch (strSc.hashCode()) {
                case 3107:
                    if (strSc.equals("ad")) {
                        b11 = 0;
                    }
                    break;
                case 3366:
                    if (strSc.equals("io")) {
                        b11 = 1;
                    }
                    break;
                case 107332:
                    if (strSc.equals("log")) {
                        b11 = 2;
                    }
                    break;
                case 3237136:
                    if (strSc.equals("init")) {
                        b11 = 3;
                    }
                    break;
                case 212371911:
                    if (strSc.equals("computation")) {
                        b11 = 4;
                    }
                    break;
            }
            switch (b11) {
                case 0:
                case 3:
                    if (jUptimeMillis2 > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                        sc scVar2 = this.pFF;
                        String strSc2 = scVar2 != null ? scVar2.sc() : "null";
                        Qj qj4 = this.f26560sc;
                        sc(strSc2, qj4 != null ? qj4.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 1:
                    if (jUptimeMillis2 > 5000) {
                        sc scVar3 = this.pFF;
                        String strSc3 = scVar3 != null ? scVar3.sc() : "null";
                        Qj qj5 = this.f26560sc;
                        sc(strSc3, qj5 != null ? qj5.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 2:
                    if (jUptimeMillis2 > 3000) {
                        sc scVar4 = this.pFF;
                        String strSc4 = scVar4 != null ? scVar4.sc() : "null";
                        Qj qj6 = this.f26560sc;
                        sc(strSc4, qj6 != null ? qj6.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 4:
                    if (jUptimeMillis2 > 1000) {
                        sc scVar5 = this.pFF;
                        String strSc5 = scVar5 != null ? scVar5.sc() : "null";
                        Qj qj7 = this.f26560sc;
                        sc(strSc5, qj7 != null ? qj7.getName() : "null", jUptimeMillis2);
                    }
                    break;
            }
        }
    }

    public Qj sc() {
        return this.f26560sc;
    }
}
