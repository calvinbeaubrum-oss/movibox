package com.transsion.transfer.androidasync.http;

import android.net.Uri;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i extends j {
    public i(Uri uri) {
        super(uri, "POST");
    }

    public i(String str) {
        this(Uri.parse(str));
    }
}
