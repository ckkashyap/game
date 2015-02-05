(ns game.police
  (:require
   [game.createjs :as createjs]
  )
)

(defn moveCar [car]
  (let [
        v   (:velocity car)
        img (:image car)
        y   (.-y img)
        ny  (if (> (+ y v) 200) 200 (+ y v))
        ]
    (if (= ny 200) (set! (.-visible img) false))
    (set! (.-y img) ny)
)) 

(defn isCarValid [car]
  (< (.-y (:image car)) 200))



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
    
       
       
