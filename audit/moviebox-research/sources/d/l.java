package d;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushExtButtonList;
import com.transsion.push.bean.PushExtensionBtn;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import java.util.List;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l {
    public static Notification.Builder a(Context context, PushMessage pushMessage) {
        Notification.Builder builder;
        ObjectLogUtils objectLogUtils;
        StringBuilder sb2;
        int i11;
        String string;
        if (pushMessage == null) {
            objectLogUtils = PushLogUtils.LOG;
            string = "Get the notification object, the message is empty";
        } else {
            int i12 = pushMessage.notiType;
            if (i12 == 1 || i12 == 3) {
                int i13 = pushMessage.notiExType;
                if (i13 == 1 || i13 == 2 || i13 == 3) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        k.a();
                        builder = j.a(context, TextUtils.isEmpty(pushMessage.channelId) ? "twibida" : pushMessage.channelId);
                    } else {
                        builder = new Notification.Builder(context);
                    }
                    builder.setWhen(System.currentTimeMillis()).setShowWhen(true).setAutoCancel(true).setDefaults(2).setDefaults(1).setContentIntent(t.c(context, pushMessage));
                    if (pushMessage.isHeadsUp == 1) {
                        PushLogUtils.LOG.g("head up");
                        builder.setPriority(2);
                    } else {
                        PushLogUtils.LOG.g("no head up");
                        builder.setPriority(0);
                    }
                    List<PushExtensionBtn> listD = d(pushMessage);
                    if (listD != null && listD.size() > 0) {
                        for (PushExtensionBtn pushExtensionBtn : listD) {
                            builder.addAction(new Notification.Action(0, pushExtensionBtn.txt, t.c(context, c(pushMessage, pushExtensionBtn.type, pushExtensionBtn.content))));
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        builder.setChannelId(TextUtils.isEmpty(pushMessage.channelId) ? "twibida" : pushMessage.channelId);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(PushConstants.EXTRA_PUSH_FROM_TPUSH_NOTI, true);
                    builder.addExtras(bundle);
                    return builder;
                }
                objectLogUtils = PushLogUtils.LOG;
                sb2 = new StringBuilder();
                sb2.append("Notification expansion type is not supported，notiExType:");
                i11 = pushMessage.notiExType;
            } else {
                objectLogUtils = PushLogUtils.LOG;
                sb2 = new StringBuilder();
                sb2.append("Notification type is not supported，notiType:");
                i11 = pushMessage.notiType;
            }
            sb2.append(i11);
            string = sb2.toString();
        }
        objectLogUtils.i(string);
        return null;
    }

    public static PushMessage b(Intent intent) {
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

    public static PushMessage c(PushMessage pushMessage, int i11, String str) {
        PushMessage pushMessage2 = new PushMessage();
        pushMessage2.setMessageId(pushMessage.messageId);
        pushMessage2.setChannelName(pushMessage.channelName);
        pushMessage2.setNotiOpenType(i11);
        pushMessage2.setNotiOpenContent(str);
        pushMessage2.setPackageName(pushMessage.packageName);
        return pushMessage2;
    }

    public static List<PushExtensionBtn> d(PushMessage pushMessage) {
        if (TextUtils.isEmpty(pushMessage.notiExtensionBtn)) {
            return null;
        }
        try {
            PushExtButtonList pushExtButtonList = (PushExtButtonList) com.transsion.json.b.a(pushMessage.notiExtensionBtn, PushExtButtonList.class);
            if (pushExtButtonList.list.size() == 0) {
                return null;
            }
            return pushExtButtonList.list;
        } catch (Exception e11) {
            PushLogUtils.LOG.i(e11);
            return null;
        }
    }

    public static void e(long j11) {
        try {
            NotificationManager notificationManager = (NotificationManager) ws.a.a().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            notificationManager.cancel((int) j11);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00ae A[PHI: r0
  0x00ae: PHI (r0v3 'e' java.lang.Exception) = (r0v1 'e' java.lang.Exception), (r0v8 'e' java.lang.Exception) binds: [B:19:0x006c, B:27:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    public static void f(Context context, Intent intent) {
        PushMessage pushMessageB = b(intent);
        if (pushMessageB == null) {
            PushLogUtils.LOG.i("handler notification messages, message empty");
            return;
        }
        int i11 = pushMessageB.notiOpenType;
        if (1 == i11) {
            try {
                Intent intent2 = new Intent();
                if (TextUtils.isEmpty(pushMessageB.notiOpenContent) || !pushMessageB.notiOpenContent.contains("://")) {
                    intent2.setClassName(pushMessageB.packageName, pushMessageB.notiOpenContent);
                } else {
                    intent2.setData(Uri.parse(pushMessageB.notiOpenContent));
                }
                intent2.setFlags(276824064);
                context.startActivity(intent2);
            } catch (Exception e11) {
                e = e11;
                PushLogUtils.LOG.z("e:" + e.getMessage());
                g(context, pushMessageB);
                if (PushManager.getInstance().getPushListener() != null) {
                    PushManager.getInstance().getPushListener().onClickException(pushMessageB.messageId, e.getMessage());
                }
            }
        } else if (2 == i11) {
            try {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(pushMessageB.notiOpenContent));
                intent3.setFlags(ASTNode.DEOP);
                context.startActivity(intent3);
            } catch (Exception e12) {
                e = e12;
                PushLogUtils.LOG.z("e:" + e.getMessage());
                g(context, pushMessageB);
                if (PushManager.getInstance().getPushListener() != null) {
                    PushManager.getInstance().getPushListener().onClickException(pushMessageB.messageId, e.getMessage());
                }
            }
        }
        e(pushMessageB.messageId);
        x.p(pushMessageB.messageId);
        Tracker.getInstance().trackClick(pushMessageB.messageId);
    }

    public static void g(Context context, PushMessage pushMessage) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(pushMessage.packageName);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0 || listQueryIntentActivities.get(0).activityInfo == null) {
            return;
        }
        try {
            Intent intent2 = new Intent();
            intent2.setFlags(343932928);
            intent2.setClassName(listQueryIntentActivities.get(0).activityInfo.packageName, listQueryIntentActivities.get(0).activityInfo.name);
            context.startActivity(intent2);
        } catch (Exception e11) {
            e11.printStackTrace();
            PushLogUtils.LOG.i("e:" + e11.getMessage());
        }
    }
}
