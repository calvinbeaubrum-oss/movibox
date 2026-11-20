package w9;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f79347a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: w9.c0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0884a extends DrawableResponseListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f79348b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79349c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79350d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79351e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79352f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ b f79353g;

            public C0884a(String str, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, b bVar) {
                this.f79348b = str;
                this.f79349c = booleanRef;
                this.f79350d = booleanRef2;
                this.f79351e = booleanRef3;
                this.f79352f = booleanRef4;
                this.f79353g = bVar;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                com.cloud.hisavana.sdk.z zVarA = com.cloud.hisavana.sdk.z.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onRequestError ");
                sb2.append(taErrorCode);
                sb2.append(' ');
                sb2.append(taErrorCode != null ? Integer.valueOf(taErrorCode.getErrorCode()) : null);
                sb2.append(' ');
                sb2.append(taErrorCode != null ? taErrorCode.getErrorMessage() : null);
                sb2.append(" url ");
                sb2.append(this.f79348b);
                sb2.append(')');
                zVarA.e("VastMaterialDownloadUtil", sb2.toString());
                this.f79349c.element = true;
                c0.f79347a.b(true, this.f79350d.element, this.f79351e.element, this.f79352f.element, this.f79353g);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                com.cloud.hisavana.sdk.z.a().e("VastMaterialDownloadUtil", "onRequestSuccess " + i11);
                Ref.BooleanRef booleanRef = this.f79349c;
                booleanRef.element = true;
                this.f79352f.element = true;
                c0.f79347a.b(booleanRef.element, this.f79350d.element, this.f79351e.element, true, this.f79353g);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b extends DrawableResponseListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79354b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79355c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79356d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79357e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f79358f;

            public b(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, b bVar) {
                this.f79354b = booleanRef;
                this.f79355c = booleanRef2;
                this.f79356d = booleanRef3;
                this.f79357e = booleanRef4;
                this.f79358f = bVar;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                this.f79354b.element = true;
                c0.f79347a.b(this.f79355c.element, true, this.f79356d.element, this.f79357e.element, this.f79358f);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                this.f79354b.element = true;
                c0.f79347a.b(this.f79355c.element, true, this.f79356d.element, this.f79357e.element, this.f79358f);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class c extends DrawableResponseListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79359b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79360c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79361d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f79362e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f79363f;

            public c(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, b bVar) {
                this.f79359b = booleanRef;
                this.f79360c = booleanRef2;
                this.f79361d = booleanRef3;
                this.f79362e = booleanRef4;
                this.f79363f = bVar;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                this.f79359b.element = true;
                c0.f79347a.b(this.f79360c.element, this.f79361d.element, true, this.f79362e.element, this.f79363f);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                this.f79359b.element = true;
                c0.f79347a.b(this.f79360c.element, this.f79361d.element, true, this.f79362e.element, this.f79363f);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(boolean z11, boolean z12, boolean z13, boolean z14, b bVar) {
            if (z13 && z12 && z11) {
                if (z14) {
                    if (bVar != null) {
                        bVar.onSuccess();
                    }
                } else if (bVar != null) {
                    TaErrorCode MAIN_VIDEO_DOWNLOAD_FAIL_ERROR = TaErrorCode.MAIN_VIDEO_DOWNLOAD_FAIL_ERROR;
                    Intrinsics.f(MAIN_VIDEO_DOWNLOAD_FAIL_ERROR, "MAIN_VIDEO_DOWNLOAD_FAIL_ERROR");
                    bVar.a(MAIN_VIDEO_DOWNLOAD_FAIL_ERROR);
                }
            }
        }

        public final void c(b bVar, AdsDTO adsDTO) {
            boolean z11;
            VideoMask videoMask;
            VastIcon icon;
            VastMedia mainAd;
            String resource = null;
            VastData videoInfo = adsDTO != null ? adsDTO.getVideoInfo() : null;
            String mediaResource = (videoInfo == null || (mainAd = videoInfo.getMainAd()) == null) ? null : mainAd.getMediaResource();
            String iconResource = (videoInfo == null || (icon = videoInfo.getIcon()) == null) ? null : icon.getIconResource();
            if (videoInfo != null && (videoMask = videoInfo.getVideoMask()) != null) {
                resource = videoMask.getResource();
            }
            String str = resource;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
            if (TextUtils.isEmpty(mediaResource)) {
                if (bVar != null) {
                    TaErrorCode NO_MAIN_VIDEO_DATA_ERROR = TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR;
                    Intrinsics.f(NO_MAIN_VIDEO_DATA_ERROR, "NO_MAIN_VIDEO_DATA_ERROR");
                    bVar.a(NO_MAIN_VIDEO_DATA_ERROR);
                    return;
                }
                return;
            }
            if (mediaResource != null) {
                z11 = true;
                DownLoadRequest.m(mediaResource, adsDTO, true, new C0884a(mediaResource, booleanRef2, booleanRef, booleanRef3, booleanRef4, bVar));
            } else {
                z11 = true;
                booleanRef2.element = true;
            }
            if (iconResource != null) {
                DownLoadRequest.l(iconResource, adsDTO, 11, z11, new b(booleanRef, booleanRef2, booleanRef3, booleanRef4, bVar));
            } else {
                booleanRef.element = z11;
            }
            if (str != 0) {
                DownLoadRequest.l(str, adsDTO, 12, z11, new c(booleanRef3, booleanRef2, booleanRef, booleanRef4, bVar));
            } else {
                booleanRef3.element = z11;
                b(booleanRef2.element, booleanRef.element, true, booleanRef4.element, bVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a(TaErrorCode taErrorCode);

        void onSuccess();
    }
}
