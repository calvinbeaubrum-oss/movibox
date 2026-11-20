package com.transsion.search.fragment.result;

import android.app.Application;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.gslb.Worker;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.model.PostEntity;
import com.transsion.search.bean.SearchList;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.VerticalRank;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
public final class SearchResultViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<SearchResultEntity> f57577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<SearchResultEntity> f57578d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<PostEntity> f57579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f57580g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<PostEntity> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            uo.b.a.j(uo.b.f78622a, AppLovinEventTypes.USER_EXECUTED_SEARCH, "SearchValuesFragment --> postRequestResource --> failed to post request resources " + str2, false, 4, null);
            SearchResultViewModel.this.h().n(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostEntity postEntity) {
            if (postEntity != null) {
                SearchResultViewModel.this.h().n(postEntity);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f57576b = LazyKt__LazyJVMKt.b(new Function0<com.transsion.search.net.a>() { // from class: com.transsion.search.fragment.result.SearchResultViewModel$service$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.search.net.a invoke() {
                return (com.transsion.search.net.a) NetServiceGenerator.f49399d.a().i(com.transsion.search.net.a.class);
            }
        });
        this.f57577c = new c0<>();
        this.f57578d = new c0<>();
        this.f57579f = new c0<>();
        this.f57580g = 1;
    }

    public static /* synthetic */ void m(SearchResultViewModel searchResultViewModel, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        searchResultViewModel.l(str, z11);
    }

    public static /* synthetic */ void o(SearchResultViewModel searchResultViewModel, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        searchResultViewModel.n(str, str2, z11);
    }

    public final List<ResultWrapData> g(List<SearchList> list) {
        ArrayList arrayList = new ArrayList();
        List<SearchList> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            for (SearchList searchList : list) {
                String title = searchList.getTitle();
                if (title != null && title.length() != 0) {
                    arrayList.add(new ResultWrapData(ResultType.TITLE, null, null, null, null, searchList.getTitle(), null, 94, null));
                }
                List<Subject> subjects = searchList.getSubjects();
                if (subjects != null) {
                    Iterator<T> it = subjects.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.SUBJECT, (Subject) it.next(), null, null, null, null, null, 124, null));
                    }
                }
                List<Staff> staffs = searchList.getStaffs();
                if (staffs != null) {
                    Iterator<T> it2 = staffs.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.STAFF, null, (Staff) it2.next(), null, null, null, null, 122, null));
                    }
                }
                List<Group> groups = searchList.getGroups();
                if (groups != null) {
                    Iterator<T> it3 = groups.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.GROUP, null, null, (Group) it3.next(), null, null, null, 118, null));
                    }
                }
                List<VerticalRank> verticalRanks = searchList.getVerticalRanks();
                if (verticalRanks != null) {
                    Iterator<T> it4 = verticalRanks.iterator();
                    while (it4.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.VERTICAL_RANK, null, null, null, (VerticalRank) it4.next(), null, null, Worker.WHAT_QUIT, null));
                    }
                }
                if (Intrinsics.b(searchList.getShowMore(), Boolean.TRUE)) {
                    arrayList.add(new ResultWrapData(ResultType.MORE, null, null, null, null, null, searchList.getMoreTabId(), 62, null));
                }
            }
        }
        return arrayList;
    }

    public final c0<PostEntity> h() {
        return this.f57579f;
    }

    public final c0<SearchResultEntity> i() {
        return this.f57578d;
    }

    public final c0<SearchResultEntity> j() {
        return this.f57577c;
    }

    public final com.transsion.search.net.a k() {
        return (com.transsion.search.net.a) this.f57576b.getValue();
    }

    public final void l(String keyword, boolean z11) {
        Intrinsics.g(keyword, "keyword");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CampaignEx.JSON_KEY_AD_Q, keyword);
        jsonObject.addProperty("before", Boolean.valueOf(z11));
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jsonObject.toString();
        Intrinsics.f(string, "jsonObject.toString()");
        k().f(cp.a.f62775a.a(), companion.create(string, MediaType.Companion.parse("application/json"))).A(q10.a.b()).subscribe(new a());
    }

    public final void n(String keyword, String str, boolean z11) {
        Intrinsics.g(keyword, "keyword");
        j.d(u0.a(this), null, null, new SearchResultViewModel$requestSearchResult$1(this, keyword, str, z11, null), 3, null);
    }

    public final void p(int i11) {
        this.f57580g = i11;
    }
}
