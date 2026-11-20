package com.transsnet.downloader.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.h0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$string;
import com.transsion.baseui.util.l;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.push.R$dimen;
import com.transsion.push.R$id;
import com.transsion.push.R$layout;
import com.transsion.push.api.IPushProvider;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsion.push.utils.NotificationMMKVUtil;
import com.transsion.push.utils.NotificationUtil;
import com.transsion.push.utils.e;
import com.transsion.push.utils.f;
import com.transsnet.downloader.guard.DownloadGuard;
import com.transsnet.downloader.manager.b;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DownloadNotificationUtils {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f61072e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadNotificationUtils f61068a = new DownloadNotificationUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f61069b = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.notification.DownloadNotificationUtils$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f61070c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f61071d = LazyKt__LazyJVMKt.b(new Function0<NotificationManager>() { // from class: com.transsnet.downloader.notification.DownloadNotificationUtils$notificationManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationManager invoke() {
            Object systemService = Utils.a().getSystemService("notification");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService;
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f61073f = "";

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadBean f61074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f61075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f61076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f61077d;

        public a(DownloadBean downloadBean, boolean z11, String str, String str2) {
            this.f61074a = downloadBean;
            this.f61075b = z11;
            this.f61076c = str;
            this.f61077d = str2;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            uo.b.a.f(uo.b.f78622a, "download_notify", "onFailure", false, 4, null);
        }

        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            NotificationCompat.m mVarT;
            Intrinsics.g(resource, "resource");
            uo.b.a.f(uo.b.f78622a, "download_notify", "onSuccess", false, 4, null);
            int i11 = Build.VERSION.SDK_INT;
            int i12 = i11 >= 31 ? 67108864 : ASTNode.NOJIT;
            DownloadNotificationUtils downloadNotificationUtils = DownloadNotificationUtils.f61068a;
            int iW = downloadNotificationUtils.w(this.f61074a);
            int i13 = iW + 1;
            IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
            if (iPushProvider != null) {
                String strS = downloadNotificationUtils.s(this.f61074a);
                int status = this.f61074a.getStatus();
                PendingIntent pendingIntentQ = downloadNotificationUtils.q(iPushProvider, i13, this.f61074a, i12);
                PendingIntent pendingIntentP = this.f61074a.getType() == 1 ? downloadNotificationUtils.p(iPushProvider, i13, this.f61074a, i12) : downloadNotificationUtils.z(iPushProvider, i13, this.f61074a, i12);
                String strA = this.f61075b ? downloadNotificationUtils.A(status) : this.f61076c;
                if (!this.f61075b) {
                    strS = this.f61077d;
                }
                String str = strS;
                if (i11 >= 31) {
                    RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), R$layout.push_notification_custom_left_pic_s_small);
                    remoteViews.setTextViewText(R$id.notification_title_tv, strA);
                    remoteViews.setTextViewText(R$id.notification_content_tv, str);
                    remoteViews.setImageViewResource(R$id.iv_icon, R$mipmap.icon_play_white);
                    remoteViews.setTextViewText(R$id.tv_tips, Utils.a().getString(R$string.play));
                    remoteViews.setOnClickPendingIntent(R$id.ll_download, pendingIntentP);
                    int dimension = (int) Utils.a().getResources().getDimension(R$dimen.push_notification_transition_rectangle_img_width);
                    int dimension2 = (int) Utils.a().getResources().getDimension(R$dimen.push_notification_transition_rectangle_img_height);
                    com.transsion.push.utils.a aVar = com.transsion.push.utils.a.f57057a;
                    Application applicationA = Utils.a();
                    Intrinsics.f(applicationA, "getApp()");
                    Bitmap bitmapF = com.transsion.push.utils.a.f(aVar, applicationA, resource, dimension, dimension2, false, 0, 32, null);
                    RemoteViews remoteViews2 = new RemoteViews(Utils.a().getPackageName(), R$layout.push_notification_custom_left_pic_s_big);
                    remoteViews2.setTextViewText(R$id.notification_title_tv, strA);
                    remoteViews2.setTextViewText(R$id.notification_content_tv, str);
                    remoteViews2.setImageViewBitmap(R$id.notification_content_image, bitmapF);
                    remoteViews2.setImageViewResource(R$id.iv_icon, R$mipmap.icon_play_white);
                    remoteViews2.setTextViewText(R$id.tv_tips, Utils.a().getString(R$string.play));
                    remoteViews2.setOnClickPendingIntent(R$id.ll_download, pendingIntentP);
                    mVarT = new NotificationCompat.m(Utils.a(), "download_service").K(R$drawable.push_small_logo).r(strA).q(str).p(pendingIntentQ).l(true).t(remoteViews).s(remoteViews2);
                } else {
                    RemoteViews remoteViews3 = new RemoteViews(Utils.a().getPackageName(), R$layout.push_notification_custom_left_pic);
                    remoteViews3.setTextViewText(R$id.notification_title_tv, strA);
                    remoteViews3.setTextViewText(R$id.notification_content_tv, str);
                    remoteViews3.setImageViewBitmap(R$id.notification_content_image, resource);
                    remoteViews3.setImageViewResource(R$id.iv_icon, R$mipmap.icon_play_white);
                    remoteViews3.setTextViewText(R$id.tv_tips, Utils.a().getString(R$string.play));
                    remoteViews3.setOnClickPendingIntent(R$id.ll_download, pendingIntentP);
                    remoteViews3.setLong(R$id.time, "setTime", System.currentTimeMillis());
                    mVarT = new NotificationCompat.m(Utils.a(), "download_service_high").K(R$drawable.push_small_logo).p(pendingIntentQ).r(strA).q(str).l(true).t(remoteViews3);
                }
                Intrinsics.f(mVarT, "if (Build.VERSION.SDK_IN…                        }");
                downloadNotificationUtils.y().cancel(iW);
                try {
                    Result.Companion companion = Result.Companion;
                    NotificationManagerCompat.from(Utils.a()).notify(i13, mVarT.c());
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
                if (this.f61075b) {
                    return;
                }
                NotificationMMKVUtil.f57030a.a().putLong("download_play_notification_time", System.currentTimeMillis());
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b implements com.transsion.push.worker.a {
        @Override // com.transsion.push.worker.a
        public void a() {
            DownloadNotificationUtils downloadNotificationUtils = DownloadNotificationUtils.f61068a;
            if (downloadNotificationUtils.k()) {
                downloadNotificationUtils.u();
            }
        }
    }

    public static /* synthetic */ void n(DownloadNotificationUtils downloadNotificationUtils, DownloadBean downloadBean, boolean z11, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        downloadNotificationUtils.m(downloadBean, z11, str, str2);
    }

    public final String A(int i11) {
        Application applicationA = Utils.a();
        if (i11 == 3) {
            String string = applicationA.getString(com.transsnet.downloader.R$string.notification_download_waiting);
            Intrinsics.f(string, "app.getString(R.string.n…ication_download_waiting)");
            return string;
        }
        if (i11 == 4) {
            String string2 = applicationA.getString(com.transsnet.downloader.R$string.notification_download_paused);
            Intrinsics.f(string2, "app.getString(R.string.n…fication_download_paused)");
            return string2;
        }
        if (i11 == 5) {
            String string3 = applicationA.getString(com.transsnet.downloader.R$string.notification_download_success);
            Intrinsics.f(string3, "app.getString(R.string.n…ication_download_success)");
            return string3;
        }
        if (i11 != 6) {
            return "";
        }
        String string4 = applicationA.getString(com.transsnet.downloader.R$string.notification_download_failed);
        Intrinsics.f(string4, "app.getString(R.string.n…fication_download_failed)");
        return string4;
    }

    public final void B() {
        if (Build.VERSION.SDK_INT >= 26) {
            f.a();
            y().createNotificationChannel(e.a("download_service", Utils.a().getString(com.transsnet.downloader.R$string.download_notifications_name), 2));
            f.a();
            y().createNotificationChannel(e.a("download_service_high", Utils.a().getString(com.transsnet.downloader.R$string.download_success_notifications_name), 4));
        }
    }

    public final void C() {
        if (k()) {
            u();
        } else {
            NotificationUtil.f57032a.O(new b());
        }
    }

    public final void D(DownloadBean downloadBean) {
        if (downloadBean.getLastPlayTimeStamp() == 0) {
            String string = Utils.a().getString(com.transsnet.downloader.R$string.notification_download_complete);
            Intrinsics.f(string, "getApp().getString(R.str…cation_download_complete)");
            String string2 = Utils.a().getString(com.transsnet.downloader.R$string.notification_download_watch_tip, s(downloadBean));
            Intrinsics.f(string2, "getApp().getString(R.str…wnloadName(downloadBean))");
            m(downloadBean, false, string, string2);
            return;
        }
        Long duration = downloadBean.getDuration();
        if (duration != null) {
            long jLongValue = duration.longValue();
            if (jLongValue <= 0 || ((downloadBean.getReadProgress() * 1.0f) / jLongValue) * 1.0f >= 0.8d) {
                return;
            }
            String string3 = Utils.a().getString(com.transsnet.downloader.R$string.notification_continue_watching);
            Intrinsics.f(string3, "getApp().getString(R.str…cation_continue_watching)");
            Application applicationA = Utils.a();
            int i11 = com.transsnet.downloader.R$string.notification_download_continue_tip;
            DownloadNotificationUtils downloadNotificationUtils = f61068a;
            String string4 = applicationA.getString(i11, downloadNotificationUtils.s(downloadBean));
            Intrinsics.f(string4, "getApp().getString(R.str…wnloadName(downloadBean))");
            downloadNotificationUtils.m(downloadBean, false, string3, string4);
        }
    }

    public final void E(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        int iW = w(downloadInfo);
        int i11 = iW + 1;
        int status = downloadInfo.getStatus();
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        if (!downloadInfo.isDownloading()) {
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "download_notify", "updateCustomView, status = " + status + "， name = " + downloadInfo.getTotalTitleName(), false, 4, null);
            if (f61072e == status && Intrinsics.b(f61073f, resourceId)) {
                uo.b.a.f(aVar, "download_notify", "updateCustomView, return", false, 4, null);
                return;
            }
        }
        f61072e = status;
        f61073f = resourceId;
        if (status == 3) {
            j(iW);
            y().cancel(i11);
            return;
        }
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.f(aVar2, "download_notify", "updateCustomView--- 2, status = " + status + "， name = " + downloadInfo.getTotalTitleName(), false, 4, null);
        DownloadGuard.f60987a.n(downloadInfo);
        if (status == 6 && (downloadInfo.isNoNetError() || !com.tn.lib.util.networkinfo.f.f49475a.e())) {
            uo.b.a.f(aVar2, "download_notify", "updateCustomView--- 无网错误不出通知", false, 4, null);
            j(iW);
            y().cancel(i11);
            return;
        }
        String strS = s(downloadInfo);
        if (status == 1 || status == 2) {
            y().cancel(i11);
            return;
        }
        if (status == 5) {
            n(this, downloadInfo, false, null, null, 14, null);
            return;
        }
        if (status == 7 || status == 57) {
            j(iW);
            y().cancel(i11);
            return;
        }
        j(iW);
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), r());
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_status, A(downloadInfo.getStatus()));
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_name, strS);
        NotificationCompat.m mVarV = v(i11, downloadInfo);
        if (mVarV != null) {
            try {
                mVarV.l(true);
                mVarV.t(remoteViews).s(remoteViews);
                uo.b.a.s(aVar2, "download_notify", "updateCustomView--- 3, status = " + status + "， name = " + downloadInfo.getTotalTitleName(), false, 4, null);
                NotificationManagerCompat.from(Utils.a()).notify(i11, mVarV.c());
            } catch (Throwable unused) {
            }
        }
    }

    public final void j(int i11) {
        y().cancel(i11);
    }

    public final boolean k() {
        boolean zF = h0.f(NotificationMMKVUtil.f57030a.a().getLong("download_play_notification_time", 0L));
        int i11 = Calendar.getInstance().get(11);
        return 19 <= i11 && i11 < 21 && !zF;
    }

    public final void l(DownloadBean downloadInfo) {
        String value;
        Boolean boolY0;
        Intrinsics.g(downloadInfo, "downloadInfo");
        boolean zBooleanValue = false;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("download_foreground_service", false);
        if (configBeanB != null && (value = configBeanB.getValue()) != null && (boolY0 = StringsKt__StringsKt.Y0(value)) != null) {
            zBooleanValue = boolY0.booleanValue();
        }
        f61070c = zBooleanValue;
        j.d(l0.a(w0.c()), null, null, new DownloadNotificationUtils$createNotification$1(downloadInfo, null), 3, null);
    }

    public final void m(DownloadBean downloadBean, boolean z11, String str, String str2) {
        try {
            RequestBuilder requestBuilderDiskCacheStrategy = Glide.with(Utils.a()).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA);
            NotificationUtil notificationUtil = NotificationUtil.f57032a;
            String cover = downloadBean.getCover();
            if (cover == null) {
                cover = "";
            }
            requestBuilderDiskCacheStrategy.load(notificationUtil.E(cover)).into(new a(downloadBean, z11, str, str2));
        } catch (Exception unused) {
            uo.b.a.f(uo.b.f78622a, "DownloadNotificationUtils", "onFailure", false, 4, null);
        }
    }

    public final void o(DownloadBean downloadBean) {
    }

    public final PendingIntent p(IPushProvider iPushProvider, int i11, DownloadBean downloadBean, int i12) {
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.putExtra("extra_notification_id", i11);
        intentD1.putExtra("extra_source", MsgStyle.SOURCE_PUSH);
        intentD1.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        intentD1.putExtra("extra_message_id", sb2.toString());
        intentD1.addFlags(603979776);
        intentD1.setAction("android.intent.action.VIEW");
        intentD1.setData(Uri.parse("oneroom://com.community.oneroom?type=/movie/detail&id=" + downloadBean.getSubjectId() + "&autoPlay=true&resourceId=" + downloadBean.getResourceId()));
        return PendingIntent.getActivity(Utils.a(), 0, intentD1, i12);
    }

    public final PendingIntent q(IPushProvider iPushProvider, int i11, DownloadBean downloadBean, int i12) {
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.putExtra("extra_notification_id", i11);
        intentD1.putExtra("extra_source", MsgStyle.SOURCE_PUSH);
        intentD1.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        intentD1.putExtra("extra_message_id", sb2.toString());
        intentD1.addFlags(603979776);
        intentD1.setAction("android.intent.action.VIEW");
        intentD1.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity&download_notify=10&download_status=" + downloadBean.getStatus()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, intentD1, i12);
        Intrinsics.f(activity, "getActivity(Utils.getApp…notificationIntent, flag)");
        return activity;
    }

    public final int r() {
        return Build.VERSION.SDK_INT < 31 ? com.transsnet.downloader.R$layout.notification_other_status : com.transsnet.downloader.R$layout.notification_other_status_v12;
    }

    public final String s(DownloadBean downloadBean) {
        String strB;
        String subjectName = downloadBean.isSeries() ? downloadBean.getSubjectName() : downloadBean.getName();
        if (downloadBean.getEpse() > 0) {
            strB = downloadBean.getEp() > 0 ? l.b(downloadBean.getEp(), downloadBean.getSe(), downloadBean.isVideo()) : l.c(downloadBean.getEpse(), downloadBean.isVideo());
        } else {
            strB = "";
        }
        return subjectName + " " + strB;
    }

    public final int t() {
        return Build.VERSION.SDK_INT < 31 ? com.transsnet.downloader.R$layout.notification_downloading : com.transsnet.downloader.R$layout.notification_downloading_v12;
    }

    public final void u() {
        j.d(l0.a(w0.b()), null, null, new DownloadNotificationUtils$getLatestDownloadVideo$1(null), 3, null);
    }

    public final NotificationCompat.m v(int i11, DownloadBean downloadBean) {
        Long size;
        int i12 = Build.VERSION.SDK_INT >= 31 ? 67108864 : ASTNode.NOJIT;
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        if (iPushProvider == null) {
            return null;
        }
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        intentD1.putExtra("extra_notification_id", sb2.toString());
        intentD1.putExtra("extra_source", MsgStyle.SOURCE_PUSH);
        intentD1.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i11);
        intentD1.putExtra("extra_message_id", sb3.toString());
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity&download_notify=10&download_status=" + downloadBean.getStatus()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, intentD1, i12);
        String strS = s(downloadBean);
        long jLongValue = 0;
        long progress = downloadBean.getProgress() < 0 ? 0L : downloadBean.getProgress();
        Long size2 = downloadBean.getSize();
        if ((size2 != null ? size2.longValue() : 0L) >= 0 && (size = downloadBean.getSize()) != null) {
            jLongValue = size.longValue();
        }
        float progress2 = downloadBean.getProgress() * 1.0f;
        Long size3 = downloadBean.getSize();
        int iLongValue = (int) ((progress2 / (size3 != null ? size3.longValue() : 1L)) * 100);
        if (iLongValue > 100) {
            iLongValue = 100;
        }
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), t());
        remoteViews.setProgressBar(com.transsnet.downloader.R$id.progress, 100, iLongValue, false);
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_name, strS);
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_size, tp.a.a(progress, 1) + "/" + tp.a.a(jLongValue, 1));
        NotificationCompat.m mVarS = new NotificationCompat.m(Utils.a(), "download_service").K(R$drawable.push_small_logo).r(A(downloadBean.getStatus())).q(strS).p(activity).l(false).t(remoteViews).s(remoteViews);
        Intrinsics.f(mVarS, "Builder(Utils.getApp(), …stomBigContentView(views)");
        return mVarS;
    }

    public final int w(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        return x(downloadInfo.getUrl(), downloadInfo.getResourceId());
    }

    public final int x(String url, String str) {
        Intrinsics.g(url, "url");
        if (str == null) {
            str = url;
        }
        int iAbs = Math.abs(str.hashCode());
        return iAbs <= 0 ? Math.abs(url.hashCode()) : iAbs;
    }

    public final NotificationManager y() {
        return (NotificationManager) f61071d.getValue();
    }

    public final PendingIntent z(IPushProvider iPushProvider, int i11, DownloadBean downloadBean, int i12) {
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.putExtra("extra_notification_id", i11);
        intentD1.putExtra("extra_source", MsgStyle.SOURCE_PUSH);
        intentD1.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        intentD1.putExtra("extra_message_id", sb2.toString());
        intentD1.addFlags(603979776);
        intentD1.setAction("android.intent.action.VIEW");
        StringBuilder sb3 = new StringBuilder("oneroom://com.community.oneroom?type=");
        if (downloadBean.isShotTV()) {
            sb3.append("/shorts/detail");
            sb3.append("&");
            sb3.append("id");
            sb3.append("=");
            sb3.append(downloadBean.getSubjectId());
            sb3.append("&");
            sb3.append("ep");
            sb3.append("=");
            sb3.append(downloadBean.getEp());
        } else {
            sb3.append("/video/detail");
            sb3.append("&");
            sb3.append("extra_local_path");
            sb3.append("=");
            sb3.append(downloadBean.getPath());
            sb3.append("&");
            sb3.append("extra_name");
            sb3.append("=");
            sb3.append(downloadBean.getName());
            sb3.append("&");
            sb3.append("extra_resource_id");
            sb3.append("=");
            sb3.append(downloadBean.getResourceId());
            sb3.append("&");
            sb3.append("extra_post_id");
            sb3.append("=");
            sb3.append(downloadBean.getPostId());
            sb3.append("&");
            sb3.append("extra_subject_id");
            sb3.append("=");
            sb3.append(downloadBean.getSubjectId());
            sb3.append("&");
            sb3.append("extra_page_from");
            sb3.append("=");
            sb3.append(MsgStyle.SOURCE_PUSH);
            sb3.append("&");
            sb3.append("extra_is_series");
            sb3.append("=");
            sb3.append(downloadBean.isSeries());
        }
        intentD1.setData(Uri.parse(sb3.toString()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, intentD1, i12);
        Intrinsics.f(activity, "getActivity(Utils.getApp…notificationIntent, flag)");
        return activity;
    }
}
