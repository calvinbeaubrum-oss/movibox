package com.bytedance.sdk.component.ExN.We;

import com.bytedance.sdk.component.ExN.dE;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj extends sc {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Throwable f26491sc;
    private String zY;

    public Qj(int i11, String str, Throwable th2) {
        this.pFF = i11;
        this.zY = str;
        this.f26491sc = th2;
    }

    private void pFF(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        dE dEVarOl = zYVar.Ol();
        if (dEVarOl != null) {
            dEVarOl.sc(this.pFF, this.zY, this.f26491sc);
        }
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "failed";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        zYVar.sc(new com.bytedance.sdk.component.ExN.zY.sc(this.pFF, this.zY, this.f26491sc));
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
