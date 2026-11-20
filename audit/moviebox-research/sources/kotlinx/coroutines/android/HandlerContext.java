package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.n;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.y0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class HandlerContext extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f69199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f69200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f69201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HandlerContext f69202d;

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i11 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str, boolean z11) {
        super(null);
        this.f69199a = handler;
        this.f69200b = str;
        this.f69201c = z11;
        this.f69202d = z11 ? this : new HandlerContext(handler, str, true);
    }

    public static final void y(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f69199a.removeCallbacks(runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f69199a.post(runnable)) {
            return;
        }
        w(coroutineContext, runnable);
    }

    public boolean equals(Object obj) {
        if (obj instanceof HandlerContext) {
            HandlerContext handlerContext = (HandlerContext) obj;
            if (handlerContext.f69199a == this.f69199a && handlerContext.f69201c == this.f69201c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f69199a) ^ (this.f69201c ? 1231 : 1237);
    }

    @Override // kotlinx.coroutines.android.d, kotlinx.coroutines.q0
    public y0 invokeOnTimeout(long j11, final Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f69199a.postDelayed(runnable, kotlin.ranges.a.h(j11, 4611686018427387903L))) {
            return new y0() { // from class: kotlinx.coroutines.android.c
                @Override // kotlinx.coroutines.y0
                public final void dispose() {
                    HandlerContext.y(this.f69203a, runnable);
                }
            };
        }
        w(coroutineContext, runnable);
        return d2.f69264a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.f69201c && Intrinsics.b(Looper.myLooper(), this.f69199a.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.q0
    public void scheduleResumeAfterDelay(long j11, final n<? super Unit> nVar) {
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                nVar.resumeUndispatched(this, Unit.f68710a);
            }
        };
        if (this.f69199a.postDelayed(runnable, kotlin.ranges.a.h(j11, 4611686018427387903L))) {
            nVar.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.android.HandlerContext.scheduleResumeAfterDelay.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                    invoke2(th2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th2) {
                    HandlerContext.this.f69199a.removeCallbacks(runnable);
                }
            });
        } else {
            w(nVar.getContext(), runnable);
        }
    }

    @Override // kotlinx.coroutines.a2, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strP = p();
        if (strP != null) {
            return strP;
        }
        String string = this.f69200b;
        if (string == null) {
            string = this.f69199a.toString();
        }
        if (!this.f69201c) {
            return string;
        }
        return string + ".immediate";
    }

    public final void w(CoroutineContext coroutineContext, Runnable runnable) {
        t1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        w0.b().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.android.d
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public HandlerContext q() {
        return this.f69202d;
    }
}
