package com.transsion.moviedetail.viewmodel;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.bean.ForYouBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;
import uo.b;

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
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$fetchRec$1", f = "MovieDetailViewModel.kt", l = {188}, m = "invokeSuspend")
public final class MovieDetailViewModel$fetchRec$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isTablet;
    final /* synthetic */ int $page;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ Integer $subjectType;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailViewModel$fetchRec$1(String str, Integer num, int i11, boolean z11, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$fetchRec$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$subjectType = num;
        this.$page = i11;
        this.$isTablet = z11;
        this.this$0 = movieDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$fetchRec$1(this.$subjectId, this.$subjectType, this.$page, this.$isTablet, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MovieDetailViewModel$fetchRec$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00dd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<Subject> items;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                b.a.f(b.f78622a, "MovieDetailViewModel", "fetchRec,subjectId:" + this.$subjectId + ", subjectType:" + this.$subjectType + ",page: " + this.$page, false, 4, null);
                JsonObject jsonObject = new JsonObject();
                Integer num = this.$subjectType;
                int value = SubjectType.MUSIC.getValue();
                int i12 = 8;
                if (num == null || num.intValue() != value) {
                    Integer num2 = this.$subjectType;
                    int value2 = SubjectType.EDUCATION.getValue();
                    if (num2 == null || num2.intValue() != value2) {
                        if (!this.$isTablet) {
                            i12 = 6;
                        }
                    }
                }
                jsonObject.addProperty("subjectId", this.$subjectId);
                jsonObject.addProperty("perPage", Boxing.d(i12));
                jsonObject.addProperty("page", Boxing.d(this.$page));
                ip.b.a aVar = ip.b.f67591a;
                String string = jsonObject.toString();
                Intrinsics.f(string, "jsonObject.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA != null) {
                    vu.a aVarX = this.this$0.x();
                    String strA = cp.a.f62775a.a();
                    this.label = 1;
                    obj = aVarX.d(strA, requestBodyA, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    items = null;
                }
                this.this$0.f53856j.n(items);
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            BaseDto baseDto = (BaseDto) obj;
            if (baseDto == null) {
                items = null;
            } else {
                ForYouBean forYouBean = Intrinsics.b(baseDto.getCode(), "0") ? (ForYouBean) baseDto.getData() : null;
                if (forYouBean != null) {
                    items = forYouBean.getItems();
                } else {
                    items = null;
                }
            }
            this.this$0.f53856j.n(items);
        } catch (Exception unused) {
            this.this$0.f53856j.n(null);
        }
        return Unit.f68710a;
    }
}
