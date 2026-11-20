package com.transsion.member.adapter.task;

import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.member.MemberFragment;
import com.transsion.member.R$id;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.MemberTaskItem;
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
public final class i extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(MemberFragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public String A(MemberTaskItem item) {
        Intrinsics.g(item, "item");
        return String.valueOf(item.getTitle());
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public boolean C(MemberTaskItem memberTaskItem) {
        return false;
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void D() {
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void H(TextView button, MemberTaskItem item) {
        String jumpUrl;
        Intrinsics.g(button, "button");
        Intrinsics.g(item, "item");
        String jumpUrl2 = item.getJumpUrl();
        if (jumpUrl2 == null || jumpUrl2.length() == 0) {
            jumpUrl = "https://h5-aoneroom.com/spa/fissionh5/pp";
        } else {
            jumpUrl = item.getJumpUrl();
            if (jumpUrl == null) {
                jumpUrl = "";
            }
        }
        ArouterUtil.c(ArouterUtil.f51292a, g(), "oneroom://com.community.oneroom?type=/web/web&url=" + jumpUrl, null, 4, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return TaskType.PALM_PAY.getValue();
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v */
    public void a(BaseViewHolder helper, MemberTaskItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        super.a(helper, item);
        TextView textView = (TextView) helper.getView(R$id.member_item_task_button);
        item.setStatus(0);
        B(textView, item);
    }
}
