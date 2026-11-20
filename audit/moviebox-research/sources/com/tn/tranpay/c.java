package com.tn.tranpay;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50077e;

    public c(String orderId, String str, String amount, String str2, boolean z11) {
        Intrinsics.g(orderId, "orderId");
        Intrinsics.g(amount, "amount");
        this.f50073a = orderId;
        this.f50074b = str;
        this.f50075c = amount;
        this.f50076d = str2;
        this.f50077e = z11;
    }
}
