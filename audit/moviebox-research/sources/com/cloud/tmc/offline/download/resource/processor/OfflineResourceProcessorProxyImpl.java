package com.cloud.tmc.offline.download.resource.processor;

import ae.b;
import ae.c;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.k;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class OfflineResourceProcessorProxyImpl implements IOfflineResourceProcessorProxy {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final List<be.a> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ae.a());
        arrayList.add(new b());
        return arrayList;
    }

    @Override // com.cloud.tmc.offline.download.resource.processor.IOfflineResourceProcessorProxy
    public be.a.c getResultWithInterceptorChain(be.a.b params) {
        Intrinsics.g(params, "params");
        ArrayList arrayList = new ArrayList();
        k.A(arrayList, a());
        arrayList.add(new c());
        try {
            return new be.b(arrayList, 0, params).b(params);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineResourceProcessor", "Proceeding to offline resource", th2);
            return new be.a.c(null, 1, null);
        }
    }
}
