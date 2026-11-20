package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f2268a = q2.i.h(30);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.compose.ui.f f2269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.compose.ui.f f2270c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements c5 {
        @Override // androidx.compose.ui.graphics.c5
        public m4 a(long j11, LayoutDirection layoutDirection, q2.e eVar) {
            float fK0 = eVar.k0(g.b());
            return new m4.b(new y1.i(0.0f, -fK0, y1.m.i(j11), y1.m.g(j11) + fK0));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements c5 {
        @Override // androidx.compose.ui.graphics.c5
        public m4 a(long j11, LayoutDirection layoutDirection, q2.e eVar) {
            float fK0 = eVar.k0(g.b());
            return new m4.b(new y1.i(-fK0, 0.0f, y1.m.i(j11) + fK0, y1.m.g(j11)));
        }
    }

    static {
        androidx.compose.ui.f.a aVar = androidx.compose.ui.f.f3863a;
        f2269b = androidx.compose.ui.draw.d.a(aVar, new a());
        f2270c = androidx.compose.ui.draw.d.a(aVar, new b());
    }

    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, Orientation orientation) {
        return fVar.f(orientation == Orientation.Vertical ? f2270c : f2269b);
    }

    public static final float b() {
        return f2268a;
    }
}
