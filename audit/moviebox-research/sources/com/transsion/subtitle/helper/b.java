package com.transsion.subtitle.helper;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.n;
import com.cloud.config.utils.ConstantsKt;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.baselib.report.m;
import com.transsion.subtitle.bean.OpenSubtitleData;
import com.transsion.subtitle.bean.OpenSubtitleDownloadInfo;
import com.transsion.subtitle.bean.OpenSubtitleResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;

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
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f58260a = new b();

    public final String a(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == 3588) {
            return !str.equals("pt") ? str : "pt-pt";
        }
        if (iHashCode != 3886) {
            return (iHashCode == 100341365 && str.equals("in_id")) ? "id" : str;
        }
        return !str.equals("zh") ? str : "zh-cn";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2 A[RETURN, SYNTHETIC] */
    public final String b(String lan) {
        Intrinsics.g(lan, "lan");
        switch (lan) {
            case "ar":
                return "عربي";
            case "bn":
                return "বাংলা";
            case "en":
                return "English";
            case "fr":
                return "Français";
            case "hi":
                return "हिन्दी";
            case "id":
                return "Indonesia";
            case "ru":
                return "Русский";
            case "sw":
                return "Swahili";
            case "ur":
                return "اردو";
            case "fil":
                return "Filipino";
            case "pt-pt":
                return "Português";
            case "zh-cn":
                return "中文(简体)";
            default:
                return "";
        }
    }

    public final String c(InputStream inputStream) {
        try {
            try {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    char[] cArr = new char[512];
                    StringBuffer stringBuffer = new StringBuffer();
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int i11 = inputStreamReader.read(cArr);
                        intRef.element = i11;
                        if (i11 == -1) {
                            break;
                        }
                        stringBuffer.append(cArr, 0, i11);
                    }
                    String string = stringBuffer.toString();
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return string;
                } catch (Throwable th2) {
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th2;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
                try {
                    inputStream.close();
                    return null;
                } catch (Exception unused3) {
                    return null;
                }
            }
        } catch (UnsupportedEncodingException e12) {
            e12.printStackTrace();
            inputStream.close();
            return null;
        }
    }

    public final Object d(String str, Continuation<? super OpenSubtitleDownloadInfo> continuation) {
        int i11;
        String strC;
        try {
            uo.b.a aVar = uo.b.f78622a;
            com.transsion.baselib.report.a aVar2 = com.transsion.baselib.report.a.f51248a;
            aVar.t(aVar2.a(), "Subtitle new api download info start:" + str + " ", true);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://vip-api.opensubtitles.com/api/v1/download").openConnection());
            Intrinsics.e(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", "player2024");
            httpURLConnection.setRequestProperty("Api-Key", "ZRN9QpqcTxje5UH3bV1RuugwitxkqB53");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.getDoOutput();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                outputStreamWriter.write("{\"file_id\":" + str + "}");
                outputStreamWriter.flush();
                Unit unit = Unit.f68710a;
                CloseableKt.a(outputStream, null);
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.f(inputStream, "connection.inputStream");
                if (httpURLConnection.getResponseCode() == 200) {
                    aVar.c(aVar2.a(), "Subtitle new api, download info success ", true);
                    strC = c(inputStream);
                } else {
                    aVar.t(aVar2.a(), "Subtitle new api download info fail ", true);
                    strC = null;
                }
                return (OpenSubtitleDownloadInfo) n.d(strC, OpenSubtitleDownloadInfo.class);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(outputStream, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            i iVarE = ll.c.c().e("https://vip-api.opensubtitles.com/api/v1/download", "GET");
            Intrinsics.f(iVarE, "getInstance().newHttpMetric(url, \"GET\")");
            if (th4 instanceof SSLHandshakeException) {
                i11 = 87;
            } else if (th4 instanceof ProtocolException) {
                i11 = 86;
            } else if (th4 instanceof IOException) {
                i11 = 88;
            } else {
                i11 = th4 instanceof TimeoutException ? 85 : 89;
            }
            iVarE.a(i11);
            th4.printStackTrace();
            uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "Subtitle new api download info fail: " + th4 + " ", true);
            return null;
        }
    }

    public final Object e(String str, String str2, Integer num, Integer num2, Continuation<? super List<OpenSubtitleData>> continuation) {
        String str3;
        int i11;
        String strC;
        List<OpenSubtitleData> data;
        String lowerCase = new Regex("[\\\\/:#*?\"<>|&,]").replace(str, "").toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        String strA = a(str2);
        if (num == null && num2 == null) {
            str3 = "https://vip-api.opensubtitles.com/api/v1/subtitles?query=" + lowerCase + "&languages=" + strA;
        } else {
            str3 = "https://vip-api.opensubtitles.com/api/v1/subtitles?query=" + lowerCase + "&languages=" + strA + "&season_number=" + num + "&episode_number=" + num2;
        }
        try {
            uo.b.a aVar = uo.b.f78622a;
            com.transsion.baselib.report.a aVar2 = com.transsion.baselib.report.a.f51248a;
            aVar.c(aVar2.a(), "new api getSubtitleInfo url:" + str3, true);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str3).openConnection());
            Intrinsics.e(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "player2024");
            httpURLConnection.setRequestProperty("Api-Key", "ZRN9QpqcTxje5UH3bV1RuugwitxkqB53");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.f(inputStream, "connection.inputStream");
            if (httpURLConnection.getResponseCode() == 200) {
                aVar.c(aVar2.a(), "Subtitle new api success ", true);
                strC = c(inputStream);
            } else {
                aVar.t(aVar2.a(), "Subtitle new api fail ", true);
                strC = null;
            }
            OpenSubtitleResponse openSubtitleResponse = (OpenSubtitleResponse) n.d(strC, OpenSubtitleResponse.class);
            if (openSubtitleResponse != null && (data = openSubtitleResponse.getData()) != null && !data.isEmpty()) {
                return CollectionsKt___CollectionsKt.M0(openSubtitleResponse.getData());
            }
            f(3, ConstantsKt.ERROR_1000_MESSAGE);
            return null;
        } catch (Throwable th2) {
            String message = th2.getMessage();
            f(3, message != null ? message : "");
            th2.printStackTrace();
            i iVarE = ll.c.c().e(str3, "GET");
            Intrinsics.f(iVarE, "getInstance().newHttpMetric(urlWithParams, \"GET\")");
            if (th2 instanceof SSLHandshakeException) {
                i11 = 87;
            } else if (th2 instanceof ProtocolException) {
                i11 = 86;
            } else if (th2 instanceof IOException) {
                i11 = 88;
            } else {
                i11 = th2 instanceof TimeoutException ? 85 : 89;
            }
            iVarE.a(i11);
            uo.b.f78622a.h(com.transsion.baselib.report.a.f51248a.a(), "new api getSubtitleInfo FAIL :" + th2, true);
            return null;
        }
    }

    public final void f(int i11, String msg) {
        Intrinsics.g(msg, "msg");
        HashMap map = new HashMap();
        map.put("from", String.valueOf(i11));
        map.put("error_msg", msg);
        m.f51277a.t("subtitle_search", "app_perf", map);
    }
}
