package hn;

import android.util.Log;
import com.hisavana.common.bean.Network;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.ConfigContentHelper;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {
    public static CloudControlConfig.CodeSeat a(String str) {
        return b(str, "", false);
    }

    public static CloudControlConfig.CodeSeat b(String str, String str2, boolean z11) {
        CloudControlConfig.CodeSeat codeSeatE = null;
        try {
            codeSeatE = ConfigContentHelper.g().e(str);
            if (codeSeatE == null) {
                return codeSeatE;
            }
            List<Network> networks = codeSeatE.getNetworks();
            if (networks != null && !networks.isEmpty()) {
                for (Network network : networks) {
                    if (network.getSource().intValue() != 1 && !o.f(network, codeSeatE.getCodeSeatType())) {
                        network.setPrice(Double.valueOf(network.getTempPrice()));
                    }
                    if (z11) {
                        AdUtil.overwriteAdmobNetworkPrice(network, str2);
                    }
                }
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigUtil", "getConfigByAdUnit " + Log.getStackTraceString(e11));
        }
        return codeSeatE;
    }
}
