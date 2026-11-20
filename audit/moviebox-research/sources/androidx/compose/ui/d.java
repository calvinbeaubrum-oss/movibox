package androidx.compose.ui;

import androidx.compose.ui.platform.e1;
import androidx.compose.ui.platform.f1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
public class d extends f1 implements f.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<f, androidx.compose.runtime.i, Integer, f> f3814c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super e1, Unit> function1, Function3<? super f, ? super androidx.compose.runtime.i, ? super Integer, ? extends f> function3) {
        super(function1);
        this.f3814c = function3;
    }

    public final Function3<f, androidx.compose.runtime.i, Integer, f> a() {
        return this.f3814c;
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object c(Object obj, Function2 function2) {
        return g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean d(Function1 function1) {
        return g.a(this, function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ f f(f fVar) {
        return e.a(this, fVar);
    }
}
