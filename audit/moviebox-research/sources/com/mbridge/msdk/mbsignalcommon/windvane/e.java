package com.mbridge.msdk.mbsignalcommon.windvane;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum e {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML("html", "text/html");


    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f45790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f45791k;

    e(String str, String str2) {
        this.f45790j = str;
        this.f45791k = str2;
    }

    public final String a() {
        return this.f45790j;
    }

    public final String b() {
        return this.f45791k;
    }
}
