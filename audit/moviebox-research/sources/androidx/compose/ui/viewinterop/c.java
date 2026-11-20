package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.input.nestedscroll.e;
import androidx.compose.ui.layout.n;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import y1.g;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6219a = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.compose.ui.input.nestedscroll.b {
        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ Object L(long j11, long j12, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.a(this, j11, j12, continuation);
        }

        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ long L0(long j11, int i11) {
            return androidx.compose.ui.input.nestedscroll.a.d(this, j11, i11);
        }

        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ Object R0(long j11, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.c(this, j11, continuation);
        }

        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ long o0(long j11, long j12, int i11) {
            return androidx.compose.ui.input.nestedscroll.a.b(this, j11, j12, i11);
        }
    }

    public static final void f(View view, LayoutNode layoutNode) {
        long jE = n.e(layoutNode.l());
        int iRound = Math.round(g.m(jE));
        int iRound2 = Math.round(g.n(jE));
        view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
    }

    public static final float g(int i11) {
        return i11 * (-1);
    }

    public static final float h(float f11) {
        return f11 * (-1.0f);
    }

    public static final int i(int i11) {
        return i11 == 0 ? e.f4627a.b() : e.f4627a.a();
    }
}
