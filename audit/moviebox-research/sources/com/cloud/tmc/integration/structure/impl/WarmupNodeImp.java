package com.cloud.tmc.integration.structure.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.node.NodeInstance;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WarmupNodeImp extends NodeInstance implements WarmupNode {
    public static final a CREATOR = new a(null);
    private final ConcurrentHashMap<String, Node> nodeMap;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<WarmupNodeImp> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WarmupNodeImp createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new WarmupNodeImp(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public WarmupNodeImp[] newArray(int i11) {
            return new WarmupNodeImp[i11];
        }
    }

    public WarmupNodeImp() {
        this.nodeMap = new ConcurrentHashMap<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WarmupNodeImp(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.cloud.tmc.integration.structure.WarmupNode
    public Node getNode(String id2) {
        Intrinsics.g(id2, "id");
        Node node = this.nodeMap.get(id2);
        if (node != null) {
            return node;
        }
        NodeInstance nodeInstance = new NodeInstance();
        this.nodeMap.put(id2, nodeInstance);
        return nodeInstance;
    }

    public final ConcurrentHashMap<String, Node> getNodeMap() {
        return this.nodeMap;
    }

    @Override // com.cloud.tmc.integration.structure.WarmupNode
    public void removeNode(String id2) {
        Intrinsics.g(id2, "id");
        this.nodeMap.remove(id2);
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        super.writeToParcel(parcel, i11);
    }
}
