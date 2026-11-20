package com.transsion.member.bean.request;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MemberInviteUserShareInfo implements Serializable {
    public static final int $stable = 0;
    private final String coverUrl;
    private final String desc;
    private final String downUrl;
    private final String title;
    private final String url;

    public MemberInviteUserShareInfo(String url, String title, String desc, String coverUrl, String downUrl) {
        Intrinsics.g(url, "url");
        Intrinsics.g(title, "title");
        Intrinsics.g(desc, "desc");
        Intrinsics.g(coverUrl, "coverUrl");
        Intrinsics.g(downUrl, "downUrl");
        this.url = url;
        this.title = title;
        this.desc = desc;
        this.coverUrl = coverUrl;
        this.downUrl = downUrl;
    }

    public static /* synthetic */ MemberInviteUserShareInfo copy$default(MemberInviteUserShareInfo memberInviteUserShareInfo, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = memberInviteUserShareInfo.url;
        }
        if ((i11 & 2) != 0) {
            str2 = memberInviteUserShareInfo.title;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = memberInviteUserShareInfo.desc;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = memberInviteUserShareInfo.coverUrl;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = memberInviteUserShareInfo.downUrl;
        }
        return memberInviteUserShareInfo.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.coverUrl;
    }

    public final String component5() {
        return this.downUrl;
    }

    public final MemberInviteUserShareInfo copy(String url, String title, String desc, String coverUrl, String downUrl) {
        Intrinsics.g(url, "url");
        Intrinsics.g(title, "title");
        Intrinsics.g(desc, "desc");
        Intrinsics.g(coverUrl, "coverUrl");
        Intrinsics.g(downUrl, "downUrl");
        return new MemberInviteUserShareInfo(url, title, desc, coverUrl, downUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberInviteUserShareInfo)) {
            return false;
        }
        MemberInviteUserShareInfo memberInviteUserShareInfo = (MemberInviteUserShareInfo) obj;
        return Intrinsics.b(this.url, memberInviteUserShareInfo.url) && Intrinsics.b(this.title, memberInviteUserShareInfo.title) && Intrinsics.b(this.desc, memberInviteUserShareInfo.desc) && Intrinsics.b(this.coverUrl, memberInviteUserShareInfo.coverUrl) && Intrinsics.b(this.downUrl, memberInviteUserShareInfo.downUrl);
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDownUrl() {
        return this.downUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.downUrl.hashCode();
    }

    public String toString() {
        return "MemberInviteUserShareInfo(url=" + this.url + ", title=" + this.title + ", desc=" + this.desc + ", coverUrl=" + this.coverUrl + ", downUrl=" + this.downUrl + ")";
    }
}
