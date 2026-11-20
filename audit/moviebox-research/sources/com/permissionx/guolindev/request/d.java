package com.permissionx.guolindev.request;

import com.permissionx.guolindev.dialog.RationaleDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PermissionBuilder f48684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f48685b;

    public d(PermissionBuilder pb2, c chainTask) {
        Intrinsics.g(pb2, "pb");
        Intrinsics.g(chainTask, "chainTask");
        this.f48684a = pb2;
        this.f48685b = chainTask;
    }

    public final void a(List<String> permissions) {
        Intrinsics.g(permissions, "permissions");
        this.f48684a.h(permissions);
    }

    public final void b(List<String> permissions) {
        Intrinsics.g(permissions, "permissions");
        this.f48685b.a(permissions);
    }

    @JvmOverloads
    public final void c(List<String> permissions, co.a dialogInfo) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(dialogInfo, "dialogInfo");
        this.f48684a.K(this.f48685b, false, permissions, dialogInfo);
    }

    public final void d(RationaleDialog dialog) {
        Intrinsics.g(dialog, "dialog");
        this.f48684a.J(this.f48685b, true, dialog);
    }

    @JvmOverloads
    public final void e(List<String> permissions, co.a dialogInfo) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(dialogInfo, "dialogInfo");
        this.f48684a.K(this.f48685b, true, permissions, dialogInfo);
    }
}
