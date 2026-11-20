package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7778a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final int f7779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final int f7780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final int f7781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public static final int f7782e;

    /* JADX INFO: renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    @Metadata
    public static final class C0072a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0072a f7783a = new C0072a();

        public final int a(int i11) {
            return SdkExtensions.getExtensionVersion(i11);
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        f7779b = i11 >= 30 ? C0072a.f7783a.a(30) : 0;
        f7780c = i11 >= 30 ? C0072a.f7783a.a(31) : 0;
        f7781d = i11 >= 30 ? C0072a.f7783a.a(33) : 0;
        f7782e = i11 >= 30 ? C0072a.f7783a.a(1000000) : 0;
    }

    @JvmStatic
    public static final boolean a(String codename, String buildCodename) {
        Intrinsics.g(codename, "codename");
        Intrinsics.g(buildCodename, "buildCodename");
        if (Intrinsics.b("REL", buildCodename)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        Intrinsics.f(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        Intrinsics.f(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    @Deprecated
    @JvmStatic
    public static final boolean b() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 34) {
            if (i11 >= 33) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.f(CODENAME, "CODENAME");
                if (a("UpsideDownCake", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        if (Build.VERSION.SDK_INT >= 34) {
            String CODENAME = Build.VERSION.CODENAME;
            Intrinsics.f(CODENAME, "CODENAME");
            if (a("VanillaIceCream", CODENAME)) {
                return true;
            }
        }
        return false;
    }
}
