package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
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
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6123a = a.f6124a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6124a = new a();

        public final l a(l1 l1Var, float f11) {
            if (l1Var == null) {
                return b.f6125b;
            }
            if (l1Var instanceof d5) {
                return b(k.b(((d5) l1Var).b(), f11));
            }
            if (l1Var instanceof a5) {
                return new androidx.compose.ui.text.style.b((a5) l1Var, f11);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final l b(long j11) {
            return j11 != 16 ? new c(j11, null) : b.f6125b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f6125b = new b();

        @Override // androidx.compose.ui.text.style.l
        public long a() {
            return w1.f4564b.e();
        }

        @Override // androidx.compose.ui.text.style.l
        public /* synthetic */ l b(Function0 function0) {
            return TextForegroundStyle$CC.b(this, function0);
        }

        @Override // androidx.compose.ui.text.style.l
        public /* synthetic */ l c(l lVar) {
            return TextForegroundStyle$CC.a(this, lVar);
        }

        @Override // androidx.compose.ui.text.style.l
        public l1 d() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.l
        public float getAlpha() {
            return Float.NaN;
        }
    }

    long a();

    l b(Function0<? extends l> function0);

    l c(l lVar);

    l1 d();

    float getAlpha();
}
