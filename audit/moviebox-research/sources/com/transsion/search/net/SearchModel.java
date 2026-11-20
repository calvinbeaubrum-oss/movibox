package com.transsion.search.net;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.search.bean.HotSubjectEntity;
import com.transsion.search.bean.JoinGroupEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.bean.SearchWorkEntity;
import io.reactivex.rxjava3.core.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SearchModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f57641b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f57642a = LazyKt__LazyJVMKt.b(new Function0<com.transsion.search.net.a>() { // from class: com.transsion.search.net.SearchModel$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String a() {
        return cp.a.f62775a.a();
    }

    public final j<BaseDto<HotSubjectEntity>> b() {
        return com.transsion.search.net.a.C0595a.a(d(), 1, 0, 2, null);
    }

    public final j<BaseDto<SearchSuggestEntity>> c(String keyword) {
        Intrinsics.g(keyword, "keyword");
        return com.transsion.search.net.a.C0595a.b(d(), keyword, 0, 0, 6, null);
    }

    public final com.transsion.search.net.a d() {
        return (com.transsion.search.net.a) this.f57642a.getValue();
    }

    public final j<BaseDto<JoinGroupEntity>> e(RequestJoinGroupEntity entity) {
        Intrinsics.g(entity, "entity");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("groupId", entity.getGroupId());
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jsonObject.toString();
        Intrinsics.f(string, "json.toString()");
        return d().b(a(), companion.create(string, MediaType.Companion.parse("application/json")));
    }

    public final j<BaseDto<SearchGroupEntity>> f(RequestSearchEntity entity) {
        Intrinsics.g(entity, "entity");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Integer.valueOf(entity.getPage()));
        jsonObject.addProperty("keyword", entity.getKeyword());
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jsonObject.toString();
        Intrinsics.f(string, "json.toString()");
        companion.create(string, MediaType.Companion.parse("application/json"));
        return d().a(a(), entity.getPage(), entity.getKeyword());
    }

    public final Object g(RequestSearchEntity requestSearchEntity, Continuation<? super BaseDto<SearchWorkEntity>> continuation) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Boxing.d(requestSearchEntity.getPage()));
        jsonObject.addProperty("perPage", Boxing.d(requestSearchEntity.getPerPage()));
        jsonObject.addProperty("keyword", requestSearchEntity.getKeyword());
        jsonObject.addProperty("subjectType", Boxing.d(requestSearchEntity.getSubjectType()));
        jsonObject.addProperty("resultMode", Boxing.d(1));
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jsonObject.toString();
        Intrinsics.f(string, "json.toString()");
        return d().e(a(), companion.create(string, MediaType.Companion.parse("application/json")), continuation);
    }
}
