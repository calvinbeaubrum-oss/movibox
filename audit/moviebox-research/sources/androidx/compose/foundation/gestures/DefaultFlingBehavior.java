package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.w;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class DefaultFlingBehavior implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w<Float> f2292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.ui.j f2293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2294c;

    public DefaultFlingBehavior(w<Float> wVar, androidx.compose.ui.j jVar) {
        this.f2292a = wVar;
        this.f2293b = jVar;
    }

    public /* synthetic */ DefaultFlingBehavior(w wVar, androidx.compose.ui.j jVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(wVar, (i11 & 2) != 0 ? ScrollableKt.e() : jVar);
    }

    @Override // androidx.compose.foundation.gestures.g
    public Object a(k kVar, float f11, Continuation<? super Float> continuation) {
        this.f2294c = 0;
        return kotlinx.coroutines.h.g(this.f2293b, new DefaultFlingBehavior$performFling$2(f11, this, kVar, null), continuation);
    }

    public final w<Float> b() {
        return this.f2292a;
    }

    public final int c() {
        return this.f2294c;
    }

    public final void d(w<Float> wVar) {
        this.f2292a = wVar;
    }

    public final void e(int i11) {
        this.f2294c = i11;
    }
}
