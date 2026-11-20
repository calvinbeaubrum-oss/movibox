package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.q1;

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
public final class FontListFontFamilyTypefaceAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5806c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5807d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f5808e = new p();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final kotlinx.coroutines.g0 f5809f = new b(kotlinx.coroutines.g0.f69429i8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncTypefaceCache f5810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kotlinx.coroutines.k0 f5811b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b extends AbstractCoroutineContextElement implements kotlinx.coroutines.g0 {
        public b(kotlinx.coroutines.g0.a aVar) {
            super(aVar);
        }

        @Override // kotlinx.coroutines.g0
        public void l(CoroutineContext coroutineContext, Throwable th2) {
        }
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, CoroutineContext coroutineContext) {
        this.f5810a = asyncTypefaceCache;
        this.f5811b = kotlinx.coroutines.l0.a(f5809f.plus(androidx.compose.ui.text.platform.k.a()).plus(coroutineContext).plus(l2.a((q1) coroutineContext.get(q1.f69514j8))));
    }

    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, CoroutineContext coroutineContext, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache, (i11 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext);
    }

    public o0 a(n0 n0Var, a0 a0Var, Function1<? super o0.b, Unit> function1, Function1<? super n0, ? extends Object> function2) {
        if (!(n0Var.c() instanceof m)) {
            return null;
        }
        Pair pairB = n.b(f5808e.a(((m) n0Var.c()).i(), n0Var.f(), n0Var.d()), n0Var, this.f5810a, a0Var, function2);
        List list = (List) pairB.component1();
        Object objComponent2 = pairB.component2();
        if (list == null) {
            return new o0.b(objComponent2, false, 2, null);
        }
        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list, objComponent2, n0Var, this.f5810a, function1, a0Var);
        kotlinx.coroutines.j.d(this.f5811b, null, CoroutineStart.UNDISPATCHED, new FontListFontFamilyTypefaceAdapter$resolve$1(asyncFontListLoader, null), 1, null);
        return new o0.a(asyncFontListLoader);
    }
}
