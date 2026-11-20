package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcig extends SSLSocketFactory {
    final SSLSocketFactory zza = (SSLSocketFactory) SSLSocketFactory.getDefault();
    final /* synthetic */ zzcih zzb;

    public zzcig(zzcih zzcihVar) {
        this.zzb = zzcihVar;
    }

    private final Socket zza(Socket socket) throws SocketException {
        zzcih zzcihVar = this.zzb;
        if (zzcihVar.zzr > 0) {
            socket.setReceiveBufferSize(zzcihVar.zzr);
        }
        this.zzb.zzs.add(socket);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i11) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(str, i11);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(str, i11, inetAddress, i12);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(inetAddress, i11);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(inetAddress, i11, inetAddress2, i12);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(socket, str, i11, z11);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }
}
