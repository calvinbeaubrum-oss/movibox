package com.cloud.hisavana.sdk;

import android.content.Context;
import com.cloud.hisavana.sdk.common.activity.MiniAppPopUpActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.MiniAppInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.HSToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
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
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30028a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: com.cloud.hisavana.sdk.s0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0330a extends DrawableResponseListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<String, Unit> f30029b;

            /* JADX WARN: Multi-variable type inference failed */
            public C0330a(Function1<? super String, Unit> function1) {
                this.f30029b = function1;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                z.a().w("MiniApp", "Failed to load mini app icon.");
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                this.f30029b.invoke(adImage != null ? adImage.getFilePath() : null);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b extends Lambda implements Function1<String, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<String> f30030a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Ref.ObjectRef<String> objectRef) {
                super(1);
                this.f30030a = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void a(String str) {
                this.f30030a.element = str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                a(str);
                return Unit.f68710a;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class c implements MiniAppPopUpActivity.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AdsDTO f30031a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<String> f30032b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ MiniAppInfo f30033c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Context f30034d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f30035e;

            /* JADX INFO: renamed from: com.cloud.hisavana.sdk.s0$a$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class C0331a extends Lambda implements Function1<Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ AdsDTO f30036a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Context f30037b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f30038c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0331a(AdsDTO adsDTO, Context context, String str) {
                    super(1);
                    this.f30036a = adsDTO;
                    this.f30037b = context;
                    this.f30038c = str;
                }

                public final void a(int i11) {
                    s0.f30028a.b(i11, this.f30036a);
                    e1.I(this.f30037b, this.f30038c);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    a(num.intValue());
                    return Unit.f68710a;
                }
            }

            public c(AdsDTO adsDTO, Ref.ObjectRef<String> objectRef, MiniAppInfo miniAppInfo, Context context, String str) {
                this.f30031a = adsDTO;
                this.f30032b = objectRef;
                this.f30033c = miniAppInfo;
                this.f30034d = context;
                this.f30035e = str;
            }

            @Override // com.cloud.hisavana.sdk.common.activity.MiniAppPopUpActivity.a
            public void a() {
                z.a().d("MiniApp", "On click miniapp guide's skip button.");
                AthenaTracker.W(this.f30031a, 4);
                e1.I(this.f30034d, this.f30035e);
            }

            @Override // com.cloud.hisavana.sdk.common.activity.MiniAppPopUpActivity.a
            public void b() {
                z.a().d("MiniApp", "On click miniapp guide's cancel button.");
                AthenaTracker.W(this.f30031a, 3);
            }

            @Override // com.cloud.hisavana.sdk.common.activity.MiniAppPopUpActivity.a
            public void c() {
                z.a().d("MiniApp", "On click miniapp guide's sure button and show system add homescreen.");
                AthenaTracker.W(this.f30031a, 2);
                t0.f30119a.g(this.f30032b.element, this.f30033c, new C0331a(this.f30031a, this.f30034d, this.f30035e));
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i11, Context context, AdsDTO adsDTO, MiniAppInfo miniAppInfo, String str) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String iconUrl = miniAppInfo.getIconUrl();
            Intrinsics.f(iconUrl, "miniAppInfo.iconUrl");
            d(iconUrl, new b(objectRef));
            z.a().d("MiniApp", "Popup mini app guide.");
            AthenaTracker.W(adsDTO, 1);
            MiniAppPopUpActivity.T(context, miniAppInfo, i11, new c(adsDTO, objectRef, miniAppInfo, context, str));
        }

        public final void b(int i11, AdsDTO adsDTO) {
            int i12;
            if (i11 == -1) {
                z.a().d("MiniApp", "Failed to add to homescreen.");
                i12 = R$string.failed_to_get;
            } else if (i11 == 0) {
                z.a().d("MiniApp", "Cancel to add to homescreen.");
                AthenaTracker.X(adsDTO, 1);
                AthenaTracker.X(adsDTO, 3);
                return;
            } else if (i11 == 1) {
                z.a().d("MiniApp", "Succeed to add to homescreen.");
                AthenaTracker.X(adsDTO, 1);
                AthenaTracker.X(adsDTO, 2);
                i12 = R$string.got_successfully;
            } else {
                if (i11 != 2) {
                    return;
                }
                z.a().d("MiniApp", "Existed in homescreen.");
                i12 = R$string.already_exists;
            }
            HSToastUtil.e(i12);
        }

        public final void d(String str, Function1<? super String, Unit> function1) {
            DownLoadRequest.l(str, null, 13, true, new C0330a(function1));
        }

        public final boolean e(String str, Context context, AdsDTO adsDTO) {
            int i11;
            if (str != null && context != null && adsDTO != null) {
                if (kotlin.text.l.L(str, "launcherdlt://", false, 2, null)) {
                    return e1.I(context, str);
                }
                if (!kotlin.text.l.L(str, "{\"", false, 2, null)) {
                    return false;
                }
                try {
                    MiniAppInfo miniAppInfo = (MiniAppInfo) GsonUtil.a(str, MiniAppInfo.class);
                    if (miniAppInfo != null) {
                        String deepLinkUrl = miniAppInfo.getDeepLinkUrl();
                        Intrinsics.f(deepLinkUrl, "miniAppInfo.deepLinkUrl");
                        if (kotlin.text.l.L(deepLinkUrl, "launcherdlt://", false, 2, null)) {
                            String realDeeplink = miniAppInfo.getDeepLinkUrl();
                            int intGuideMode = miniAppInfo.getIntGuideMode();
                            if (intGuideMode == 0) {
                                return e1.I(context, realDeeplink);
                            }
                            if (intGuideMode != 1) {
                                if (intGuideMode == 2) {
                                    Intrinsics.f(realDeeplink, "realDeeplink");
                                    i11 = 2;
                                }
                                return true;
                            }
                            Intrinsics.f(realDeeplink, "realDeeplink");
                            i11 = 1;
                            a(i11, context, adsDTO, miniAppInfo, realDeeplink);
                            return true;
                        }
                    }
                    return false;
                } catch (Exception unused) {
                    z.a().e("MiniApp", "Parse mini app info failed.");
                }
            }
            return false;
        }
    }
}
