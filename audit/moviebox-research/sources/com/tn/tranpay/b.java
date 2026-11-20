package com.tn.tranpay;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f50070c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f50072b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ b b(a aVar, int i11, String str, String str2, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                str2 = null;
            }
            return aVar.a(i11, str, str2);
        }

        public final b a(int i11, String debugMessage, String str) {
            Intrinsics.g(debugMessage, "debugMessage");
            if (str != null) {
                debugMessage = debugMessage + " and serverCode: " + str;
            }
            return new b(i11, debugMessage);
        }
    }

    public b(int i11, String debugMessage) {
        Intrinsics.g(debugMessage, "debugMessage");
        this.f50071a = i11;
        this.f50072b = debugMessage;
    }

    public final String a() {
        return this.f50072b;
    }

    public final int b() {
        return this.f50071a;
    }

    public String toString() {
        return "Response Code: " + this.f50071a + ", Debug Message: " + this.f50072b;
    }
}
