package com.transsion.commercialization.gameres.ps;

import android.content.Context;
import android.view.View;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.GameResView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class PSGameResLoader implements com.transsion.commercialization.gameres.a<RecommendInfo> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51680b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.commercialization.gameres.ps.PSGameResLoader$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    @Override // com.transsion.commercialization.gameres.a
    public void a(Context context, String pageName, String itemId, Function1<? super View, Unit> callback) {
        Intrinsics.g(context, "context");
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(itemId, "itemId");
        Intrinsics.g(callback, "callback");
        j.d(l0.a(w0.b()), null, null, new PSGameResLoader$loadGameInfo$1(itemId, this, callback, context, pageName, null), 3, null);
    }

    public ps.a c(String pageName, String itemId, RecommendInfo info) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(itemId, "itemId");
        Intrinsics.g(info, "info");
        ps.a aVar = new ps.a(GameInfoType.PS, info, null);
        aVar.l(pageName);
        aVar.k(itemId);
        return aVar;
    }

    public GameResView d(Context context, ps.a info) {
        Intrinsics.g(context, "context");
        Intrinsics.g(info, "info");
        PSGameResView pSGameResView = new PSGameResView(context);
        pSGameResView.setContent(info);
        return pSGameResView;
    }

    public String e() {
        if (wo.a.f79569a.d()) {
            return "https://test-empower-api.palmplaystore.com";
        }
        return Intrinsics.b(Utils.a().getPackageName(), "com.community.mbox.in") ? "https://ind-empower-api.palmplaystore.com" : "https://empower-api.palmplaystore.com";
    }

    public final a f() {
        return (a) this.f51680b.getValue();
    }
}
