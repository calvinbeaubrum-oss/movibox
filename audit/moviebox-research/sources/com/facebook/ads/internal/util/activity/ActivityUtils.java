package com.facebook.ads.internal.util.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.facebook.ads.redexgen.uinode.AbstractC1432Ki;
import com.facebook.ads.redexgen.uinode.C1384Ih;
import com.facebook.ads.redexgen.uinode.C1437Kp;
import com.facebook.ads.redexgen.uinode.C1794Ym;
import com.facebook.ads.redexgen.uinode.C1795Yn;
import com.facebook.ads.redexgen.uinode.C8A;
import com.facebook.ads.redexgen.uinode.C8B;
import com.facebook.ads.redexgen.uinode.ExecutorC1456Li;
import com.facebook.ads.redexgen.uinode.InterfaceC1435Kl;
import com.facebook.ads.redexgen.uinode.RunnableC1434Kk;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ActivityUtils implements Application.ActivityLifecycleCallbacks {
    public static Context A01;
    public static C1794Ym A02;
    public static byte[] A03;
    public static String[] A04 = {"ouMPsLdF8VOzsynXqmRiTnVq9sCULlEK", "RDluICFSUJyOT3sC2lXOFgStPQc7gg7Y", "UmtUlnThENixw5hdz8sG1KFdsGmJDk97", "fTn296Ch3TXxkAVBDyGQxp9TrJ", "IUqXVRs0X8uhoFuXuWrDHC", "AqSoSQ8lTXl56yd6tw1FPxb5AEpw6", "5ylHfIThOZnGyEtaFkstDkkPbeVs18fd", "i0x"};
    public static final C1437Kp A05;
    public static final List<InterfaceC1435Kl> A06;
    public static final List<Runnable> A07;
    public static final Map<Activity, Integer> A08;
    public final Class<? extends Activity> A00;

    static {
        A02();
        A08 = Collections.synchronizedMap(new WeakHashMap());
        A06 = Collections.synchronizedList(new ArrayList());
        A07 = new ArrayList();
        A05 = C1437Kp.A00();
    }

    public ActivityUtils(Class<? extends Activity> cls) {
        this.A00 = cls;
    }

    public static synchronized Activity A00() {
        Activity key = null;
        for (Map.Entry<Activity, Integer> entry : A08.entrySet()) {
            if (entry.getValue().intValue() == 3) {
                key = entry.getKey();
                break;
            }
        }
        boolean z11 = key == null || Build.VERSION.SDK_INT < 28;
        Activity activityA00 = z11 ? AbstractC1432Ki.A00() : null;
        if (A02 != null && z11 && key != activityA00) {
            C8B c8b = new C8B(A01(19, 23, 62), A01(203, 5, 20) + key + A01(12, 7, 124) + activityA00);
            c8b.A05(1);
            A02.A07().A9a(A01(208, 8, 114), C8A.A03, c8b);
        }
        return key != null ? key : activityA00;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A04;
            if (strArr[4].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "4AKSMNDzmxTAf23dNNcZP8";
            strArr2[7] = "cH1";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 12);
            i14++;
        }
    }

    public static void A02() {
        A03 = new byte[]{54, 58, 91, 121, 110, 115, 108, 115, 110, 99, 32, 58, 92, 80, 2, Ascii.NAK, Ascii.SYN, 74, 80, 115, 81, 70, 91, 68, 91, 70, 75, Ascii.DC2, 86, 91, 65, 81, 64, 87, 66, 83, 92, 81, 91, 87, 65, Ascii.FS, 55, 6, 6, 53, Ascii.EM, Ascii.CAN, 2, 19, Ascii.SO, 2, 86, Ascii.US, 5, 86, Ascii.CAN, Ascii.EM, 2, 86, 55, 6, 6, Ascii.SUB, Ascii.US, Ascii.NAK, Ascii.ETB, 2, Ascii.US, Ascii.EM, Ascii.CAN, 88, 40, 4, 5, 8, Ascii.RS, Ascii.EM, Ascii.EM, Ascii.SO, 5, Ascii.US, 75, 6, 4, Ascii.SI, 2, Ascii.CR, 2, 8, 10, Ascii.US, 2, 4, 5, 75, Ascii.SO, 19, 8, Ascii.SO, Ascii.ESC, Ascii.US, 2, 4, 5, 75, Ascii.US, 3, Ascii.EM, 4, Ascii.FS, 5, Ascii.SI, Ascii.RS, Ascii.EM, 2, 5, Ascii.FF, 75, Ascii.EM, Ascii.SO, Ascii.FF, 2, Ascii.CAN, Ascii.US, Ascii.SO, Ascii.EM, 42, 8, Ascii.US, 2, Ascii.GS, 2, Ascii.US, Ascii.DC2, 40, 10, 7, 7, 9, 10, 8, 0, Ascii.CAN, 39, 2, Ascii.CAN, Ascii.US, Ascii.SO, 5, Ascii.SO, Ascii.EM, 10, 41, 33, 101, 36, 38, 49, 44, 51, 44, 49, 60, 101, 54, 49, 36, 49, 32, Ascii.DEL, 101, 115, 66, 86, 80, 70, 71, 3, 66, 64, 87, 74, 85, 74, 87, 90, 3, 74, 80, 3, 77, 76, 87, 3, 81, 70, 80, 86, 78, 70, 71, Ascii.CR, 74, 125, 107, 34, 56, Ascii.US, Ascii.GS, 10, 33, Ascii.VT, 10, Ascii.ETB, Ascii.DC2, 4, Ascii.NAK, Ascii.FF, 81, 80, Ascii.DEL, 93, 74, 87, 72, 87, 74, 71, 125, 76, 91, 95, 74, 91, 90};
    }

    public static void A03(C1795Yn c1795Yn) {
        if (C1384Ih.A1N(c1795Yn) && Build.VERSION.SDK_INT < 29) {
            RunnableC1434Kk runnableC1434Kk = new RunnableC1434Kk(c1795Yn);
            List<Runnable> list = A07;
            synchronized (list) {
                list.add(runnableC1434Kk);
            }
            ExecutorC1456Li.A01.A01().postDelayed(runnableC1434Kk, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }

    public static synchronized void A04(C1794Ym c1794Ym, Class<? extends Activity> cls) {
        A02 = c1794Ym;
        Context applicationContext = c1794Ym.getApplicationContext();
        A01 = applicationContext;
        if (applicationContext instanceof Application) {
            ANActivityLifecycleCallbacksListener aNActivityLifecycleCallbacksListener = ANActivityLifecycleCallbacksListener.getANActivityLifecycleCallbacksListener();
            if (aNActivityLifecycleCallbacksListener != null) {
                Map<Activity, Integer> activityStateMap = aNActivityLifecycleCallbacksListener.getActivityStateMap();
                synchronized (activityStateMap) {
                    try {
                        A08.putAll(activityStateMap);
                    } catch (ConcurrentModificationException unused) {
                        c1794Ym.A07().A9a(A01(208, 8, 114), C8A.A02, new C8B(A01(72, 80, Worker.WHAT_SYNC_DATA)));
                    }
                }
                ANActivityLifecycleCallbacksListener.unregisterActivityCallbacks(c1794Ym);
            }
            ((Application) A01).registerActivityLifecycleCallbacks(new ActivityUtils(cls));
        } else {
            c1794Ym.A07().A9a(A01(216, 3, 105), C8A.A0d, new C8B(A01(42, 30, 122)));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        A08.put(activity, 1);
        Iterator<InterfaceC1435Kl> it = A06.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A01(219, 17, 50));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        A08.put(activity, 6);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        ArrayList arrayList;
        Map<Activity, Integer> map = A08;
        Integer num = map.get(activity);
        if (num == null || num.intValue() != 3) {
            C8B c8b = new C8B(A01(172, 31, 47), A01(152, 20, 73) + num + A01(0, 12, 22) + activity);
            c8b.A05(0);
            A02.A07().A9a(A01(208, 8, 114), C8A.A03, c8b);
        }
        map.put(activity, 4);
        if (activity.getClass() != this.A00) {
            List<Runnable> list = A07;
            synchronized (list) {
                arrayList = new ArrayList(list);
                list.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ExecutorC1456Li.A01.A01().removeCallbacks((Runnable) it.next());
            }
        }
        A05.A01();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        A08.put(activity, 3);
        A05.A02();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        A08.put(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        A08.put(activity, 5);
    }
}
