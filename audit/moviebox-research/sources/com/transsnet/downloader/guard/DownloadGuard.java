package com.transsnet.downloader.guard;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.l;
import com.transsion.push.api.IPushProvider;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import k1.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;
import uo.b;
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
public final class DownloadGuard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadGuard f60987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f60988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f60989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<Integer, String> f60990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final NotificationManager f60991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map<Integer, Long> f60992f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Intrinsics.g(name, "name");
            Intrinsics.g(service, "service");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Intrinsics.g(name, "name");
        }
    }

    static {
        DownloadGuard downloadGuard = new DownloadGuard();
        f60987a = downloadGuard;
        f60989c = LazyKt__LazyJVMKt.b(new Function0<k0>() { // from class: com.transsnet.downloader.guard.DownloadGuard$coroutineScopeIO$2
            @Override // kotlin.jvm.functions.Function0
            public final k0 invoke() {
                return l0.a(w0.b());
            }
        });
        f60990d = new LinkedHashMap();
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        f60991e = notificationManager;
        if (Build.VERSION.SDK_INT >= 26) {
            z.a();
            notificationManager.createNotificationChannel(h.a(downloadGuard.d(), Utils.a().getString(R$string.download_notifications_name), 2));
        }
        com.transsion.ad.a.h(com.transsion.ad.a.f50276a, "DownloadGuard --> init{} --> 初始化配置， isOpen:true", false, 2, null);
        f60992f = new LinkedHashMap();
    }

    public final k0 c() {
        return (k0) f60989c.getValue();
    }

    public final String d() {
        return "download_service";
    }

    public final int e() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.notification_download_complete : R$layout.notification_download_complete_v12;
    }

    public final String f(DownloadBean downloadBean) {
        String strB;
        String subjectName = downloadBean.isSeries() ? downloadBean.getSubjectName() : downloadBean.getName();
        if (downloadBean.getEpse() > 0) {
            strB = downloadBean.getEp() > 0 ? l.b(downloadBean.getEp(), downloadBean.getSe(), downloadBean.isVideo()) : l.c(downloadBean.getEpse(), downloadBean.isVideo());
        } else {
            strB = "";
        }
        return subjectName + " " + strB;
    }

    public final int g() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.notification_downloading : R$layout.notification_downloading_v12;
    }

    public final NotificationCompat.m h(DownloadBean downloadBean) {
        Long size;
        int i11 = Build.VERSION.SDK_INT >= 31 ? 67108864 : ASTNode.NOJIT;
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        if (iPushProvider == null) {
            return null;
        }
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        DownloadGuard downloadGuard = f60987a;
        int i12 = downloadGuard.i(downloadBean);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i12);
        intentD1.putExtra("extra_notification_id", sb2.toString());
        intentD1.putExtra("extra_source", MsgStyle.SOURCE_PUSH);
        intentD1.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        int i13 = downloadGuard.i(downloadBean);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i13);
        intentD1.putExtra("extra_message_id", sb3.toString());
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity&download_notify=10&download_status=" + downloadBean.getStatus()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, intentD1, i11);
        String strF = f(downloadBean);
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
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), g());
        remoteViews.setProgressBar(R$id.progress, 100, iLongValue, false);
        remoteViews.setTextViewText(R$id.tv_name, downloadBean.getTitleName());
        remoteViews.setTextViewText(R$id.tv_epse, downloadBean.getEpName());
        remoteViews.setTextViewText(R$id.tv_size, i.b(progress, 1) + "/" + i.b(jLongValue, 1));
        return new NotificationCompat.m(Utils.a(), d()).K(R$drawable.push_small_logo).q(strF).p(activity).l(false).t(remoteViews).F(true).l(false).G(true).s(remoteViews);
    }

    public final int i(DownloadBean downloadBean) {
        return j(downloadBean.getUrl(), downloadBean.getResourceId());
    }

    public final int j(String str, String str2) {
        if (str2 == null) {
            str2 = str;
        }
        int iAbs = Math.abs(str2.hashCode());
        return iAbs <= 0 ? Math.abs(str.hashCode()) : iAbs;
    }

    public final void k(DownloadBean downloadBean) {
        com.transsion.ad.a.h(com.transsion.ad.a.f50276a, "DownloadGuard --> otherStatus()", false, 2, null);
        int i11 = i(downloadBean);
        f60990d.remove(Integer.valueOf(i11));
        f60991e.cancel(i11);
        try {
            j.d(c(), null, null, new DownloadGuard$otherStatus$1(downloadBean, null), 3, null);
        } catch (Throwable th2) {
            b.a.f(b.f78622a, "notify", "DownloadGuard {" + th2 + "}", false, 4, null);
        }
    }

    public final void l(DownloadBean downloadBean) {
        int i11 = i(downloadBean);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l11 = f60992f.get(Integer.valueOf(i11));
        if (jElapsedRealtime - (l11 != null ? l11.longValue() : 0L) < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            return;
        }
        f60992f.put(Integer.valueOf(i11), Long.valueOf(jElapsedRealtime));
        try {
            j.d(c(), null, null, new DownloadGuard$progress$1(downloadBean, i11, null), 3, null);
        } catch (Throwable th2) {
            b.a.f(b.f78622a, "notify", "DownloadGuard {" + th2 + "}", false, 4, null);
        }
    }

    public final void m(int i11) {
        try {
            Intent intent = new Intent();
            intent.setClass(Utils.a(), DownloadGuardService.class);
            intent.putExtra("id", i11);
            if (Build.VERSION.SDK_INT >= 26) {
                com.transsion.ad.a.h(com.transsion.ad.a.f50276a, "DownloadGuard --> ForegroundService >= 8，bindService", false, 2, null);
                Utils.a().bindService(intent, new a(), 1);
            } else {
                com.transsion.ad.a.h(com.transsion.ad.a.f50276a, "DownloadGuard --> ForegroundService < 8，startService", false, 2, null);
                Utils.a().startService(intent);
            }
        } catch (Throwable th2) {
            com.transsion.ad.a.j(com.transsion.ad.a.f50276a, "DownloadGuard --> startForegroundService() --> e = " + th2, false, 2, null);
        }
        f60988b = true;
    }

    public final void n(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        int i11 = i(downloadInfo);
        boolean zContainsKey = f60990d.containsKey(Integer.valueOf(i11));
        f60991e.cancel(10086);
        if (!zContainsKey) {
            f60990d.put(Integer.valueOf(i11), "");
            m(i11);
        } else {
            int status = downloadInfo.getStatus();
            if (status == 1 || status == 2) {
                l(downloadInfo);
            } else {
                k(downloadInfo);
            }
        }
    }
}
