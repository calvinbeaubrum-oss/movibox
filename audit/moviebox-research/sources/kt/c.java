package kt;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$string;
import com.transsion.moviedetailapi.R$mipmap;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class c extends BaseItemProvider<Staff> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_cast;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, Staff item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            int i11 = R$mipmap.movie_staff_default_avatar;
            String avatarUrl = item.getAvatarUrl();
            if (avatarUrl == null || avatarUrl.length() == 0) {
                shapeableImageView.setImageResource(i11);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                String avatarUrl2 = item.getAvatarUrl();
                if (avatarUrl2 == null) {
                    avatarUrl2 = "";
                }
                companion.o(context, shapeableImageView, avatarUrl2, (32704 & 8) != 0 ? R$color.skeleton : i11, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
        }
        helper.setText(R$id.tv_title, item.getName());
        int i12 = R$id.tv_subject_num;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String string = g().getString(R$string.subject_num);
        Intrinsics.f(string, "context.getString(R.string.subject_num)");
        String str = String.format(string, Arrays.copyOf(new Object[]{item.getSubjectNum()}, 1));
        Intrinsics.f(str, "format(...)");
        helper.setText(i12, str);
        StringBuilder sb2 = new StringBuilder();
        List<StaffType> staffTypes = item.getStaffTypes();
        if (staffTypes != null) {
            Iterator<T> it = staffTypes.iterator();
            while (it.hasNext()) {
                sb2.append(((StaffType) it.next()).getName());
                sb2.append("•");
            }
        }
        helper.setText(R$id.tv_desc, StringsKt__StringsKt.a1(sb2, 8226));
        BaseProviderMultiAdapter<Staff> baseProviderMultiAdapterC = c();
        Integer numValueOf = baseProviderMultiAdapterC != null ? Integer.valueOf(baseProviderMultiAdapterC.P(item)) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            View viewOrNull = helper.getViewOrNull(R$id.divider);
            if (viewOrNull != null) {
                so.c.k(viewOrNull);
            }
            View viewOrNull2 = helper.getViewOrNull(R$id.bg_gradient);
            if (viewOrNull2 != null) {
                so.c.k(viewOrNull2);
            }
            View viewOrNull3 = helper.getViewOrNull(R$id.item_root);
            if (viewOrNull3 != null) {
                viewOrNull3.setBackgroundResource(R$drawable.bg_category_first_item);
                return;
            }
            return;
        }
        View viewOrNull4 = helper.getViewOrNull(R$id.divider);
        if (viewOrNull4 != null) {
            so.c.g(viewOrNull4);
        }
        View viewOrNull5 = helper.getViewOrNull(R$id.bg_gradient);
        if (viewOrNull5 != null) {
            so.c.g(viewOrNull5);
        }
        View viewOrNull6 = helper.getViewOrNull(R$id.item_root);
        if (viewOrNull6 != null) {
            viewOrNull6.setBackgroundColor(z2.a.getColor(g(), R$color.bg_01));
        }
    }
}
