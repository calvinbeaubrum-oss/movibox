package com.transsion.lib.diffupdate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class d {
    public static final c a(String jsonString) {
        Intrinsics.g(jsonString, "jsonString");
        JSONObject jSONObjectOptJSONObject = new JSONObject(jsonString).optJSONObject("data");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("hasUpdate", false);
        String strOptString = jSONObjectOptJSONObject.optString("patchUrl", "");
        Intrinsics.f(strOptString, "jsonObject.optString(\"patchUrl\", \"\")");
        String strOptString2 = jSONObjectOptJSONObject.optString("patchMd5", "");
        Intrinsics.f(strOptString2, "jsonObject.optString(\"patchMd5\", \"\")");
        long jOptLong = jSONObjectOptJSONObject.optLong("patchSize", 0L);
        String strOptString3 = jSONObjectOptJSONObject.optString("installPkgUrl", "");
        Intrinsics.f(strOptString3, "jsonObject.optString(\"installPkgUrl\", \"\")");
        long jOptLong2 = jSONObjectOptJSONObject.optLong("installPkgVersionCode", 0L);
        String strOptString4 = jSONObjectOptJSONObject.optString("installPkgMd5", "");
        Intrinsics.f(strOptString4, "jsonObject.optString(\"installPkgMd5\", \"\")");
        return new c(zOptBoolean, strOptString, strOptString2, jOptLong, strOptString3, jOptLong2, strOptString4, jSONObjectOptJSONObject.optLong("installPkgSize", 0L));
    }
}
