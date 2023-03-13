(ns blog-proto.core
   (:require [blog-proto.render :as render]
             [ring.adapter.jetty :as jetty] 
             [ring.util.http-response :as response]
             [reitit.ring :as reitit]
             [clojure.java.io :as io]))

;; setting route
(def routes
  [["/" (fn [request-map] (response/ok
         (slurp (io/file "output/index.html"))))] ;;home index html
   ["/posts/:post" {:get (fn [{{:keys [post]} :path-params}]
                   (response/ok (slurp (io/file (str "output/" post "/index.html")))))}]]) ;;route subfolder in output

(def handler
  (reitit/ring-handler
   (reitit/router routes)
   (reitit/routes
    (reitit/create-resource-handler {:path "/"})
    (reitit/create-default-handler
     {:not-found
      (constantly (response/not-found (slurp (io/file "output/404.html"))))}))))


(render/render!)
(shutdown-agents)

(defn -main [] (jetty/run-jetty
                      (-> #'handler)
                      {:port 3000 :join? false}))