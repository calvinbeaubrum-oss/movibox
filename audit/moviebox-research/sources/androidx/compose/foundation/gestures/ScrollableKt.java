package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.f0;
import androidx.compose.ui.input.pointer.k0;
import androidx.compose.ui.input.pointer.z;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
public final class ScrollableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function1<z, Boolean> f2328a = new Function1<z, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$CanDragCalculation$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(z zVar) {
            return Boolean.valueOf(!k0.g(zVar.n(), k0.f4712a.b()));
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f2329b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.compose.ui.j f2330c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f2331d = new c();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.compose.ui.j {
        @Override // androidx.compose.ui.j
        public float d() {
            return 1.0f;
        }

        @Override // kotlin.coroutines.CoroutineContext
        public <R> R fold(R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) androidx.compose.ui.j.a.a(this, r11, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
            return (E) androidx.compose.ui.j.a.b(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element
        public /* synthetic */ CoroutineContext.Key getKey() {
            return androidx.compose.ui.i.a(this);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
            return androidx.compose.ui.j.a.c(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return androidx.compose.ui.j.a.d(this, coroutineContext);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements k {
        @Override // androidx.compose.foundation.gestures.k
        public float a(float f11) {
            return f11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements q2.e {
        @Override // q2.e
        public /* synthetic */ float H0(float f11) {
            return q2.d.b(this, f11);
        }

        @Override // q2.n
        public /* synthetic */ long M(float f11) {
            return q2.m.b(this, f11);
        }

        @Override // q2.n
        public float M0() {
            return 1.0f;
        }

        @Override // q2.e
        public /* synthetic */ float N0(float f11) {
            return q2.d.d(this, f11);
        }

        @Override // q2.n
        public /* synthetic */ float O(long j11) {
            return q2.m.a(this, j11);
        }

        @Override // q2.e
        public /* synthetic */ long V0(long j11) {
            return q2.d.e(this, j11);
        }

        @Override // q2.e
        public /* synthetic */ long X(float f11) {
            return q2.d.f(this, f11);
        }

        @Override // q2.e
        public float getDensity() {
            return 1.0f;
        }

        @Override // q2.e
        public /* synthetic */ int k0(float f11) {
            return q2.d.a(this, f11);
        }

        @Override // q2.e
        public /* synthetic */ float p0(long j11) {
            return q2.d.c(this, j11);
        }
    }

    public static final androidx.compose.ui.j e() {
        return f2330c;
    }

    public static final androidx.compose.ui.f f(androidx.compose.ui.f fVar, o oVar, Orientation orientation, f0 f0Var, boolean z11, boolean z12, g gVar, o1.i iVar, d dVar) {
        return fVar.f(new ScrollableElement(oVar, orientation, f0Var, z11, z12, gVar, iVar, dVar));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object g(ScrollingLogic scrollingLogic, long j11, Continuation<? super y1.g> continuation) throws Throwable {
        ScrollableKt$semanticsScrollBy$1 scrollableKt$semanticsScrollBy$1;
        Ref.FloatRef floatRef;
        if (continuation instanceof ScrollableKt$semanticsScrollBy$1) {
            scrollableKt$semanticsScrollBy$1 = (ScrollableKt$semanticsScrollBy$1) continuation;
            int i11 = scrollableKt$semanticsScrollBy$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                scrollableKt$semanticsScrollBy$1.label = i11 - Integer.MIN_VALUE;
            } else {
                scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuation);
            }
        } else {
            scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuation);
        }
        Object obj = scrollableKt$semanticsScrollBy$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = scrollableKt$semanticsScrollBy$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            floatRef = new Ref.FloatRef();
            MutatePriority mutatePriority = MutatePriority.Default;
            ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(scrollingLogic, j11, floatRef, null);
            scrollableKt$semanticsScrollBy$1.L$0 = scrollingLogic;
            scrollableKt$semanticsScrollBy$1.L$1 = floatRef;
            scrollableKt$semanticsScrollBy$1.label = 1;
            if (scrollingLogic.v(mutatePriority, scrollableKt$semanticsScrollBy$2, scrollableKt$semanticsScrollBy$1) == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.FloatRef floatRef2 = (Ref.FloatRef) scrollableKt$semanticsScrollBy$1.L$1;
            ScrollingLogic scrollingLogic2 = (ScrollingLogic) scrollableKt$semanticsScrollBy$1.L$0;
            ResultKt.b(obj);
            floatRef = floatRef2;
            scrollingLogic = scrollingLogic2;
        }
        return y1.g.d(scrollingLogic.B(floatRef.element));
    }
}
