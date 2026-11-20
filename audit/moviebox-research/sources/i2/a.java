package i2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import y1.i;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f66879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f66880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f66881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f66882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f66883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f66884f;

    public a(Function0<Unit> function0, i iVar, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4) {
        this.f66879a = function0;
        this.f66880b = iVar;
        this.f66881c = function1;
        this.f66882d = function2;
        this.f66883e = function3;
        this.f66884f = function4;
    }

    public /* synthetic */ a(Function0 function0, i iVar, Function0 function1, Function0 function2, Function0 function3, Function0 function4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : function0, (i11 & 2) != 0 ? i.f81075e.a() : iVar, (i11 & 4) != 0 ? null : function1, (i11 & 8) != 0 ? null : function2, (i11 & 16) != 0 ? null : function3, (i11 & 32) != 0 ? null : function4);
    }
}
