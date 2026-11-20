package com.transsion.member.adapter.task;

import android.widget.TextView;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.member.MemberFragment;
import com.transsion.member.MemberKV;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b extends BaseTaskCommonProvider {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.transsion.baselib.task.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f53246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MemberTaskItem f53247c;

        public a(TextView textView, MemberTaskItem memberTaskItem) {
            this.f53246b = textView;
            this.f53247c = memberTaskItem;
        }

        @Override // com.transsion.baselib.task.a
        public void a(boolean z11) {
            if (!z11) {
                zp.b.f82110a.e(b.this.g().getString(R$string.common_failed));
            } else {
                com.transsion.member.task.i.f53350a.b0();
                b.this.B(this.f53246b, this.f53247c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MemberFragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public boolean C(MemberTaskItem memberTaskItem) {
        return com.transsion.member.task.i.f53350a.E() > 0;
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void D() {
        com.transsion.member.task.i.f53350a.u();
        MemberKV.f53157a.a().putLong("kv_download_app_claim_item", System.currentTimeMillis());
    }

    @Override // com.transsion.member.adapter.task.BaseTaskCommonProvider
    public void H(TextView button, MemberTaskItem item) {
        String jumpUrl;
        Intrinsics.g(button, "button");
        Intrinsics.g(item, "item");
        long jCurrentTimeMillis = System.currentTimeMillis() - MemberKV.f53157a.a().getLong("kv_download_app_claim_item", 0L);
        Integer timeInterval = item.getTimeInterval();
        if (jCurrentTimeMillis <= (timeInterval != null ? timeInterval.intValue() : 0) * 1000) {
            zp.b.f82110a.e(g().getString(R$string.try_again));
            return;
        }
        String jumpUrl2 = item.getJumpUrl();
        if (jumpUrl2 == null || jumpUrl2.length() == 0) {
            jumpUrl = "oneroom://com.community.oneroom?type=/common/dialog&name=DownloadInterceptDialog";
        } else {
            jumpUrl = item.getJumpUrl();
            if (jumpUrl == null) {
                jumpUrl = "";
            }
        }
        ArouterUtil.f51292a.b(g(), jumpUrl, new a(button, item));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return TaskType.DOWNLOAD_APP.getValue();
    }
}
