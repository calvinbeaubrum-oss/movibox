package ho;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class l1 extends q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f66722d = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubscriptionManager f66723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r0 f66724c;

    public l1(d dVar, Context context) {
        super(dVar);
        this.f66723b = (Build.VERSION.SDK_INT < 33 || io.a.d(context, "android.hardware.telephony.subscription")) ? s0.a(io.a.e(context, z2.b.a(), "telephony_subscription_service")) : null;
    }

    public static k b(TelephonyManager telephonyManager, SubscriptionInfo subscriptionInfo, boolean z11, Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return q0.a(telephonyManager.createForSubscriptionId(subscriptionInfo.getSubscriptionId()), context);
            } catch (Throwable unused) {
            }
        }
        if (z11) {
            return q0.a(telephonyManager, context);
        }
        k.a aVarL = k.l();
        aVarL.d(subscriptionInfo.getSubscriptionId()).g(3).a(com.google.common.base.p.e(subscriptionInfo.getCountryIso()));
        if (Build.VERSION.SDK_INT >= 29) {
            String strE = com.google.common.base.p.e(subscriptionInfo.getMccString());
            String strE2 = com.google.common.base.p.e(subscriptionInfo.getMncString());
            if (strE.isEmpty() && strE2.isEmpty()) {
                str = "";
            } else {
                str = com.google.common.base.p.f(strE, 3, '0') + com.google.common.base.p.f(strE2, 3, '0');
            }
            aVarL.b(str).e(subscriptionInfo.getCarrierId()).h(((CharSequence) q.a(subscriptionInfo.getCarrierName(), "")).toString());
        } else {
            int iMax = Math.max(subscriptionInfo.getMcc(), 0);
            int iMax2 = Math.max(subscriptionInfo.getMnc(), 0);
            if (iMax > 0 || iMax2 > 0) {
                aVarL.b(String.format(Locale.ROOT, "%03d%03d", Integer.valueOf(iMax), Integer.valueOf(iMax2)));
            }
        }
        return aVarL.build();
    }

    public final void c() {
        if (!f66722d && this.f66723b == null) {
            throw new AssertionError();
        }
        int i11 = Build.VERSION.SDK_INT;
        r0 r0Var = i11 >= 35 ? new r0(this) : (r0) Futures.e(this.f66749a.d().w().submit(new Callable() { // from class: ho.k1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f66714a.d();
            }
        }));
        if (i11 >= 30) {
            this.f66723b.addOnSubscriptionsChangedListener(this.f66749a.d().n(), r0Var);
        } else {
            this.f66723b.addOnSubscriptionsChangedListener(r0Var);
        }
        this.f66724c = r0Var;
    }

    @Override // ho.q0, java.lang.AutoCloseable
    public void close() {
        r0 r0Var;
        SubscriptionManager subscriptionManager = this.f66723b;
        if (subscriptionManager == null || (r0Var = this.f66724c) == null) {
            return;
        }
        subscriptionManager.removeOnSubscriptionsChangedListener(r0Var);
        this.f66724c = null;
    }

    public final /* synthetic */ r0 d() {
        return new r0(this);
    }

    @Override // ho.q0, ho.o
    public boolean v(a.AbstractC0700a abstractC0700a, Context context) {
        int size;
        if (this.f66723b == null || !io.a.c(context, "android.permission.READ_PHONE_STATE")) {
            super.v(abstractC0700a, context);
            return false;
        }
        if (this.f66724c == null) {
            c();
        }
        TelephonyManager telephonyManagerM = this.f66749a.m();
        ArrayList arrayList = new ArrayList();
        int i11 = Build.VERSION.SDK_INT;
        int activeDataSubscriptionId = i11 >= 30 ? SubscriptionManager.getActiveDataSubscriptionId() : -1;
        if (activeDataSubscriptionId == -1 && i11 >= 24) {
            activeDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        }
        Iterator it = ((List) q.a(this.f66723b.getActiveSubscriptionInfoList(), Collections.emptyList())).iterator();
        int size2 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubscriptionInfo subscriptionInfoA = f1.a(it.next());
            boolean z11 = activeDataSubscriptionId != -1 && activeDataSubscriptionId == subscriptionInfoA.getSubscriptionId();
            if (z11) {
                size2 = arrayList.size();
            }
            arrayList.add(b(telephonyManagerM, subscriptionInfoA, z11, context));
        }
        if (size2 == -1 && activeDataSubscriptionId != -1) {
            try {
                arrayList.add(b(telephonyManagerM, this.f66723b.getActiveSubscriptionInfo(activeDataSubscriptionId), true, context));
                size = arrayList.size();
                size2 = size - 1;
            } catch (Throwable unused) {
            }
        } else if (size2 == -1 && Build.VERSION.SDK_INT < 24) {
            size = arrayList.size();
            size2 = size - 1;
        }
        abstractC0700a.k(arrayList).c(size2);
        return false;
    }
}
