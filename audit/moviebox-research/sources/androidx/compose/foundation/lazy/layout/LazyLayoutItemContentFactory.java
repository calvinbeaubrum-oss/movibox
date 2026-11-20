package androidx.compose.foundation.lazy.layout;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
public final class LazyLayoutItemContentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.saveable.a f2641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<m> f2642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Object, CachedItemContent> f2643c = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class CachedItemContent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f2645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> f2647d;

        public CachedItemContent(int i11, Object obj, Object obj2) {
            this.f2644a = obj;
            this.f2645b = obj2;
            this.f2646c = i11;
        }

        public final Function2<androidx.compose.runtime.i, Integer, Unit> c() {
            final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = LazyLayoutItemContentFactory.this;
            return androidx.compose.runtime.internal.b.c(1403994769, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar, Integer num) {
                    invoke(iVar, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                    if ((i11 & 3) == 2 && iVar.h()) {
                        iVar.H();
                        return;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(1403994769, i11, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:91)");
                    }
                    m mVarInvoke = lazyLayoutItemContentFactory.d().invoke();
                    int iF = this.f();
                    if ((iF >= mVarInvoke.getItemCount() || !Intrinsics.b(mVarInvoke.b(iF), this.g())) && (iF = mVarInvoke.a(this.g())) != -1) {
                        this.f2646c = iF;
                    }
                    int i12 = iF;
                    if (i12 != -1) {
                        iVar.R(-660479623);
                        LazyLayoutItemContentFactoryKt.a(mVarInvoke, k0.a(lazyLayoutItemContentFactory.f2641a), i12, k0.a(this.g()), iVar, 0);
                        iVar.L();
                    } else {
                        iVar.R(-660272047);
                        iVar.L();
                    }
                    Object objG = this.g();
                    boolean zA = iVar.A(this);
                    final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this;
                    Object objY = iVar.y();
                    if (zA || objY == androidx.compose.runtime.i.f3413a.a()) {
                        objY = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$1$1

                            /* JADX INFO: compiled from: source.java */
                            @Metadata
                            @SourceDebugExtension
                            public static final class a implements androidx.compose.runtime.c0 {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                public final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent f2649a;

                                public a(LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
                                    this.f2649a = cachedItemContent;
                                }

                                @Override // androidx.compose.runtime.c0
                                public void dispose() {
                                    this.f2649a.f2647d = null;
                                }
                            }

                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                                return new a(cachedItemContent);
                            }
                        };
                        iVar.p(objY);
                    }
                    androidx.compose.runtime.g0.a(objG, (Function1) objY, iVar, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                }
            });
        }

        public final Function2<androidx.compose.runtime.i, Integer, Unit> d() {
            Function2 function2 = this.f2647d;
            if (function2 != null) {
                return function2;
            }
            Function2<androidx.compose.runtime.i, Integer, Unit> function2C = c();
            this.f2647d = function2C;
            return function2C;
        }

        public final Object e() {
            return this.f2645b;
        }

        public final int f() {
            return this.f2646c;
        }

        public final Object g() {
            return this.f2644a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutItemContentFactory(androidx.compose.runtime.saveable.a aVar, Function0<? extends m> function0) {
        this.f2641a = aVar;
        this.f2642b = function0;
    }

    public final Function2<androidx.compose.runtime.i, Integer, Unit> b(int i11, Object obj, Object obj2) {
        CachedItemContent cachedItemContent = this.f2643c.get(obj);
        if (cachedItemContent != null && cachedItemContent.f() == i11 && Intrinsics.b(cachedItemContent.e(), obj2)) {
            return cachedItemContent.d();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(i11, obj, obj2);
        this.f2643c.put(obj, cachedItemContent2);
        return cachedItemContent2.d();
    }

    public final Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        CachedItemContent cachedItemContent = this.f2643c.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.e();
        }
        m mVarInvoke = this.f2642b.invoke();
        int iA = mVarInvoke.a(obj);
        if (iA != -1) {
            return mVarInvoke.c(iA);
        }
        return null;
    }

    public final Function0<m> d() {
        return this.f2642b;
    }
}
