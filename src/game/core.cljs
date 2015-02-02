(ns game.core
;  (:require [clojure.browser.repl :as repl])
  (:require [game.createjs :as createjs])
)

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

(def stage)

(defn ^:export init []
  (let [
        _ (set! stage (new  js/createjs.Stage "demoCanvas"))
        c (new js/createjs.Shape)
        a1 (.drawCircle (.beginFill (.-graphics c) "Blue") 0 5 50)
        a2 (set! (.-x c) 100)
        a3 (set! (.-y c) 100)
        a4 (.addChild stage c)
        a5 (.update stage)
        ]
  (js/alert (createjs/dingo))))



(println "Hello world!")



;(set! (.-onload js/window) init)
