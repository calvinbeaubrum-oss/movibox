package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwh {
    public static final zzbwc zza(zzbwq zzbwqVar) {
        Intrinsics.g(zzbwqVar, "<this>");
        return new zzbwk(zzbwqVar);
    }

    public static final zzbwd zzb(zzbws zzbwsVar) {
        Intrinsics.g(zzbwsVar, "<this>");
        return new zzbwl(zzbwsVar);
    }

    public static final zzbwq zzc(Socket socket) throws IOException {
        int i11 = zzbwi.zza;
        Intrinsics.g(socket, "<this>");
        zzbwr zzbwrVar = new zzbwr(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.f(outputStream, "getOutputStream(...)");
        zzbwj sink = new zzbwj(outputStream, zzbwrVar);
        Intrinsics.g(sink, "sink");
        return new zzbvx(zzbwrVar, sink);
    }

    public static final zzbws zzd(Socket socket) throws IOException {
        int i11 = zzbwi.zza;
        Intrinsics.g(socket, "<this>");
        zzbwr zzbwrVar = new zzbwr(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.f(inputStream, "getInputStream(...)");
        zzbwg source = new zzbwg(inputStream, zzbwrVar);
        Intrinsics.g(source, "source");
        return new zzbvy(zzbwrVar, source);
    }
}
