package u1;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import s1.h;
import t1.d;

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
public final class b<E> extends AbstractSet<E> implements h<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f78144f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f78145g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f78146h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f78147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f78148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<E, u1.a> f78149d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <E> h<E> a() {
            return b.f78146h;
        }
    }

    static {
        v1.c cVar = v1.c.f78697a;
        f78146h = new b(cVar, cVar, d.f76671g.a());
    }

    public b(Object obj, Object obj2, d<E, u1.a> dVar) {
        this.f78147b = obj;
        this.f78148c = obj2;
        this.f78149d = dVar;
    }

    @Override // java.util.Collection, java.util.Set, s1.h
    public h<E> add(E e11) {
        if (this.f78149d.containsKey(e11)) {
            return this;
        }
        if (isEmpty()) {
            return new b(e11, e11, this.f78149d.v(e11, new u1.a()));
        }
        Object obj = this.f78148c;
        u1.a aVar = this.f78149d.get((E) obj);
        Intrinsics.d(aVar);
        return new b(this.f78147b, e11, this.f78149d.v((E) obj, aVar.e(e11)).v(e11, new u1.a(obj)));
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f78149d.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f78149d.size();
    }

    @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new c(this.f78147b, this.f78149d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set, s1.h
    public h<E> remove(E e11) {
        u1.a aVar = this.f78149d.get(e11);
        if (aVar == null) {
            return this;
        }
        d dVarW = this.f78149d.w(e11);
        if (aVar.b()) {
            V v11 = dVarW.get(aVar.d());
            Intrinsics.d(v11);
            dVarW = dVarW.v(aVar.d(), ((u1.a) v11).e(aVar.c()));
        }
        if (aVar.a()) {
            V v12 = dVarW.get(aVar.c());
            Intrinsics.d(v12);
            dVarW = dVarW.v(aVar.c(), ((u1.a) v12).f(aVar.d()));
        }
        return new b(!aVar.b() ? aVar.c() : this.f78147b, !aVar.a() ? aVar.d() : this.f78148c, dVarW);
    }
}
