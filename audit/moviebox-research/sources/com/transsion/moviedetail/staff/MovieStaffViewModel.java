package com.transsion.moviedetail.staff;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.bean.MovieStaffSubjectList;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.postdetail.bean.Pager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MovieStaffViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<Staff> f53747a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<List<MovieStaffSubjectList>> f53748b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<MovieStaffSubjectList> f53749c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Integer> f53750d = new c0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<MovieStaffList> f53751f = new c0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f53752g = LazyKt__LazyJVMKt.b(new Function0<com.transsion.moviedetail.staff.a>() { // from class: com.transsion.moviedetail.staff.MovieStaffViewModel$mMovieStaffApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f53753h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f53754i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h10.b f53755j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<MovieStaffList> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            MovieStaffViewModel.this.f53751f.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MovieStaffList movieStaffList) {
            super.c(movieStaffList);
            MovieStaffViewModel.this.f53751f.q(movieStaffList);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<Staff> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            MovieStaffViewModel.this.f53747a.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(Staff staff) {
            super.c(staff);
            MovieStaffViewModel.this.f53747a.q(staff);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<MovieStaffSubjectList> {
        public c() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            h10.b bVar;
            MovieStaffViewModel.this.f53749c.q(null);
            h10.b bVar2 = MovieStaffViewModel.this.f53755j;
            if (bVar2 == null || bVar2.isDisposed() || (bVar = MovieStaffViewModel.this.f53755j) == null) {
                return;
            }
            bVar.dispose();
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MovieStaffSubjectList movieStaffSubjectList) {
            h10.b bVar;
            Pager pager;
            Boolean hasMore;
            super.c(movieStaffSubjectList);
            if (movieStaffSubjectList != null && (pager = movieStaffSubjectList.getPager()) != null && (hasMore = pager.getHasMore()) != null) {
                MovieStaffViewModel.this.f53754i = hasMore.booleanValue();
            }
            MovieStaffViewModel.this.f53749c.q(movieStaffSubjectList);
            if (movieStaffSubjectList != null) {
                MovieStaffViewModel movieStaffViewModel = MovieStaffViewModel.this;
                List arrayList = (List) movieStaffViewModel.f53748b.f();
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(movieStaffSubjectList);
                movieStaffViewModel.f53748b.q(arrayList);
            }
            MovieStaffViewModel.this.f53753h++;
            h10.b bVar2 = MovieStaffViewModel.this.f53755j;
            if (bVar2 == null || bVar2.isDisposed() || (bVar = MovieStaffViewModel.this.f53755j) == null) {
                return;
            }
            bVar.dispose();
        }

        @Override // zo.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            super.onSubscribe(d11);
            MovieStaffViewModel.this.f53755j = d11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JsonObject f53759a;

        public d(JsonObject jsonObject) {
            this.f53759a = jsonObject;
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(JsonObject it) {
            Intrinsics.g(it, "it");
            RequestBody.Companion companion = RequestBody.Companion;
            String string = this.f53759a.toString();
            Intrinsics.f(string, "json.toString()");
            return companion.create(string, MediaType.Companion.parse("application/json"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e<T, R> implements k10.h {
        public e() {
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<String>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return com.transsion.moviedetail.staff.a.C0576a.d(MovieStaffViewModel.this.q(), it, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends zo.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f53762f;

        public f(int i11) {
            this.f53762f = i11;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            MovieStaffViewModel.this.f53750d.q(-1);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            MovieStaffViewModel.this.f53750d.q(Integer.valueOf(this.f53762f));
        }
    }

    public final void m() {
        this.f53749c.q(null);
    }

    public final void n(String str) {
        if (str == null) {
            return;
        }
        com.transsion.moviedetail.staff.a.C0576a.b(q(), str, null, 2, null).e(zo.d.f82109a.c()).subscribe(new a());
    }

    public final void o(String str) {
        if (str == null) {
            return;
        }
        com.transsion.moviedetail.staff.a.C0576a.a(q(), str, null, 2, null).e(zo.d.f82109a.c()).subscribe(new b());
    }

    public final void p(String str, int i11) {
        int i12;
        int i13;
        if (str == null || !this.f53754i) {
            return;
        }
        h10.b bVar = this.f53755j;
        if (bVar == null || bVar.isDisposed()) {
            int i14 = this.f53753h;
            if (i14 <= 1) {
                i12 = i11;
                i13 = 1;
            } else {
                int i15 = i11 + 1 + ((i14 - 2) * 60);
                i12 = i15 + 59;
                i13 = i15;
            }
            com.transsion.moviedetail.staff.a.C0576a.c(q(), str, i13, i12, 1, null, 16, null).e(zo.d.f82109a.c()).subscribe(new c());
        }
    }

    public final com.transsion.moviedetail.staff.a q() {
        return (com.transsion.moviedetail.staff.a) this.f53752g.getValue();
    }

    public final LiveData<MovieStaffList> r() {
        return this.f53751f;
    }

    public final LiveData<Staff> s() {
        return this.f53747a;
    }

    public final LiveData<List<MovieStaffSubjectList>> t() {
        return this.f53748b;
    }

    public final LiveData<MovieStaffSubjectList> u() {
        return this.f53749c;
    }

    public final LiveData<Integer> v() {
        return this.f53750d;
    }

    public final void w(String str, int i11) {
        if (str == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("staffId", str);
        jsonObject.addProperty("action", Integer.valueOf(i11));
        io.reactivex.rxjava3.core.j.p(jsonObject).q(new d(jsonObject)).k(new e()).e(zo.d.f82109a.c()).subscribe(new f(i11));
    }
}
