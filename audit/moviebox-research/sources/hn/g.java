package hn;

import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f66589b = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, CloudControlConfig.CodeSeat> f66590a;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f66591a = new g();
    }

    public g() {
        this.f66590a = new ConcurrentHashMap<>();
    }

    public static g d() {
        return b.f66591a;
    }

    public CloudControlConfig.CodeSeat a(String str) {
        try {
            CloudControlConfig.CodeSeat codeSeat = this.f66590a.get(str);
            if (codeSeat != null) {
                return codeSeat;
            }
            AdLogUtil.Log().d(f66589b, "getCodeSeat value is null");
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void b() {
        AdLogUtil.Log().d(f66589b, "clearCache");
        this.f66590a.clear();
    }

    public void c(List<CloudControlConfig.CodeSeat> list) {
        if (list == null) {
            return;
        }
        try {
            b();
            for (CloudControlConfig.CodeSeat codeSeat : list) {
                this.f66590a.put(codeSeat.getCodeSeatId(), codeSeat);
            }
        } catch (Exception unused) {
            AdLogUtil.Log().d(f66589b, "update code seat error");
        }
    }
}
