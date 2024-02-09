(ns app.core
  (:require
    [components.screenlayouts.core :refer [top-left-layout]]
    [clojure.string :as str]
    [solid.core :as s :refer [$ defui]]))

(defui app []
       ($ top-left-layout {:company-logo ($ :img {:src "img/company-logo.svg" :height 69 :width 120})
                           :leftbar-items [["Home" "/"] ["My Profile" "/profile"]]
                           :footer-body "Hi"}
          "Hello"))

(defn render-app []
  (s/render ($ app) (js/document.getElementById "root")))

;; hot-reloading setup
(defonce dispose (atom (render-app)))

(defn ^:dev/after-load reload []
  (@dispose)
  (reset! dispose (render-app)))
