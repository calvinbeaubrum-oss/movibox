package com.bytedance.sdk.component.TRI.sc;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xc;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final We f26595sc = new We();

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(int i11) {
        if (i11 == 0) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.sc.pFF();
        } else if (i11 == 1) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF.pFF();
        }
    }

    private void pFF(final com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        final ExN exNDE = Qj.qr().dE();
        if (scVar == null || exNDE == null || Qj.qr().TRI() == null || exNDE.We() == null) {
            return;
        }
        if (!Qj.qr().pFF()) {
            Qj.qr().sc(scVar);
            return;
        }
        if (sc(Qj.qr().TRI(), exNDE)) {
            Qj.qr().sc(scVar);
            return;
        }
        zY();
        if (zY()) {
            exNDE.We().execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("dispatchEvent") { // from class: com.bytedance.sdk.component.TRI.sc.We.4
                @Override // java.lang.Runnable
                public void run() {
                    We.this.sc(scVar, exNDE.TRI());
                }
            });
        } else {
            sc(scVar, exNDE.TRI());
        }
    }

    private void pFF(sc scVar, Context context) {
        zY.sc(context, "context == null");
        zY.sc(scVar, "AdLogConfig == null");
        zY.sc(scVar.We(), "AdLogDepend ==null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i11) {
        if (i11 == 0) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.sc.sc();
        } else if (i11 == 1) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF.sc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar, int i11) {
        if (i11 == 0) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.sc.sc(scVar);
        } else if (i11 == 1) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF.sc(scVar);
        }
    }

    private void sc(sc scVar) {
        Executor executorExN;
        if (Looper.myLooper() != Looper.getMainLooper() && com.bytedance.sdk.component.TRI.sc.zY.sc.pFF()) {
            com.bytedance.sdk.component.TRI.sc.zY.sc.sc();
            return;
        }
        ExN exNWe = scVar.We();
        if (exNWe == null || !com.bytedance.sdk.component.TRI.sc.zY.sc.pFF() || (executorExN = exNWe.ExN()) == null) {
            return;
        }
        executorExN.execute(new Runnable() { // from class: com.bytedance.sdk.component.TRI.sc.We.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.TRI.sc.zY.sc.sc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str, int i11, boolean z11) {
        if (i11 == 0) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.sc.sc(str);
        } else if (i11 == 1) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF.sc(str, z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str, List<String> list, boolean z11, int i11, int i12, String str2) {
        if (i11 == 0) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.sc.sc(str, list, z11);
        } else if (i11 == 1) {
            com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF.sc(str, list, z11, i12, str2);
        }
    }

    private boolean sc(Context context, ExN exN) {
        if (context == null || exN == null) {
            return false;
        }
        if (exN.TRI() == 2) {
            return true;
        }
        if (exN.TRI() == 1) {
            return exN.SR();
        }
        try {
            return Xc.sc(context);
        } catch (Throwable th2) {
            th2.getMessage();
            return true;
        }
    }

    private boolean zY() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public void pFF() {
        final ExN exNDE = Qj.qr().dE();
        if (exNDE == null || Qj.qr().TRI() == null || exNDE.We() == null) {
            return;
        }
        if (!Qj.qr().pFF()) {
            Qj.qr().UFX();
            return;
        }
        if (sc(Qj.qr().TRI(), exNDE)) {
            Qj.qr().UFX();
        } else if (zY()) {
            exNDE.We().execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("stop") { // from class: com.bytedance.sdk.component.TRI.sc.We.3
                @Override // java.lang.Runnable
                public void run() {
                    We.this.pFF(exNDE.TRI());
                }
            });
        } else {
            pFF(exNDE.TRI());
        }
    }

    public void sc() {
        final ExN exNDE = Qj.qr().dE();
        if (exNDE == null || Qj.qr().TRI() == null || exNDE.We() == null) {
            return;
        }
        if (!Qj.qr().pFF()) {
            Qj.qr().Ol();
            return;
        }
        if (sc(Qj.qr().TRI(), exNDE)) {
            Qj.qr().Ol();
        } else if (zY()) {
            exNDE.We().execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("start") { // from class: com.bytedance.sdk.component.TRI.sc.We.2
                @Override // java.lang.Runnable
                public void run() {
                    We.this.sc(exNDE.TRI());
                }
            });
        } else {
            sc(exNDE.TRI());
        }
    }

    public void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        pFF(scVar);
    }

    public void sc(sc scVar, Context context) {
        pFF(scVar, context);
        Qj.qr().sc(context);
        Qj.qr().sc(scVar.WH());
        Qj.qr().pFF(scVar.qr());
        Qj.qr().zY(scVar.Qj());
        Qj.qr().sc(scVar.pFF());
        Qj.qr().We(scVar.Ol());
        Qj.qr().ExN(scVar.TRI());
        Qj.qr().sc(scVar.sc() == null ? com.bytedance.sdk.component.TRI.sc.sc.sc.ExN.f26636sc : scVar.sc());
        Qj.qr().pFF(scVar.UFX());
        Qj.qr().sc(scVar.We());
        Qj.qr().sc(scVar.zY());
        Qj.qr().sc(scVar.ExN());
        com.bytedance.sdk.component.TRI.sc.pFF.zY.zY.sc(scVar.Ql());
        com.bytedance.sdk.component.TRI.sc.pFF.zY.zY.pFF(scVar.Tf());
        sc(scVar);
    }

    public void sc(final String str, final List<String> list, final boolean z11, Map<String, String> map, final int i11, final String str2) {
        final ExN exNDE = Qj.qr().dE();
        if (exNDE == null || Qj.qr().TRI() == null || exNDE.We() == null) {
            return;
        }
        if (exNDE.Qj()) {
            if (exNDE.TRI() == 1) {
                if (list == null || list.isEmpty()) {
                    return;
                }
            } else if (exNDE.TRI() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
                return;
            }
            if (Qj.qr().pFF() && !sc(Qj.qr().TRI(), exNDE)) {
                if (zY()) {
                    exNDE.We().execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("trackFailed") { // from class: com.bytedance.sdk.component.TRI.sc.We.5
                        @Override // java.lang.Runnable
                        public void run() {
                            We.this.sc(str, (List<String>) list, z11, exNDE.TRI(), i11, str2);
                        }
                    });
                    return;
                } else {
                    sc(str, list, z11, exNDE.TRI(), i11, str2);
                    return;
                }
            }
            Qj.qr().sc(str, list, z11, map, i11, str2);
        }
    }

    public void sc(final String str, final boolean z11) {
        final ExN exNDE = Qj.qr().dE();
        if (exNDE == null || Qj.qr().TRI() == null || exNDE.We() == null || !exNDE.Qj()) {
            return;
        }
        if (exNDE.TRI() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (!Qj.qr().pFF() || sc(Qj.qr().TRI(), exNDE)) {
            Qj.qr().sc(str, z11);
        } else if (zY()) {
            exNDE.We().execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("trackFailed") { // from class: com.bytedance.sdk.component.TRI.sc.We.6
                @Override // java.lang.Runnable
                public void run() {
                    We.this.sc(str, exNDE.TRI(), z11);
                }
            });
        } else {
            sc(str, exNDE.TRI(), z11);
        }
    }

    public void sc(boolean z11) {
        Qj.qr().sc(z11);
    }
}
