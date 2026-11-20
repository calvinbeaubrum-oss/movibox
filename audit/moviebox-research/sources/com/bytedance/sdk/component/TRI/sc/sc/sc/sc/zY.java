package com.bytedance.sdk.component.TRI.sc.sc.sc.sc;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f26645sc;
    protected final List<com.bytedance.sdk.component.TRI.sc.We.sc> pFF = new ArrayList();
    private boolean zY = false;
    private final Runnable We = new Runnable() { // from class: com.bytedance.sdk.component.TRI.sc.sc.sc.sc.zY.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (zY.this) {
                try {
                    if (zY.this.pFF.isEmpty()) {
                        zY.this.zY = false;
                        return;
                    }
                    ArrayList arrayList = new ArrayList(zY.this.pFF);
                    zY.this.pFF.clear();
                    zY.this.zY = false;
                    zY.this.We(arrayList);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    public zY(Context context) {
        this.f26645sc = context;
    }

    private void sc() {
        if (this.zY) {
            return;
        }
        com.bytedance.sdk.component.TRI.sc.qr.sc.sc().postDelayed(this.We, com.bytedance.sdk.component.TRI.sc.qr.sc.pFF());
        this.zY = true;
    }

    public Context ExN() {
        return this.f26645sc;
    }

    public void We(List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), list);
    }

    public abstract String pFF();

    public synchronized void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        if (scVar.qr() != null && !TextUtils.isEmpty(scVar.zY())) {
            this.pFF.add(scVar);
            sc();
        }
    }

    public void zY(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.TRI.sc.We.sc> it = this.pFF.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.TRI.sc.We.sc next = it.next();
                if (next != null) {
                    String strZY = next.zY();
                    if (!TextUtils.isEmpty(strZY) && list.contains(strZY)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th2) {
            pFF();
            th2.getMessage();
        }
    }
}
