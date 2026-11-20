package com.transsion.player.mediasession;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MusicNotificationBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f54608a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PendingIntent a() {
            Intent intent = new Intent(Utils.a(), (Class<?>) MusicNotificationBroadcastReceiver.class);
            intent.setAction("com.transsion.player.mediasession.NotificationUtil.DeleteIntent");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(Utils.a(), 0, intent, 201326592);
            Intrinsics.f(pendingIntent, "pendingIntent");
            return pendingIntent;
        }

        @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
        public final void b() {
            MusicNotificationBroadcastReceiver musicNotificationBroadcastReceiver = new MusicNotificationBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter("com.transsion.player.mediasession.NotificationUtil.DeleteIntent");
            if (Build.VERSION.SDK_INT >= 33) {
                Utils.a().registerReceiver(musicNotificationBroadcastReceiver, intentFilter, 4);
            } else {
                Utils.a().registerReceiver(musicNotificationBroadcastReceiver, intentFilter);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.g(context, "context");
        String action = intent != null ? intent.getAction() : null;
        if (action != null && action.hashCode() == -1731612133 && action.equals("com.transsion.player.mediasession.NotificationUtil.DeleteIntent")) {
            f fVarB = TnPlayerManager.f54684a.b();
            if (fVarB != null) {
                fVarB.release();
            }
            c.f54613a.r(false);
        }
    }
}
