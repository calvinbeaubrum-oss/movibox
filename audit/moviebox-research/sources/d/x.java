package d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushConfig;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.NotificationAssistUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ServiceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<ResolveInfo> f62850a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f62851b = new AtomicBoolean(false);

    public static Bitmap a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return b(packageManager, str);
            }
        } catch (Exception e11) {
            PushLogUtils.LOG.g("getApplicationIcon e" + e11);
        }
        PushLogUtils.LOG.g("getApplicationIcon id error");
        return null;
    }

    public static Bitmap b(PackageManager packageManager, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k(packageManager, str);
        }
        try {
            return ((BitmapDrawable) packageManager.getApplicationIcon(str)).getBitmap();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static PushMessage c(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return (PushMessage) com.transsion.json.b.a(intent.getStringExtra("message"), PushMessage.class);
        } catch (Exception unused) {
            PushLogUtils.LOG.i("Notification service message is empty");
            return null;
        }
    }

    public static String d() {
        String string = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_APP_ID, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            string = ws.a.a().getPackageManager().getApplicationInfo(ws.a.a().getPackageName(), 128).metaData.getString(PushConstants.TPUSH_APP_ID);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
        }
        if (!TextUtils.isEmpty(string)) {
            PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_ID, string);
        }
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static String e(Context context, PushMessage pushMessage) {
        if (!TextUtils.isEmpty(pushMessage.appName)) {
            return pushMessage.appName;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(pushMessage.packageName, 0).applicationInfo.loadLabel(packageManager).toString();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return "";
    }

    public static void f(PushConfig pushConfig) {
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_CLOSE_JOB_SERVICE, Boolean.valueOf(pushConfig.isCloseJobService()));
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_CHECK_INTERVAL, Integer.valueOf(Math.min(Math.max(pushConfig.getCheckInterval(), 900), 43200)));
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_MOBILE_UPLOAD_INTERVAL, Integer.valueOf(Math.min(Math.max(pushConfig.getMobileUploadInterval(), 7200), 43200)));
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_UPLOAD_INTERVAL, Integer.valueOf(Math.min(Math.max(pushConfig.getUploadInterval(), 7200), 43200)));
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_GROUP_ID, pushConfig.getGroupId());
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_MAX_NOTIFICATION_COUNT, Integer.valueOf(Math.min(pushConfig.getMaxNotificationCount(), 60)));
    }

    public static void g(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(PushConstants.EXTRA_PUSH_SERVICE_TYPE, "token");
            bundle.putString(PushConstants.EXTRA_TOKEN, str);
            ServiceUtils.startJobThread(ws.a.a(), bundle);
        } catch (Exception unused) {
        }
    }

    public static boolean h(long j11) {
        try {
            String strI = com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).i(PushConstants.SP_KEY_PUSHUI_CLICK_MESSAGE_IDS);
            if (TextUtils.isEmpty(strI)) {
                return false;
            }
            return strI.contains(String.valueOf(j11));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean i(PushMessage pushMessage) {
        int i11 = pushMessage.type;
        if (i11 != 7) {
            if (i11 != 1) {
                return false;
            }
            boolean zO = o(pushMessage.messageId);
            if (zO) {
                Tracker.getInstance().trackShow(pushMessage.messageId, 7, String.valueOf(System.currentTimeMillis()), NotificationAssistUtils.isOpenNotification(ws.a.a()), 0);
            }
            return zO;
        }
        boolean zM = m(pushMessage.retraceMsgId);
        boolean zH = h(pushMessage.retraceMsgId);
        if (zM && !zH) {
            l.e(pushMessage.retraceMsgId);
            try {
                Tracker.getInstance().trackShow(pushMessage.retraceMsgId, 7, String.valueOf(System.currentTimeMillis()), NotificationAssistUtils.isOpenNotification(ws.a.a()), 0);
            } catch (Exception unused) {
            }
        }
        t(pushMessage.retraceMsgId);
        return zM && !zH;
    }

    public static boolean j(PushMessage pushMessage, int i11) {
        if (pushMessage == null) {
            PushLogUtils.LOG.z("Transparent page, empty message");
            return false;
        }
        int i12 = pushMessage.type;
        if (i12 != 1 && i12 != 5 && i12 != 2 && i12 != 6 && i12 != 7) {
            PushLogUtils.LOG.i("Message type is not supported");
            if (i11 == 0) {
                Tracker.getInstance().trackMessage(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, "fail", 4);
            } else {
                Tracker.getInstance().trackTarget(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, pushMessage.rpkg, "fail");
            }
            return false;
        }
        if (!m(pushMessage.messageId)) {
            if (i11 == 1 || z.b(pushMessage.packageName)) {
                return true;
            }
            PushLogUtils.LOG.z("Package Name No longer appMap");
            Tracker.getInstance().trackMessage(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, "fail", 1);
            return false;
        }
        if (i11 == 1 && !TextUtils.isEmpty(pushMessage.packageName) && !pushMessage.packageName.equals(pushMessage.rpkg)) {
            Tracker.getInstance().trackTarget(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, pushMessage.rpkg, "handled");
        }
        PushLogUtils.LOG.g("The message has been handled, msgId:" + pushMessage.messageId + ", rpkg:" + pushMessage.rpkg);
        return false;
    }

    @RequiresApi(api = 26)
    public static Bitmap k(PackageManager packageManager, String str) {
        try {
            Drawable applicationIcon = packageManager.getApplicationIcon(str);
            if (applicationIcon instanceof BitmapDrawable) {
                return ((BitmapDrawable) applicationIcon).getBitmap();
            }
            if (!com.google.firebase.messaging.c.a(applicationIcon)) {
                return null;
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{u.a(applicationIcon).getBackground(), u.a(applicationIcon).getForeground()});
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            layerDrawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String l() {
        String string = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_APP_KEY, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            string = ws.a.a().getPackageManager().getApplicationInfo(ws.a.a().getPackageName(), 128).metaData.getString(PushConstants.TPUSH_APP_KEY);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (!TextUtils.isEmpty(string)) {
            PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_KEY, string);
        }
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static boolean m(long j11) {
        try {
            String strI = com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).i(PushConstants.SP_KEY_PUSHUI_MESSAGE_IDS);
            if (TextUtils.isEmpty(strI)) {
                return false;
            }
            return strI.contains(String.valueOf(j11));
        } catch (Exception unused) {
            return false;
        }
    }

    public static void n() {
        PackageManager.NameNotFoundException nameNotFoundException;
        boolean z11;
        String str;
        boolean z12;
        String string;
        String string2 = "";
        boolean z13 = false;
        try {
            ApplicationInfo applicationInfo = ws.a.a().getPackageManager().getApplicationInfo(ws.a.a().getPackageName(), 128);
            z12 = applicationInfo.metaData.getBoolean(PushConstants.TPUSH_OPEN_DEBUG);
            try {
                string = applicationInfo.metaData.getString(PushConstants.TPUSH_APP_ID);
                try {
                    string2 = applicationInfo.metaData.getString(PushConstants.TPUSH_APP_KEY);
                    z13 = applicationInfo.metaData.getBoolean(PushConstants.TPUSH_TEST_ENV);
                } catch (PackageManager.NameNotFoundException e11) {
                    str = string2;
                    string2 = string;
                    z11 = z12;
                    nameNotFoundException = e11;
                    nameNotFoundException.printStackTrace();
                    z12 = z11;
                    string = string2;
                    string2 = str;
                }
            } catch (PackageManager.NameNotFoundException e12) {
                z11 = z12;
                nameNotFoundException = e12;
                str = "";
                nameNotFoundException.printStackTrace();
                z12 = z11;
                string = string2;
                string2 = str;
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_ID, string);
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_KEY, string2);
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_ISDEBUG, Boolean.valueOf(z12));
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IS_TEST_ENV, Boolean.valueOf(z13));
            }
        } catch (PackageManager.NameNotFoundException e13) {
            nameNotFoundException = e13;
            z11 = false;
        }
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_ID, string);
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_KEY, string2);
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_ISDEBUG, Boolean.valueOf(z12));
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IS_TEST_ENV, Boolean.valueOf(z13));
    }

    public static boolean o(long j11) {
        try {
            String strI = com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).i(PushConstants.SP_KEY_PUSHUI_RETRACE_MESSAGE_IDS);
            if (TextUtils.isEmpty(strI)) {
                return false;
            }
            return strI.contains(String.valueOf(j11));
        } catch (Exception unused) {
            return false;
        }
    }

    public static void p(long j11) {
        try {
            String strI = com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).i(PushConstants.SP_KEY_PUSHUI_CLICK_MESSAGE_IDS);
            if (strI.contains(String.valueOf(j11))) {
                return;
            }
            String strSubstring = strI + " " + j11;
            if (strSubstring.length() > 1024) {
                strSubstring = strSubstring.substring(256);
            }
            com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).p(PushConstants.SP_KEY_PUSHUI_CLICK_MESSAGE_IDS, strSubstring);
        } catch (Exception unused) {
        }
    }

    public static boolean q() {
        return ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_ISDEBUG, Boolean.FALSE)).booleanValue();
    }

    public static void r(long j11) {
        String strI = com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).i(PushConstants.SP_KEY_PUSHUI_MESSAGE_IDS);
        if (strI.contains(String.valueOf(j11))) {
            return;
        }
        String strSubstring = strI + " " + j11;
        if (strSubstring.length() > 1024) {
            strSubstring = strSubstring.substring(256);
        }
        try {
            com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).p(PushConstants.SP_KEY_PUSHUI_MESSAGE_IDS, strSubstring);
        } catch (Exception unused) {
        }
    }

    public static boolean s() {
        return TextUtils.isEmpty((String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "")) || !PushRepository.getInstance().isReported();
    }

    public static void t(long j11) {
        String strI = com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).i(PushConstants.SP_KEY_PUSHUI_RETRACE_MESSAGE_IDS);
        if (strI.contains(String.valueOf(j11))) {
            return;
        }
        String strSubstring = strI + " " + j11;
        if (strSubstring.length() > 1024) {
            strSubstring = strSubstring.substring(256);
        }
        try {
            com.transsion.core.utils.f.e(PushConstants.SP_FILENAME).p(PushConstants.SP_KEY_PUSHUI_RETRACE_MESSAGE_IDS, strSubstring);
        } catch (Exception unused) {
        }
    }

    public static boolean u() {
        long reportTime = PushRepository.getInstance().getReportTime();
        return System.currentTimeMillis() - reportTime > 0 || System.currentTimeMillis() - (reportTime - n.b()) < 0;
    }

    public static boolean v() {
        return System.currentTimeMillis() - PushRepository.getInstance().getLastTpmsReportTime() > 0;
    }

    public static boolean w() {
        return ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_IS_TEST_ENV, Boolean.FALSE)).booleanValue();
    }

    public static boolean x() {
        long jLongValue = ((Long) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_TRACKER_REPORT_TIME, -1L)).longValue();
        return System.currentTimeMillis() - jLongValue > 0 || System.currentTimeMillis() - (jLongValue - n.f()) < 0;
    }

    public static void y() {
        try {
            String str = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
            String str2 = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, "");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (f62851b.get()) {
                    return;
                }
                if (PushManager.getInstance().getPushListener() != null) {
                    PushManager.getInstance().getPushListener().onSdkInitSuccess(str, str2);
                    f62851b.set(true);
                } else {
                    Log.e(PushLogUtils.TAG, "tpush listener is not registered");
                }
            }
        } catch (Exception unused) {
        }
    }
}
