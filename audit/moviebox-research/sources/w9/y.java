package w9;

import android.text.TextUtils;
import com.hisavana.common.constant.ComConstants;
import java.util.TimeZone;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class y {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length != 3) {
                return 0;
            }
            return (Integer.parseInt(strArrSplit[0]) * 3600) + (Integer.parseInt(strArrSplit[1]) * 60) + Integer.parseInt(strArrSplit[2]);
        } catch (Exception unused) {
            com.cloud.hisavana.sdk.z.a().e("TimeUtil", "getDuration wrong,param is " + str);
            return 0;
        }
    }

    public static long b(long j11) {
        return j11 - ((((long) TimeZone.getDefault().getRawOffset()) + j11) % 3600000);
    }

    public static long c(long j11) {
        return j11 - ((((long) TimeZone.getDefault().getRawOffset()) + j11) % ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED);
    }
}
