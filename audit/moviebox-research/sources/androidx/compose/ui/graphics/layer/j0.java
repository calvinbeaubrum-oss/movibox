package androidx.compose.ui.graphics.layer;

import android.os.Build;
import android.view.View;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f4296a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f4297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4298c;

    public final boolean a(View view) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT >= 22) {
            view.invalidateOutline();
            return true;
        }
        try {
            synchronized (this) {
                try {
                    if (f4298c) {
                        declaredMethod = f4297b;
                        Unit unit = Unit.f68710a;
                    } else {
                        f4298c = true;
                        declaredMethod = View.class.getDeclaredMethod("rebuildOutline", new Class[0]);
                        if (declaredMethod != null) {
                            declaredMethod.setAccessible(true);
                            f4297b = declaredMethod;
                            Unit unit2 = Unit.f68710a;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (declaredMethod != null) {
                declaredMethod.invoke(view, new Object[0]);
            }
            return declaredMethod != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
