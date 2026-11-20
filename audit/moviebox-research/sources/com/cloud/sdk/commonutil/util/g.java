package com.cloud.sdk.commonutil.util;

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
public abstract class g<T> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f30288a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable exception) {
            super(null);
            Intrinsics.g(exception, "exception");
            this.f30288a = exception;
        }

        public final Throwable a() {
            return this.f30288a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.b(this.f30288a, ((a) obj).f30288a);
        }

        public int hashCode() {
            return this.f30288a.hashCode();
        }

        public String toString() {
            return "Failure(exception=" + this.f30288a + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b<T> extends g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f30289a;

        public b(T t11) {
            super(null);
            this.f30289a = t11;
        }

        public final T a() {
            return this.f30289a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.b(this.f30289a, ((b) obj).f30289a);
        }

        public int hashCode() {
            T t11 = this.f30289a;
            if (t11 == null) {
                return 0;
            }
            return t11.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f30289a + ')';
        }
    }

    public g() {
    }

    public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
