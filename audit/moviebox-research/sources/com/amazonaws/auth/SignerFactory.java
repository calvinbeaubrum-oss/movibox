package com.amazonaws.auth;

import com.amazonaws.internal.config.InternalConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SignerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Class<? extends Signer>> f15703a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f15703a = concurrentHashMap;
        concurrentHashMap.put("QueryStringSignerType", QueryStringSigner.class);
        concurrentHashMap.put("AWS4SignerType", AWS4Signer.class);
        concurrentHashMap.put("NoOpSignerType", NoOpSigner.class);
    }

    public static Signer a(String str, String str2) {
        Class<? extends Signer> cls = f15703a.get(str);
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        try {
            Signer signerNewInstance = cls.newInstance();
            if (signerNewInstance instanceof ServiceAwareSigner) {
                ((ServiceAwareSigner) signerNewInstance).a(str2);
            }
            return signerNewInstance;
        } catch (IllegalAccessException e11) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e11);
        } catch (InstantiationException e12) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e12);
        }
    }

    public static Signer b(String str, String str2) {
        return d(str, str2);
    }

    public static Signer c(String str, String str2) {
        return a(str, str2);
    }

    public static Signer d(String str, String str2) {
        return a(InternalConfig.Factory.a().i(str, str2).a(), str);
    }

    public static void e(String str, Class<? extends Signer> cls) {
        if (str == null) {
            throw new IllegalArgumentException("signerType cannot be null");
        }
        if (cls == null) {
            throw new IllegalArgumentException("signerClass cannot be null");
        }
        f15703a.put(str, cls);
    }
}
