package org.jsoup.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f73175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73176b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ParseErrorList f73177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f73178d;

    public e(i iVar) {
        this.f73175a = iVar;
        this.f73178d = iVar.b();
    }

    public static e a() {
        return new e(new b());
    }

    public static Document c(String str, String str2) {
        b bVar = new b();
        return bVar.d(new StringReader(str), str2, ParseErrorList.noTracking(), bVar.b());
    }

    public static List<org.jsoup.nodes.g> d(String str, Element element, String str2) {
        b bVar = new b();
        return bVar.i0(str, element, str2, ParseErrorList.noTracking(), bVar.b());
    }

    public static e g() {
        return new e(new j());
    }

    public boolean b() {
        return this.f73176b > 0;
    }

    public Document e(Reader reader, String str) {
        ParseErrorList parseErrorListTracking = b() ? ParseErrorList.tracking(this.f73176b) : ParseErrorList.noTracking();
        this.f73177c = parseErrorListTracking;
        return this.f73175a.d(reader, str, parseErrorListTracking, this.f73178d);
    }

    public Document f(String str, String str2) {
        this.f73177c = b() ? ParseErrorList.tracking(this.f73176b) : ParseErrorList.noTracking();
        return this.f73175a.d(new StringReader(str), str2, this.f73177c, this.f73178d);
    }
}
