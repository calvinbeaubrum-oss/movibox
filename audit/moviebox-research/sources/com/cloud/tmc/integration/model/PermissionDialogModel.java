package com.cloud.tmc.integration.model;

import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc.a;
import rc.b;

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
public final class PermissionDialogModel extends b {
    private String action;
    private String appId;
    private NativeCallContext<?> bridgeContext;
    private PermissionModel model;
    private Page page;
    private a responseHelper;
    private long startToken;

    public PermissionDialogModel(Page page, String appId, String action, NativeCallContext<?> bridgeContext, a responseHelper, PermissionModel model, long j11) {
        Intrinsics.g(page, "page");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(action, "action");
        Intrinsics.g(bridgeContext, "bridgeContext");
        Intrinsics.g(responseHelper, "responseHelper");
        Intrinsics.g(model, "model");
        this.page = page;
        this.appId = appId;
        this.action = action;
        this.bridgeContext = bridgeContext;
        this.responseHelper = responseHelper;
        this.model = model;
        this.startToken = j11;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final NativeCallContext<?> getBridgeContext() {
        return this.bridgeContext;
    }

    public final PermissionModel getModel() {
        return this.model;
    }

    public final Page getPage() {
        return this.page;
    }

    public final a getResponseHelper() {
        return this.responseHelper;
    }

    public final long getStartToken() {
        return this.startToken;
    }

    public final void setAction(String str) {
        Intrinsics.g(str, "<set-?>");
        this.action = str;
    }

    public final void setAppId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setBridgeContext(NativeCallContext<?> nativeCallContext) {
        Intrinsics.g(nativeCallContext, "<set-?>");
        this.bridgeContext = nativeCallContext;
    }

    public final void setModel(PermissionModel permissionModel) {
        Intrinsics.g(permissionModel, "<set-?>");
        this.model = permissionModel;
    }

    public final void setPage(Page page) {
        Intrinsics.g(page, "<set-?>");
        this.page = page;
    }

    public final void setResponseHelper(a aVar) {
        Intrinsics.g(aVar, "<set-?>");
        this.responseHelper = aVar;
    }

    public final void setStartToken(long j11) {
        this.startToken = j11;
    }
}
