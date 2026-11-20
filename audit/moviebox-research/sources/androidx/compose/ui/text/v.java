package androidx.compose.ui.text;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6158c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f6159d = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6161b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v() {
        this(e.f5769b.b(), false, null);
    }

    public v(int i11, boolean z11) {
        this.f6160a = z11;
        this.f6161b = i11;
    }

    public /* synthetic */ v(int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, z11);
    }

    public v(boolean z11) {
        this.f6160a = z11;
        this.f6161b = e.f5769b.b();
    }

    public final int a() {
        return this.f6161b;
    }

    public final boolean b() {
        return this.f6160a;
    }

    public final v c(v vVar) {
        return vVar == null ? this : vVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f6160a == vVar.f6160a && e.g(this.f6161b, vVar.f6161b);
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.f6160a) * 31) + e.h(this.f6161b);
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.f6160a + ", emojiSupportMatch=" + ((Object) e.i(this.f6161b)) + ')';
    }
}
