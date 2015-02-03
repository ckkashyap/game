(ns game.gameLoop)


(defn loopFunction [state]
  (let
      [
       circle (:circle state)
       y (.-y circle)
       _ (set! (.-y circle) (if (> y 200)  5 (+ 10 y)))
       ]
  (println y)
  state))
