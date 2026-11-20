package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f2748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<d0, Unit> f2749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f2750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PrefetchHandleProvider f2751d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<g0> f2752a = new ArrayList();

        public a() {
        }

        @Override // androidx.compose.foundation.lazy.layout.d0
        public void a(int i11) {
            c(i11, y.f2754a);
        }

        public final List<g0> b() {
            return this.f2752a;
        }

        public void c(int i11, long j11) {
            PrefetchHandleProvider prefetchHandleProviderC = x.this.c();
            if (prefetchHandleProviderC == null) {
                return;
            }
            this.f2752a.add(prefetchHandleProviderC.c(i11, j11, x.this.f2750c));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a();

        void cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(i0 i0Var, Function1<? super d0, Unit> function1) {
        this.f2748a = i0Var;
        this.f2749b = function1;
        this.f2750c = new f0();
    }

    public /* synthetic */ x(i0 i0Var, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : i0Var, (i11 & 2) != 0 ? null : function1);
    }

    public final List<g0> b() {
        Function1<d0, Unit> function1 = this.f2749b;
        if (function1 == null) {
            return kotlin.collections.g.l();
        }
        a aVar = new a();
        function1.invoke(aVar);
        return aVar.b();
    }

    public final PrefetchHandleProvider c() {
        return this.f2751d;
    }

    public final i0 d() {
        return this.f2748a;
    }

    public final b e(int i11, long j11) {
        b bVarD;
        PrefetchHandleProvider prefetchHandleProvider = this.f2751d;
        return (prefetchHandleProvider == null || (bVarD = prefetchHandleProvider.d(i11, j11, this.f2750c)) == null) ? androidx.compose.foundation.lazy.layout.a.f2693a : bVarD;
    }

    public final void f(PrefetchHandleProvider prefetchHandleProvider) {
        this.f2751d = prefetchHandleProvider;
    }
}
