(ns game.police
  (:require
   [game.createjs :as createjs]
  )
)


(defn newPoliceCar [state x v]
  (let
      [
       stage (:stage state)
       canvas (:canvas state)
       img (createjs/newBitmap "images/police.png")
       _ (set! (.-scaleX img) 0.2)
       _ (set! (.-scaleY img) 0.2)
       _ (set! (.-x img) x)
       _ (createjs/addChild stage img)
       ]
    {:velocity v :image img}
))
    
       
       
