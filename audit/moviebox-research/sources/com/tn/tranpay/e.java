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
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f50084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f50085d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f50086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50087b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(e theme) {
            Intrinsics.g(theme, "theme");
            e.f50085d = theme;
        }

        public final e b() {
            return e.f50085d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f50084c = new a(defaultConstructorMarker);
        f50085d = new e(false, 0 == true ? 1 : 0, 3, defaultConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public e(boolean z11, int i11) {
        this.f50086a = z11;
        this.f50087b = i11;
    }

    public /* synthetic */ e(boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z11, (i12 & 2) != 0 ? -14696961 : i11);
    }

    public final boolean c() {
        return this.f50086a;
    }

    public final int d() {
        return this.f50087b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f50086a == eVar.f50086a && this.f50087b == eVar.f50087b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.f50086a;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (r11 * 31) + this.f50087b;
    }

    public String toString() {
        return "TranPayTheme(showLoadingWhenLaunched=" + this.f50086a + ", tintColor=" + this.f50087b + ")";
    }
}
