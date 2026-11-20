package com.hisavana.mediation.config;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.i;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import hn.e;
import hn.f;
import hn.g;
import hn.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ConfigContentHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f41904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f41905b;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConfigContentHelper f41906a = new ConfigContentHelper();
    }

    public ConfigContentHelper() {
        this.f41905b = g.d();
        if (TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL)) {
            this.f41904a = f.d();
        } else {
            this.f41904a = e.d();
        }
    }

    public static ConfigContentHelper g() {
        return a.f41906a;
    }

    public void b() {
        this.f41905b.b();
    }

    public void c() {
        this.f41905b.b();
        this.f41904a.a();
    }

    public List<CloudControlConfig.CodeSeat> d() {
        return this.f41904a.b();
    }

    public CloudControlConfig.CodeSeat e(String str) {
        if (TextUtils.isEmpty(str)) {
            MediaLogUtil.e("ConfigContentHelper", "getConfig,codeSeatId is empty");
            AdLogUtil.Log().e("ConfigContentHelper", "getConfig,codeSeatId is empty");
            return null;
        }
        MediaLogUtil.d("ConfigContentHelper", "getConfig " + str);
        try {
            CloudControlConfig.CodeSeat codeSeatA = this.f41905b.a(str);
            if (codeSeatA == null) {
                i.f30292a.e(new Runnable() { // from class: com.hisavana.mediation.config.ConfigContentHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigContentHelper.this.h();
                    }
                });
            }
            if (codeSeatA != null || !TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL)) {
                return codeSeatA;
            }
            Network network = new Network();
            CloudControlConfig.CodeSeat codeSeat = new CloudControlConfig.CodeSeat();
            ArrayList arrayList = new ArrayList();
            codeSeat.setNetworks(arrayList);
            arrayList.add(network);
            codeSeat.setCodeSeatId(str);
            network.setCodeSeatId(str);
            network.setPrice(Double.valueOf(0.0d));
            network.setSource(1);
            AdLogUtil.Log().d("ConfigContentHelper", "aha channel return default config");
            return codeSeat;
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigContentHelper", "ex " + Log.getStackTraceString(e11));
            MediaLogUtil.d("ConfigContentHelper", "getConfig,codeSeatId " + str + ",codeSeat is null");
            return null;
        }
    }

    public long f() {
        return this.f41904a.c();
    }

    public void h() {
        AdLogUtil.Log().d("ConfigContentHelper", "getConfig from database");
        this.f41905b.c(this.f41904a.b());
    }

    public boolean i(List<CloudControlConfig.CodeSeat> list) {
        AdLogUtil.Log().d("ConfigContentHelper", "insert ");
        List<CloudControlConfig.CodeSeat> listD = d();
        if (listD != null && !listD.isEmpty()) {
            for (CloudControlConfig.CodeSeat codeSeat : listD) {
                if (codeSeat != null) {
                    for (CloudControlConfig.CodeSeat codeSeat2 : list) {
                        if (codeSeat2 != null && TextUtils.equals(codeSeat.getCodeSeatId(), codeSeat2.getCodeSeatId())) {
                            codeSeat2.setCurrentHourZeroClock(codeSeat.getCurrentHourZeroClock());
                            codeSeat2.setLastShowTime(codeSeat.getLastShowTime());
                            codeSeat2.setCurrentHourShowTimes(codeSeat.getCurrentHourShowTimes());
                            codeSeat2.setTodayZeroClock(codeSeat.getTodayZeroClock());
                            codeSeat2.setTodayShowTimes(codeSeat.getTodayShowTimes());
                            break;
                        }
                    }
                }
            }
        }
        this.f41905b.c(list);
        return this.f41904a.a(list);
    }

    public void j(final CloudControlConfig.CodeSeat codeSeat) {
        AdLogUtil.Log().d("ConfigContentHelper", "updateConfig " + codeSeat);
        i.f30292a.e(new Runnable() { // from class: com.hisavana.mediation.config.ConfigContentHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (ConfigContentHelper.this.f41904a != null) {
                    ConfigContentHelper.this.f41904a.a(codeSeat);
                }
            }
        });
    }
}
