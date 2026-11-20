package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

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
public final class m2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f29863d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdsDTO f29864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f29865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29866c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m2(AdsDTO adsDTO) {
        Intrinsics.g(adsDTO, "adsDTO");
        this.f29864a = adsDTO;
    }

    public final int a() {
        PslinkInfo pslinkInfo = this.f29864a.getPslinkInfo();
        if (pslinkInfo != null) {
            return pslinkInfo.getDownloadCount();
        }
        return 0;
    }

    public final int b(int i11, int i12, int i13) {
        int i14 = i12 + i11;
        int iNextInt = Random.Default.nextInt(i13 + i14) + 1;
        if (iNextInt <= i11) {
            return 0;
        }
        return iNextInt <= i14 ? 1 : 2;
    }

    public final String c(float f11) {
        float f12 = 10;
        String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((float) Math.floor(f11 * f12)) / f12)}, 1));
        Intrinsics.f(str, "format(...)");
        return str;
    }

    public final String d(int i11) {
        StringBuilder sb2;
        String str;
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            if (i11 < 1000) {
                return String.valueOf(i11);
            }
            if (i11 < 1000000) {
                sb2 = new StringBuilder();
                sb2.append(decimalFormat.format(i11 / 1000.0f));
                str = " Thousand";
            } else {
                sb2 = new StringBuilder();
                sb2.append(decimalFormat.format(i11 / 1000000.0f));
                str = " Million";
            }
            sb2.append(str);
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final float e() {
        float f11;
        Integer rating;
        PslinkInfo pslinkInfo = this.f29864a.getPslinkInfo();
        float fIntValue = 0.0f;
        if (pslinkInfo != null) {
            try {
                String score = pslinkInfo.getScore();
                Intrinsics.f(score, "it.score");
                f11 = Float.parseFloat(score);
            } catch (Exception unused) {
                f11 = 0.0f;
            }
        } else {
            f11 = 0.0f;
        }
        NativeBean nativeObject = this.f29864a.getNativeObject();
        if (nativeObject != null && (rating = nativeObject.getRating()) != null) {
            fIntValue = rating.intValue();
        }
        return Math.max(f11, fIntValue);
    }

    public final int f(int i11) {
        if (i11 != 0) {
            if (i11 == 1) {
                return R$drawable.score;
            }
            if (i11 == 2) {
                return R$drawable.download;
            }
        }
        return 0;
    }

    public final int g() {
        ConfigTotalDTO.ExtInfo extInfoD = v.p().d();
        if (extInfoD == null) {
            z.a().i("BannerStyleHelper", "extInfo is null, style is OLD");
            return 0;
        }
        float fE = e();
        this.f29865b = fE;
        boolean z11 = fE >= extInfoD.getScoreCount();
        int iA = a();
        this.f29866c = iA;
        int iB = b(extInfoD.getOldStyle(), z11 ? extInfoD.getScoreStyle() : 0, ((long) iA) >= extInfoD.getDownloadCount() ? extInfoD.getDownloadStyle() : 0);
        if (AdManager.h()) {
            z.a().i("BannerStyleHelper", "score: " + this.f29865b + ", \ndownloadCount: " + this.f29866c + ", \nX: " + extInfoD.getScoreCount() + ", \nY: " + extInfoD.getDownloadCount() + ", \nweightOld: " + extInfoD.getOldStyle() + ", \nweightScore: " + extInfoD.getScoreStyle() + ", \nweightDownload: " + extInfoD.getDownloadStyle() + ", \nrandomStyle: " + iB);
        }
        return iB;
    }

    public final String h(int i11) {
        if (i11 != 0) {
            if (i11 == 1) {
                return c(this.f29865b);
            }
            if (i11 == 2) {
                return d(this.f29866c);
            }
        }
        return "";
    }
}
