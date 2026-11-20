package com.transsion.home.adapter.suboperate.provider;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.home.adapter.trending.provider.SubjectSingleImgItemProvider;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.music.data.MusicLikedFragmentViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public class SubFeedsSingleImageProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f52124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SubjectSingleImgItemProvider f52125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f52126i = LazyKt__LazyJVMKt.b(new Function0<MusicLikedFragmentViewModel>() { // from class: com.transsion.home.adapter.suboperate.provider.SubFeedsSingleImageProvider$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MusicLikedFragmentViewModel invoke() {
            return new MusicLikedFragmentViewModel();
        }
    });

    public SubFeedsSingleImageProvider(int i11, boolean z11) {
        this.f52123f = i11;
        this.f52124g = z11;
        this.f52125h = new SubjectSingleImgItemProvider(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i11, Subject subject, boolean z11) {
        HashMap map = new HashMap();
        map.put("event_type", z11 ? "browse_feeds_single_item" : "click_feeds_single_item");
        map.put("sequence", String.valueOf(i11));
        map.put("item_type", "rec");
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        String subjectId = subject.getSubjectId();
        map.put("subject_id", subjectId != null ? subjectId : "");
        map.put("builtin", subject.getBuiltIn() ? "1" : "0");
        map.put("tabId", String.valueOf(this.f52123f));
        StringBuilder sb2 = new StringBuilder();
        List<ExplainBean> explains = subject.getExplains();
        if (explains != null) {
            Iterator<T> it = explains.iterator();
            while (it.hasNext()) {
                sb2.append(((ExplainBean) it.next()).getType());
                sb2.append(",");
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "explains.toString()");
        map.put("rec_explain_type", StringsKt__StringsKt.b1(string, ','));
        ot.b.c(subject, map);
        if (z11) {
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52123f), map);
        } else {
            com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52123f), map);
        }
    }

    public static final void y(OperateItem item, SubFeedsSingleImageProvider this$0, View view) {
        List<OperateItem> listD;
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject != null) {
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                HomeUtilsKt.b(feedsSubject, "opt_sub_feeds");
                BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = this$0.c();
                this$0.B((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, false);
            } else {
                Context contextG = this$0.g();
                AppCompatActivity appCompatActivity = contextG instanceof AppCompatActivity ? (AppCompatActivity) contextG : null;
                if (appCompatActivity != null) {
                    kotlinx.coroutines.j.d(androidx.lifecycle.v.a(appCompatActivity), null, null, new SubFeedsSingleImageProvider$convert$2$1$1$1(this$0, item, feedsSubject, null), 3, null);
                }
            }
        }
    }

    public static final void z(OperateItem item, SubFeedsSingleImageProvider this$0, View view) {
        Subject feedsSubject;
        List<OperateItem> listD;
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (feedsSubject = item.getFeedsSubject()) == null) {
            return;
        }
        HomeUtilsKt.c(feedsSubject, SubTabFragment.f52541r.a(this$0.f52123f), this$0.g(), "opt_sub_feeds");
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = this$0.c();
        this$0.B((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, false);
    }

    public final MusicLikedFragmentViewModel A() {
        return (MusicLikedFragmentViewModel) this.f52126i.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.SINGLE_SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return this.f52125h.i();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        List<OperateItem> listD;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject != null) {
            this.f52125h.a(helper, item);
            BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
            B((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, true);
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubFeedsSingleImageProvider.y(item, this, view);
            }
        });
        View viewB = this.f52125h.B();
        if (viewB != null) {
            viewB.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubFeedsSingleImageProvider.z(item, this, view);
                }
            });
        }
    }
}
