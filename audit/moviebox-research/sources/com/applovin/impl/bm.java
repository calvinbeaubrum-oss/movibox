package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bm extends yl implements ze.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final com.applovin.impl.sdk.ad.b f17992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final u2 f17993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AppLovinAdLoadListener f17994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.applovin.impl.sdk.l f17995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Collection f17996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17997m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected ExecutorService f17998n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected ExecutorService f17999o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected List f18000p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected String f18001q;

    /* JADX INFO: compiled from: source.java */
    public class a implements f1.a {
        public a() {
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            bm.this.f17992h.b(uri);
            com.applovin.impl.sdk.n nVar = bm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                bm bmVar = bm.this;
                bmVar.f24691c.a(bmVar.f24690b, "Ad updated with muteImageUri = " + uri);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements f1.a {
        public b() {
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            bm.this.f17992h.c(uri);
            com.applovin.impl.sdk.n nVar = bm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                bm bmVar = bm.this;
                bmVar.f24691c.a(bmVar.f24690b, "Ad updated with unmuteImageUri = " + uri);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f1.a f18004a;

        public c(f1.a aVar) {
            this.f18004a = aVar;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.n nVar = bm.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    bm bmVar = bm.this;
                    bmVar.f24691c.a(bmVar.f24690b, "Finish caching video for ad #" + bm.this.f17992h.getAdIdNumber() + ". Updating ad with cachedVideoURL = " + uri);
                }
                this.f18004a.a(uri);
                return;
            }
            com.applovin.impl.sdk.n nVar2 = bm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                bm bmVar2 = bm.this;
                bmVar2.f24691c.b(bmVar2.f24690b, "Failed to cache video");
            }
            bm.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            Bundle bundle = new Bundle();
            bundle.putLong("ad_id", bm.this.f17992h.getAdIdNumber());
            bundle.putInt("load_response_code", bm.this.f17993i.b());
            Throwable thA = bm.this.f17993i.a();
            if (thA != null) {
                bundle.putString("load_exception_message", thA.getMessage());
            }
            bm.this.f24689a.p().a(bundle, "video_caching_failed");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements e1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f18006a;

        public d(e eVar) {
            this.f18006a = eVar;
        }

        @Override // com.applovin.impl.e1.c
        public void a(String str, boolean z11) {
            if (z11) {
                bm.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                return;
            }
            e eVar = this.f18006a;
            if (eVar != null) {
                eVar.a(str);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(String str);
    }

    public bm(String str, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, jVar);
        if (bVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.f17992h = bVar;
        this.f17994j = appLovinAdLoadListener;
        this.f17995k = jVar.B();
        this.f17996l = h();
        this.f17993i = new u2();
        if (((Boolean) jVar.a(sj.f22935d1)).booleanValue()) {
            this.f18001q = StringUtils.isValidString(bVar.H()) ? bVar.H() : UUID.randomUUID().toString();
            this.f17998n = jVar.j0().a("com.applovin.sdk.caching." + this.f18001q, ((Integer) jVar.a(sj.f22942e1)).intValue());
            this.f17999o = jVar.j0().a("com.applovin.sdk.caching.html." + this.f18001q, ((Integer) jVar.a(sj.f22950f1)).intValue());
        }
    }

    private Uri a(String str, String str2) {
        File fileA = this.f17995k.a(yp.a(Uri.parse(str2), this.f17992h.getCachePrefix(), this.f24689a), com.applovin.impl.sdk.j.l());
        if (fileA == null) {
            return null;
        }
        if (this.f17995k.a(fileA)) {
            this.f17993i.a(fileA.length());
            return Uri.parse("file://" + fileA.getAbsolutePath());
        }
        if (!this.f17995k.a(fileA, str + str2, Arrays.asList(str), this.f17993i)) {
            return null;
        }
        return Uri.parse("file://" + fileA.getAbsolutePath());
    }

    private String a(String str, boolean z11, List list, boolean z12) {
        return z11 ? b(str, list, z12) : d(str, list, z12);
    }

    private Collection h() {
        HashSet hashSet = new HashSet();
        for (char c11 : ((String) this.f24689a.a(sj.Y0)).toCharArray()) {
            hashSet.add(Character.valueOf(c11));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f17994j;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.f17992h);
            this.f17994j = null;
        }
    }

    public Uri a(Uri uri, String str) {
        if (uri == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "No " + str + " image to cache");
            }
            return null;
        }
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Failed to cache " + str + " image");
            }
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching " + str + " image...");
        }
        return b(string);
    }

    public Uri a(String str, List list, boolean z11) {
        try {
            String strA = this.f17995k.a(a(), str, this.f17992h.getCachePrefix(), list, z11, this.f17993i);
            if (!StringUtils.isValidString(strA)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "Failed to cache image: " + str);
                }
                this.f24689a.E().a(la.G, "cacheImageResource", (Map) CollectionUtils.hashMap("url", str));
                return null;
            }
            File fileA = this.f17995k.a(strA, a());
            if (fileA != null) {
                Uri uriFromFile = Uri.fromFile(fileA);
                if (uriFromFile != null) {
                    return uriFromFile;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "Unable to extract Uri from image file");
                }
                this.f24689a.E().a(la.G, "extractUriFromImageFile", (Map) CollectionUtils.hashMap("url", strA));
                return null;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to retrieve File from cached image filename = " + strA);
            }
            this.f24689a.E().a(la.G, "retrieveImageFile", (Map) CollectionUtils.hashMap("url", strA));
            return null;
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Failed to cache image at url = " + str, th2);
            }
            this.f24689a.E().a(this.f24690b, "cacheImageResource", th2, CollectionUtils.hashMap("url", str));
            return null;
        }
    }

    public e1 a(String str, List list, e eVar) {
        return new e1(str, this.f17992h, list, this.f17993i, this.f17999o, this.f24689a, new d(eVar));
    }

    public f1 a(String str, f1.a aVar) {
        return new f1(str, this.f17992h, this.f17993i, this.f24689a, aVar);
    }

    public f1 a(String str, List list, boolean z11, f1.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f24691c.a(this.f24690b, "No video to cache, skipping...");
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching video " + str + "...");
        }
        return new f1(str, this.f17992h, list, z11, this.f17993i, this.f24689a, new c(aVar));
    }

    public String a(String str, String str2, boolean z11, List list, boolean z12) {
        if (StringUtils.isValidString(str2)) {
            String strA = a(str2, z11, list, z12);
            if (StringUtils.isValidString(strA)) {
                return strA;
            }
            if (TextUtils.isEmpty(str)) {
                a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "Could not retrieve HTML from: " + str2 + " and HTML source is invalid.");
                }
                this.f24689a.E().a(la.G, "retrieveHtmlString", (Map) CollectionUtils.hashMap("url", str2));
            }
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:51:0x0114  */
    /* JADX WARN: Code duplicated, block: B:54:0x0127  */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x00ff, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:54:0x0127, please report this as an issue */
    public String a(String str, List list, com.applovin.impl.sdk.ad.b bVar) {
        Uri uriA;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!((Boolean) this.f24689a.a(sj.Z0)).booleanValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Resource caching is disabled, skipping cache...");
            }
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        boolean zShouldCancelHtmlCachingIfShown = bVar.shouldCancelHtmlCachingIfShown();
        boolean zJ0 = bVar.J0();
        List listW = bVar.W();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            int iIndexOf = 0;
            int i11 = 0;
            while (iIndexOf < sb2.length()) {
                if (l()) {
                    return str;
                }
                iIndexOf = sb2.indexOf(str3, i11);
                if (iIndexOf == -1) {
                    break;
                }
                int length = sb2.length();
                int i12 = iIndexOf;
                while (!this.f17996l.contains(Character.valueOf(sb2.charAt(i12))) && i12 < length) {
                    i12++;
                }
                if (i12 <= iIndexOf || i12 == length) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f24691c.b(this.f24690b, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return str;
                }
                String strSubstring = sb2.substring(str3.length() + iIndexOf, i12);
                if (StringUtils.isValidString(strSubstring)) {
                    if (zShouldCancelHtmlCachingIfShown && bVar.hasShown()) {
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f24691c.a(this.f24690b, "Cancelling HTML caching due to ad being shown already");
                        }
                        this.f17993i.e();
                        return str;
                    }
                    if (zJ0) {
                        if (!bVar.P().equals(str3 + strSubstring)) {
                            uriA = a(str3, strSubstring);
                            if (uriA != null) {
                                sb2.replace(iIndexOf, i12, uriA.toString());
                                bVar.a(uriA);
                                this.f17993i.d();
                            } else {
                                str2 = str3 + strSubstring;
                                if (listW.contains(str2)) {
                                    a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                                    this.f17997m = true;
                                }
                                this.f17993i.c();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f24691c.b(this.f24690b, "Failed to cache HTML Resource: " + str2);
                                }
                                this.f24689a.E().a(la.G, "cacheHtmlResource", (Map) CollectionUtils.hashMap("url", str2));
                            }
                        } else if (com.applovin.impl.sdk.n.a()) {
                            this.f24691c.a(this.f24690b, "Postponing caching for \"" + strSubstring + "\" video resource");
                        }
                    } else {
                        uriA = a(str3, strSubstring);
                        if (uriA != null) {
                            sb2.replace(iIndexOf, i12, uriA.toString());
                            bVar.a(uriA);
                            this.f17993i.d();
                        } else {
                            str2 = str3 + strSubstring;
                            if (listW.contains(str2)) {
                                a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                                this.f17997m = true;
                            }
                            this.f17993i.c();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f24691c.b(this.f24690b, "Failed to cache HTML Resource: " + str2);
                            }
                            this.f24689a.E().a(la.G, "cacheHtmlResource", (Map) CollectionUtils.hashMap("url", str2));
                        }
                    }
                } else if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Skip caching of non-resource " + strSubstring);
                }
                i11 = i12;
            }
        }
        return sb2.toString();
    }

    public List a(List list) {
        this.f18000p = list;
        return this.f24689a.j0().a(list, this.f17998n);
    }

    public void a(int i11) {
        if (this.f17994j != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Calling back ad load failed with error code: " + i11);
            }
            this.f17994j.failedToReceiveAd(i11);
            this.f17994j = null;
        }
        g();
    }

    @Override // com.applovin.impl.ze.a
    public void a(ge geVar) {
        if (geVar.T().equalsIgnoreCase(this.f17992h.H())) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Updating flag for timeout...");
            }
            g();
        }
        this.f24689a.S().b(this);
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        String strA = a(bVar.g0(), bVar.h0(), bVar.O0(), bVar.X(), bVar.Z0());
        if (bVar.N0() && StringUtils.isValidString(strA)) {
            String strA2 = a(strA, bVar.X(), bVar);
            bVar.a(strA2);
            this.f24691c.f(this.f24690b, "Ad updated with video button HTML assets cached = " + strA2);
        }
    }

    public Uri b(String str) {
        return a(str, this.f17992h.X(), true);
    }

    public f1 b(String str, f1.a aVar) {
        return a(str, this.f17992h.X(), true, aVar);
    }

    public String b(String str, List list, boolean z11) {
        InputStream inputStreamA;
        if (StringUtils.isValidString(str)) {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Nothing to cache, skipping...");
                }
                return null;
            }
            try {
                File fileA = this.f17995k.a(yp.a(uri, this.f17992h.getCachePrefix(), this.f24689a), a());
                if (!this.f17995k.a(fileA)) {
                    if (((Boolean) this.f24689a.a(sj.F)).booleanValue()) {
                        try {
                            InputStream inputStreamA2 = this.f17995k.a(str, list, z11, this.f17993i);
                            try {
                                if (inputStreamA2 != null) {
                                    this.f17995k.a(inputStreamA2, fileA);
                                } else {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f24691c.b(this.f24690b, "Failed to load resource: " + str);
                                    }
                                    this.f24689a.E().a(la.G, "cacheStringResource", (Map) CollectionUtils.hashMap("url", str));
                                }
                                if (inputStreamA2 != null) {
                                    inputStreamA2.close();
                                }
                            } catch (Throwable th2) {
                                if (inputStreamA2 != null) {
                                    try {
                                        inputStreamA2.close();
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            this.f24691c.a(this.f24690b, th4);
                            this.f24689a.E().a(this.f24690b, "cacheStringResource", th4);
                        }
                    } else {
                        try {
                            inputStreamA = this.f17995k.a(str, list, z11, this.f17993i);
                            try {
                                if (inputStreamA != null) {
                                    this.f17995k.a(inputStreamA, fileA);
                                } else {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f24691c.b(this.f24690b, "Failed to load resource: " + str);
                                    }
                                    this.f24689a.E().a(la.G, "cacheStringResource", (Map) CollectionUtils.hashMap("url", str));
                                }
                                yp.a(inputStreamA, this.f24689a);
                            } catch (Throwable th5) {
                                th = th5;
                                yp.a(inputStreamA, this.f24689a);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            inputStreamA = null;
                        }
                    }
                }
                return this.f17995k.e(fileA);
            } catch (Throwable th7) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Resource at " + str + " failed to load.", th7);
                }
            }
        }
        return null;
    }

    public Uri c(String str) {
        return c(str, this.f17992h.X(), true);
    }

    public Uri c(String str, List list, boolean z11) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching video " + str + "...");
        }
        String strA = this.f17995k.a(a(), str, this.f17992h.getCachePrefix(), list, z11, this.f17993i);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Failed to cache video: " + str);
            }
            this.f24689a.E().a(la.G, "cacheVideo", (Map) CollectionUtils.hashMap("url", str));
            a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            return null;
        }
        File fileA = this.f17995k.a(strA, a());
        if (fileA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to retrieve File from cached video filename = " + strA);
            }
            this.f24689a.E().a(la.G, "retrieveVideoFile", (Map) CollectionUtils.hashMap("url", strA));
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Finish caching video for ad #" + this.f17992h.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + strA);
            }
            return uriFromFile;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Unable to create URI from cached video file = " + fileA);
        }
        this.f24689a.E().a(la.G, "extractUriFromVideoFile", (Map) CollectionUtils.hashMap("url", strA));
        return null;
    }

    public String d(String str, List list, boolean z11) {
        if (!((Boolean) this.f24689a.a(sj.F)).booleanValue()) {
            InputStream inputStreamA = this.f17995k.a(str, list, z11, this.f17993i);
            if (inputStreamA == null) {
                return null;
            }
            try {
                String strA = this.f17995k.a(inputStreamA);
                yp.a(inputStreamA, this.f24689a);
                return strA;
            } catch (Throwable th2) {
                try {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f24691c.a(this.f24690b, "Unknown failure to read input stream.", th2);
                    }
                    this.f24689a.E().a(this.f24690b, "readInputStreamAsString", th2);
                    return null;
                } finally {
                    yp.a(inputStreamA, this.f24689a);
                }
            }
        }
        try {
            InputStream inputStreamA2 = this.f17995k.a(str, list, z11, this.f17993i);
            if (inputStreamA2 == null) {
                if (inputStreamA2 != null) {
                    inputStreamA2.close();
                }
                return null;
            }
            try {
                String strA2 = this.f17995k.a(inputStreamA2);
                inputStreamA2.close();
                return strA2;
            } catch (Throwable th3) {
                try {
                    inputStreamA2.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Unknown failure to read input stream.", th5);
            }
            this.f24691c.a(this.f24690b, th5);
            this.f24689a.E().a(this.f24690b, "readInputStreamAsString", th5);
            return null;
        }
    }

    public List e() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching mute images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.f17992h.L() != null) {
            arrayList.add(a(this.f17992h.L().toString(), new a()));
        }
        if (this.f17992h.e0() != null) {
            arrayList.add(a(this.f17992h.e0().toString(), new b()));
        }
        return arrayList;
    }

    public void f() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Rendered new ad:" + this.f17992h);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mt
            @Override // java.lang.Runnable
            public final void run() {
                this.f21202a.i();
            }
        });
    }

    public void g() {
        this.f17997m = true;
        List list = this.f18000p;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.f18000p.iterator();
            while (it.hasNext()) {
                ((d1) it.next()).a(true);
            }
        }
        ExecutorService executorService = this.f17998n;
        if (executorService != null) {
            executorService.shutdown();
            this.f17998n = null;
        }
        ExecutorService executorService2 = this.f17999o;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.f17999o = null;
        }
    }

    public void j() {
        if (z3.f()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching mute images...");
        }
        Uri uriA = a(this.f17992h.L(), CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (uriA != null) {
            this.f17992h.b(uriA);
        }
        Uri uriA2 = a(this.f17992h.e0(), CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        if (uriA2 != null) {
            this.f17992h.c(uriA2);
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Ad updated with muteImageFilename = " + this.f17992h.L() + ", unmuteImageFilename = " + this.f17992h.e0());
        }
    }

    public void k() {
        this.f24689a.S().b(this);
        ExecutorService executorService = this.f17998n;
        if (executorService != null) {
            executorService.shutdown();
            this.f17998n = null;
        }
        ExecutorService executorService2 = this.f17999o;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.f17999o = null;
        }
    }

    public boolean l() {
        return this.f17997m;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f17992h.c1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Subscribing to timeout events...");
            }
            this.f24689a.S().a(this);
        }
    }
}
