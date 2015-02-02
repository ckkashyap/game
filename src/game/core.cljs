(ns game.core
;  (:require [clojure.browser.repl :as repl])
  (:require [game.createjs :as createjs])
)

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

(defn timerFunc [state]
  (let
      [
       circle (:circle state)
       y (.-y circle)
       _ (set! (.-y circle) (if (> y 200)  5 (+ 10 y)))
       ]
  (println y)
  state))

(defn ^:export init []
  (let [
        stage (createjs/newStage "demoCanvas")
        c (createjs/drawCircle 100 5 50 "Red")
        _ (.addChild stage c)
        _ (.update stage)

        ]
    (def state {:stage stage :circle c})
    (.addEventListener (.-Ticker js/createjs) "tick"
                       (fn []
                         (set! state (timerFunc state))
                         (.update stage)
                         )
                       )
    ))



(println "Hello world!")



;(set! (.-onload js/window) init)
