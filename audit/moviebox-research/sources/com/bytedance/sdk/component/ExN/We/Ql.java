package com.bytedance.sdk.component.ExN.We;

import com.bytedance.sdk.component.ExN.dE;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ql<T> extends sc {
    private com.bytedance.sdk.component.ExN.TRI pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private T f26492sc;
    private boolean zY;

    public Ql(T t11, com.bytedance.sdk.component.ExN.TRI tri, boolean z11) {
        this.f26492sc = t11;
        this.pFF = tri;
        this.zY = z11;
    }

    private Map<String, String> pFF() {
        com.bytedance.sdk.component.ExN.TRI tri = this.pFF;
        if (tri != null) {
            return tri.ExN();
        }
        return null;
    }

    private void pFF(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        dE dEVarOl = zYVar.Ol();
        if (dEVarOl != null) {
            dEVarOl.sc(new com.bytedance.sdk.component.ExN.zY.We().sc(zYVar, this.f26492sc, pFF(), this.zY));
        }
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "success";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        String strJPJ = zYVar.JPJ();
        Map<String, List<com.bytedance.sdk.component.ExN.zY.zY>> mapQr = zYVar.Sfl().qr();
        List<com.bytedance.sdk.component.ExN.zY.zY> list = mapQr.get(strJPJ);
        if (list == null) {
            pFF(zYVar);
            return;
        }
        synchronized (list) {
            try {
                Iterator<com.bytedance.sdk.component.ExN.zY.zY> it = list.iterator();
                while (it.hasNext()) {
                    pFF(it.next());
                }
                list.clear();
                mapQr.remove(strJPJ);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
