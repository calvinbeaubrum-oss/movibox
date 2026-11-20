package com.transsion.push.utils;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import androidx.work.m;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.n;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.MsgConfig;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.push.PushConstants;
import com.transsion.push.R$string;
import com.transsion.push.api.IPushProvider;
import com.transsion.push.bean.MsgStatus;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.bean.ShowOrder;
import com.transsion.push.helper.NotificationRefreshService;
import com.transsion.push.helper.NotificationShowHelper;
import com.transsion.push.helper.PushMsgHelper;
import com.transsion.push.helper.PushPermanentManager;
import com.transsion.push.notification.ToolbarNotificationUtils;
import com.transsion.push.receiver.NotificationReceiver;
import com.transsion.push.worker.PullWorker;
import com.transsion.push.worker.ReportWorker;
import com.transsion.pushapi.TriggerSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class NotificationUtil {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MsgConfig f57033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.transsion.push.worker.a f57034c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationUtil f57032a = new NotificationUtil();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f57035d = LazyKt__LazyJVMKt.b(new Function0<BuiltInNotificationHelper>() { // from class: com.transsion.push.utils.NotificationUtil$builtInNotificationHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BuiltInNotificationHelper invoke() {
            return new BuiltInNotificationHelper();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f57036e = LazyKt__LazyJVMKt.b(new Function0<kw.a>() { // from class: com.transsion.push.utils.NotificationUtil$mPullApi$2
        @Override // kotlin.jvm.functions.Function0
        public final kw.a invoke() {
            return (kw.a) NetServiceGenerator.f49399d.a().i(kw.a.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57037a;

        static {
            int[] iArr = new int[ShowOrder.values().length];
            try {
                iArr[ShowOrder.LAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShowOrder.NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f57037a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c implements com.tn.lib.util.networkinfo.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f57038a;

        public c(Context context) {
            this.f57038a = context;
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            NotificationUtil.f57032a.J(this.f57038a, TriggerSource.NETWORK_CONNECTED);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class d implements RequestListener<Drawable> {
        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", obj + " 预加载成功", false, 4, null);
            return true;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", obj + " 预加载失败", false, 4, null);
            return true;
        }
    }

    public static /* synthetic */ void K(NotificationUtil notificationUtil, Context context, TriggerSource triggerSource, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            triggerSource = TriggerSource.APP_INNER;
        }
        notificationUtil.J(context, triggerSource);
    }

    public static /* synthetic */ void R(NotificationUtil notificationUtil, Context context, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        notificationUtil.Q(context, str, z11);
    }

    public static /* synthetic */ void V(NotificationUtil notificationUtil, Context context, List list, ShowOrder showOrder, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            showOrder = ShowOrder.CURRENT;
        }
        if ((i11 & 8) != 0) {
            str = null;
        }
        notificationUtil.U(context, list, showOrder, str);
    }

    public static /* synthetic */ void v(NotificationUtil notificationUtil, Context context, ShowOrder showOrder, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            showOrder = ShowOrder.CURRENT;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        notificationUtil.u(context, showOrder, str, z11);
    }

    public final MsgBean A(int i11, List<MsgBean> list) {
        String pushGap;
        if (list.isEmpty()) {
            return null;
        }
        MsgConfig msgConfig = f57033b;
        int i12 = ((i11 - 7) / ((msgConfig == null || (pushGap = msgConfig.getPushGap()) == null) ? 2 : Integer.parseInt(pushGap))) % list.size();
        if (i12 < 0 || i12 >= list.size()) {
            return null;
        }
        return list.get(i12);
    }

    public final MsgConfig B() {
        String string = NotificationMMKVUtil.f57030a.a().getString(PushConstants.SP_KEY_CONFIG, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (MsgConfig) n.d(string, MsgConfig.class);
    }

    public final int C(List<MsgBean> list, String str) {
        if (list.size() == 1) {
            return 0;
        }
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            MsgBean msgBean = (MsgBean) obj;
            if (msgBean != null && Intrinsics.b(msgBean.getMessageId(), str)) {
                return ((i11 + list.size()) + 1) % list.size();
            }
            i11 = i12;
        }
        return 0;
    }

    public final String D() {
        return "oneroom_notice_Permanent";
    }

    public final String E(String url) {
        Intrinsics.g(url, "url");
        int iA = d0.a();
        return ImageHelper.f51371a.e(url, (124 & 2) != 0 ? 0 : iA, (124 & 4) != 0 ? 0 : iA, (124 & 8) != 0 ? true : true, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
    }

    public final void F(Context context) {
        Intrinsics.g(context, "context");
        try {
            WorkManager.g(context).f("unique_pull", ExistingPeriodicWorkPolicy.UPDATE, new m.a(PullWorker.class, 15L, TimeUnit.MINUTES).a("pull").b());
            MsgConfig msgConfigB = B();
            if (msgConfigB != null) {
                f57032a.q(context, msgConfigB);
            } else {
                msgConfigB = null;
            }
            f57033b = msgConfigB;
            G(context);
            j(context);
            ToolbarNotificationUtils.f56927a.k();
            k(context);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void G(Context context) {
        Intrinsics.g(context, "context");
        uo.b.a.f(uo.b.f78622a, "NotificationUtil", "NotificationUtil initListener ", false, 4, null);
        com.tn.lib.util.networkinfo.f.f49475a.l(new c(context));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("com.community.oneroom.notification_delete");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        }
        if (i11 >= 33) {
            context.registerReceiver(new NotificationReceiver(), intentFilter, 2);
        } else {
            context.registerReceiver(new NotificationReceiver(), intentFilter);
        }
        FSNControl.f57027a.i();
    }

    public final boolean H() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public final boolean I() {
        return Build.VERSION.SDK_INT <= 24;
    }

    public final void J(Context context, TriggerSource triggerSource) {
        Intrinsics.g(context, "context");
        Intrinsics.g(triggerSource, "triggerSource");
        L(context, triggerSource);
        PushPermanentManager.f56895a.o();
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new NotificationUtil$loadNotificationMsg$1(triggerSource, context, null), 3, null);
    }

    public final void L(Context context, TriggerSource triggerSource) {
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new NotificationUtil$loadSeekSubjectMsg$1(context, triggerSource, null), 3, null);
    }

    public final void M(Context context, PullMsgResp pullMsgResp) {
        List<MsgBean> items = pullMsgResp.getItems();
        if (items != null) {
            for (MsgBean msgBean : items) {
                if (msgBean != null && !msgBean.getBuiltIn()) {
                    List<String> listH = NotificationShowHelper.f56890a.h(msgBean);
                    if (!listH.isEmpty()) {
                        f57032a.N(context, listH.get(0));
                    }
                }
            }
        }
    }

    public final void N(Context context, String str) {
        Glide.with(context).load2(E(str)).diskCacheStrategy(DiskCacheStrategy.DATA).addListener(new d()).preload();
    }

    public final void O(com.transsion.push.worker.a aVar) {
        f57034c = aVar;
    }

    public final void P(Context context, String currentMsgId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(currentMsgId, "currentMsgId");
        v(this, context, ShowOrder.LAST, currentMsgId, false, 8, null);
    }

    public final void Q(Context context, String str, boolean z11) {
        Intrinsics.g(context, "context");
        u(context, ShowOrder.NEXT, str, z11);
    }

    public final void S(Context context, PullMsgResp pullMsgResp, TriggerSource triggerSource) {
        List<MsgBean> items;
        MsgBean msgBeanA;
        MsgConfig config;
        MsgConfig config2;
        MsgConfig config3 = pullMsgResp.getConfig();
        if (config3 != null) {
            Boolean enable = config3.getEnable();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.b(enable, bool)) {
                TriggerSource triggerSource2 = TriggerSource.SCREEN_ON;
                if (triggerSource != triggerSource2 || ((config2 = pullMsgResp.getConfig()) != null && Intrinsics.b(config2.getBrightScreen(), bool))) {
                    TriggerSource triggerSource3 = TriggerSource.UNLOCK;
                    if (triggerSource != triggerSource3 || ((config = pullMsgResp.getConfig()) != null && Intrinsics.b(config.getUnlock(), bool))) {
                        int i11 = Calendar.getInstance().get(11);
                        if (!m(i11) || (items = pullMsgResp.getItems()) == null || (msgBeanA = f57032a.A(i11, items)) == null) {
                            return;
                        }
                        if (msgBeanA.getForceShow() && triggerSource == triggerSource3) {
                            return;
                        }
                        if ((msgBeanA.getHasScreenOn() && triggerSource == triggerSource2) || msgBeanA.getMsgStatus() == MsgStatus.CLICKED.ordinal()) {
                            return;
                        }
                        if (triggerSource == TriggerSource.APP_INNER && msgBeanA.getMsgStatus() == MsgStatus.SHOWED.ordinal()) {
                            return;
                        }
                        if (triggerSource == TriggerSource.NETWORK_CONNECTED && msgBeanA.getMsgStatus() == MsgStatus.SHOWED.ordinal()) {
                            return;
                        }
                        msgBeanA.setTriggerSource(triggerSource.ordinal());
                        PushMsgHelper.f56891a.c(context, msgBeanA);
                    }
                }
            }
        }
    }

    public final void T(Context context, MsgBean msgBean) {
        if (msgBean == null) {
            return;
        }
        msgBean.setPermanent(true);
        PushMsgHelper.f56891a.b(context, msgBean);
    }

    public final void U(Context context, List<MsgBean> list, ShowOrder showOrder, String str) {
        if (list == null || CollectionsKt___CollectionsKt.b0(list).size() <= 3 || PushConfigHelper.INSTANCE.isAbType()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MsgBean msgBean : CollectionsKt___CollectionsKt.G0(list, 3)) {
            if (msgBean == null) {
                return;
            }
            if (msgBean.getPermanentMsgStatus() != MsgStatus.CLICKED.ordinal()) {
                arrayList.add(msgBean);
            }
        }
        if (!(!arrayList.isEmpty())) {
            n(context, "oneroom.group.tag.permanent", 111);
            return;
        }
        int i11 = 0;
        for (Object obj : arrayList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            MsgBean msgBean2 = (MsgBean) obj;
            msgBean2.setType(MsgType.PERMANENT.getType());
            msgBean2.setPermanentMsgPosition(i12);
            msgBean2.setPermanentMsgSize(arrayList.size());
            i11 = i12;
        }
        if (str == null) {
            T(context, arrayList.get(0));
            return;
        }
        int i13 = a.f57037a[showOrder.ordinal()];
        if (i13 == 1) {
            int iW = w(arrayList, str);
            if (iW < 0 || iW >= arrayList.size()) {
                return;
            }
            T(context, arrayList.get(iW));
            return;
        }
        if (i13 != 2) {
            T(context, arrayList.get(0));
            return;
        }
        int iC = C(arrayList, str);
        if (iC < 0 || iC >= arrayList.size()) {
            return;
        }
        T(context, arrayList.get(iC));
    }

    public final void j(Context context) {
        String value;
        Boolean boolY0;
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "key_report_request_off", false, 2, null);
        if (configBeanC == null || (value = configBeanC.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null || !boolY0.booleanValue()) {
            WorkManager.g(context).f("unique_report", ExistingPeriodicWorkPolicy.REPLACE, new m.a(ReportWorker.class, 15L, TimeUnit.MINUTES).i(new androidx.work.b.a().b(NetworkType.CONNECTED).a()).a("report").b());
        }
    }

    public final void k(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_notification_refresh", false, 2, null);
            if (Intrinsics.b(configBeanC != null ? configBeanC.getValue() : null, "false")) {
                return;
            }
            context.bindService(new Intent(context, (Class<?>) NotificationRefreshService.class), new b(), 1);
        }
    }

    public final boolean l() {
        String value;
        Boolean boolY0;
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "permanent_notification_switch", false, 2, null);
        return ((configBeanC == null || (value = configBeanC.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null) ? false : boolY0.booleanValue()) && Calendar.getInstance().get(11) >= 8;
    }

    public final boolean m(int i11) {
        String endTime;
        String startTime;
        int i12 = 8;
        int i13 = 22;
        try {
            MsgConfig msgConfig = f57033b;
            if (msgConfig != null && (startTime = msgConfig.getStartTime()) != null) {
                i12 = Integer.parseInt(startTime);
            }
            MsgConfig msgConfig2 = f57033b;
            if (msgConfig2 != null && (endTime = msgConfig2.getEndTime()) != null) {
                i13 = Integer.parseInt(endTime);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return i12 <= i11 && i11 < i13;
    }

    public final void n(Context context, String str, int i11) {
        if (context == null) {
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", "bad parameter.", false, 4, null);
            return;
        }
        Object systemService = context.getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", "NotificationManager is not available", false, 4, null);
            return;
        }
        try {
            notificationManager.cancel(i11);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final int o(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return new Random().nextInt();
        }
        return ((str != null ? str.hashCode() : 0) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @TargetApi(26)
    public final void p(ArrayList<NotificationChannel> arrayList, String str, String str2, int i11, boolean z11, boolean z12, boolean z13, boolean z14) {
        f.a();
        NotificationChannel notificationChannelA = e.a(str, str2, i11);
        notificationChannelA.setShowBadge(z13);
        if (!z11) {
            notificationChannelA.setSound(null, null);
        }
        notificationChannelA.enableVibration(z12);
        if (z12) {
            notificationChannelA.setVibrationPattern(new long[]{0, 300, 100, 300});
        }
        notificationChannelA.enableLights(z14);
        if (z14) {
            notificationChannelA.setLockscreenVisibility(1);
        }
        arrayList.add(notificationChannelA);
    }

    @TargetApi(26)
    public final void q(Context context, MsgConfig msgConfig) {
        Boolean shock;
        Boolean ring;
        Intrinsics.g(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Object systemService = context.getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        ArrayList<NotificationChannel> arrayList = new ArrayList<>();
        String string = context.getString(R$string.importance_foreground);
        Intrinsics.f(string, "context.getString(R.string.importance_foreground)");
        p(arrayList, "oneroom_notice_Foreground", string, (msgConfig == null || !Intrinsics.b(msgConfig.getFloatingWindow(), Boolean.TRUE)) ? 3 : 4, false, false, true, true);
        String string2 = context.getString(R$string.importance_background);
        Intrinsics.f(string2, "context.getString(R.string.importance_background)");
        p(arrayList, "oneroom_notice_Background", string2, 4, (msgConfig == null || (ring = msgConfig.getRing()) == null) ? true : ring.booleanValue(), (msgConfig == null || (shock = msgConfig.getShock()) == null) ? true : shock.booleanValue(), true, true);
        String string3 = context.getString(R$string.permanent);
        Intrinsics.f(string3, "context.getString(R.string.permanent)");
        p(arrayList, "oneroom_notice_Permanent", string3, 4, false, false, false, false);
        if (notificationManager != null) {
            notificationManager.createNotificationChannels(arrayList);
        }
    }

    public final void r() {
        com.transsion.push.worker.a aVar = f57034c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final BuiltInNotificationHelper s() {
        return (BuiltInNotificationHelper) f57035d.getValue();
    }

    public final String t(boolean z11) {
        return z11 ? "oneroom_notice_Foreground" : "oneroom_notice_Background";
    }

    public final void u(Context context, ShowOrder showOrder, String str, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(showOrder, "showOrder");
        if (l()) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new NotificationUtil$getLast3MsgForPermanent$1(z11, context, showOrder, str, null), 3, null);
        }
    }

    public final int w(List<MsgBean> list, String str) {
        if (list.size() == 1) {
            return 0;
        }
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            MsgBean msgBean = (MsgBean) obj;
            if (msgBean != null && Intrinsics.b(msgBean.getMessageId(), str)) {
                return ((i11 + list.size()) - 1) % list.size();
            }
            i11 = i12;
        }
        return 0;
    }

    public final Intent x(Context context, String str, int i11, String str2, String str3, String str4, String str5) {
        Intrinsics.g(context, "context");
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        if (iPushProvider == null) {
            return null;
        }
        Intent intentD1 = iPushProvider.d1(context);
        intentD1.putExtra("extra_notification_id", i11);
        intentD1.putExtra("extra_source", str2);
        intentD1.putExtra("MESSAGE_TYPE", str3);
        intentD1.putExtra("extra_message_id", str5);
        intentD1.putExtra("extra_message_style", str4);
        intentD1.addFlags(603979776);
        intentD1.setAction("android.intent.action.VIEW");
        return intentD1;
    }

    public final void y(Context context, TriggerSource triggerSource) {
        uo.b.a.f(uo.b.f78622a, "NotificationUtil", "get local notification begin", false, 4, null);
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new NotificationUtil$getLocalNotifications$1(context, null), 3, null);
    }

    public final kw.a z() {
        return (kw.a) f57036e.getValue();
    }
}
