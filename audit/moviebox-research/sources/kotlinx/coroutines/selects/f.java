package kotlinx.coroutines.selects;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.y0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@PublishedApi
@SourceDebugExtension
public class f<R> extends l implements g, s2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69572g = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "state$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f69573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<f<R>.a> f69574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f69575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f69576d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f69577f;
    private volatile /* synthetic */ Object state$volatile;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final Object f69578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f69579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final Function3<g<?>, Object, Object, Function1<Throwable, Unit>> f69580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public Object f69581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @JvmField
        public int f69582e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f<R> f69583f;

        public final Function1<Throwable, Unit> a(g<?> gVar, Object obj) {
            Function3<g<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.f69580c;
            if (function3 != null) {
                return function3.invoke(gVar, this.f69579b, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f69581d;
            f<R> fVar = this.f69583f;
            if (obj instanceof z) {
                ((z) obj).r(this.f69582e, null, fVar.getContext());
                return;
            }
            y0 y0Var = obj instanceof y0 ? (y0) obj : null;
            if (y0Var != null) {
                y0Var.dispose();
            }
        }
    }

    @Override // kotlinx.coroutines.selects.g
    public void a(Object obj) {
        this.f69577f = obj;
    }

    @Override // kotlinx.coroutines.selects.g
    public void b(y0 y0Var) {
        this.f69575c = y0Var;
    }

    @Override // kotlinx.coroutines.selects.g
    public boolean c(Object obj, Object obj2) {
        return h(obj, obj2) == 0;
    }

    @Override // kotlinx.coroutines.m
    public void d(Throwable th2) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69572g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.f69560c) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, SelectKt.f69561d));
        List<f<R>.a> list = this.f69574b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        this.f69577f = SelectKt.f69562e;
        this.f69574b = null;
    }

    public final f<R>.a e(Object obj) {
        List<f<R>.a> list = this.f69574b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        for (Object obj3 : list) {
            if (((a) obj3).f69578a == obj) {
                obj2 = obj3;
                break;
            }
        }
        f<R>.a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final TrySelectDetailedResult g(Object obj, Object obj2) {
        return SelectKt.a(h(obj, obj2));
    }

    @Override // kotlinx.coroutines.selects.g
    public CoroutineContext getContext() {
        return this.f69573a;
    }

    public final int h(Object obj, Object obj2) {
        while (true) {
            Object obj3 = f69572g.get(this);
            if (obj3 instanceof n) {
                f<R>.a aVarE = e(obj);
                if (aVarE == null) {
                    continue;
                } else {
                    Function1<Throwable, Unit> function1A = aVarE.a(this, obj2);
                    if (androidx.concurrent.futures.a.a(f69572g, this, obj3, aVarE)) {
                        this.f69577f = obj2;
                        if (SelectKt.i((n) obj3, function1A)) {
                            return 0;
                        }
                        this.f69577f = SelectKt.f69562e;
                        return 2;
                    }
                }
            } else {
                if (Intrinsics.b(obj3, SelectKt.f69560c) || (obj3 instanceof a)) {
                    return 3;
                }
                if (Intrinsics.b(obj3, SelectKt.f69561d)) {
                    return 2;
                }
                if (Intrinsics.b(obj3, SelectKt.f69559b)) {
                    if (androidx.concurrent.futures.a.a(f69572g, this, obj3, kotlin.collections.f.e(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (androidx.concurrent.futures.a.a(f69572g, this, obj3, CollectionsKt___CollectionsKt.y0((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
        d(th2);
        return Unit.f68710a;
    }

    @Override // kotlinx.coroutines.s2
    public void invokeOnCancellation(z<?> zVar, int i11) {
        this.f69575c = zVar;
        this.f69576d = i11;
    }
}
