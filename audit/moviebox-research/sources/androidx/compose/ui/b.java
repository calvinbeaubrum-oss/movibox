package androidx.compose.ui;

import androidx.compose.ui.unit.LayoutDirection;
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
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3770a = a.f3771a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3771a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3772b = new androidx.compose.ui.c(-1.0f, -1.0f);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f3773c = new androidx.compose.ui.c(0.0f, -1.0f);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f3774d = new androidx.compose.ui.c(1.0f, -1.0f);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f3775e = new androidx.compose.ui.c(-1.0f, 0.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f3776f = new androidx.compose.ui.c(0.0f, 0.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f3777g = new androidx.compose.ui.c(1.0f, 0.0f);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f3778h = new androidx.compose.ui.c(-1.0f, 1.0f);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f3779i = new androidx.compose.ui.c(0.0f, 1.0f);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f3780j = new androidx.compose.ui.c(1.0f, 1.0f);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final c f3781k = new androidx.compose.ui.c.b(-1.0f);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final c f3782l = new androidx.compose.ui.c.b(0.0f);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final c f3783m = new androidx.compose.ui.c.b(1.0f);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final InterfaceC0052b f3784n = new androidx.compose.ui.c.a(-1.0f);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final InterfaceC0052b f3785o = new androidx.compose.ui.c.a(0.0f);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final InterfaceC0052b f3786p = new androidx.compose.ui.c.a(1.0f);

        public final b a() {
            return f3779i;
        }

        public final b b() {
            return f3780j;
        }

        public final b c() {
            return f3778h;
        }

        public final b d() {
            return f3776f;
        }

        public final b e() {
            return f3777g;
        }

        public final InterfaceC0052b f() {
            return f3785o;
        }

        public final b g() {
            return f3775e;
        }

        public final c h() {
            return f3782l;
        }

        public final InterfaceC0052b i() {
            return f3784n;
        }

        public final c j() {
            return f3781k;
        }

        public final b k() {
            return f3773c;
        }

        public final b l() {
            return f3774d;
        }

        public final b m() {
            return f3772b;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface InterfaceC0052b {
        int a(int i11, int i12, LayoutDirection layoutDirection);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface c {
        int a(int i11, int i12);
    }

    long a(long j11, long j12, LayoutDirection layoutDirection);
}
