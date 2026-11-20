package androidx.compose.ui.text;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
public final class f0 {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5783a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5783a = iArr;
        }
    }

    public static final x b(w wVar, v vVar) {
        if (vVar == null) {
            return null;
        }
        return c.a(wVar, vVar);
    }

    public static final e0 c(e0 e0Var, LayoutDirection layoutDirection) {
        return new e0(SpanStyleKt.d(e0Var.y()), s.c(e0Var.v(), layoutDirection), e0Var.w());
    }

    public static final int d(LayoutDirection layoutDirection, int i11) {
        androidx.compose.ui.text.style.j.a aVar = androidx.compose.ui.text.style.j.f6115b;
        if (androidx.compose.ui.text.style.j.j(i11, aVar.a())) {
            int i12 = a.f5783a[layoutDirection.ordinal()];
            if (i12 == 1) {
                return aVar.b();
            }
            if (i12 == 2) {
                return aVar.c();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!androidx.compose.ui.text.style.j.j(i11, aVar.f())) {
            return i11;
        }
        int i13 = a.f5783a[layoutDirection.ordinal()];
        if (i13 == 1) {
            return aVar.d();
        }
        if (i13 == 2) {
            return aVar.e();
        }
        throw new NoWhenBranchMatchedException();
    }
}
