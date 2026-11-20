package hn;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.Network;
import com.hisavana.common.manager.BidExecutorCacheManager;
import com.hisavana.common.mock.RecordTestInfo;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Network> f66549a = new HashMap<>();

    public Network a(@NonNull String str) {
        return c(str);
    }

    public boolean b(String str, @NonNull Network network) {
        if (network == null) {
            return false;
        }
        Network networkC = c(str);
        double dDoubleValue = networkC != null ? networkC.getPrice().doubleValue() : 0.0d;
        if (dDoubleValue > 0.0d && dDoubleValue > network.getPrice().doubleValue()) {
            return false;
        }
        d(str, network);
        if (!LogSwitch.isDebug) {
            return true;
        }
        RecordTestInfo.LogMsg("add price cache:" + RecordTestInfo.getLogMsg(network), RecordTestInfo.LOG_CODE11);
        return true;
    }

    public final Network c(String str) {
        Network network;
        BaseAd baseAdRemoveData;
        if (TextUtils.isEmpty(str) || (network = this.f66549a.get(str)) == null) {
            return null;
        }
        if (network.getBidInfo() != null && !network.getBidInfo().isExpired()) {
            return network;
        }
        this.f66549a.remove(str);
        if (network.getSource().intValue() == 8 && (baseAdRemoveData = BidExecutorCacheManager.getInstance().removeData(network.getCodeSeatId())) != null) {
            baseAdRemoveData.destroyAd();
        }
        return null;
    }

    public final void d(String str, Network network) {
        if (TextUtils.isEmpty(str) || network == null) {
            return;
        }
        this.f66549a.put(str, network);
    }
}
