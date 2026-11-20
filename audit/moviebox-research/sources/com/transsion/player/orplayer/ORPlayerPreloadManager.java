package com.transsion.player.orplayer;

import com.aliyun.loader.MediaLoader;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class ORPlayerPreloadManager implements MediaLoader.OnLoadStatusListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f54651i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<ORPlayerPreloadManager> f54652j = LazyKt__LazyJVMKt.b(new Function0<ORPlayerPreloadManager>() { // from class: com.transsion.player.orplayer.ORPlayerPreloadManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ORPlayerPreloadManager invoke() {
            return new ORPlayerPreloadManager();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54653a = "ORPlayerPreload";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f54654b = 4000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f54655c = 4000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f54656d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f54657e = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f54658f = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f54659g = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f54660h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ORPlayerPreloadManager a() {
            return (ORPlayerPreloadManager) ORPlayerPreloadManager.f54652j.getValue();
        }
    }

    public ORPlayerPreloadManager() {
        MediaLoader.getInstance().setOnLoadStatusListener(this);
        File externalCacheDir = Utils.a().getExternalCacheDir();
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        String str = absolutePath + File.separator + "video_cache";
        try {
            Result.Companion companion = Result.Companion;
            AliPlayerGlobalSettings.enableLocalCache(true, 0, str);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void b() {
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "cancelAll", false, 4, null);
        this.f54656d = "";
        this.f54659g.clear();
        this.f54657e.clear();
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new ORPlayerPreloadManager$cancelAll$1(null), 3, null);
    }

    public final boolean c(String url) {
        Intrinsics.g(url, "url");
        return this.f54658f.contains(url);
    }

    public final boolean d(String url) {
        Intrinsics.g(url, "url");
        return (this.f54656d.length() > 0 && Intrinsics.b(url, this.f54656d)) || this.f54659g.contains(url);
    }

    public final void e(String url) {
        Intrinsics.g(url, "url");
        if (!d(url)) {
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "pause, but not contains, PausedContains =  " + this.f54657e.contains(url) + ", url = " + url, false, 4, null);
            return;
        }
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "pause, url = " + url, false, 4, null);
        this.f54657e.add(url);
        if (!Intrinsics.b(this.f54656d, url)) {
            if (this.f54659g.contains(url)) {
                this.f54659g.remove(url);
                return;
            }
            return;
        }
        this.f54656d = "";
        MediaLoader.getInstance().pause(url);
        if (!this.f54659g.isEmpty()) {
            Object objE0 = CollectionsKt___CollectionsKt.e0(this.f54659g);
            Intrinsics.f(objE0, "urlsCache.first()");
            String str = (String) objE0;
            this.f54656d = str;
            j(str);
            this.f54659g.remove(this.f54656d);
        }
    }

    public final void f() {
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "pauseAll, paused size = " + this.f54657e.size() + ", urlsCache size = " + this.f54659g.size() + ", curUrl = " + this.f54656d + " ", false, 4, null);
        if (this.f54656d.length() > 0) {
            MediaLoader.getInstance().pause(this.f54656d);
            this.f54657e.add(this.f54656d);
            this.f54656d = "";
        }
        if (!this.f54659g.isEmpty()) {
            this.f54657e.addAll(this.f54659g);
            this.f54659g.clear();
        }
    }

    public final void g(String url) {
        Intrinsics.g(url, "url");
        h(url, this.f54654b);
    }

    public final void h(String url, long j11) {
        Intrinsics.g(url, "url");
        if (j11 > 0) {
            this.f54655c = j11;
        }
        if (d(url)) {
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "start preload, contains return~ url = " + url, false, 4, null);
            return;
        }
        if (this.f54657e.contains(url)) {
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "start preload, pause contains resume~ url = " + url, false, 4, null);
            if (this.f54656d.length() > 0) {
                this.f54659g.add(url);
            } else {
                this.f54656d = url;
                MediaLoader.getInstance().resume(url);
            }
            this.f54657e.remove(url);
            return;
        }
        if (this.f54658f.contains(url)) {
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "is preloaded, return, url = " + url, false, 4, null);
            return;
        }
        if (this.f54656d.length() <= 0) {
            this.f54656d = url;
            j(url);
            return;
        }
        if (System.currentTimeMillis() - this.f54660h <= 5000) {
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "start preload, add to cache, url = " + url, false, 4, null);
            this.f54659g.add(url);
            return;
        }
        com.transsion.player.utils.b.i(com.transsion.player.utils.b.f54866a, this.f54653a, "last is more than 5 sec, preload new url", false, 4, null);
        if (!(!this.f54659g.isEmpty())) {
            this.f54656d = url;
            j(url);
            return;
        }
        Object objE0 = CollectionsKt___CollectionsKt.e0(this.f54659g);
        Intrinsics.f(objE0, "urlsCache.first()");
        String str = (String) objE0;
        this.f54656d = str;
        j(str);
        this.f54659g.remove(this.f54656d);
        this.f54659g.add(url);
    }

    public final void i() {
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "resumeAll, paused size = " + this.f54657e.size() + ", urlsCache size = " + this.f54659g.size() + ", curUrl = " + this.f54656d + " ", false, 4, null);
        if (this.f54656d.length() > 0) {
            return;
        }
        if (!this.f54657e.isEmpty()) {
            for (String paused : this.f54657e) {
                if (this.f54656d.length() > 0) {
                    this.f54659g.add(paused);
                } else {
                    Intrinsics.f(paused, "paused");
                    this.f54656d = paused;
                    MediaLoader.getInstance().resume(paused);
                }
            }
        }
        this.f54657e.clear();
    }

    public final void j(String str) {
        this.f54660h = System.currentTimeMillis();
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "startPreload, url = " + str, false, 4, null);
        MediaLoader.getInstance().load(str, this.f54655c);
    }

    @Override // com.aliyun.loader.MediaLoader.OnLoadStatusListener
    public void onCanceled(String str) {
    }

    @Override // com.aliyun.loader.MediaLoader.OnLoadStatusListener
    public void onCompleted(String str) {
        com.transsion.player.utils.b.i(com.transsion.player.utils.b.f54866a, this.f54653a, "preload complete, url = " + str, false, 4, null);
        this.f54657e.remove(str);
        if (!this.f54659g.isEmpty()) {
            Object objE0 = CollectionsKt___CollectionsKt.e0(this.f54659g);
            Intrinsics.f(objE0, "urlsCache.first()");
            String str2 = (String) objE0;
            this.f54656d = str2;
            j(str2);
            this.f54659g.remove(this.f54656d);
        } else {
            this.f54656d = "";
        }
        if (str != null) {
            this.f54658f.add(str);
        }
    }

    @Override // com.aliyun.loader.MediaLoader.OnLoadStatusListener
    public void onError(String str, int i11, String str2) {
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54653a, "preload error, " + (i11 == -300 ? "is preloaded code" : "errorCode") + " = " + i11 + ", errorMsg= " + str2 + ", url = " + str, false, 4, null);
        if (!this.f54659g.isEmpty()) {
            Object objE0 = CollectionsKt___CollectionsKt.e0(this.f54659g);
            Intrinsics.f(objE0, "urlsCache.first()");
            String str3 = (String) objE0;
            this.f54656d = str3;
            j(str3);
            this.f54659g.remove(this.f54656d);
        }
        this.f54657e.remove(str);
        if (i11 == -300) {
            this.f54658f.add(str);
        }
    }
}
