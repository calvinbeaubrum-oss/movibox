package x1;

import androidx.compose.ui.autofill.AutofillType;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<AutofillType, String> f79804a = kotlin.collections.s.j(TuplesKt.a(AutofillType.EmailAddress, "emailAddress"), TuplesKt.a(AutofillType.Username, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER), TuplesKt.a(AutofillType.Password, "password"), TuplesKt.a(AutofillType.NewUsername, "newUsername"), TuplesKt.a(AutofillType.NewPassword, "newPassword"), TuplesKt.a(AutofillType.PostalAddress, "postalAddress"), TuplesKt.a(AutofillType.PostalCode, "postalCode"), TuplesKt.a(AutofillType.CreditCardNumber, "creditCardNumber"), TuplesKt.a(AutofillType.CreditCardSecurityCode, "creditCardSecurityCode"), TuplesKt.a(AutofillType.CreditCardExpirationDate, "creditCardExpirationDate"), TuplesKt.a(AutofillType.CreditCardExpirationMonth, "creditCardExpirationMonth"), TuplesKt.a(AutofillType.CreditCardExpirationYear, "creditCardExpirationYear"), TuplesKt.a(AutofillType.CreditCardExpirationDay, "creditCardExpirationDay"), TuplesKt.a(AutofillType.AddressCountry, "addressCountry"), TuplesKt.a(AutofillType.AddressRegion, "addressRegion"), TuplesKt.a(AutofillType.AddressLocality, "addressLocality"), TuplesKt.a(AutofillType.AddressStreet, "streetAddress"), TuplesKt.a(AutofillType.AddressAuxiliaryDetails, "extendedAddress"), TuplesKt.a(AutofillType.PostalCodeExtended, "extendedPostalCode"), TuplesKt.a(AutofillType.PersonFullName, "personName"), TuplesKt.a(AutofillType.PersonFirstName, "personGivenName"), TuplesKt.a(AutofillType.PersonLastName, "personFamilyName"), TuplesKt.a(AutofillType.PersonMiddleName, "personMiddleName"), TuplesKt.a(AutofillType.PersonMiddleInitial, "personMiddleInitial"), TuplesKt.a(AutofillType.PersonNamePrefix, "personNamePrefix"), TuplesKt.a(AutofillType.PersonNameSuffix, "personNameSuffix"), TuplesKt.a(AutofillType.PhoneNumber, "phoneNumber"), TuplesKt.a(AutofillType.PhoneNumberDevice, "phoneNumberDevice"), TuplesKt.a(AutofillType.PhoneCountryCode, "phoneCountryCode"), TuplesKt.a(AutofillType.PhoneNumberNational, "phoneNational"), TuplesKt.a(AutofillType.Gender, "gender"), TuplesKt.a(AutofillType.BirthDateFull, "birthDateFull"), TuplesKt.a(AutofillType.BirthDateDay, "birthDateDay"), TuplesKt.a(AutofillType.BirthDateMonth, "birthDateMonth"), TuplesKt.a(AutofillType.BirthDateYear, "birthDateYear"), TuplesKt.a(AutofillType.SmsOtpCode, "smsOTPCode"));

    public static final String a(AutofillType autofillType) {
        String str = f79804a.get(autofillType);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Unsupported autofill type".toString());
    }
}
