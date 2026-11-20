package com.blankj.utilcode.util;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class CacheDiskUtils$DiskCacheManager$1 implements Runnable {
    final /* synthetic */ e this$0;
    final /* synthetic */ File val$cacheDir;

    /* JADX INFO: compiled from: source.java */
    public class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("cdu_");
        }
    }

    public CacheDiskUtils$DiskCacheManager$1(e eVar, File file) {
        this.val$cacheDir = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        File[] fileArrListFiles = this.val$cacheDir.listFiles(new a());
        if (fileArrListFiles != null) {
            int length = 0;
            int i11 = 0;
            for (File file : fileArrListFiles) {
                length = (int) (((long) length) + file.length());
                i11++;
                e.a(null).put(file, Long.valueOf(file.lastModified()));
            }
            e.b(null).getAndAdd(length);
            e.c(null).getAndAdd(i11);
        }
    }
}
