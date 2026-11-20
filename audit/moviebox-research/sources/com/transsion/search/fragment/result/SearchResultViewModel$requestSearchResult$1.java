package com.transsion.search.fragment.result;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.net.RequestSearchResultEntity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.search.fragment.result.SearchResultViewModel$requestSearchResult$1", f = "SearchResultViewModel.kt", l = {56}, m = "invokeSuspend")
public final class SearchResultViewModel$requestSearchResult$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $tabId;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ SearchResultViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultViewModel$requestSearchResult$1(SearchResultViewModel searchResultViewModel, String str, String str2, boolean z11, Continuation<? super SearchResultViewModel$requestSearchResult$1> continuation) {
        super(2, continuation);
        this.this$0 = searchResultViewModel;
        this.$keyword = str;
        this.$tabId = str2;
        this.$isLoadMore = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchResultViewModel$requestSearchResult$1 searchResultViewModel$requestSearchResult$1 = new SearchResultViewModel$requestSearchResult$1(this.this$0, this.$keyword, this.$tabId, this.$isLoadMore, continuation);
        searchResultViewModel$requestSearchResult$1.L$0 = obj;
        return searchResultViewModel$requestSearchResult$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SearchResultViewModel$requestSearchResult$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        SearchResultViewModel searchResultViewModel;
        boolean z11;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                RequestSearchResultEntity requestSearchResultEntity = new RequestSearchResultEntity(this.this$0.f57580g, 10, this.$keyword);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("page", Boxing.d(requestSearchResultEntity.getPage()));
                jsonObject.addProperty("perPage", Boxing.d(requestSearchResultEntity.getPerPage()));
                jsonObject.addProperty("keyword", requestSearchResultEntity.getKeyword());
                String str = this.$tabId;
                if (str != null && str.length() != 0) {
                    jsonObject.addProperty("tabId", this.$tabId);
                }
                RequestBody.Companion companion = RequestBody.Companion;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyCreate = companion.create(string, MediaType.Companion.parse("application/json"));
                searchResultViewModel = this.this$0;
                boolean z12 = this.$isLoadMore;
                Result.Companion companion2 = Result.Companion;
                com.transsion.search.net.a aVarK = searchResultViewModel.k();
                String strG = CacheIpPool.f49384a.g();
                this.L$0 = searchResultViewModel;
                this.Z$0 = z12;
                this.label = 1;
                obj = aVarK.c(strG, requestBodyCreate, this);
                if (obj == objE) {
                    return objE;
                }
                z11 = z12;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z11 = this.Z$0;
                searchResultViewModel = (SearchResultViewModel) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            SearchResultEntity searchResultEntity = (SearchResultEntity) baseDto.getData();
            if (searchResultEntity != null) {
                SearchResultEntity searchResultEntity2 = (SearchResultEntity) baseDto.getData();
                searchResultEntity.setConvertData(searchResultViewModel.g(searchResultEntity2 != null ? searchResultEntity2.getResults() : null));
            }
            if (z11) {
                searchResultViewModel.i().n(baseDto.getData());
            } else {
                searchResultViewModel.j().n(baseDto.getData());
            }
            int i12 = searchResultViewModel.f57580g;
            searchResultViewModel.f57580g = i12 + 1;
            objM163constructorimpl = Result.m163constructorimpl(Boxing.d(i12));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        SearchResultViewModel searchResultViewModel2 = this.this$0;
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            searchResultViewModel2.j().n(null);
            uo.b.a.j(uo.b.f78622a, "SearchResultViewModel", "requestSearchResult error: " + thM166exceptionOrNullimpl.getMessage(), false, 4, null);
        }
        return Unit.f68710a;
    }
}
