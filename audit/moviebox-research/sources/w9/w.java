package w9;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.hisavana.common.constant.ComConstants;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class w {
    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str2.toLowerCase();
        if (d(lowerCase)) {
            for (String str3 : str.split("[^a-zA-Z0-9]+")) {
                if (TextUtils.equals(str3.toLowerCase(), lowerCase)) {
                    return true;
                }
            }
            return false;
        }
        if (!str.toLowerCase().trim().contains(lowerCase)) {
            return false;
        }
        com.cloud.hisavana.sdk.z.a().d("SensitiveUtil", "is sensitive ,word is: " + lowerCase);
        com.cloud.hisavana.sdk.z.a().d("SensitiveUtil", "is sensitive ,content is: " + str);
        return true;
    }

    public static boolean b(TaNativeInfo taNativeInfo) {
        return c(taNativeInfo.getTitle(), taNativeInfo.getDescription());
    }

    public static boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
            Set<String> setK = da.a.d().k(ComConstants.KEY_WORDS);
            com.cloud.hisavana.sdk.z.a().d("SensitiveUtil", "Sensitive keywords is:=" + setK);
            if (setK != null) {
                for (String str3 : setK) {
                    if (!TextUtils.isEmpty(str3) && (a(str2, str3) || a(str, str3))) {
                        return true;
                    }
                }
            }
        }
        com.cloud.hisavana.sdk.z.a().d("SensitiveUtil", "sensitive check is pass");
        return false;
    }

    public static boolean d(String str) {
        return str.matches("^[a-z0-9A-Z]+$");
    }
}
