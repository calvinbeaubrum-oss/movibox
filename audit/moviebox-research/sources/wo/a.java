package wo;

import android.app.Application;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0894a f79569a = new C0894a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f79570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f79571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f79572d;

    /* JADX INFO: renamed from: wo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0894a {
        public C0894a() {
        }

        public /* synthetic */ C0894a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return a.f79572d;
        }

        public final b b() {
            return a.f79571c;
        }

        public final boolean c() {
            b bVarB = b();
            return (bVarB != null && bVarB.c()) || Log.isLoggable("net_proxy_tag", 3);
        }

        public final boolean d() {
            b bVarB;
            if (a() || (bVarB = b()) == null) {
                return false;
            }
            return bVarB.d();
        }

        public final void e(Application application) {
            a.f79570b = application;
        }

        public final void f(Application application, b bVar) {
            Intrinsics.g(application, "application");
            e(application);
            i(bVar);
        }

        public final void g(boolean z11) {
            a.f79572d = z11;
        }

        public final void h(boolean z11) {
            g(z11);
        }

        public final void i(b bVar) {
            a.f79571c = bVar;
        }
    }
}
