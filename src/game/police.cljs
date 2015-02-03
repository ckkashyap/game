(ns game.police
  (:require
   [game.createjs :as createjs]
  )
)


(defn newPolicaCar [state]
  (let
      [
       stage (:stage state)
       canvas (:canvas state)
       img (createjs/newBitmap "images/police.png")
       _ (createjs/addChild stage img)
       ]

    img))
    
       
       
