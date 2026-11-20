package com.bytedance.sdk.component.adexpress.sc.pFF;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.Xc;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends zY {
    private static volatile ExN pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static File f26894sc;
    private AtomicBoolean zY = new AtomicBoolean(true);
    private AtomicBoolean We = new AtomicBoolean(false);
    private boolean ExN = false;
    private AtomicBoolean TRI = new AtomicBoolean(false);

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private AtomicInteger f26895qr = new AtomicInteger(0);
    private AtomicLong Qj = new AtomicLong();

    private ExN() {
        WH();
    }

    public static File Qj() {
        if (f26894sc == null) {
            try {
                File file = new File(new File(We.sc(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                f26894sc = file;
            } catch (Throwable th2) {
                Tf.sc("TemplateManager", "getTemplateDir error", th2);
            }
        }
        return f26894sc;
    }

    private void UFX() {
        if (this.f26895qr.getAndSet(0) <= 0 || System.currentTimeMillis() - this.Qj.get() <= TTAdConstant.AD_MAX_EVENT_TIME) {
            return;
        }
        qr();
    }

    private void WH() {
        com.bytedance.sdk.component.adexpress.We.We.pFF(new com.bytedance.sdk.component.Qj.Qj("init") { // from class: com.bytedance.sdk.component.adexpress.sc.pFF.ExN.1
            @Override // java.lang.Runnable
            public void run() {
                Qj.sc();
                ExN.this.zY.set(false);
                ExN.this.We();
                ExN.this.qr();
                if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() == null || !Xc.sc(com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().pFF())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().zY().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.sc.pFF.ExN.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() != null) {
                            com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().We();
                        }
                    }
                });
            }
        }, 10);
    }

    public static ExN pFF() {
        if (pFF == null) {
            synchronized (ExN.class) {
                try {
                    if (pFF == null) {
                        pFF = new ExN();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    public boolean ExN() {
        return this.ExN;
    }

    public void Ol() {
        this.TRI.set(true);
        this.ExN = false;
        this.We.set(false);
    }

    public com.bytedance.sdk.component.adexpress.sc.zY.sc TRI() {
        return Qj.pFF();
    }

    public void We() {
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarPFF = Qj.pFF();
        if (scVarPFF == null || !scVarPFF.qr()) {
            return;
        }
        boolean zSc = sc(scVarPFF);
        if (!zSc) {
            Qj.We();
        }
        this.ExN = zSc;
    }

    public void pFF(boolean z11) {
        this.TRI.set(z11);
    }

    public void qr() {
        sc(false);
    }

    @Override // com.bytedance.sdk.component.adexpress.sc.pFF.zY
    public File sc() {
        return Qj();
    }

    public void sc(boolean z11) {
        List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> listSc;
        boolean z12;
        if (this.zY.get()) {
            return;
        }
        try {
            if (this.We.get()) {
                if (z11) {
                    this.f26895qr.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z13 = true;
            this.We.set(true);
            com.bytedance.sdk.component.adexpress.sc.zY.sc scVarExN = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().ExN();
            com.bytedance.sdk.component.adexpress.sc.zY.sc scVarPFF = Qj.pFF();
            if (scVarExN != null && scVarExN.qr()) {
                if (!Qj.pFF(scVarExN)) {
                    this.We.set(false);
                    this.Qj.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() != null) {
                    com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().zY().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.sc.pFF.ExN.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.ExN.ExN.sc().pFF();
                        }
                    });
                }
                Qj.sc(scVarExN);
                boolean zSc = (scVarExN.ExN() == null || TextUtils.isEmpty(scVarExN.ExN().sc())) ? false : sc(scVarExN.ExN().sc());
                if (scVarExN.sc().size() != 0) {
                    listSc = sc(scVarExN, scVarPFF);
                    z12 = listSc != null;
                } else {
                    listSc = null;
                    z12 = zSc;
                }
                if (!zSc) {
                    List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> listPFF = pFF(scVarExN, scVarPFF);
                    if (listSc == null || listPFF == null) {
                        listSc = listPFF;
                    } else {
                        listSc.addAll(listPFF);
                    }
                    if (listPFF == null) {
                        z13 = false;
                    }
                    if (listPFF == null) {
                        this.We.set(false);
                    }
                    z12 = z13;
                }
                if (z12 && sc(scVarExN)) {
                    Qj.sc(scVarExN);
                    Qj.zY();
                    pFF(listSc);
                }
                We();
                this.We.set(false);
                this.Qj.set(System.currentTimeMillis());
                UFX();
                return;
            }
            this.We.set(false);
            sc(109);
        } catch (Throwable unused) {
        }
    }

    public boolean sc(com.bytedance.sdk.component.adexpress.sc.zY.sc scVar) {
        if (scVar == null) {
            return false;
        }
        return sc(scVar.sc()) || sc(scVar.ExN()) || sc(scVar.TRI());
    }

    public void zY() {
        WH();
    }
}
