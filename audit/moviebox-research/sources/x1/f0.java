package x1;

import com.applovin.sdk.AppLovinEventParameters;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f79830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f79805b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f79806c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f0 f79807d = new f0(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f0 f79808e = new f0("password");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f0 f79809f = new f0("emailAddress");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f0 f79810g = new f0("newUsername");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f0 f79811h = new f0("newPassword");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f0 f79812i = new f0("postalAddress");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f0 f79813j = new f0("postalCode");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f0 f79814k = new f0("creditCardNumber");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f0 f79815l = new f0("creditCardSecurityCode");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f0 f79816m = new f0("creditCardExpirationDate");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f0 f79817n = new f0("creditCardExpirationMonth");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f0 f79818o = new f0("creditCardExpirationYear");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f0 f79819p = new f0("creditCardExpirationDay");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f0 f79820q = new f0("addressCountry");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final f0 f79821r = new f0("addressRegion");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f0 f79822s = new f0("addressLocality");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final f0 f79823t = new f0("streetAddress");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final f0 f79824u = new f0("extendedAddress");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final f0 f79825v = new f0("extendedPostalCode");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f0 f79826w = new f0("personName");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f0 f79827x = new f0("personGivenName");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f0 f79828y = new f0("personFamilyName");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final f0 f79829z = new f0("personMiddleName");
    public static final f0 A = new f0("personMiddleInitial");
    public static final f0 B = new f0("personNamePrefix");
    public static final f0 C = new f0("personNameSuffix");
    public static final f0 D = new f0("phoneNumber");
    public static final f0 E = new f0("phoneNumberDevice");
    public static final f0 F = new f0("phoneCountryCode");
    public static final f0 G = new f0("phoneNational");
    public static final f0 H = new f0("gender");
    public static final f0 I = new f0("birthDateFull");
    public static final f0 J = new f0("birthDateDay");
    public static final f0 K = new f0("birthDateMonth");
    public static final f0 L = new f0("birthDateYear");
    public static final f0 M = new f0("smsOTPCode");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f0(String str) {
        this((Set<String>) kotlin.collections.v.d(str));
    }

    public f0(Set<String> set) {
        this.f79830a = set;
    }
}
