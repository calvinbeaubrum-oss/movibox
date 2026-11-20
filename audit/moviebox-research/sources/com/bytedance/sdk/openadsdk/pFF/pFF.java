package com.bytedance.sdk.openadsdk.pFF;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends sc {
    private volatile boolean We;
    private int pFF;
    private int zY;

    public pFF(int i11, int i12) {
        this.pFF = 15;
        this.zY = 3;
        if (i11 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.pFF = i11;
        this.zY = i12;
    }

    public pFF(int i11, int i12, boolean z11) {
        this.pFF = 15;
        this.zY = 3;
        if (i11 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.pFF = i11;
        this.zY = i12;
        this.We = z11;
    }

    private void We(List<File> list) {
        long jPFF;
        int size;
        boolean zSc;
        if (list != null) {
            try {
                if (list.size() == 0 || (zSc = sc((jPFF = pFF(list)), (size = list.size())))) {
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zSc) {
                        ((Long) entry.getKey()).longValue();
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jPFF -= length;
                        }
                        if (sc(file2, jPFF, size)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void zY(List<File> list) {
        long jPFF = pFF(list);
        int size = list.size();
        if (sc(jPFF, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jPFF -= length;
            }
            if (sc(file, jPFF, size)) {
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pFF.sc
    public void sc(List<File> list) {
        if (!this.We) {
            zY(list);
        } else {
            We(list);
            this.We = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pFF.sc
    public boolean sc(long j11, int i11) {
        return i11 <= this.pFF;
    }

    @Override // com.bytedance.sdk.openadsdk.pFF.sc
    public boolean sc(File file, long j11, int i11) {
        return i11 <= this.zY;
    }
}
