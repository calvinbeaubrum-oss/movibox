package com.transsion.home.viewmodel;

import com.transsion.home.bean.SubOperateData;
import com.transsion.moviedetailapi.bean.OperateItem;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.b;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.o0;

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
@Metadata
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1", f = "SubTabViewModel.kt", l = {60}, m = "invokeSuspend")
public final class SubTabViewModel$fetchOperateData$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ Ref.ObjectRef<SubOperateData> $operateData;
    final /* synthetic */ int $tabId;
    int label;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1", f = "SubTabViewModel.kt", l = {64}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isRefresh;
        final /* synthetic */ Ref.ObjectRef<SubOperateData> $operateData;
        final /* synthetic */ int $tabId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SubTabViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref.ObjectRef<SubOperateData> objectRef, SubTabViewModel subTabViewModel, int i11, boolean z11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$operateData = objectRef;
            this.this$0 = subTabViewModel;
            this.$tabId = i11;
            this.$isRefresh = z11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$operateData, this.this$0, this.$tabId, this.$isRefresh, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref.ObjectRef<SubOperateData> objectRef;
            T t11;
            List<OperateItem> items;
            List listE0;
            Object objE = a.e();
            int i11 = this.label;
            List<OperateItem> listM0 = null;
            if (i11 == 0) {
                ResultKt.b(obj);
                o0 o0VarB = j.b((k0) this.L$0, null, null, new SubTabViewModel$fetchOperateData$1$1$operationTask$1(this.this$0, this.$tabId, null), 3, null);
                Ref.ObjectRef<SubOperateData> objectRef2 = this.$operateData;
                this.L$0 = objectRef2;
                this.label = 1;
                Object objC = o0VarB.c(this);
                if (objC == objE) {
                    return objE;
                }
                objectRef = objectRef2;
                t11 = objC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
                t11 = obj;
            }
            objectRef.element = t11;
            SubOperateData subOperateData = this.$operateData.element;
            SubOperateData subOperateData2 = subOperateData;
            if (subOperateData2 != null) {
                SubOperateData subOperateData3 = subOperateData;
                if (subOperateData3 != null && (items = subOperateData3.getItems()) != null && (listE0 = CollectionsKt___CollectionsKt.E0(items, new Comparator() { // from class: com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t12, T t13) {
                        return b.d(((OperateItem) t12).getPosition(), ((OperateItem) t13).getPosition());
                    }
                })) != null) {
                    listM0 = CollectionsKt___CollectionsKt.M0(listE0);
                }
                subOperateData2.setItems(listM0);
            }
            this.this$0.n(this.$tabId, this.$operateData.element);
            if (this.$isRefresh) {
                this.this$0.j().n(this.$operateData.element);
                this.this$0.f52759g = 1;
            } else {
                this.this$0.i().n(this.$operateData.element);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel$fetchOperateData$1(boolean z11, SubTabViewModel subTabViewModel, Ref.ObjectRef<SubOperateData> objectRef, int i11, Continuation<? super SubTabViewModel$fetchOperateData$1> continuation) {
        super(2, continuation);
        this.$isRefresh = z11;
        this.this$0 = subTabViewModel;
        this.$operateData = objectRef;
        this.$tabId = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubTabViewModel$fetchOperateData$1(this.$isRefresh, this.this$0, this.$operateData, this.$tabId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubTabViewModel$fetchOperateData$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<OperateItem> items;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$operateData, this.this$0, this.$tabId, this.$isRefresh, null);
                this.label = 1;
                if (l2.c(anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            uo.b.f78622a.h("SubTabFragment", "exceptionHandler " + e11.getMessage(), true);
            if (this.$isRefresh) {
                this.this$0.j().n(null);
            } else {
                SubOperateData subOperateData = this.$operateData.element;
                if (subOperateData == null || (items = subOperateData.getItems()) == null || items.size() <= 0) {
                    this.this$0.i().n(null);
                } else {
                    this.this$0.i().n(this.$operateData.element);
                }
            }
        }
        return Unit.f68710a;
    }
}
