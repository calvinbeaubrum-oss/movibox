package com.transsnet.flow.event;

import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.t0;
import androidx.lifecycle.u;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.u0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
@SourceDebugExtension
public final class FlowEventBus extends t0 {
    private final HashMap<String, u0<Object>> eventFlows = new HashMap<>();
    private final HashMap<String, u0<Object>> stickyEventFlows = new HashMap<>();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @SourceDebugExtension
    public static final class a implements kotlinx.coroutines.flow.b<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f61405b;

        public a(Function1 function1) {
            this.f61405b = function1;
        }

        @Override // kotlinx.coroutines.flow.b
        public Object emit(Object obj, Continuation<? super Unit> continuation) {
            FlowEventBus.this.invokeReceived(obj, this.f61405b);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.flow.event.FlowEventBus$observeEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.flow.event.FlowEventBus$observeEvent$1", f = "FlowEventBus.kt", l = {TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineDispatcher $dispatcher;
        final /* synthetic */ String $eventName;
        final /* synthetic */ boolean $isSticky;
        final /* synthetic */ Function1<T, Unit> $onReceived;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.transsnet.flow.event.FlowEventBus$observeEvent$1$a */
        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes8.dex */
        @Metadata
        @SourceDebugExtension
        public static final class a implements kotlinx.coroutines.flow.b<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k0 f61406a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CoroutineDispatcher f61407b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ FlowEventBus f61408c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function1 f61409d;

            public a(k0 k0Var, CoroutineDispatcher coroutineDispatcher, FlowEventBus flowEventBus, Function1 function1) {
                this.f61406a = k0Var;
                this.f61407b = coroutineDispatcher;
                this.f61408c = flowEventBus;
                this.f61409d = function1;
            }

            @Override // kotlinx.coroutines.flow.b
            public Object emit(Object obj, Continuation<? super Unit> continuation) {
                j.d(this.f61406a, this.f61407b, null, new FlowEventBus$observeEvent$1$1$1(this.f61408c, obj, this.f61409d, null), 2, null);
                return Unit.f68710a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String str, boolean z11, CoroutineDispatcher coroutineDispatcher, Function1<? super T, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$eventName = str;
            this.$isSticky = z11;
            this.$dispatcher = coroutineDispatcher;
            this.$onReceived = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = FlowEventBus.this.new AnonymousClass1(this.$eventName, this.$isSticky, this.$dispatcher, this.$onReceived, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
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
                k0 k0Var = (k0) this.L$0;
                u0 eventFlow = FlowEventBus.this.getEventFlow(this.$eventName, this.$isSticky);
                a aVar = new a(k0Var, this.$dispatcher, FlowEventBus.this, this.$onReceived);
                this.label = 1;
                if (eventFlow.a(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final u0<Object> getEventFlow(String str, boolean z11) {
        u0<Object> u0VarB = z11 ? this.stickyEventFlows.get(str) : this.eventFlows.get(str);
        if (u0VarB == null) {
            u0VarB = a1.b(z11 ? 1 : 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, null, 4, null);
            if (z11) {
                this.stickyEventFlows.put(str, u0VarB);
            } else {
                this.eventFlows.put(str, u0VarB);
            }
        }
        return u0VarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void invokeReceived(Object obj, Function1<? super T, Unit> function1) {
        b bVarB;
        b bVarB2;
        try {
            Intrinsics.e(obj, "null cannot be cast to non-null type T of com.transsnet.flow.event.FlowEventBus.invokeReceived");
            function1.invoke(obj);
        } catch (ClassCastException e11) {
            String message = e11.getMessage();
            if (message == null || (bVarB2 = com.transsnet.flow.event.a.f61410a.b()) == null) {
                return;
            }
            bVarB2.log("class cast error on message received: " + obj, message);
        } catch (Exception e12) {
            String message2 = e12.getMessage();
            if (message2 == null || (bVarB = com.transsnet.flow.event.a.f61410a.b()) == null) {
                return;
            }
            bVarB.log("error on message received: " + obj, message2);
        }
    }

    public final void clearStickEvent(String eventName) {
        Intrinsics.g(eventName, "eventName");
        u0<Object> u0Var = this.stickyEventFlows.get(eventName);
        if (u0Var != null) {
            u0Var.f();
        }
    }

    public final int getEventObserverCount(String eventName) {
        f1<Integer> f1VarC;
        f1<Integer> f1VarC2;
        Intrinsics.g(eventName, "eventName");
        u0<Object> u0Var = this.stickyEventFlows.get(eventName);
        int iIntValue = 0;
        int iIntValue2 = (u0Var == null || (f1VarC2 = u0Var.c()) == null) ? 0 : f1VarC2.getValue().intValue();
        u0<Object> u0Var2 = this.eventFlows.get(eventName);
        if (u0Var2 != null && (f1VarC = u0Var2.c()) != null) {
            iIntValue = f1VarC.getValue().intValue();
        }
        return iIntValue2 + iIntValue;
    }

    public final <T> q1 observeEvent(u lifecycleOwner, String eventName, Lifecycle.State minState, CoroutineDispatcher dispatcher, boolean z11, Function1<? super T, Unit> onReceived) {
        Intrinsics.g(lifecycleOwner, "lifecycleOwner");
        Intrinsics.g(eventName, "eventName");
        Intrinsics.g(minState, "minState");
        Intrinsics.g(dispatcher, "dispatcher");
        Intrinsics.g(onReceived, "onReceived");
        return EventUtilsKt.launchWhenStateAtLeast(lifecycleOwner, minState, new AnonymousClass1(eventName, z11, dispatcher, onReceived, null));
    }

    public final <T> Object observeWithoutLifecycle(String str, boolean z11, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        Object objA = getEventFlow(str, z11).a(new a(function1), continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }

    public final void postEvent(String eventName, Object value, long j11) {
        Intrinsics.g(eventName, "eventName");
        Intrinsics.g(value, "value");
        b bVarB = com.transsnet.flow.event.a.f61410a.b();
        if (bVarB != null) {
            bVarB.log("post Event:" + eventName);
        }
        Iterator it = g.p(getEventFlow(eventName, false), getEventFlow(eventName, true)).iterator();
        while (it.hasNext()) {
            j.d(androidx.lifecycle.u0.a(this), null, null, new FlowEventBus$postEvent$1$1(j11, (u0) it.next(), value, null), 3, null);
        }
    }

    public final void removeStickEvent(String eventName) {
        Intrinsics.g(eventName, "eventName");
        this.stickyEventFlows.remove(eventName);
    }
}
