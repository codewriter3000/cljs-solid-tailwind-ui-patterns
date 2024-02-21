(ns app.core
  (:require
    [components.screenlayouts.core :refer [top-left-screen-layout]]
    [components.groupedlayouts.core :refer [tab-control-grouped-layout]]
    [clojure.string :as str]
    [solid.core :as s :refer [$ defui]]))

(defui app []
       ($ top-left-screen-layout {:company-logo ($ :img {:src "img/company-logo.svg" :height 69 :width 120})
                           :leftbar-items [["Home" "/"]]
                           :footer-body "Hi"}
          (let [active-tab (s/signal 0)])
          ($ tab-control-grouped-layout)
          ($ tab)))

(defn render-app []
  (s/render ($ app) (js/document.getElementById "root")))

;; hot-reloading setup
(defonce dispose (atom (render-app)))

(defn ^:dev/after-load reload []
  (@dispose)
  (reset! dispose (render-app)))
