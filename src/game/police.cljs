(ns game.police
  (:require
   [game.createjs :as createjs]
  )
)

(def carImagePath "images/police.png")

(def scaleFactor 0.2)

(defn moveCar [car]
  (let [
        t  (:ticker car)
        nt (if (= t 21) 0 (+ 1 t))
        v   (:velocity car)
        img (:image car)
        y   (.-y img)
        ny  (if (= 10 nt) (if (> (+ y v) 200) 200 (+ y 50)) y)
        ]
    (if (= ny 200) (set! (.-visible img) false))
    (set! (.-y img) ny)
    (assoc car :ticker nt)
)) 

(defn isCarValid [car]
  (< (.-y (:image car)) 200))


(defn createImage []
  (let [
       img (createjs/newBitmap carImagePath)
       _ (set! (.-scaleX img) scaleFactor)
       _ (set! (.-scaleY img) scaleFactor)
        ] img))
  
(defn width []
  (let [
        img (createImage)
        b (.getBounds img)
        w (if b (.-width b) 0)
        ] 
    (println "width === ")
    (println b)
    (println "width +++ ")    
    100
))


(defn newPoliceCar [state l v]
  (let
      [
       x (* (width) l)
       stage (:stage state)
       canvas (:canvas state)
       img (createImage)
       _ (set! (.-x img) x)
       _ (createjs/addChild stage img)
       ]
    {:velocity v :image img :lane l :ticker 0}
))
    
       

