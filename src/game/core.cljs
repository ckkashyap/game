(ns game.core
;  (:require [clojure.browser.repl :as repl])
  (:require [game.createjs :as createjs])
)

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

(defn timerFunc [state]
  (let
      [
       x     (:x state)
       ]
  (println x)
  (println "HELLO")
  (assoc state :x (+ x 1))))

(defn ^:export init []
  (let [
        stage (createjs/newStage "demoCanvas")
        c (createjs/drawCircle 0 5 50 "Red")
        _ (set! (.-x c) 100)
        _ (set! (.-y c) 100)
        _ (.addChild stage c)
        _ (.update stage)

        ]
    (def state {:stage stage :x 0})
    (.addEventListener (.-Ticker js/createjs) "tick" (fn [] (set! state (timerFunc state))))
    ))



(println "Hello world!")



;(set! (.-onload js/window) init)
