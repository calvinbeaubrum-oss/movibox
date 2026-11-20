package com.bytedance.sdk.openadsdk.core.Ql.zY;

import com.bytedance.sdk.component.utils.TRI;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends com.bytedance.sdk.openadsdk.pFF.pFF {
    public zY(int i11, int i12) {
        super(i11, i12);
    }

    public zY(int i11, int i12, boolean z11) {
        super(i11, i12);
        this.f28660sc = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.pFF.pFF, com.bytedance.sdk.openadsdk.pFF.sc
    public void sc(List<File> list) {
        int size = list.size();
        if (sc(0L, size)) {
            return;
        }
        for (File file : list) {
            TRI.zY(file);
            size--;
            if (sc(file, 0L, size)) {
                return;
            }
        }
    }
}
