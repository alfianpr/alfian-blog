(ns blog-proto.adoc
  (:require [java-time :as jt])
  (:import [org.asciidoctor Asciidoctor$Factory]))

(defonce ^:private adoc
  (Asciidoctor$Factory/create))

(defn parse
  "Convert the given source from AsciiDoc to the title string and HTML
  body."
  [source]
  (when source
    (let [header (.readDocumentHeader adoc source)]
      (merge {:html (.convert adoc source {"attributes" {"source-highlighter" "rouge"}})}
             (when header
               (let [title (.getDocumentTitle header)
                     author (.getAuthor header)
                     revision (.getRevisionInfo header)]
                 (merge {}
                        (when-let [combined (some-> title .getCombined)]
                          {:title combined})
                        (when-let [full-name (some-> author .getFullName)]
                          {:author full-name})
                        (when-let [date (some-> revision .getDate)]
                          {:date (jt/local-date date)}))))))))