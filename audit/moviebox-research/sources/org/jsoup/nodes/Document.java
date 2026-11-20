package org.jsoup.nodes;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Document extends Element {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OutputSettings f73067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public QuirksMode f73068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f73069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f73070n;

    /* JADX INFO: compiled from: source.java */
    public static class OutputSettings implements Cloneable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Charset f73072b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Entities.CoreCharset f73074d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Entities.EscapeMode f73071a = Entities.EscapeMode.base;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ThreadLocal<CharsetEncoder> f73073c = new ThreadLocal<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f73075f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f73076g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f73077h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Syntax f73078i = Syntax.html;

        /* JADX INFO: compiled from: source.java */
        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            c(Charset.forName("UTF8"));
        }

        public Charset a() {
            return this.f73072b;
        }

        public OutputSettings b(String str) {
            c(Charset.forName(str));
            return this;
        }

        public OutputSettings c(Charset charset) {
            this.f73072b = charset;
            return this;
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.b(this.f73072b.name());
                outputSettings.f73071a = Entities.EscapeMode.valueOf(this.f73071a.name());
                return outputSettings;
            } catch (CloneNotSupportedException e11) {
                throw new RuntimeException(e11);
            }
        }

        public CharsetEncoder f() {
            CharsetEncoder charsetEncoder = this.f73073c.get();
            return charsetEncoder != null ? charsetEncoder : k();
        }

        public Entities.EscapeMode g() {
            return this.f73071a;
        }

        public int h() {
            return this.f73077h;
        }

        public boolean j() {
            return this.f73076g;
        }

        public CharsetEncoder k() {
            CharsetEncoder charsetEncoderNewEncoder = this.f73072b.newEncoder();
            this.f73073c.set(charsetEncoderNewEncoder);
            this.f73074d = Entities.CoreCharset.byName(charsetEncoderNewEncoder.charset().name());
            return charsetEncoderNewEncoder;
        }

        public boolean l() {
            return this.f73075f;
        }

        public Syntax m() {
            return this.f73078i;
        }

        public OutputSettings n(Syntax syntax) {
            this.f73078i = syntax;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(org.jsoup.parser.f.l("#root", org.jsoup.parser.d.f73171c), str);
        this.f73067k = new OutputSettings();
        this.f73068l = QuirksMode.noQuirks;
        this.f73070n = false;
        this.f73069m = str;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.g
    public String E() {
        return "#document";
    }

    @Override // org.jsoup.nodes.g
    public String G() {
        return super.E0();
    }

    @Override // org.jsoup.nodes.Element
    public Element a1(String str) {
        g1().a1(str);
        return this;
    }

    public Element g1() {
        return i1(TtmlNode.TAG_BODY, this);
    }

    @Override // org.jsoup.nodes.Element
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Document r() {
        Document document = (Document) super.r();
        document.f73067k = this.f73067k.clone();
        return document;
    }

    public final Element i1(String str, g gVar) {
        if (gVar.E().equals(str)) {
            return (Element) gVar;
        }
        int iO = gVar.o();
        for (int i11 = 0; i11 < iO; i11++) {
            Element elementI1 = i1(str, gVar.n(i11));
            if (elementI1 != null) {
                return elementI1;
            }
        }
        return null;
    }

    public OutputSettings j1() {
        return this.f73067k;
    }

    public QuirksMode k1() {
        return this.f73068l;
    }

    public Document l1(QuirksMode quirksMode) {
        this.f73068l = quirksMode;
        return this;
    }

    public String m1() {
        Element elementFirst = B0(CampaignEx.JSON_KEY_TITLE).first();
        return elementFirst != null ? d30.c.k(elementFirst.Z0()).trim() : "";
    }
}
