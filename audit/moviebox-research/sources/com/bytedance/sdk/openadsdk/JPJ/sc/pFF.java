package com.bytedance.sdk.openadsdk.JPJ.sc;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private final Sfl pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f27097sc = zY.pFF;
    private final AtomicBoolean zY = new AtomicBoolean(false);
    private final AtomicBoolean We = new AtomicBoolean(true);
    private final AtomicInteger ExN = new AtomicInteger(0);
    private long TRI = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f27096qr = 0;
    private final Runnable Qj = new Runnable() { // from class: com.bytedance.sdk.openadsdk.JPJ.sc.pFF.3
        @Override // java.lang.Runnable
        public void run() {
            pFF.this.We();
        }
    };

    public pFF(Sfl sfl) {
        this.pFF = sfl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ExN() {
        if (this.ExN.get() == 2) {
            this.TRI = SystemClock.elapsedRealtime();
            Handler handlerSc = sc.sc();
            if (handlerSc != null) {
                handlerSc.postDelayed(this.Qj, ((long) this.f27097sc) - this.f27096qr);
            }
            this.ExN.set(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TRI() {
        if (this.ExN.get() != 1 || this.TRI == 0) {
            return;
        }
        Handler handlerSc = sc.sc();
        if (handlerSc != null) {
            handlerSc.removeCallbacks(this.Qj);
        }
        this.f27096qr += SystemClock.elapsedRealtime() - this.TRI;
        this.TRI = 0L;
        this.ExN.set(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        if (this.zY.compareAndSet(false, true)) {
            pFF();
            final long jElapsedRealtime = this.f27096qr + (SystemClock.elapsedRealtime() - this.TRI);
            this.f27096qr = jElapsedRealtime;
            Cb.zY(new Qj("ev_tracker") { // from class: com.bytedance.sdk.openadsdk.JPJ.sc.pFF.1
                @Override // java.lang.Runnable
                public void run() {
                    String strSc = cJ.sc(pFF.this.pFF);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ev_wait_time_server", pFF.this.pFF.OUZ() * 1000);
                        jSONObject.put("ev_wait_time_client", jElapsedRealtime);
                    } catch (JSONException e11) {
                        Tf.sc("EvTracker", e11.getMessage());
                    }
                    com.bytedance.sdk.openadsdk.We.zY.pFF(pFF.this.pFF, strSc, pFF.this.pFF.Pm(), jSONObject);
                }
            });
        }
    }

    public void pFF() {
        this.ExN.set(3);
        Handler handlerSc = sc.sc();
        if (handlerSc != null) {
            handlerSc.removeCallbacks(this.Qj);
        }
    }

    public void sc() {
        if (this.ExN.get() != 0) {
            return;
        }
        this.f27097sc = this.pFF.OUZ() * 1000;
        this.ExN.set(1);
        this.TRI = SystemClock.elapsedRealtime();
        Handler handlerSc = sc.sc();
        if (handlerSc != null) {
            handlerSc.postDelayed(this.Qj, this.f27097sc);
        }
    }

    public void sc(final int i11) {
        Handler handlerSc;
        if (this.ExN.get() == 3 || (handlerSc = sc.sc()) == null) {
            return;
        }
        handlerSc.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.JPJ.sc.pFF.2
            @Override // java.lang.Runnable
            public void run() {
                if (i11 == 4 && pFF.this.We.get()) {
                    pFF.this.ExN();
                    return;
                }
                int i12 = i11;
                if (i12 == 8) {
                    pFF.this.TRI();
                } else if (i12 == 5) {
                    pFF.this.We();
                }
            }
        });
    }

    public void sc(boolean z11) {
        this.We.set(z11);
    }

    public boolean zY() {
        return this.ExN.get() == 3;
    }
}
