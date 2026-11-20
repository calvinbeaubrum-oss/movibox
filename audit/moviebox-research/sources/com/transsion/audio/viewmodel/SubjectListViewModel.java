package com.transsion.audio.viewmodel;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsnet.downloader.bean.DownloadListBean;
import i00.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

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
public final class SubjectListViewModel extends t0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f50911c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f50912a = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsion.audio.viewmodel.SubjectListViewModel$serviceDownload$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f50913b = LazyKt__LazyJVMKt.b(new Function0<c0<DownloadListBean>>() { // from class: com.transsion.audio.viewmodel.SubjectListViewModel$audioList$2
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i00.a f() {
        return (i00.a) this.f50912a.getValue();
    }

    public final c0<DownloadListBean> c() {
        return (c0) this.f50913b.getValue();
    }

    public final void d(boolean z11, String str, String nextPage, int i11, int i12, int i13, int i14) {
        Intrinsics.g(nextPage, "nextPage");
        j.d(u0.a(this), null, null, new SubjectListViewModel$getDownloadList$1(this, str, nextPage, i11, i12, i13, i14, z11, null), 3, null);
    }
}
