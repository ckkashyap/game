(ns game.gameLoop
  (:require
   [game.police :as police]
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


(defn loopFunction [state]
  (let
      [
       circle  (:circle state)
       y       (.-y circle)
       c       (:counter state)
       _       (set! (.-y circle) (if (> y 200)  5 (+ 10 y)))
       police  (if (:police state) (:police state) {:count 0})
       ctr     (:count police)
       cars    (filter isCarValid (if (:cars police) (:cars police) []))
       _       (doall (map moveCar cars))
       new-car (if (and (< ctr 6) (= (mod c 5) 0)) (police/newPoliceCar state (* 80 (* 6 (rand))) (+ 2 (* 5 (rand)))) nil )
       ]

    (println (count cars))

    (assoc state :police {
                          :cars (if new-car (conj cars new-car) cars)
                          :count (count cars)

                          })
))

;  (assoc state :police {:count (+ 1 count)))))
