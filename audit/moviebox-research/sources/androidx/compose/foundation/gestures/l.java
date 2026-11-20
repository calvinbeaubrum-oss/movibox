package androidx.compose.foundation.gestures;

import androidx.compose.ui.node.m1;
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
public final class l extends androidx.compose.ui.f.c implements m1 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f2366q = new a(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f2367r = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f2368o = f2366q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2369p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(boolean z11) {
        this.f2369p = z11;
    }

    public final boolean H1() {
        return this.f2369p;
    }

    @Override // androidx.compose.ui.node.m1
    public Object I() {
        return this.f2368o;
    }

    public final void I1(boolean z11) {
        this.f2369p = z11;
    }
}
