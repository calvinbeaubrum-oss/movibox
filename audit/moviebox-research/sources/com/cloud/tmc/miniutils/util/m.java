package com.cloud.tmc.miniutils.util;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m {
    public static long a(String str) {
        long contentLength = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpURLConnection.setRequestMethod("HEAD");
            contentLength = httpURLConnection.getContentLength();
            httpURLConnection.disconnect();
            return contentLength;
        } catch (Throwable unused) {
            return contentLength;
        }
    }
}
