(ns game.gameLoop
  (:require
   [game.createjs :as createjs]
  )
)


(defn loopFunction [state]
  (let
      [
       circle (:circle state)
       y (.-y circle)
       c (:counter state)
       _ (set! (.-y circle) (if (> y 200)  5 (+ 10 y)))
       ]
  (println c)
  state))
