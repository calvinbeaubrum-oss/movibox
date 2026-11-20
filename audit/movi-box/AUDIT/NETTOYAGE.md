# Nettoyage publicitaire du dépôt — MovieBox 3.0.16

Épuration réalisée le 25 octobre 2026 par **calvinbeaubrum-oss**.
Objectif : retirer toute trace de publicité de l'arborescence du dépôt, pour une consultation propre.
**L'état d'origine reste intégralement consultable dans l'historique git (commit initial `e9d292c`).**

## Chiffres

| Poste | Quantité |
|---|---|
| Fichiers supprimés (ressources, libs, assets, META-INF) | **455** (6 236 → 5 780 fichiers dans `resources/`) |
| Blocs manifest supprimés (composants + permissions pub) | **59** |
| Entrées `res/values/` supprimées (styles, strings, public.xml…) | **~1 050** |
| Permissions : 57 → **54** (AD_ID, ACCESS_ADSERVICES ×2 retirées) |

## 1. Fichiers supprimés

- **Mintegral (mbridge)** : 205 fichiers `res/` + `assets/mbridge_download_dialog_view.xml`
- **Pangle / CSJ ByteDance** : 94 fichiers `res/` préfixe `tt_` (boutons pubs, animations, icônes) ; libs `libpglarmor.so`, `libbuffer_pgl.so`, `libfile_lock_pgl.so`, `libtobEmbedPagEncrypt.so`, `libtt_ugen_layout.so` (× 2 ABI)
- **Hisavana (Huawei ads)** : 24 fichiers `res/` + `assets/hisavana_ab_data.json`, `assets/hisavana_rsa_public_key.pem`
- **Ressources pub de l'app (régie SSP Transsion)** : ~110 fichiers préfixe `ad_` (interstitiels, splash, end-cards, formats i1107, boutons « télécharger »), `layout_hs_popupwindow_confirm.xml`, écrans de pub récompensée `activity_rewarded_r01/r02*`, `download_intercept_rewarded_ad_layout.xml`, `long_vod_layout_reward_intercept.xml`
- **OMID (mesure visibilité pub IAB)** : `res/raw/omid_session_client_v1_5_3.js`
- **AdMob / Privacy Sandbox** : `res/xml/ga_ad_services_config.xml`
- **META-INF** : `adnetwork_release.kotlin_module`, `com.cloud.tmc.*.kotlin_module` (régie TMC)

## 2. Blocs manifest supprimés (liste complète)

**Permissions** : `com.google.android.gms.permission.AD_ID`, `android.permission.ACCESS_ADSERVICES_ATTRIBUTION`, `android.permission.ACCESS_ADSERVICES_AD_ID`.

**Hisavana** : HisavanaSplashActivity, AdvertiserLinkActivity, PersonalCloseAdActivity, OfflineLandingActivity, AgentPageLandingActivity, EWOfficialActivity, OnlineLandingActivity, OnlinePreloadLandingPageActivity, TAdInterstitialActivity, TAdWebFormsActivity, MiniAppPopUpActivity, MiniAppSchemeActivity, HisavanaRewardedActivity, HisavanaInterstitialRewardedActivity, HisavanaContentProvider, HisavanaFileProvider, ConfigContentProvider (mediation), meta-data `tran_hisavana_version`, `com.transsion.ad.bidding.splash.BiddingHisavanaSplashActivity`.

**Pangle/CSJ (com.bytedance.sdk.openadsdk)** : TTLandingPageActivity, TTPlayableLandingPageActivity, TTVideoLandingPageLink2Activity, TTDelegateActivity, TTWebsiteActivity, TTAppOpenAdActivity, TTRewardVideoActivity, TTRewardExpressVideoActivity, TTFullScreenVideoActivity, TTFullScreenExpressVideoActivity, TTInterstitialActivity, TTInterstitialExpressActivity, TTCeilingLandingPageActivity, TTAdActivity, BinderPoolService, meta-data `com.bytedance.sdk.pangle.version`.

**Mintegral (com.mbridge.msdk)** : MBCommonActivity, MBRewardVideoActivity (×2), LoadingActivity, NetWorkChangeReceiver.

**Vungle** : VungleActivity, VungleProvider.

**AdMob / mesure Google** : AdActivity, AppMeasurementService, AppMeasurementJobService, AppMeasurementReceiver, meta-data APPLICATION_ID et INTEGRATION_MANAGER.

**Régie EagllWin/TMC** : meta-data `api.eagllwin.com` (×3), `AD_SUBMIT_FORM`, activités `com.cloud.tmc.miniapp.ad.WebviewAdFormActivity`, `WebviewAdLandingPageActivity`, `WebviewPersonalizationActivity`, meta-data mini-config associées.

**Privacy Sandbox** : `<property android.adservices.AD_SERVICES_CONFIG>`, `<uses-library android.ext.adservices>`.

## 3. Conservation volontaire (pas de la publicité)

- Login Facebook (`com.facebook.login`) — connexion utilisateur, pas de pub
- Mini-apps TMC (`com.cloud.tmc.miniapp` hors `.ad.`) — fonctionnalité de l'app
- Centre de récompenses (`rewards_center`, `claim_reward`, `member_task_reward`) — fonctionnalité utilisateur
- `shott_tv_*` — ressources du lecteur vidéo (le préfixe « tt_ » y est une coïncidence)
- Push Firebase (FirebaseInstanceIdReceiver), Crashlytics — infrastructures non publicitaires
- Librairies natives `libnms.so`, `libor_signal.so` — non identifiées publicitaires
- Libs du packer Ijiami (`AUDIT/libs-packer/`) — objet de l'audit

## 4. Outil

Rejouable via `node outils/nettoyer-traces-pub-v2.js` (idempotent, vérifie l'équilibre XML et les résidus).

## 5. Limite importante

Le **code Java** des SDK publicitaires est dans le DEX chiffré par le packer Ijiami (voir `analyse-packer-ijiami.md`) : il n'a jamais été dans ce dépôt et n'a donc pas pu être retiré — ce nettoyage porte sur les artefacts visibles (ressources, manifest, libs, métadonnées). Un APK « sans pub » fonctionnel reste impossible à produire depuis cet arbre sans casser le chiffrement Ijiami.
