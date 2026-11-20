package ho;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class q0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f66749a;

    public q0(d dVar) {
        dVar.getClass();
        this.f66749a = dVar;
    }

    public static k a(TelephonyManager telephonyManager, Context context) {
        int dataNetworkType;
        k.a aVarL = k.l();
        int i11 = 5;
        try {
            int i12 = Build.VERSION.SDK_INT;
            aVarL.d(i12 >= 30 ? telephonyManager.getSubscriptionId() : -1).e(i12 >= 28 ? telephonyManager.getSimCarrierId() : -1).h(i12 >= 28 ? ((CharSequence) q.a(telephonyManager.getSimCarrierIdName(), "")).toString() : "").a(com.google.common.base.p.e(telephonyManager.getSimCountryIso()));
            if (telephonyManager.getSimState() == 5) {
                aVarL.b(com.google.common.base.p.e(telephonyManager.getSimOperator())).j(com.google.common.base.p.e(telephonyManager.getSimOperatorName()));
            }
        } catch (Throwable unused) {
        }
        int i13 = 0;
        try {
            aVarL.i(com.google.common.base.p.e(telephonyManager.getNetworkOperator())).f(com.google.common.base.p.e(telephonyManager.getNetworkOperatorName())).c(com.google.common.base.p.e(telephonyManager.getNetworkCountryIso()));
            if (io.a.c(context, "android.permission.READ_PHONE_STATE") || io.a.c(context, "android.permission.READ_BASIC_PHONE_STATE")) {
                dataNetworkType = Build.VERSION.SDK_INT >= 24 ? telephonyManager.getDataNetworkType() : 0;
                if (dataNetworkType == 0) {
                    try {
                        dataNetworkType = telephonyManager.getNetworkType();
                    } catch (Throwable unused2) {
                    }
                }
            } else {
                dataNetworkType = 0;
            }
        } catch (Throwable unused3) {
        }
        if (dataNetworkType != 0) {
            if (dataNetworkType != 20) {
                switch (dataNetworkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        i11 = 4;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        break;
                    case 13:
                        i11 = 6;
                        break;
                    default:
                        i11 = 0;
                        break;
                }
            } else {
                i11 = 7;
            }
            i13 = i11 == 0 ? 3 : i11;
        }
        return aVarL.g(i13).build();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    @Override // ho.o
    public boolean v(a.AbstractC0700a abstractC0700a, Context context) {
        k kVarA = a(this.f66749a.m(), context);
        if (kVarA.equals(k.l().build())) {
            abstractC0700a.k(Collections.emptyList()).c(-1);
        } else {
            abstractC0700a.k(Collections.singletonList(kVarA)).c(kVarA.e() != 0 ? 0 : -1);
        }
        return false;
    }
}
