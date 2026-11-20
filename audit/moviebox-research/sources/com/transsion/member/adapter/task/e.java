package com.transsion.member.adapter.task;

import android.widget.TextView;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.member.MemberFragment;
import com.transsion.member.R$string;
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
public final class e extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MemberFragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public String A(MemberTaskItem item) {
        Intrinsics.g(item, "item");
        Integer durationCondition = item.getDurationCondition();
        long jIntValue = ((long) (durationCondition != null ? durationCondition.intValue() : 0)) / 60;
        long jH = kotlin.ranges.a.h(com.transsion.member.task.i.f53350a.G(), jIntValue);
        return item.getTitle() + " (" + jH + "/" + jIntValue + g().getString(R$string.member_task_mins) + ")";
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public boolean C(MemberTaskItem memberTaskItem) {
        Integer status;
        return (memberTaskItem == null || (status = memberTaskItem.getStatus()) == null || status.intValue() != 3) && com.transsion.member.task.i.f53350a.Q();
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void H(TextView button, MemberTaskItem item) {
        String jumpUrl;
        Intrinsics.g(button, "button");
        Intrinsics.g(item, "item");
        String jumpUrl2 = item.getJumpUrl();
        if (jumpUrl2 == null || jumpUrl2.length() == 0) {
            jumpUrl = "oneroom://com.community.oneroom?type=/main/tab&bottomTab=home&topTab=Game";
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
        return TaskType.GAME_RES_BROWSE.getValue();
    }
}
