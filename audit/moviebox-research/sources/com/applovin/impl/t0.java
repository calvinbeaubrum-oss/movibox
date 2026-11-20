package com.applovin.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static t0 f23148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f23149f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f23150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23153d;

    private t0(Context context) throws Throwable {
        Bundle bundle;
        int iIntValue;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            bundle = applicationInfo.metaData;
            try {
                try {
                    String str = applicationInfo.processName;
                    this.f23150a = bundle;
                    this.f23153d = str;
                } catch (PackageManager.NameNotFoundException e11) {
                    e = e11;
                    com.applovin.impl.sdk.n.c("AndroidManifest", "Failed to get meta data.", e);
                    this.f23150a = bundle;
                    this.f23153d = null;
                }
            } catch (Throwable th2) {
                th = th2;
                this.f23150a = bundle;
                this.f23153d = null;
                throw th;
            }
        } catch (PackageManager.NameNotFoundException e12) {
            e = e12;
            bundle = null;
        } catch (Throwable th3) {
            th = th3;
            bundle = null;
            this.f23150a = bundle;
            this.f23153d = null;
            throw th;
        }
        boolean z11 = false;
        try {
            XmlResourceParser xmlResourceParserOpenXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = xmlResourceParserOpenXmlResourceParser.getEventType();
            iIntValue = 0;
            boolean zBooleanValue = false;
            do {
                if (2 == eventType) {
                    try {
                        if (xmlResourceParserOpenXmlResourceParser.getName().equals(MimeTypes.BASE_TYPE_APPLICATION)) {
                            for (int i11 = 0; i11 < xmlResourceParserOpenXmlResourceParser.getAttributeCount(); i11++) {
                                String attributeName = xmlResourceParserOpenXmlResourceParser.getAttributeName(i11);
                                String attributeValue = xmlResourceParserOpenXmlResourceParser.getAttributeValue(i11);
                                if (attributeName.equals("networkSecurityConfig")) {
                                    iIntValue = Integer.valueOf(attributeValue.substring(1)).intValue();
                                } else if (attributeName.equals("usesCleartextTraffic")) {
                                    zBooleanValue = Boolean.valueOf(attributeValue).booleanValue();
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z11 = zBooleanValue;
                        try {
                            com.applovin.impl.sdk.n.c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                            return;
                        } finally {
                            this.f23151b = iIntValue;
                            this.f23152c = z11;
                        }
                    }
                }
                eventType = xmlResourceParserOpenXmlResourceParser.next();
            } while (eventType != 1);
            this.f23151b = iIntValue;
            this.f23152c = zBooleanValue;
        } catch (Throwable th5) {
            th = th5;
            iIntValue = 0;
        }
    }

    public static t0 a(Context context) {
        t0 t0Var;
        synchronized (f23149f) {
            try {
                if (f23148e == null) {
                    f23148e = new t0(context);
                }
                t0Var = f23148e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t0Var;
    }

    public String a() {
        return this.f23153d;
    }

    public String a(String str, String str2) {
        Bundle bundle = this.f23150a;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    public boolean a(String str) {
        Bundle bundle = this.f23150a;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public boolean a(String str, boolean z11) {
        Bundle bundle = this.f23150a;
        return bundle != null ? bundle.getBoolean(str, z11) : z11;
    }
}
