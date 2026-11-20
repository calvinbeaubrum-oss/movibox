package d;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.R$drawable;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushNotification;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.NotificationAssistUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.pushui.activity.TransparentActivity;
import java.util.HashMap;
import java.util.UUID;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t {
    public static int a() {
        return 0;
    }

    public static Notification b(Context context, PushMessage pushMessage, HashMap<String, Bitmap> map, Notification.Builder builder) {
        Notification.Style styleBigLargeIcon;
        if (pushMessage == null || builder == null) {
            return null;
        }
        PushNotification pushNotificationF = d.f(pushMessage.notiType, pushMessage.layoutStyleId);
        if (map == null || map.get(pushMessage.notiSmallIcon) == null || Build.VERSION.SDK_INT < 23) {
            builder.setSmallIcon((pushNotificationF == null || pushNotificationF.getSmallIcon() <= 0) ? R$drawable.tpush_notify_icon : pushNotificationF.getSmallIcon());
        } else {
            builder.setSmallIcon(Icon.createWithBitmap(map.get(pushMessage.notiSmallIcon)));
        }
        if (map != null && map.get(pushMessage.notiOptionalIcon) != null && Build.VERSION.SDK_INT >= 23) {
            builder.setLargeIcon(Icon.createWithBitmap(map.get(pushMessage.notiOptionalIcon)));
        }
        d(builder, pushMessage);
        if (pushMessage.notiType != 1) {
            RemoteViews remoteViewsE = d.e(context, pushMessage, map, false);
            if (remoteViewsE == null) {
                return builder.build();
            }
            builder.setContentTitle(pushMessage.notiTitle);
            builder.setContentText(pushMessage.notiDes);
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                builder.setCustomContentView(remoteViewsE);
            } else {
                builder.setContent(remoteViewsE);
            }
            if (i11 >= 31) {
                builder.setStyle(o.a());
                builder.setCustomBigContentView(d.a(context, pushMessage, map, false));
            }
            return builder.build();
        }
        builder.setContentTitle(pushMessage.notiTitle).setContentText(pushMessage.notiDes);
        int i12 = pushMessage.notiExType;
        if (i12 != 2) {
            if (i12 == 3 && map != null && map.get(pushMessage.notiImgEx) != null) {
                builder.setLargeIcon(map.get(pushMessage.notiImgEx));
                styleBigLargeIcon = new Notification.BigPictureStyle().bigPicture(map.get(pushMessage.notiImgEx)).bigLargeIcon((Bitmap) null);
            }
            builder.setContentIntent(c(ws.a.a(), pushMessage));
            return builder.build();
        }
        styleBigLargeIcon = new Notification.BigTextStyle().bigText(pushMessage.notiTxtEx);
        builder.setStyle(styleBigLargeIcon);
        builder.setContentIntent(c(ws.a.a(), pushMessage));
        return builder.build();
    }

    public static PendingIntent c(Context context, PushMessage pushMessage) {
        int iHashCode;
        int i11;
        Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
        intent.setPackage(context.getPackageName());
        intent.putExtra("message", com.transsion.json.b.b(pushMessage));
        intent.putExtra(PushConstants.EXTRA_PUSH_NOTI_CLICK, true);
        if (Build.VERSION.SDK_INT >= 23) {
            iHashCode = UUID.randomUUID().hashCode();
            i11 = 67108864;
        } else {
            iHashCode = UUID.randomUUID().hashCode();
            i11 = ASTNode.NOJIT;
        }
        return PendingIntent.getActivity(context, iHashCode, intent, i11);
    }

    public static void d(Notification.Builder builder, PushMessage pushMessage) {
        try {
            if (!TextUtils.isEmpty(pushMessage.iconColor)) {
                builder.setColor(Color.parseColor(pushMessage.iconColor));
                return;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        PushNotification pushNotificationF = d.f(pushMessage.notiType, pushMessage.layoutStyleId);
        try {
            if (TextUtils.isEmpty(pushNotificationF.getIconColor())) {
                return;
            }
            builder.setColor(Color.parseColor(pushNotificationF.getIconColor()));
        } catch (Exception unused) {
        }
    }

    public static void e(PushMessage pushMessage) {
        if (pushMessage == null) {
            return;
        }
        PushNotification pushNotificationF = d.f(pushMessage.notiType, pushMessage.layoutStyleId);
        String channelId = pushMessage.channelId;
        try {
            if (TextUtils.isEmpty(channelId)) {
                channelId = pushNotificationF.getChannelId();
            }
            if (TextUtils.isEmpty(channelId)) {
                channelId = "";
            }
        } catch (Exception unused) {
        }
        pushMessage.channelId = channelId;
    }

    public static void f(PushMessage pushMessage, HashMap<String, Bitmap> map) {
        Context contextA;
        try {
            contextA = ws.a.a();
        } catch (Exception unused) {
            contextA = null;
        }
        if (contextA == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, true, 2);
            return;
        }
        boolean zIsOpenNotification = NotificationAssistUtils.isOpenNotification(contextA);
        NotificationManager notificationManager = (NotificationManager) contextA.getSystemService("notification");
        if (notificationManager == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, zIsOpenNotification, 3);
            return;
        }
        e(pushMessage);
        Notification.Builder builderA = l.a(contextA, pushMessage);
        if (builderA == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, zIsOpenNotification, 4);
            return;
        }
        Notification notificationB = b(contextA, pushMessage, map, builderA);
        if (notificationB == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, zIsOpenNotification, 5);
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                z3.z.a();
                NotificationChannel notificationChannelA = k1.h.a(TextUtils.isEmpty(pushMessage.channelId) ? "twibida" : pushMessage.channelId, TextUtils.isEmpty(pushMessage.channelName) ? "cloud messaging" : pushMessage.channelName, 3);
                PushLogUtils.LOG.g("message.channelId" + pushMessage.channelId + pushMessage.channelName);
                notificationManager.createNotificationChannel(notificationChannelA);
            }
            c.a.d(pushMessage, notificationManager);
            notificationManager.notify((int) pushMessage.messageId, notificationB);
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, zIsOpenNotification, zIsOpenNotification ? 0 : 6);
            if (PushManager.getInstance().getPushListener() != null) {
                PushManager.getInstance().getPushListener().onNotificationShow(pushMessage.messageId, pushMessage.notiOpenContent);
            }
        } catch (Exception e11) {
            PushLogUtils.LOG.i(e11);
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, zIsOpenNotification, 7);
        }
    }

    public static void g(PushRequest.ReportContentData reportContentData) {
    }

    public static void h(String[] strArr, int i11) {
    }

    public static String i() {
        if (PushManager.getInstance().getTestEnv()) {
            return PushConstants.BASE_TEST_URL_V2;
        }
        if (PushManager.getInstance().getDebug()) {
            return PushConstants.BASE_DEBUG_URL_V2;
        }
        try {
            String domain = GslbSdk.getDomain(PushConstants.BASE_RELEASE_URL_V2, false);
            if (TextUtils.isEmpty(domain)) {
                PushLogUtils.LOG.g("gslb domain is empty");
                return "";
            }
            PushLogUtils.LOG.g("gslb domain is" + domain);
            return domain;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean j() {
        return false;
    }
}
