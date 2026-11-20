package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;

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
public final class LazyListStateKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f2576a = q2.i.h(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f2577b = new m(null, 0, false, 0.0f, new a(), 0.0f, false, l0.a(EmptyCoroutineContext.INSTANCE), q2.g.b(1.0f, 0.0f, 2, null), q2.c.b(0, 0, 0, 0, 15, null), kotlin.collections.g.l(), 0, 0, 0, false, Orientation.Vertical, 0, 0, null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.compose.ui.layout.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<androidx.compose.ui.layout.a, Integer> f2580c = kotlin.collections.s.h();

        @Override // androidx.compose.ui.layout.w
        public int getHeight() {
            return this.f2579b;
        }

        @Override // androidx.compose.ui.layout.w
        public int getWidth() {
            return this.f2578a;
        }

        @Override // androidx.compose.ui.layout.w
        public Map<androidx.compose.ui.layout.a, Integer> l() {
            return this.f2580c;
        }

        @Override // androidx.compose.ui.layout.w
        public void m() {
        }

        @Override // androidx.compose.ui.layout.w
        public /* synthetic */ Function1 n() {
            return androidx.compose.ui.layout.v.a(this);
        }
    }

    public static final LazyListState c(final int i11, final int i12, androidx.compose.runtime.i iVar, int i13, int i14) {
        if ((i14 & 1) != 0) {
            i11 = 0;
        }
        if ((i14 & 2) != 0) {
            i12 = 0;
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1470655220, i13, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:80)");
        }
        Object[] objArr = new Object[0];
        androidx.compose.runtime.saveable.d<LazyListState, ?> dVarA = LazyListState.f2548y.a();
        boolean z11 = ((((i13 & 14) ^ 6) > 4 && iVar.c(i11)) || (i13 & 6) == 4) | ((((i13 & 112) ^ 48) > 32 && iVar.c(i12)) || (i13 & 48) == 32);
        Object objY = iVar.y();
        if (z11 || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new Function0<LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListStateKt$rememberLazyListState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LazyListState invoke() {
                    return new LazyListState(i11, i12);
                }
            };
            iVar.p(objY);
        }
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.c(objArr, dVarA, null, (Function0) objY, iVar, 0, 4);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return lazyListState;
    }
}
