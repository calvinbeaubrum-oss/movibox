package com.transsnet.downloader.manager;

import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StartDownloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61059a = "StartDownloadHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f61060b = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsnet.downloader.manager.StartDownloadHelper$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i00.a invoke() {
            return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
        }
    });

    public final i00.a c() {
        return (i00.a) this.f61060b.getValue();
    }

    public final void d(List<? extends DownloadBean> list) {
        j.d(l0.a(w0.b()), null, null, new StartDownloadHelper$startDownloadResource$1(list, this, null), 3, null);
    }
}
