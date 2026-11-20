package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.q1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@PublishedApi
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f69297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StackTraceElement f69298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f69299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentWeakMap<a<?>, Boolean> f69300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f69301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f69302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Function1<Boolean, Unit> f69303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentWeakMap<CoroutineStackFrame, c> f69304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ b f69305i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final Continuation<T> f69306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final c f69307b;

        public final g a() {
            this.f69307b.c();
            return null;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            a();
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f69306a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            a();
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            d.f69297a.e(this);
            this.f69306a.resumeWith(obj);
        }

        public String toString() {
            return this.f69306a.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f69308a = AtomicIntegerFieldUpdater.newUpdater(b.class, "installations$volatile");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicLongFieldUpdater f69309b = AtomicLongFieldUpdater.newUpdater(b.class, "sequenceNumber$volatile");
        private volatile /* synthetic */ int installations$volatile;
        private volatile /* synthetic */ long sequenceNumber$volatile;

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        d dVar = new d();
        f69297a = dVar;
        f69298b = new y0.a().b();
        f69299c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DefaultConstructorMarker defaultConstructorMarker = null;
        f69300d = new ConcurrentWeakMap<>(false, 1, defaultConstructorMarker);
        f69301e = true;
        f69302f = true;
        f69303g = dVar.c();
        f69304h = new ConcurrentWeakMap<>(true);
        f69305i = new b(defaultConstructorMarker);
    }

    public final Function1<Boolean, Unit> c() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            Object objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            Intrinsics.e(objNewInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            objM163constructorimpl = Result.m163constructorimpl((Function1) TypeIntrinsics.e(objNewInstance, 1));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m169isFailureimpl(objM163constructorimpl)) {
            objM163constructorimpl = null;
        }
        return (Function1) objM163constructorimpl;
    }

    public final boolean d(a<?> aVar) {
        q1 q1Var;
        CoroutineContext coroutineContextB = aVar.f69307b.b();
        if (coroutineContextB == null || (q1Var = (q1) coroutineContextB.get(q1.f69514j8)) == null || !q1Var.isCompleted()) {
            return false;
        }
        f69300d.remove(aVar);
        return true;
    }

    public final void e(a<?> aVar) {
        CoroutineStackFrame coroutineStackFrameF;
        f69300d.remove(aVar);
        CoroutineStackFrame coroutineStackFrameE = aVar.f69307b.e();
        if (coroutineStackFrameE == null || (coroutineStackFrameF = f(coroutineStackFrameE)) == null) {
            return;
        }
        f69304h.remove(coroutineStackFrameF);
    }

    public final CoroutineStackFrame f(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }
}
