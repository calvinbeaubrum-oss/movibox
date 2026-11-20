package com.transsion.member.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.v;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.member.R$string;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.OpType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class CheckMemberRightsLoadingDialog extends BaseMemberLoadingDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public su.a f53261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MemberSceneType f53262d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f53263f;

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.transsion.member.a.f53220a.a(g0() + " --> onCreate() --> 会员权益校验 --> 中间过度弹窗 --> 请求接口判断是否需要拦截");
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        s0();
    }

    public final void r0(MemberCheckResult memberCheckResult) {
        Resources resources;
        com.transsion.member.a.f53220a.a(g0() + " --> checkMember() --> it = " + memberCheckResult);
        String string = null;
        if (memberCheckResult == null) {
            zp.b.a aVar = zp.b.f82110a;
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                string = resources.getString(R$string.co_network_error);
            }
            aVar.e(string);
            su.a aVar2 = this.f53261c;
            if (aVar2 != null) {
                aVar2.onFail("权益校验接口请求失败");
            }
            if (!isAdded() || isDetached()) {
                return;
            }
            dismissAllowingStateLoss();
            return;
        }
        kotlinx.coroutines.j.d(v.a(this), null, null, new CheckMemberRightsLoadingDialog$analysis$1(this, null), 3, null);
        if (Intrinsics.b(memberCheckResult.isPassed(), Boolean.TRUE)) {
            su.a aVar3 = this.f53261c;
            if (aVar3 != null) {
                aVar3.d();
                return;
            }
            return;
        }
        String interceptType = memberCheckResult.getInterceptType();
        if (Intrinsics.b(interceptType, OpType.OP_INSTALL.getValue())) {
            su.a aVar4 = this.f53261c;
            if (aVar4 != null) {
                aVar4.c(memberCheckResult);
                return;
            }
            return;
        }
        if (Intrinsics.b(interceptType, OpType.OP_AD.getValue())) {
            su.a aVar5 = this.f53261c;
            if (aVar5 != null) {
                aVar5.b(memberCheckResult);
                return;
            }
            return;
        }
        if (Intrinsics.b(interceptType, OpType.OP_VIP.getValue())) {
            su.a aVar6 = this.f53261c;
            if (aVar6 != null) {
                aVar6.a(memberCheckResult);
                return;
            }
            return;
        }
        su.a aVar7 = this.f53261c;
        if (aVar7 != null) {
            aVar7.e(memberCheckResult);
        }
    }

    public final void s0() {
        kotlinx.coroutines.j.d(v.a(this), null, null, new CheckMemberRightsLoadingDialog$checkMember$1(this, null), 3, null);
    }

    public final void t0(su.a aVar) {
        this.f53261c = aVar;
    }

    public final void u0(MemberSceneType memberSceneType, Integer num) {
        this.f53262d = memberSceneType;
        this.f53263f = num;
    }
}
