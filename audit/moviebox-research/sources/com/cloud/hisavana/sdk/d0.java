package com.cloud.hisavana.sdk;

import android.util.Log;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f29612a = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29613b = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends HashSet<String> {
        public a() {
            add("jpg");
            add("jpeg");
            add("png");
            add("gif");
            add("bmp");
            add("webp");
            add("tiff");
            add("tif");
            add("svg");
            add("ico");
            add("heif");
            add("heic");
            add("mp4");
            add("m4a");
            add("fmp4");
            add("webm");
            add("mkv");
            add("ogg");
            add("wav");
            add("flv");
            add("adts");
            add("aac");
            add("html");
            add("htm");
            add("css");
            add("js");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("xml");
            add("swf");
            add(MimeTypes.BASE_TYPE_TEXT);
            add("conf");
        }

        public /* bridge */ int a() {
            return super.size();
        }

        public /* bridge */ boolean a(String str) {
            return super.contains(str);
        }

        public /* bridge */ boolean b(String str) {
            return super.remove(str);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ int size() {
            return a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29614b;

        public b(String str) {
            this.f29614b = str;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().d("DefaultMaterialManager", "request error，URL---》" + this.f29614b);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null) {
                String str = this.f29614b;
                try {
                    z.a().d("DefaultMaterialManager", "request success，filepath ----》" + adImage.getFilePath());
                    AthenaTracker.d0(str, 2, 2, 0L);
                } catch (Throwable th2) {
                    z.a().w("DefaultMaterialManager", Log.getStackTraceString(th2));
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f29616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f29617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ n0 f29618e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f29619f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29620g;

        public c(String str, AtomicInteger atomicInteger, String str2, n0 n0Var, Function0<Unit> function0, AdsDTO adsDTO) {
            this.f29615b = str;
            this.f29616c = atomicInteger;
            this.f29617d = str2;
            this.f29618e = n0Var;
            this.f29619f = function0;
            this.f29620g = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().d("DefaultMaterialManager", "request error，URL---》" + this.f29615b);
            this.f29616c.getAndIncrement();
            d0.f29612a.f(this.f29617d, this.f29618e.c(), this.f29616c, this.f29619f);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null) {
                String str = this.f29615b;
                AdsDTO adsDTO = this.f29620g;
                String str2 = this.f29617d;
                n0 n0Var = this.f29618e;
                AtomicInteger atomicInteger = this.f29616c;
                Function0<Unit> function0 = this.f29619f;
                z.a().d("DefaultMaterialManager", "request success，main url is " + str + ", filepath ----》" + adImage.getFilePath());
                e0 e0Var = e0.f29658a;
                String adCreativeId = adsDTO.getAdCreativeId();
                Intrinsics.f(adCreativeId, "ad.adCreativeId");
                String codeSeatId = adsDTO.getCodeSeatId();
                Intrinsics.f(codeSeatId, "ad.codeSeatId");
                String filePath = adImage.getFilePath();
                Intrinsics.f(filePath, "mediaBean.filePath");
                e0Var.k(adCreativeId, codeSeatId, filePath);
                d0.f29612a.f(str2, n0Var.c(), atomicInteger, function0);
            }
        }
    }

    public final n0 a(List<? extends AdsDTO> ads) {
        Intrinsics.g(ads, "ads");
        n0 n0Var = null;
        n0 n0Var2 = null;
        for (AdsDTO adsDTO : ads) {
            if (adsDTO != null) {
                n0 n0Var3 = new n0(adsDTO);
                if (n0Var2 == null) {
                    n0Var = n0Var3;
                } else {
                    n0Var2.b(n0Var3);
                }
                n0Var2 = n0Var3;
            }
        }
        return n0Var;
    }

    public final void b() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(w9.f.b(com.cloud.sdk.commonutil.util.f.a()));
            String str = File.separator;
            sb2.append(str);
            sb2.append("default_ad_data");
            sb2.append(str);
            sb2.append(AdManager.f29117b);
            File file = new File(sb2.toString());
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                int length = fileArrListFiles != null ? fileArrListFiles.length : 0;
                File[] fileArrListFiles2 = file.listFiles();
                if (fileArrListFiles2 != null) {
                    for (File it : fileArrListFiles2) {
                        if (it.exists()) {
                            d0 d0Var = f29612a;
                            Intrinsics.f(it, "it");
                            if (d0Var.g(it) && d0Var.h(it)) {
                                length--;
                            }
                        }
                    }
                }
                da.a.d().m("default_file_save_finished", length <= 2);
            }
        } catch (Throwable th2) {
            z.a().w("DefaultMaterialManager", Log.getStackTraceString(th2));
        }
    }

    public final void c(int i11) {
        if (i11 > 0) {
            HttpRequest.f28935a.k(i11);
        }
    }

    public final void d(AdsDTO adsDTO) {
        String strE = b0.f29174a.e(adsDTO);
        if (strE != null) {
            DownLoadRequest.k(strE, 3, adsDTO.isOfflineAd(), 1, false, 4, false, adsDTO, null);
        }
        DownLoadRequest.k(adsDTO.getAdChoiceImageUrl(), 3, adsDTO.isOfflineAd(), 3, false, 4, false, adsDTO, null);
    }

    public final void e(String url) {
        Intrinsics.g(url, "url");
        DownLoadRequest.k(url, 3, false, 4, false, 4, false, null, new b(url));
        AthenaTracker.d0(url, 2, 1, 0L);
    }

    public final void f(String codeSeatId, n0 n0Var, AtomicInteger count, Function0<Unit> callback) {
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(count, "count");
        Intrinsics.g(callback, "callback");
        if (n0Var == null) {
            callback.invoke();
            return;
        }
        AdsDTO ad2 = n0Var.a();
        if (n0Var.a() == null) {
            f(codeSeatId, n0Var.c(), count, callback);
            return;
        }
        b0 b0Var = b0.f29174a;
        Intrinsics.f(ad2, "ad");
        String strJ = b0Var.j(ad2);
        DownLoadRequest.k(strJ, 3, ad2.isOfflineAd(), 2, true, 4, ad2.getDefaultMaterialType() == 2, ad2, new c(strJ, count, codeSeatId, n0Var, callback, ad2));
        d(ad2);
        String clickUrl = ad2.getClickUrl();
        Intrinsics.f(clickUrl, "ad.clickUrl");
        if (StringsKt__StringsKt.Q(clickUrl, AgentPageJsBridge.AGENT_PAGE_INFO, false, 2, null)) {
            String clickUrl2 = ad2.getClickUrl();
            Intrinsics.f(clickUrl2, "ad.clickUrl");
            e(clickUrl2);
        }
    }

    public final boolean g(File file) {
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        a aVar = f29613b;
        String strT = FilesKt__UtilsKt.t(file);
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = strT.toLowerCase(locale);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        return aVar.contains(lowerCase);
    }

    public final boolean h(File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return true;
        }
        try {
            IDiskCache iDiskCacheG = DiskLruCacheUtil.g(4);
            ImageCacheURL imageCacheURL = new ImageCacheURL(file.getName());
            z.a().d("DefaultMaterialManager", "saveDefaultAdMaterial, sourceFile is " + file.getName() + ", key is " + imageCacheURL);
            File fileC = iDiskCacheG.c(imageCacheURL);
            if (fileC != null && fileC.exists() && fileC.isFile()) {
                iDiskCacheG.a(imageCacheURL);
            }
            fileInputStream = new FileInputStream(file);
            try {
                String strE = iDiskCacheG.e(imageCacheURL, fileInputStream);
                if (strE == null) {
                    strE = "";
                }
                if (strE.length() > 0) {
                    file.delete();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    z.a().w("DefaultMaterialManager", Log.getStackTraceString(th));
                    if (fileInputStream == null) {
                        return false;
                    }
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        try {
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
