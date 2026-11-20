package androidx.compose.ui.input.pointer;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.collection.v<a> f4667a = new androidx.collection.v<>(0, 1, null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f4668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f4669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4671d;

        public a(long j11, long j12, boolean z11, int i11) {
            this.f4668a = j11;
            this.f4669b = j12;
            this.f4670c = z11;
            this.f4671d = i11;
        }

        public /* synthetic */ a(long j11, long j12, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(j11, j12, z11, i11);
        }

        public final boolean a() {
            return this.f4670c;
        }

        public final long b() {
            return this.f4669b;
        }

        public final long c() {
            return this.f4668a;
        }
    }

    public final void a() {
        this.f4667a.b();
    }

    public final i b(b0 b0Var, l0 l0Var) {
        long jK;
        boolean zA;
        long jMo55screenToLocalMKHz9U;
        androidx.collection.v vVar = new androidx.collection.v(b0Var.b().size());
        List<c0> listB = b0Var.b();
        int size = listB.size();
        for (int i11 = 0; i11 < size; i11++) {
            c0 c0Var = listB.get(i11);
            a aVarF = this.f4667a.f(c0Var.d());
            if (aVarF == null) {
                jK = c0Var.k();
                jMo55screenToLocalMKHz9U = c0Var.f();
                zA = false;
            } else {
                long jC = aVarF.c();
                jK = jC;
                zA = aVarF.a();
                jMo55screenToLocalMKHz9U = l0Var.mo55screenToLocalMKHz9U(aVarF.b());
            }
            vVar.l(c0Var.d(), new z(c0Var.d(), c0Var.k(), c0Var.f(), c0Var.b(), c0Var.h(), jK, jMo55screenToLocalMKHz9U, zA, false, c0Var.j(), c0Var.c(), c0Var.i(), c0Var.e(), null));
            if (c0Var.b()) {
                this.f4667a.l(c0Var.d(), new a(c0Var.k(), c0Var.g(), c0Var.b(), c0Var.j(), null));
            } else {
                this.f4667a.m(c0Var.d());
            }
        }
        return new i(vVar, b0Var);
    }
}
