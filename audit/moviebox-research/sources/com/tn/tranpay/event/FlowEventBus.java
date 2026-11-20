package com.tn.tranpay.event;

import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.t0;
import androidx.lifecycle.u;
import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
@SourceDebugExtension
public final class FlowEventBus extends t0 {
    private final HashMap<String, u0<Object>> eventFlows = new HashMap<>();
    private final HashMap<String, u0<Object>> stickyEventFlows = new HashMap<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<T, Unit> f50089b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super T, Unit> function1) {
            this.f50089b = function1;
        }

        @Override // kotlinx.coroutines.flow.b
        public final Object emit(Object obj, Continuation<? super Unit> continuation) {
            FlowEventBus.this.invokeReceived(obj, this.f50089b);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.tn.tranpay.event.FlowEventBus$observeEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus$observeEvent$1", f = "FlowEventBus.kt", l = {51}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<?>, Object> {
        final /* synthetic */ CoroutineDispatcher $dispatcher;
        final /* synthetic */ String $eventName;
        final /* synthetic */ boolean $isSticky;
        final /* synthetic */ Function1<T, Unit> $onReceived;
        private /* synthetic */ Object L$0;
        int label;

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
        public final Object invoke(k0 k0Var, Continuation<?> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                final k0 k0Var = (k0) this.L$0;
                u0 eventFlow = FlowEventBus.this.getEventFlow(this.$eventName, this.$isSticky);
                final CoroutineDispatcher coroutineDispatcher = this.$dispatcher;
                final FlowEventBus flowEventBus = FlowEventBus.this;
                final Function1<T, Unit> function1 = this.$onReceived;
                kotlinx.coroutines.flow.b bVar = new kotlinx.coroutines.flow.b() { // from class: com.tn.tranpay.event.FlowEventBus.observeEvent.1.1

                    /* JADX INFO: renamed from: com.tn.tranpay.event.FlowEventBus$observeEvent$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus$observeEvent$1$1$1", f = "FlowEventBus.kt", l = {}, m = "invokeSuspend")
                    public static final class C05441 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Function1<T, Unit> $onReceived;
                        final /* synthetic */ Object $value;
                        int label;
                        final /* synthetic */ FlowEventBus this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public C05441(FlowEventBus flowEventBus, Object obj, Function1<? super T, Unit> function1, Continuation<? super C05441> continuation) {
                            super(2, continuation);
                            this.this$0 = flowEventBus;
                            this.$value = obj;
                            this.$onReceived = function1;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C05441(this.this$0, this.$value, this.$onReceived, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                            return ((C05441) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            kotlin.coroutines.intrinsics.a.e();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            this.this$0.invokeReceived(this.$value, this.$onReceived);
                            return Unit.f68710a;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.b
                    public final Object emit(Object obj2, Continuation<? super Unit> continuation) {
                        j.d(k0Var, coroutineDispatcher, null, new C05441(flowEventBus, obj2, function1, null), 2, null);
                        return Unit.f68710a;
                    }
                };
                this.label = 1;
                if (eventFlow.a(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.tn.tranpay.event.FlowEventBus$observeWithoutLifecycle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus", f = "FlowEventBus.kt", l = {64}, m = "observeWithoutLifecycle")
    public static final class C19831<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C19831(Continuation<? super C19831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowEventBus.this.observeWithoutLifecycle(null, false, null, this);
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
        try {
            Intrinsics.e(obj, "null cannot be cast to non-null type T of com.tn.tranpay.event.FlowEventBus.invokeReceived");
            function1.invoke(obj);
        } catch (ClassCastException e11) {
            String message = e11.getMessage();
            if (message != null) {
                fq.a.c(fq.a.f65215a, "class cast error on message received: " + message, null, 2, null);
            }
        } catch (Exception e12) {
            String message2 = e12.getMessage();
            if (message2 != null) {
                fq.a.c(fq.a.f65215a, "error on message received: " + message2, null, 2, null);
            }
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final <T> Object observeWithoutLifecycle(String str, boolean z11, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        C19831 c19831;
        if (continuation instanceof C19831) {
            c19831 = (C19831) continuation;
            int i11 = c19831.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c19831.label = i11 - Integer.MIN_VALUE;
            } else {
                c19831 = new C19831(continuation);
            }
        } else {
            c19831 = new C19831(continuation);
        }
        Object obj = c19831.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = c19831.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            u0<Object> eventFlow = getEventFlow(str, z11);
            a aVar = new a(function1);
            c19831.label = 1;
            if (eventFlow.a(aVar, c19831) == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    public final void postEvent(String eventName, Object value, long j11) {
        Intrinsics.g(eventName, "eventName");
        Intrinsics.g(value, "value");
        fq.a.c(fq.a.f65215a, "post Event:" + eventName, null, 2, null);
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
