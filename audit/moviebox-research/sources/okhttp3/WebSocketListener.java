package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

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
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i11, String reason) {
        Intrinsics.g(webSocket, "webSocket");
        Intrinsics.g(reason, "reason");
    }

    public void onClosing(WebSocket webSocket, int i11, String reason) {
        Intrinsics.g(webSocket, "webSocket");
        Intrinsics.g(reason, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable t11, Response response) {
        Intrinsics.g(webSocket, "webSocket");
        Intrinsics.g(t11, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        Intrinsics.g(webSocket, "webSocket");
        Intrinsics.g(text, "text");
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Intrinsics.g(webSocket, "webSocket");
        Intrinsics.g(bytes, "bytes");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.g(webSocket, "webSocket");
        Intrinsics.g(response, "response");
    }
}
