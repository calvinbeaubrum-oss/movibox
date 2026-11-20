package com.transsion.push.helper;

import android.app.Application;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.service.notification.StatusBarNotification;
import androidx.annotation.RequiresApi;
import com.transsion.baselib.db.notification.MsgBean;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import uo.b;

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
public final class NotificationRefreshService extends Service {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f56881i = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NotificationManager f56883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f56884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f56885d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SoftReference<MsgBean>> f56882a = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f56886f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotificationRefreshService$localReceiver$1 f56887g = new BroadcastReceiver() { // from class: com.transsion.push.helper.NotificationRefreshService$localReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MsgBean msgBean = intent != null ? (MsgBean) intent.getParcelableExtra("newMsg") : null;
            b.f78622a.c("NoticeRefreshHelper", "receive message: " + msgBean, true);
            this.f56889a.e(msgBean);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @RequiresApi(23)
    public final NotificationRefreshService$runnable$1 f56888h = new Runnable() { // from class: com.transsion.push.helper.NotificationRefreshService$runnable$1
        @Override // java.lang.Runnable
        public void run() {
            StatusBarNotification[] activeNotifications;
            StatusBarNotification statusBarNotification;
            k.G(this.this$0.f56882a, new Function1<SoftReference<MsgBean>, Boolean>() { // from class: com.transsion.push.helper.NotificationRefreshService$runnable$1$run$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SoftReference<MsgBean> it) {
                    Intrinsics.g(it, "it");
                    return Boolean.valueOf(it.get() == null);
                }
            });
            try {
                NotificationManager notificationManager = this.this$0.f56883b;
                activeNotifications = notificationManager != null ? notificationManager.getActiveNotifications() : null;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            b.a aVar = b.f78622a;
            Integer numValueOf = activeNotifications != null ? Integer.valueOf(activeNotifications.length) : null;
            b.a.f(aVar, "NoticeRefreshHelper", "onRepeat, currentNotifications: " + numValueOf + " msgList: " + this.this$0.f56882a.size(), false, 4, null);
            int length = activeNotifications != null ? activeNotifications.length : 0;
            for (int i11 = 0; i11 < length; i11++) {
                Integer numValueOf2 = (activeNotifications == null || (statusBarNotification = activeNotifications[i11]) == null) ? null : Integer.valueOf(statusBarNotification.getId());
                Iterator it = this.this$0.f56882a.iterator();
                MsgBean msgBean = null;
                while (it.hasNext()) {
                    MsgBean msgBean2 = (MsgBean) ((SoftReference) it.next()).get();
                    if (msgBean2 != null) {
                        int iK = NotificationShowHelper.f56890a.k(msgBean2);
                        if (numValueOf2 != null && iK == numValueOf2.intValue()) {
                            msgBean2.setRefresh(true);
                            Application applicationA = com.tn.lib.util.a.f49452a.a();
                            if (applicationA != null) {
                                PushMsgHelper.f56891a.c(applicationA, msgBean2);
                            }
                        }
                    }
                    if (msgBean2 != null && msgBean2.isPermanent()) {
                        int iN = NotificationShowHelper.f56890a.n();
                        if (numValueOf2 != null && iN == numValueOf2.intValue()) {
                            msgBean = msgBean2;
                        }
                    }
                }
                if (msgBean != null) {
                    msgBean.setRefresh(true);
                    Application applicationA2 = com.tn.lib.util.a.f49452a.a();
                    if (applicationA2 != null) {
                        PushMsgHelper.f56891a.c(applicationA2, msgBean);
                    }
                }
            }
            Handler handler = this.this$0.f56884c;
            if (handler != null) {
                handler.postDelayed(this, 30000L);
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends Binder {
    }

    public final void e(MsgBean msgBean) {
        String messageId;
        if (msgBean == null || (messageId = msgBean.getMessageId()) == null || messageId.length() == 0) {
            return;
        }
        Object obj = null;
        if (msgBean.isPermanent()) {
            for (Object obj2 : this.f56882a) {
                MsgBean msgBean2 = (MsgBean) ((SoftReference) obj2).get();
                if (msgBean2 != null && msgBean2.isPermanent()) {
                    obj = obj2;
                    break;
                }
            }
            SoftReference softReference = (SoftReference) obj;
            if (softReference != null) {
                this.f56882a.remove(softReference);
            }
            this.f56882a.add(new SoftReference<>(msgBean));
            return;
        }
        for (Object obj3 : this.f56882a) {
            String messageId2 = msgBean.getMessageId();
            MsgBean msgBean3 = (MsgBean) ((SoftReference) obj3).get();
            if (Intrinsics.b(messageId2, msgBean3 != null ? msgBean3.getMessageId() : null)) {
                obj = obj3;
                break;
            }
        }
        if (obj == null) {
            this.f56882a.add(new SoftReference<>(msgBean));
        }
        if (this.f56882a.size() >= 4) {
            MsgBean msgBean4 = this.f56882a.get(0).get();
            if (msgBean4 == null || !msgBean4.isPermanent()) {
                this.f56882a.remove(0);
            } else {
                this.f56882a.remove(1);
            }
        }
    }

    public final void f() {
        if (Build.VERSION.SDK_INT < 26 || this.f56885d) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "NoticeRefreshHelper", "startRepeat", false, 4, null);
        if (this.f56883b == null) {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            Object systemService = applicationA != null ? applicationA.getSystemService("notification") : null;
            this.f56883b = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        }
        if (this.f56884c == null) {
            this.f56884c = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.f56884c;
        if (handler != null) {
            handler.removeCallbacks(this.f56888h);
        }
        Handler handler2 = this.f56884c;
        if (handler2 != null) {
            handler2.postDelayed(this.f56888h, 30000L);
        }
        this.f56885d = true;
    }

    public final void g() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f56885d = false;
            Handler handler = this.f56884c;
            if (handler != null) {
                handler.removeCallbacks(this.f56888h);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f56886f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f();
        IntentFilter intentFilter = new IntentFilter(getPackageName());
        intentFilter.addAction("ACTION_NEW_MESSAGE");
        u3.a.b(this).c(this.f56887g, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        g();
        u3.a.b(this).e(this.f56887g);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        return 1;
    }
}
