package com.transsnet.flow.event.sync.event;

import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class JoinRoomEvent implements Serializable {
    private final String groupId;
    private final boolean join;

    public JoinRoomEvent(boolean z11, String groupId) {
        Intrinsics.g(groupId, "groupId");
        this.join = z11;
        this.groupId = groupId;
    }

    public static /* synthetic */ JoinRoomEvent copy$default(JoinRoomEvent joinRoomEvent, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = joinRoomEvent.join;
        }
        if ((i11 & 2) != 0) {
            str = joinRoomEvent.groupId;
        }
        return joinRoomEvent.copy(z11, str);
    }

    public final boolean component1() {
        return this.join;
    }

    public final String component2() {
        return this.groupId;
    }

    public final JoinRoomEvent copy(boolean z11, String groupId) {
        Intrinsics.g(groupId, "groupId");
        return new JoinRoomEvent(z11, groupId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JoinRoomEvent)) {
            return false;
        }
        JoinRoomEvent joinRoomEvent = (JoinRoomEvent) obj;
        return this.join == joinRoomEvent.join && Intrinsics.b(this.groupId, joinRoomEvent.groupId);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final boolean getJoin() {
        return this.join;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.join;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (r11 * 31) + this.groupId.hashCode();
    }

    public String toString() {
        return "JoinRoomEvent(join=" + this.join + ", groupId=" + this.groupId + ")";
    }
}
