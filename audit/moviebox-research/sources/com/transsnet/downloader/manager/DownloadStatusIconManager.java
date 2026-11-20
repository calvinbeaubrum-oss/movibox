package com.transsnet.downloader.manager;

import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsnet.downloader.callback.DownloadTaskStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class DownloadStatusIconManager implements g00.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f61047h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<DownloadStatusIconManager> f61048i = LazyKt__LazyJVMKt.b(new Function0<DownloadStatusIconManager>() { // from class: com.transsnet.downloader.manager.DownloadStatusIconManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadStatusIconManager invoke() {
            return new DownloadStatusIconManager();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f61052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f61053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f61054f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f61049a = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.manager.DownloadStatusIconManager$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g00.e> f61050b = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f61055g = RoomAppMMKV.f51271a.a().getBoolean("k_download_done_status", true);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadStatusIconManager a() {
            return (DownloadStatusIconManager) DownloadStatusIconManager.f61048i.getValue();
        }
    }

    public DownloadStatusIconManager() {
        n().m(this);
    }

    public static /* synthetic */ void q(DownloadStatusIconManager downloadStatusIconManager, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = -1;
        }
        downloadStatusIconManager.p(i11, i12);
    }

    @Override // g00.b
    public void a(DownloadTaskStat downloadTaskStat) {
        Intrinsics.g(downloadTaskStat, "downloadTaskStat");
        j.d(l0.a(w0.c()), null, null, new DownloadStatusIconManager$onChange$1(this, downloadTaskStat, null), 3, null);
    }

    public final void m(g00.e listener) {
        Intrinsics.g(listener, "listener");
        if (!this.f61050b.contains(listener)) {
            this.f61050b.add(listener);
        }
        n().E();
    }

    public final com.transsnet.downloader.manager.a n() {
        return (com.transsnet.downloader.manager.a) this.f61049a.getValue();
    }

    public final void o() {
        j.d(l0.a(w0.c()), null, null, new DownloadStatusIconManager$initDownloadUnreadList$1(this, null), 3, null);
    }

    public final void p(int i11, int i12) {
        Iterator<T> it = this.f61050b.iterator();
        while (it.hasNext()) {
            ((g00.e) it.next()).a(i11, i12);
        }
    }

    public final void r(g00.e listener) {
        Intrinsics.g(listener, "listener");
        this.f61050b.remove(listener);
    }

    public final void s(boolean z11) {
        RoomAppMMKV.f51271a.a().putBoolean("k_download_done_status", z11);
        this.f61055g = z11;
    }
}
