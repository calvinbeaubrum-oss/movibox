package se;

import android.content.Context;
import com.cloud.tupdate.bean.AppScoreContent;
import com.cloud.tupdate.bean.UpdateContent;
import com.cloud.tupdate.bean.UpdateEntity;
import com.cloud.tupdate.utils.p;
import com.cloud.tupdate.utils.w;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class g implements te.g {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements p.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateEntity f76326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f76327b;

        public a(UpdateEntity updateEntity, Context context) {
            this.f76326a = updateEntity;
            this.f76327b = context;
        }

        @Override // com.cloud.tupdate.utils.p.b
        public void a() {
            com.cloud.tupdate.utils.b bVar = com.cloud.tupdate.utils.b.f32235a;
            AppScoreContent appScoreContent = this.f76326a.getAppScoreContent();
            bVar.l("cancel", appScoreContent == null ? null : appScoreContent.getScoreDeeplink());
        }

        @Override // com.cloud.tupdate.utils.p.b
        public void b() {
            com.cloud.tupdate.utils.b bVar = com.cloud.tupdate.utils.b.f32235a;
            AppScoreContent appScoreContent = this.f76326a.getAppScoreContent();
            bVar.l("score", appScoreContent == null ? null : appScoreContent.getScoreDeeplink());
            w wVar = w.f32268a;
            Context context = this.f76327b;
            UpdateContent updateContent = this.f76326a.getUpdateContent();
            wVar.r(context, updateContent == null ? null : updateContent.getUpdateVersion(), true);
            com.cloud.tupdate.utils.d dVar = com.cloud.tupdate.utils.d.f32241a;
            Context context2 = this.f76327b;
            AppScoreContent appScoreContent2 = this.f76326a.getAppScoreContent();
            dVar.k(context2, appScoreContent2 != null ? appScoreContent2.getScoreDeeplink() : null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements p.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateEntity f76328a;

        public b(UpdateEntity updateEntity) {
            this.f76328a = updateEntity;
        }

        @Override // com.cloud.tupdate.utils.p.c
        public void a() {
            com.cloud.tupdate.utils.b bVar = com.cloud.tupdate.utils.b.f32235a;
            UpdateContent updateContent = this.f76328a.getUpdateContent();
            bVar.o("cancel", updateContent == null ? null : updateContent.getUpdateUrl());
        }

        @Override // com.cloud.tupdate.utils.p.c
        public void b() {
            com.cloud.tupdate.utils.b bVar = com.cloud.tupdate.utils.b.f32235a;
            UpdateContent updateContent = this.f76328a.getUpdateContent();
            bVar.o("upgrade", updateContent == null ? null : updateContent.getUpdateUrl());
        }

        @Override // com.cloud.tupdate.utils.p.c
        public void c(boolean z11) {
            if (z11) {
                com.cloud.tupdate.utils.b.f32235a.e("upgrade", "upgrade_ignore_click", 1);
            } else {
                com.cloud.tupdate.utils.b.f32235a.e("upgrade", "upgrade_ignore_click", 0);
            }
            UpdateContent updateContent = this.f76328a.getUpdateContent();
            if (updateContent != null && Intrinsics.b(updateContent.getForce(), Boolean.FALSE)) {
                w wVar = w.f32268a;
                UpdateContent updateContent2 = this.f76328a.getUpdateContent();
                wVar.o(updateContent2 == null ? null : updateContent2.getUpdateVersion(), z11);
            }
        }
    }

    @Override // te.g
    public void a(UpdateEntity updateEntity, te.e updateManager) {
        Intrinsics.g(updateEntity, "updateEntity");
        Intrinsics.g(updateManager, "updateManager");
        Context context = updateManager.getContext();
        if (context == null) {
            return;
        }
        com.cloud.tupdate.utils.b.f32235a.k("score", updateEntity);
        p.f32262a.l(context, updateEntity.getAppScoreContent(), updateManager, new a(updateEntity, context));
    }

    @Override // te.g
    public void b(UpdateEntity updateEntity, te.e updateManager, boolean z11) {
        Intrinsics.g(updateEntity, "updateEntity");
        Intrinsics.g(updateManager, "updateManager");
        Context context = updateManager.getContext();
        if (context == null) {
            return;
        }
        UpdateContent updateContent = updateEntity.getUpdateContent();
        if (updateContent != null && Intrinsics.b(updateContent.getForce(), Boolean.FALSE) && !z11) {
            updateManager.d();
            w.f32268a.t(context, "tupdate_update_day", Calendar.getInstance().get(5));
        }
        p.f32262a.q(context, updateEntity, updateManager, new b(updateEntity), updateManager.h());
    }
}
