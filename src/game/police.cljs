(ns game.police
  (:require
   [game.createjs :as createjs]
  )
)

(def carImagePath "images/police.png")

(def scaleFactor 0.2)

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


(defn createImage []
  (let [
       img (createjs/newBitmap carImagePath)
       _ (set! (.-scaleX img) scaleFactor)
       _ (set! (.-scaleY img) scaleFactor)
        ] img))
  

(defn newPoliceCar [state x v]
  (let
      [
       stage (:stage state)
       canvas (:canvas state)
       img (createImage)
       _ (set! (.-x img) x)
       _ (createjs/addChild stage img)
       ]
    {:velocity v :image img}
))
    
       
       
(defn width []
  (let [
        img (createImage)
        ] 
    (println "width = ")
;    (println (.-width (.getBounds img)))
    100
))

