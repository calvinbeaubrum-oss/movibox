package com.transsion.shorttv.episode;

import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.shorttv.episode.ShortTvEpisodeListDialog$showAllEpisodes$1$5", f = "ShortTvEpisodeListDialog.kt", l = {270}, m = "invokeSuspend")
@SourceDebugExtension
public final class ShortTvEpisodeListDialog$showAllEpisodes$1$5 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $selectEp;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ ShortTvEpisodeListDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvEpisodeListDialog$showAllEpisodes$1$5(ShortTvEpisodeListDialog shortTvEpisodeListDialog, String str, int i11, Continuation<? super ShortTvEpisodeListDialog$showAllEpisodes$1$5> continuation) {
        super(2, continuation);
        this.this$0 = shortTvEpisodeListDialog;
        this.$subjectId = str;
        this.$selectEp = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvEpisodeListDialog$showAllEpisodes$1$5(this.this$0, this.$subjectId, this.$selectEp, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvEpisodeListDialog$showAllEpisodes$1$5) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Collection collectionL;
        ProgressBar progressBar;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ox.a aVarW = this.this$0.u0().w();
            String str = this.$subjectId;
            this.label = 1;
            obj = aVarW.c(str, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        List<qx.e> listF = this.this$0.u0().F().f();
        if (listF != null) {
            collectionL = new ArrayList();
            for (Object obj2 : listF) {
                if (obj2 instanceof qx.d) {
                    collectionL.add(obj2);
                }
            }
        } else {
            collectionL = g.l();
        }
        Iterator it = list.iterator();
        while (true) {
            Object obj3 = null;
            if (!it.hasNext()) {
                break;
            }
            ShortTVItem shortTVItem = (ShortTVItem) it.next();
            for (Object obj4 : collectionL) {
                if (((qx.d) obj4).b() == shortTVItem.getEp()) {
                    obj3 = obj4;
                    break;
                }
            }
            qx.d dVar = (qx.d) obj3;
            if (dVar != null && dVar.c() == null) {
                dVar.h(shortTVItem);
            }
        }
        nx.a aVar = this.this$0.f57851a;
        RecyclerView recyclerView = aVar != null ? aVar.f72170f : null;
        if (recyclerView != null) {
            b bVarS0 = this.this$0.s0();
            ShortTvEpisodeListDialog shortTvEpisodeListDialog = this.this$0;
            int i12 = this.$selectEp;
            bVarS0.x0(CollectionsKt___CollectionsKt.M0(collectionL));
            bVarS0.B0(shortTvEpisodeListDialog.f57860k);
            bVarS0.I0(i12);
            recyclerView.setAdapter(bVarS0);
        }
        nx.a aVar2 = this.this$0.f57851a;
        if (aVar2 != null && (progressBar = aVar2.f72169d) != null) {
            so.c.g(progressBar);
        }
        return Unit.f68710a;
    }
}
