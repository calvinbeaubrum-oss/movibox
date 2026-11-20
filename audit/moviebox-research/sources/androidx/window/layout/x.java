package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public interface x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13223a = a.f13224a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f13224a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f13225b = Reflection.b(x.class).e();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static y f13226c = m.f13189a;

        @JvmStatic
        @JvmName
        public final x a(Context context) {
            Intrinsics.g(context, "context");
            return f13226c.a(new WindowInfoTrackerImpl(f0.f13186a, b(context)));
        }

        public final v b(Context context) {
            Intrinsics.g(context, "context");
            p pVar = null;
            try {
                WindowLayoutComponent windowLayoutComponentM = SafeWindowLayoutComponentProvider.f13154a.m();
                if (windowLayoutComponentM != null) {
                    pVar = new p(windowLayoutComponentM);
                }
            } catch (Throwable unused) {
            }
            return pVar == null ? t.f13211c.a(context) : pVar;
        }
    }

    kotlinx.coroutines.flow.a<a0> a(Activity activity);
}
