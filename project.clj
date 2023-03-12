(defproject alfian-blog "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"} 
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core            "1.9.5"]
                 [org.immutant/web          "2.1.10"]
                 [rum                       "0.12.8"]
                 [compojure                 "1.6.2"]
                 [joda-time                 "2.10.14"]] 
  :repl-options {:init-ns alfian-blog.core}
  :main alfian_blog.server)
