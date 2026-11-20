package com.transsion.search.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.report.m;
import com.transsion.search.activity.SearchManagerActivity;
import com.transsion.search.bean.HotSubjectEntity;
import com.transsion.search.bean.JoinGroupEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.net.RequestJoinGroupEntity;
import com.transsion.search.net.RequestSearchEntity;
import com.transsion.search.net.SearchModel;
import com.transsion.search.widget.BoundaryLinkedHashMap;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

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
public final class SearchViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<SearchGroupEntity> f57686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<SearchWorkEntity> f57687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<SearchWorkEntity> f57688d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<String> f57689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<SearchGroupEntity> f57690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<HotSubjectEntity> f57691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f57692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h10.b f57693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BoundaryLinkedHashMap f57694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BoundaryLinkedHashMap f57695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0<String> f57696m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<HotSubjectEntity> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            SearchViewModel.this.i().n(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(HotSubjectEntity hotSubjectEntity) {
            SearchViewModel.this.i().n(hotSubjectEntity);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<SearchSuggestEntity> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f57699f;

        public b(String str) {
            this.f57699f = str;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            SearchViewModel.this.q().n(this.f57699f);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(SearchSuggestEntity searchSuggestEntity) {
            String keyword;
            if (searchSuggestEntity != null) {
                SearchViewModel searchViewModel = SearchViewModel.this;
                String str = this.f57699f;
                searchViewModel.r().put(searchSuggestEntity.getKeyword(), searchSuggestEntity);
                searchViewModel.q().n(str);
                List<SuggestEntity> items = searchSuggestEntity.getItems();
                if (items == null || !items.isEmpty() || (keyword = searchSuggestEntity.getKeyword()) == null || keyword.length() < 2 || searchViewModel.p().containsKey(searchSuggestEntity.getKeyword())) {
                    return;
                }
                searchViewModel.p().put(searchSuggestEntity.getKeyword(), null);
                SearchManagerActivity.f57432m.a("no associative word results when the user enters query longer than 2 characters");
                HashMap map = new HashMap();
                String keyword2 = searchSuggestEntity.getKeyword();
                if (keyword2 == null) {
                    keyword2 = "";
                }
                map.put(MBridgeConstans.KEY_WORD, keyword2);
                String ops = searchSuggestEntity.getOps();
                map.put("ops", ops != null ? ops : "");
                m.f51277a.t("search_suggest", "browse", map);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<JoinGroupEntity> {
        public c() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            if (str2 != null) {
                h.f50034a.l(str2);
            }
            SearchViewModel.this.f57689f.n("");
        }

        @Override // zo.a
        public void d(BaseDto<JoinGroupEntity> baseDto) {
            Intrinsics.g(baseDto, "baseDto");
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(JoinGroupEntity joinGroupEntity) {
            if (TextUtils.isEmpty(joinGroupEntity != null ? joinGroupEntity.getM() : null)) {
                SearchViewModel.this.f57689f.n("succeed");
            } else {
                SearchViewModel.this.f57689f.n(joinGroupEntity != null ? joinGroupEntity.getM() : null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends zo.a<SearchGroupEntity> {
        public d() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            if (str2 != null) {
                h.f50034a.l(str2);
            }
            SearchViewModel.this.f57686b.n(null);
        }

        @Override // zo.a
        public void d(BaseDto<SearchGroupEntity> baseDto) {
            Intrinsics.g(baseDto, "baseDto");
            SearchViewModel.this.f57686b.n(baseDto.getData());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f57686b = new c0<>();
        this.f57687c = new c0<>();
        this.f57688d = new c0<>();
        this.f57689f = new c0<>();
        this.f57690g = new c0<>();
        this.f57691h = new c0<>();
        this.f57692i = LazyKt__LazyJVMKt.b(new Function0<SearchModel>() { // from class: com.transsion.search.viewmodel.SearchViewModel$searchApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SearchModel invoke() {
                return new SearchModel();
            }
        });
        this.f57694k = new BoundaryLinkedHashMap();
        this.f57695l = new BoundaryLinkedHashMap();
        this.f57696m = new c0<>();
    }

    public final void h() {
        k().b().A(q10.a.b()).subscribe(new a());
    }

    public final c0<HotSubjectEntity> i() {
        return this.f57691h;
    }

    public final c0<String> j() {
        return this.f57689f;
    }

    public final SearchModel k() {
        return (SearchModel) this.f57692i.getValue();
    }

    public final c0<SearchGroupEntity> l() {
        return this.f57686b;
    }

    public final void m(String keyword) {
        Intrinsics.g(keyword, "keyword");
        k().c(keyword).A(q10.a.b()).subscribe(new b(keyword));
    }

    public final c0<SearchWorkEntity> n() {
        return this.f57687c;
    }

    public final c0<SearchWorkEntity> o() {
        return this.f57688d;
    }

    @Override // androidx.lifecycle.t0
    public void onCleared() {
        h10.b bVar;
        super.onCleared();
        h10.b bVar2 = this.f57693j;
        if (bVar2 == null || bVar2.isDisposed() || (bVar = this.f57693j) == null) {
            return;
        }
        bVar.dispose();
    }

    public final BoundaryLinkedHashMap p() {
        return this.f57695l;
    }

    public final c0<String> q() {
        return this.f57696m;
    }

    public final BoundaryLinkedHashMap r() {
        return this.f57694k;
    }

    public final void s(String groupId) {
        Intrinsics.g(groupId, "groupId");
        k().e(new RequestJoinGroupEntity(groupId)).A(q10.a.b()).subscribe(new c());
    }

    public final void t(int i11, int i12, String keyword) {
        Intrinsics.g(keyword, "keyword");
        k().f(new RequestSearchEntity(i11, i12, keyword)).A(q10.a.b()).subscribe(new d());
    }

    public final void u(int i11, int i12, String keyword) {
        Intrinsics.g(keyword, "keyword");
        j.d(u0.a(this), null, null, new SearchViewModel$searchWork$1(this, new RequestSearchEntity(i11, i12, keyword), null), 3, null);
    }

    public final void v(int i11, int i12, String keyword, int i13) {
        Intrinsics.g(keyword, "keyword");
        j.d(u0.a(this), null, null, new SearchViewModel$searchWorkV2$1(this, new RequestSearchEntity(i11, i12, keyword, i13), null), 3, null);
    }
}
