package com.transsion.player.mediasession;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.d0;
import androidx.media.session.MediaButtonReceiver;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.player.R$mipmap;
import com.transsion.player.R$string;
import com.transsion.player.utils.e;
import k1.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f54614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static MediaSessionCompat f54615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static MediaService f54616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static MediaItem f54617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Integer f54618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Bitmap f54619g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f54613a = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f54620h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f54621i = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends CustomTarget<Bitmap> {
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            d.f54622a.a(c.f54613a.i() + " --> loadAlbum --> onLoadCleared() ---> 加载失败");
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            d dVar = d.f54622a;
            c cVar = c.f54613a;
            dVar.a(cVar.i() + " --> loadAlbum --> onLoadFailed() ---> 加载失败");
            c.f54619g = BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_notification_icon);
            cVar.o(c.f54616d, c.f54617e, c.f54618f, c.f54615c);
        }

        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            Intrinsics.g(resource, "resource");
            String str = c.f54620h;
            MediaItem mediaItem = c.f54617e;
            if (TextUtils.equals(str, mediaItem != null ? mediaItem.getCoverUrl() : null)) {
                c.f54619g = resource;
                c.f54613a.o(c.f54616d, c.f54617e, c.f54618f, c.f54615c);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }
    }

    public final Bitmap h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return q(str);
    }

    public final String i() {
        String simpleName = c.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final int j() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    public final String k(String str) {
        return e.f54871a.b(str, f0.a(48.0f), (120 & 4) != 0 ? true : true, (120 & 8) != 0, (120 & 16) != 0 ? 0 : 0, (120 & 32) != 0 ? false : false, (120 & 64) != 0 ? false : false);
    }

    public final void l() {
        d.f54622a.a(i() + " --> initNotificationChannel() --> 初始化 通知的 渠道");
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            z.a();
            NotificationChannel notificationChannelA = h.a("MUSIC_NOTIFICATION_ID", Utils.a().getString(R$string.player_notification_name), 3);
            notificationChannelA.setSound(null, null);
            notificationChannelA.setDescription("playing media");
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        MusicNotificationBroadcastReceiver.f54608a.b();
    }

    public final void m(MediaService mediaService, MediaItem mediaItem, Integer num, MediaSessionCompat mediaSessionCompat) {
        f54616d = mediaService;
        f54617e = mediaItem;
        f54618f = num;
        f54615c = mediaSessionCompat;
        n();
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Object systemService = null;
        NotificationCompat.m mVarQ = new NotificationCompat.m(applicationA, "MUSIC_NOTIFICATION_ID").r(mediaItem != null ? mediaItem.getTitle() : null).q(mediaItem != null ? mediaItem.getSubTitle() : null);
        Intrinsics.f(mVarQ, "Builder(context, CHANNEL…Text(mediaItem?.subTitle)");
        Bitmap bitmap = f54619g;
        if (bitmap == null) {
            mVarQ.B(BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_push_small_logo));
        } else {
            mVarQ.B(bitmap);
        }
        mVarQ.v(MusicNotificationBroadcastReceiver.f54608a.a());
        mVarQ.p(mediaItem != null ? mediaItem.getPendingIntent() : null);
        mVarQ.P(1);
        if (num != null && num.intValue() == 3) {
            mVarQ.b(new NotificationCompat.b.a(R$mipmap.player_pause, "pause", MediaButtonReceiver.a(applicationA, 2L)).a());
        } else {
            mVarQ.b(new NotificationCompat.b.a(R$mipmap.player_play, MediaItem.MUSIC_FLOAT_STATE_PLAY, MediaButtonReceiver.a(applicationA, 4L)).a());
        }
        v3.c cVar = new v3.c();
        MediaSessionCompat mediaSessionCompat2 = f54615c;
        mVarQ.M(cVar.q(mediaSessionCompat2 != null ? mediaSessionCompat2.getSessionToken() : null).r(0));
        mVarQ.K(R$mipmap.player_ic_push_small_logo);
        Notification notificationC = mVarQ.c();
        Intrinsics.f(notificationC, "builder.build()");
        notificationC.flags = 224;
        if (f54614b) {
            if (mediaService != null) {
                try {
                    systemService = mediaService.getSystemService("notification");
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).notify(89757, notificationC);
            return;
        }
        if (!com.blankj.utilcode.util.c.j()) {
            d.f54622a.b("Service is restricted, cannot start foreground.");
            return;
        }
        if (mediaService != null) {
            try {
                mediaService.startForeground(89757, notificationC);
            } catch (Throwable th3) {
                th3.printStackTrace();
                try {
                    Object systemService2 = mediaService.getSystemService("notification");
                    Intrinsics.e(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
                    ((NotificationManager) systemService2).notify(89757, notificationC);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        }
        f54614b = true;
    }

    public final void n() {
        Object objM163constructorimpl;
        String coverUrl;
        MediaItem mediaItem = f54617e;
        String coverUrl2 = mediaItem != null ? mediaItem.getCoverUrl() : null;
        if (TextUtils.isEmpty(coverUrl2) || TextUtils.equals(f54620h, coverUrl2)) {
            return;
        }
        f54620h = coverUrl2;
        if (coverUrl2 != null && StringsKt__StringsKt.Q(coverUrl2, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            f54619g = null;
            RequestBuilder requestBuilderDiskCacheStrategy = Glide.with(Utils.a()).asBitmap().centerInside().diskCacheStrategy(DiskCacheStrategy.DATA);
            MediaItem mediaItem2 = f54617e;
            if (mediaItem2 == null || (coverUrl = mediaItem2.getCoverUrl()) == null) {
                coverUrl = "";
            }
            requestBuilderDiskCacheStrategy.load(k(coverUrl)).into(f54621i);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            f54619g = f54613a.h(f54620h);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            f54619g = BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_push_small_logo);
        }
        m(f54616d, f54617e, f54618f, f54615c);
    }

    public final void o(MediaService mediaService, MediaItem mediaItem, Integer num, MediaSessionCompat mediaSessionCompat) {
        if (mediaItem != null) {
            m(mediaService, mediaItem, num, mediaSessionCompat);
            return;
        }
        d.f54622a.b(i() + " --> notifyNotification() --> mediaItem == null --> return");
        p();
    }

    public final void p() {
        MediaService mediaService = f54616d;
        if (mediaService != null) {
            d0.a(mediaService, 1);
        }
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(89757);
        f54614b = false;
    }

    public final Bitmap q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iA = f0.a(48.0f);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int iRound = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i11 = options.outWidth;
            int i12 = options.outHeight;
            if (i11 <= iA && i12 <= iA) {
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeFile(str, options);
            }
            if (i12 > iA || i11 > iA) {
                float f11 = iA;
                iRound = Math.round(kotlin.ranges.a.c(i12 / f11, i11 / f11));
            }
            options.inSampleSize = iRound;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final void r(boolean z11) {
        f54614b = z11;
    }
}
