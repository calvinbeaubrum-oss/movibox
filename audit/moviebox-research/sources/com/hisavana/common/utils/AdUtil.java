package com.hisavana.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.constant.ComConstants;
import da.a;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdUtil {
    public static boolean checkAppInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                PackageManager packageManager = context.getPackageManager();
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                if (packageManager.getPackageInfo(str, 0) != null) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int filterAdByPullOrNew(List<TAdNativeInfo> list) {
        int i11 = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<TAdNativeInfo> it = list.iterator();
            while (it.hasNext()) {
                TAdNativeInfo next = it.next();
                if (next.isIconAd()) {
                    int pullNewestLive = next.getPullNewestLive();
                    String packageName = next.getPackageName();
                    AdLogUtil.Log().d("AdUtil", "current ad  ----->  packageName: " + packageName + ";    PullNewestLive:" + next.getPullNewestLive());
                    if (pullNewestLive == 3 || pullNewestLive == 2) {
                        if (!TextUtils.isEmpty(packageName)) {
                            boolean zCheckAppInstalled = checkAppInstalled(f.a(), packageName);
                            if ((pullNewestLive != 3 || zCheckAppInstalled) && (pullNewestLive != 2 || !zCheckAppInstalled)) {
                            }
                        }
                        it.remove();
                        i11++;
                    }
                }
            }
        }
        return i11;
    }

    public static boolean isAdmobNetwork(int i11) {
        return i11 == 1;
    }

    public static boolean isBiddingNetwork(int i11) {
        return i11 == 6 || i11 == 0 || i11 == 14 || i11 == 16;
    }

    public static boolean isDebuggable() {
        try {
            return (f.a().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWaterFall(int i11) {
        return i11 == 1 || i11 == 3 || i11 == 5 || i11 == 4 || i11 == 12 || i11 == 11 || i11 == 15;
    }

    public static boolean isZero(@NonNull BigDecimal bigDecimal) {
        return bigDecimal.compareTo(new BigDecimal("0")) == 0;
    }

    public static void overwriteAdmobNetworkPrice(@NonNull Network network) {
        overwriteAdmobNetworkPrice(network, "");
    }

    public static void overwriteAdmobNetworkPrice(@NonNull Network network, String str) {
        if (isAdmobNetwork(network.getSource().intValue())) {
            BigDecimal showPriceCoefficient = network.getShowPriceCoefficient();
            AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> priceCoefficient: " + showPriceCoefficient.doubleValue() + " | codeSeatId: " + network.getCodeSeatId());
            if (isZero(showPriceCoefficient)) {
                return;
            }
            long jH = a.d().h(network.getCodeSeatId(), 0L);
            if (jH > 0) {
                double tempPrice = network.getTempPrice();
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(jH / 1000.0d);
                double dDoubleValue = bigDecimalValueOf.multiply(showPriceCoefficient).multiply(BigDecimal.valueOf(100L)).stripTrailingZeros().doubleValue();
                if (dDoubleValue > tempPrice) {
                    network.setPrice(Double.valueOf(dDoubleValue));
                }
                AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> valueMicros: " + jH + " | valueDollar :" + bigDecimalValueOf + " | price :" + dDoubleValue + " | formerPrice: " + tempPrice + " | nowPrice: " + network.getPrice());
            }
        }
    }

    public static void release(TAdNativeInfo tAdNativeInfo) {
        if (tAdNativeInfo != null) {
            tAdNativeInfo.release();
        }
    }
}
