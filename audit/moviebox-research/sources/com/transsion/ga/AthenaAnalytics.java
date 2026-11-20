package com.transsion.ga;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.util.Log;
import athena.a0;
import athena.i0;
import athena.j0;
import athena.t0;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.transsion.athena.aidl.AthenaTrackService;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AthenaAnalytics {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile AthenaAnalytics f51924g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static List<Integer> f51930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static com.transsion.ga.a f51931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f51932o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public athena.l f51933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public athena.a f51934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<TrackDataWrapper> f51936d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static f f51922e = new f() { // from class: com.transsion.ga.i
        @Override // com.transsion.ga.AthenaAnalytics.f
        public final String a(String str) {
            return AthenaAnalytics.d(str);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f51923f = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f51925h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile int f51926i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile long f51927j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f51928k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Context f51929l = null;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f51937a;

        public a(boolean z11) {
            this.f51937a = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            ws.a.e(this.f51937a);
            a0.f13598a.m().r(this.f51937a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            AthenaAnalytics.g(AthenaAnalytics.f51924g);
            if (AthenaAnalytics.f51927j > 0) {
                AthenaAnalytics.n(AthenaAnalytics.f51924g);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f51938a;

        private c(Handler handler) {
            this.f51938a = handler;
        }

        public /* synthetic */ c(Handler handler, a aVar) {
            this(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (br.g.H()) {
                j0.e("Athena is in Test mode，should not release this APK（测试模式）[" + AthenaAnalytics.f51929l.getPackageName() + "]");
                this.f51938a.postDelayed(this, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                return;
            }
            if (br.g.F() && br.g.D()) {
                j0.e("  - Athena is in Release mode with log enabled. Please set AthenaAnalytics.setDebug(false) to release this APK （Debug模式）[" + AthenaAnalytics.f51929l.getPackageName() + "]");
                this.f51938a.postDelayed(this, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f51939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SimpleDateFormat f51940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f51941c;

        private d(Handler handler) {
            this.f51941c = "";
            this.f51939a = handler;
        }

        public /* synthetic */ d(Handler handler, a aVar) {
            this(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AthenaAnalytics.f51927j > 0) {
                if (j0.f13695c) {
                    if (this.f51940b == null) {
                        this.f51940b = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
                    }
                    String str = this.f51940b.format(new Date());
                    if (!str.equals(this.f51941c)) {
                        for (Integer num : cr.b.a()) {
                            if (num.intValue() != 9999) {
                                AthenaAnalytics.z(num.intValue()).Q("app_heartbeat", null, num.intValue());
                            }
                        }
                        this.f51941c = str;
                    }
                }
                this.f51939a.postDelayed(this, 3600000L);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public interface e {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public interface f {
        String a(String str);
    }

    /* JADX INFO: compiled from: source.java */
    public interface g {
        void a(String str, String str2);
    }

    public static AthenaAnalytics A(long j11) {
        if (f51924g == null) {
            synchronized (AthenaAnalytics.class) {
                try {
                    if (f51924g == null) {
                        f51924g = new AthenaAnalytics();
                        if (f51926i == 0) {
                            f51924g.s();
                            Handler handler = new Handler(Looper.getMainLooper());
                            a aVar = null;
                            handler.postDelayed(new c(handler, aVar), 3000L);
                            handler.postDelayed(new b(), 6000L);
                            handler.postDelayed(new d(handler, aVar), 3600000L);
                        } else {
                            AthenaAnalytics athenaAnalytics = f51924g;
                            Context context = f51929l;
                            athenaAnalytics.getClass();
                            try {
                                a0.e("AthenaAnalytics bindTrackService");
                                Intent intent = new Intent(context, (Class<?>) AthenaTrackService.class);
                                intent.setPackage(context.getApplicationInfo().packageName);
                                context.bindService(intent, new j(athenaAnalytics), 1);
                            } catch (Exception e11) {
                                a0.c(Log.getStackTraceString(e11));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (j0.l(j11)) {
            int i11 = (int) j11;
            if (f51926i == 0 && cr.b.b(i11)) {
                Message message = new Message();
                message.what = LogSeverity.WARNING_VALUE;
                message.arg1 = i11;
                f51924g.s().d(message, 0L);
            } else if (f51926i == 1 && cr.b.b(i11)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("multi process appid ");
                sb2.append(i11);
                sb2.append(" register successful");
            }
        }
        return f51924g;
    }

    public static t0 B() {
        return null;
    }

    public static f C() {
        return f51922e;
    }

    public static void D() {
        if (f51926i != 0 || f51924g == null || f51924g.s() == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = LogSeverity.CRITICAL_VALUE;
        f51924g.s().d(messageObtain, 100L);
    }

    @Deprecated
    public static void E(Context context, String str, int i11, boolean z11) {
        F(context, str, i11, z11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void F(Context context, String str, int i11, boolean z11, boolean z12) {
        boolean zEquals;
        if (context == null || i11 < 1000 || i11 > 9999) {
            throw new IllegalArgumentException("The parameter is illegal.");
        }
        if (f51929l == null) {
            f51929l = context.getApplicationContext();
        }
        ws.a.b(f51929l);
        ws.a.e(z11);
        br.g.l(z11);
        br.g.e(str, z12);
        if (z12) {
            cr.b.e(i11);
            f(i11, false);
        }
        l.b(f51929l);
        if (f51926i == -1) {
            String str2 = f51928k;
            try {
                String str3 = context.getApplicationContext().getApplicationInfo().processName;
                if (str2 == null || str2.length() <= 0) {
                    str2 = str3;
                }
                zEquals = str2 != null ? str2.equals(com.transsion.ga.g.f(context)) : 1;
            } catch (Exception e11) {
                a0.c(e11.getMessage());
            }
            f51926i = !zEquals;
            if (f51926i == 0) {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    int i12 = k.f51967b;
                    intentFilter.addAction("com.transsion.athena.track_event");
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    intentFilter.addAction("android.location.PROVIDERS_CHANGED");
                    if (Build.VERSION.SDK_INT >= 33) {
                        context.registerReceiver(new k(), intentFilter, 4);
                    } else {
                        context.registerReceiver(new k(), intentFilter);
                    }
                } catch (Exception e12) {
                    a0.c(Log.getStackTraceString(e12));
                }
                if (f51932o == 0 && br.g.H) {
                    f51932o = new Random().nextInt(PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY) + LogSeverity.NOTICE_VALUE;
                }
            }
        }
        z(9999);
        z(i11);
        i0.c(context, i11, f51932o);
    }

    public static boolean G() {
        if (Build.VERSION.SDK_INT >= 29) {
            return br.g.G && r();
        }
        return br.g.D && q();
    }

    public static boolean H() {
        return f51923f == 3;
    }

    public static boolean I() {
        if (Build.VERSION.SDK_INT >= 29) {
            return br.g.E && r();
        }
        return br.g.B && q();
    }

    public static boolean J() {
        if (Build.VERSION.SDK_INT >= 29) {
            return br.g.F && r();
        }
        return br.g.C && q();
    }

    public static void K(short s11, String str) {
        br.g.f(s11, str);
    }

    public static void L(boolean z11) {
        br.g.l(z11);
        if (f51926i == 0) {
            if (f51924g == null) {
                a0.a("Init method not called.");
                return;
            }
            athena.l lVarS = f51924g.s();
            if (lVarS != null) {
                lVarS.e(new a(z11));
            }
        }
    }

    public static void M(int i11) {
        athena.l lVarS;
        if (f51926i != 0 || (lVarS = f51924g.s()) == null) {
            return;
        }
        lVarS.c(i11);
    }

    public static void N(boolean z11) {
        br.g.q(z11);
    }

    public static void O(int i11) {
        f51923f = i11;
    }

    public static void P() {
        if (f51924g != null) {
            AthenaAnalytics athenaAnalytics = f51924g;
            athenaAnalytics.getClass();
            if ((f51923f == 3 || v()) && f51926i == 0 && athenaAnalytics.s() != null) {
                athenaAnalytics.s().h();
            }
        }
    }

    public static /* synthetic */ String d(String str) {
        return str;
    }

    public static void f(long j11, boolean z11) {
        if (f51929l == null) {
            return;
        }
        if (f51927j == 0 || z11) {
            f51927j = j11;
        }
        com.transsion.ga.a aVar = f51931n;
        if (aVar != null) {
            aVar.d(f51927j);
            return;
        }
        com.transsion.ga.a aVar2 = new com.transsion.ga.a();
        f51931n = aVar2;
        aVar2.d(f51927j);
        ((Application) f51929l).registerActivityLifecycleCallbacks(f51931n);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ee A[Catch: Exception -> 0x010e, TryCatch #1 {Exception -> 0x010e, blocks: (B:47:0x00cc, B:49:0x00de, B:51:0x00e4, B:52:0x00e8, B:54:0x00ee, B:56:0x00fc, B:58:0x0102, B:61:0x0110, B:63:0x0116, B:65:0x011c), top: B:72:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void g(AthenaAnalytics athenaAnalytics) throws Throwable {
        FileInputStream fileInputStream;
        String string;
        String strA;
        List activeSubscriptionInfoList;
        Iterator it;
        SubscriptionInfo subscriptionInfoA;
        athenaAnalytics.getClass();
        if (!v()) {
            a0.a("Athena SDK isAthenaEnable = false");
            return;
        }
        TrackData trackData = new TrackData();
        if (I()) {
            trackData.add("iid", com.transsion.ga.g.b(0)).add("iid2", com.transsion.ga.g.b(1));
        }
        if (J()) {
            trackData.add("isd", com.transsion.ga.g.e(1)).add("isd2", com.transsion.ga.g.e(2));
        }
        if (G()) {
            trackData.add("aid", com.transsion.ga.g.a());
        }
        StringBuilder sb2 = new StringBuilder();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File("proc/rid"));
            try {
                byte[] bArr = new byte[1];
                while (fileInputStream.read(bArr) != -1) {
                    sb2.append(br.d.e(bArr));
                }
            } catch (Exception unused) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream = fileInputStream2;
                }
                string = sb2.toString();
                if (TextUtils.isEmpty(string)) {
                    strA = "";
                } else {
                    strA = com.transsion.core.utils.c.a(string);
                }
                trackData.add("chip", strA).add("sn", com.transsion.ga.g.j());
                if (Build.VERSION.SDK_INT >= 22) {
                    try {
                        activeSubscriptionInfoList = com.transsion.ga.b.a(f51929l.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                        if (activeSubscriptionInfoList != null) {
                            it = activeSubscriptionInfoList.iterator();
                            while (it.hasNext()) {
                                subscriptionInfoA = com.transsion.ga.d.a(it.next());
                                if (subscriptionInfoA.getSimSlotIndex() != 0) {
                                }
                                if (subscriptionInfoA.getSimSlotIndex() != 1) {
                                }
                            }
                        }
                    } catch (Exception e11) {
                        a0.c(e11.getMessage());
                    }
                }
                z(9999).Q("device", trackData, 9999);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e12) {
                        a0.c(e12.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            fileInputStream.close();
        } catch (Exception e13) {
            a0.c(e13.getMessage());
        }
        string = sb2.toString();
        if (TextUtils.isEmpty(string)) {
            strA = "";
        } else {
            strA = com.transsion.core.utils.c.a(string);
        }
        trackData.add("chip", strA).add("sn", com.transsion.ga.g.j());
        if (Build.VERSION.SDK_INT >= 22) {
            activeSubscriptionInfoList = com.transsion.ga.b.a(f51929l.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList != null && activeSubscriptionInfoList.size() > 0) {
                it = activeSubscriptionInfoList.iterator();
                while (it.hasNext()) {
                    subscriptionInfoA = com.transsion.ga.d.a(it.next());
                    if (subscriptionInfoA.getSimSlotIndex() != 0 && J()) {
                        trackData.add("isd", com.transsion.ga.g.e(subscriptionInfoA.getSubscriptionId()));
                    } else if (subscriptionInfoA.getSimSlotIndex() != 1 && J()) {
                        trackData.add("isd2", com.transsion.ga.g.e(subscriptionInfoA.getSubscriptionId()));
                    }
                }
            }
        }
        z(9999).Q("device", trackData, 9999);
    }

    public static boolean k(Class<?> cls) {
        List<Integer> list;
        return (cls == null || (list = f51930m) == null || !list.contains(Integer.valueOf(cls.hashCode()))) ? false : true;
    }

    public static void l(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        br.g.n(str, obj);
    }

    public static void n(AthenaAnalytics athenaAnalytics) {
        athenaAnalytics.getClass();
        if (!v()) {
            a0.a("Athena SDK isAthenaEnable = false");
            return;
        }
        for (Integer num : cr.b.a()) {
            if (num.intValue() != 9999) {
                athenaAnalytics.Q("app_launch", null, num.intValue());
            }
        }
    }

    public static boolean q() {
        return f51929l.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean r() {
        return f51929l.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") == 0;
    }

    public static void t(boolean z11) {
        athena.l lVarS;
        br.g.o(z11);
        if (f51924g == null) {
            a0.a("Init method not called.");
        } else {
            if (f51926i != 0 || (lVarS = f51924g.s()) == null || z11) {
                return;
            }
            lVarS.b();
        }
    }

    public static void u() {
        if (f51924g != null) {
            AthenaAnalytics athenaAnalytics = f51924g;
            athenaAnalytics.getClass();
            if ((f51923f == 3 || v()) && f51926i == 0 && athenaAnalytics.s() != null) {
                athenaAnalytics.s().g();
            }
        }
    }

    public static boolean v() {
        return (f51929l == null || f51924g == null || !br.g.E()) ? false : true;
    }

    public static String w(Context context) {
        return i0.a();
    }

    public static String x(Context context, boolean z11) {
        return z11 ? i0.d(context) : i0.a();
    }

    public static e y() {
        return null;
    }

    public static AthenaAnalytics z(int i11) {
        return A(i11);
    }

    public void Q(String str, TrackData trackData, int i11) {
        R(str, trackData, i11);
    }

    public void R(String str, TrackData trackData, long j11) {
        String str2 = j0.f13693a;
        int length = String.valueOf(j11).length();
        if ((length != 8 && length != 12 && length != 4) || TextUtils.isEmpty(str)) {
            a0.a("The parameter tid : " + j11 + " or event name : " + str + " is illegal.");
            return;
        }
        if (!cr.b.c(j11)) {
            a0.a("The tid " + j11 + " is not belong the app");
            return;
        }
        try {
            if (trackData != null) {
                i(str, trackData, j11);
            } else {
                i(str, new TrackData(), j11);
            }
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public void e(int i11, long j11) {
        if (v() && f51926i == 0 && s() != null) {
            Message message = new Message();
            message.what = i11;
            s().d(message, j11);
        }
    }

    public final void i(String str, TrackData trackData, long j11) {
        if (f51926i == 0 || f51923f == 2) {
            s().f(str, trackData, j11);
            return;
        }
        if (f51929l != null) {
            String str2 = br.g.f14348a;
            try {
                if (!TextUtils.isEmpty("")) {
                    trackData.a().put("scode", "");
                }
                o(str, trackData, j11);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void o(String str, TrackData trackData, long j11) {
        try {
            if (this.f51934b == null || !this.f51935c) {
                if (this.f51936d.size() < 100) {
                    this.f51936d.add(new TrackDataWrapper(str, trackData, j11));
                }
            } else if (trackData.b() < 524288) {
                a0.a(String.format(Locale.getDefault(), "TrackByAidl tid : %d, eventName : %s", Long.valueOf(j11), str));
                this.f51934b.V(str, trackData, j11);
            } else {
                a0.c("TrackByAidl trackData size is too large, ignored !!");
            }
        } catch (RemoteException e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public final athena.l s() {
        if (this.f51933a == null && f51929l != null) {
            if (f51923f == 2 && !j0.t(f51929l)) {
                f51923f = 1;
            }
            this.f51933a = athena.l.a(f51929l, f51923f);
        }
        return this.f51933a;
    }
}
