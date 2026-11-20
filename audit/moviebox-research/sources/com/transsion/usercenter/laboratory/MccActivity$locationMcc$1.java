package com.transsion.usercenter.laboratory;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.db.mcc.LocalMcc;
import com.transsion.ad.strategy.NationalInformationManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

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
@DebugMetadata(c = "com.transsion.usercenter.laboratory.MccActivity$locationMcc$1", f = "MccActivity.kt", l = {107}, m = "invokeSuspend")
@SourceDebugExtension
public final class MccActivity$locationMcc$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $iso;
    int label;
    final /* synthetic */ MccActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MccActivity$locationMcc$1(String str, MccActivity mccActivity, Continuation<? super MccActivity$locationMcc$1> continuation) {
        super(2, continuation);
        this.$iso = str;
        this.this$0 = mccActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MccActivity$locationMcc$1(this.$iso, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MccActivity$locationMcc$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<a1> listD;
        xy.f fVar;
        RecyclerView recyclerView;
        RecyclerView.m layoutManager;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            NationalInformationManager nationalInformationManager = NationalInformationManager.f50580a;
            String str = this.$iso;
            this.label = 1;
            obj = nationalInformationManager.e(str, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        LocalMcc localMcc = (LocalMcc) obj;
        z0 z0Var = this.this$0.f59361a;
        if (z0Var != null && (listD = z0Var.D()) != null) {
            MccActivity mccActivity = this.this$0;
            int i12 = 0;
            for (Object obj2 : listD) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (TextUtils.equals(localMcc != null ? localMcc.getMcc() : null, ((a1) obj2).a().getMcc()) && (fVar = mccActivity.f59362b) != null && (recyclerView = fVar.f80801g) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
                    layoutManager.scrollToPosition(i12);
                }
                i12 = i13;
            }
        }
        return Unit.f68710a;
    }
}
