package com.cloud.tmc.integration.defaultImpl;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.RequestConfigBean;
import com.cloud.tmc.integration.proxy.IRequestConfigProxy;
import com.google.gson.Gson;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RequestConfigManager implements IRequestConfigProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RequestConfigBean f30721a;

    @Override // com.cloud.tmc.integration.proxy.IRequestConfigProxy
    public void preLoadConfig() {
        this.f30721a = (RequestConfigBean) new Gson().fromJson(MiniAppConfigHelper.f30370a.e("requestConfig", "{\"repairIntToFloat\":true}"), RequestConfigBean.class);
    }

    @Override // com.cloud.tmc.integration.proxy.IRequestConfigProxy
    public boolean repairIntToFloat() {
        RequestConfigBean requestConfigBean = this.f30721a;
        if (requestConfigBean != null) {
            return requestConfigBean.getRepairIntToFloat();
        }
        return true;
    }
}
