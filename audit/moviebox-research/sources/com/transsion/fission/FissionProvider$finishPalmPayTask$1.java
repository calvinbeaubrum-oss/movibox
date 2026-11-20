package com.transsion.fission;

import android.app.Activity;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupInfo;
import com.transsion.commercializationapi.ICommonDialogApi;
import com.transsion.fission.activity.bean.PalmPayTaskInfo;
import com.transsion.fission.activity.bean.PalmPayTaskResult;
import defpackage.PalmPayMmkv;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

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
@DebugMetadata(c = "com.transsion.fission.FissionProvider$finishPalmPayTask$1", f = "FissionProvider.kt", l = {125}, m = "invokeSuspend")
public final class FissionProvider$finishPalmPayTask$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $subjectType;
    int label;
    final /* synthetic */ FissionProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FissionProvider$finishPalmPayTask$1(int i11, FissionProvider fissionProvider, Continuation<? super FissionProvider$finishPalmPayTask$1> continuation) {
        super(2, continuation);
        this.$subjectType = i11;
        this.this$0 = fissionProvider;
    }

    public static final void d(HomePopupEntity homePopupEntity) {
        ((ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class)).B0(homePopupEntity, new Function1<Boolean, Unit>() { // from class: com.transsion.fission.FissionProvider$finishPalmPayTask$1$1$1$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
            }
        });
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FissionProvider$finishPalmPayTask$1(this.$subjectType, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((FissionProvider$finishPalmPayTask$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:17:0x005f, B:20:0x0065, B:22:0x006b, B:24:0x0073, B:26:0x0079, B:28:0x0081, B:33:0x008b, B:35:0x0095, B:37:0x00a8, B:39:0x00b0, B:42:0x00b9, B:44:0x00db, B:36:0x009f, B:45:0x00e3, B:12:0x0027, B:14:0x0050), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:21:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:17:0x005f, B:20:0x0065, B:22:0x006b, B:24:0x0073, B:26:0x0079, B:28:0x0081, B:33:0x008b, B:35:0x0095, B:37:0x00a8, B:39:0x00b0, B:42:0x00b9, B:44:0x00db, B:36:0x009f, B:45:0x00e3, B:12:0x0027, B:14:0x0050), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    /* JADX WARN: Code duplicated, block: B:36:0x009f A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:17:0x005f, B:20:0x0065, B:22:0x006b, B:24:0x0073, B:26:0x0079, B:28:0x0081, B:33:0x008b, B:35:0x0095, B:37:0x00a8, B:39:0x00b0, B:42:0x00b9, B:44:0x00db, B:36:0x009f, B:45:0x00e3, B:12:0x0027, B:14:0x0050), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b0 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:17:0x005f, B:20:0x0065, B:22:0x006b, B:24:0x0073, B:26:0x0079, B:28:0x0081, B:33:0x008b, B:35:0x0095, B:37:0x00a8, B:39:0x00b0, B:42:0x00b9, B:44:0x00db, B:36:0x009f, B:45:0x00e3, B:12:0x0027, B:14:0x0050), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b9 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:17:0x005f, B:20:0x0065, B:22:0x006b, B:24:0x0073, B:26:0x0079, B:28:0x0081, B:33:0x008b, B:35:0x0095, B:37:0x00a8, B:39:0x00b0, B:42:0x00b9, B:44:0x00db, B:36:0x009f, B:45:0x00e3, B:12:0x0027, B:14:0x0050), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00db A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:17:0x005f, B:20:0x0065, B:22:0x006b, B:24:0x0073, B:26:0x0079, B:28:0x0081, B:33:0x008b, B:35:0x0095, B:37:0x00a8, B:39:0x00b0, B:42:0x00b9, B:44:0x00db, B:36:0x009f, B:45:0x00e3, B:12:0x0027, B:14:0x0050), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00fb  */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x00fb, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        BaseDto baseDto;
        Object objA;
        String code;
        PalmPayTaskResult palmPayTaskResult;
        PalmPayTaskInfo taskInfo;
        PalmPayTaskResult palmPayTaskResult2;
        HomePopupInfo popup;
        final HomePopupEntity homePopupEntity;
        Activity activityB;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                int i12 = this.$subjectType;
                FissionProvider fissionProvider = this.this$0;
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subjectType", i12);
                RequestBody.Companion companion2 = RequestBody.Companion;
                String string = jSONObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyCreate = companion2.create(string, MediaType.Companion.parse("application/json"));
                dt.b bVarA1 = fissionProvider.A1();
                if (bVarA1 != null) {
                    String strA = cp.a.f62775a.a();
                    this.label = 1;
                    objA = bVarA1.a(strA, requestBodyCreate, this);
                    if (objA == objE) {
                        return objE;
                    }
                } else {
                    baseDto = null;
                }
                if (baseDto != null) {
                    code = baseDto.getCode();
                } else {
                    code = null;
                }
                if (Intrinsics.b(code, "0") && baseDto.getData() != null) {
                    palmPayTaskResult = (PalmPayTaskResult) baseDto.getData();
                    if (palmPayTaskResult != null) {
                        taskInfo = palmPayTaskResult.getTaskInfo();
                    } else {
                        taskInfo = null;
                    }
                    if (taskInfo != null || taskInfo.getProgress() < taskInfo.getTotalProgress()) {
                        PalmPayMmkv.f350a.a().putBoolean("kv_task_is_finished", false);
                    } else {
                        PalmPayMmkv.f350a.a().putBoolean("kv_task_is_finished", true);
                    }
                    palmPayTaskResult2 = (PalmPayTaskResult) baseDto.getData();
                    if (palmPayTaskResult2 != null) {
                        popup = palmPayTaskResult2.getPopup();
                    } else {
                        popup = null;
                    }
                    if (popup != null) {
                        homePopupEntity = new HomePopupEntity(popup, new HomePopupInfo(0L, "", 0, "", 0, "", ""), 0, 0L);
                        activityB = com.blankj.utilcode.util.a.b();
                        if (activityB != null) {
                            activityB.runOnUiThread(new Runnable() { // from class: com.transsion.fission.f
                                @Override // java.lang.Runnable
                                public final void run() {
                                    FissionProvider$finishPalmPayTask$1.d(homePopupEntity);
                                }
                            });
                        }
                    }
                }
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    uo.b.a.k(uo.b.f78622a, "finishPalmPayTask() ---> getOrElse() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            objA = obj;
            baseDto = (BaseDto) objA;
            if (baseDto != null) {
                code = baseDto.getCode();
            } else {
                code = null;
            }
            if (Intrinsics.b(code, "0")) {
                palmPayTaskResult = (PalmPayTaskResult) baseDto.getData();
                if (palmPayTaskResult != null) {
                    taskInfo = palmPayTaskResult.getTaskInfo();
                } else {
                    taskInfo = null;
                }
                if (taskInfo != null) {
                    PalmPayMmkv.f350a.a().putBoolean("kv_task_is_finished", false);
                } else {
                    PalmPayMmkv.f350a.a().putBoolean("kv_task_is_finished", false);
                }
                palmPayTaskResult2 = (PalmPayTaskResult) baseDto.getData();
                if (palmPayTaskResult2 != null) {
                    popup = palmPayTaskResult2.getPopup();
                } else {
                    popup = null;
                }
                if (popup != null) {
                    homePopupEntity = new HomePopupEntity(popup, new HomePopupInfo(0L, "", 0, "", 0, "", ""), 0, 0L);
                    activityB = com.blankj.utilcode.util.a.b();
                    if (activityB != null) {
                        activityB.runOnUiThread(new Runnable() { // from class: com.transsion.fission.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                FissionProvider$finishPalmPayTask$1.d(homePopupEntity);
                            }
                        });
                    }
                }
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.a.k(uo.b.f78622a, "finishPalmPayTask() ---> getOrElse() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
        }
        return Unit.f68710a;
    }
}
