package hx;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.R$mipmap;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SuggestEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
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
public final class d extends BaseItemProvider<SuggestEntity> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 3;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.fragment_search_suggest_staff_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, SuggestEntity item) {
        String avatarUrl;
        List<StaffType> staffTypes;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        ImageView imageView = (ImageView) helper.getView(R$id.ivCover);
        Staff staff = item.getStaff();
        if (staff == null || (avatarUrl = staff.getAvatarUrl()) == null) {
            avatarUrl = "";
        }
        companion.o(contextG, imageView, avatarUrl, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.movie_staff_default_avatar, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        int i11 = R$id.tvTitle;
        Staff staff2 = item.getStaff();
        helper.setText(i11, staff2 != null ? staff2.getName() : null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvDes);
        if (appCompatTextView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Staff staff3 = item.getStaff();
            if (staff3 != null && (staffTypes = staff3.getStaffTypes()) != null) {
                int i12 = 0;
                for (Object obj : staffTypes) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        g.u();
                    }
                    spannableStringBuilder.append((CharSequence) String.valueOf(((StaffType) obj).getName()));
                    if (i12 < staffTypes.size() - 1) {
                        spannableStringBuilder.append((CharSequence) " · ");
                    }
                    i12 = i13;
                }
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) "  ");
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder.toString());
            int i14 = R$drawable.search_suggest_staff;
            spannableStringBuilder2.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(appCompatTextView.getContext(), i14, 2) : new ImageSpan(appCompatTextView.getContext(), i14, 1), 0, 1, 34);
            appCompatTextView.setText(spannableStringBuilder2);
        }
        int i15 = R$id.tvWorks;
        Staff staff4 = item.getStaff();
        Integer subjectNum = staff4 != null ? staff4.getSubjectNum() : null;
        helper.setText(i15, subjectNum + " " + g().getString(R$string.search_works));
    }
}
