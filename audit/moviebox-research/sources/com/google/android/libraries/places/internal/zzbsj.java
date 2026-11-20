package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbsj extends zzbsk {
    private static final zzbtf zzb;
    private static final zzbtf zzc;
    private static final zzbtf zzd;
    private static final zzbtf zze;
    private static final zzbtf zzf;
    private static final zzbtf zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static final Method zzj;
    private static final Method zzk;
    private static final Method zzl;
    private static final Method zzm;
    private static final Constructor zzn;

    static {
        NoSuchMethodException noSuchMethodException;
        Method method;
        Method method2;
        Method method3;
        ClassNotFoundException classNotFoundException;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        NoSuchMethodException noSuchMethodException2;
        Method method8;
        ClassNotFoundException classNotFoundException2;
        Class<?> cls = Boolean.TYPE;
        Constructor<?> constructor = null;
        zzb = new zzbtf(null, "setUseSessionTickets", cls);
        zzc = new zzbtf(null, "setHostname", String.class);
        zzd = new zzbtf(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
        zze = new zzbtf(null, "setAlpnProtocols", byte[].class);
        zzf = new zzbtf(byte[].class, "getNpnSelectedProtocol", new Class[0]);
        zzg = new zzbtf(null, "setNpnProtocols", byte[].class);
        try {
            try {
                method2 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                try {
                    try {
                        method3 = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
                        try {
                            method5 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                            try {
                                Class<?> cls2 = Class.forName("android.net.ssl.SSLSockets");
                                method6 = cls2.getMethod("isSupportedSocket", SSLSocket.class);
                                try {
                                    method7 = cls2.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                                } catch (ClassNotFoundException e11) {
                                    classNotFoundException = e11;
                                    method = method5;
                                    method4 = method6;
                                    zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) classNotFoundException);
                                    method5 = method;
                                    method6 = method4;
                                    method7 = null;
                                } catch (NoSuchMethodException e12) {
                                    noSuchMethodException = e12;
                                    method = method5;
                                    method4 = method6;
                                    zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) noSuchMethodException);
                                    method5 = method;
                                    method6 = method4;
                                    method7 = null;
                                }
                            } catch (ClassNotFoundException e13) {
                                classNotFoundException = e13;
                                method4 = null;
                                method = method5;
                            } catch (NoSuchMethodException e14) {
                                noSuchMethodException = e14;
                                method4 = null;
                                method = method5;
                            }
                        } catch (ClassNotFoundException e15) {
                            classNotFoundException = e15;
                            method = null;
                            method4 = null;
                        } catch (NoSuchMethodException e16) {
                            noSuchMethodException = e16;
                            method = null;
                            method4 = null;
                        }
                    } catch (ClassNotFoundException e17) {
                        classNotFoundException = e17;
                        method = null;
                        method3 = null;
                        method4 = method3;
                        zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) classNotFoundException);
                        method5 = method;
                        method6 = method4;
                        method7 = null;
                        zzj = method2;
                        zzk = method3;
                        zzl = method5;
                        zzh = method6;
                        zzi = method7;
                        method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        zzm = method8;
                        zzn = constructor;
                    } catch (NoSuchMethodException e18) {
                        noSuchMethodException = e18;
                        method = null;
                        method3 = null;
                        method4 = method3;
                        zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) noSuchMethodException);
                        method5 = method;
                        method6 = method4;
                        method7 = null;
                        zzj = method2;
                        zzk = method3;
                        zzl = method5;
                        zzh = method6;
                        zzi = method7;
                        method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        zzm = method8;
                        zzn = constructor;
                    }
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                } catch (ClassNotFoundException e19) {
                    classNotFoundException2 = e19;
                    zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (Throwable) classNotFoundException2);
                } catch (NoSuchMethodException e21) {
                    noSuchMethodException2 = e21;
                    zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (Throwable) noSuchMethodException2);
                }
            } catch (ClassNotFoundException e22) {
                classNotFoundException = e22;
                method = null;
                method2 = null;
                method3 = null;
            } catch (NoSuchMethodException e23) {
                noSuchMethodException = e23;
                method = null;
                method2 = null;
                method3 = null;
            }
            method8 = SSLParameters.class.getMethod("setServerNames", List.class);
        } catch (ClassNotFoundException e24) {
            classNotFoundException2 = e24;
            method8 = null;
        } catch (NoSuchMethodException e25) {
            noSuchMethodException2 = e25;
            method8 = null;
        }
        zzj = method2;
        zzk = method3;
        zzl = method5;
        zzh = method6;
        zzi = method7;
        zzm = method8;
        zzn = constructor;
    }

    public zzbsj(zzbtl zzbtlVar) {
        super(zzbtlVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    public final String zza(SSLSocket sSLSocket) {
        Method method = zzl;
        if (method != null) {
            try {
                return (String) method.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                if (!(e12.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new RuntimeException(e12);
                }
                zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Socket unsupported for getApplicationProtocol, will try old methods");
            }
        }
        if (this.zza.zzc() == 1) {
            try {
                byte[] bArr = (byte[]) zzd.zzb(sSLSocket, new Object[0]);
                if (bArr != null) {
                    return new String(bArr, zzbto.zzb);
                }
            } catch (Exception e13) {
                zzbsk.zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getAlpnSelectedProtocol()", (Throwable) e13);
            }
        }
        if (this.zza.zzc() == 3) {
            return null;
        }
        try {
            byte[] bArr2 = (byte[]) zzf.zzb(sSLSocket, new Object[0]);
            if (bArr2 != null) {
                return new String(bArr2, zzbto.zzb);
            }
            return null;
        } catch (Exception e14) {
            zzbsk.zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getNpnSelectedProtocol()", (Throwable) e14);
            return null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    public final String zzb(SSLSocket sSLSocket, String str, List list) throws IOException {
        String strZza = zza(sSLSocket);
        return strZza == null ? super.zzb(sSLSocket, str, list) : strZza;
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    public final void zzc(SSLSocket sSLSocket, String str, List list) {
        Constructor constructor;
        boolean z11;
        Method method;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzbtm) it.next()).toString());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (str != null) {
            try {
                try {
                    if (!str.contains("_")) {
                        try {
                            zzmt.zzj(zzbjd.zzf(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
                            Method method2 = zzh;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                zzb.zza(sSLSocket, Boolean.TRUE);
                            } else {
                                zzi.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = zzm;
                            if (method3 == null || (constructor = zzn) == null) {
                                zzc.zza(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException(e11);
                }
            } catch (IllegalAccessException e12) {
                throw new RuntimeException(e12);
            } catch (InstantiationException e13) {
                throw new RuntimeException(e13);
            }
        }
        Method method4 = zzl;
        if (method4 != null) {
            try {
                method4.invoke(sSLSocket, new Object[0]);
                zzj.invoke(sSLParameters, strArr);
                z11 = true;
            } catch (InvocationTargetException e14) {
                if (!(e14.getTargetException() instanceof UnsupportedOperationException)) {
                    throw e14;
                }
                zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "configureTlsExtensions", "setApplicationProtocol unsupported, will try old methods");
                z11 = false;
            }
        } else {
            z11 = false;
        }
        sSLSocket.setSSLParameters(sSLParameters);
        if (z11 && (method = zzk) != null && Arrays.equals(strArr, (String[]) method.invoke(sSLSocket.getSSLParameters(), new Object[0]))) {
            return;
        }
        Object[] objArr = {zzbtl.zzg(list)};
        if (this.zza.zzc() == 1) {
            zze.zzb(sSLSocket, objArr);
        }
        if (this.zza.zzc() == 3) {
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }
        zzg.zzb(sSLSocket, objArr);
    }
}
