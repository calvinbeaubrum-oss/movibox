package com.hisavana.admoblibrary.check;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.o;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.hisavana.admoblibrary.check.ExistsCheck;
import com.hisavana.admoblibrary.excuter.AdmobBanner;
import com.hisavana.admoblibrary.excuter.AdmobInterstitia;
import com.hisavana.admoblibrary.excuter.AdmobNative;
import com.hisavana.admoblibrary.excuter.AdmobSplash;
import com.hisavana.admoblibrary.excuter.AdmobVideo;
import com.hisavana.admoblibrary.holder.NativeAdViewHolder;
import com.hisavana.admoblibrary.util.PlatformUtil;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.utils.AdLogUtil;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ExistsCheck implements IBaseAdSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f41685a = new AtomicInteger(0);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a implements b {
        public a() {
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void a() {
            ExistsCheck.f41685a.set(0);
            AdLogUtil.Log().d("Admob ExistsCheck", "Admob ExistsCheck 初始化失败");
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void b() {
            ExistsCheck.f41685a.set(2);
            AdLogUtil.Log().d("Admob ExistsCheck", "Admob ExistsCheck 初始化成功");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public interface b {
        void a();

        void b();
    }

    public static void a(Context context, final b bVar) {
        AtomicInteger atomicInteger = f41685a;
        if (atomicInteger.get() == 2) {
            if (bVar != null) {
                bVar.b();
            }
        } else {
            if (atomicInteger.get() == 1) {
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            try {
                atomicInteger.set(1);
                MobileAds.initialize(context, new OnInitializationCompleteListener() { // from class: cn.a
                    @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
                    public final void onInitializationComplete(InitializationStatus initializationStatus) {
                        ExistsCheck.a(bVar, initializationStatus);
                    }
                });
            } catch (Throwable unused) {
                AdLogUtil.Log().e(ComConstants.SDK_INIT, "ExistsCheck --> admob--> initialize exception");
                f41685a.set(0);
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    public static /* synthetic */ void a(b bVar, InitializationStatus initializationStatus) {
        for (Map.Entry<String, AdapterStatus> entry : initializationStatus.getAdapterStatusMap().entrySet()) {
            if (entry.getValue() != null) {
                AdLogUtil.Log().d("Admob_Init", String.format(Locale.getDefault(), "Adapter name: %s, Description: %s, Latency: %d", entry.getKey(), entry.getValue().getDescription(), Integer.valueOf(entry.getValue().getLatency())));
            }
        }
        f41685a.set(2);
        if (bVar != null) {
            bVar.b();
        }
    }

    public static void b() {
        try {
            MobileAds.setAppMuted(AdMuteStatus.MUTE_ALL);
        } catch (Exception e11) {
            AdLogUtil.Log().e("ADMOB_CHECK", "setAppVolume exception " + Log.getStackTraceString(e11));
        }
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i11, int i12) {
        return dn.a.a(context, network, new AdmobBanner(context, network, i11, i12));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return dn.a.b(context, network, new AdmobInterstitia(context, network));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i11) {
        return dn.a.e(context, network, i11, new AdmobNative(context, network, i11));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNativeViewHolder getNativeViewHolder() {
        return new NativeAdViewHolder();
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseQueryPrice getQueryPrice() {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseSplash getSplash(Context context, Network network) {
        return dn.a.c(context, network, new AdmobSplash(context, network));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return (network == null || TextUtils.isEmpty(network.getNetworkCodeSeatType()) || !network.getNetworkCodeSeatType().equals("7")) ? dn.a.d(context, network, new AdmobVideo(context, network)) : new com.hisavana.admoblibrary.excuter.b(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(Context context, AdSourceConfig adSourceConfig) {
        boolean z11;
        boolean z12;
        String strB;
        if (f41685a.get() != 0) {
            return;
        }
        if (adSourceConfig != null) {
            z11 = adSourceConfig.isInitAdMob;
            z12 = adSourceConfig.testDevice;
        } else {
            z11 = false;
            z12 = false;
        }
        if (z12) {
            try {
                strB = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e11) {
                e11.printStackTrace();
                strB = PlatformUtil.b();
            }
            String upperCase = o.a(strB).toUpperCase();
            if (!TextUtils.isEmpty(upperCase)) {
                MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(upperCase)).build());
            }
        }
        PlatformUtil.f41732a = AdSourceConfig.handler;
        AdLogUtil.Log().d("Admob ExistsCheck", "isInitAdmob == " + z11);
        if (z11) {
            a(f.a(), new a());
        }
    }
}
