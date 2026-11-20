package com.transsnet.downloader.manager;

import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.fissionapi.IFissionProvider;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FinishDownloadHelper extends tr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61056a = "FinishDownloadHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f61057b = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsnet.downloader.manager.FinishDownloadHelper$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i00.a invoke() {
            return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f61058c = LazyKt__LazyJVMKt.b(new Function0<IFissionProvider>() { // from class: com.transsnet.downloader.manager.FinishDownloadHelper$fissionProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFissionProvider invoke() {
            return (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
        }
    });

    @Override // tr.a, tr.g
    public void e(DownloadBean bean, String str) {
        Intrinsics.g(bean, "bean");
        super.e(bean, str);
        IFissionProvider iFissionProviderJ = j();
        if (iFissionProviderJ == null || !iFissionProviderJ.enable()) {
            return;
        }
        j.d(l0.a(w0.b()), null, null, new FinishDownloadHelper$onDownloadSuccess$1(bean, this, null), 3, null);
    }

    public final IFissionProvider j() {
        return (IFissionProvider) this.f61058c.getValue();
    }

    public final i00.a k() {
        return (i00.a) this.f61057b.getValue();
    }
}
