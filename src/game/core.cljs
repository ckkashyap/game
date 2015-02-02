(ns game.core
  (:require [clojure.browser.repl :as repl]))

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)


(defn ^:export init []
  (let [
        s (new  js/createjs.Stage "demoCanvas")
        c (new js/createjs.Shape)
        a1 (.drawCircle (.beginFill (.. c -graphics) "Green") 0 5 50)
        a2 (set! (.-x c) 100)
        a3 (set! (.-y c) 100)
        a4 (.addChild s c)
        a5 (.update s)
        ]
  (js/alert "AAA")))



(println "Hello world!")



;(set! (.-onload js/window) init)
