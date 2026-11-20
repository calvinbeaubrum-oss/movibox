package com.avery.subtitle;

import a8.d;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.avery.subtitle.exception.FatalParsingException;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SubtitleLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubtitleLoader f25098a = new SubtitleLoader();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25099b = SubtitleLoader.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k0 f25100c = l0.a(w0.b());

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(Exception exc);

        void b(d dVar);
    }

    public final d c(InputStream inputStream, String str, String str2) throws IOException, FatalParsingException {
        String strSubstring = str.substring(StringsKt__StringsKt.j0(str, "/", 0, false, 6, null) + 1);
        Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
        String strSubstring2 = strSubstring.substring(StringsKt__StringsKt.j0(strSubstring, InstructionFileId.DOT, 0, false, 6, null));
        Intrinsics.f(strSubstring2, "this as java.lang.String).substring(startIndex)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parse: name = ");
        sb2.append(strSubstring);
        sb2.append(", ext = ");
        sb2.append(strSubstring2);
        if (l.v(".srt", strSubstring2, true)) {
            d dVarA = new z7.b().a(strSubstring, str2, inputStream);
            Intrinsics.f(dVarA, "FormatSRT().parseFile(fileName, unicode, `is`)");
            return dVarA;
        }
        if (l.v(".ass", strSubstring2, true) || l.v(".ssa", strSubstring2, true)) {
            d dVarB = new z7.a().b(strSubstring, str2, inputStream);
            Intrinsics.f(dVarB, "FormatASS().parseFile(fileName, unicode, `is`)");
            return dVarB;
        }
        if (l.v(".stl", strSubstring2, true)) {
            d dVarB2 = new z7.c().b(strSubstring, str2, inputStream);
            Intrinsics.f(dVarB2, "FormatSTL().parseFile(fileName, unicode, `is`)");
            return dVarB2;
        }
        if (l.v(".ttml", strSubstring2, true)) {
            d dVarB3 = new z7.c().b(strSubstring, str2, inputStream);
            Intrinsics.f(dVarB3, "FormatSTL().parseFile(fileName, unicode, `is`)");
            return dVarB3;
        }
        if (l.v(".sub", strSubstring2, true)) {
            return new z7.d().b(strSubstring, str2, inputStream);
        }
        d dVarA2 = new z7.b().a(strSubstring, str2, inputStream);
        Intrinsics.f(dVarA2, "FormatSRT().parseFile(fileName, unicode, `is`)");
        return dVarA2;
    }

    public final d d(String str, String str2) throws IOException, FatalParsingException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parseLocal: localSubtitlePath = ");
        sb2.append(str);
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        String path = file.getPath();
        Intrinsics.f(path, "file.path");
        return c(fileInputStream, path, str2);
    }

    public final void e(String str, String str2, a aVar) {
        j.d(f25100c, null, null, new SubtitleLoader$loadFromLocalAsync$1(str, str2, aVar, null), 3, null);
    }

    public final d f(String str, String str2) throws IOException, FatalParsingException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parseRemote: remoteSubtitlePath = ");
        sb2.append(str);
        URL url = new URL(str);
        InputStream inputStreamOpenStream = FirebasePerfUrlConnection.openStream(url);
        Intrinsics.f(inputStreamOpenStream, "url.openStream()");
        String path = url.getPath();
        Intrinsics.f(path, "url.path");
        return c(inputStreamOpenStream, path, str2);
    }

    public final void g(String str, String str2, a aVar) {
        j.d(f25100c, null, null, new SubtitleLoader$loadFromRemoteAsync$1(str, str2, aVar, null), 3, null);
    }

    public final void h(String path, String unicode, a callback) {
        Intrinsics.g(path, "path");
        Intrinsics.g(unicode, "unicode");
        Intrinsics.g(callback, "callback");
        if (TextUtils.isEmpty(path)) {
            return;
        }
        if (l.L(path, "http://", false, 2, null) || l.L(path, AgentPageJsBridge.HTTPS, false, 2, null)) {
            g(path, unicode, callback);
        } else {
            e(path, unicode, callback);
        }
    }
}
