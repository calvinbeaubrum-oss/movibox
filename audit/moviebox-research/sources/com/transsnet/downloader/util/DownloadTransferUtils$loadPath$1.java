package com.transsnet.downloader.util;

import android.content.Context;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
@DebugMetadata(c = "com.transsnet.downloader.util.DownloadTransferUtils$loadPath$1", f = "DownloadTransferUtils.kt", l = {165}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadTransferUtils$loadPath$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Map<String, String>, Unit> $onComplete;
    final /* synthetic */ List<String> $urls;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadTransferUtils$loadPath$1(List<String> list, Function1<? super Map<String, String>, Unit> function1, Context context, Continuation<? super DownloadTransferUtils$loadPath$1> continuation) {
        super(2, continuation);
        this.$urls = list;
        this.$onComplete = function1;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadTransferUtils$loadPath$1 downloadTransferUtils$loadPath$1 = new DownloadTransferUtils$loadPath$1(this.$urls, this.$onComplete, this.$context, continuation);
        downloadTransferUtils$loadPath$1.L$0 = obj;
        return downloadTransferUtils$loadPath$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadTransferUtils$loadPath$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Map<String, String> map;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            k0 k0Var = (k0) this.L$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<String> list = this.$urls;
            Context context = this.$context;
            ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(kotlinx.coroutines.j.b(k0Var, w0.b(), null, new DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1((String) it.next(), context, null), 2, null));
            }
            this.L$0 = linkedHashMap;
            this.label = 1;
            obj = AwaitKt.a(arrayList, this);
            if (obj == objE) {
                return objE;
            }
            map = linkedHashMap;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) this.L$0;
            ResultKt.b(obj);
        }
        for (Pair pair : (List) obj) {
            String str = (String) pair.component1();
            File file = (File) pair.component2();
            map.put(str, file != null ? file.getAbsolutePath() : null);
        }
        uo.b.a.o(uo.b.f78622a, TransferBottomToolsView.TAG, new String[]{"所有封面加载--完成"}, false, 4, null);
        this.$onComplete.invoke(map);
        return Unit.f68710a;
    }
}
