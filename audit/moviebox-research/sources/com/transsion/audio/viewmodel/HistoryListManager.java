package com.transsion.audio.viewmodel;

import android.app.Application;
import androidx.lifecycle.c0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import rr.a;
import uo.b;

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
public final class HistoryListManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f50901e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<HistoryListManager> f50902f = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<HistoryListManager>() { // from class: com.transsion.audio.viewmodel.HistoryListManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HistoryListManager invoke() {
            return new HistoryListManager();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f50903g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f50904a = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsion.audio.viewmodel.HistoryListManager$audioDao$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).D0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f50905b = LazyKt__LazyJVMKt.b(new Function0<gr.a>() { // from class: com.transsion.audio.viewmodel.HistoryListManager$subjectApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final gr.a invoke() {
            return (gr.a) NetServiceGenerator.f49399d.a().i(gr.a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f50906c = LazyKt__LazyJVMKt.b(new Function0<c0<List<? extends AudioBean>>>() { // from class: com.transsion.audio.viewmodel.HistoryListManager$audioBeanListLiveData$2
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<? extends AudioBean>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f50907d = LazyKt__LazyJVMKt.b(new Function0<c0<DownloadListBean>>() { // from class: com.transsion.audio.viewmodel.HistoryListManager$subjectListLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<DownloadListBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return HistoryListManager.f50903g;
        }

        public final HistoryListManager b() {
            return (HistoryListManager) HistoryListManager.f50902f.getValue();
        }

        public final void c(boolean z11) {
            HistoryListManager.f50903g = z11;
        }
    }

    public static /* synthetic */ void m(HistoryListManager historyListManager, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 10;
        }
        historyListManager.l(str, str2, i11);
    }

    public final void f(AudioBean audioBean) throws InterruptedException {
        Intrinsics.g(audioBean, "audioBean");
        b.a.g(b.f78622a, "audio insert name " + audioBean.getTitle(), false, 2, null);
        i.b(null, new HistoryListManager$addToList$1(audioBean, this, null), 1, null);
    }

    public final void g() {
        j.d(l0.a(w0.b()), null, null, new HistoryListManager$deleteAll$1(this, null), 3, null);
    }

    public final void h(AudioBean audioItem) {
        Intrinsics.g(audioItem, "audioItem");
        j.d(l0.a(w0.b()), null, null, new HistoryListManager$deleteItem$1(this, audioItem, null), 3, null);
    }

    public final c0<List<AudioBean>> i() {
        return (c0) this.f50906c.getValue();
    }

    public final rr.a j() {
        return (rr.a) this.f50904a.getValue();
    }

    public final void k() {
        j.d(l0.a(w0.c()), null, null, new HistoryListManager$getAudioList$1(this, null), 3, null);
    }

    public final void l(String subjectId, String postId, int i11) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(postId, "postId");
        j.d(l0.a(w0.b()), null, null, new HistoryListManager$getResourcePosition$1(this, subjectId, postId, i11, null), 3, null);
    }

    public final gr.a n() {
        return (gr.a) this.f50905b.getValue();
    }

    public final c0<DownloadListBean> o() {
        return (c0) this.f50907d.getValue();
    }

    public final void p(AudioBean audioBean) {
        Intrinsics.g(audioBean, "audioBean");
        j.d(l0.a(w0.b()), null, null, new HistoryListManager$insert$1(audioBean, this, null), 3, null);
    }
}
