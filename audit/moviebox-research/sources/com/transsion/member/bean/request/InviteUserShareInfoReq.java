package com.transsion.member.bean.request;

import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InviteUserShareInfoReq implements Serializable {
    public static final int $stable = 0;
    private final String scene;
    private final String type;
    private final String utmSource;

    public InviteUserShareInfoReq(String type, String scene, String utmSource) {
        Intrinsics.g(type, "type");
        Intrinsics.g(scene, "scene");
        Intrinsics.g(utmSource, "utmSource");
        this.type = type;
        this.scene = scene;
        this.utmSource = utmSource;
    }

    public /* synthetic */ InviteUserShareInfoReq(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "fissionInvite" : str, str2, (i11 & 4) != 0 ? str2 : str3);
    }

    public static /* synthetic */ InviteUserShareInfoReq copy$default(InviteUserShareInfoReq inviteUserShareInfoReq, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = inviteUserShareInfoReq.type;
        }
        if ((i11 & 2) != 0) {
            str2 = inviteUserShareInfoReq.scene;
        }
        if ((i11 & 4) != 0) {
            str3 = inviteUserShareInfoReq.utmSource;
        }
        return inviteUserShareInfoReq.copy(str, str2, str3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.scene;
    }

    public final String component3() {
        return this.utmSource;
    }

    public final InviteUserShareInfoReq copy(String type, String scene, String utmSource) {
        Intrinsics.g(type, "type");
        Intrinsics.g(scene, "scene");
        Intrinsics.g(utmSource, "utmSource");
        return new InviteUserShareInfoReq(type, scene, utmSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InviteUserShareInfoReq)) {
            return false;
        }
        InviteUserShareInfoReq inviteUserShareInfoReq = (InviteUserShareInfoReq) obj;
        return Intrinsics.b(this.type, inviteUserShareInfoReq.type) && Intrinsics.b(this.scene, inviteUserShareInfoReq.scene) && Intrinsics.b(this.utmSource, inviteUserShareInfoReq.utmSource);
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUtmSource() {
        return this.utmSource;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.scene.hashCode()) * 31) + this.utmSource.hashCode();
    }

    public String toString() {
        return "InviteUserShareInfoReq(type=" + this.type + ", scene=" + this.scene + ", utmSource=" + this.utmSource + ")";
    }
}
