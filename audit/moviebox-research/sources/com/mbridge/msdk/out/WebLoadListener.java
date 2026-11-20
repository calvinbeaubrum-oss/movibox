package com.mbridge.msdk.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface WebLoadListener {
    void onFailed(String str, int i11, int i12, int i13, String str2, String str3);

    void onProgress(String str, int i11, int i12, int i13, String str2, String str3);

    void onSucess(String str, int i11, int i12, int i13, String str2, String str3);
}
