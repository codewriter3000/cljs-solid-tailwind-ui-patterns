(ns components.navigation.core
  (:require
    [clojure.string :as str]
    [solid.core :as s :refer [$ defui for]]))

(defui topbar [{:keys [company-logo]}]
       ($ :header {:class "bg-zinc-800"}
          ($ :div {:class "mx-auto max-w-8xl px-6 sm:px-6 lg:px-8"}
             ($ :div {:class "flex basis-auto items-center justify-between"}
                ($ :div {:class "text-zinc-300"}
                   company-logo)))))

(defui leftbar [{:keys [items class]}]
    (defui item [{:keys [name href]}]
      ($ :button {:class "text-zinc-300 text-lg" :href href}
         ($ :div {:class "p-4 border-r-1"}
            name)))
    ($ :aside {:class (str "flex flex-col bg-zinc-700 border-r-2 border-zinc-800" " " class)}
       (for [[arr _] items]
              ($ item {:name (first arr) :href (first (rest arr))}))))

(defui content [{:keys [class children]}]
       ($ :main {:class (str "bg-zinc-700 basis-3/4" " " class)}
          ($ :div {:class "text-zinc-300"}
             children)))

(defui footer [{:keys [class children]}]
       ($ :footer {:class (str "bg-zinc-800 basis-auto" " " class)}
          ($ :div {:class "text-zinc-300"}
             children)))