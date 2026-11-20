package androidx.compose.ui.layout;

import kotlin.Metadata;

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
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4870a = a.f4871a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4871a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f4872b = new C0059a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f4873c = new e();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f4874d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f4875e = new d();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f4876f = new C0060f();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f4877g = new h(1.0f);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final f f4878h = new b();

        /* JADX INFO: renamed from: androidx.compose.ui.layout.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0059a implements f {
            @Override // androidx.compose.ui.layout.f
            public long a(long j11, long j12) {
                float f11 = g.f(j11, j12);
                return q0.a(f11, f11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b implements f {
            @Override // androidx.compose.ui.layout.f
            public long a(long j11, long j12) {
                return q0.a(g.h(j11, j12), g.e(j11, j12));
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class c implements f {
            @Override // androidx.compose.ui.layout.f
            public long a(long j11, long j12) {
                float fE = g.e(j11, j12);
                return q0.a(fE, fE);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class d implements f {
            @Override // androidx.compose.ui.layout.f
            public long a(long j11, long j12) {
                float fH = g.h(j11, j12);
                return q0.a(fH, fH);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class e implements f {
            @Override // androidx.compose.ui.layout.f
            public long a(long j11, long j12) {
                float fG = g.g(j11, j12);
                return q0.a(fG, fG);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.ui.layout.f$a$f, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0060f implements f {
            @Override // androidx.compose.ui.layout.f
            public long a(long j11, long j12) {
                if (y1.m.i(j11) <= y1.m.i(j12) && y1.m.g(j11) <= y1.m.g(j12)) {
                    return q0.a(1.0f, 1.0f);
                }
                float fG = g.g(j11, j12);
                return q0.a(fG, fG);
            }
        }

        public final f a() {
            return f4873c;
        }

        public final f b() {
            return f4876f;
        }
    }

    long a(long j11, long j12);
}
