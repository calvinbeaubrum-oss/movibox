package com.transsion.share.api;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import com.cloud.config.utils.CommonUtils;
import com.google.gson.JsonObject;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.share.bean.ShareBean;
import com.transsion.share.bean.ShareType;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lx.a;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import zo.d;

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
public final class ActionViewModel extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<ShareBean> f57719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Object> f57720d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f57721f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<ShareBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ShareType f57723f;

        public a(ShareType shareType) {
            this.f57723f = shareType;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            ActionViewModel.this.f57719c.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ShareBean shareBean) {
            if (shareBean != null) {
                shareBean.setShareType(this.f57723f);
            }
            ActionViewModel.this.f57719c.q(shareBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f57718b = "ActionViewModel";
        this.f57719c = new c0<>();
        this.f57720d = new c0<>();
        this.f57721f = LazyKt__LazyJVMKt.b(new Function0<lx.a>() { // from class: com.transsion.share.api.ActionViewModel$actionApi$2
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) NetServiceGenerator.f49399d.a().i(a.class);
            }
        });
    }

    public final lx.a d() {
        return (lx.a) this.f57721f.getValue();
    }

    public final LiveData<ShareBean> e() {
        return this.f57719c;
    }

    public final void f(ShareType shareType, String postType, String subjectId, String uid, String scene) {
        Intrinsics.g(shareType, "shareType");
        Intrinsics.g(postType, "postType");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(uid, "uid");
        Intrinsics.g(scene, "scene");
        if (TextUtils.isEmpty(subjectId)) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CommonUtils.PARAM_UID, uid);
        jsonObject.addProperty("type", postType);
        jsonObject.addProperty("scene", scene);
        jsonObject.addProperty("id", subjectId);
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jsonObject.toString();
        Intrinsics.f(string, "json.toString()");
        d().a(cp.a.f62775a.a(), companion.create(string, MediaType.Companion.parse("application/json"))).e(d.f82109a.c()).subscribe(new a(shareType));
    }
}
