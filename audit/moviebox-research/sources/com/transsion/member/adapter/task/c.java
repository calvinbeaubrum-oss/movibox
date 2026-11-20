package com.transsion.member.adapter.task;

import android.widget.TextView;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.member.MemberFragment;
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
public final class c extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MemberFragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public String A(MemberTaskItem item) {
        Intrinsics.g(item, "item");
        Integer timesCondition = item.getTimesCondition();
        int iIntValue = timesCondition != null ? timesCondition.intValue() : 0;
        int iG = kotlin.ranges.a.g(com.transsion.member.task.i.f53350a.J(), iIntValue);
        return item.getTitle() + " (" + iG + "/" + iIntValue + ")";
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public boolean C(MemberTaskItem memberTaskItem) {
        Integer timesCondition;
        return com.transsion.member.task.i.f53350a.J() >= ((memberTaskItem == null || (timesCondition = memberTaskItem.getTimesCondition()) == null) ? 0 : timesCondition.intValue());
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void D() {
        com.transsion.member.task.i.f53350a.v();
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void H(TextView button, MemberTaskItem item) {
        String jumpUrl;
        Intrinsics.g(button, "button");
        Intrinsics.g(item, "item");
        String jumpUrl2 = item.getJumpUrl();
        if (jumpUrl2 == null || jumpUrl2.length() == 0) {
            jumpUrl = "oneroom://com.community.oneroom?type=/main/tab&tabIndex=0";
        } else {
            jumpUrl = item.getJumpUrl();
            if (jumpUrl == null) {
                jumpUrl = "";
            }
        }
        ArouterUtil.c(ArouterUtil.f51292a, g(), jumpUrl, null, 4, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return TaskType.DOWNLOAD_MOVIE.getValue();
    }
}
