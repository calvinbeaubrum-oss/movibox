package com.transsion.player.helper;

import android.app.NotificationManager;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class AppVolumeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppVolumeManager f54318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f54319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f54320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f54321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f54322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f54323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f54324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f54325h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z11, Uri uri) {
            super.onChange(z11, uri);
            AppVolumeManager.f54318a.b();
        }
    }

    static {
        AppVolumeManager appVolumeManager = new AppVolumeManager();
        f54318a = appVolumeManager;
        f54319b = true;
        f54320c = 200;
        f54321d = 100;
        f54322e = 15;
        f54323f = 100;
        f54324g = LazyKt__LazyJVMKt.b(new Function0<AudioManager>() { // from class: com.transsion.player.helper.AppVolumeManager$mAudioManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AudioManager invoke() {
                Object systemService = Utils.a().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                Intrinsics.e(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                return (AudioManager) systemService;
            }
        });
        f54325h = LazyKt__LazyJVMKt.b(new Function0<NotificationManager>() { // from class: com.transsion.player.helper.AppVolumeManager$notificationManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NotificationManager invoke() {
                Object systemService = Utils.a().getSystemService("notification");
                Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                return (NotificationManager) systemService;
            }
        });
        Utils.a().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, new a(new Handler()));
        f54322e = appVolumeManager.d().getStreamMaxVolume(3);
        appVolumeManager.f();
    }

    public final void a(int i11, float f11) {
        float f12 = (i11 + f11) / 100.0f;
        int i12 = f54322e;
        int i13 = (int) (f12 * i12);
        if (i13 <= 0) {
            i12 = 0;
        } else if (i13 < i12) {
            i12 = i13;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("preVolume:");
        sb2.append(i11);
        sb2.append(", volume:");
        sb2.append(i12);
        try {
            if (d().isVolumeFixed() && !f54319b) {
                return;
            }
            d().setStreamVolume(3, i12, 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void b() {
        int streamVolume = d().getStreamVolume(3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkCurVolume volume:");
        sb2.append(streamVolume);
        if (streamVolume < f54322e) {
            int i11 = f54323f;
            int i12 = f54322e;
            int i13 = f54321d;
            if ((i11 * i12) / i13 != streamVolume) {
                f54323f = (streamVolume * i13) / i12;
            }
        }
    }

    public final int c() {
        return f54323f;
    }

    public final AudioManager d() {
        return (AudioManager) f54324g.getValue();
    }

    public final NotificationManager e() {
        return (NotificationManager) f54325h.getValue();
    }

    public final void f() {
        f54319b = Build.VERSION.SDK_INT >= 23 ? e().isNotificationPolicyAccessGranted() : true;
        int streamVolume = d().getStreamVolume(3);
        f54323f = (f54321d * streamVolume) / f54322e;
        int i11 = f54323f;
        int i12 = f54322e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("curVolume:");
        sb2.append(i11);
        sb2.append(", volume:");
        sb2.append(streamVolume);
        sb2.append(" system:");
        sb2.append(i12);
    }

    public final int g(int i11) {
        int iD = kotlin.ranges.a.d(kotlin.ranges.a.g(f54323f + i11, f54320c), 0);
        if (iD <= f54321d) {
            a(f54323f, i11);
        }
        f54323f = iD;
        return iD;
    }
}
