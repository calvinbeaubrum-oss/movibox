package gx;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.R$mipmap;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
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
public final class d extends BaseItemProvider<ResultWrapData> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return ResultType.STAFF.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.provider_result_staff;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, ResultWrapData item) {
        String avatarUrl;
        String description;
        List<StaffType> staffTypes;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        ImageView imageView = (ImageView) helper.getView(R$id.search_result_provider_staff_cover);
        Staff staff = item.getStaff();
        if (staff == null || (avatarUrl = staff.getAvatarUrl()) == null) {
            avatarUrl = "";
        }
        companion.o(contextG, imageView, avatarUrl, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.movie_staff_default_avatar, (32704 & 16) != 0 ? companion.d() : f0.a(50.0f), (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        int i11 = R$id.search_result_provider_staff_title;
        Staff staff2 = item.getStaff();
        helper.setText(i11, staff2 != null ? staff2.getName() : null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Staff staff3 = item.getStaff();
        if (staff3 != null && (staffTypes = staff3.getStaffTypes()) != null) {
            int i12 = 0;
            for (Object obj : staffTypes) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                spannableStringBuilder.append((CharSequence) String.valueOf(((StaffType) obj).getName()));
                if (i12 < staffTypes.size() - 1) {
                    spannableStringBuilder.append((CharSequence) " · ");
                }
                i12 = i13;
            }
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        Staff staff4 = item.getStaff();
        Integer subjectNum = staff4 != null ? staff4.getSubjectNum() : null;
        spannableStringBuilder.append((CharSequence) (subjectNum + " " + g().getString(R$string.search_works)));
        spannableStringBuilder.setSpan(xw.f.b(g()), length, length + 1, 34);
        helper.setText(R$id.search_result_provider_staff_brief, spannableStringBuilder);
        Staff staff5 = item.getStaff();
        if (staff5 == null || (description = staff5.getDescription()) == null || description.length() <= 0) {
            helper.setGone(R$id.search_result_provider_staff_des, true);
            return;
        }
        helper.setVisible(R$id.search_result_provider_staff_des, true);
        int i14 = R$id.search_result_provider_staff_des;
        Staff staff6 = item.getStaff();
        helper.setText(i14, staff6 != null ? staff6.getDescription() : null);
    }
}
