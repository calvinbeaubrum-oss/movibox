package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.a0;
import androidx.compose.foundation.lazy.layout.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

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
public final class d {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LazyListState f2587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f2588b;

        public a(LazyListState lazyListState, boolean z11) {
            this.f2587a = lazyListState;
            this.f2588b = z11;
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public int a() {
            return this.f2587a.t().e() + this.f2587a.t().b();
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public float b() {
            return a0.a(this.f2587a.o(), this.f2587a.p(), this.f2587a.d());
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public Object c(int i11, Continuation<? super Unit> continuation) {
            Object objH = LazyListState.H(this.f2587a, i11, 0, continuation, 2, null);
            return objH == kotlin.coroutines.intrinsics.a.e() ? objH : Unit.f68710a;
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public androidx.compose.ui.semantics.b d() {
            return this.f2588b ? new androidx.compose.ui.semantics.b(-1, 1) : new androidx.compose.ui.semantics.b(1, -1);
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public int e() {
            return this.f2587a.t().getOrientation() == Orientation.Vertical ? q2.t.f(this.f2587a.t().a()) : q2.t.g(this.f2587a.t().a());
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public float f() {
            return a0.b(this.f2587a.o(), this.f2587a.p());
        }
    }

    public static final z a(LazyListState lazyListState, boolean z11) {
        return new a(lazyListState, z11);
    }
}
