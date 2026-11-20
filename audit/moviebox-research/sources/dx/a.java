package dx;

import android.content.Context;
import android.widget.ImageView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.h;
import com.transsion.publish.api.GroupBean;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import h9.f;
import h9.i;
import h9.j;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a extends BaseQuickAdapter<GroupBean, BaseViewHolder> implements j {
    public final int H;
    public final int I;

    public a(int i11) {
        super(i11, null, 2, null);
        this.H = f0.a(48.0f);
        this.I = f0.a(48.0f);
    }

    public /* synthetic */ a(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? R$layout.item_search_group : i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, GroupBean item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        holder.setText(R$id.tv_name, item.getName());
        holder.setText(R$id.tv_des, h.f51463a.a(item.getUserCount()) + " checkin");
        holder.setVisible(R$id.iv_select, item.getSelect());
        Context context = holder.itemView.getContext();
        ImageView ivAvatar = (ImageView) holder.itemView.findViewById(R$id.iv_avatar);
        String avatar = item.getAvatar();
        if (avatar != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Intrinsics.f(context, "context");
            Intrinsics.f(ivAvatar, "ivAvatar");
            companion.o(context, ivAvatar, avatar, (32704 & 8) != 0 ? R$color.skeleton : R$color.cl34_ff, (32704 & 16) != 0 ? companion.d() : this.H, (32704 & 32) != 0 ? companion.c() : this.I, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        }
        H0(item, P(item));
    }

    public final void H0(GroupBean groupBean, int i11) {
        HashMap map = new HashMap();
        String groupId = groupBean.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        map.put("group_id", groupId);
        map.put("sequence", String.valueOf(i11));
        String ops = groupBean.getOps();
        map.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f51183a.a("searchresult", map);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
