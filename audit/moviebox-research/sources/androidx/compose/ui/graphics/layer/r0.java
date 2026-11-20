package androidx.compose.ui.graphics.layer;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.Surface;
import java.lang.reflect.Method;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f4304a = new r0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f4305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4306c;

    public final boolean a() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return true;
        }
        return i11 == 22 && b() != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public final Method b() {
        Method method;
        synchronized (this) {
            try {
                method = f4305b;
                if (!f4306c) {
                    f4306c = true;
                    Method declaredMethod = Surface.class.getDeclaredMethod("lockHardwareCanvas", new Class[0]);
                    declaredMethod.setAccessible(true);
                    f4305b = declaredMethod;
                    method = declaredMethod;
                }
            } catch (Throwable unused) {
                method = null;
                f4305b = null;
            }
        }
        return method;
    }
}
