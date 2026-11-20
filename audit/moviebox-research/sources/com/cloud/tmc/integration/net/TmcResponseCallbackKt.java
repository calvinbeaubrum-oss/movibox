package com.cloud.tmc.integration.net;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class TmcResponseCallbackKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f30829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type f30830b;

    static {
        Type type = new TypeToken<BaseResponse<? extends Object>>() { // from class: com.cloud.tmc.integration.net.TmcResponseCallbackKt$failType$1
        }.getType();
        Intrinsics.f(type, "object : TypeToken<BaseResponse<Any>>() {}.type");
        f30829a = type;
        Type type2 = new TypeToken<GatewayBean>() { // from class: com.cloud.tmc.integration.net.TmcResponseCallbackKt$gatewayType$1
        }.getType();
        Intrinsics.f(type2, "object : TypeToken<GatewayBean>() {}.type");
        f30830b = type2;
    }

    public static final Type a() {
        return f30829a;
    }

    public static final Type b() {
        return f30830b;
    }
}
