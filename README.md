# MoviBox — reconstruction libre, fidèle à l'architecture d'origine

Application vidéo Android **sans publicité, sans compte, sans limite** : tout le
catalogue et toutes les qualités sont ouverts à tout le monde, par construction
(aucun verrou Premium dans le code — il n'y a rien à déverrouiller).

Reconstruction en code 100 % original de l'architecture de MovieBox v3.0.16
(dépôt d'audit privé `studio-nox/movi-box`) — **aucune ligne du code décompilé
n'est réutilisée**, et les serveurs de l'application d'origine ne sont pas
contactés. Les vidéos proviennent de serveurs publics légaux :
**Internet Archive** (films du domaine public) et **Blender Foundation**
(films d'animation sous licence libre, hébergés sur l'Archive).

## Correspondance architecturale

| MovieBox d'origine (audit) | MoviBox (ce projet) |
|---|---|
| Écran d'accueil VOD avec rangées de chaînes | `HomeScreen` — rangées horizontales par catégorie |
| Recherche catalogue | `SearchScreen` — filtre titre/description |
| `com.transsnet.downloader` + ForegroundService | `Downloader` — `DownloadManager` système, multi-téléchargements, notifications |
| Lecteur ijkplayer/media3 (libavcodec…) | `PlayerActivity` — Media3/ExoPlayer, sélecteur de qualité, reprise de lecture |
| Centre utilisateur / écran Membre (Premium) | `ProfileScreen` — avantages affichés comme acquis pour tous, zéro paiement |
| SDK pub (AdMob, Pangle, Mintegral…) | **Supprimés** — aucune publicité, aucun tracker |
| Paiement (PayWebActivity, billing) | **Supprimés** — rien n'est verrouillé |

## Contenu

Catalogue embarqué `app/src/main/assets/catalog.json` (17 titres vérifiés,
chacun avec ses vraies URL de fichiers MP4) + mise à jour optionnelle depuis
`Catalog.CATALOG_URL` (même schéma JSON) pour enrichir le catalogue sans
republier l'application.

## Build

### GitHub Actions (recommandé — ne charge pas le PC)
Pousser ce dossier sur un dépôt du compte `calvinbeaubrum-oss` : le workflow
`.github/workflows/build.yml` produit l'artefact `MoviBox-debug-apk`.

### Local (Android Studio / Gradle 8.7, JDK 17)
```bash
gradle assembleDebug
```

## Vérifications
```bash
node tools/verify-catalog.js   # catalogue : JSON, unicité, URLs HTTPS + allowlist d'hôtes
```

## Légal
- Films : domaine public (Internet Archive) et licences libres (Blender, Nina Paley).
- Code : original, écrit pour ce projet ; l'application d'origine, son nom commercial
  et ses serveurs ne sont pas réutilisés.
