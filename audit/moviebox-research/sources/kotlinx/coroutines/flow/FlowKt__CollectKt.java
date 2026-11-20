package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.q1;

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
public final /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(a<?> aVar, Continuation<? super Unit> continuation) {
        Object objA = aVar.a(kotlinx.coroutines.flow.internal.l.f69415a, continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }

    public static final <T> Object b(a<? extends T> aVar, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objG = c.g(q.b(c.s(aVar, function2), 0, null, 2, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public static final <T> Object c(b<? super T> bVar, a<? extends T> aVar, Continuation<? super Unit> continuation) throws Throwable {
        c.m(bVar);
        Object objA = aVar.a(bVar, continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }

    public static final <T> q1 d(a<? extends T> aVar, kotlinx.coroutines.k0 k0Var) {
        return kotlinx.coroutines.j.d(k0Var, null, null, new FlowKt__CollectKt$launchIn$1(aVar, null), 3, null);
    }
}
