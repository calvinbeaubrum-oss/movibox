package com.transsion.player.mediasession;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class MediaService extends MediaBrowserServiceCompat {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f54607k = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.e f(String clientPackageName, int i11, Bundle bundle) {
        Intrinsics.g(clientPackageName, "clientPackageName");
        return new MediaBrowserServiceCompat.e("media_service_id", null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void g(String parentId, MediaBrowserServiceCompat.k<List<MediaBrowserCompat.MediaItem>> result) {
        Intrinsics.g(parentId, "parentId");
        Intrinsics.g(result, "result");
        result.f(null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat, android.app.Service
    public void onCreate() {
        super.onCreate();
        d.f54622a.a(s() + " --> onCreate()");
        c.f54613a.l();
        t();
    }

    @Override // androidx.media.MediaBrowserServiceCompat, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d.f54622a.b(s() + " --> onDestroy() --> 服务销毁的时候停止通知");
    }

    public final String s() {
        String simpleName = MediaService.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void t() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this, "media_service_id");
            mediaSessionCompat.setActive(true);
            mediaSessionCompat.setPlaybackState(new PlaybackStateCompat.Builder().setActions(775L).build());
            mediaSessionCompat.setCallback(new com.transsion.player.mediasession.a(mediaSessionCompat, this));
            r(mediaSessionCompat.getSessionToken());
            mediaSessionCompat.setMediaButtonReceiver(PendingIntent.getBroadcast(this, 1, new Intent(this, (Class<?>) MusicIntentReceiver.class), c.f54613a.j()));
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        d.f54622a.b(s() + " --> initMediaSessionCompat() --> it = " + thM166exceptionOrNullimpl);
    }
}
