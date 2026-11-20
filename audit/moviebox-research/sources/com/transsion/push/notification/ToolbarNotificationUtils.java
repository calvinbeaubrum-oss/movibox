package com.transsion.push.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.permissionx.guolindev.PermissionX;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.push.R$drawable;
import com.transsion.push.R$id;
import com.transsion.push.R$layout;
import com.transsion.push.R$mipmap;
import com.transsion.push.R$string;
import com.transsion.push.api.IPushProvider;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.ToolbarNoticeConfig;
import com.transsion.push.bean.ToolbarNoticeItem;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.k;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;
import z3.z;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ToolbarNotificationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ToolbarNotificationUtils f56927a = new ToolbarNotificationUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f56928b = 790343710;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f56929c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final NotificationManager f56930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ToolbarNoticeConfig f56931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f56932f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56933a;

        static {
            int[] iArr = new int[NoticeIntentType.values().length];
            try {
                iArr[NoticeIntentType.SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoticeIntentType.TOP_10.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoticeIntentType.SETTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NoticeIntentType.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f56933a = iArr;
        }
    }

    static {
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        f56930d = notificationManager;
        if (Build.VERSION.SDK_INT >= 26) {
            z.a();
            notificationManager.createNotificationChannel(k1.h.a("mbx_tool_notice", Utils.a().getString(R$string.tool_notice_name), 2));
        }
    }

    public final void A(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", str);
        m.f51277a.m("toolbar_notice", "click", linkedHashMap);
    }

    public final void B() {
        m.f51277a.t("toolbar_notice", "browse", new LinkedHashMap());
    }

    public final void C(RemoteViews remoteViews, Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair) {
        if (pair.getFirst().isDefault()) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "setButtonText 默认本地文案", false, 4, null);
            remoteViews.setTextViewText(R$id.notice_tv_left, Utils.a().getString(R$string.tool_notice_top_10));
            remoteViews.setTextViewText(R$id.notice_tv_right, Utils.a().getString(R$string.tool_notice_search));
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ToolbarNo", "setButtonText 配置文案", false, 4, null);
        String text = pair.getFirst().getText();
        if (text != null) {
            remoteViews.setTextViewText(R$id.notice_tv_left, text);
        }
        String text2 = pair.getSecond().getText();
        if (text2 != null) {
            remoteViews.setTextViewText(R$id.notice_tv_right, text2);
        }
    }

    public final void D(RemoteViews remoteViews, Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair) {
        int i11 = R$id.notice_ll_left;
        String deeplink = pair.getFirst().getDeeplink();
        if (deeplink == null) {
            deeplink = m(NoticeIntentType.TOP_10);
        }
        remoteViews.setOnClickPendingIntent(i11, o(deeplink, TtmlNode.LEFT));
        int i12 = R$id.notice_ll_right;
        String deeplink2 = pair.getSecond().getDeeplink();
        if (deeplink2 == null) {
            deeplink2 = m(NoticeIntentType.SEARCH);
        }
        remoteViews.setOnClickPendingIntent(i12, o(deeplink2, TtmlNode.RIGHT));
        remoteViews.setOnClickPendingIntent(R$id.notice_v_setting, o(m(NoticeIntentType.SETTING), "setting"));
    }

    public final void E(RemoteViews remoteViews, Pair<Bitmap, Bitmap> pair) {
        if (pair == null) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "setIconCover 默认本地图", false, 4, null);
            remoteViews.setImageViewResource(R$id.notice_iv_left, R$mipmap.ic_notification_top_10);
            remoteViews.setImageViewResource(R$id.notice_iv_right, R$mipmap.ic_notification_search);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ToolbarNo", "setIconCover 配置图", false, 4, null);
        Bitmap first = pair.getFirst();
        if (first != null) {
            remoteViews.setImageViewBitmap(R$id.notice_iv_left, first);
        }
        Bitmap second = pair.getSecond();
        if (second != null) {
            remoteViews.setImageViewBitmap(R$id.notice_iv_right, second);
        }
    }

    public final void F() {
        final Pair<ToolbarNoticeItem, ToolbarNoticeItem> pairQ = q();
        if (!t()) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "showNotice, 配置数据，加载图片", false, 4, null);
            w(pairQ, new Function2<Bitmap, Bitmap, Unit>() { // from class: com.transsion.push.notification.ToolbarNotificationUtils$showNotice$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Bitmap bitmap2) {
                    invoke2(bitmap, bitmap2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Bitmap bitmap, Bitmap bitmap2) {
                    uo.b.a.f(uo.b.f78622a, "ToolbarNo", "showNotice, 加载图片成功， " + (bitmap != null) + ",  " + (bitmap2 != null), false, 4, null);
                    ToolbarNotificationUtils toolbarNotificationUtils = ToolbarNotificationUtils.f56927a;
                    Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair = pairQ;
                    try {
                        Result.Companion companion = Result.Companion;
                        ToolbarNotificationUtils.f56930d.notify(ToolbarNotificationUtils.f56928b, toolbarNotificationUtils.s(pair, new Pair(bitmap, bitmap2)).c());
                        Result.m163constructorimpl(Unit.f68710a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m163constructorimpl(ResultKt.a(th2));
                    }
                    ToolbarNotificationUtils.f56927a.B();
                }
            });
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ToolbarNo", "showNotice, 本地默认数据", false, 4, null);
        try {
            Result.Companion companion = Result.Companion;
            f56930d.notify(f56928b, s(pairQ, null).c());
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        B();
    }

    public final void G() {
        Object objM163constructorimpl;
        PermissionX permissionX = PermissionX.f48641a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        if (!permissionX.a(applicationA)) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "showToolbarNotification 没有通知权限", false, 4, null);
            return;
        }
        if (!f56932f) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "showToolbarNotification，当前不需要展示通知", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            f56930d.cancel(f56928b);
            f56927a.F();
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "showToolbarNotification", false, 4, null);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.a.j(uo.b.f78622a, "ToolbarNo", "showToolbarNotification error:" + thM166exceptionOrNullimpl, false, 4, null);
        }
    }

    public final void j(RemoteViews remoteViews, boolean z11) {
        int color = Utils.a().getResources().getColor(z11 ? R$color.white : R$color.gray_light_70);
        remoteViews.setTextColor(R$id.notice_tv_left, color);
        remoteViews.setTextColor(R$id.notice_tv_right, color);
        int i11 = z11 ? R$drawable.shape_toolbar_btn_bg_dark : R$drawable.shape_toolbar_btn_bg_light;
        remoteViews.setInt(R$id.notice_ll_left, "setBackgroundResource", i11);
        remoteViews.setInt(R$id.notice_ll_right, "setBackgroundResource", i11);
        remoteViews.setInt(R$id.notice_iv_left, "setColorFilter", color);
        remoteViews.setInt(R$id.notice_iv_right, "setColorFilter", color);
    }

    public final void k() {
        j.d(l0.a(w0.b()), null, null, new ToolbarNotificationUtils$checkNotice$1(null), 3, null);
    }

    public final boolean l(long j11, int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j11);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, i11);
        long timeInMillis = calendar.getTimeInMillis();
        uo.b.f78622a.c("ToolbarNo", "isNeedShowNotice, currentTimeMillis:" + jCurrentTimeMillis + ", daysAgo:" + timeInMillis, true);
        return jCurrentTimeMillis > timeInMillis;
    }

    public final String m(NoticeIntentType type) {
        Intrinsics.g(type, "type");
        int i11 = a.f56933a[type.ordinal()];
        if (i11 == 1) {
            return "oneroom://com.community.oneroom?type=/search/activity/search_manager&channel=os_search&type=3";
        }
        if (i11 == 2) {
            return "oneroom://com.community.oneroom?type=/rank/all";
        }
        if (i11 == 3) {
            return "oneroom://com.community.oneroom?type=/profile/setting_notice";
        }
        if (i11 == 4) {
            return "oneroom://com.community.oneroom?type=/main/tab";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int n() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    public final PendingIntent o(String str, String str2) {
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        int i11 = f56928b;
        intentD1.putExtra("extra_notification_id", String.valueOf(i11));
        intentD1.putExtra("extra_source", MsgStyle.SOURCE_PUSH);
        intentD1.putExtra("MESSAGE_TYPE", MsgType.TOP10_PUSH.getType());
        intentD1.putExtra("extra_message_id", String.valueOf(i11));
        intentD1.putExtra("extra_toolbar_notice_name", str2);
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse(str));
        if (Build.VERSION.SDK_INT >= 24) {
            intentD1.addFlags(ASTNode.DEOP);
        }
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, intentD1, n());
        Intrinsics.f(activity, "getActivity(Utils.getApp…cationIntent, getFlags())");
        return activity;
    }

    public final int p() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.layout_ongoing_notification : R$layout.layout_ongoing_notification_expend_s;
    }

    public final Pair<ToolbarNoticeItem, ToolbarNoticeItem> q() {
        if (t()) {
            ToolbarNoticeItem toolbarNoticeItem = new ToolbarNoticeItem(null, null, m(NoticeIntentType.TOP_10), 3, null);
            toolbarNoticeItem.setDefault(true);
            ToolbarNoticeItem toolbarNoticeItem2 = new ToolbarNoticeItem(null, null, m(NoticeIntentType.SEARCH), 3, null);
            toolbarNoticeItem2.setDefault(true);
            return new Pair<>(toolbarNoticeItem, toolbarNoticeItem2);
        }
        ToolbarNoticeConfig toolbarNoticeConfig = f56931e;
        Intrinsics.d(toolbarNoticeConfig);
        List<ToolbarNoticeItem> list = toolbarNoticeConfig.getList();
        Intrinsics.d(list);
        ToolbarNoticeItem toolbarNoticeItem3 = list.get(0);
        ToolbarNoticeConfig toolbarNoticeConfig2 = f56931e;
        Intrinsics.d(toolbarNoticeConfig2);
        List<ToolbarNoticeItem> list2 = toolbarNoticeConfig2.getList();
        Intrinsics.d(list2);
        return new Pair<>(toolbarNoticeItem3, list2.get(1));
    }

    public final int r() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.layout_ongoing_notification : R$layout.layout_ongoing_notification_s;
    }

    public final NotificationCompat.m s(Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair, Pair<Bitmap, Bitmap> pair2) {
        boolean z11 = (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), r());
        ToolbarNotificationUtils toolbarNotificationUtils = f56927a;
        toolbarNotificationUtils.D(remoteViews, pair);
        toolbarNotificationUtils.E(remoteViews, pair2);
        toolbarNotificationUtils.C(remoteViews, pair);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            toolbarNotificationUtils.j(remoteViews, z11);
        }
        RemoteViews remoteViews2 = new RemoteViews(Utils.a().getPackageName(), p());
        toolbarNotificationUtils.D(remoteViews2, pair);
        toolbarNotificationUtils.E(remoteViews2, pair2);
        toolbarNotificationUtils.C(remoteViews2, pair);
        if (i11 >= 31) {
            toolbarNotificationUtils.j(remoteViews2, z11);
        }
        NotificationCompat.m mVarS = new NotificationCompat.m(Utils.a(), "mbx_tool_notice").K(com.tn.lib.widget.R$drawable.push_small_logo).t(remoteViews).p(o(m(NoticeIntentType.CONTENT), AppLovinEventTypes.USER_VIEWED_CONTENT)).F(true).l(false).G(true).s(remoteViews2);
        Intrinsics.f(mVarS, "Builder(Utils.getApp(), …igContentView(expendView)");
        return mVarS;
    }

    public final boolean t() {
        List<ToolbarNoticeItem> list;
        ToolbarNoticeConfig toolbarNoticeConfig = f56931e;
        return toolbarNoticeConfig == null || toolbarNoticeConfig == null || (list = toolbarNoticeConfig.getList()) == null || list.size() < 2;
    }

    public final boolean u(int i11) {
        Long lN;
        if (!RoomActivityLifecycleCallbacks.f51239a.i()) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "isNeedShowNotice,当前在前台，无需处理", false, 4, null);
            return false;
        }
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (!roomAppMMKV.a().getBoolean("k_is_show_ongoing_tool_notice", true)) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "isNeedShowNotice,设置页已主动关闭", false, 4, null);
            return false;
        }
        String string = roomAppMMKV.a().getString("k_last_open_time", "");
        long jLongValue = (string == null || (lN = k.n(string)) == null) ? 0L : lN.longValue();
        if (jLongValue > 0) {
            if (l(jLongValue, i11)) {
                uo.b.f78622a.c("ToolbarNo", "isNeedShowNotice, true currentDayKey:" + System.currentTimeMillis() + ", appOpenTime:" + jLongValue + ", " + i11 + " ", true);
                return true;
            }
            uo.b.f78622a.c("ToolbarNo", "isNeedShowNotice, false currentDayKey:" + System.currentTimeMillis() + ", appOpenTime:" + jLongValue + ", " + i11 + " ", true);
        }
        return false;
    }

    public final Object v(String str, Continuation<? super Bitmap> continuation) {
        return TimeoutKt.c(5000L, new ToolbarNotificationUtils$loadImageAsBitmap$2(str, f0.a(20.0f), null), continuation);
    }

    public final void w(Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair, Function2<? super Bitmap, ? super Bitmap, Unit> function2) {
        j.d(l0.a(w0.c()), null, null, new ToolbarNotificationUtils$loadImages$1(function2, pair, null), 3, null);
    }

    public final void x(Intent intent) {
        String stringExtra;
        String stringExtra2;
        if (intent == null || (stringExtra = intent.getStringExtra("extra_notification_id")) == null || !Intrinsics.b(stringExtra, String.valueOf(f56928b)) || (stringExtra2 = intent.getStringExtra("extra_toolbar_notice_name")) == null) {
            return;
        }
        A(stringExtra2);
    }

    public final void y(ToolbarNoticeConfig toolbarNoticeConfig) {
        List<ToolbarNoticeItem> list;
        if (toolbarNoticeConfig == null || (list = toolbarNoticeConfig.getList()) == null || list.isEmpty() || toolbarNoticeConfig.getList().size() < 2) {
            return;
        }
        int iA = f0.a(20.0f);
        Iterator<T> it = toolbarNoticeConfig.getList().iterator();
        while (it.hasNext()) {
            String cover = ((ToolbarNoticeItem) it.next()).getCover();
            if (cover != null) {
                Map<String, String> map = f56929c;
                if (!map.containsKey(cover)) {
                    uo.b.a.f(uo.b.f78622a, "ToolbarNo", "preloadImage, url :" + cover, false, 4, null);
                    map.put(cover, "");
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    companion.w(companion.e(cover, (124 & 2) != 0 ? 0 : iA, (124 & 4) != 0 ? 0 : iA, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), cover, iA, new Function1<Boolean, Unit>() { // from class: com.transsion.push.notification.ToolbarNotificationUtils$preloadImage$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(boolean z11) {
                            uo.b.a.s(uo.b.f78622a, "ToolbarNo", "preloadImage, result:" + z11, false, 4, null);
                        }
                    });
                }
            }
        }
    }

    public final void z() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            f56930d.cancel(f56928b);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.a.f(uo.b.f78622a, "ToolbarNo", "removeOngoingToolNotification error:" + thM166exceptionOrNullimpl, false, 4, null);
        }
    }
}
