package androidx.compose.ui.scrollcapture;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.v0;
import androidx.compose.ui.graphics.h0;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsNode;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.vungle.warren.error.VungleException;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import q2.r;

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
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(VungleException.WEB_CRASH)
@Metadata
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SemanticsNode f5567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f5568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f5569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f5570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RelativeScroller f5571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5572f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1", f = "ComposeScrollCaptureCallback.android.kt", l = {190}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Runnable $onReady;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Runnable runnable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onReady = runnable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ComposeScrollCaptureCallback.this.new AnonymousClass1(this.$onReady, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                RelativeScroller relativeScroller = ComposeScrollCaptureCallback.this.f5571e;
                this.label = 1;
                if (relativeScroller.g(0.0f, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            ComposeScrollCaptureCallback.this.f5569c.b();
            this.$onReady.run();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1", f = "ComposeScrollCaptureCallback.android.kt", l = {116}, m = "invokeSuspend")
    public static final class C09381 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $captureArea;
        final /* synthetic */ Consumer<Rect> $onComplete;
        final /* synthetic */ ScrollCaptureSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09381(ScrollCaptureSession scrollCaptureSession, Rect rect, Consumer<Rect> consumer, Continuation<? super C09381> continuation) {
            super(2, continuation);
            this.$session = scrollCaptureSession;
            this.$captureArea = rect;
            this.$onComplete = consumer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ComposeScrollCaptureCallback.this.new C09381(this.$session, this.$captureArea, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C09381) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                ComposeScrollCaptureCallback composeScrollCaptureCallback = ComposeScrollCaptureCallback.this;
                ScrollCaptureSession scrollCaptureSession = this.$session;
                r rVarD = w4.d(this.$captureArea);
                this.label = 1;
                obj = composeScrollCaptureCallback.e(scrollCaptureSession, rVarD, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.$onComplete.accept(w4.a((r) obj));
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback", f = "ComposeScrollCaptureCallback.android.kt", l = {TsExtractor.TS_STREAM_TYPE_AC3, 132}, m = "onScrollCaptureImageRequest")
    public static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ComposeScrollCaptureCallback.this.e(null, null, this);
        }
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, r rVar, k0 k0Var, a aVar) {
        this.f5567a = semanticsNode;
        this.f5568b = rVar;
        this.f5569c = aVar;
        this.f5570d = l0.g(k0Var, f.f5578a);
        this.f5571e = new RelativeScroller(rVar.e(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:37:0x0109  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(ScrollCaptureSession scrollCaptureSession, r rVar, Continuation<? super r> continuation) throws Throwable {
        AnonymousClass2 anonymousClass2;
        int iH;
        int iD;
        ComposeScrollCaptureCallback composeScrollCaptureCallback;
        r rVar2;
        int i11;
        ComposeScrollCaptureCallback composeScrollCaptureCallback2;
        ScrollCaptureSession scrollCaptureSession2;
        int i12;
        int iC;
        int iC2;
        r rVarC;
        NodeCoordinator nodeCoordinatorE;
        Canvas canvasLockHardwareCanvas;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i13 = anonymousClass2.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i13 - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object obj = anonymousClass2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i14 = anonymousClass2.label;
        if (i14 != 0) {
            if (i14 == 1) {
                int i15 = anonymousClass2.I$1;
                int i16 = anonymousClass2.I$0;
                r rVar3 = (r) anonymousClass2.L$2;
                ScrollCaptureSession scrollCaptureSessionA = androidx.compose.ui.scrollcapture.a.a(anonymousClass2.L$1);
                composeScrollCaptureCallback = (ComposeScrollCaptureCallback) anonymousClass2.L$0;
                ResultKt.b(obj);
                iH = i16;
                rVar = rVar3;
                iD = i15;
                scrollCaptureSession = scrollCaptureSessionA;
            } else {
                if (i14 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i12 = anonymousClass2.I$1;
                i11 = anonymousClass2.I$0;
                rVar2 = (r) anonymousClass2.L$2;
                ScrollCaptureSession scrollCaptureSessionA2 = androidx.compose.ui.scrollcapture.a.a(anonymousClass2.L$1);
                composeScrollCaptureCallback2 = (ComposeScrollCaptureCallback) anonymousClass2.L$0;
                ResultKt.b(obj);
                scrollCaptureSession2 = scrollCaptureSessionA2;
            }
            iC = composeScrollCaptureCallback2.f5571e.c(i11);
            iC2 = composeScrollCaptureCallback2.f5571e.c(i12);
            rVarC = r.c(rVar2, 0, iC, 0, iC2, 5, null);
            if (iC == iC2) {
                return r.f74247e.a();
            }
            nodeCoordinatorE = composeScrollCaptureCallback2.f5567a.e();
            if (nodeCoordinatorE != null) {
                throw new IllegalStateException("Could not find coordinator for semantics node.".toString());
            }
            canvasLockHardwareCanvas = scrollCaptureSession2.getSurface().lockHardwareCanvas();
            try {
                canvasLockHardwareCanvas.drawColor(0, BlendMode.CLEAR);
                o1 o1VarB = h0.b(canvasLockHardwareCanvas);
                o1VarB.c(-rVarC.f(), -rVarC.h());
                nodeCoordinatorE.G1(o1VarB, null);
                return rVarC.l(0, a20.b.d(composeScrollCaptureCallback2.f5571e.b()));
            } finally {
                scrollCaptureSession2.getSurface().unlockCanvasAndPost(canvasLockHardwareCanvas);
            }
        }
        ResultKt.b(obj);
        iH = rVar.h();
        iD = rVar.d();
        RelativeScroller relativeScroller = this.f5571e;
        anonymousClass2.L$0 = this;
        anonymousClass2.L$1 = scrollCaptureSession;
        anonymousClass2.L$2 = rVar;
        anonymousClass2.I$0 = iH;
        anonymousClass2.I$1 = iD;
        anonymousClass2.label = 1;
        if (relativeScroller.f(iH, iD, anonymousClass2) == objE) {
            return objE;
        }
        composeScrollCaptureCallback = this;
        AnonymousClass3 anonymousClass3 = new Function1<Long, Unit>() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.onScrollCaptureImageRequest.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l11) {
                invoke(l11.longValue());
                return Unit.f68710a;
            }

            public final void invoke(long j11) {
            }
        };
        anonymousClass2.L$0 = composeScrollCaptureCallback;
        anonymousClass2.L$1 = scrollCaptureSession;
        anonymousClass2.L$2 = rVar;
        anonymousClass2.I$0 = iH;
        anonymousClass2.I$1 = iD;
        anonymousClass2.label = 2;
        if (v0.b(anonymousClass3, anonymousClass2) == objE) {
            return objE;
        }
        rVar2 = rVar;
        i11 = iH;
        composeScrollCaptureCallback2 = composeScrollCaptureCallback;
        scrollCaptureSession2 = scrollCaptureSession;
        i12 = iD;
        iC = composeScrollCaptureCallback2.f5571e.c(i11);
        iC2 = composeScrollCaptureCallback2.f5571e.c(i12);
        rVarC = r.c(rVar2, 0, iC, 0, iC2, 5, null);
        if (iC == iC2) {
            return r.f74247e.a();
        }
        nodeCoordinatorE = composeScrollCaptureCallback2.f5567a.e();
        if (nodeCoordinatorE != null) {
            throw new IllegalStateException("Could not find coordinator for semantics node.".toString());
        }
        canvasLockHardwareCanvas = scrollCaptureSession2.getSurface().lockHardwareCanvas();
        canvasLockHardwareCanvas.drawColor(0, BlendMode.CLEAR);
        o1 o1VarB2 = h0.b(canvasLockHardwareCanvas);
        o1VarB2.c(-rVarC.f(), -rVarC.h());
        nodeCoordinatorE.G1(o1VarB2, null);
        return rVarC.l(0, a20.b.d(composeScrollCaptureCallback2.f5571e.b()));
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureEnd(Runnable runnable) {
        kotlinx.coroutines.j.d(this.f5570d, c2.f69212a, null, new AnonymousClass1(runnable, null), 2, null);
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer<Rect> consumer) {
        ComposeScrollCaptureCallback_androidKt.c(this.f5570d, cancellationSignal, new C09381(scrollCaptureSession, rect, consumer, null));
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer<Rect> consumer) {
        consumer.accept(w4.a(this.f5568b));
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.f5571e.d();
        this.f5572f = 0;
        this.f5569c.a();
        runnable.run();
    }
}
