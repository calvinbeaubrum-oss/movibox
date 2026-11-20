package com.transsion.fission;

import android.app.Activity;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.bean.HomePopupEntity;
import com.transsion.commercializationapi.ICommonDialogApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.fission.FissionProvider$showPalmPayDialog$1", f = "FissionProvider.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
public final class FissionProvider$showPalmPayDialog$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $callback;
    Object L$0;
    int label;
    final /* synthetic */ FissionProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FissionProvider$showPalmPayDialog$1(FissionProvider fissionProvider, Function2<? super Boolean, ? super Boolean, Unit> function2, Continuation<? super FissionProvider$showPalmPayDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = fissionProvider;
        this.$callback = function2;
    }

    public static final void d(HomePopupEntity homePopupEntity, final Function2 function2) {
        ((ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class)).B0(homePopupEntity, new Function1<Boolean, Unit>() { // from class: com.transsion.fission.FissionProvider$showPalmPayDialog$1$1$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                function2.invoke(Boolean.FALSE, Boolean.valueOf(z11));
            }
        });
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FissionProvider$showPalmPayDialog$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((FissionProvider$showPalmPayDialog$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0042 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:6:0x0011, B:19:0x003b, B:22:0x0042, B:24:0x0048, B:26:0x0050, B:28:0x0056, B:30:0x0062, B:33:0x007c, B:32:0x006f, B:13:0x0027, B:15:0x002f), top: B:42:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:6:0x0011, B:19:0x003b, B:22:0x0042, B:24:0x0048, B:26:0x0050, B:28:0x0056, B:30:0x0062, B:33:0x007c, B:32:0x006f, B:13:0x0027, B:15:0x002f), top: B:42:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0094  */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0094, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Function2<Boolean, Boolean, Unit> function2;
        Throwable thM166exceptionOrNullimpl;
        final Function2<Boolean, Boolean, Unit> function3;
        BaseDto baseDto;
        Function2<Boolean, Boolean, Unit> function4;
        String code;
        Unit unit;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                FissionProvider fissionProvider = this.this$0;
                function3 = this.$callback;
                Result.Companion companion = Result.Companion;
                dt.b bVarA1 = fissionProvider.A1();
                if (bVarA1 != null) {
                    this.L$0 = function3;
                    this.label = 1;
                    obj = dt.b.a.a(bVarA1, null, this, 1, null);
                    if (obj == objE) {
                        return objE;
                    }
                    function4 = function3;
                } else {
                    baseDto = null;
                }
                if (baseDto != null) {
                    code = baseDto.getCode();
                } else {
                    code = null;
                }
                if (Intrinsics.b(code, "0") || baseDto.getData() == null) {
                    function3.invoke(Boxing.a(true), Boxing.a(false));
                    unit = Unit.f68710a;
                } else {
                    final HomePopupEntity homePopupEntity = (HomePopupEntity) baseDto.getData();
                    Activity activityB = com.blankj.utilcode.util.a.b();
                    if (activityB != null) {
                        activityB.runOnUiThread(new Runnable() { // from class: com.transsion.fission.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                FissionProvider$showPalmPayDialog$1.d(homePopupEntity, function3);
                            }
                        });
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                }
                objM163constructorimpl = Result.m163constructorimpl(unit);
                function2 = this.$callback;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    uo.b.a.k(uo.b.f78622a, "fetchPalmPayDialog() ---> getOrElse() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
                    function2.invoke(Boxing.a(true), Boxing.a(false));
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function4 = (Function2) this.L$0;
            ResultKt.b(obj);
            baseDto = (BaseDto) obj;
            function3 = function4;
            if (baseDto != null) {
                code = baseDto.getCode();
            } else {
                code = null;
            }
            if (Intrinsics.b(code, "0")) {
                function3.invoke(Boxing.a(true), Boxing.a(false));
                unit = Unit.f68710a;
            } else {
                function3.invoke(Boxing.a(true), Boxing.a(false));
                unit = Unit.f68710a;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        function2 = this.$callback;
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.a.k(uo.b.f78622a, "fetchPalmPayDialog() ---> getOrElse() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            function2.invoke(Boxing.a(true), Boxing.a(false));
        }
        return Unit.f68710a;
    }
}
