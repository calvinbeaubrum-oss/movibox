package com.transsion.shorttv.favorite;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.IShortTvFavoriteStateDao;
import com.transsion.baselib.db.video.ShortTvFavoriteState;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;

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
public interface IShortTvFavoriteProvider {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class DefaultImpls {
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static Object a(IShortTvFavoriteProvider iShortTvFavoriteProvider, String str, Continuation<? super ShortTVFavInfo> continuation) throws Throwable {
            IShortTvFavoriteProvider$getLocalFavoriteState$1 iShortTvFavoriteProvider$getLocalFavoriteState$1;
            if (continuation instanceof IShortTvFavoriteProvider$getLocalFavoriteState$1) {
                iShortTvFavoriteProvider$getLocalFavoriteState$1 = (IShortTvFavoriteProvider$getLocalFavoriteState$1) continuation;
                int i11 = iShortTvFavoriteProvider$getLocalFavoriteState$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    iShortTvFavoriteProvider$getLocalFavoriteState$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    iShortTvFavoriteProvider$getLocalFavoriteState$1 = new IShortTvFavoriteProvider$getLocalFavoriteState$1(continuation);
                }
            } else {
                iShortTvFavoriteProvider$getLocalFavoriteState$1 = new IShortTvFavoriteProvider$getLocalFavoriteState$1(continuation);
            }
            Object objB = iShortTvFavoriteProvider$getLocalFavoriteState$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = iShortTvFavoriteProvider$getLocalFavoriteState$1.label;
            if (i12 == 0) {
                ResultKt.b(objB);
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                IShortTvFavoriteStateDao iShortTvFavoriteStateDaoL0 = v0Var.b(applicationA).L0();
                iShortTvFavoriteProvider$getLocalFavoriteState$1.label = 1;
                objB = iShortTvFavoriteStateDaoL0.b(str, iShortTvFavoriteProvider$getLocalFavoriteState$1);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objB);
            }
            ShortTvFavoriteState shortTvFavoriteState = (ShortTvFavoriteState) objB;
            if (shortTvFavoriteState != null) {
                return new ShortTVFavInfo(shortTvFavoriteState.getFavoriteNum(), shortTvFavoriteState.getHasFavorite(), shortTvFavoriteState.getFavoriteTime());
            }
            return null;
        }

        public static void b(IShortTvFavoriteProvider iShortTvFavoriteProvider, String subjectId, boolean z11, String favoriteNum) {
            Intrinsics.g(subjectId, "subjectId");
            Intrinsics.g(favoriteNum, "favoriteNum");
            j00.c cVar = new j00.c(subjectId, !z11, favoriteNum);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = j00.c.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, cVar, 0L);
        }

        public static Object c(IShortTvFavoriteProvider iShortTvFavoriteProvider, String str, ShortTVFavInfo shortTVFavInfo, Continuation<? super Unit> continuation) {
            ShortTvFavoriteState shortTvFavoriteState = new ShortTvFavoriteState();
            shortTvFavoriteState.setFavoriteNum(shortTVFavInfo.getFavoriteNum());
            shortTvFavoriteState.setHasFavorite(shortTVFavInfo.getHasFavorite());
            shortTvFavoriteState.setFavoriteTime(shortTVFavInfo.getFavoriteTime());
            shortTvFavoriteState.setSubjectId(str);
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            Object objD = v0Var.b(applicationA).L0().d(shortTvFavoriteState, continuation);
            return objD == kotlin.coroutines.intrinsics.a.e() ? objD : Unit.f68710a;
        }
    }

    Object a(String str, ShortTVFavInfo shortTVFavInfo, Continuation<? super Unit> continuation);

    void b(String str, boolean z11, String str2);

    Object c(JSONObject jSONObject, Continuation<? super BaseDto<String>> continuation);

    Object d(String str, Continuation<? super ShortTVFavInfo> continuation);
}
