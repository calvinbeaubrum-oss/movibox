package com.transsion.member.adapter.task;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.web.api.WebPageIdentity;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class l extends BaseItemProvider<MemberTaskItem> {
    public static final void w(MemberTaskItem item, View view) {
        Intrinsics.g(item, "$item");
        String groupUrl = item.getGroupUrl();
        if (groupUrl != null) {
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
            HashMap map = new HashMap();
            map.put("event_detail", "task_title_right");
            map.put("group_name", String.valueOf(item.getGroupName()));
            map.put("group_title", String.valueOf(item.getTitle()));
            Unit unit = Unit.f68710a;
            aVar.b("memberdetail", map);
            if (kotlin.text.l.L(groupUrl, "http://", false, 2, null) || kotlin.text.l.L(groupUrl, AgentPageJsBridge.HTTPS, false, 2, null)) {
                com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", groupUrl).navigation();
            } else {
                com.transsion.baselib.utils.i.e(groupUrl, null, 1, null);
            }
        }
    }

    private final int x() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? GravityCompat.END : GravityCompat.START;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return TaskType.TITLE.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_task_title;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final MemberTaskItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) helper.getView(R$id.member_item_task_title);
        textView.setText(item.getTitle());
        textView.setGravity(x());
        String groupUrl = item.getGroupUrl();
        if (groupUrl == null || groupUrl.length() == 0) {
            helper.setGone(R$id.member_item_task_title_right, true);
        } else {
            helper.setGone(R$id.member_item_task_title_right, false);
            helper.getView(R$id.member_item_task_title_right).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.adapter.task.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.w(item, view);
                }
            });
        }
    }
}
