package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
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
public final class c1<V extends o> implements b1<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f2052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public V f2053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V f2054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V f2055d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f2056a;

        public a(e0 e0Var) {
            this.f2056a = e0Var;
        }

        @Override // androidx.compose.animation.core.q
        public e0 get(int i11) {
            return this.f2056a;
        }
    }

    public c1(e0 e0Var) {
        this(new a(e0Var));
    }

    public c1(q qVar) {
        this.f2052a = qVar;
    }

    @Override // androidx.compose.animation.core.v0
    public /* synthetic */ boolean a() {
        return a1.a(this);
    }

    @Override // androidx.compose.animation.core.v0
    public V c(V v11, V v12, V v13) {
        if (this.f2055d == null) {
            this.f2055d = (V) p.g(v13);
        }
        V v14 = this.f2055d;
        if (v14 == null) {
            Intrinsics.y("endVelocityVector");
            v14 = null;
        }
        int iB = v14.b();
        for (int i11 = 0; i11 < iB; i11++) {
            V v15 = this.f2055d;
            if (v15 == null) {
                Intrinsics.y("endVelocityVector");
                v15 = null;
            }
            v15.e(i11, this.f2052a.get(i11).b(v11.a(i11), v12.a(i11), v13.a(i11)));
        }
        V v16 = this.f2055d;
        if (v16 != null) {
            return v16;
        }
        Intrinsics.y("endVelocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.v0
    public V e(long j11, V v11, V v12, V v13) {
        if (this.f2054c == null) {
            this.f2054c = (V) p.g(v13);
        }
        V v14 = this.f2054c;
        if (v14 == null) {
            Intrinsics.y("velocityVector");
            v14 = null;
        }
        int iB = v14.b();
        for (int i11 = 0; i11 < iB; i11++) {
            V v15 = this.f2054c;
            if (v15 == null) {
                Intrinsics.y("velocityVector");
                v15 = null;
            }
            v15.e(i11, this.f2052a.get(i11).d(j11, v11.a(i11), v12.a(i11), v13.a(i11)));
        }
        V v16 = this.f2054c;
        if (v16 != null) {
            return v16;
        }
        Intrinsics.y("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.v0
    public long f(V v11, V v12, V v13) {
        Iterator<Integer> it = kotlin.ranges.a.r(0, v11.b()).iterator();
        long jMax = 0;
        while (it.hasNext()) {
            int iA = ((IntIterator) it).a();
            jMax = Math.max(jMax, this.f2052a.get(iA).e(v11.a(iA), v12.a(iA), v13.a(iA)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.v0
    public V g(long j11, V v11, V v12, V v13) {
        if (this.f2053b == null) {
            this.f2053b = (V) p.g(v11);
        }
        V v14 = this.f2053b;
        if (v14 == null) {
            Intrinsics.y("valueVector");
            v14 = null;
        }
        int iB = v14.b();
        for (int i11 = 0; i11 < iB; i11++) {
            V v15 = this.f2053b;
            if (v15 == null) {
                Intrinsics.y("valueVector");
                v15 = null;
            }
            v15.e(i11, this.f2052a.get(i11).c(j11, v11.a(i11), v12.a(i11), v13.a(i11)));
        }
        V v16 = this.f2053b;
        if (v16 != null) {
            return v16;
        }
        Intrinsics.y("valueVector");
        return null;
    }
}
