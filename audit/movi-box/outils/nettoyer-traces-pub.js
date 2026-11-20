// Nettoyage des traces publicitaires du manifest et des values de MovieBox 3.0.16.
// Usage : node outils/nettoyer-traces-pub.js  (depuis la racine du dépôt)
// Supprime les éléments XML (activity/service/receiver/provider/meta-data/uses-permission)
// des SDK publicitaires, avec leurs enfants, et journalise chaque suppression.
// Conservé volontairement : login Facebook (com.facebook.login), mini-apps TMC
// (com.cloud.tmc.miniapp hors ".ad."), ressources shott_* de l'app vidéo.
const fs = require("fs");

// Patterns identifiant un bloc/une entrée publicitaire (testés sur le contenu du bloc)
const PUB = [
  /com\.bytedance\.sdk/i,        // Pangle / CSJ (ByteDance)
  /com\.mintegral/i, /com\.mbridge/i, /\bmbridge_/i, // Mintegral
  /com\.cloud\.hisavana/i, /com\.hisavana/i, /hisavana/i, /tran_hisavana/i, // Hisavana (Huawei ads / mediation)
  /eagllwin/i,                   // Régie maison Transsion (EagllWin/TMC ad)
  /com\.cloud\.tmc\.miniapp\.ad\./i, // Activités "ad" des mini-apps TMC
  /com\.vungle/i, /com\.liftoff/i,   // Vungle / Liftoff
  /com\.facebook\.ads/i,         // Meta Audience Network (PAS com.facebook.login)
  /gms\.permission\.AD_ID/i, /ACCESS_ADSERVICES/i, // Permissions publicitaires
  /iab\.omid/i, /\bomid_session/i,  // Mesure de visibilité publicitaire IAB
];
const isPub = (s) => PUB.some((re) => re.test(s));

// Patterns pour les entrées values/ (name= ou parent=)
const PUB_VALUE = /^(mbridge_|mintegral|hisavana|tt_|ad_|tmc_adn|tran_ad)/i;
const isPubValueName = (s) => PUB_VALUE.test(s);

function cleanXmlElementFile(path, isTarget, label) {
  const lines = fs.readFileSync(path, "utf8").split(/\r?\n/);
  const out = [];
  const removed = [];
  let i = 0;
  while (i < lines.length) {
    const line = lines[i];
    // ouverture d'un élément à considérer
    const m = line.match(/^\s*<(activity|service|receiver|provider|meta-data|uses-permission|uses-library|style|declare-styleable|attr|color|dimen|string|integer|bool|item)\b/);
    if (m) {
      // déterminer l'étendue du bloc : auto-fermé sur une ligne, ou ouvert jusqu'à </tag> correspondant
      const tag = m[1];
      const selfClosedSameLine = /\/>\s*$/.test(line);
      let end = i;
      if (!selfClosedSameLine) {
        let depth = 1;
        for (let j = i + 1; j < lines.length; j++) {
          const open = (lines[j].match(new RegExp(`<${tag}\\b`, "g")) || []).length;
          const close = (lines[j].match(new RegExp(`</${tag}>`, "g")) || []).length;
          const selfClose = (lines[j].match(new RegExp(`<${tag}\\b[^>]*/>`, "g")) || []).length;
          depth += open - selfClose - close;
          if (depth <= 0) { end = j; break; }
        }
      }
      const block = lines.slice(i, end + 1).join("\n");
      const nameAttr = block.match(/(?:name|value)="([^"]*)"/);
      const target = isTarget(block, nameAttr ? nameAttr[1] : "");
      if (target) {
        removed.push(`${path}: <${tag}> ${nameAttr ? nameAttr[1] : "(sans nom)"} [lignes ${i + 1}-${end + 1}]`);
        i = end + 1;
        continue;
      }
    }
    out.push(line);
    i++;
  }
  if (removed.length) fs.writeFileSync(path, out.join("\n"), "utf8");
  return removed;
}

const all = [];
// 1. Manifest : éléments dont le CONTENU matche un pattern pub
all.push(...cleanXmlElementFile("resources/AndroidManifest.xml", (block) => isPub(block), "manifest"));
// 2. values : entrées dont le name= ou parent= matche les préfixes pub
const valuesDir = "resources/res/values";
for (const f of fs.readdirSync(valuesDir).filter((x) => x.endsWith(".xml"))) {
  all.push(...cleanXmlElementFile(`${valuesDir}/${f}`, (block, name) => isPubValueName(name) || /parent="(mbridge_|tt_|hisavana_)/i.test(block), "values"));
}

console.log(`Blocs/entrées publicitaires supprimés : ${all.length}`);
for (const r of all) console.log("  " + r);
fs.writeFileSync("AUDIT/journal-nettoyage-manifest.txt", all.join("\n") + "\n", "utf8");

// Vérification d'équilibre des balises du manifest nettoyé
const xml = fs.readFileSync("resources/AndroidManifest.xml", "utf8");
for (const tag of ["manifest", "application", "activity", "service", "receiver", "provider", "meta-data", "uses-permission"]) {
  const open = (xml.match(new RegExp(`<${tag}\\b[^>]*[^/]?>`, "g")) || []).length;
  const close = (xml.match(new RegExp(`</${tag}>`, "g")) || []).length;
  const selfc = (xml.match(new RegExp(`<${tag}\\b[^>]*/>`, "g")) || []).length;
  console.log(`manifest <${tag}> ouverts=${open} fermés=${close} auto-fermés=${selfc} ${open === close + selfc ? "OK" : "*** DESEQUILIBRE ***"}`);
}
const residus = (xml.match(/bytedance\.sdk|mintegral|mbridge|hisavana|eagllwin|vungle|AD_ID|ADSERVICES/gi) || []).length;
console.log("Résidus de motifs pub dans le manifest :", residus);
