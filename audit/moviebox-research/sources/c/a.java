package c;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import com.hisavana.common.constant.ComConstants;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import d.f;
import d.m;
import d.n;
import d.t;
import d.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class C0151a implements d.a.b {
        @Override // d.a.b
        public void a(PushMessage pushMessage, HashMap<String, Bitmap> map) {
            a.j(pushMessage, map);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b implements Comparator<StatusBarNotification> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(StatusBarNotification statusBarNotification, StatusBarNotification statusBarNotification2) {
            return (int) (statusBarNotification2.getPostTime() - statusBarNotification.getPostTime());
        }
    }

    public static List<StatusBarNotification> a(String str, NotificationManager notificationManager) {
        Bundle bundle;
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && (bundle = notification.extras) != null && bundle.getBoolean(PushConstants.EXTRA_PUSH_FROM_TPUSH_NOTI) && ((notification.getGroup() == null && TextUtils.isEmpty(str)) || (notification.getGroup() != null && notification.getGroup().equals(str)))) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    public static void b(Intent intent) {
        if (intent == null) {
        }
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_PUSH_SERVICE_TYPE);
        PushLogUtils.LOG.g("PushJobIntentService ---> onHandleWork, type:" + stringExtra);
        if (stringExtra == null) {
            return;
        }
        switch (stringExtra) {
            case "sync_config":
                i(intent);
                break;
            case "init":
                break;
            case "token":
                m(intent);
                break;
            case "force_update":
                h();
                break;
            case "message":
                l(intent);
                break;
            default:
                PushLogUtils.LOG.z("service type error");
                break;
        }
    }

    public static synchronized void c(PushMessage pushMessage) {
        try {
            try {
                if (TextUtils.isEmpty(pushMessage.packageName)) {
                    pushMessage.packageName = com.transsion.core.utils.a.a();
                }
                if (pushMessage.packageName.equals(com.transsion.core.utils.a.a())) {
                    if (PushManager.getInstance().getPushListener() != null) {
                        PushManager.getInstance().getPushListener().onMessageReceive(pushMessage.messageId, pushMessage.transData, pushMessage.priority);
                    } else {
                        Log.e(PushLogUtils.TAG, "tpush listener is not registered");
                    }
                }
            } catch (Exception e11) {
                PushLogUtils.LOG.i("transmitMessage---> e:" + e11.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void d(PushMessage pushMessage, NotificationManager notificationManager) {
        int i11;
        List<StatusBarNotification> listA;
        if (pushMessage == null || notificationManager == null) {
            return;
        }
        try {
            i11 = Integer.parseInt(pushMessage.groupMaxCount);
        } catch (Exception unused) {
            i11 = 0;
        }
        if (i11 <= 0 || Build.VERSION.SDK_INT < 23 || (listA = a(pushMessage.groupId, notificationManager)) == null || listA.size() < i11) {
            return;
        }
        int size = listA.size() - i11;
        f(listA);
        for (int i12 = 0; i12 <= size; i12++) {
            try {
                notificationManager.cancel(listA.get((listA.size() - 1) - i12).getId());
            } catch (Exception e11) {
                PushLogUtils.LOG.i("handle max limit message fail, e:" + e11.getMessage());
            }
        }
    }

    public static void f(List<StatusBarNotification> list) {
        Collections.sort(list, new b());
    }

    public static boolean g() {
        return ws.a.a() != null && Settings.Global.getInt(ws.a.a().getContentResolver(), "auto_time", 0) == 1;
    }

    public static void h() {
        try {
            if (PushRepository.getInstance().isReported()) {
                return;
            }
            PushRepository.getInstance().syncActive();
            PushLogUtils.LOG.g(" active reporting");
        } catch (Exception e11) {
            PushLogUtils.LOG.i("handle sync active exception,e:" + e11.getMessage());
        }
    }

    public static void i(Intent intent) {
        if (intent == null) {
            return;
        }
        k();
    }

    public static void j(PushMessage pushMessage, HashMap<String, Bitmap> map) {
        PushLogUtils.LOG.g("display messages，message：" + pushMessage);
        if (pushMessage == null) {
            return;
        }
        try {
            t.f(pushMessage, map);
        } catch (Exception e11) {
            PushLogUtils.LOG.i("Notification show exception:" + e11.getMessage());
        }
    }

    public static void k() {
        PushLogUtils.LOG.g("onHandleSyncActive");
        if (x.s()) {
            PushLogUtils.LOG.g("onHandleSyncActive force update");
            h();
            return;
        }
        try {
            if (x.v()) {
                PushLogUtils.LOG.g("tpms sync");
                if (m.b(ws.a.a())) {
                    m.c(ws.a.a());
                    PushRepository.getInstance().saveTpmsReportTime(System.currentTimeMillis() + ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED);
                }
            }
            if (!x.u() || m.b(ws.a.a())) {
                return;
            }
            PushRepository.getInstance().syncActive();
        } catch (Exception e11) {
            PushLogUtils.LOG.i("handle sync active exception,e:" + e11.getMessage());
        }
    }

    public static void l(Intent intent) {
        PushLogUtils.LOG.g("onHandleTargetMessage--->");
        if (intent == null) {
            PushLogUtils.LOG.g("onHandleTargetMessage---> intent is null");
            return;
        }
        PushMessage pushMessageC = x.c(intent);
        if (pushMessageC == null) {
            PushLogUtils.LOG.g("onHandleTargetMessage---> message is null");
            return;
        }
        if (n.h()) {
            PushLogUtils.LOG.z("push self-destroying");
            return;
        }
        if (!x.j(pushMessageC, 1)) {
            PushLogUtils.LOG.g("onHandleTargetMessage---> checkMessage return ");
            return;
        }
        if (x.i(pushMessageC)) {
            PushLogUtils.LOG.g("onHandleTargetMessage---> retraceMessage return, retrace msgId:" + pushMessageC.retraceMsgId);
            return;
        }
        Tracker.getInstance().trackTarget(pushMessageC.messageId, pushMessageC.type, pushMessageC.timeStamp, pushMessageC.rpkg, "success");
        x.r(pushMessageC.messageId);
        PushLogUtils.LOG.g("onHandleTargetMessage---> type:" + pushMessageC.type);
        int i11 = pushMessageC.type;
        if (i11 != 1) {
            if (i11 == 2) {
                c(pushMessageC);
                return;
            } else if (i11 != 5 && i11 != 6) {
                if (i11 != 7) {
                    PushLogUtils.LOG.z("Display message, message type is not supported");
                    return;
                }
                return;
            }
        }
        if (pushMessageC.sdkShow == 0) {
            PushLogUtils.LOG.g("sdkShow no show");
            if (PushManager.getInstance().getPushListener() != null) {
                PushManager.getInstance().getPushListener().onPushReceive(pushMessageC.messageId, pushMessageC, pushMessageC.priority);
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            PushLogUtils.LOG.g("message ignoreExpire? " + pushMessageC.ignoreExpire);
            PushLogUtils.LOG.g("isTimeAutomatic: " + g());
            PushLogUtils.LOG.g("message schedule time: " + pushMessageC.getTimeStamp());
            PushLogUtils.LOG.g("message delay: " + (jCurrentTimeMillis - Long.parseLong(pushMessageC.getTimeStamp())));
            PushLogUtils.LOG.g("message ttl: " + (((long) pushMessageC.getMsgTtl()) * 1000));
            if (pushMessageC.ignoreExpire == 0) {
                PushLogUtils.LOG.g("message expiration check");
                if (g() && jCurrentTimeMillis - Long.parseLong(pushMessageC.getTimeStamp()) > ((long) pushMessageC.getMsgTtl()) * 1000) {
                    PushLogUtils.LOG.g("message expired, no show");
                    Tracker.getInstance().trackShow(pushMessageC.messageId, pushMessageC.type, pushMessageC.timeStamp, true, 999);
                    return;
                }
            }
        } catch (Exception unused) {
        }
        if (!PushManager.getInstance().getNotificationSwitch()) {
            PushLogUtils.LOG.g("notification switch is off, do not show noti");
        } else if (d.a.b(pushMessageC)) {
            d.a.a(pushMessageC, new C0151a());
        } else {
            j(pushMessageC, null);
        }
    }

    public static void m(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_TOKEN);
        if (TextUtils.isEmpty(stringExtra)) {
            PushLogUtils.LOG.z("Initialize token to empty");
            return;
        }
        try {
            if (ws.a.a() == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Initialize push_token， packageName:");
            sb2.append(f.h());
            sb2.append(", token：");
            sb2.append(stringExtra);
            if (stringExtra.equals((String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, "")) && !TextUtils.isEmpty((CharSequence) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
                PushLogUtils.LOG.g("token does not need to report without modification");
                x.y();
                com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).o(PushConstants.SP_KEY_UPDATE_TOKEN_TIME, System.currentTimeMillis());
            } else {
                PushLogUtils.LOG.g("token updated, do network request");
                try {
                    com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).o(PushConstants.SP_KEY_UPDATE_TOKEN_TIME, System.currentTimeMillis());
                } catch (Exception unused) {
                }
                PushRepository.getInstance().updateNewToken(stringExtra);
                h();
                m.b(ws.a.a());
            }
        } catch (Exception unused2) {
        }
    }
}
