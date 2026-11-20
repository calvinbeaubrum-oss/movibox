package com.bytedance.sdk.component.ExN.We;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends sc {
    private byte[] pFF(com.bytedance.sdk.component.ExN.zY.zY zYVar, String str) {
        com.bytedance.sdk.component.ExN.zY zYVarZY = zYVar.Sfl().zY(zYVar.YIK());
        if (zYVarZY == null) {
            return null;
        }
        return zYVarZY.sc(str);
    }

    private byte[] sc(com.bytedance.sdk.component.ExN.zY.zY zYVar, String str) {
        zYVar.Sfl().zY(zYVar.YIK());
        Collection<com.bytedance.sdk.component.ExN.zY> collectionZY = zYVar.Sfl().zY();
        if (collectionZY == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.ExN.zY> it = collectionZY.iterator();
        while (it.hasNext()) {
            byte[] bArrSc = it.next().sc(str);
            if (bArrSc != null) {
                return bArrSc;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "disk_cache";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        String strWH = zYVar.WH();
        byte[] bArrSc = (zYVar.Dl() || zYVar.YIK().TRI()) ? sc(zYVar, strWH) : pFF(zYVar, strWH);
        if (bArrSc == null) {
            zYVar.sc(new UFX());
        } else {
            zYVar.sc(new pFF(bArrSc, null));
            zYVar.Sfl().pFF(zYVar.YIK()).sc(strWH, bArrSc);
        }
    }
}
