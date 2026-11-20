package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.collection.v<z> f4702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f4703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4704c;

    public i(androidx.collection.v<z> vVar, b0 b0Var) {
        this.f4702a = vVar;
        this.f4703b = b0Var;
    }

    public final boolean a(long j11) {
        c0 c0Var;
        List<c0> listB = this.f4703b.b();
        int size = listB.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                c0Var = null;
                break;
            }
            c0Var = listB.get(i11);
            if (y.d(c0Var.d(), j11)) {
                break;
            }
            i11++;
        }
        c0 c0Var2 = c0Var;
        if (c0Var2 != null) {
            return c0Var2.a();
        }
        return false;
    }

    public final androidx.collection.v<z> b() {
        return this.f4702a;
    }

    public final MotionEvent c() {
        return this.f4703b.a();
    }

    public final boolean d() {
        return this.f4704c;
    }

    public final void e(boolean z11) {
        this.f4704c = z11;
    }
}
