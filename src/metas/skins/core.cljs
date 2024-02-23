(ns metas.skins.core
  (:require
    [solid.core :as s :refer [$ defui]]
    [clojure.string :as str]))

;parses skin yaml file
(defn skin [data]
  (-> data
      (str/split-lines)
      (console/log )))