package com.transsion.postdetail.shorttv.vskitstyle.unlock;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import rx.b;
import rx.e;
import rx.f;
import rx.h;
import rx.i;

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
@DebugMetadata(c = "com.transsion.postdetail.shorttv.vskitstyle.unlock.ShortTvHisvanaAdUnlockRequest$unlock$1", f = "ShortTvHisvanaAdUnlockRequest.kt", l = {64}, m = "invokeSuspend")
public final class ShortTvHisvanaAdUnlockRequest$unlock$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ f $params;
    int label;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f55447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f55448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f55449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.transsion.ad.bidding.video.f f55450d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e f55451f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ f f55452g;

        public a(Context context, com.transsion.ad.bidding.video.f fVar, e eVar, f fVar2) {
            this.f55449c = context;
            this.f55450d = fVar;
            this.f55451f = eVar;
            this.f55452g = fVar2;
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            if (this.f55448b) {
                return;
            }
            this.f55451f.a(new h(this.f55452g));
            this.f55448b = true;
            this.f55450d.F();
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            Context context = this.f55449c;
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                this.f55450d.n0(fragmentActivity);
            }
        }

        @Override // jq.a
        public void j(int i11) {
            super.j(i11);
            if (this.f55447a) {
                this.f55451f.a(new i(this.f55452g, null, 2, null));
            } else {
                this.f55451f.a(new b(this.f55452g));
            }
            this.f55448b = true;
            this.f55450d.F();
        }

        @Override // jq.a
        public void l(int i11) {
            super.l(i11);
            this.f55447a = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvHisvanaAdUnlockRequest$unlock$1(Context context, e eVar, f fVar, Continuation<? super ShortTvHisvanaAdUnlockRequest$unlock$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$callback = eVar;
        this.$params = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvHisvanaAdUnlockRequest$unlock$1(this.$context, this.$callback, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvHisvanaAdUnlockRequest$unlock$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.bidding.video.f fVar = new com.transsion.ad.bidding.video.f();
            fVar.m0("ShortTvVideoScene");
            fVar.l0(new a(this.$context, fVar, this.$callback, this.$params));
            this.label = 1;
            if (fVar.T(this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
