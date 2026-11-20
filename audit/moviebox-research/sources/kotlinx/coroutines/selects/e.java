package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class e<Q> implements d<Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f69568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<Object, g<?>, Object, Unit> f69569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<Object, Object, Object, Object> f69570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<g<?>, Object, Object, Function1<Throwable, Unit>> f69571d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object obj, Function3<Object, ? super g<?>, Object, Unit> function3, Function3<Object, Object, Object, ? extends Object> function4, Function3<? super g<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function5) {
        this.f69568a = obj;
        this.f69569b = function3;
        this.f69570c = function4;
        this.f69571d = function5;
    }

    public /* synthetic */ e(Object obj, Function3 function3, Function3 function4, Function3 function5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, function4, (i11 & 8) != 0 ? null : function5);
    }
}
