package hn;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.config.TAdManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f66609b = {0, 1, 2, 3, 4, 5, 12, 8, 11, 6, 9, 14, 15, 16};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SparseArray<String> f66610c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<IBaseAdSummary> f66611a = new SparseArray<>();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f66612a = new o();
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f66610c = sparseArray;
        sparseArray.put(0, "com.hisavana.adxlibrary.check.ExistsCheck");
        sparseArray.put(1, "com.hisavana.admoblibrary.check.ExistsCheck");
        sparseArray.put(2, "com.hisavana.fblibrary.excuter.check.ExistsCheck");
        sparseArray.put(3, "com.hisavana.applovin.check.ExistsCheck");
        sparseArray.put(4, "com.hisavana.unity.check.ExistsCheck");
        sparseArray.put(5, "com.hisavana.ironsource.check.ExistsCheck");
        sparseArray.put(8, "com.hisavana.inmobi.check.ExistsCheck");
        sparseArray.put(12, "com.hisavana.vungle.check.ExistsCheck");
        sparseArray.put(11, "com.hisavana.adcolony.check.ExistsCheck");
        sparseArray.put(9, "com.hisavana.mintegral.check.ExistsCheck");
        sparseArray.put(14, "com.hisavana.max.check.ExistsCheck");
        sparseArray.put(15, "com.hisavana.yandex.check.ExistsCheck");
        sparseArray.put(16, "com.hisavana.bigo.check.ExistsCheck");
        sparseArray.put(6, "com.hisavana.pangle.check.ExistsCheck");
    }

    public static o a() {
        return a.f66612a;
    }

    public static boolean e(Network network) {
        if (network == null) {
            return false;
        }
        return AdUtil.isBiddingNetwork(network.getSource().intValue());
    }

    public static boolean f(Network network, Integer num) {
        if (network == null || num == null) {
            return false;
        }
        return network.getSource().intValue() == 9 || network.getSource().intValue() == 2 || (network.getSource().intValue() == 8 && num.intValue() != 1);
    }

    public static boolean g(Iad iad) {
        if (iad == null) {
            return false;
        }
        return AdUtil.isBiddingNetwork(iad.getAdSource());
    }

    public final String b(int i11) {
        return f66610c.get(i11);
    }

    public final void c(@NonNull Context context, int i11, @NonNull TAdManager.AdConfig adConfig) {
        boolean z11;
        IBaseAdSummary iBaseAdSummary;
        String strB = b(i11);
        IBaseAdSummary iBaseAdSummary2 = null;
        try {
            iBaseAdSummary = (IBaseAdSummary) Class.forName(strB).newInstance();
            z11 = true;
        } catch (Throwable unused) {
            z11 = false;
            iBaseAdSummary = null;
        }
        AdLogUtil.Log().d(ComConstants.SDK_INIT, "platform classname = " + strB + " exist = " + z11);
        if (z11) {
            try {
                AdSourceConfig adSourceConfig = new AdSourceConfig();
                adSourceConfig.isDebug = adConfig.isDebug();
                adSourceConfig.appId = adConfig.getAppId();
                adSourceConfig.testDevice = adConfig.isTestDevice();
                adSourceConfig.isLite = adConfig.isLite();
                adSourceConfig.vidAppId = adConfig.getAppId();
                adSourceConfig.appIconId = adConfig.getAppIconId();
                adSourceConfig.isInitAdMob = adConfig.isInitAdmob();
                adSourceConfig.isInitAlliance = adConfig.isInitAlliance();
                adSourceConfig.defaultVersion = adConfig.getDefaultVersion();
                adSourceConfig.defaultMaterialMaxSize = adConfig.getDefaultMaterialMaxSize();
                adSourceConfig.shouldOptimizeImageLoading = adConfig.getShouldOptimizeImageLoading();
                iBaseAdSummary.init(context, adSourceConfig);
                iBaseAdSummary2 = iBaseAdSummary;
            } catch (Throwable th2) {
                AdLogUtil.Log().e(ComConstants.SDK_INIT, "ad source init error source:" + i11 + " error:" + th2.getMessage());
            }
            if (iBaseAdSummary2 != null) {
                this.f66611a.put(i11, iBaseAdSummary2);
            }
        }
    }

    public void d(@NonNull Context context, TAdManager.AdConfig adConfig) {
        for (int i11 : f66609b) {
            c(context, i11, adConfig);
        }
    }

    public IBaseAdSummary h(int i11) {
        return this.f66611a.get(i11);
    }
}
