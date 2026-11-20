package com.transsnet.downloader.guard;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$drawable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
public final class DownloadGuardService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Binder f60993a = new Binder();

    public final Notification a() {
        Notification notificationC = new NotificationCompat.m(Utils.a(), DownloadGuard.f60987a.d()).K(R$drawable.push_small_logo).F(true).l(false).G(true).c();
        Intrinsics.f(notificationC, "Builder(\n            Uti…rue)\n            .build()");
        return notificationC;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f60993a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        try {
            Result.Companion companion = Result.Companion;
            int intExtra = intent != null ? intent.getIntExtra("id", 10086) : 10086;
            int i13 = Build.VERSION.SDK_INT;
            if (i13 < 29 && i13 >= 26) {
                startForeground(intExtra, a());
            } else {
                NotificationManagerCompat.from(Utils.a()).notify(intExtra, a());
            }
            Result.m163constructorimpl(Unit.f68710a);
            return 1;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
            return 1;
        }
    }
}
