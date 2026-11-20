package androidx.compose.runtime.internal;

import androidx.compose.runtime.g3;
import androidx.compose.runtime.m1;
import androidx.compose.runtime.n1;
import androidx.compose.runtime.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t1.t;

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
public final class e extends t1.d<q<Object>, g3<Object>> implements n1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f3441j = new b(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f3442k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends t1.f<q<Object>, g3<Object>> implements n1.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e f3443h;

        public a(e eVar) {
            super(eVar);
            this.f3443h = eVar;
        }

        @Override // t1.f, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof q) {
                return r((q) obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof g3) {
                return s((g3) obj);
            }
            return false;
        }

        @Override // t1.f, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof q) {
                return t((q) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof q) ? obj2 : u((q) obj, (g3) obj2);
        }

        @Override // t1.f
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public e build() {
            e eVar;
            if (i() == this.f3443h.t()) {
                eVar = this.f3443h;
            } else {
                m(new v1.e());
                eVar = new e(i(), size());
            }
            this.f3443h = eVar;
            return eVar;
        }

        public /* bridge */ boolean r(q<Object> qVar) {
            return super.containsKey(qVar);
        }

        @Override // t1.f, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof q) {
                return v((q) obj);
            }
            return null;
        }

        public /* bridge */ boolean s(g3<Object> g3Var) {
            return super.containsValue(g3Var);
        }

        public /* bridge */ g3<Object> t(q<Object> qVar) {
            return (g3) super.get(qVar);
        }

        public /* bridge */ g3<Object> u(q<Object> qVar, g3<Object> g3Var) {
            return (g3) super.getOrDefault(qVar, g3Var);
        }

        public /* bridge */ g3<Object> v(q<Object> qVar) {
            return (g3) super.remove(qVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return e.f3442k;
        }
    }

    static {
        t tVarA = t.f76696e.a();
        Intrinsics.e(tVarA, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.ValueHolder<kotlin.Any?>>");
        f3442k = new e(tVarA, 0);
    }

    public e(t<q<Object>, g3<Object>> tVar, int i11) {
        super(tVar, i11);
    }

    public /* bridge */ boolean A(g3<Object> g3Var) {
        return super.containsValue(g3Var);
    }

    public /* bridge */ g3<Object> B(q<Object> qVar) {
        return (g3) super.get(qVar);
    }

    public /* bridge */ g3<Object> C(q<Object> qVar, g3<Object> g3Var) {
        return (g3) super.getOrDefault(qVar, g3Var);
    }

    @Override // androidx.compose.runtime.s
    public <T> T a(q<T> qVar) {
        return (T) androidx.compose.runtime.t.b(this, qVar);
    }

    @Override // androidx.compose.runtime.n1
    public n1 b(q<Object> qVar, g3<Object> g3Var) {
        t.b<q<Object>, g3<Object>> bVarP = t().P(qVar.hashCode(), qVar, g3Var, 0);
        return bVarP == null ? this : new e(bVarP.a(), size() + bVarP.b());
    }

    @Override // androidx.compose.runtime.r
    public /* synthetic */ Object c(q qVar) {
        return m1.a(this, qVar);
    }

    @Override // t1.d, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof q) {
            return z((q) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof g3) {
            return A((g3) obj);
        }
        return false;
    }

    @Override // t1.d, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof q) {
            return B((q) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof q) ? obj2 : C((q) obj, (g3) obj2);
    }

    @Override // t1.d
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a q() {
        return new a(this);
    }

    public /* bridge */ boolean z(q<Object> qVar) {
        return super.containsKey(qVar);
    }
}
