package com.transsion.player.mediasession;

import android.app.Application;
import android.content.ComponentName;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MediaBrowserCompatHelper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f54597h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<MediaBrowserCompatHelper> f54598i = LazyKt__LazyJVMKt.b(new Function0<MediaBrowserCompatHelper>() { // from class: com.transsion.player.mediasession.MediaBrowserCompatHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MediaBrowserCompatHelper invoke() {
            return new MediaBrowserCompatHelper();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MediaBrowserCompat f54602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaControllerCompat f54603e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54605g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaBrowserCompat.SubscriptionCallback f54599a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaControllerCompat.Callback f54600b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaBrowserCompat.ConnectionCallback f54601c = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Function1<MediaControllerCompat.TransportControls, Unit>> f54604f = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaBrowserCompatHelper a() {
            return (MediaBrowserCompatHelper) MediaBrowserCompatHelper.f54598i.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b extends MediaBrowserCompat.ConnectionCallback {
        public b() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            String root;
            super.onConnected();
            try {
                try {
                    MediaBrowserCompat mediaBrowserCompat = MediaBrowserCompatHelper.this.f54602d;
                    if (mediaBrowserCompat != null && (root = mediaBrowserCompat.getRoot()) != null) {
                        MediaBrowserCompatHelper mediaBrowserCompatHelper = MediaBrowserCompatHelper.this;
                        MediaBrowserCompat mediaBrowserCompat2 = mediaBrowserCompatHelper.f54602d;
                        if (mediaBrowserCompat2 != null) {
                            mediaBrowserCompat2.unsubscribe(root);
                        }
                        MediaBrowserCompat mediaBrowserCompat3 = mediaBrowserCompatHelper.f54602d;
                        if (mediaBrowserCompat3 != null) {
                            mediaBrowserCompat3.subscribe(root, mediaBrowserCompatHelper.f54599a);
                        }
                    }
                    MediaBrowserCompatHelper mediaBrowserCompatHelper2 = MediaBrowserCompatHelper.this;
                    Application applicationA = Utils.a();
                    MediaBrowserCompat mediaBrowserCompat4 = MediaBrowserCompatHelper.this.f54602d;
                    Intrinsics.d(mediaBrowserCompat4);
                    mediaBrowserCompatHelper2.f54603e = new MediaControllerCompat(applicationA, mediaBrowserCompat4.getSessionToken());
                    MediaControllerCompat mediaControllerCompat = MediaBrowserCompatHelper.this.f54603e;
                    if (mediaControllerCompat != null) {
                        mediaControllerCompat.registerCallback(MediaBrowserCompatHelper.this.f54600b);
                    }
                    List<Function1> list = MediaBrowserCompatHelper.this.f54604f;
                    MediaBrowserCompatHelper mediaBrowserCompatHelper3 = MediaBrowserCompatHelper.this;
                    for (Function1 function1 : list) {
                        MediaControllerCompat mediaControllerCompat2 = mediaBrowserCompatHelper3.f54603e;
                        function1.invoke(mediaControllerCompat2 != null ? mediaControllerCompat2.getTransportControls() : null);
                    }
                    MediaBrowserCompatHelper.this.f54604f.clear();
                } catch (Exception e11) {
                    e11.printStackTrace();
                    com.transsion.player.mediasession.d.f54622a.a("mediaSource --> connectionCallback --> e = " + Log.getStackTraceString(e11));
                }
            } finally {
                MediaBrowserCompatHelper.this.f54605g = false;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            super.onConnectionFailed();
            MediaBrowserCompatHelper.this.f54605g = false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            super.onConnectionSuspended();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends MediaControllerCompat.Callback {
        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat metadata) {
            Intrinsics.g(metadata, "metadata");
            super.onMetadataChanged(metadata);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            super.onPlaybackStateChanged(playbackStateCompat);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends MediaBrowserCompat.SubscriptionCallback {
        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String parentId, List<? extends MediaBrowserCompat.MediaItem> children) {
            Intrinsics.g(parentId, "parentId");
            Intrinsics.g(children, "children");
            super.onChildrenLoaded(parentId, children);
            com.transsion.player.mediasession.d.f54622a.a("mediaSource --> subscriptionCallback --> onChildrenLoaded() --> parentId = " + parentId + " -- children = " + children);
        }
    }

    public final void k(Function1<? super MediaControllerCompat.TransportControls, Unit> function1) {
        Object objD;
        try {
            Result.Companion companion = Result.Companion;
            MediaBrowserCompat mediaBrowserCompat = this.f54602d;
            Object obj = null;
            if (mediaBrowserCompat != null && mediaBrowserCompat.isConnected()) {
                if (function1 != null) {
                    MediaControllerCompat mediaControllerCompat = this.f54603e;
                    function1.invoke(mediaControllerCompat != null ? mediaControllerCompat.getTransportControls() : null);
                    return;
                }
                return;
            }
            if (this.f54605g) {
                if (function1 != null) {
                    this.f54604f.add(function1);
                    return;
                }
                return;
            }
            this.f54605g = true;
            Application applicationA = Utils.a();
            if (applicationA != null) {
                Intrinsics.f(applicationA, "getApp()");
                if (ThreadUtils.i()) {
                    if (function1 != null) {
                        this.f54604f.add(function1);
                    }
                    MediaBrowserCompat mediaBrowserCompat2 = new MediaBrowserCompat(applicationA, new ComponentName(applicationA, (Class<?>) MediaService.class), this.f54601c, null);
                    this.f54602d = mediaBrowserCompat2;
                    mediaBrowserCompat2.connect();
                    objD = Unit.f68710a;
                } else {
                    objD = j.d(l0.a(w0.c()), null, null, new MediaBrowserCompatHelper$init$1$2$2(function1, this, applicationA, null), 3, null);
                }
                obj = objD;
            }
            Result.m163constructorimpl(obj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void l(final MediaItem mediaItem) {
        o(new Function1<MediaControllerCompat.TransportControls, Unit>() { // from class: com.transsion.player.mediasession.MediaBrowserCompatHelper$pause$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaControllerCompat.TransportControls transportControls) {
                invoke2(transportControls);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaControllerCompat.TransportControls transportControls) {
                if (transportControls != null) {
                    transportControls.sendCustomAction("transsion_pause", androidx.core.os.c.b(new Pair("MediaItem", mediaItem)));
                }
            }
        });
    }

    public final void m(final MediaItem mediaItem) {
        o(new Function1<MediaControllerCompat.TransportControls, Unit>() { // from class: com.transsion.player.mediasession.MediaBrowserCompatHelper$play$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaControllerCompat.TransportControls transportControls) {
                invoke2(transportControls);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaControllerCompat.TransportControls transportControls) {
                if (transportControls != null) {
                    transportControls.sendCustomAction("transsion_play", androidx.core.os.c.b(new Pair("MediaItem", mediaItem)));
                }
            }
        });
    }

    public final void n(String mediaId) {
        Intrinsics.g(mediaId, "mediaId");
    }

    public final void o(Function1<? super MediaControllerCompat.TransportControls, Unit> function1) {
        k(function1);
    }

    public final void p() {
        o(new Function1<MediaControllerCompat.TransportControls, Unit>() { // from class: com.transsion.player.mediasession.MediaBrowserCompatHelper$skipToNext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaControllerCompat.TransportControls transportControls) {
                invoke2(transportControls);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaControllerCompat.TransportControls transportControls) {
                if (transportControls != null) {
                    transportControls.skipToNext();
                }
            }
        });
    }

    public final void q() {
        o(new Function1<MediaControllerCompat.TransportControls, Unit>() { // from class: com.transsion.player.mediasession.MediaBrowserCompatHelper$skipToPrevious$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaControllerCompat.TransportControls transportControls) {
                invoke2(transportControls);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaControllerCompat.TransportControls transportControls) {
                if (transportControls != null) {
                    transportControls.skipToPrevious();
                }
            }
        });
    }
}
