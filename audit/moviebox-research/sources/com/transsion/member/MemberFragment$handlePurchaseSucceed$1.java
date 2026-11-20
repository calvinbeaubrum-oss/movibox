package com.transsion.member;

import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.FragmentActivity;
import com.transsion.memberapi.IMemberApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "com.transsion.member.MemberFragment$handlePurchaseSucceed$1", f = "MemberFragment.kt", l = {}, m = "invokeSuspend")
public final class MemberFragment$handlePurchaseSucceed$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $buttonTitle;
    final /* synthetic */ String $title;
    int label;
    final /* synthetic */ MemberFragment this$0;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements su.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MemberFragment f53153a;

        public a(MemberFragment memberFragment) {
            this.f53153a = memberFragment;
        }

        @Override // su.g
        public void a() {
            OnBackPressedDispatcher onBackPressedDispatcher;
            if (!(this.f53153a.getActivity() instanceof MemberActivity)) {
                com.alibaba.android.arouter.launcher.a.d().b("/main/tab").withInt("tabIndex", 0).navigation();
                return;
            }
            FragmentActivity activity = this.f53153a.getActivity();
            if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
                return;
            }
            onBackPressedDispatcher.l();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberFragment$handlePurchaseSucceed$1(MemberFragment memberFragment, String str, String str2, Continuation<? super MemberFragment$handlePurchaseSucceed$1> continuation) {
        super(2, continuation);
        this.this$0 = memberFragment;
        this.$title = str;
        this.$buttonTitle = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberFragment$handlePurchaseSucceed$1(this.this$0, this.$title, this.$buttonTitle, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MemberFragment$handlePurchaseSucceed$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!Intrinsics.b(this.this$0.getActivity(), com.blankj.utilcode.util.a.b()) || !this.this$0.isVisible()) {
            return Unit.f68710a;
        }
        IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        FragmentActivity activity = this.this$0.getActivity();
        String str = this.$title;
        if (str == null) {
            str = "";
        }
        String str2 = this.$buttonTitle;
        iMemberApi.k1(activity, str, str2 != null ? str2 : "", new a(this.this$0));
        return Unit.f68710a;
    }
}
