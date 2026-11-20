package com.transsion.search.fragment.suggest;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bx.j;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.report.h;
import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.viewmodel.SearchViewModel;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class SearchSuggestFragment extends BaseSearchMainFragment<j> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f57595h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f57596a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.search.fragment.suggest.b f57598c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57600f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57597b = LazyKt__LazyJVMKt.b(new Function0<SearchViewModel>() { // from class: com.transsion.search.fragment.suggest.SearchSuggestFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SearchViewModel invoke() {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return new SearchViewModel(applicationA);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f57599d = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final pp.a f57601g = new pp.a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchSuggestFragment a() {
            return new SearchSuggestFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a(SuggestEntity suggestEntity, int i11, String str, String str2);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements pp.a.b {
        public c() {
        }

        @Override // pp.a.b
        public int a() {
            List<SuggestEntity> listD;
            com.transsion.search.fragment.suggest.b bVar = SearchSuggestFragment.this.f57598c;
            if (bVar == null || (listD = bVar.D()) == null) {
                return 0;
            }
            return listD.size();
        }

        @Override // pp.a.b
        public void onItemViewVisible(boolean z11, int i11) {
            List<SuggestEntity> listD;
            com.transsion.search.fragment.suggest.b bVar = SearchSuggestFragment.this.f57598c;
            SearchSuggestFragment.this.t0((bVar == null || (listD = bVar.D()) == null) ? null : (SuggestEntity) CollectionsKt___CollectionsKt.h0(listD, i11), Integer.valueOf(i11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends DiffUtil.e<SuggestEntity> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(SuggestEntity oldItem, SuggestEntity newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return oldItem.hashCode() == newItem.hashCode();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(SuggestEntity oldItem, SuggestEntity newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return oldItem.hashCode() == newItem.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57603a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57603a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57603a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f57603a.invoke(obj);
        }
    }

    public static final void r0(SearchSuggestFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<SuggestEntity> listD;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        com.transsion.search.fragment.suggest.b bVar = this$0.f57598c;
        SuggestEntity suggestEntity = (bVar == null || (listD = bVar.D()) == null) ? null : listD.get(i11);
        this$0.s0(suggestEntity, i11);
        b bVar2 = this$0.f57596a;
        if (bVar2 != null) {
            String str = this$0.f57599d;
            String str2 = this$0.f57600f;
            if (str2 == null) {
                str2 = "";
            }
            bVar2.a(suggestEntity, i11, str, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initListener() {
        pp.a aVar = this.f57601g;
        j jVar = (j) getMViewBinding();
        aVar.n(jVar != null ? jVar.f14503b : null, new c());
        p0().q().j(this, new e(new Function1<String, Unit>() { // from class: com.transsion.search.fragment.suggest.SearchSuggestFragment.initListener.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                SearchSuggestEntity searchSuggestEntity = SearchSuggestFragment.this.p0().r().get(str);
                if (searchSuggestEntity != null) {
                    List<SuggestEntity> items = searchSuggestEntity.getItems();
                    if (items == null || !items.isEmpty()) {
                        SearchSuggestFragment searchSuggestFragment = SearchSuggestFragment.this;
                        String ops = searchSuggestEntity.getOps();
                        if (ops == null) {
                            ops = "";
                        }
                        searchSuggestFragment.f57600f = ops;
                        com.transsion.search.fragment.suggest.b bVar = SearchSuggestFragment.this.f57598c;
                        if (bVar != null) {
                            bVar.W0(SearchSuggestFragment.this.f57599d);
                        }
                        SearchSuggestFragment searchSuggestFragment2 = SearchSuggestFragment.this;
                        List<SuggestEntity> items2 = searchSuggestEntity.getItems();
                        com.transsion.search.fragment.suggest.b bVar2 = SearchSuggestFragment.this.f57598c;
                        if (searchSuggestFragment2.o0(items2, bVar2 != null ? bVar2.D() : null)) {
                            com.transsion.search.fragment.suggest.b bVar3 = SearchSuggestFragment.this.f57598c;
                            if (bVar3 != null) {
                                bVar3.notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        SearchSuggestFragment.this.f57601g.l();
                        com.transsion.search.fragment.suggest.b bVar4 = SearchSuggestFragment.this.f57598c;
                        if (bVar4 != null) {
                            bVar4.w0(searchSuggestEntity.getItems());
                        }
                        SearchSuggestFragment.this.f57601g.k();
                    }
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        Intrinsics.g(view, "view");
        j jVar = (j) getMViewBinding();
        if (jVar == null || (recyclerView = jVar.f14503b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        com.transsion.search.fragment.suggest.b bVar = new com.transsion.search.fragment.suggest.b();
        bVar.o0(new d());
        this.f57598c = bVar;
        recyclerView.setAdapter(bVar);
        com.transsion.search.fragment.suggest.b bVar2 = this.f57598c;
        if (bVar2 != null) {
            bVar2.B0(new f9.d() { // from class: com.transsion.search.fragment.suggest.a
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                    SearchSuggestFragment.r0(this.f57604a, baseQuickAdapter, view2, i11);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public h newLogViewConfig() {
        h hVar = new h("search_suggest", false, 2, null);
        hVar.k(true);
        return hVar;
    }

    public final boolean o0(List<SuggestEntity> list, List<SuggestEntity> list2) {
        SuggestEntity suggestEntity;
        Subject subject;
        int size = list2 != null ? list2.size() : 0;
        int size2 = list != null ? list.size() : 0;
        if (size2 <= 0 || size != size2) {
            return false;
        }
        if (list != null) {
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    g.u();
                }
                SuggestEntity suggestEntity2 = (SuggestEntity) obj;
                Integer type = suggestEntity2.getType();
                if (type != null && type.intValue() == 1) {
                    Subject subject2 = suggestEntity2.getSubject();
                    if (!Intrinsics.b(subject2 != null ? subject2.getSubjectId() : null, (list2 == null || (suggestEntity = list2.get(i11)) == null || (subject = suggestEntity.getSubject()) == null) ? null : subject.getSubjectId())) {
                        return false;
                    }
                }
                Integer type2 = suggestEntity2.getType();
                if (type2 == null || type2.intValue() != 1) {
                    int iHashCode = suggestEntity2.hashCode();
                    SuggestEntity suggestEntity3 = list2 != null ? list2.get(i11) : null;
                    if (iHashCode != (suggestEntity3 != null ? suggestEntity3.hashCode() : 0)) {
                        return false;
                    }
                }
                i11 = i12;
            }
        }
        return true;
    }

    public final SearchViewModel p0() {
        return (SearchViewModel) this.f57597b.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public j getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        j jVarC = j.c(inflater);
        Intrinsics.f(jVarC, "inflate(inflater)");
        return jVarC;
    }

    public final void s0(SuggestEntity suggestEntity, int i11) {
        String word;
        String subjectId;
        String title;
        Staff staff;
        String staffId;
        VerticalRank verticalRank;
        Subject subject;
        try {
            Result.Companion companion = Result.Companion;
            HashMap map = new HashMap();
            map.put("type", String.valueOf(suggestEntity != null ? suggestEntity.getType() : null));
            map.put(MBridgeConstans.KEY_WORD, this.f57599d);
            String str = this.f57600f;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            map.put("ops", str);
            if (suggestEntity == null || (word = suggestEntity.getWord()) == null) {
                word = "";
            }
            map.put(CampaignEx.JSON_KEY_TITLE, word);
            if (suggestEntity == null || (subject = suggestEntity.getSubject()) == null || (subjectId = subject.getSubjectId()) == null) {
                subjectId = "";
            }
            map.put("subject_id", subjectId);
            if (suggestEntity == null || (verticalRank = suggestEntity.getVerticalRank()) == null || (title = verticalRank.getTitle()) == null) {
                title = "";
            }
            map.put("word", title);
            if (suggestEntity != null && (staff = suggestEntity.getStaff()) != null && (staffId = staff.getStaffId()) != null) {
                str2 = staffId;
            }
            map.put("staff_id", str2);
            map.put("index", String.valueOf(i11));
            m.f51277a.m("search_suggest", "click", map);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void t0(SuggestEntity suggestEntity, Integer num) {
        String word;
        String subjectId;
        VerticalRank verticalRank;
        String title;
        Subject subject;
        try {
            Result.Companion companion = Result.Companion;
            HashMap map = new HashMap();
            map.put("type", String.valueOf(suggestEntity != null ? suggestEntity.getType() : null));
            map.put(MBridgeConstans.KEY_WORD, this.f57599d);
            String str = this.f57600f;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            map.put("ops", str);
            if (suggestEntity == null || (word = suggestEntity.getWord()) == null) {
                word = "";
            }
            map.put(CampaignEx.JSON_KEY_TITLE, word);
            if (suggestEntity == null || (subject = suggestEntity.getSubject()) == null || (subjectId = subject.getSubjectId()) == null) {
                subjectId = "";
            }
            map.put("subject_id", subjectId);
            if (suggestEntity != null && (verticalRank = suggestEntity.getVerticalRank()) != null && (title = verticalRank.getTitle()) != null) {
                str2 = title;
            }
            map.put("word", str2);
            map.put("index", String.valueOf(num));
            m.f51277a.t("search_suggest", "browse", map);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void u0(String keyWord) {
        Intrinsics.g(keyWord, "keyWord");
        this.f57599d = keyWord;
        p0().m(keyWord);
    }

    public final void v0(b listener) {
        Intrinsics.g(listener, "listener");
        this.f57596a = listener;
    }
}
