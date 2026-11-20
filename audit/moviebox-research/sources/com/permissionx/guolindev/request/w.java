package com.permissionx.guolindev.request;

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
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseTask f48711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseTask f48712b;

    public final void a(BaseTask task) {
        Intrinsics.g(task, "task");
        if (this.f48711a == null) {
            this.f48711a = task;
        }
        BaseTask baseTask = this.f48712b;
        if (baseTask != null) {
            baseTask.f48649c = task;
        }
        this.f48712b = task;
    }

    public final void b() {
        BaseTask baseTask = this.f48711a;
        if (baseTask != null) {
            baseTask.request();
        }
    }
}
