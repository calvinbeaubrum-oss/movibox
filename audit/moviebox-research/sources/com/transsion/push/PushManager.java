package com.transsion.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.crypto.TCrypterSdk;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.bean.PushConfig;
import com.transsion.push.bean.PushNotification;
import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.NotificationAssistUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ServiceUtils;
import com.transsion.push.utils.ThreadManager;
import d.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class PushManager {
    public static final int SHOW_STATUS_FAIL_NOTI_CLOSE = 6;
    public static final int SHOW_STATUS_FAIL_PRIORITY = 12;
    public static final int SHOW_STATUS_FAIL_REPEAT = 11;
    public static final int SHOW_STATUS_SUCCESS = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f56812c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f56813d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.a f56814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TPushListener f56815b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class a implements GslbSdk.InitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f56816a;

        public a(Context context) {
            this.f56816a = context;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
            PushLogUtils.LOG.g("gslb sdk init fail");
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            PushLogUtils.LOG.g("gslb sdk init success");
            Bundle bundle = new Bundle();
            bundle.putString(PushConstants.EXTRA_PUSH_SERVICE_TYPE, PushConstants.PUSH_SERVICE_TYPE_FORCE_UPDATE);
            ServiceUtils.startJobThread(this.f56816a.getApplicationContext(), bundle);
            PushLogUtils.LOG.g("gslb success, force update info to server");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f56818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f56819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f56820c;

        public b(String str, String str2, boolean z11) {
            this.f56818a = str;
            this.f56819b = str2;
            this.f56820c = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Tracker.getInstance().init();
            PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_ID, this.f56818a);
            PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_KEY, this.f56819b);
            PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IS_TEST_ENV, Boolean.valueOf(this.f56820c));
            ws.a.e(x.q());
            Tracker.getInstance().trackInit();
            d.e.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements GslbSdk.InitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f56822a;

        public c(Context context) {
            this.f56822a = context;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
            PushLogUtils.LOG.g("gslb sdk init fail");
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            PushLogUtils.LOG.g("gslb sdk init success");
            Bundle bundle = new Bundle();
            bundle.putString(PushConstants.EXTRA_PUSH_SERVICE_TYPE, PushConstants.PUSH_SERVICE_TYPE_FORCE_UPDATE);
            ServiceUtils.startJobThread(this.f56822a.getApplicationContext(), bundle);
            PushLogUtils.LOG.g("gslb success, force update info to server");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Tracker.getInstance().init();
            x.n();
            ws.a.e(x.q());
            Tracker.getInstance().trackInit();
            d.e.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PushConfig f56825a;

        public e(PushConfig pushConfig) {
            this.f56825a = pushConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.f(this.f56825a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PushRepository.getInstance().syncActive();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PushManager f56828a = new PushManager(null);
    }

    public PushManager() {
    }

    public /* synthetic */ PushManager(a aVar) {
        this();
    }

    public static PushManager getInstance() {
        return g.f56828a;
    }

    public final boolean a() {
        return true;
    }

    public void addCustomNotification(PushNotification pushNotification) {
        if (a()) {
            d.d.c(pushNotification);
        }
    }

    public final void b() {
        if (a()) {
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            if (this.f56814a == null) {
                this.f56814a = new a.a();
            }
            try {
                ws.a.a().registerReceiver(this.f56814a, intentFilter);
            } catch (Exception e11) {
                PushLogUtils.LOG.i("registerReceiver fail, e:" + e11.getMessage());
            }
        }
    }

    public void getClientId(IClientIdListener iClientIdListener) {
        if (a()) {
            PushRepository.getInstance().getClientId(iClientIdListener);
        }
    }

    public boolean getDebug() {
        if (a()) {
            return x.q();
        }
        return false;
    }

    public boolean getIsSdkInitFinished() {
        return f56813d;
    }

    public boolean getNotificationSwitch() {
        if (!a()) {
            return false;
        }
        try {
            return com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).c(PushConstants.SP_KEY_PUSH_SWITCH, true);
        } catch (Exception unused) {
            return false;
        }
    }

    public TPushListener getPushListener() {
        return this.f56815b;
    }

    public boolean getTestEnv() {
        if (a()) {
            return x.w();
        }
        return false;
    }

    public String getToken(Context context) {
        if (a()) {
            return (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, "");
        }
        return null;
    }

    public void init(Context context) {
        if (a()) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                ws.a.b(context.getApplicationContext());
                if (f56812c.get()) {
                    return;
                }
                GslbSdk.init(context, new String[]{PushConstants.BASE_RELEASE_URL_V2}, new c(context));
                f56812c.set(true);
                TCrypterSdk.b(context.getApplicationContext());
                ThreadManager.executeInBackground(new d());
                b();
                f56813d = true;
                PushLogUtils.LOG.i("sdk init time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Exception e11) {
                PushLogUtils.LOG.i("init fail, e:" + e11.getMessage());
                f56813d = false;
            }
        }
    }

    public void init(Context context, String str, String str2, boolean z11) {
        if (a()) {
            try {
                ws.a.b(context.getApplicationContext());
                if (f56812c.get()) {
                    return;
                }
                GslbSdk.init(context, new String[]{PushConstants.BASE_RELEASE_URL_V2}, new a(context));
                f56812c.set(true);
                long jCurrentTimeMillis = System.currentTimeMillis();
                TCrypterSdk.b(context.getApplicationContext());
                ThreadManager.executeInBackground(new b(str, str2, z11));
                b();
                f56813d = true;
                PushLogUtils.LOG.i("sdk init time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Exception e11) {
                PushLogUtils.LOG.i("init fail, e:" + e11.getMessage());
                f56813d = false;
            }
        }
    }

    public void registerPushListener(TPushListener tPushListener) {
        this.f56815b = tPushListener;
    }

    @Deprecated
    public void registerReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (a()) {
            try {
                PushLogUtils.LOG.g("registerReceiver --> ");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PushConstants.ACTION_PUSH_RECEIVER);
                intentFilter.addAction(PushConstants.ACTION_PUSH_INIT_COMPLETE);
                context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    public void setAppInfo(String str, String str2) {
        if (a()) {
            String strD = x.d();
            String strL = x.l();
            try {
                if (strD.equalsIgnoreCase(str) && strL.equalsIgnoreCase(str2)) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_ID, str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_KEY, str2);
                }
                ThreadManager.executeInBackground(new f());
            } catch (Exception unused) {
            }
        }
    }

    public void setNotificationSwitch(boolean z11) {
        if (a()) {
            try {
                com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).l(PushConstants.SP_KEY_PUSH_SWITCH, z11);
            } catch (Exception unused) {
            }
        }
    }

    public void setPushConfig(PushConfig pushConfig) {
        if (a()) {
            ThreadManager.executeInBackground(new e(pushConfig));
        }
    }

    public void subscribeToTopic(String str, ITopicListener iTopicListener) {
        if (a()) {
            PushRepository.getInstance().subscribeToTopic(str, iTopicListener);
        }
    }

    public void trackArrive(long j11) {
        if (a()) {
            try {
                Tracker.getInstance().trackTarget(j11, 2, "", "", "success");
            } catch (Exception unused) {
            }
        }
    }

    public void trackClick(long j11) {
        if (a()) {
            Tracker.getInstance().trackClick(j11);
        }
    }

    public void trackConversion(long j11) {
        if (a()) {
            try {
                Tracker.getInstance().trackConversion(j11);
            } catch (Exception unused) {
            }
        }
    }

    public void trackShow(long j11, int i11) {
        if (a()) {
            try {
                Tracker.getInstance().trackShow(j11, 2, String.valueOf(System.currentTimeMillis()), NotificationAssistUtils.isOpenNotification(ws.a.a()), i11);
            } catch (Exception unused) {
            }
        }
    }

    public void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (a()) {
            try {
                context.getApplicationContext().unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
        }
    }

    public void unsubscribeFromTopic(String str, ITopicListener iTopicListener) {
        if (a()) {
            PushRepository.getInstance().unsubscribeFromTopic(str, iTopicListener);
        }
    }

    public void updateToken(String str) {
        if (a()) {
            x.g(str);
        }
    }
}
