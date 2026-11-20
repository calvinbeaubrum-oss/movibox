package com.cloud.tmc.integration.structure;

import com.cloud.tmc.kernel.node.Node;
import dd.d;
import java.util.List;
import kotlin.Metadata;
import zb.c;

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
@c("com.cloud.tmc.integration.structure.impl.WarmupNodeImp")
public interface WarmupNode extends Node {
    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ d getGroup();

    Node getNode(String str);

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ void inquiry(List list, dd.c.a aVar);

    void removeNode(String str);

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ List usePermissions();
}
