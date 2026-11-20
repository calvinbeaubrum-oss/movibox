package com.transsion.home.viewmodel;

import androidx.lifecycle.c0;
import com.google.gson.JsonObject;
import com.transsion.home.bean.MovieBean;
import com.transsion.home.bean.MovieItem;
import com.transsion.home.bean.RefreshBaseDto;
import ip.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.viewmodel.MovieViewModel$getMovieList$2", f = "MovieViewModel.kt", l = {75}, m = "invokeSuspend")
public final class MovieViewModel$getMovieList$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelId;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ JsonObject $jsonObject;
    final /* synthetic */ Map<String, String> $selectItems;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ MovieViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieViewModel$getMovieList$2(JsonObject jsonObject, MovieViewModel movieViewModel, boolean z11, String str, Map<String, String> map, Continuation<? super MovieViewModel$getMovieList$2> continuation) {
        super(2, continuation);
        this.$jsonObject = jsonObject;
        this.this$0 = movieViewModel;
        this.$isRefresh = z11;
        this.$channelId = str;
        this.$selectItems = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieViewModel$getMovieList$2(this.$jsonObject, this.this$0, this.$isRefresh, this.$channelId, this.$selectItems, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MovieViewModel$getMovieList$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MovieViewModel movieViewModel;
        String str;
        boolean z11;
        Map<String, String> map;
        List<MovieItem> items;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                b.a aVar = b.f67591a;
                String string = this.$jsonObject.toString();
                Intrinsics.f(string, "jsonObject.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA != null) {
                    movieViewModel = this.this$0;
                    boolean z12 = this.$isRefresh;
                    str = this.$channelId;
                    Map<String, String> map2 = this.$selectItems;
                    rt.b bVar = movieViewModel.f52742f;
                    String strA = cp.a.f62775a.a();
                    this.L$0 = movieViewModel;
                    this.L$1 = str;
                    this.L$2 = map2;
                    this.Z$0 = z12;
                    this.label = 1;
                    obj = bVar.a(strA, requestBodyA, this);
                    if (obj == objE) {
                        return objE;
                    }
                    z11 = z12;
                    map = map2;
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z11 = this.Z$0;
            map = (Map) this.L$2;
            str = (String) this.L$1;
            movieViewModel = (MovieViewModel) this.L$0;
            ResultKt.b(obj);
            RefreshBaseDto<MovieBean> refreshBaseDto = (RefreshBaseDto) obj;
            refreshBaseDto.setRefresh(z11);
            MovieBean data = refreshBaseDto.getData();
            if (data != null && (items = data.getItems()) != null && items.size() > 1) {
                MovieItem movieItem = items.get(items.size() - 1);
                movieItem.setChannelId(str);
                movieItem.setSelectItems(map);
            }
            movieViewModel.i().n(refreshBaseDto);
        } catch (Exception e11) {
            e11.printStackTrace();
            c0<RefreshBaseDto<MovieBean>> c0VarI = this.this$0.i();
            String message = e11.getMessage();
            String str2 = message == null ? "" : message;
            String message2 = e11.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            c0VarI.n(new RefreshBaseDto<>(str2, "-1", null, message2, this.$isRefresh));
        }
        return Unit.f68710a;
    }
}
