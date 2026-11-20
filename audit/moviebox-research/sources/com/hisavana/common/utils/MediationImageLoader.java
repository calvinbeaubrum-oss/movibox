package com.hisavana.common.utils;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.sdk.commonutil.util.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MediationImageLoader {
    public static void loadImage(String str, ImageView imageView) {
        AdLogUtil adLogUtilLog;
        String str2;
        if (imageView != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                AdLogUtil.Log().d("ContentValues", "loadImageView,url:" + str);
                if (l.d(str, imageView, false)) {
                    adLogUtilLog = AdLogUtil.Log();
                    str2 = "loadImageView,mediation picasso || glide";
                } else {
                    DownLoadRequest.p(str, null, 9, null, imageView);
                    adLogUtilLog = AdLogUtil.Log();
                    str2 = "loadImageView,mediation ssp";
                }
                adLogUtilLog.d("ContentValues", str2);
            } catch (Throwable th2) {
                AdLogUtil.Log().d("ContentValues", "ALL " + Log.getStackTraceString(th2));
            }
        }
    }
}
