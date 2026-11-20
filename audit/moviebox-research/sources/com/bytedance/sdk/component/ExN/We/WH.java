package com.bytedance.sdk.component.ExN.We;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ExN.wjp;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH extends sc {
    private Bitmap pFF(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        Collection<wjp> collectionSc = zYVar.Sfl().sc();
        Bitmap bitmapSc = null;
        if (collectionSc == null) {
            return null;
        }
        Iterator<wjp> it = collectionSc.iterator();
        while (it.hasNext() && (bitmapSc = it.next().sc(zYVar.ExN())) == null) {
        }
        return bitmapSc;
    }

    private Bitmap zY(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        return zYVar.Sfl().sc(zYVar.YIK()).sc(zYVar.ExN());
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "memory_cache";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        Bitmap bitmapPFF;
        int iTf = zYVar.Tf();
        if (iTf == 2 || iTf == 1) {
            bitmapPFF = (zYVar.Dl() || zYVar.YIK().TRI()) ? pFF(zYVar) : zY(zYVar);
        } else {
            bitmapPFF = null;
        }
        if (bitmapPFF == null) {
            zYVar.sc(new Tf());
        } else {
            zYVar.sc(new Ql(bitmapPFF, null, false));
        }
    }
}
