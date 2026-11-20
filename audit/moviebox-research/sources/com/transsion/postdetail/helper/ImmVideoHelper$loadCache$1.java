package com.transsion.postdetail.helper;

import com.blankj.utilcode.util.n;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.utils.PreloadBuiltinHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "com.transsion.postdetail.helper.ImmVideoHelper$loadCache$1", f = "ImmVideoHelper.kt", l = {}, m = "invokeSuspend")
public final class ImmVideoHelper$loadCache$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImmVideoHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmVideoHelper$loadCache$1(ImmVideoHelper immVideoHelper, Continuation<? super ImmVideoHelper$loadCache$1> continuation) {
        super(2, continuation);
        this.this$0 = immVideoHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImmVideoHelper$loadCache$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ImmVideoHelper$loadCache$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            String string = RoomAppMMKV.f51271a.a().getString("k_save_video", "");
            List<PostSubjectItem> listF = (string == null || string.length() <= 0) ? null : (List) n.e(string, n.g(PostSubjectItem.class));
            List<PostSubjectItem> list = listF;
            if (list == null || list.isEmpty()) {
                listF = PreloadBuiltinHelper.f59764a.a().f();
            }
            if (listF == null || !(!listF.isEmpty())) {
                this.this$0.g().n(null);
            } else {
                this.this$0.g().n(listF);
            }
        } catch (Exception unused) {
            this.this$0.g().n(null);
        }
        return Unit.f68710a;
    }
}
