package com.transsnet.downloader.viewmodel;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadViewModel$getDownloadedList$1", f = "DownloadViewModel.kt", l = {198}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadViewModel$getDownloadedList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromDb;
    int label;
    final /* synthetic */ DownloadViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$getDownloadedList$1(boolean z11, DownloadViewModel downloadViewModel, Continuation<? super DownloadViewModel$getDownloadedList$1> continuation) {
        super(2, continuation);
        this.$fromDb = z11;
        this.this$0 = downloadViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$getDownloadedList$1(this.$fromDb, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadViewModel$getDownloadedList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            boolean z11 = this.$fromDb;
            this.label = 1;
            obj = downloadEsHelperA.v(z11, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.this$0.f61233a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.o(aVar, TAG, new String[]{"getDownloadedList, is empty"}, false, 4, null);
            this.this$0.f61247p.n(new ArrayList());
            return Unit.f68710a;
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : list) {
            String subjectId = ((DownloadBean) obj2).getSubjectId();
            Object arrayList2 = linkedHashMap.get(subjectId);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(subjectId, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List list3 = (List) ((Map.Entry) it.next()).getValue();
            if (list3.size() == 1) {
                arrayList.addAll(list3);
            } else {
                arrayList.add(this.this$0.I(list3));
            }
        }
        uo.b.a aVar2 = uo.b.f78622a;
        String TAG2 = this.this$0.f61233a;
        Intrinsics.f(TAG2, "TAG");
        uo.b.a.o(aVar2, TAG2, new String[]{"getDownloadedList, size = " + arrayList.size()}, false, 4, null);
        this.this$0.f61247p.n(arrayList);
        return Unit.f68710a;
    }
}
