package com.transsnet.login.constant;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LoginSmsCodeMmkvUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoginSmsCodeMmkvUtil f61454a = new LoginSmsCodeMmkvUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f61455b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsnet.login.constant.LoginSmsCodeMmkvUtil$kv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("kv_login_sms");
        }
    });

    public final MMKV a() {
        Object value = f61455b.getValue();
        Intrinsics.f(value, "<get-kv>(...)");
        return (MMKV) value;
    }
}
