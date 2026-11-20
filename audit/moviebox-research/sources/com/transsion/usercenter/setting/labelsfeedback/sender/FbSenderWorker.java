package com.transsion.usercenter.setting.labelsfeedback.sender;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.n;
import com.cloud.config.utils.CommonUtils;
import com.google.android.material.timepicker.TimeModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.upload.log.UploadLoggerManager;
import com.transsion.usercenter.setting.feedback.bean.FeedbackEntity;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.RequestBody;

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
public final class FbSenderWorker extends CoroutineWorker {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ty.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f59751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation<Pair<String, String>> f59752b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Continuation<? super Pair<String, String>> continuation) {
            this.f59752b = continuation;
        }

        @Override // ty.a
        public void a(String localFilePath, long j11, long j12) {
            Intrinsics.g(localFilePath, "localFilePath");
        }

        @Override // ty.a
        public void b(String localFilePath, String url, String bucket) {
            Intrinsics.g(localFilePath, "localFilePath");
            Intrinsics.g(url, "url");
            Intrinsics.g(bucket, "bucket");
            if (this.f59751a) {
                return;
            }
            Continuation<Pair<String, String>> continuation = this.f59752b;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m163constructorimpl(new Pair(url, bucket)));
            this.f59751a = true;
        }

        @Override // ty.a
        public void c(String localFilePath, String str, String str2, UploadTstTokenStorageType uploadTstTokenStorageType) {
            Intrinsics.g(localFilePath, "localFilePath");
            if (this.f59751a) {
                return;
            }
            Continuation<Pair<String, String>> continuation = this.f59752b;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m163constructorimpl(ResultKt.a(new Error("unable to upload log"))));
            this.f59751a = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ty.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f59753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation<String> f59754b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Continuation<? super String> continuation) {
            this.f59754b = continuation;
        }

        @Override // ty.a
        public void a(String uploadKey, long j11, long j12) {
            Intrinsics.g(uploadKey, "uploadKey");
        }

        @Override // ty.a
        public void b(String uploadKey, String url, String bucket) {
            Intrinsics.g(uploadKey, "uploadKey");
            Intrinsics.g(url, "url");
            Intrinsics.g(bucket, "bucket");
            if (this.f59753a) {
                return;
            }
            this.f59754b.resumeWith(Result.m163constructorimpl(uploadKey));
            this.f59753a = true;
        }

        @Override // ty.a
        public void c(String uploadKey, String str, String str2, UploadTstTokenStorageType uploadTstTokenStorageType) {
            Intrinsics.g(uploadKey, "uploadKey");
            if (this.f59753a) {
                return;
            }
            Continuation<String> continuation = this.f59754b;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m163constructorimpl(ResultKt.a(new Error("unable to upload log"))));
            this.f59753a = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FbSenderWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.g(appContext, "appContext");
        Intrinsics.g(workerParams, "workerParams");
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0129 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x012a  */
    /* JADX WARN: Code duplicated, block: B:52:0x014c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x0157 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:15:0x0037, B:53:0x014d, B:55:0x0157, B:57:0x015d, B:22:0x0057, B:50:0x012e, B:25:0x0076, B:44:0x0106, B:46:0x0117, B:28:0x0093, B:40:0x00e4, B:34:0x00bb, B:36:0x00cb), top: B:62:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, java.lang.Object] */
    @Override // androidx.work.CoroutineWorker
    public Object d(Continuation<? super i.a> continuation) throws Throwable {
        FbSenderWorker$doWork$1 fbSenderWorker$doWork$1;
        FbDataModel fbDataModel;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        String imagePath;
        FbSenderWorker fbSenderWorker;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        FbDataModel fbDataModel2;
        FbSenderWorker fbSenderWorker2;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        FbDataModel fbDataModel3;
        Object objL;
        FbDataModel fbDataModel4;
        Ref.ObjectRef objectRef8;
        FbSenderWorker fbSenderWorker3;
        FeedbackEntity feedbackEntity;
        if (continuation instanceof FbSenderWorker$doWork$1) {
            fbSenderWorker$doWork$1 = (FbSenderWorker$doWork$1) continuation;
            int i11 = fbSenderWorker$doWork$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                fbSenderWorker$doWork$1.label = i11 - Integer.MIN_VALUE;
            } else {
                fbSenderWorker$doWork$1 = new FbSenderWorker$doWork$1(this, continuation);
            }
        } else {
            fbSenderWorker$doWork$1 = new FbSenderWorker$doWork$1(this, continuation);
        }
        FbSenderWorker$doWork$1 fbSenderWorker$doWork$2 = fbSenderWorker$doWork$1;
        Object objK = fbSenderWorker$doWork$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = fbSenderWorker$doWork$2.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objK);
                fbDataModel = (FbDataModel) n.d(getInputData().i("key_work_data"), FbDataModel.class);
                if (fbDataModel == null) {
                    i.a aVarA = i.a.a();
                    Intrinsics.f(aVarA, "failure()");
                    return aVarA;
                }
                objectRef = new Ref.ObjectRef();
                objectRef2 = new Ref.ObjectRef();
                imagePath = fbDataModel.getImagePath();
                if (imagePath != null) {
                    fbSenderWorker$doWork$2.L$0 = this;
                    fbSenderWorker$doWork$2.L$1 = fbDataModel;
                    fbSenderWorker$doWork$2.L$2 = objectRef;
                    fbSenderWorker$doWork$2.L$3 = objectRef2;
                    fbSenderWorker$doWork$2.L$4 = imagePath;
                    fbSenderWorker$doWork$2.L$5 = objectRef;
                    fbSenderWorker$doWork$2.label = 1;
                    Object objK2 = k(imagePath, fbSenderWorker$doWork$2);
                    if (objK2 == objE) {
                        return objE;
                    }
                    fbDataModel2 = fbDataModel;
                    fbSenderWorker2 = this;
                    objK = objK2;
                    objectRef5 = objectRef;
                } else {
                    fbSenderWorker = this;
                    objectRef3 = objectRef;
                    objectRef4 = objectRef2;
                }
                fbSenderWorker$doWork$2.L$0 = fbSenderWorker;
                fbSenderWorker$doWork$2.L$1 = fbDataModel;
                fbSenderWorker$doWork$2.L$2 = objectRef3;
                fbSenderWorker$doWork$2.L$3 = objectRef4;
                fbSenderWorker$doWork$2.L$4 = null;
                fbSenderWorker$doWork$2.label = 3;
                objL = fbSenderWorker.l(fbSenderWorker$doWork$2);
                if (objL == objE) {
                    return objE;
                }
                fbDataModel4 = fbDataModel;
                objK = objL;
                objectRef8 = objectRef4;
                fbSenderWorker3 = fbSenderWorker;
                String str = (String) objectRef3.element;
                String str2 = (String) objectRef8.element;
                fbSenderWorker$doWork$2.L$0 = null;
                fbSenderWorker$doWork$2.L$1 = null;
                fbSenderWorker$doWork$2.L$2 = null;
                fbSenderWorker$doWork$2.L$3 = null;
                fbSenderWorker$doWork$2.label = 4;
                objK = fbSenderWorker3.j(str, (String) objK, fbDataModel4, str2, fbSenderWorker$doWork$2);
                if (objK == objE) {
                    return objE;
                }
                feedbackEntity = (FeedbackEntity) ((BaseDto) objK).getData();
                if (feedbackEntity != null) {
                    i.a aVarC = i.a.c();
                    Intrinsics.f(aVarC, "success()");
                    return aVarC;
                }
                i.a aVarA2 = i.a.a();
                Intrinsics.f(aVarA2, "failure()");
                return aVarA2;
            }
            if (i12 == 1) {
                objectRef = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$5;
                String str3 = (String) fbSenderWorker$doWork$2.L$4;
                Ref.ObjectRef objectRef9 = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$3;
                objectRef5 = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$2;
                fbDataModel2 = (FbDataModel) fbSenderWorker$doWork$2.L$1;
                fbSenderWorker2 = (FbSenderWorker) fbSenderWorker$doWork$2.L$0;
                ResultKt.b(objK);
                imagePath = str3;
                objectRef2 = objectRef9;
            } else if (i12 == 2) {
                objectRef6 = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$4;
                objectRef7 = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$3;
                objectRef3 = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$2;
                fbDataModel3 = (FbDataModel) fbSenderWorker$doWork$2.L$1;
                fbSenderWorker = (FbSenderWorker) fbSenderWorker$doWork$2.L$0;
                ResultKt.b(objK);
                objectRef6.element = ((Pair) objK).getSecond();
                objectRef4 = objectRef7;
                fbDataModel = fbDataModel3;
                fbSenderWorker$doWork$2.L$0 = fbSenderWorker;
                fbSenderWorker$doWork$2.L$1 = fbDataModel;
                fbSenderWorker$doWork$2.L$2 = objectRef3;
                fbSenderWorker$doWork$2.L$3 = objectRef4;
                fbSenderWorker$doWork$2.L$4 = null;
                fbSenderWorker$doWork$2.label = 3;
                objL = fbSenderWorker.l(fbSenderWorker$doWork$2);
                if (objL == objE) {
                    return objE;
                }
                fbDataModel4 = fbDataModel;
                objK = objL;
                objectRef8 = objectRef4;
                fbSenderWorker3 = fbSenderWorker;
                String str4 = (String) objectRef3.element;
                String str5 = (String) objectRef8.element;
                fbSenderWorker$doWork$2.L$0 = null;
                fbSenderWorker$doWork$2.L$1 = null;
                fbSenderWorker$doWork$2.L$2 = null;
                fbSenderWorker$doWork$2.L$3 = null;
                fbSenderWorker$doWork$2.label = 4;
                objK = fbSenderWorker3.j(str4, (String) objK, fbDataModel4, str5, fbSenderWorker$doWork$2);
                if (objK == objE) {
                    return objE;
                }
            } else if (i12 == 3) {
                Ref.ObjectRef objectRef10 = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$3;
                Ref.ObjectRef objectRef11 = (Ref.ObjectRef) fbSenderWorker$doWork$2.L$2;
                fbDataModel4 = (FbDataModel) fbSenderWorker$doWork$2.L$1;
                FbSenderWorker fbSenderWorker4 = (FbSenderWorker) fbSenderWorker$doWork$2.L$0;
                ResultKt.b(objK);
                objectRef8 = objectRef10;
                fbSenderWorker3 = fbSenderWorker4;
                objectRef3 = objectRef11;
                String str6 = (String) objectRef3.element;
                String str7 = (String) objectRef8.element;
                fbSenderWorker$doWork$2.L$0 = null;
                fbSenderWorker$doWork$2.L$1 = null;
                fbSenderWorker$doWork$2.L$2 = null;
                fbSenderWorker$doWork$2.L$3 = null;
                fbSenderWorker$doWork$2.label = 4;
                objK = fbSenderWorker3.j(str6, (String) objK, fbDataModel4, str7, fbSenderWorker$doWork$2);
                if (objK == objE) {
                    return objE;
                }
            } else {
                if (i12 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objK);
            }
            feedbackEntity = (FeedbackEntity) ((BaseDto) objK).getData();
            if (feedbackEntity != null && feedbackEntity.getResult()) {
                i.a aVarC2 = i.a.c();
                Intrinsics.f(aVarC2, "success()");
                return aVarC2;
            }
            i.a aVarA3 = i.a.a();
            Intrinsics.f(aVarA3, "failure()");
            return aVarA3;
            objectRef.element = ((Pair) objK).getFirst();
            fbSenderWorker$doWork$2.L$0 = fbSenderWorker2;
            fbSenderWorker$doWork$2.L$1 = fbDataModel2;
            fbSenderWorker$doWork$2.L$2 = objectRef5;
            fbSenderWorker$doWork$2.L$3 = objectRef2;
            fbSenderWorker$doWork$2.L$4 = objectRef2;
            fbSenderWorker$doWork$2.L$5 = null;
            fbSenderWorker$doWork$2.label = 2;
            objK = fbSenderWorker2.k(imagePath, fbSenderWorker$doWork$2);
            if (objK == objE) {
                return objE;
            }
            objectRef6 = objectRef2;
            objectRef7 = objectRef6;
            objectRef3 = objectRef5;
            fbDataModel3 = fbDataModel2;
            fbSenderWorker = fbSenderWorker2;
            objectRef6.element = ((Pair) objK).getSecond();
            objectRef4 = objectRef7;
            fbDataModel = fbDataModel3;
            fbSenderWorker$doWork$2.L$0 = fbSenderWorker;
            fbSenderWorker$doWork$2.L$1 = fbDataModel;
            fbSenderWorker$doWork$2.L$2 = objectRef3;
            fbSenderWorker$doWork$2.L$3 = objectRef4;
            fbSenderWorker$doWork$2.L$4 = null;
            fbSenderWorker$doWork$2.label = 3;
            objL = fbSenderWorker.l(fbSenderWorker$doWork$2);
            if (objL == objE) {
                return objE;
            }
            fbDataModel4 = fbDataModel;
            objK = objL;
            objectRef8 = objectRef4;
            fbSenderWorker3 = fbSenderWorker;
            String str8 = (String) objectRef3.element;
            String str9 = (String) objectRef8.element;
            fbSenderWorker$doWork$2.L$0 = null;
            fbSenderWorker$doWork$2.L$1 = null;
            fbSenderWorker$doWork$2.L$2 = null;
            fbSenderWorker$doWork$2.L$3 = null;
            fbSenderWorker$doWork$2.label = 4;
            objK = fbSenderWorker3.j(str8, (String) objK, fbDataModel4, str9, fbSenderWorker$doWork$2);
            if (objK == objE) {
                return objE;
            }
            feedbackEntity = (FeedbackEntity) ((BaseDto) objK).getData();
            if (feedbackEntity != null) {
                i.a aVarC3 = i.a.c();
                Intrinsics.f(aVarC3, "success()");
                return aVarC3;
            }
            i.a aVarA4 = i.a.a();
            Intrinsics.f(aVarA4, "failure()");
            return aVarA4;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final Object j(String str, String str2, FbDataModel fbDataModel, String str3, Continuation<? super BaseDto<FeedbackEntity>> continuation) {
        UserInfo userInfoP = ((ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class)).P();
        String userId = userInfoP != null ? userInfoP.getUserId() : null;
        JsonObject jsonObject = new JsonObject();
        if (userId == null) {
            userId = "0";
        }
        jsonObject.addProperty(CommonUtils.PARAM_UID, userId);
        jsonObject.addProperty(AppLovinEventTypes.USER_VIEWED_CONTENT, fbDataModel.getContent());
        if (str != null) {
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(str);
            jsonObject.add("imageUrl", jsonArray);
        }
        jsonObject.addProperty("email", "");
        String whole = fbDataModel.getContact().getWhole();
        if (whole != null) {
            jsonObject.addProperty("whatsApp", whole);
        }
        jsonObject.addProperty("pageName", fbDataModel.getPageName());
        String subjectId = fbDataModel.getSubjectId();
        if (subjectId != null) {
            jsonObject.addProperty("subjectId", subjectId);
        }
        FbTvData tv2 = fbDataModel.getTv();
        if (tv2 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str4 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Boxing.d(tv2.getSeason())}, 1));
            Intrinsics.f(str4, "format(...)");
            String str5 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Boxing.d(tv2.getEpisode())}, 1));
            Intrinsics.f(str5, "format(...)");
            jsonObject.addProperty("season", "S" + str4 + "  E" + str5);
        }
        jsonObject.addProperty("logId", str2);
        Integer selectedId = fbDataModel.getSelectedId();
        jsonObject.addProperty("label", Boxing.d(selectedId != null ? selectedId.intValue() : -1));
        jsonObject.addProperty("tempBucket", str3);
        ip.b.a aVar = ip.b.f67591a;
        String string = jsonObject.toString();
        Intrinsics.f(string, "obj.toString()");
        RequestBody requestBodyA = aVar.a(string);
        if (requestBodyA != null) {
            return ((lz.a) NetServiceGenerator.f49399d.a().i(lz.a.class)).b(cp.a.f62775a.a(), requestBodyA, continuation);
        }
        throw new Error("can not find feedback body");
    }

    public final Object k(String str, Continuation<? super Pair<String, String>> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        ty.b.f78077a.d(str, UploadFileType.OBJECT_NAME_IMAGE, true, new a(safeContinuation));
        Object objA = safeContinuation.a();
        if (objA == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objA;
    }

    public final Object l(Continuation<? super String> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        UploadLoggerManager.f59261a.l(new b(safeContinuation));
        Object objA = safeContinuation.a();
        if (objA == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objA;
    }
}
