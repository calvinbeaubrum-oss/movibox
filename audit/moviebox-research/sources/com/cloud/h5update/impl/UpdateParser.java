package com.cloud.h5update.impl;

import com.cloud.h5update.bean.BaseResponse;
import com.cloud.h5update.bean.UpdateEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import m9.d;

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
public final class UpdateParser implements d {
    @Override // m9.d
    public UpdateEntity a(String str) {
        BaseResponse baseResponse;
        if (str == null || l.y(str)) {
            return null;
        }
        try {
            if (StringsKt__StringsKt.Q(str, TrackingKey.ERROR_CODE, false, 2, null) || !StringsKt__StringsKt.Q(str, TrackingKey.CODE, false, 2, null) || !StringsKt__StringsKt.Q(str, "data", false, 2, null) || (baseResponse = (BaseResponse) new Gson().fromJson(str, new TypeToken<BaseResponse<UpdateEntity>>() { // from class: com.cloud.h5update.impl.UpdateParser$parseJson$responseResult$1
            }.getType())) == null) {
                return null;
            }
            return (UpdateEntity) baseResponse.getData();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
