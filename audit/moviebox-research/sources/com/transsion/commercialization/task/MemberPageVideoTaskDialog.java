package com.transsion.commercialization.task;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MemberPageVideoTaskDialog extends BaseMemberLoadingDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f51760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51761d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.ad.bidding.video.f f51762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f51763g = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {
        public a() {
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            MemberPageVideoTaskDialog.this.dismissAllowingStateLoss();
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            com.transsion.ad.bidding.video.f fVar;
            super.h(biddingIntermediateMaterialBean);
            FragmentActivity activity = MemberPageVideoTaskDialog.this.getActivity();
            if (activity == null || (fVar = MemberPageVideoTaskDialog.this.f51762f) == null) {
                return;
            }
            fVar.n0(activity);
        }

        @Override // jq.a
        public void j(int i11) {
            super.j(i11);
            MemberPageVideoTaskDialog.this.dismissAllowingStateLoss();
        }

        @Override // jq.a
        public void l(int i11) {
            super.l(i11);
            MemberPageVideoTaskDialog.this.f51761d = true;
        }
    }

    /* JADX INFO: renamed from: com.transsion.commercialization.task.MemberPageVideoTaskDialog$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.commercialization.task.MemberPageVideoTaskDialog$onViewCreated$1", f = "MemberPageVideoTaskDialog.kt", l = {66}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MemberPageVideoTaskDialog.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                MemberPageVideoTaskDialog.this.f51762f = new com.transsion.ad.bidding.video.f();
                com.transsion.ad.bidding.video.f fVar = MemberPageVideoTaskDialog.this.f51762f;
                if (fVar != null) {
                    fVar.m0("MemberPageVideoTaskScene");
                }
                com.transsion.ad.bidding.video.f fVar2 = MemberPageVideoTaskDialog.this.f51762f;
                if (fVar2 != null) {
                    fVar2.l0(MemberPageVideoTaskDialog.this.f51763g);
                }
                com.transsion.ad.bidding.video.f fVar3 = MemberPageVideoTaskDialog.this.f51762f;
                if (fVar3 != null) {
                    this.label = 1;
                    if (fVar3.T(this) == objE) {
                        return objE;
                    }
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

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ad.bidding.video.f fVar = this.f51762f;
        if (fVar != null) {
            fVar.F();
        }
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        Function1<? super Boolean, Unit> function1 = this.f51760c;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this.f51761d));
        }
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        kotlinx.coroutines.j.d(v.a(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final MemberPageVideoTaskDialog s0(Function1<? super Boolean, Unit> function1) {
        this.f51760c = function1;
        return this;
    }
}
