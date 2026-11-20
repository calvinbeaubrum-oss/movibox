package com.transsion.push.helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.push.PushManager;
import com.transsion.push.R$dimen;
import com.transsion.push.R$id;
import com.transsion.push.R$layout;
import com.transsion.push.bean.MsgStatus;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.notification.c;
import com.transsion.push.notification.d;
import com.transsion.push.notification.g;
import com.transsion.push.notification.h;
import com.transsion.push.receiver.NotificationReceiver;
import com.transsion.push.utils.NotificationMMKVUtil;
import com.transsion.push.utils.NotificationUtil;
import com.transsion.pushapi.TriggerSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NotificationShowHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationShowHelper f56890a = new NotificationShowHelper();

    public final NotificationCompat.m a(Context context, int i11, MsgBean msgBean, d dVar, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
        c.a aVar = new c.a(context, i11, R$layout.push_notification_normal_small, R$layout.push_notification_big_picture);
        int i12 = R$id.notification_title_tv;
        String title = msgBean.getTitle();
        boolean z11 = false;
        c.a aVarX = aVar.W(i12, title != null ? StringsKt__StringsKt.c1(title, '\n') : null).X(R$id.iv_icon, 8);
        int i13 = R$id.notification_title_tv;
        String title2 = msgBean.getTitle();
        c.a aVarU = aVarX.U(i13, title2 != null ? StringsKt__StringsKt.c1(title2, '\n') : null);
        int i14 = R$id.notification_title_tv;
        String title3 = msgBean.getTitle();
        c.a aVarT = aVarU.S(i14, title3 != null ? StringsKt__StringsKt.c1(title3, '\n') : null).T(R$id.notification_last, 8).T(R$id.notification_next, 8).T(R$id.page_num, 8);
        NotificationUtil notificationUtil = NotificationUtil.f57032a;
        if (!RoomActivityLifecycleCallbacks.f51239a.i() && !msgBean.isFloat()) {
            z11 = true;
        }
        aVarT.y(notificationUtil.t(z11)).L(R$drawable.push_small_logo).G(dVar.c()).A(pendingIntent).x(pendingIntent3).O(System.currentTimeMillis());
        if (bitmap == null || bitmap.isRecycled()) {
            aVar.V(R$id.notification_content_image, null);
            aVar.R(R$id.notification_content_image, null);
        } else {
            Bitmap bitmapE = com.transsion.push.utils.a.f57057a.e(context, bitmap, gs.a.a(100), gs.a.a(56), false, gs.a.a(4));
            RemoteViews remoteViewsJ = aVar.j();
            if (remoteViewsJ != null) {
                remoteViewsJ.setImageViewBitmap(R$id.notification_content_image, bitmapE);
            }
            aVar.R(R$id.notification_content_image, bitmap);
        }
        return aVar.P().a(context);
    }

    public final NotificationCompat.m b(Context context, MsgBean msgBean, int i11, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2, d messageGroup) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgBean, "msgBean");
        Intrinsics.g(messageGroup, "messageGroup");
        PendingIntent pendingIntentI = i(context, msgBean, i11, messageGroup);
        PendingIntent pendingIntentJ = j(context, msgBean, i11, messageGroup);
        g.a aVar = new g.a(context, i11, R$layout.push_notification_normal_small, R$layout.push_notification_big_picture);
        aVar.G(messageGroup.c());
        int i12 = R$id.notification_title_tv;
        String title = msgBean.getTitle();
        aVar.V(i12, title != null ? StringsKt__StringsKt.c1(title, '\n') : null);
        RemoteViews remoteViewsJ = aVar.j();
        if (remoteViewsJ != null) {
            remoteViewsJ.setImageViewBitmap(R$id.notification_content_image, bitmap);
        }
        int i13 = R$id.notification_title_tv;
        String title2 = msgBean.getTitle();
        aVar.T(i13, title2 != null ? StringsKt__StringsKt.c1(title2, '\n') : null);
        int i14 = R$id.page_num;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(msgBean.getPermanentMsgPosition()), Integer.valueOf(msgBean.getPermanentMsgSize())}, 2));
        Intrinsics.f(str, "format(...)");
        aVar.T(i14, str);
        aVar.O(System.currentTimeMillis());
        aVar.A(pendingIntent);
        aVar.I(pendingIntentI);
        aVar.J(pendingIntentJ);
        aVar.K(true);
        NotificationUtil notificationUtil = NotificationUtil.f57032a;
        aVar.z(notificationUtil.D());
        if (bitmap == null || bitmap.isRecycled()) {
            aVar.W(R$id.notification_content_image, null);
            aVar.S(R$id.notification_content_image, null);
        } else {
            Bitmap bitmapE = com.transsion.push.utils.a.f57057a.e(context, bitmap, gs.a.a(60), gs.a.a(40), false, gs.a.a(4));
            RemoteViews remoteViewsJ2 = aVar.j();
            if (remoteViewsJ2 != null) {
                remoteViewsJ2.setImageViewBitmap(R$id.notification_content_image, bitmapE);
            }
            aVar.S(R$id.notification_content_image, bitmap);
        }
        if (notificationUtil.H()) {
            return aVar.P().a(context);
        }
        aVar.R(System.currentTimeMillis());
        aVar.N(true);
        return aVar.P().a(context);
    }

    public final NotificationCompat.m c(Context context, int i11, MsgBean msgBean, d dVar, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        h.a aVar = new h.a(context, i11);
        aVar.y(NotificationUtil.f57032a.t(!RoomActivityLifecycleCallbacks.f51239a.i()));
        aVar.L(R$drawable.push_small_logo);
        aVar.G(dVar.c());
        String title = msgBean.getTitle();
        aVar.C(title != null ? StringsKt__StringsKt.c1(title, '\n') : null);
        String desc = msgBean.getDesc();
        aVar.B(desc != null ? StringsKt__StringsKt.c1(desc, '\n') : null);
        aVar.A(pendingIntent);
        aVar.F(pendingIntent2);
        if (bitmap == null || bitmap.isRecycled()) {
            aVar.H(null);
        } else {
            int dimension = (int) context.getResources().getDimension(R$dimen.push_notification_transition_square_img_width);
            aVar.H(com.transsion.push.utils.a.f57057a.a(context, bitmap, dimension, dimension, false));
        }
        return aVar.P().a(context);
    }

    public final NotificationCompat.m d(Context context, int i11, MsgBean msgBean, d dVar, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        c.a aVar = new c.a(context, i11, R$layout.push_notification_normal_vertical_small, R$layout.push_notification_normal_vertical_big);
        int i12 = R$id.notification_title_tv;
        String title = msgBean.getTitle();
        boolean z11 = false;
        c.a aVarW = aVar.W(i12, title != null ? StringsKt__StringsKt.c1(title, '\n') : null);
        int i13 = R$id.notification_title_tv;
        String title2 = msgBean.getTitle();
        c.a aVarU = aVarW.U(i13, title2 != null ? StringsKt__StringsKt.c1(title2, '\n') : null);
        int i14 = R$id.notification_title_tv;
        String title3 = msgBean.getTitle();
        c.a aVarS = aVarU.S(i14, title3 != null ? StringsKt__StringsKt.c1(title3, '\n') : null);
        int i15 = R$id.notification_content_tv;
        String desc = msgBean.getDesc();
        c.a aVarS2 = aVarS.S(i15, desc != null ? StringsKt__StringsKt.c1(desc, '\n') : null);
        NotificationUtil notificationUtil = NotificationUtil.f57032a;
        if (!RoomActivityLifecycleCallbacks.f51239a.i() && !msgBean.isFloat()) {
            z11 = true;
        }
        aVarS2.y(notificationUtil.t(z11)).L(R$drawable.push_small_logo).G(dVar.c()).A(pendingIntent).x(pendingIntent2).O(System.currentTimeMillis());
        if (bitmap == null || bitmap.isRecycled()) {
            aVar.V(R$id.notification_content_image, null);
            aVar.R(R$id.notification_content_image, null);
        } else {
            com.transsion.push.utils.a aVar2 = com.transsion.push.utils.a.f57057a;
            Bitmap bitmapE = aVar2.e(context, bitmap, gs.a.a(40), gs.a.a(56), false, gs.a.a(4));
            Bitmap bitmapE2 = aVar2.e(context, bitmap, gs.a.a(71), gs.a.a(100), false, gs.a.a(4));
            RemoteViews remoteViewsJ = aVar.j();
            if (remoteViewsJ != null) {
                remoteViewsJ.setImageViewBitmap(R$id.notification_content_image, bitmapE);
            }
            aVar.R(R$id.notification_content_image, bitmapE2);
        }
        return aVar.P().a(context);
    }

    public final void e(int i11) {
        Object systemService = Utils.a().getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return;
        }
        notificationManager.cancel(i11);
    }

    public final PendingIntent f(Context context, MsgBean msgBean, int i11, d dVar) {
        return m("com.community.oneroom.notification_delete", context, msgBean, i11, dVar);
    }

    public final PendingIntent g(Context context, String str, int i11, MsgBean msgBean) {
        Intent intentX = NotificationUtil.f57032a.x(context, str, i11, msgBean.getSource(), msgBean.getType(), msgBean.getStyle(), msgBean.getMessageId());
        if (intentX == null) {
            return null;
        }
        intentX.setData(Uri.parse(msgBean.getDeeplink() + "&autoDownload=true"));
        return PendingIntent.getActivity(context, f56890a.k(msgBean), intentX, Build.VERSION.SDK_INT >= 23 ? 201326592 : ASTNode.NOJIT);
    }

    public final List<String> h(MsgBean msgBean) {
        Intrinsics.g(msgBean, "msgBean");
        ArrayList arrayList = new ArrayList();
        String imageList = msgBean.getImageList();
        if (imageList != null) {
            arrayList.addAll(StringsKt__StringsKt.E0(imageList, new String[]{","}, false, 0, 6, null));
        }
        return arrayList;
    }

    public final PendingIntent i(Context context, MsgBean msgBean, int i11, d dVar) {
        return m("com.community.oneroom.last_permanent_msg", context, msgBean, i11, dVar);
    }

    public final PendingIntent j(Context context, MsgBean msgBean, int i11, d dVar) {
        return m("com.community.oneroom.next_permanent_msg", context, msgBean, i11, dVar);
    }

    public final int k(MsgBean msgBean) {
        Intrinsics.g(msgBean, "msgBean");
        String messageId = msgBean.getMessageId();
        if (TextUtils.isEmpty(messageId)) {
            return Math.abs((int) System.currentTimeMillis());
        }
        return Math.abs(messageId != null ? messageId.hashCode() : 0);
    }

    public final PendingIntent l(Context context, String str, int i11, MsgBean msgBean) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgBean, "msgBean");
        Intent intentX = NotificationUtil.f57032a.x(context, str, i11, msgBean.getSource(), msgBean.getType(), msgBean.getStyle(), msgBean.getMessageId());
        if (intentX == null) {
            return null;
        }
        intentX.setData(Uri.parse(msgBean.getDeeplink()));
        return PendingIntent.getActivity(context, f56890a.k(msgBean), intentX, Build.VERSION.SDK_INT >= 23 ? 201326592 : ASTNode.NOJIT);
    }

    public final PendingIntent m(String str, Context context, MsgBean msgBean, int i11, d dVar) {
        int i12 = Build.VERSION.SDK_INT;
        int i13 = i12 >= 23 ? 201326592 : ASTNode.NOJIT;
        int iO = NotificationUtil.f57032a.o(msgBean.getMessageId(), msgBean.getType());
        Intent intent = new Intent(context, (Class<?>) NotificationReceiver.class);
        intent.setPackage(context.getPackageName());
        intent.setAction(str);
        intent.putExtra("extra_notification_id", i11);
        intent.putExtra("extra_notification_group_tag", dVar.d());
        intent.putExtra("extra_message_id", msgBean.getMessageId());
        intent.putExtra("MESSAGE_TYPE", msgBean.getType());
        intent.putExtra("extra_source", msgBean.getSource());
        intent.setData(Uri.parse(msgBean.getDeeplink()));
        if (i12 >= 24) {
            intent.addFlags(ASTNode.DEOP);
        }
        return PendingIntent.getBroadcast(context, iO, intent, i13);
    }

    public final int n() {
        return 111;
    }

    public final Notification o(Context context, NotificationCompat.m builder, int i11, d messageGroup, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(builder, "builder");
        Intrinsics.g(messageGroup, "messageGroup");
        Object systemService = context.getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return null;
        }
        Notification notificationC = builder.c();
        Intrinsics.f(notificationC, "builder.build()");
        if (z11 && Build.VERSION.SDK_INT < 26) {
            notificationC.visibility = 1;
            notificationC.priority = 1;
            notificationC.vibrate = new long[]{0, 300, 100, 300};
            notificationC.defaults = 3;
            notificationC.flags = 17;
        }
        try {
            Result.Companion companion = Result.Companion;
            notificationManager.notify(i11, notificationC);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return notificationC;
    }

    public final void p(Context context, MsgBean msgBean) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgBean, "msgBean");
        Intent intent = new Intent(context.getPackageName());
        intent.setAction("ACTION_NEW_MESSAGE");
        intent.putExtra("newMsg", msgBean);
        u3.a.b(context).d(intent);
    }

    public final void q(Context context, MsgBean msgBean, Bitmap bitmap) {
        NotificationCompat.m mVarC;
        Long lN;
        Intrinsics.g(context, "context");
        Intrinsics.g(msgBean, "msgBean");
        d dVarC = d.f56962d.c(msgBean.getType());
        int iK = k(msgBean);
        if (iK < 0) {
            return;
        }
        PendingIntent pendingIntentL = l(context, dVarC.d(), iK, msgBean);
        PendingIntent pendingIntentF = f(context, msgBean, iK, dVarC);
        PendingIntent pendingIntentG = g(context, dVarC.d(), iK, msgBean);
        String style = msgBean.getStyle();
        if (Intrinsics.b(style, "3") || !Intrinsics.b(style, "1") || NotificationUtil.f57032a.I()) {
            mVarC = c(context, iK, msgBean, dVarC, bitmap, pendingIntentL, pendingIntentF);
        } else {
            mVarC = PushConfigHelper.INSTANCE.isVerticalType() ? d(context, iK, msgBean, dVarC, bitmap, pendingIntentL, pendingIntentG) : a(context, iK, msgBean, dVarC, bitmap, pendingIntentL, pendingIntentF, pendingIntentG);
        }
        NotificationCompat.m mVar = mVarC;
        boolean z11 = !RoomActivityLifecycleCallbacks.f51239a.i();
        if (Intrinsics.b(msgBean.getType(), MsgType.SUBJECT_SEEKING.getType())) {
            mVar.F(true);
            NotificationMMKVUtil.f57030a.a().putLong("seeking_msg_show_time", System.currentTimeMillis());
        }
        o(context, mVar, iK, dVarC, z11);
        s(context, msgBean);
        if (msgBean.isRefresh()) {
            return;
        }
        if (Intrinsics.b(msgBean.getType(), MsgType.ONLINE_JSON_PUSH.getType())) {
            PushManager pushManager = PushManager.getInstance();
            String messageId = msgBean.getMessageId();
            pushManager.trackShow((messageId == null || (lN = k.n(messageId)) == null) ? 0L : lN.longValue(), a.f56923a.f() ? 0 : 6);
        } else {
            a.f56923a.d(msgBean);
        }
        p(context, msgBean);
    }

    public final void r(Context context, MsgBean msgBean, Bitmap bitmap) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgBean, "msgBean");
        d dVarC = d.f56962d.c(msgBean.getType());
        int iN = n();
        o(context, b(context, msgBean, iN, bitmap, l(context, dVarC.d(), iN, msgBean), f(context, msgBean, iN, dVarC), dVarC), iN, dVarC, true);
        if (msgBean.isRefresh()) {
            return;
        }
        a.f56923a.d(msgBean);
        p(context, msgBean);
    }

    public final void s(Context context, MsgBean msgBean) {
        msgBean.setMsgStatus(MsgStatus.SHOWED.ordinal());
        msgBean.setShowTime(Long.valueOf(System.currentTimeMillis()));
        if (msgBean.getTriggerSource() == TriggerSource.SCREEN_ON.ordinal()) {
            msgBean.setHasScreenOn(true);
        }
        if (msgBean.getTriggerSource() == TriggerSource.UNLOCK.ordinal()) {
            msgBean.setForceShow(true);
        }
        j.d(l0.a(w0.b()), null, null, new NotificationShowHelper$updateShowTime$1(context, msgBean, null), 3, null);
    }
}
