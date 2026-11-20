package com.cloud.tupdate.impl;

import android.util.Log;
import com.cloud.tupdate.bean.BaseResponse;
import com.cloud.tupdate.bean.UpdateEntity;
import com.cloud.tupdate.utils.a;
import com.cloud.tupdate.utils.b;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import te.f;

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
public final class UpdateParser implements f {
    @Override // te.f
    public UpdateEntity a(String str) {
        if (str == null || l.y(str)) {
            return null;
        }
        try {
            a.j().d("update", Intrinsics.p("response  ->  ", str));
            if (StringsKt__StringsKt.Q(str, TrackingKey.ERROR_CODE, false, 2, null) || !StringsKt__StringsKt.Q(str, TrackingKey.CODE, false, 2, null) || !StringsKt__StringsKt.Q(str, "data", false, 2, null)) {
                b.f32235a.n(0, "0", "fail");
                return null;
            }
            BaseResponse baseResponse = (BaseResponse) new Gson().fromJson(str, new TypeToken<BaseResponse<UpdateEntity>>() { // from class: com.cloud.tupdate.impl.UpdateParser$parseJson$responseResult$1
            }.getType());
            b.f32235a.n(1, String.valueOf(baseResponse == null ? null : Integer.valueOf(baseResponse.getCode())), baseResponse == null ? null : baseResponse.getMessage());
            if (baseResponse == null) {
                return null;
            }
            return (UpdateEntity) baseResponse.getData();
        } catch (Exception e11) {
            b.f32235a.n(0, "0", "exception fail");
            a.j().a(Log.getStackTraceString(e11));
            return null;
        }
    }
}
