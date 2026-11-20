package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;

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
public final class BufferedChannelKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<Object> f69230a = new g<>(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final int f69231b = f0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f69232c = f0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final c0 f69233d = new c0("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f69234e = new c0("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0 f69235f = new c0("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c0 f69236g = new c0("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c0 f69237h = new c0("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c0 f69238i = new c0("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c0 f69239j = new c0("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c0 f69240k = new c0("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c0 f69241l = new c0("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c0 f69242m = new c0("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c0 f69243n = new c0("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c0 f69244o = new c0("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c0 f69245p = new c0("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c0 f69246q = new c0("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c0 f69247r = new c0("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c0 f69248s = new c0("NO_CLOSE_CAUSE");

    public static final long A(int i11) {
        if (i11 == 0) {
            return 0L;
        }
        if (i11 != Integer.MAX_VALUE) {
            return i11;
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(kotlinx.coroutines.n<? super T> nVar, T t11, Function1<? super Throwable, Unit> function1) {
        Object objTryResume = nVar.tryResume(t11, null, function1);
        if (objTryResume == null) {
            return false;
        }
        nVar.completeResume(objTryResume);
        return true;
    }

    public static /* synthetic */ boolean C(kotlinx.coroutines.n nVar, Object obj, Function1 function1, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return B(nVar, obj, function1);
    }

    public static final long v(long j11, boolean z11) {
        return (z11 ? 4611686018427387904L : 0L) + j11;
    }

    public static final long w(long j11, int i11) {
        return (((long) i11) << 60) + j11;
    }

    public static final <E> g<E> x(long j11, g<E> gVar) {
        return new g<>(j11, gVar, gVar.x(), 0);
    }

    public static final <E> KFunction<g<E>> y() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final c0 z() {
        return f69241l;
    }
}
