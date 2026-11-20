package d;

import android.text.TextUtils;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.config.PushRepository;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class z {
    public static int a() {
        int i11;
        ConfigInfo.Whitelist whiteList = PushRepository.getInstance().getWhiteList();
        if (whiteList == null || (i11 = whiteList.version) <= 0) {
            return 0;
        }
        return i11;
    }

    public static boolean b(String str) {
        ConfigInfo.Whitelist whiteList;
        List<ConfigInfo.Apps> list;
        if (!TextUtils.isEmpty(str) && (whiteList = PushRepository.getInstance().getWhiteList()) != null && (list = whiteList.apps) != null) {
            for (ConfigInfo.Apps apps : list) {
                if (apps != null && str.equals(apps.pkg)) {
                    return true;
                }
            }
        }
        return false;
    }
}
