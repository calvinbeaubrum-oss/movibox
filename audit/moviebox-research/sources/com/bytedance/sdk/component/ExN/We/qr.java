package com.bytedance.sdk.component.ExN.We;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends sc {
    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        List<com.bytedance.sdk.component.ExN.zY.zY> linkedList;
        String strJPJ = zYVar.JPJ();
        Map<String, List<com.bytedance.sdk.component.ExN.zY.zY>> mapQr = zYVar.Sfl().qr();
        synchronized (mapQr) {
            try {
                linkedList = mapQr.get(strJPJ);
                if (linkedList == null) {
                    linkedList = new LinkedList<>();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (linkedList) {
            try {
                linkedList.add(zYVar);
                mapQr.put(strJPJ, linkedList);
                if (linkedList.size() <= 1) {
                    zYVar.sc(new We());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
