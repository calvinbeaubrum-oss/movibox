package p9;

import androidx.core.view.PointerIconCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Response;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f73722a = g.o("ERR_NAME_NOT_RESOLVED", "ERR_TIMED_OUT", "ERR_CONNECTION_CLOSED", "ERR_CONNECTION_TIMED_OUT", "ERR_CONNECTION_REFUSED", "ERR_CONNECTION_RESET", "ERR_ADDRESS_UNREACHABLE", "ERR_QUIC_PROTOCOL_ERROR");

    public static final boolean a(Response response) {
        int iCode;
        Intrinsics.g(response, "<this>");
        return !d(response) && 400 <= (iCode = response.code()) && iCode < 600;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final int b(Exception exc) {
        Object obj;
        Intrinsics.g(exc, "<this>");
        Iterator<T> it = f73722a.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            String message = exc.getMessage();
            if (message != null && StringsKt__StringsKt.Q(message, str, false, 2, null)) {
                obj = next;
                break;
            }
        }
        String str2 = (String) obj;
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -2126483297:
                    if (str2.equals("ERR_CONNECTION_TIMED_OUT")) {
                        return PointerIconCompat.TYPE_ALL_SCROLL;
                    }
                    break;
                case -1656717400:
                    if (str2.equals("ERR_QUIC_PROTOCOL_ERROR")) {
                        return PointerIconCompat.TYPE_CROSSHAIR;
                    }
                    break;
                case -1521802893:
                    if (str2.equals("ERR_CONNECTION_CLOSED")) {
                        return 1046;
                    }
                    break;
                case -1051917428:
                    if (str2.equals("ERR_TIMED_OUT")) {
                        return PointerIconCompat.TYPE_TEXT;
                    }
                    break;
                case -1005274040:
                    if (str2.equals("ERR_CONNECTION_RESET")) {
                        return 1048;
                    }
                    break;
                case 287761289:
                    if (str2.equals("ERR_CONNECTION_REFUSED")) {
                        return 1047;
                    }
                    break;
                case 341511375:
                    if (str2.equals("ERR_ADDRESS_UNREACHABLE")) {
                        return PointerIconCompat.TYPE_CELL;
                    }
                    break;
                case 1081559230:
                    if (str2.equals("ERR_NAME_NOT_RESOLVED")) {
                        return 1005;
                    }
                    break;
            }
        }
        return -1;
    }

    public static final int c(Response response) {
        int iCode;
        Intrinsics.g(response, "<this>");
        if (d(response) || ((400 > (iCode = response.code()) || iCode >= 500) && response.code() != 505)) {
            return -1;
        }
        return response.code();
    }

    public static final boolean d(Response response) {
        Intrinsics.g(response, "<this>");
        return response.code() == 429;
    }
}
