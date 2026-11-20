package com.transsion.push.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.json.b;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushMessageKey;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ServiceUtils;
import d.y;
import ws.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class FCMMessageReceiver extends BroadcastReceiver {
    public static boolean c(Intent intent) {
        return "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()) || "com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction());
    }

    public final PushMessage a(Bundle bundle) {
        PushMessage pushMessage = new PushMessage();
        pushMessage.messageId = y.e(bundle.getString(PushMessageKey.KEY_TCM_MSG_ID));
        pushMessage.type = y.d(bundle.getString(PushMessageKey.KEY_TCM_MSG_TYPE));
        pushMessage.pkgId = bundle.getString(PushMessageKey.KEY_TCM_MSG_PKG);
        pushMessage.packageName = bundle.getString(PushMessageKey.KEY_TCM_MSG_PKGNAME);
        try {
            pushMessage.rpkg = a.a().getPackageName();
        } catch (Exception unused) {
            pushMessage.rpkg = "";
        }
        pushMessage.notiType = y.d(bundle.getString(PushMessageKey.KEY_NOTI_TYPE));
        pushMessage.notiExType = y.c(bundle.getString(PushMessageKey.KEY_NOTI_EX_TYPE));
        pushMessage.msgTtl = y.d(bundle.getString(PushMessageKey.KEY_TCM_MSG_TTL));
        pushMessage.ignoreExpire = y.d(bundle.getString(PushMessageKey.KEY_NOTI_IGNORE_EXPIRE));
        pushMessage.groupId = bundle.getString(PushMessageKey.KEY_APP_GROUP_ID);
        pushMessage.groupMaxCount = bundle.getString(PushMessageKey.KEY_APP_GROUP_MAX_COUNT);
        pushMessage.notiTitle = bundle.getString(PushMessageKey.KEY_NOTI_TITLE);
        pushMessage.notiDes = bundle.getString(PushMessageKey.KEY_NOTI_DESC);
        pushMessage.notiImg = bundle.getString(PushMessageKey.KEY_NOTI_IMG);
        pushMessage.notiIcon = bundle.getString(PushMessageKey.KEY_NOTI_ICON);
        pushMessage.notiBtn = bundle.getString(PushMessageKey.KEY_NOTI_BTN);
        pushMessage.notiImgEx = bundle.getString(PushMessageKey.KEY_NOTI_IMG_EX);
        pushMessage.notiTitleEx = bundle.getString(PushMessageKey.KEY_NOTI_TITLE_EX);
        pushMessage.notiTxtEx = bundle.getString(PushMessageKey.KEY_NOTI_TXT_EX);
        pushMessage.notiOpenType = y.d(bundle.getString(PushMessageKey.KEY_NOTI_OPEN_TYPE));
        pushMessage.notiOpenContent = bundle.getString(PushMessageKey.KEY_NOTI_OPEN_CONTENT);
        pushMessage.transData = y.a(bundle.getString("trans_data"));
        pushMessage.timeStamp = bundle.getString(PushMessageKey.KEY_TCM_MSG_TIMESTAMP);
        pushMessage.notiSmallIcon = bundle.getString(PushMessageKey.KEY_NOTI_SMALL_ICON);
        pushMessage.displayPolicy = y.d(bundle.getString(PushMessageKey.KEY_DISPLAY_POLICY));
        pushMessage.appName = bundle.getString("app_name");
        pushMessage.layoutStyleId = y.d(bundle.getString(PushMessageKey.KEY_APP_LAYOUT_STYLE_ID));
        pushMessage.channelId = bundle.getString(PushMessageKey.KEY_APP_CHANNEL_ID);
        pushMessage.channelName = bundle.getString(PushMessageKey.KEY_APP_CHANNEL_NAME);
        pushMessage.iconColor = bundle.getString(PushMessageKey.KEY_NOTI_SMALL_ICON_COLOR);
        pushMessage.impUrlList = bundle.getString(PushMessageKey.KEY_NOTI_IMP_URLS);
        pushMessage.clickUrlList = bundle.getString(PushMessageKey.KEY_NOTI_CLICK_URLS);
        pushMessage.isHeadsUp = y.d(bundle.getString(PushMessageKey.KEY_NOTI_IS_HEADSUP));
        pushMessage.retraceMsgId = y.e(bundle.getString(PushMessageKey.KEY_NOTI_RETRACE_MSG_ID));
        pushMessage.notiExtensionBtn = bundle.getString(PushMessageKey.KEY_NOTI_BTN_EX);
        pushMessage.notiBtnBgColor = bundle.getString(PushMessageKey.KEY_NOTI_BTN_BG_COLOR);
        pushMessage.notiBtnTxtColor = bundle.getString(PushMessageKey.KEY_NOTI_BTN_WORD_COLOR);
        pushMessage.notiOptionalIcon = bundle.getString(PushMessageKey.KEY_NOTI_OPTIONAL_ICON);
        pushMessage.priority = y.d(bundle.getString(PushMessageKey.KEY_TCM_MSG_PRIORITY));
        pushMessage.sdkShow = y.d(bundle.getString(PushMessageKey.KEY_TCM_MSG_SDKSHOW));
        return pushMessage;
    }

    public final void b(Context context, Intent intent) {
        String strB;
        PushManager.getInstance().init(context.getApplicationContext());
        if (intent == null || intent.getExtras() == null || !c(intent)) {
            return;
        }
        PushMessage pushMessageA = a(intent.getExtras());
        PushLogUtils.LOG.g("Receiving FCM messages packageName:" + context.getPackageName() + "  " + pushMessageA);
        if (!d(pushMessageA)) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
                return;
            }
            return;
        }
        if (isOrderedBroadcast()) {
            abortBroadcast();
            setResultCode(-1);
        }
        Tracker.getInstance().trackMessage(pushMessageA.messageId, pushMessageA.type, pushMessageA.timeStamp, "all", 0);
        try {
            strB = b.b(pushMessageA);
        } catch (Exception e11) {
            PushLogUtils.LOG.i("Receiving FCM messages to messageContent fail, e:" + e11.getMessage());
            strB = null;
        }
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("message", strB);
        bundle.putString(PushConstants.EXTRA_PUSH_SERVICE_TYPE, "message");
        ServiceUtils.startTargetIntentService(context.getApplicationContext(), bundle);
    }

    public final boolean d(PushMessage pushMessage) {
        return pushMessage.messageId > 0 && pushMessage.type > 0 && !TextUtils.isEmpty(pushMessage.pkgId);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a.b(context.getApplicationContext());
        b(context, intent);
    }
}
