package com.bytedance.sdk.component.qr;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.pFF.sc.Qj;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.bytedance.sdk.component.qr.We.zY;
import com.bytedance.sdk.component.qr.pFF.We;
import com.bytedance.sdk.component.qr.zY.qr;
import com.bytedance.sdk.component.utils.Xc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private qr pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private UFX f26977sc;
    private int zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.qr.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0264sc {
        private Set<String> TRI;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private Bundle f26978qr;
        boolean We = true;
        final List<Qj> ExN = new ArrayList();

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        int f26979sc = 10000;
        int pFF = 10000;
        int zY = 10000;

        private static int sc(String str, long j11, TimeUnit timeUnit) {
            if (j11 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j11);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j11 <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public C0264sc pFF(long j11, TimeUnit timeUnit) {
            this.pFF = sc("timeout", j11, timeUnit);
            return this;
        }

        public C0264sc sc(long j11, TimeUnit timeUnit) {
            this.f26979sc = sc("timeout", j11, timeUnit);
            return this;
        }

        public C0264sc sc(boolean z11) {
            this.We = z11;
            return this;
        }

        public sc sc() {
            return new sc(this);
        }

        public C0264sc zY(long j11, TimeUnit timeUnit) {
            this.zY = sc("timeout", j11, timeUnit);
            return this;
        }
    }

    private sc(C0264sc c0264sc) {
        UFX.sc scVar = new UFX.sc();
        long j11 = c0264sc.f26979sc;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        UFX.sc scVarPFF = scVar.sc(j11, timeUnit).zY(c0264sc.zY, timeUnit).pFF(c0264sc.pFF, timeUnit);
        if (c0264sc.We) {
            qr qrVar = new qr();
            this.pFF = qrVar;
            scVarPFF.sc(qrVar);
        }
        List<Qj> list = c0264sc.ExN;
        if (list != null && list.size() > 0) {
            Iterator<Qj> it = c0264sc.ExN.iterator();
            while (it.hasNext()) {
                scVarPFF.sc(it.next());
            }
        }
        if (c0264sc.f26978qr != null) {
            Bundle unused = c0264sc.f26978qr;
        }
        Set unused2 = c0264sc.TRI;
        this.f26977sc = scVarPFF.sc();
    }

    public static void sc() {
        zY.sc(zY.sc.DEBUG);
    }

    private static boolean sc(Context context) {
        String strPFF = Xc.pFF(context);
        if (strPFF != null) {
            return strPFF.endsWith(":push") || strPFF.endsWith(":pushservice");
        }
        return false;
    }

    public UFX ExN() {
        return this.f26977sc;
    }

    public com.bytedance.sdk.component.qr.pFF.sc We() {
        return new com.bytedance.sdk.component.qr.pFF.sc(this.f26977sc);
    }

    public We pFF() {
        return new We(this.f26977sc);
    }

    public void sc(Context context, boolean z11) {
        com.bytedance.sdk.component.qr.zY.sc.pFF(true);
        if (sc(context) || (!Xc.sc(context) && z11)) {
            com.bytedance.sdk.component.qr.zY.Qj.sc().sc(this.zY, context).We();
            com.bytedance.sdk.component.qr.zY.Qj.sc().sc(this.zY, context).sc();
        }
        if (Xc.sc(context)) {
            com.bytedance.sdk.component.qr.zY.Qj.sc().sc(this.zY, context).We();
            com.bytedance.sdk.component.qr.zY.Qj.sc().sc(this.zY, context).sc();
        }
    }

    public void sc(Context context, boolean z11, com.bytedance.sdk.component.qr.zY.pFF pff) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (pff == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iSc = pff.sc();
        this.zY = iSc;
        qr qrVar = this.pFF;
        if (qrVar != null) {
            qrVar.sc(iSc);
        }
        com.bytedance.sdk.component.qr.zY.Qj.sc().sc(this.zY).sc(z11);
        com.bytedance.sdk.component.qr.zY.Qj.sc().sc(this.zY).sc(pff);
        com.bytedance.sdk.component.qr.zY.Qj.sc().sc(this.zY).sc(context, Xc.sc(context));
    }

    public com.bytedance.sdk.component.qr.pFF.pFF zY() {
        return new com.bytedance.sdk.component.qr.pFF.pFF(this.f26977sc);
    }
}
