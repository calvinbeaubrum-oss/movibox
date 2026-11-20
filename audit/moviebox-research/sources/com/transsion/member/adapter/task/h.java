package com.transsion.member.adapter.task;

import android.widget.TextView;
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
public final class h extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MemberFragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void B(TextView button, MemberTaskItem item) {
        Intrinsics.g(button, "button");
        Intrinsics.g(item, "item");
        super.B(button, item);
        button.setAlpha(0.5f);
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void H(TextView button, MemberTaskItem item) {
        Intrinsics.g(button, "button");
        Intrinsics.g(item, "item");
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return TaskType.OPEN_APP.getValue();
    }
}
