package com.transsion.baselib.helper;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UserPreferHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f51180b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<UserPreferHelper> f51181c = LazyKt__LazyJVMKt.b(new Function0<UserPreferHelper>() { // from class: com.transsion.baselib.helper.UserPreferHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserPreferHelper invoke() {
            return new UserPreferHelper();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f51182a = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserPreferHelper a() {
            return (UserPreferHelper) UserPreferHelper.f51181c.getValue();
        }
    }

    public final void b(String userPrefer) {
        Intrinsics.g(userPrefer, "userPrefer");
        this.f51182a = userPrefer;
    }
}
