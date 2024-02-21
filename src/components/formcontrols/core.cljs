(ns components.formcontrols.core
  (:require
    [solid.core :as s :refer [$ defui]]))

(defui textbox [{:keys [label-name children]}]
       ($ :div
          ($ :label {:for label-name}
          label-name)
       ($ :input {:type "text" :id label-name})))