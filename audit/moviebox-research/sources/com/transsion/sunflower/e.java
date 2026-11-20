package com.transsion.sunflower;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import k1.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f58389d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NotificationChannel f58392c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i11) {
            Intrinsics.g(context, "context");
            Object systemService = context.getSystemService("notification");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            try {
                ((NotificationManager) systemService).cancel(i11);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public e(Context context, String channelId, String channelName) {
        Intrinsics.g(context, "context");
        Intrinsics.g(channelId, "channelId");
        Intrinsics.g(channelName, "channelName");
        this.f58390a = channelId;
        this.f58391b = channelName;
        if (Build.VERSION.SDK_INT >= 26) {
            z.a();
            NotificationChannel notificationChannelA = h.a(channelId, channelName, 4);
            this.f58392c = notificationChannelA;
            notificationChannelA.setSound(null, null);
            NotificationChannel notificationChannel = this.f58392c;
            if (notificationChannel != null) {
                notificationChannel.enableVibration(false);
            }
            NotificationChannel notificationChannel2 = this.f58392c;
            if (notificationChannel2 != null) {
                notificationChannel2.setLockscreenVisibility(-1);
            }
            Object systemService = context.getSystemService("notification");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationChannel notificationChannel3 = this.f58392c;
            Intrinsics.d(notificationChannel3);
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel3);
        }
    }

    public final void a(Context context, NotificationCompat.m builder, PendingIntent pendingIntent, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(builder, "builder");
        builder.y(pendingIntent, true);
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            notificationManager.cancel(i11);
            notificationManager.notify(i11, builder.c());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
