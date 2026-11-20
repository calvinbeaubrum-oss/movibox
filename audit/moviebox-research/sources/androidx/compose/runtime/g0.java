package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f3410a = new d0();

    public static final void a(Object obj, Function1<? super d0, ? extends c0> function1, i iVar, int i11) {
        if (k.J()) {
            k.S(-1371986847, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:155)");
        }
        boolean zQ = iVar.Q(obj);
        Object objY = iVar.y();
        if (zQ || objY == i.f3413a.a()) {
            objY = new b0(function1);
            iVar.p(objY);
        }
        if (k.J()) {
            k.R();
        }
    }

    public static final void b(Object[] objArr, Function1<? super d0, ? extends c0> function1, i iVar, int i11) {
        if (k.J()) {
            k.S(-1307627122, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:276)");
        }
        boolean zQ = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zQ |= iVar.Q(obj);
        }
        Object objY = iVar.y();
        if (zQ || objY == i.f3413a.a()) {
            iVar.p(new b0(function1));
        }
        if (k.J()) {
            k.R();
        }
    }

    public static final void c(Object obj, Object obj2, Function2<? super kotlinx.coroutines.k0, ? super Continuation<? super Unit>, ? extends Object> function2, i iVar, int i11) {
        if (k.J()) {
            k.S(590241125, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:360)");
        }
        CoroutineContext coroutineContextM = iVar.m();
        boolean zQ = iVar.Q(obj) | iVar.Q(obj2);
        Object objY = iVar.y();
        if (zQ || objY == i.f3413a.a()) {
            objY = new r0(coroutineContextM, function2);
            iVar.p(objY);
        }
        if (k.J()) {
            k.R();
        }
    }

    public static final void d(Object obj, Function2<? super kotlinx.coroutines.k0, ? super Continuation<? super Unit>, ? extends Object> function2, i iVar, int i11) {
        if (k.J()) {
            k.S(1179185413, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:337)");
        }
        CoroutineContext coroutineContextM = iVar.m();
        boolean zQ = iVar.Q(obj);
        Object objY = iVar.y();
        if (zQ || objY == i.f3413a.a()) {
            objY = new r0(coroutineContextM, function2);
            iVar.p(objY);
        }
        if (k.J()) {
            k.R();
        }
    }

    public static final void e(Function0<Unit> function0, i iVar, int i11) {
        if (k.J()) {
            k.S(-1288466761, i11, -1, "androidx.compose.runtime.SideEffect (Effects.kt:48)");
        }
        iVar.t(function0);
        if (k.J()) {
            k.R();
        }
    }

    @PublishedApi
    public static final kotlinx.coroutines.k0 g(CoroutineContext coroutineContext, i iVar) {
        kotlinx.coroutines.q1.b bVar = kotlinx.coroutines.q1.f69514j8;
        if (coroutineContext.get(bVar) == null) {
            CoroutineContext coroutineContextM = iVar.m();
            return kotlinx.coroutines.l0.a(coroutineContextM.plus(kotlinx.coroutines.t1.a((kotlinx.coroutines.q1) coroutineContextM.get(bVar))).plus(coroutineContext));
        }
        kotlinx.coroutines.z zVarB = kotlinx.coroutines.v1.b(null, 1, null);
        zVarB.i(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
        return kotlinx.coroutines.l0.a(zVarB);
    }
}
