(defproject blog-proto "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [me.raynes/fs "1.4.6"]
                 [selmer "1.12.56"]
                 [org.asciidoctor/asciidoctorj "2.5.4"]
                 [clojure.java-time "1.2.0"]
                 [com.taoensso/timbre "6.1.0"]
                 [com.climate/claypoole "1.1.4"]
                 [ring "1.8.2"]
                 [metosin/ring-http-response "0.9.1"]
                 [metosin/muuntaja "0.6.7"]
                 [metosin/reitit "0.5.11"]]
  :repl-options {:init-ns blog-proto.core}
  :main blog-proto.core)
