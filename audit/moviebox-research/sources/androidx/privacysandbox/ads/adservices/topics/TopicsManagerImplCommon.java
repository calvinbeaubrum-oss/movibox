package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresPermission;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"NewApi"})
@SourceDebugExtension
public class TopicsManagerImplCommon extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TopicsManager f12349b;

    public TopicsManagerImplCommon(TopicsManager mTopicsManager) {
        Intrinsics.g(mTopicsManager, "mTopicsManager");
        this.f12349b = mTopicsManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public static /* synthetic */ Object e(TopicsManagerImplCommon topicsManagerImplCommon, a aVar, Continuation<? super b> continuation) throws Throwable {
        TopicsManagerImplCommon$getTopics$1 topicsManagerImplCommon$getTopics$1;
        if (continuation instanceof TopicsManagerImplCommon$getTopics$1) {
            topicsManagerImplCommon$getTopics$1 = (TopicsManagerImplCommon$getTopics$1) continuation;
            int i11 = topicsManagerImplCommon$getTopics$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                topicsManagerImplCommon$getTopics$1.label = i11 - Integer.MIN_VALUE;
            } else {
                topicsManagerImplCommon$getTopics$1 = new TopicsManagerImplCommon$getTopics$1(topicsManagerImplCommon, continuation);
            }
        } else {
            topicsManagerImplCommon$getTopics$1 = new TopicsManagerImplCommon$getTopics$1(topicsManagerImplCommon, continuation);
        }
        Object objF = topicsManagerImplCommon$getTopics$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = topicsManagerImplCommon$getTopics$1.label;
        if (i12 == 0) {
            ResultKt.b(objF);
            GetTopicsRequest getTopicsRequestC = topicsManagerImplCommon.c(aVar);
            topicsManagerImplCommon$getTopics$1.L$0 = topicsManagerImplCommon;
            topicsManagerImplCommon$getTopics$1.label = 1;
            objF = topicsManagerImplCommon.f(getTopicsRequestC, topicsManagerImplCommon$getTopics$1);
            if (objF == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            topicsManagerImplCommon = (TopicsManagerImplCommon) topicsManagerImplCommon$getTopics$1.L$0;
            ResultKt.b(objF);
        }
        return topicsManagerImplCommon.d(m.a(objF));
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.d
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public Object a(a aVar, Continuation<? super b> continuation) {
        return e(this, aVar, continuation);
    }

    public GetTopicsRequest c(a request) {
        Intrinsics.g(request, "request");
        GetTopicsRequest getTopicsRequestBuild = h.a().setAdsSdkName(request.a()).build();
        Intrinsics.f(getTopicsRequestBuild, "Builder()\n            .s…ame)\n            .build()");
        return getTopicsRequestBuild;
    }

    public final b d(GetTopicsResponse response) {
        Intrinsics.g(response, "response");
        ArrayList arrayList = new ArrayList();
        Iterator it = response.getTopics().iterator();
        while (it.hasNext()) {
            Topic topicA = p.a(it.next());
            arrayList.add(new c(topicA.getTaxonomyVersion(), topicA.getModelVersion(), topicA.getTopicId()));
        }
        return new b(arrayList);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public final Object f(GetTopicsRequest getTopicsRequest, Continuation<? super GetTopicsResponse> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.f12349b.getTopics(getTopicsRequest, new b6.m(), androidx.core.os.q.a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }
}
