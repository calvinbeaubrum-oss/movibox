package com.transsion.postdetail.ui.fragment.preload;

import androidx.lifecycle.c0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.postdetail.shorttv.config.Constants;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import lu.b;
import xv.d;

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
public final class ShortTvVideoImmersiveDataLoader extends b<ShortTVRespData> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImmVideoRequestEntity f55910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f55911g;

    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvVideoImmersiveDataLoader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ShortTvVideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f55910f = immVideoRequestEntity;
        this.f55911g = LazyKt__LazyJVMKt.b(new Function0<d>() { // from class: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$service$2
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return (d) NetServiceGenerator.f49399d.a().i(d.class);
            }
        });
    }

    public /* synthetic */ ShortTvVideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : immVideoRequestEntity);
    }

    @Override // lu.b
    public void h(c0<ShortTVRespData> c0Var) {
        j(j.d(l0.a(w0.b()), null, null, new ShortTvVideoImmersiveDataLoader$loadDataFromService$1(this, null), 3, null));
    }

    public final ImmVideoRequestEntity m() {
        return this.f55910f;
    }

    public final d n() {
        return (d) this.f55911g.getValue();
    }

    public final Object o(ShortTVRespData shortTVRespData, Continuation<? super Unit> continuation) {
        Media video;
        Video videoAddress;
        String url;
        Unit unit;
        Media video2;
        Video videoAddress2;
        String url2;
        Object objG;
        ImmVideoRequestEntity immVideoRequestEntity = this.f55910f;
        Unit unit2 = null;
        if (!Intrinsics.b(immVideoRequestEntity != null ? immVideoRequestEntity.getPage() : null, "1")) {
            return Unit.f68710a;
        }
        List<Subject> items = shortTVRespData != null ? shortTVRespData.getItems() : null;
        if (items == null || items.isEmpty()) {
            return Unit.f68710a;
        }
        if (Constants.f55400a.a()) {
            Intrinsics.d(shortTVRespData);
            List<Subject> items2 = shortTVRespData.getItems();
            Intrinsics.d(items2);
            ShortTVItem shortTVFirstEp = items2.get(0).getShortTVFirstEp();
            if (shortTVFirstEp != null && (objG = h.g(w0.c(), new ShortTvVideoImmersiveDataLoader$initVideoPreload$2$1(shortTVFirstEp, null), continuation)) == a.e()) {
                return objG;
            }
        } else {
            try {
                Result.Companion companion = Result.Companion;
                Intrinsics.d(shortTVRespData);
                List<Subject> items3 = shortTVRespData.getItems();
                Intrinsics.d(items3);
                ShortTVItem shortTVFirstEp2 = items3.get(0).getShortTVFirstEp();
                if (shortTVFirstEp2 == null || (video2 = shortTVFirstEp2.getVideo()) == null || (videoAddress2 = video2.getVideoAddress()) == null || (url2 = videoAddress2.getUrl()) == null) {
                    unit = null;
                } else {
                    ORPlayerPreloadManager.f54651i.a().g(url2);
                    unit = Unit.f68710a;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            try {
                Intrinsics.d(shortTVRespData);
                List<Subject> items4 = shortTVRespData.getItems();
                Intrinsics.d(items4);
                ShortTVItem shortTVFirstEp3 = items4.get(1).getShortTVFirstEp();
                if (shortTVFirstEp3 != null && (video = shortTVFirstEp3.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
                    ORPlayerPreloadManager.f54651i.a().g(url);
                    unit2 = Unit.f68710a;
                }
                Result.m163constructorimpl(unit2);
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th3));
            }
        }
        return Unit.f68710a;
    }

    public final void p(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f55910f = immVideoRequestEntity;
    }
}
