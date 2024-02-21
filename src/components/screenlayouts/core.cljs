(ns components.screenlayouts.core
  (:require
    [components.navigation.core :refer [topbar leftbar content footer]]
    [solid.core :as s :refer [$ defui children]]))

(defui top-left-screen-layout [{:keys [leftbar-items company-logo children]}]
       ($ :div {:class "flex flex-col h-dvh"}
           ($ topbar {:company-logo company-logo})
           ($ :div {:class "flex flex-row grow"}
              ($ leftbar {:class "basis-1/4" :items leftbar-items})
              ($ content {:class "basis-3/4"}
                 children))
          ))

(defui top-left-footer-screen-layout [{:keys [leftbar-items company-logo children footer-body]}]
       ($ :div {:class "flex flex-col h-dvh"}
           ($ topbar {:company-logo
                 ($ :img {:src "img/company-logo.svg" :height 69 :width 120})})
           ($ :div {:class "flex flex-row grow"}
              ($ leftbar {:class "basis-1/4" :items [["Home" "/"] ["My Profile" "/profile"]]})
              ($ content {:class "basis-3/4"}
                 children))
           ($ footer footer-body)
          ))

(defui left-screen-layout [{:keys [leftbar-items children]}]
       ($ :div {:class "flex flex-row"}
          ($ leftbar {:class "basis-1/4" :items leftbar-items})
          ($ content {:class "basis-3/4"}
             children)))

(defui top-screen-layout [{:keys [company-logo children]}]
       ($ :div {:class "flex flex-col"}
           ($ topbar {:company-logo
                 company-logo})
           ($ content {:class "basis-full flex flex-row"}
              children)
          ))

(defui top-footer-screen-layout [{:keys [company-logo children footer-body]}]
       ($ :div {:class "flex flex-col"}
           ($ topbar {:company-logo
                 company-logo})
           ($ content {:class "basis-full flex flex-row"}
              children)
           ($ footer footer-body)
          ))

(defui content-footer-screen-layout [{:keys [children footer-body]}]
       ($ :div {:class "flex flex-col"}
           ($ content {:class "basis-full"}
              children)
           ($ footer footer-body)
          ))

(defui content-only-screen-layout [children]
       ($ content {:class "h-dvh"}
          children))