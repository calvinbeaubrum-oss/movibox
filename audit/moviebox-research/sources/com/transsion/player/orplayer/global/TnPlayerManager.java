package com.transsion.player.orplayer.global;

import android.annotation.SuppressLint;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaBrowserCompatHelper;
import com.transsion.player.orplayer.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class TnPlayerManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function0<Boolean> f54686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function0<Boolean> f54687d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Function0<Integer> f54690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f54691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile TnSingleInstancePlayer f54692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile com.transsion.player.orplayer.f f54693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<com.transsion.player.orplayer.f>> f54694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CopyOnWriteArrayList<g> f54695l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TnPlayerManager f54684a = new TnPlayerManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f54685b = LazyKt__LazyJVMKt.b(new Function0<e>() { // from class: com.transsion.player.orplayer.global.TnPlayerManager$singleInstancePlayer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final e invoke() {
            return new e();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f54688e = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.player.orplayer.global.TnPlayerManager$isASyncPlayer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Function0<Boolean> function0E = TnPlayerManager.f54684a.e();
            boolean zBooleanValue = function0E != null ? function0E.invoke().booleanValue() : false;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isASyncPlayer:");
            sb2.append(zBooleanValue);
            return Boolean.valueOf(zBooleanValue);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f54689f = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.player.orplayer.global.TnPlayerManager$isMultiplePlayer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Function0<Boolean> function0G = TnPlayerManager.f54684a.g();
            boolean zBooleanValue = function0G != null ? function0G.invoke().booleanValue() : true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isMultiplePlayer:");
            sb2.append(zBooleanValue);
            return Boolean.valueOf(zBooleanValue);
        }
    });

    static {
        Function0<Integer> function0 = f54690g;
        f54691h = function0 != null ? function0.invoke().intValue() : 0;
        f54694k = new CopyOnWriteArrayList<>();
        f54695l = new CopyOnWriteArrayList<>();
    }

    public final com.transsion.player.orplayer.f a(String mediaId) {
        String strE;
        com.transsion.player.orplayer.f fVar;
        MediaSource mediaSourceCurrentMediaSource;
        Intrinsics.g(mediaId, "mediaId");
        Iterator<T> it = f54694k.iterator();
        do {
            strE = null;
            if (!it.hasNext()) {
                return null;
            }
            fVar = (com.transsion.player.orplayer.f) ((WeakReference) it.next()).get();
            if (fVar != null && (mediaSourceCurrentMediaSource = fVar.currentMediaSource()) != null) {
                strE = mediaSourceCurrentMediaSource.e();
            }
        } while (!Intrinsics.b(strE, mediaId));
        return fVar;
    }

    public final com.transsion.player.orplayer.f b() {
        return f54693j;
    }

    public final e c() {
        return (e) f54685b.getValue();
    }

    public final boolean d() {
        return ((Boolean) f54688e.getValue()).booleanValue();
    }

    public final Function0<Boolean> e() {
        return f54687d;
    }

    public final boolean f() {
        return ((Boolean) f54689f.getValue()).booleanValue();
    }

    public final Function0<Boolean> g() {
        return f54686c;
    }

    public final int h() {
        return f54691h;
    }

    public final com.transsion.player.orplayer.f i() {
        com.transsion.player.orplayer.f eVar = f() ? new e() : new TnSingleInstancePlayer();
        f54694k.add(new WeakReference<>(eVar));
        return eVar;
    }

    public final void j(com.transsion.player.orplayer.f fVar, com.transsion.player.orplayer.f fVar2) {
        Iterator<g> it = f54695l.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, fVar2);
        }
    }

    public final void k(com.transsion.player.orplayer.f orPlayer, MediaSource mediaSource) {
        Intrinsics.g(orPlayer, "orPlayer");
    }

    public final void l(com.transsion.player.orplayer.f orPlayer, MediaSource mediaSource) {
        Intrinsics.g(orPlayer, "orPlayer");
    }

    public final void m(com.transsion.player.orplayer.f fVar) {
        Iterator<WeakReference<com.transsion.player.orplayer.f>> it = f54694k.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.b(it.next().get(), fVar)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            f54694k.remove(i11);
        }
    }

    public final void n(com.transsion.player.orplayer.f orPlayer) {
        Intrinsics.g(orPlayer, "orPlayer");
        if (Intrinsics.b(f54693j, orPlayer)) {
            f54693j = null;
            j(null, orPlayer);
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, "TnPlayerManager", "releaseFocus  orPlayer:" + orPlayer, false, 4, null);
        }
        m(orPlayer);
    }

    public final void o(String mediaId) {
        Intrinsics.g(mediaId, "mediaId");
        MediaBrowserCompatHelper.f54597h.a().n(mediaId);
    }

    public final void p(com.transsion.player.orplayer.f orPlayer, String reason) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(reason, "reason");
        if (Intrinsics.b(f54693j, orPlayer)) {
            return;
        }
        com.transsion.player.orplayer.f fVar = f54693j;
        if (fVar != null && fVar.isPlaying()) {
            fVar.pause();
        }
        f54693j = orPlayer;
        j(fVar, orPlayer);
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, "TnPlayerManager", "requestFocus  orPlayer:" + orPlayer + "  reason:" + reason, false, 4, null);
    }

    public final void q(TnSingleInstancePlayer tnPlayer) {
        Intrinsics.g(tnPlayer, "tnPlayer");
        if (f() || Intrinsics.b(f54692i, tnPlayer)) {
            return;
        }
        synchronized (this) {
            try {
                if (!Intrinsics.b(f54692i, tnPlayer)) {
                    com.transsion.player.utils.b.f54866a.a("TnPlayer", "换boss啦:" + f54692i + "  to " + tnPlayer, true);
                    TnSingleInstancePlayer tnSingleInstancePlayer = f54692i;
                    if (tnSingleInstancePlayer != null) {
                        tnSingleInstancePlayer.q(true);
                    }
                    tnPlayer.q(false);
                    TnSingleInstancePlayer tnSingleInstancePlayer2 = f54692i;
                    if (tnSingleInstancePlayer2 != null) {
                        tnSingleInstancePlayer2.r(null);
                    }
                    tnPlayer.r(f54684a.c());
                    f54692i = tnPlayer;
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void r(com.transsion.player.orplayer.f orPlayer, MediaSource mediaSource) {
        Intrinsics.g(orPlayer, "orPlayer");
    }

    public final void s(Function0<Boolean> function0) {
        f54687d = function0;
    }

    public final void t(Function0<Boolean> function0) {
        f54686c = function0;
    }

    public final void u(Function0<Integer> function0) {
        f54690g = function0;
    }
}
