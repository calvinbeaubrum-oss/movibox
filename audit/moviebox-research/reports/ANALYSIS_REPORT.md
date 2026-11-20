# ANALYSIS_REPORT.md — MovieBox `com.community.oneroom` v3.0.05.0711.03 (APK NON PACKÉE)

> Audit statique du 15 novembre 2026. APK historique récupérée depuis l'historique
> git de `solo12345689/moviebox-internal-api` (commit `9ff0f816`, Phase 0) —
> source de contexte uniquement, aucun code du dépôt exécuté, `session_mbox.json`
> de l'auteur jamais lu ni copié.

## 1. Identité

| Champ | Valeur |
|---|---|
| Package | `com.community.oneroom` |
| versionName / versionCode | **3.0.05.0711.03** / 50020052 |
| Taille / SHA-256 | 65 598 677 octets / `d8dcbe2708b82e44729cd17d2e0439b0a79b9cde19797d830c646048b0650739` |
| Packing | **NON PACKÉ** : 8 DEX (38,1 Mo cumulés), 0 marqueur Ijiami/ijm/MSDvUDPFc |
| Décompilation | JADX 1.5.6 → **38 995 fichiers .java** (31 731 classes, 17 007 erreurs partielles) |
| Signature APK | cf. META-INF (écosystème Transsion) |

Version antérieure et auditable de la 3.0.16 packée analysée précédemment : la classe
`com.transsion.subroom.app.SubRoomApp` (masquée par le packer en 3.0.16) est ici
directement lisible, de même que tout le module réseau.

## 2. Architecture

