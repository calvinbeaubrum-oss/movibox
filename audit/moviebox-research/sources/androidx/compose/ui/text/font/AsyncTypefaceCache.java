package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
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
@SourceDebugExtension
public final class AsyncTypefaceCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5793a = a.b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2.b<b, a> f5794b = new o2.b<>(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o2.c<b, a> f5795c = new o2.c<>(0, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.text.platform.q f5796d = androidx.compose.ui.text.platform.p.a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5797a;

        public /* synthetic */ a(Object obj) {
            this.f5797a = obj;
        }

        public static final /* synthetic */ a a(Object obj) {
            return new a(obj);
        }

        public static Object b(Object obj) {
            return obj;
        }

        public static boolean c(Object obj, Object obj2) {
            return (obj2 instanceof a) && Intrinsics.b(obj, ((a) obj2).g());
        }

        public static int d(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public static final boolean e(Object obj) {
            return obj == null;
        }

        public static String f(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return c(this.f5797a, obj);
        }

        public final /* synthetic */ Object g() {
            return this.f5797a;
        }

        public int hashCode() {
            return d(this.f5797a);
        }

        public String toString() {
            return f(this.f5797a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f5798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f5799b;

        public b(h hVar, Object obj) {
            this.f5798a = hVar;
            this.f5799b = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f5798a, bVar.f5798a) && Intrinsics.b(this.f5799b, bVar.f5799b);
        }

        public int hashCode() {
            int iHashCode = this.f5798a.hashCode() * 31;
            Object obj = this.f5799b;
            return iHashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "Key(font=" + this.f5798a + ", loaderKey=" + this.f5799b + ')';
        }
    }

    public static /* synthetic */ void f(AsyncTypefaceCache asyncTypefaceCache, h hVar, a0 a0Var, Object obj, boolean z11, int i11, Object obj2) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        asyncTypefaceCache.e(hVar, a0Var, obj, z11);
    }

    public final a d(h hVar, a0 a0Var) {
        a aVarD;
        b bVar = new b(hVar, a0Var.b());
        synchronized (this.f5796d) {
            aVarD = this.f5794b.d(bVar);
            if (aVarD == null) {
                aVarD = this.f5795c.b(bVar);
            }
        }
        return aVarD;
    }

    public final void e(h hVar, a0 a0Var, Object obj, boolean z11) {
        b bVar = new b(hVar, a0Var.b());
        synchronized (this.f5796d) {
            try {
                if (obj == null) {
                    this.f5795c.h(bVar, a.a(this.f5793a));
                } else if (z11) {
                    this.f5795c.h(bVar, a.a(a.b(obj)));
                } else {
                    this.f5794b.e(bVar, a.a(a.b(obj)));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(h hVar, a0 a0Var, boolean z11, Function1<? super Continuation<Object>, ? extends Object> function1, Continuation<Object> continuation) throws Throwable {
        AsyncTypefaceCache$runCached$1 asyncTypefaceCache$runCached$1;
        AsyncTypefaceCache asyncTypefaceCache;
        b bVar;
        if (continuation instanceof AsyncTypefaceCache$runCached$1) {
            asyncTypefaceCache$runCached$1 = (AsyncTypefaceCache$runCached$1) continuation;
            int i11 = asyncTypefaceCache$runCached$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                asyncTypefaceCache$runCached$1.label = i11 - Integer.MIN_VALUE;
            } else {
                asyncTypefaceCache$runCached$1 = new AsyncTypefaceCache$runCached$1(this, continuation);
            }
        } else {
            asyncTypefaceCache$runCached$1 = new AsyncTypefaceCache$runCached$1(this, continuation);
        }
        Object obj = asyncTypefaceCache$runCached$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = asyncTypefaceCache$runCached$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            b bVar2 = new b(hVar, a0Var.b());
            synchronized (this.f5796d) {
                try {
                    a aVarD = this.f5794b.d(bVar2);
                    if (aVarD == null) {
                        aVarD = this.f5795c.b(bVar2);
                    }
                    if (aVarD != null) {
                        return aVarD.g();
                    }
                    Unit unit = Unit.f68710a;
                    asyncTypefaceCache$runCached$1.L$0 = this;
                    asyncTypefaceCache$runCached$1.L$1 = bVar2;
                    asyncTypefaceCache$runCached$1.Z$0 = z11;
                    asyncTypefaceCache$runCached$1.label = 1;
                    Object objInvoke = function1.invoke(asyncTypefaceCache$runCached$1);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    asyncTypefaceCache = this;
                    obj = objInvoke;
                    bVar = bVar2;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z11 = asyncTypefaceCache$runCached$1.Z$0;
            bVar = (b) asyncTypefaceCache$runCached$1.L$1;
            asyncTypefaceCache = (AsyncTypefaceCache) asyncTypefaceCache$runCached$1.L$0;
            ResultKt.b(obj);
        }
        synchronized (asyncTypefaceCache.f5796d) {
            try {
                if (obj == null) {
                    asyncTypefaceCache.f5795c.h(bVar, a.a(asyncTypefaceCache.f5793a));
                } else if (z11) {
                    asyncTypefaceCache.f5795c.h(bVar, a.a(a.b(obj)));
                } else {
                    asyncTypefaceCache.f5794b.e(bVar, a.a(a.b(obj)));
                }
                Unit unit2 = Unit.f68710a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return obj;
    }
}
