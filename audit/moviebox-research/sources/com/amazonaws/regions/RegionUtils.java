package com.amazonaws.regions;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class RegionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Region> f15902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Log f15903b = LogFactory.c("com.amazonaws.request");

    public static Region a(String str) {
        for (Region region : c()) {
            if (region.d().equals(str)) {
                return region;
            }
        }
        return null;
    }

    public static Region b(String str) {
        String host = d(str).getHost();
        for (Region region : c()) {
            Iterator<String> it = region.h().values().iterator();
            while (it.hasNext()) {
                if (d(it.next()).getHost().equals(host)) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException("No region found with any service for endpoint " + str);
    }

    public static synchronized List<Region> c() {
        try {
            if (f15902a == null) {
                e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f15902a;
    }

    public static URI d(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getHost() != null) {
                return uri;
            }
            return new URI("http://" + str);
        } catch (URISyntaxException e11) {
            throw new RuntimeException("Unable to parse service endpoint: " + e11.getMessage());
        }
    }

    public static synchronized void e() {
        if (System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride") != null) {
            try {
                h();
            } catch (FileNotFoundException e11) {
                throw new RuntimeException("Couldn't find regions override file specified", e11);
            }
        }
        if (f15902a == null) {
            g();
        }
        if (f15902a == null) {
            throw new RuntimeException("Failed to initialize the regions.");
        }
    }

    public static void f(InputStream inputStream) {
        try {
            f15902a = new RegionMetadataParser().e(inputStream);
        } catch (Exception e11) {
            f15903b.i("Failed to parse regional endpoints", e11);
        }
    }

    public static void g() {
        Log log = f15903b;
        if (log.b()) {
            log.a("Initializing the regions with default regions");
        }
        f15902a = RegionDefaults.a();
    }

    public static void h() throws FileNotFoundException {
        String property = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
        Log log = f15903b;
        if (log.b()) {
            log.a("Using local override of the regions file (" + property + ") to initiate regions data...");
        }
        f(new FileInputStream(new File(property)));
    }
}
