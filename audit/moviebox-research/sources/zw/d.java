package zw;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h0;
import com.blankj.utilcode.util.z;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.CornerTextView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SearchSubject;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tp.f;

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
public final class d extends BaseItemProvider<SearchSubject> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f82185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f82186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f82187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f82188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f82189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f82190k;

    public d(Context context) {
        Intrinsics.g(context, "context");
        int iA = f0.a(104.0f);
        this.f82185f = iA;
        int iA2 = f0.a(149.0f);
        this.f82186g = iA2;
        int iA3 = f0.a(48.0f);
        this.f82187h = iA3;
        int iE = f.f77260a.e(context);
        this.f82188i = iE;
        int i11 = (iE - iA3) / 3;
        this.f82189j = i11;
        this.f82190k = (int) (i11 * ((iA2 * 1.0f) / iA));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_works_layout_vertical;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, SearchSubject item) {
        String url;
        String thumbnail;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Context context = helper.itemView.getContext();
        ImageView ivAvatar = (ImageView) helper.itemView.findViewById(R$id.ivCover);
        ViewGroup.LayoutParams layoutParams = ivAvatar.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = this.f82190k;
        ((ViewGroup.MarginLayoutParams) bVar).width = this.f82189j;
        Cover cover = item.getCover();
        if (cover != null && (url = cover.getUrl()) != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Intrinsics.f(context, "context");
            Intrinsics.f(ivAvatar, "ivAvatar");
            int i11 = this.f82189j;
            int i12 = this.f82190k;
            Cover cover2 = item.getCover();
            if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                thumbnail = "";
            }
            companion.q(context, ivAvatar, url, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : i12, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        helper.setText(R$id.tvSubject, item.getTitle());
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvSubjectYear);
        if (appCompatTextView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "  ");
            String releaseDate = item.getReleaseDate();
            if (releaseDate != null && releaseDate.length() != 0) {
                Date dateK = h0.k(item.getReleaseDate(), "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateK);
                spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            }
            String[] strings = z.a(item.getGenre(), ",");
            if (strings != null) {
                Intrinsics.f(strings, "strings");
                for (String str : strings) {
                    spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) str);
                }
            }
            String countryName = item.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) item.getCountryName());
            }
            int iA = com.transsion.moviedetailapi.a.a(item.getSubjectType());
            spannableStringBuilder.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, iA, 2) : new ImageSpan(context, iA, 1), 0, 1, 34);
            appCompatTextView.setText(spannableStringBuilder);
        }
        Integer seNum = item.getSeNum();
        int iIntValue = seNum != null ? seNum.intValue() : 0;
        helper.setGone(R$id.tvSeasons, iIntValue < 2);
        helper.setText(R$id.tvSeasons, context.getString(R$string.seasons, String.valueOf(iIntValue)));
        ((CornerTextView) helper.getView(R$id.ivSearchCorner)).setTextWithType(item.getCorner(), item.getSubjectType());
    }
}
