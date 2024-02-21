(ns components.groupedlayouts.core
  (:require
    [solid.core :as s :refer [$ defui]]))

(defui tab [{:keys [name children]}]
       children)

(defui tab-header [{:keys [name active]}]
       ($ :li {:class "me-2"}
             ($ :button {:aria-current "page" :class (str "inline-block p-4 text-zinc-200 "
                                                    (if (true? active) "bg-zinc-600 rounded-t-lg"))}
                name)))

; CHILDREN HAVE TO BE TABS
(defui tab-control-grouped-layout [{:keys [children]}]
       ($ :ul {:class "flex flex-wrap text-sm font-medium text-center text-zinc-300 border-b-2 border-zinc-800"}
          ($ tab-header {:name "General Settings" :active true})
          ($ tab-header {:name "Cache"})
          ($ tab-header {:name "Database"})))