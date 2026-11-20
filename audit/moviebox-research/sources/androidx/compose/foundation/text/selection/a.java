package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.q;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.platform.r2;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r2 f3004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f3006c;

    public a(r2 r2Var) {
        this.f3004a = r2Var;
    }

    public final int a() {
        return this.f3005b;
    }

    public final boolean b(z zVar, z zVar2) {
        return SelectionGesturesKt.f(this.f3004a, zVar, zVar2);
    }

    public final boolean c(z zVar, z zVar2) {
        return zVar2.o() - zVar.o() < this.f3004a.a();
    }

    public final void d(q qVar) {
        z zVar = this.f3006c;
        z zVar2 = qVar.c().get(0);
        if (zVar != null && c(zVar, zVar2) && b(zVar, zVar2)) {
            this.f3005b++;
        } else {
            this.f3005b = 1;
        }
        this.f3006c = zVar2;
    }
}
