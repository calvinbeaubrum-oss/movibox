package com.transsion.postdetail.comment;

import android.content.Context;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.transsion.postdetail.R$string;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f54963a = new r();

    public final String a(int i11) {
        if (i11 < 1000) {
            return String.valueOf(i11);
        }
        if (i11 < 1000000) {
            BigDecimal bigDecimalDivide = new BigDecimal(i11).divide(new BigDecimal(1000), 1, 4);
            Intrinsics.f(bigDecimalDivide, "bigDecimal.divide(BigDec…BigDecimal.ROUND_HALF_UP)");
            return bigDecimalDivide + " k";
        }
        BigDecimal bigDecimalDivide2 = new BigDecimal(i11).divide(new BigDecimal(1000000), 1, 4);
        Intrinsics.f(bigDecimalDivide2, "bigDecimal.divide(BigDec…BigDecimal.ROUND_HALF_UP)");
        return bigDecimalDivide2 + " m";
    }

    public final String b(Context context, long j11) {
        if (j11 == 0) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        int i11 = calendar.get(1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j11);
        boolean z11 = calendar2.get(1) == i11;
        boolean z12 = calendar2.get(6) == Calendar.getInstance().get(6);
        if (!z11 || z12) {
            String str = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j11));
            Intrinsics.f(str, "SimpleDateFormat(\"dd/MM/…ult()).format(Date(time))");
            return str;
        }
        String str2 = new SimpleDateFormat("dd/MM", Locale.getDefault()).format(new Date(j11));
        Intrinsics.f(str2, "SimpleDateFormat(\"dd/MM\"…ult()).format(Date(time))");
        return str2;
    }

    public final String c(Context context, long j11) {
        Intrinsics.g(context, "context");
        long jCurrentTimeMillis = System.currentTimeMillis() - j11;
        if (jCurrentTimeMillis < -30000) {
            return b(context, j11);
        }
        if (-30000 <= jCurrentTimeMillis && jCurrentTimeMillis < 10000) {
            String string = context.getString(R$string.comment_just_now);
            Intrinsics.f(string, "{\n                contex…t_just_now)\n            }");
            return string;
        }
        if (10000 <= jCurrentTimeMillis && jCurrentTimeMillis < ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            return ((int) (jCurrentTimeMillis / 1000)) + "s";
        }
        if (ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS <= jCurrentTimeMillis && jCurrentTimeMillis < 3600000) {
            return ((int) (jCurrentTimeMillis / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS)) + "min";
        }
        if (3600000 > jCurrentTimeMillis || jCurrentTimeMillis >= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            return b(context, j11);
        }
        return ((int) (jCurrentTimeMillis / 3600000)) + "h";
    }
}