- **Application** : `com.transsion.subroom.app.SubRoomApp` — init multi-process, config distante (`ConfigManager`, clés `player_async`, `sb_player_type`), lecteur `TnPlayerManager`, MMKV, WorkManager, reporting de cycle de vie.
- **Réseau** (3 couches) :
  1. `com.tn.lib.net.manager.NetServiceGenerator` — Retrofit/OkHttp/Cronet, **QUIC** activé, SSL permissif (`hp.a` + hostnameVerifier custom), `DynamicHostInterceptor` (bascule d'hôtes), `GatewayInterceptor` (signature).
  2. `com.transsion.api.gateway.*` — passerelle `apigateway.tmctool.com` : signature `x-tr-signature` (HMAC-MD5), failover multi-stratégies, resync horloge `GW.4410`, métriques `/gateway/metric/add` (gzip).
  3. `com.transsion.baselib.net.LoginInterceptor` — auth : `X-Client-Token: <ts>,<md5(reverse(ts))>` pour les invités, `Authorization: Bearer <token>` sinon.
- **Crypto SDK** : `com.transsion.crypto.TCrypterSdk` → façade vers packages obfusqués `ys/zs`.
- **Monétisation** : AdMob, Pangle/Bytedance, Mintegral/mbridge, AppLovin, Hisavana, EagllWin — + télémétrie (Firebase/APMInsight).
- **Mini-apps** : V8/Cronet (`100000.miniapp.transsion.com`, `app-oss.byte-app.com`), ponts JS (`RegisterWorkerBridge`, `PermissionScopeBridge`).
- **Code obfusqué** : majorité des 39 000 fichiers dans des packages racine `a…zz`, `OooO*` (ProGuard), dont les packages `ys/zs` (crypto), `qp` (md5), `ap` (token), `hp` (SSL).

## 3. Endpoints découverts (code, pas seulement ressources)

- Passerelle signée : `apigateway.tmctool.com` (chemins `/gateway/metric/add`, `/gateway/sdk/v1/config`).
- Cluster BFF QUIC : `api3/api4/api4sg/api5/api6/api6sg.aoneroom.com`, `api.inmoviebox.com`.
- **Staging embarqué** : `test-mse-api.aoneroom.com` (hint QUIC en production).
- CDN/assets : `pacdn.aoneroom.com`, `app-oss.byte-app.com`, `100000.miniapp.transsion.com`, `h5.dlight-app.com` (privacy policy).
- Deep links `moviebox://` ; protocole applicatif `/wefeed-mobile-bff/...` documenté dans `OFFICIAL_API_DOCUMENTATION.md` (source du dépôt, corroborée par le code).
- Liste exhaustive : `security_findings.txt` (612 hôtes distincts).

## 4. Clés / secrets (redactés)

| Secret | Emplacement | Nature |
|---|---|---|
| Secret gateway **online** `76iR…` (40 car., base64) | manifeste (`gateway_secret_online`) **et codé en dur** dans `com/cloud/hisavana/sdk/h0.java:46` | clé HMAC-MD5 des requêtes gateway — **l'ensemble du schéma de signature est répliquable hors de l'app** (l'audit statique suffit) |
| Secret gateway **test** `Xqn2…` (40 car.) | manifeste (`gateway_secret_test`) + `h0.java` | même clé en environnement test |
| Clé Google AIza ×3 | SDK ads (`zzbii.java`), manifeste | Firebase/ads (publics par conception) |
| Vrais positifs écartés | `R.java`, SDK divers | identifiants de ressources, noms de variables |

Le secret `76iR…`/`Xqn2…` correspond exactement aux « Default/Alt Gateway Secret »
documentés côté dépôt de référence ; il est désormais **confirmé dans le code binaire**.
`security_findings.txt` (43 467 fichiers scannés) contient la liste redactée complète.

## 5. Refactoring sémantique (Étape 4)

Périmètre réaliste sur 39 000 fichiers : **8 fichiers prioritaires** (réseau/API/auth/crypto/Application)
copiés dans `refactored_sources/` avec en-tête sémantique détaillé et renommages sûrs
(logique inchangée) :

| Original | Rôle établi |
|---|---|
| `com/transsion/api/gateway/GateWaySdk.java` | Singleton gateway, secrets manifeste, WorkMode |
| `com/transsion/api/gateway/GatewaySignManager.java` | x-tr-signature (canonical + HMAC-MD5) |
| `com/transsion/api/gateway/interceptor/GatewayInterceptor.java` | Réécriture d'hôte, signature, failover, gzip metrics |
| `com/transsion/baselib/net/LoginInterceptor.java` → **ClientAuthInterceptor** | X-Client-Token / Bearer |
| `com/transsion/api/gateway/utils/EncoderUtil.java` | MD5/SHA hex |
| `com/tn/lib/net/manager/NetServiceGenerator.java` | Fabrique réseau (QUIC/SSL/Retrofit) |
| `com/transsion/subroom/app/SubRoomApp.java` | Application principale |
| `com/transsion/crypto/TCrypterSdk.java` | Façade crypto (réelle dans `ys/zs`) |

Glossaire complet : `glossary.json` (protocole, hosts, classes clés, packages obfusqués
`ys/zs/qp/ap/hp` encore non résolus — cible d'un travail ultérieur).

## 6. Limitations

1. **Obfuscation ProGuard massive** : la majorité du code applicatif est dans des packages racine courts (`a…zz`, `OooO*`) ; le refactoring complet des ~39 000 fichiers n'est pas réaliste en une passe — priorité `com.transsion.*` appliquée (8 fichiers clés annotés, glossaire documentant le reste).
2. **17 007 erreurs partielles JADX** (Kotlin metadata malformée, etc.) : les fichiers concernés restent lisibles avec des marqueurs `JADX ERROR` (ex. `LoginInterceptor`, `SubRoomApp`).
3. **Crypto `ys/zs` non résolue** : la logique réelle de TCrypterSdk est obfusquée ; il faudrait une passe ciblée supplémentaire (deobfuscation `qp/ap/hp` incluse).
4. Le manifeste liste aussi `com.transsnet.downloader`, `com.transsion.payment`, `com.transsion.edcation` (modules secondaires non refactorés).

## 7. Recommandations de sécurité

1. **Secret gateway embarqué deux fois** (manifeste + SDK pub Hisavana en dur) : tout client connaissant ces 2 constantes peut signer des requêtes gateway — le mécanisme protège contre le replay léger et le décalage d'horloge, pas contre la falsification par un analyste. Côté serveur : considérer ce schéma comme de l'obfuscation, pas de l'authentification.
2. **SSL permissif** (`hp.a` : `createSSLSocketFactory` + hostnameVerifier custom) : MITM possible si `hp.a` accepte tout certificat — à vérifier dans `com/tn/lib/net/…`/`hp` (piste suivante).
3. **Environnements de test exposés** dans l'APK prod (`gateway_secret_test`, `test-mse-api.aoneroom.com`).
4. `usesCleartextTraffic` et permissions larges : cf. audit 3.0.16 (toujours applicables à cette génération).

## 8. Livrables

| Livrable | Emplacement |
|---|---|
| Sources refactorées (8 fichiers prioritaires) | `C:\Work\refactored_sources\` |
| Glossaire (protocole + renommages) | `C:\Work\glossary.json` |
| Scan sécurité (43 467 fichiers, redacté) | `C:\Work\security_findings.txt` |
| Ce rapport | `C:\Work\ANALYSIS_REPORT.md` |
| Package final | `C:\Work\RESULT_FINAL.zip` |
| Décompilation brute complète (38 995 .java) | `C:\Work\jadx_output\` (hors package, volume) |
