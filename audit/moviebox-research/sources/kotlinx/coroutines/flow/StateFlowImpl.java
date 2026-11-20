package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;

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
@SourceDebugExtension
public final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<h1> implements v0<T>, a, kotlinx.coroutines.flow.internal.j<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69372g = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f69373f;

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b5 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b5, B:40:0x00ba, B:50:0x00db, B:52:0x00e1, B:42:0x00c0, B:46:0x00c7, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b5, B:40:0x00ba, B:50:0x00db, B:52:0x00e1, B:42:0x00c0, B:46:0x00c7, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c0 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b5, B:40:0x00ba, B:50:0x00db, B:52:0x00e1, B:42:0x00c0, B:46:0x00c7, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e1 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b5, B:40:0x00ba, B:50:0x00db, B:52:0x00e1, B:42:0x00c0, B:46:0x00c7, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, kotlinx.coroutines.flow.h1] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, kotlinx.coroutines.flow.b] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00df -> B:36:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f1 -> B:36:0x00ab). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x00ba
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.a
    public java.lang.Object a(kotlinx.coroutines.flow.b<? super T> r11, kotlin.coroutines.Continuation<?> r12) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.a(kotlinx.coroutines.flow.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.u0
    public boolean b(T t11) {
        setValue(t11);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.j
    public a<T> d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return g1.d(this, coroutineContext, i11, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.v0
    public boolean e(T t11, T t12) {
        if (t11 == null) {
            t11 = (T) kotlinx.coroutines.flow.internal.m.f69416a;
        }
        if (t12 == null) {
            t12 = (T) kotlinx.coroutines.flow.internal.m.f69416a;
        }
        return r(t11, t12);
    }

    @Override // kotlinx.coroutines.flow.u0, kotlinx.coroutines.flow.b
    public Object emit(T t11, Continuation<? super Unit> continuation) {
        setValue(t11);
        return Unit.f68710a;
    }

    @Override // kotlinx.coroutines.flow.u0
    public void f() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.v0, kotlinx.coroutines.flow.f1
    public T getValue() {
        kotlinx.coroutines.internal.c0 c0Var = kotlinx.coroutines.flow.internal.m.f69416a;
        T t11 = (T) f69372g.get(this);
        if (t11 == c0Var) {
            return null;
        }
        return t11;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public h1 j() {
        return new h1();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public h1[] k(int i11) {
        return new h1[i11];
    }

    public final boolean r(Object obj, Object obj2) {
        int i11;
        h1[] h1VarArrN;
        synchronized (this) {
            Object obj3 = f69372g.get(this);
            if (obj != null && !Intrinsics.b(obj3, obj)) {
                return false;
            }
            if (Intrinsics.b(obj3, obj2)) {
                return true;
            }
            f69372g.set(this, obj2);
            int i12 = this.f69373f;
            if ((i12 & 1) != 0) {
                this.f69373f = i12 + 2;
                return true;
            }
            int i13 = i12 + 1;
            this.f69373f = i13;
            h1[] h1VarArrN2 = n();
            Unit unit = Unit.f68710a;
            while (true) {
                h1[] h1VarArr = h1VarArrN2;
                if (h1VarArr != null) {
                    for (h1 h1Var : h1VarArr) {
                        if (h1Var != null) {
                            h1Var.h();
                        }
                    }
                }
                synchronized (this) {
                    i11 = this.f69373f;
                    if (i11 == i13) {
                        this.f69373f = i13 + 1;
                        return true;
                    }
                    h1VarArrN = n();
                    Unit unit2 = Unit.f68710a;
                }
                h1VarArrN2 = h1VarArrN;
                i13 = i11;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.v0
    public void setValue(T t11) {
        if (t11 == null) {
            t11 = (T) kotlinx.coroutines.flow.internal.m.f69416a;
        }
        r(null, t11);
    }
}
