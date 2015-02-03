(ns game.gameLoop
  (:require
   [game.police :as police]
  )
)

(defn moveCar [car]
  (let [
        v (:velocity car)
        img (:image car)
        y (.-y img)
        ]
    (println "Move")
    (set! (.-y img) (+ y v))
)) 


(defn loopFunction [state]
  (let
      [
       circle (:circle state)
       y (.-y circle)
       c (:counter state)
       _ (set! (.-y circle) (if (> y 200)  5 (+ 10 y)))
       police (if (:police state) (:police state) {:count 0})
       ctr (:count police)
       cars (if (:cars police) (:cars police) [])
       _ (doall (map moveCar cars))
       new-car (if (and (< ctr 6) (= (mod c 5) 0)) (police/newPoliceCar state (* 80 ctr) (+ 2 (* 5 (rand)))) nil )
       ]

    (assoc state :police {
                          :count (+ (if new-car 1 0) ctr)
                          :cars (if new-car (conj cars new-car) cars)
                          })
))

;  (assoc state :police {:count (+ 1 count)))))
