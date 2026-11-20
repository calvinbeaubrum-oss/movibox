package gx;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class a extends BaseItemProvider<ResultWrapData> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return ResultType.GROUP.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.provider_result_group;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, ResultWrapData item) {
        String url;
        String thumbnail;
        List<String> tags;
        Cover cover;
        Cover cover2;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        ImageView imageView = (ImageView) helper.getView(R$id.search_result_provider_group_cover);
        Group groups = item.getGroups();
        if (groups == null || (cover2 = groups.getCover()) == null || (url = cover2.getUrl()) == null) {
            url = "";
        }
        int iA = f0.a(50.0f);
        Group groups2 = item.getGroups();
        if (groups2 == null || (cover = groups2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
            thumbnail = "";
        }
        companion.q(contextG, imageView, url, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        int i11 = R$id.search_result_provider_group_title;
        Group groups3 = item.getGroups();
        String strA = null;
        helper.setText(i11, groups3 != null ? groups3.getName() : null);
        Group groups4 = item.getGroups();
        if ((groups4 != null ? groups4.getUserCount() : null) != null) {
            Long userCount = item.getGroups().getUserCount();
            if (userCount != null) {
                strA = i.a(userCount.longValue());
            }
        } else {
            strA = "0";
        }
        CharSequence string = g().getString(R$string.members, strA);
        Intrinsics.f(string, "context.getString(com.tn…ng.members, userCountStr)");
        helper.setText(R$id.search_result_provider_group_member, string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Group groups5 = item.getGroups();
        if (groups5 != null && (tags = groups5.getTags()) != null) {
            int i12 = 0;
            for (Object obj : tags) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                spannableStringBuilder.append((CharSequence) obj);
                List<String> tags2 = item.getGroups().getTags();
                if (i12 < (tags2 != null ? tags2.size() : 0) - 1) {
                    spannableStringBuilder.append((CharSequence) "￼");
                    spannableStringBuilder.setSpan(xw.f.b(g()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                }
                i12 = i13;
            }
        }
        if (spannableStringBuilder.length() > 0) {
            helper.setText(R$id.search_result_provider_group_des, spannableStringBuilder);
            helper.setVisible(R$id.search_result_provider_group_des, true);
        } else {
            helper.setGone(R$id.search_result_provider_group_des, true);
        }
        Group groups6 = item.getGroups();
        if (groups6 == null || !Intrinsics.b(groups6.getHasJoin(), Boolean.TRUE)) {
            helper.setImageResource(R$id.search_result_provider_group_arrow, R$mipmap.ic_room_join_def_white);
        } else {
            helper.setImageResource(R$id.search_result_provider_group_arrow, R$drawable.ic_result_arrow);
        }
    }
}
