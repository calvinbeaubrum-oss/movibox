package com.cloud.hisavana.sdk.common.http;

import android.util.Log;
import com.cloud.hisavana.sdk.data.bean.response.AdResponseBody;
import com.cloud.hisavana.sdk.z;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static void a(AdResponseBody adResponseBody) {
        if (adResponseBody == null || adResponseBody.getData() == null) {
            return;
        }
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").parse(adResponseBody.getData().getTime());
            da.a.d().o("services_time_difference_value", System.currentTimeMillis() - (date == null ? 0L : date.getTime()));
        } catch (Exception e11) {
            z.a().e(Log.getStackTraceString(e11));
        }
    }
}
