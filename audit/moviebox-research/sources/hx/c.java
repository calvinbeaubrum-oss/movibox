package hx;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.h0;
import com.blankj.utilcode.util.z;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SuggestEntity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class c extends BaseItemProvider<SuggestEntity> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.fragment_search_suggest_movie_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, SuggestEntity item) {
        String strV0;
        Integer seNum;
        Cover cover;
        String url;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        ImageView imageView = (ImageView) helper.getView(R$id.ivCover);
        Subject subject = item.getSubject();
        companion.r(contextG, imageView, (subject == null || (cover = subject.getCover()) == null || (url = cover.getUrl()) == null) ? "" : url, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        int i11 = R$id.tvTitle;
        com.transsion.search.fragment.suggest.b.a aVar = com.transsion.search.fragment.suggest.b.J;
        BaseProviderMultiAdapter<SuggestEntity> baseProviderMultiAdapterC = c();
        com.transsion.search.fragment.suggest.b bVar = baseProviderMultiAdapterC instanceof com.transsion.search.fragment.suggest.b ? (com.transsion.search.fragment.suggest.b) baseProviderMultiAdapterC : null;
        if (bVar == null || (strV0 = bVar.V0()) == null) {
            strV0 = "";
        }
        Subject subject2 = item.getSubject();
        helper.setText(i11, aVar.a(strV0, subject2 != null ? subject2.getTitle() : null));
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvDes);
        if (appCompatTextView != null) {
            Subject subject3 = item.getSubject();
            Date dateK = h0.k(subject3 != null ? subject3.getReleaseDate() : null, "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateK);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            Subject subject4 = item.getSubject();
            String[] strings = z.a(subject4 != null ? subject4.getGenre() : null, ",");
            if (strings != null) {
                Intrinsics.f(strings, "strings");
                for (String str : strings) {
                    spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str);
                }
            }
            Subject subject5 = item.getSubject();
            if (!TextUtils.isEmpty(subject5 != null ? subject5.getCountryName() : null)) {
                SpannableStringBuilder spannableStringBuilderAppend = spannableStringBuilder.append((CharSequence) " · ");
                Subject subject6 = item.getSubject();
                spannableStringBuilderAppend.append((CharSequence) (subject6 != null ? subject6.getCountryName() : null));
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) "  ");
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder.toString());
            Subject subject7 = item.getSubject();
            int iA = com.transsion.moviedetailapi.a.a(subject7 != null ? subject7.getSubjectType() : null);
            spannableStringBuilder2.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(appCompatTextView.getContext(), iA, 2) : new ImageSpan(appCompatTextView.getContext(), iA, 1), 0, 1, 34);
            appCompatTextView.setText(spannableStringBuilder2);
        }
        int i12 = R$id.tvScore;
        Subject subject8 = item.getSubject();
        helper.setText(i12, String.valueOf(subject8 != null ? subject8.getImdbRate() : null));
        Subject subject9 = item.getSubject();
        int iIntValue = (subject9 == null || (seNum = subject9.getSeNum()) == null) ? 0 : seNum.intValue();
        helper.setGone(R$id.tvSeasons, iIntValue <= 1);
        String string = g().getString(R$string.seasons, String.valueOf(iIntValue));
        Intrinsics.f(string, "context.getString(R.stri…easons, seNum.toString())");
        helper.setText(R$id.tvSeasons, v(string));
    }

    public final String v(String input) {
        Intrinsics.g(input, "input");
        List listE0 = StringsKt__StringsKt.E0(input, new String[]{" "}, false, 0, 6, null);
        if (listE0.size() != 2) {
            return "";
        }
        String lowerCase = (listE0.get(1) + " " + listE0.get(0)).toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
