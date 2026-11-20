package se;

import com.cloud.tupdate.bean.UpdateContent;
import com.cloud.tupdate.bean.UpdateEntity;
import com.cloud.tupdate.net.network.HttpRequestor;
import com.cloud.tupdate.net.utils.LogUtil;
import com.cloud.tupdate.net.utils.ThreadPoolUtil;
import com.cloud.tupdate.utils.ExecutorUtils;
import com.cloud.tupdate.utils.w;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.http.impl.StringCallback;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
public final class e implements te.c {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends StringCallback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f76315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ te.e f76316g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, te.e eVar) {
            super(true);
            this.f76315f = str;
            this.f76316g = eVar;
        }

        @Override // com.transsion.http.impl.StringCallback
        public void D(int i11, String str, Throwable th2) {
            com.cloud.tupdate.utils.b.f32235a.n(0, String.valueOf(i11), str);
            e.this.k(this.f76315f, this.f76316g);
            LogUtil.f32213a.d(th2);
        }

        @Override // com.transsion.http.impl.StringCallback
        public void E(int i11, String str) {
            try {
                e.this.l(this.f76315f, str, this.f76316g);
            } catch (Exception e11) {
                com.cloud.tupdate.utils.b.f32235a.n(0, "0", "");
                LogUtil.f32213a.d(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends StringCallback {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ te.a f76317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ te.e f76318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f76319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e f76320h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(te.a aVar, te.e eVar, boolean z11, e eVar2) {
            super(true);
            this.f76317e = aVar;
            this.f76318f = eVar;
            this.f76319g = z11;
            this.f76320h = eVar2;
        }

        public static final void G(String str, te.e updateManager, te.a aVar, boolean z11, e this$0) {
            UpdateContent updateContent;
            Boolean showDialog;
            UpdateContent updateContent2;
            String updateVersion;
            UpdateContent updateContent3;
            Boolean force;
            Intrinsics.g(updateManager, "$updateManager");
            Intrinsics.g(this$0, "this$0");
            if (str != null && (!l.y(str))) {
                UpdateEntity updateEntityA = updateManager.a(str);
                if (aVar != null) {
                    boolean zBooleanValue = false;
                    boolean zBooleanValue2 = (updateEntityA == null || (updateContent = updateEntityA.getUpdateContent()) == null || (showDialog = updateContent.getShowDialog()) == null) ? false : showDialog.booleanValue();
                    if (updateEntityA != null && (updateContent3 = updateEntityA.getUpdateContent()) != null && (force = updateContent3.getForce()) != null) {
                        zBooleanValue = force.booleanValue();
                    }
                    String str2 = "";
                    if (updateEntityA != null && (updateContent2 = updateEntityA.getUpdateContent()) != null && (updateVersion = updateContent2.getUpdateVersion()) != null) {
                        str2 = updateVersion;
                    }
                    aVar.a(zBooleanValue2, zBooleanValue, str2);
                }
                if (z11) {
                    this$0.q(updateEntityA, updateManager, z11);
                }
            }
        }

        @Override // com.transsion.http.impl.StringCallback
        public void D(int i11, String str, Throwable th2) {
            te.a aVar = this.f76317e;
            if (aVar != null) {
                if (str == null) {
                    str = "check fail";
                }
                aVar.b(i11, str);
            }
            LogUtil.f32213a.d(th2);
        }

        @Override // com.transsion.http.impl.StringCallback
        public void E(int i11, final String str) {
            try {
                ExecutorService executorServiceI = ExecutorUtils.i();
                final te.e eVar = this.f76318f;
                final te.a aVar = this.f76317e;
                final boolean z11 = this.f76319g;
                final e eVar2 = this.f76320h;
                executorServiceI.execute(new Runnable() { // from class: se.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.G(str, eVar, aVar, z11, eVar2);
                    }
                });
            } catch (Exception e11) {
                te.a aVar2 = this.f76317e;
                if (aVar2 != null) {
                    aVar2.b(i11, "parse fail");
                }
                LogUtil.f32213a.d(e11);
            }
        }
    }

    public static final void j(String url, Map finalHeaders, Map map, e this$0, te.e updateManager) {
        Intrinsics.g(url, "$url");
        Intrinsics.g(finalHeaders, "$finalHeaders");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(updateManager, "$updateManager");
        try {
            com.cloud.tupdate.utils.a.j().d("update", Intrinsics.p("update url -> ", url));
            HttpRequestor httpRequestorA = HttpRequestor.f32183k.a();
            if (httpRequestorA == null) {
                return;
            }
            httpRequestorA.a(url, finalHeaders, map, null, this$0.new a(url, updateManager));
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
    }

    public static final void n(e this$0, te.e updateManager, Map map, String url, Map map2, te.a aVar, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(updateManager, "$updateManager");
        Intrinsics.g(url, "$url");
        try {
            Map<String, String> mapM = this$0.m(updateManager, map);
            HttpRequestor httpRequestorA = HttpRequestor.f32183k.a();
            if (httpRequestorA == null) {
                return;
            }
            httpRequestorA.a(url, mapM, map2, null, new b(aVar, updateManager, z11, this$0));
        } catch (Exception e11) {
            if (aVar != null) {
                aVar.b(-1, "Exception");
            }
            LogUtil.f32213a.d(e11);
        }
    }

    public static final void p(te.e updateManager, String result) {
        Intrinsics.g(updateManager, "$updateManager");
        Intrinsics.g(result, "$result");
        w.m(w.f32268a, updateManager.a(result), updateManager, false, 4, null);
    }

    public static final void r(UpdateEntity updateEntity, te.e updateManager, boolean z11) {
        Intrinsics.g(updateManager, "$updateManager");
        w.f32268a.l(updateEntity, updateManager, z11);
    }

    @Override // te.c
    public void a(final String url, Map<String, String> map, final Map<String, String> map2, final te.e updateManager) {
        Intrinsics.g(url, "url");
        Intrinsics.g(updateManager, "updateManager");
        try {
            final Map<String, String> mapM = m(updateManager, map);
            com.cloud.tupdate.utils.b.f32235a.m(mapM.toString(), String.valueOf(map2));
            ThreadPoolUtil threadPoolUtilA = ThreadPoolUtil.f32218b.a();
            if (threadPoolUtilA == null) {
                return;
            }
            threadPoolUtilA.a(new Runnable() { // from class: se.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.j(url, mapM, map2, this, updateManager);
                }
            });
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
    }

    @Override // te.c
    public void b(final String url, final Map<String, String> map, final Map<String, String> map2, final te.e updateManager, final te.a aVar, final boolean z11) {
        Intrinsics.g(url, "url");
        Intrinsics.g(updateManager, "updateManager");
        try {
            ThreadPoolUtil threadPoolUtilA = ThreadPoolUtil.f32218b.a();
            if (threadPoolUtilA == null) {
                return;
            }
            threadPoolUtilA.a(new Runnable() { // from class: se.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.n(this.f76302a, updateManager, map, url, map2, aVar, z11);
                }
            });
        } catch (Exception e11) {
            if (aVar != null) {
                aVar.b(-1, "Exception");
            }
            LogUtil.f32213a.d(e11);
        }
    }

    public final void k(String str, te.e eVar) {
    }

    public final void l(String str, String str2, te.e eVar) {
        if (str2 != null && (!l.y(str2))) {
            o(str2, eVar);
        }
    }

    public final Map<String, String> m(te.e eVar, Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.cloud.tupdate.utils.d dVar = com.cloud.tupdate.utils.d.f32241a;
        linkedHashMap.put(PlaceTypes.COUNTRY, dVar.d());
        linkedHashMap.put("mcc", dVar.f());
        linkedHashMap.put("brand", dVar.c());
        linkedHashMap.put("osVersion", dVar.p());
        linkedHashMap.put("whiteList", eVar.e());
        if (map != null && (!map.isEmpty())) {
            linkedHashMap.putAll(map);
        }
        return linkedHashMap;
    }

    public void o(final String result, final te.e updateManager) {
        Intrinsics.g(result, "result");
        Intrinsics.g(updateManager, "updateManager");
        try {
            ExecutorUtils.i().execute(new Runnable() { // from class: se.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.p(updateManager, result);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void q(final UpdateEntity updateEntity, final te.e eVar, final boolean z11) {
        try {
            ExecutorUtils.i().execute(new Runnable() { // from class: se.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.r(updateEntity, eVar, z11);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
