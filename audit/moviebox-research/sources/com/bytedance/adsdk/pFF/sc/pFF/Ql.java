package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.Path;
import com.bytedance.adsdk.pFF.sc.sc.Sfl;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ql extends sc<com.bytedance.adsdk.pFF.zY.pFF.SR, Path> {
    private final Path ExN;
    private List<Sfl> TRI;
    private final com.bytedance.adsdk.pFF.zY.pFF.SR We;

    public Ql(List<com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.SR>> list) {
        super(list);
        this.We = new com.bytedance.adsdk.pFF.zY.pFF.SR();
        this.ExN = new Path();
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public Path sc(com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.SR> scVar, float f11) {
        this.We.sc(scVar.f26180sc, scVar.pFF, f11);
        com.bytedance.adsdk.pFF.zY.pFF.SR srSc = this.We;
        List<Sfl> list = this.TRI;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                srSc = this.TRI.get(size).sc(srSc);
            }
        }
        com.bytedance.adsdk.pFF.TRI.ExN.sc(srSc, this.ExN);
        return this.ExN;
    }

    public void sc(List<Sfl> list) {
        this.TRI = list;
    }
}
