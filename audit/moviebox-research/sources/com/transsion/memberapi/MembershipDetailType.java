package com.transsion.memberapi;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public enum MembershipDetailType {
    GUEST,
    TRIAL,
    SUBSCRIPTION_MEMBER,
    FINANCIAL_MEMBER,
    EXPIRED;

    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MembershipDetailType a(MemberInfo memberInfo) {
            if (memberInfo == null || !memberInfo.isActive()) {
                return (memberInfo == null || memberInfo.getMemberType() != 0) ? MembershipDetailType.EXPIRED : MembershipDetailType.GUEST;
            }
            if (memberInfo.getMemberType() == 1) {
                return MembershipDetailType.TRIAL;
            }
            return memberInfo.isAutoRenew() ? MembershipDetailType.SUBSCRIPTION_MEMBER : MembershipDetailType.FINANCIAL_MEMBER;
        }
    }
}
