package com.aliyun.downloader;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AliDownloaderFactory {
    public static AliMediaDownloader create(Context context) {
        return new ApsaraDownloader(context.getApplicationContext());
    }

    public static int deleteFile(String str, String str2, String str3, int i11) {
        return AliMediaDownloader.deleteFile(str, str2, str3, i11);
    }
}
