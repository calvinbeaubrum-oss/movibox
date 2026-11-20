package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.s2;

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
public class j<E> extends BufferedChannel<E> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f69259n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BufferOverflow f69260o;

    public j(int i11, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(i11, function1);
        this.f69259n = i11;
        this.f69260o = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.b(BufferedChannel.class).e() + " instead").toString());
        }
        if (i11 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i11 + " was specified").toString());
    }

    public static /* synthetic */ <E> Object U0(j<E> jVar, E e11, Continuation<? super Unit> continuation) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionD;
        Object objX0 = jVar.X0(e11, true);
        if (!(objX0 instanceof e.a)) {
            return Unit.f68710a;
        }
        e.e(objX0);
        Function1<E, Unit> function1 = jVar.f69223b;
        if (function1 == null || (undeliveredElementExceptionD = OnUndeliveredElementKt.d(function1, e11, null, 2, null)) == null) {
            throw jVar.T();
        }
        v10.b.a(undeliveredElementExceptionD, jVar.T());
        throw undeliveredElementExceptionD;
    }

    public final Object V0(E e11, boolean z11) {
        Function1<E, Unit> function1;
        UndeliveredElementException undeliveredElementExceptionD;
        Object objF = super.f(e11);
        if (e.i(objF) || e.h(objF)) {
            return objF;
        }
        if (!z11 || (function1 = this.f69223b) == null || (undeliveredElementExceptionD = OnUndeliveredElementKt.d(function1, e11, null, 2, null)) == null) {
            return e.f69253b.c(Unit.f68710a);
        }
        throw undeliveredElementExceptionD;
    }

    public final Object W0(E e11) {
        g gVar;
        Object obj = BufferedChannelKt.f69233d;
        g gVar2 = (g) BufferedChannel.U().get(this);
        while (true) {
            long andIncrement = BufferedChannel.V().getAndIncrement(this);
            long j11 = andIncrement & 1152921504606846975L;
            boolean zH0 = h0(andIncrement);
            int i11 = BufferedChannelKt.f69231b;
            long j12 = j11 / ((long) i11);
            int i12 = (int) (j11 % ((long) i11));
            if (gVar2.f69497c != j12) {
                g gVarI = I(j12, gVar2);
                if (gVarI != null) {
                    gVar = gVarI;
                } else if (zH0) {
                    return e.f69253b.a(T());
                }
            } else {
                gVar = gVar2;
            }
            int iP0 = P0(gVar, i12, e11, j11, obj, zH0);
            if (iP0 == 0) {
                gVar.b();
                return e.f69253b.c(Unit.f68710a);
            }
            if (iP0 == 1) {
                return e.f69253b.c(Unit.f68710a);
            }
            if (iP0 == 2) {
                if (zH0) {
                    gVar.s();
                    return e.f69253b.a(T());
                }
                s2 s2Var = obj instanceof s2 ? (s2) obj : null;
                if (s2Var != null) {
                    x0(s2Var, gVar, i12);
                }
                E((gVar.f69497c * ((long) i11)) + ((long) i12));
                return e.f69253b.c(Unit.f68710a);
            }
            if (iP0 == 3) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (iP0 == 4) {
                if (j11 < S()) {
                    gVar.b();
                }
                return e.f69253b.a(T());
            }
            if (iP0 == 5) {
                gVar.b();
            }
            gVar2 = gVar;
        }
    }

    public final Object X0(E e11, boolean z11) {
        return this.f69260o == BufferOverflow.DROP_LATEST ? V0(e11, z11) : W0(e11);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.p
    public Object f(E e11) {
        return X0(e11, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean i0() {
        return this.f69260o == BufferOverflow.DROP_OLDEST;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.p
    public Object q(E e11, Continuation<? super Unit> continuation) {
        return U0(this, e11, continuation);
    }
}
