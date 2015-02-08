(ns game.gameLoop
  (:require
   [game.police :as police]
  )
)


(defn loopFunction [state]
  (let
      [
       c       (:counter state)
       police  (if (:police state) (:police state) {:count 0})
       ctr     (:count police)
       cars    (filter police/isCarValid (if (:cars police) (:cars police) []))
       occupied-lanes (into #{} (map :lane cars))
       updated-cars       (map police/moveCar cars)
       lane (int (* 6 (rand)))
       new-car (if (and (not (occupied-lanes lane))(= (mod c 5) 0)) (police/newPoliceCar state  lane 10) nil )
       ]

    (println (count updated-cars))

    (assoc state :police {
                          :cars (if new-car (conj updated-cars new-car) updated-cars)
                          :count (count updated-cars)

                          })
))

;  (assoc state :police {:count (+ 1 count)))))
