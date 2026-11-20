package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public interface i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3413a = a.f3414a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3414a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Object f3415b = new C0050a();

        /* JADX INFO: renamed from: androidx.compose.runtime.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0050a {
            public String toString() {
                return "Empty";
            }
        }

        public final Object a() {
            return f3415b;
        }
    }

    boolean A(Object obj);

    void B();

    void C(int i11, Object obj);

    void D();

    void E(t1<?> t1Var);

    void F(int i11, Object obj);

    <T> void G(Function0<? extends T> function0);

    void H();

    void I();

    boolean J();

    void K(u1 u1Var);

    void L();

    int M();

    m N();

    void O();

    void P();

    boolean Q(Object obj);

    void R(int i11);

    void S(t1<?>[] t1VarArr);

    boolean a(boolean z11);

    boolean b(float f11);

    boolean c(int i11);

    boolean d(long j11);

    boolean e();

    void f(boolean z11);

    i g(int i11);

    boolean h();

    f<?> i();

    g2 j();

    <V, T> void k(V v11, Function2<? super T, ? super V, Unit> function2);

    <T> T l(q<T> qVar);

    CoroutineContext m();

    s n();

    void o();

    void p(Object obj);

    void q();

    void r();

    void s();

    void t(Function0<Unit> function0);

    void u();

    u1 v();

    void w();

    void x(int i11);

    Object y();

    w1.a z();
}
