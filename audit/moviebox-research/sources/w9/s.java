package w9;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.e1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class s {
    public static int a(int i11, String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        boolean zP = e1.p(com.cloud.sdk.commonutil.util.f.a(), str, str2);
        if (i11 == 2 && zP) {
            com.cloud.hisavana.sdk.z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "app is exist,not fill");
            return 1;
        }
        if (i11 != 3 || zP) {
            return 0;
        }
        com.cloud.hisavana.sdk.z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "app is not exist,not fill");
        return 2;
    }
}
