package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.home.bean.FilterItems;
import com.transsion.home.bean.MovieBean;
import com.transsion.home.bean.RefreshBaseDto;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import st.a;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class MovieViewModel extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f52737g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f52738h = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f52739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f52740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f52741d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final rt.b f52742f;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f52739b = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<FilterItems>>>() { // from class: com.transsion.home.viewmodel.MovieViewModel$filterItemsLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<FilterItems>> invoke() {
                return new c0<>();
            }
        });
        this.f52740c = LazyKt__LazyJVMKt.b(new Function0<c0<RefreshBaseDto<MovieBean>>>() { // from class: com.transsion.home.viewmodel.MovieViewModel$movieListLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<RefreshBaseDto<MovieBean>> invoke() {
                return new c0<>();
            }
        });
        this.f52741d = LazyKt__LazyJVMKt.b(new Function0<c0<st.a>>() { // from class: com.transsion.home.viewmodel.MovieViewModel$selectFilterItemLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<a> invoke() {
                return new c0<>();
            }
        });
        this.f52742f = (rt.b) NetServiceGenerator.f49399d.a().i(rt.b.class);
    }

    public final void d(Integer num, String version) {
        Intrinsics.g(version, "version");
        j.d(u0.a(this), w0.b(), null, new MovieViewModel$getFilterItems$1(this, num, version, null), 2, null);
    }

    public final LiveData<BaseDto<FilterItems>> e() {
        return f();
    }

    public final c0<BaseDto<FilterItems>> f() {
        return (c0) this.f52739b.getValue();
    }

    public final void g(int i11, int i12, String str, Map<String, String> map, boolean z11) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Integer.valueOf(i11));
        jsonObject.addProperty("perPage", Integer.valueOf(i12));
        jsonObject.addProperty("channelId", str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringsKt__StringsKt.Q(entry.getValue(), ",", false, 2, null)) {
                    JsonArray jsonArray = new JsonArray();
                    Iterator it = StringsKt__StringsKt.E0(entry.getValue(), new String[]{","}, false, 0, 6, null).iterator();
                    while (it.hasNext()) {
                        jsonArray.add((String) it.next());
                    }
                    jsonObject.add(entry.getKey(), jsonArray);
                } else {
                    jsonObject.addProperty(entry.getKey(), entry.getValue());
                }
            }
        }
        j.d(u0.a(this), w0.b(), null, new MovieViewModel$getMovieList$2(jsonObject, this, z11, str, map, null), 2, null);
    }

    public final LiveData<RefreshBaseDto<MovieBean>> h() {
        return i();
    }

    public final c0<RefreshBaseDto<MovieBean>> i() {
        return (c0) this.f52740c.getValue();
    }

    public final c0<st.a> j() {
        return (c0) this.f52741d.getValue();
    }
}
